package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.finance.repository.AssisAccountTypeRepository;
import cn.com.leadu.fms.data.finance.repository.SubjectAssisAccountRepository;
import cn.com.leadu.fms.finance.service.FinancialSubjectService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialSubjectRepository;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectSaveVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectModifyVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectDeleteVo;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.FinancialSubjectDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectService
 * @Description: 财务科目管理业务实现层
 * @date 2018-06-20
 */
@Service
public class FinancialSubjectServiceImpl implements FinancialSubjectService {

    /**
     * @Fields  : 财务科目管理repository
     */
    @Autowired
    private FinancialSubjectRepository financialSubjectRepository;

    /**
     * @Fields  : 辅助核算类型管理repository
     */
    @Autowired
    private AssisAccountTypeRepository assisAccountTypeRepository;

    @Autowired
    private SubjectAssisAccountRepository subjectAssisAccountRepository;

    /**
     * @Title:
     * @Description: 分页查询财务科目管理
     * @param financialSubjectVo
     * @return PageInfoExtend<FinancialSubject>
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    public PageInfoExtend<FinancialSubjectVo> findFinancialSubjectsByPage(FinancialSubjectVo financialSubjectVo){
        //设置查询条件
        if(StringUtils.isNotTrimBlank(financialSubjectVo.getSubjectCd()))
            financialSubjectVo.setSubjectCd(SqlUtil.likePattern(financialSubjectVo.getSubjectCd()));
        else
            financialSubjectVo.setSubjectCd(null);
        if (StringUtils.isNotTrimBlank(financialSubjectVo.getSubjectName()))
            financialSubjectVo.setSubjectName(SqlUtil.likePattern(financialSubjectVo.getSubjectName()));
        else
            financialSubjectVo.setSubjectName(null);
        PageInfoExtend<FinancialSubjectVo> pageInfo = financialSubjectRepository.selectListVoByPage("selectFinancialSubjectsByPage",financialSubjectVo,financialSubjectVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存财务科目管理
     * @param financialSubjectSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Transactional
    public void saveFinancialSubject(FinancialSubjectSaveVo financialSubjectSaveVo){
        Example example = SqlUtil.newExample(FinancialSubject.class);
        example.createCriteria().andEqualTo("subjectCd",financialSubjectSaveVo.getSubjectCd());
        FinancialSubject financialSubject =   financialSubjectRepository.selectOneByExample(example);
        if(financialSubject != null){
            throw  new FmsServiceException("代码已经存在");
        }
        List<AssisAccountTypeVo> assisAccountTypeVoList = financialSubjectSaveVo.getAssisAccountTypeVos();
        List<SubjectAssisAccount> subjectAssisAccountList = new ArrayList<>();
        for(AssisAccountTypeVo assisAccountTypeVo:assisAccountTypeVoList){
            SubjectAssisAccount subjectAssisAccount = new SubjectAssisAccount();
            subjectAssisAccount.setSubjectCd(financialSubjectSaveVo.getSubjectCd());
            subjectAssisAccount.setAssisAccountType(assisAccountTypeVo.getAssisAccountType());
            //保存辅助核算序号
            subjectAssisAccount.setAssisAccountOrder(assisAccountTypeVo.getAssisAccountIndex());
            subjectAssisAccountList.add(subjectAssisAccount);
        }
        subjectAssisAccountRepository.insertDataList(subjectAssisAccountList);
        financialSubjectRepository.insertData(financialSubjectSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改财务科目管理
     * @param financialSubjectModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Transactional
    public void modifyFinancialSubject(FinancialSubjectModifyVo financialSubjectModifyVo){
        List<AssisAccountTypeVo> assisAccountTypeVoList = financialSubjectModifyVo.getAssisAccountTypeVos();
        List<SubjectAssisAccount> subjectAssisAccountList = new ArrayList<>();   //前台传来数据
        for(AssisAccountTypeVo assisAccountTypeVo:assisAccountTypeVoList){
            SubjectAssisAccount subjectAssisAccount = new SubjectAssisAccount();
            subjectAssisAccount.setAssisAccountType(assisAccountTypeVo.getAssisAccountType());
            subjectAssisAccount.setSubjectCd(financialSubjectModifyVo.getSubjectCd());
            //保存辅助核算序号
            subjectAssisAccount.setAssisAccountOrder(assisAccountTypeVo.getAssisAccountIndex());
            //页面传入数据
            subjectAssisAccountList.add(subjectAssisAccount);
        }
        Example example = SqlUtil.newExample(SubjectAssisAccount.class);
        example.createCriteria().andEqualTo("subjectCd",financialSubjectModifyVo.getSubjectCd());
        List<SubjectAssisAccount> roleMenuGetList = subjectAssisAccountRepository.selectListByExample(example);//原有数据
        List<SubjectAssisAccount> subjectAssisAccountAddList = new ArrayList<>();
        List<SubjectAssisAccount> subjectAssisAccountKeepList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(assisAccountTypeVoList)){
            for(SubjectAssisAccount cstmcon:subjectAssisAccountList){
                //if(ArrayUtils.isNotNullAndLengthNotZero(roleMenuGetList)){
                    for(SubjectAssisAccount con:roleMenuGetList){
                        if(con.getAssisAccountType().equals(cstmcon.getAssisAccountType())){
                            //将原来的科目辅助核算id赋给页面传过来的科目辅助核算id
                            cstmcon.setSubjectAssisAccountId(con.getSubjectAssisAccountId());
                            //保存辅助核算类型相同的原来数据
                            subjectAssisAccountKeepList.add(con);
                            //保存辅助核算类型相同的页面传入数据
                            subjectAssisAccountAddList.add(cstmcon);
                        }
                    }

               // }
            }
            //更新科目辅助核算管理(主要更新原来的与现在传入的辅助核算类型一样的数据的assis_account_order)
            subjectAssisAccountRepository.updateByPrimaryKeySelectiveDataList(subjectAssisAccountAddList);
            //将原来数据库中保存的数据多于现在传入的数据的部分删掉
            roleMenuGetList.removeAll(subjectAssisAccountKeepList);
            if(ArrayUtils.isNotNullAndLengthNotZero(roleMenuGetList)){
                List<String> deleteList = new ArrayList<>();
                for(SubjectAssisAccount subjectAssisAccount:roleMenuGetList){
                    deleteList.add(subjectAssisAccount.getSubjectAssisAccountId());
                }
                subjectAssisAccountRepository.deleteDataList(deleteList,new SubjectAssisAccount());
            }
            //将现在传入的数据多于原来保存的数据插入表中
            subjectAssisAccountList.removeAll(subjectAssisAccountAddList);
            if(ArrayUtils.isNotNullAndLengthNotZero(subjectAssisAccountList)){
                subjectAssisAccountRepository.insertDataList(subjectAssisAccountList);
            }
        }else{
            //如果页面传来数据为空，则更新原来数据(把原来数据全部删掉)
            subjectAssisAccountRepository.deleteExampleData(example,new SubjectAssisAccount());
        }
        financialSubjectRepository.updateByPrimaryKeySelectiveData(financialSubjectModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过subjectId删除财务科目管理
     * @param financialSubjectDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    public void deleteFinancialSubject(FinancialSubjectDeleteVo financialSubjectDeleteVo){
        financialSubjectRepository.deleteData(financialSubjectDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过subjectId集合删除财务科目管理
     * @param financialSubjectDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @Transactional
    public void deleteFinancialSubjectsBySubjectIds(FinancialSubjectDeleteListVo financialSubjectDeleteListVo){
        List<FinancialSubjectVo>  financialSubjectVoList = financialSubjectDeleteListVo.getFinancialSubjectVoList();
        List<String> subjectIds = new ArrayList<>();
        List<String> subjectCds = new ArrayList<>();
        Example example = SqlUtil.newExample(SubjectAssisAccount.class);
        for(FinancialSubjectVo financialSubjectVo: financialSubjectVoList){
            subjectIds.add(financialSubjectVo.getSubjectId());
            subjectCds.add(financialSubjectVo.getSubjectCd());
            example.createCriteria().andIn("subjectCd",subjectCds);
        }
        subjectAssisAccountRepository.deleteExampleData(example,new SubjectAssisAccount());
        financialSubjectRepository.deleteDataList(subjectIds,financialSubjectDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据subjectId获取财务科目管理
     * @param subjectId
     * @return FinancialSubject
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    public FinancialSubjectVo findFinancialSubjectBySubjectId(String subjectId){
        FinancialSubjectVo financialSubjectVo = financialSubjectRepository.selectFinancialSubjectVoByPrimaryKey(subjectId);
        return financialSubjectVo;
    }

}
