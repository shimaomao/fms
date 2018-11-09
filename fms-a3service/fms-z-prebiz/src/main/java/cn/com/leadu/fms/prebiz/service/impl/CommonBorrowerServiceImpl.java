package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CommonBorrowerRepository;
import cn.com.leadu.fms.data.prebiz.repository.CrmPersonRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import cn.com.leadu.fms.pojo.prebiz.vo.commonborrower.CommonBorrowerVo;
import cn.com.leadu.fms.prebiz.service.CommonBorrowerService;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerDeleteVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerModifyVo;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.CommonBorrowerSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerService
 * @Description: 共同借款人业务实现层
 * @date 2018-05-25
 */
@Service
public class CommonBorrowerServiceImpl implements CommonBorrowerService {

    /**
     * @Fields  : 共同借款人repository
     */
    @Autowired
    private CommonBorrowerRepository commonBorrowerRepository;

    @Autowired
    private CrmPersonRepository crmPersonRepository;

    /**
     * @Title:
     * @Description: 分页查询共同借款人
     * @param commonBorrowerVo
     * @return PageInfoExtend<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public PageInfoExtend<CommonBorrower> findCommonBorrowersByPage(CommonBorrowerVo commonBorrowerVo){
        Example example = SqlUtil.newExample(CommonBorrower.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CommonBorrower> pageInfo = commonBorrowerRepository.selectListByExamplePage(example,commonBorrowerVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存共同借款人
     * @param commonBorrowerSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public void saveCommonBorrower(CommonBorrowerSaveVo commonBorrowerSaveVo){
        commonBorrowerRepository.insertData(commonBorrowerSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改共同借款人
     * @param commonBorrowerModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public void modifyCommonBorrower(CommonBorrowerModifyVo commonBorrowerModifyVo){
        commonBorrowerRepository.updateByPrimaryKeySelectiveData(commonBorrowerModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过comBorrowerId删除共同借款人
     * @param commonBorrowerDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public void deleteCommonBorrower(CommonBorrowerDeleteVo commonBorrowerDeleteVo){
        commonBorrowerRepository.deleteData(commonBorrowerDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过comBorrowerId集合删除共同借款人
     * @param commonBorrowerDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public void deleteCommonBorrowersByComBorrowerIds(CommonBorrowerDeleteListVo commonBorrowerDeleteListVo){
        commonBorrowerRepository.deleteDataList(commonBorrowerDeleteListVo.getComBorrowerIds(),commonBorrowerDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据comBorrowerId获取共同借款人
     * @param comBorrowerId
     * @return CommonBorrower
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    public CommonBorrower findCommonBorrowerByComBorrowerId(String comBorrowerId){
        return commonBorrowerRepository.selectByPrimaryKey(comBorrowerId);
    }

    /**
     * @Title:
     * @Description:  批量保存共同借款人
     * @param CommonBorrowerList
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    @Override
    public void saveCommonBorrowerList(List<CommonBorrower> CommonBorrowerList, String applyNo) {
        if(ArrayUtils.isNotNullAndLengthNotZero(CommonBorrowerList)){
            for(CommonBorrower commonBorrower : CommonBorrowerList){
                commonBorrower.setApplyNo(applyNo);
            }
            commonBorrowerRepository.insertDataList(CommonBorrowerList);
        }
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取共同借款人
     * @param applyNo
     * @return List<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    @Override
    public List<CommonBorrower> findCommonBorrowersByApplyNo(String applyNo) {
        Example example  = SqlUtil.newExample(CommonBorrower.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return commonBorrowerRepository.selectListByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据applyNo更新共同借款人
     * @param applyNo
     * @return List<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:15
     */
    @Override
    public void updateCommonBorrowersByApplyNo(List<CommonBorrower> CommonBorrowerList, String applyNo) {
        Example example = SqlUtil.newExample(CommonBorrower.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        List<CommonBorrower>  CstmContactGetList =  commonBorrowerRepository.selectListByExample(example);
        List<CommonBorrower> CstmContactAddList = new ArrayList<>();
        List<CommonBorrower> CstmContactKeepList = new ArrayList<>();
        List<CommonBorrower> CstmContactUpdateList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(CommonBorrowerList)){
            for(CommonBorrower cstmcon:CommonBorrowerList){
                if(cstmcon.getComBorrowerId()==null){
                    cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(ArrayUtils.isNotNullAndLengthNotZero(CstmContactGetList)){
                    for(CommonBorrower con:CstmContactGetList){
                        if(con.getComBorrowerId().equals(cstmcon.getComBorrowerId())){
                            CstmContactKeepList.add(con);
                            CstmContactUpdateList.add(cstmcon);
                        }
                    }
                }
            }
            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
            if(CstmContactGetList.size()>0){
                for(CommonBorrower con: CstmContactGetList){
                    commonBorrowerRepository.deleteData(con);
                }
            }
            commonBorrowerRepository.insertDataList(CstmContactAddList);
            commonBorrowerRepository.updateByPrimaryKeySelectiveDataList(CstmContactUpdateList);
        }else{
            commonBorrowerRepository.deleteExampleData(example,new CommonBorrower());
        }
    }

}
