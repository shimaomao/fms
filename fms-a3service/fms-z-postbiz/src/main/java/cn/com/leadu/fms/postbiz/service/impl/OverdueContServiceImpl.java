package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.cost.OverdueContStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueContRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.postbiz.rpc.cost.ContPrepaymentRpc;
import cn.com.leadu.fms.postbiz.service.OverdueContService;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContSaveVo;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author lijunjun
 * @ClassName: OverdueContService
 * @Description: 逾期合同信息业务实现层
 * @date 2018-05-16
 */
@Log4j
@Service
public class OverdueContServiceImpl implements OverdueContService {

    /**
     * @Fields : 逾期合同信息repository
     */
    @Autowired
    private OverdueContRepository overdueContRepository;
    /**
     * @Fields :提前还款Rpc
     */
    @Autowired
    private ContPrepaymentRpc contPrepaymentRpc;

    /**
     * @param overdueContVo
     * @return PageInfoExtend<OverdueCont>
     * @throws
     * @Title:
     * @Description: 分页查询逾期合同信息
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public PageInfoExtend<OverdueContVo> findOverdueContsByPage(OverdueContVo overdueContVo) {
        //取未逾期的数据
        overdueContVo.setOverdueFlag(OverdueContStatusEnums.NO.getType());
        return overdueContRepository.selectListVoByPage("selectOverdueContsByPage", overdueContVo, overdueContVo.getPageQuery());
    }

    /**
     * @param overdueContSaveVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 保存逾期合同信息
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public void saveOverdueCont(OverdueContSaveVo overdueContSaveVo) {
        overdueContRepository.insertData(overdueContSaveVo.getEntity());
    }

    /**
     * @param overdueContModifyVo
     * @return
     * @throws
     * @Title:
     * @Description: 修改逾期合同信息
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public void modifyOverdueCont(OverdueContModifyVo overdueContModifyVo) {
        overdueContRepository.updateByPrimaryKeySelectiveData(overdueContModifyVo.getEntity());
    }

    /**
     * @param overdueContDeleteVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过overdueContId删除逾期合同信息
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public void deleteOverdueCont(OverdueContDeleteVo overdueContDeleteVo) {
        overdueContRepository.deleteData(overdueContDeleteVo.getEntity());
    }

    /**
     * @param overdueContDeleteListVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过overdueContId集合删除逾期合同信息
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public void deleteOverdueContsByOverdueContIds(OverdueContDeleteListVo overdueContDeleteListVo) {
        overdueContRepository.deleteDataList(overdueContDeleteListVo.getOverdueContIds(), overdueContDeleteListVo.getEntity());
    }

    /**
     * @param contNo
     * @return
     * @throws
     * @Title:
     * @Description: 通过contNo取得逾期合同信息
     * @author yanfengbo
     * @date 2018-5-16 14:32:22
     */
    @Override
    public OverdueContVo findOverdueContByContNo(String contNo){
        return overdueContRepository.selectOverdueContByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期合同vo数据
     * @param overdueContVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    public PageInfoExtend<OverdueContVo> findOverdueContVosByPage(OverdueContVo overdueContVo){
        setSelectParams(overdueContVo);
        return overdueContRepository.selectListVoByPage("selectOverdueContVos", overdueContVo, overdueContVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 分页查询逾期合同vo数据参数设置
     * @param overdueContVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    private void setSelectParams(OverdueContVo overdueContVo){
        //设置申请类型
        overdueContVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        if(StringUtils.isNotTrimBlank(overdueContVo.getApplyNo()))
            overdueContVo.setApplyNo(SqlUtil.likePattern(overdueContVo.getApplyNo()));
        else
            overdueContVo.setApplyNo(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getContNo()))
            overdueContVo.setContNo(SqlUtil.likePattern(overdueContVo.getContNo()));
        else
            overdueContVo.setContNo(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getCstmName()))
            overdueContVo.setCstmName(SqlUtil.likePattern(overdueContVo.getCstmName()));
        else
            overdueContVo.setCstmName(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getMobileNo()))
            overdueContVo.setMobileNo(SqlUtil.likePattern(overdueContVo.getMobileNo()));
        else
            overdueContVo.setMobileNo(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getVinNo()))
            overdueContVo.setVinNo(SqlUtil.likePattern(overdueContVo.getVinNo()));
        else
            overdueContVo.setVinNo(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getVehicleLicenseNo()))
            overdueContVo.setVehicleLicenseNo(SqlUtil.likePattern(overdueContVo.getVehicleLicenseNo()));
        else
            overdueContVo.setVehicleLicenseNo(null);
        if(StringUtils.isNotTrimBlank(overdueContVo.getEngineNo()))
            overdueContVo.setEngineNo(SqlUtil.likePattern(overdueContVo.getEngineNo()));
        else
            overdueContVo.setEngineNo(null);
        // 当前是否逾期查询处理
        if (StringUtils.isTrimBlank(overdueContVo.getOverdueFlag()))
            overdueContVo.setOverdueFlag(null);
    }

    /**
     * @Title:
     * @Description:   根据合同id获取逾期合同号
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/17 04:14:21
     */
    public OverdueContVo findOverdueContVoByContNo(String contNo){
        if(StringUtils.isNotTrimBlank(contNo)){
            OverdueContVo overdueContVo = new OverdueContVo();
            overdueContVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
            overdueContVo.setOverdueContId(contNo);   //逾期合同id
            OverdueContVo overdueContVo1 = overdueContRepository.selectOverdueContVoByContNo(overdueContVo);
            //提前还款试算金额
            ContPrepaymentVo contPrepaymentVo = null;
            try {
                contPrepaymentVo = ResponseEntityUtils.getRestResponseData(contPrepaymentRpc.findContPrepaymentWithDetailByContNo(overdueContVo1.getContNo()));
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("获取提前还款试算金额失败");
            }
            if(contPrepaymentVo != null){
                overdueContVo1.setTrialAmount(contPrepaymentVo.getPrepayTrialAmount());
            }else{
                overdueContVo1.setTrialAmount(BigDecimal.ZERO);
            }
            return overdueContVo1;
        }
        return null;
    }

}
