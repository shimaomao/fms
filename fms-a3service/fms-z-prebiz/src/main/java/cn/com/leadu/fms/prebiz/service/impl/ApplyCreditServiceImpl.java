package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.prebiz.service.ApplyCreditService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyCreditRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCredit;
import cn.com.leadu.fms.pojo.prebiz.vo.applycredit.ApplyCreditVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditSaveVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditModifyVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditDeleteVo;
import cn.com.leadu.fms.prebiz.validator.applycredit.vo.ApplyCreditDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: ApplyCreditService
 * @Description: 征信信息业务实现层
 * @date 2018-05-15
 */
@Service
public class ApplyCreditServiceImpl implements ApplyCreditService {

    /**
     * @Fields  : 征信信息repository
     */
    @Autowired
    private ApplyCreditRepository applyCreditRepository;

    /**
     * @Title:
     * @Description: 分页查询征信信息
     * @param applyCreditVo
     * @return PageInfoExtend<ApplyCredit>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public PageInfoExtend<ApplyCredit> findApplyCreditsByPage(ApplyCreditVo applyCreditVo){
        Example example = SqlUtil.newExample(ApplyCredit.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ApplyCredit> pageInfo = applyCreditRepository.selectListByExamplePage(example,applyCreditVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存征信信息
     * @param applyCreditSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public void saveApplyCredit(ApplyCreditSaveVo applyCreditSaveVo){
        applyCreditRepository.insertData(applyCreditSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改征信信息
     * @param applyCreditModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public void modifyApplyCredit(ApplyCreditModifyVo applyCreditModifyVo){
        applyCreditRepository.updateByPrimaryKeySelectiveData(applyCreditModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过applyCreditId删除征信信息
     * @param applyCreditDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public void deleteApplyCredit(ApplyCreditDeleteVo applyCreditDeleteVo){
        applyCreditRepository.deleteData(applyCreditDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过applyCreditId集合删除征信信息
     * @param applyCreditDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public void deleteApplyCreditsByApplyCreditIds(ApplyCreditDeleteListVo applyCreditDeleteListVo){
        applyCreditRepository.deleteDataList(applyCreditDeleteListVo.getApplyCreditIds(),applyCreditDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据applyCreditId获取征信信息
     * @param applyCreditId
     * @return ApplyCredit
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public ApplyCredit findApplyCreditByApplyCreditId(String applyCreditId){
        return applyCreditRepository.selectByPrimaryKey(applyCreditId);
    }

    /**
     * @Title:
     * @Description: 保存征信信息
     * @param applyNo
     * @param inputExcelPath
     * @param resultTxtPath
     * @param creditGrade
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-15 17:27:00
     */
    public void saveApplyCredit(String applyNo,String inputExcelPath,String resultTxtPath,String creditGrade){
        ApplyCredit applyCredit = new ApplyCredit();
        applyCredit.setApplyNo(applyNo);
        applyCredit.setInputExcelPath(inputExcelPath);
        applyCredit.setResultTxtPath(resultTxtPath);
        applyCredit.setCreditGrade(creditGrade);
        applyCreditRepository.insertData(applyCredit);
    }

    /**
     * @Title:
     * @Description:   根据申请编号 获取申请模型对象
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/15 06:15:01
     */
    public ApplyCredit findApplyCreditByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(ApplyCredit.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return applyCreditRepository.selectOneByExample(example);
    }

}
