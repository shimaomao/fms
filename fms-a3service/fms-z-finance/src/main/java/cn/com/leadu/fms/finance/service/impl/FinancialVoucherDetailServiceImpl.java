package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonFinancialVoucherDetailService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.finance.repository.AssisAccountTypeRepository;
import cn.com.leadu.fms.data.finance.repository.SubjectAssisAccountRepository;
import cn.com.leadu.fms.finance.service.FinancialVoucherDetailService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDetailRepository;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailSaveVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailModifyVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailDeleteVo;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.FinancialVoucherDetailDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailService
 * @Description: 凭证类型明细管理业务实现层
 * @date 2018-06-20
 */
@Service
public class FinancialVoucherDetailServiceImpl implements FinancialVoucherDetailService ,CommonFinancialVoucherDetailService {

    /**
     * @Fields  : 凭证类型明细管理repository
     */
    @Autowired
    private FinancialVoucherDetailRepository financialVoucherDetailRepository;

    @Autowired
    private SubjectAssisAccountRepository subjectAssisAccountRepository;

    @Autowired
    private AssisAccountTypeRepository assisAccountTypeRepository;

    /**
     * @Title:
     * @Description: 分页查询凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return PageInfoExtend<FinancialVoucherDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public PageInfoExtend<FinancialVoucherDetailVo> findFinancialVoucherDetailsByPage(FinancialVoucherDetailVo financialVoucherDetailVo){

        if(StringUtils.isNotTrimBlank(financialVoucherDetailVo.getVoucherType()))
            financialVoucherDetailVo.setVoucherType(SqlUtil.likePattern(financialVoucherDetailVo.getVoucherType()));
        else
            financialVoucherDetailVo.setVoucherType(null);
        PageInfoExtend<FinancialVoucherDetailVo> pageInfo = financialVoucherDetailRepository.selectListVoByPage("selectFinancialVoucherDetailVosByPage",financialVoucherDetailVo,financialVoucherDetailVo.getPageQuery());

        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存凭证类型明细管理
     * @param financialVoucherDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public void saveFinancialVoucherDetail(FinancialVoucherDetailSaveVo financialVoucherDetailSaveVo){
        financialVoucherDetailRepository.insertData(financialVoucherDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改凭证类型明细管理
     * @param financialVoucherDetailModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public void modifyFinancialVoucherDetail(FinancialVoucherDetailModifyVo financialVoucherDetailModifyVo){
        financialVoucherDetailRepository.updateByPrimaryKeySelectiveData(financialVoucherDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过voucherDetailId删除凭证类型明细管理
     * @param financialVoucherDetailDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public void deleteFinancialVoucherDetail(FinancialVoucherDetailDeleteVo financialVoucherDetailDeleteVo){
        financialVoucherDetailRepository.deleteData(financialVoucherDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过voucherDetailId集合删除凭证类型明细管理
     * @param financialVoucherDetailDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public void deleteFinancialVoucherDetailsByVoucherDetailIds(FinancialVoucherDetailDeleteListVo financialVoucherDetailDeleteListVo){
        financialVoucherDetailRepository.deleteDataList(financialVoucherDetailDeleteListVo.getVoucherDetailIds(),financialVoucherDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据voucherDetailId获取凭证类型明细管理
     * @param voucherDetailId
     * @return FinancialVoucherDetail
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    public FinancialVoucherDetailVo findFinancialVoucherDetailByVoucherDetailId(String voucherDetailId){
        FinancialVoucherDetail  financialVoucherDetail =  financialVoucherDetailRepository.selectByPrimaryKey(voucherDetailId);
        FinancialVoucherDetailVo financialVoucherDetailVo = EntityUtils.getEntity(financialVoucherDetail,new FinancialVoucherDetailVo());
        Example example = SqlUtil.newExample(SubjectAssisAccount.class);
        example.createCriteria().andEqualTo("subjectCd",financialVoucherDetail.getSubjectCd());
        List<SubjectAssisAccount> subjectAssisAccounts =  subjectAssisAccountRepository.selectListByExample(example);
        List<String> assisTypes = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(subjectAssisAccounts)){
            for(SubjectAssisAccount subjectAssisAccount:subjectAssisAccounts){
                assisTypes.add(subjectAssisAccount.getAssisAccountType());
            }
            Example example1 = SqlUtil.newExample(AssisAccountType.class);
            example1.createCriteria().andIn("assisAccountType",assisTypes);
             if(ArrayUtils.isNotNullAndLengthNotZero(assisAccountTypeRepository.selectListByExample(example1)))
                 financialVoucherDetailVo.setAssisAccountTypes(assisAccountTypeRepository.selectListByExample(example1));
        }
        return financialVoucherDetailVo;
    }

    /**
     * @Title:
     * @Description:   根据凭证类型取得凭证类型明细列表
     * @param voucherType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:03:15
     */
    public List<FinancialVoucherDetail> findFinancialVoucherDetailsByVoucherType(String voucherType){
        Example example = SqlUtil.newExample(FinancialVoucherDetail.class);
        example.createCriteria().andEqualTo("voucherType",voucherType);
        List<FinancialVoucherDetail>  financialVoucherDetails = financialVoucherDetailRepository.selectListByExample(example);
        return financialVoucherDetails;
    }

}
