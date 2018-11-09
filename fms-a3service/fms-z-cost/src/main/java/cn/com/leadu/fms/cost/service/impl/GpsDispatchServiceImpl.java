package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BasSaleVehicleEnums;
import cn.com.leadu.fms.common.constant.enums.cost.GpsSellerTypeEnums;
import cn.com.leadu.fms.common.constant.enums.cost.PaymentStsEnums;
import cn.com.leadu.fms.common.constant.enums.cost.SettleStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.TyGpsResultEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.TyGpsTerminalModelTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.cost.rpc.thirdinterface.TyGpsDispatchRpc;
import cn.com.leadu.fms.cost.service.GpsDispatchService;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchModifyVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.GpsDispatchRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchCarVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchQueryVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchTerminalVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchService
 * @Description: 派单信息业务实现层
 * @date 2018-05-25
 */
@Slf4j
@Service
public class GpsDispatchServiceImpl implements GpsDispatchService {

    /**
     * @Fields  : 派单信息repository
     */
    @Autowired
    private GpsDispatchRepository gpsDispatchRepository;

    /**
     * @Fields  : 天易gps派单
     * @author qiaomengnan
     */
    @Autowired
    private TyGpsDispatchRpc tyGpsDispatchRpc;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description:  查询派单信息一览
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/25 03:51:07
     */
    public PageInfoExtend<GpsDispatchVo> findGpsDispatchVosByPage(GpsDispatchVo gpsDispatchVo){
        //出租人区域
        if(StringUtils.isTrimBlank(gpsDispatchVo.getGroupDistrict()))
            gpsDispatchVo.setGroupDistrict(null);
        else
            gpsDispatchVo.setGroupDistrict(SqlUtil.likePattern(gpsDispatchVo.getGroupDistrict()));
        //gps厂商
        if(StringUtils.isTrimBlank(gpsDispatchVo.getGpsSeller()))
            gpsDispatchVo.setGpsSeller(null);

        //盗抢险投保渠道
        if(StringUtils.isTrimBlank(gpsDispatchVo.getTheftInsuranceType()))
            gpsDispatchVo.setTheftInsuranceType(null);

        //安装状态
        if(StringUtils.isTrimBlank(gpsDispatchVo.getInstallStatus()))
            gpsDispatchVo.setInstallStatus(null);
        //设置查询参数
        setSelectParams(gpsDispatchVo);


        //获取合同取消的code 取消
        String contStatue = BizStatusEnums.CONTRACT_CANCEL.getType();

        //获取二手车的code 二手车
        String vehicleType = BasSaleVehicleEnums.VEHICLE_SEC.getType();

        //获取业务类型code  回租赁
        String licenseAttr = LicenseAttrEnums.LEASE_BACK.getType();

        gpsDispatchVo.setContType(contStatue);
        gpsDispatchVo.setVehicleType(vehicleType);
        gpsDispatchVo.setLicenseType(licenseAttr);
        return gpsDispatchRepository.selectListVoByPage("selectGpsDispatchVosByPage",gpsDispatchVo,gpsDispatchVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 设置查询参数
     * @param: gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/18 0018 22:18
     */
    private void setSelectParams(GpsDispatchVo gpsDispatchVo){
        //个人申请类型
        gpsDispatchVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        //gps融资项
        gpsDispatchVo.setFinItemGps(FinItemEnums.GPS.getCode());
        //合同还款状态设置为未结清
        gpsDispatchVo.setPaymentSts(PaymentStsEnums.UNCLEARED.getType());
        //申请编号查询
        if(StringUtils.isNotTrimBlank(gpsDispatchVo.getApplyNo()))
            gpsDispatchVo.setApplyNo(SqlUtil.likePattern(gpsDispatchVo.getApplyNo()));
        else
            gpsDispatchVo.setApplyNo(null);
        //合同号查询
        if(StringUtils.isNotTrimBlank(gpsDispatchVo.getContNo()))
            gpsDispatchVo.setContNo(SqlUtil.likePattern(gpsDispatchVo.getContNo()));
        else
            gpsDispatchVo.setContNo(null);
        //承租人查询
        if(StringUtils.isNotTrimBlank(gpsDispatchVo.getLessee()))
            gpsDispatchVo.setLessee(SqlUtil.likePattern(gpsDispatchVo.getLessee()));
        else
            gpsDispatchVo.setLessee(null);
        //车架号查询
        if(StringUtils.isNotTrimBlank(gpsDispatchVo.getVinNo()))
            gpsDispatchVo.setVinNo(SqlUtil.likePattern(gpsDispatchVo.getVinNo()));
        else
            gpsDispatchVo.setVinNo(null);
    }

    /**
     * @Title:
     * @Description: 暂存派单信息
     * @param: gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/18 0018 16:23
     */
    public void storageGpsDispatch(GpsDispatchVo gpsDispatchVo){
        GpsDispatch gpsDispatch = gpsDispatchVo.getEntity();
        if(StringUtils.isTrimBlank(gpsDispatch.getDispatchId())){
            gpsDispatchRepository.insertData(gpsDispatch);
        }else{
            gpsDispatchRepository.updateByPrimaryKeySelectiveData(gpsDispatch);
        }
    }

    /**
     * @Title:
     * @Description: 保存派单信息
     * @param gpsDispatchSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Transactional
    public void saveGpsDispatch(GpsDispatchSaveVo gpsDispatchSaveVo){
        GpsDispatch gpsDispatch = gpsDispatchSaveVo.getEntity();
        //校验派单记录
        checkGpsDispatch(gpsDispatch.getContNo());
        //检查金额是否正确
        checkTotalCost(gpsDispatch);
        //是否是天易需要派单
        String orderNo = tyGpsDispatch(gpsDispatch);
        //保存天易接口返回的工单号
        gpsDispatch.setTyOrderNo(orderNo);
        //检查天易的值
        checkTyValue(gpsDispatch);
        gpsDispatchRepository.insertData(gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 修改派单信息
     * @param gpsDispatchModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Transactional
    public void modifyGpsDispatch(GpsDispatchModifyVo gpsDispatchModifyVo){
        GpsDispatch gpsDispatch = gpsDispatchModifyVo.getEntity();
        //校验派单记录
        checkGpsDispatch(gpsDispatch.getContNo());
        //检查金额是否正确
        checkTotalCost(gpsDispatch);
        if(StringUtils.isTrimBlank(gpsDispatch.getTyOrderNo())) {
            //天易工单号不存在的情况,判断是否需要调用天易接口
            String tyOrderNo = tyGpsDispatch(gpsDispatch);
            gpsDispatch.setTyOrderNo(tyOrderNo);
        } else {
            //天易工单号已经存在,防止gps厂商和派单状态被更新
            gpsDispatch.setGpsSeller(null);
            gpsDispatch.setDispatchFlag(null);
        }
        checkTyValue(gpsDispatch);
        gpsDispatchRepository.updateByPrimaryKeySelectiveData(gpsDispatch,true);
    }

    /**
     * @Title:
     * @Description: 校验是否存在该条派单记录
     * @param: contNo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/12 0012 14:58
     */
    private void checkGpsDispatch(String contNo){
        GpsDispatchVo gpsDispatchVo = findGpsDispatchDetailByContNo(contNo);
        if(findGpsDispatchDetailByContNo(contNo) == null)
            throw new FmsServiceException(contNo + "派单记录不存在，派单失败");
        else if(SettleStatusEnums.MONTHLY_KNOT.getStatus().equals(gpsDispatchVo.getSettleStatus()))
            throw new FmsServiceException("该单已经月结,不能再次进行派单操作");
    }

    /**
     * @Title:
     * @Description: 校验费用合计
     * @param:  gpsDispatch
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/9 0009 13:33
     */
    private void checkTotalCost(GpsDispatch gpsDispatch){
        BigDecimal totalCost = BigDecimalUtils.adds(gpsDispatch.getGpsWiredCost(),gpsDispatch.getGpsWirelessCost(),gpsDispatch.getInstallCost(),gpsDispatch.getReformCost());
        if(totalCost.compareTo(gpsDispatch.getTotalCost()) != 0)
            throw new FmsServiceException("费用合计计算有误");
    }

    /**
     * @Title:
     * @Description:   如果是天易的接口,安装信息不可以被程序赋值,需要由接口赋值
     * @param gpsDispatch
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/05 07:33:37
     */
    private void checkTyValue(GpsDispatch gpsDispatch){
        if(StringUtils.isNotTrimBlank(gpsDispatch.getTyOrderNo())){
            //如果是天易的接口,安装信息不可以被程序赋值,需要由接口赋值
            gpsDispatch.setWiredDeviceNo(null);
            gpsDispatch.setWirelessDeviceNo(null);
            gpsDispatch.setInstallUser(null);
            gpsDispatch.setInstallUserMobileNo(null);
            gpsDispatch.setInstallStatus(null);
        }
    }

    /**
     * @Title:
     * @Description:   天易派单
     * @param gpsDispatch
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 06:29:05
     */
    private String tyGpsDispatch(GpsDispatch gpsDispatch){
        if(gpsDispatch == null)
            throw new FmsServiceException("派单信息不能为空");
        //gps厂商是天易,并且确认派单的情况下,进行天易第三方接口派单
        if(GpsSellerTypeEnums.TY.getType().equals(gpsDispatch.getGpsSeller())
              && YesNoFlagEnums.YES.getType().equals(gpsDispatch.getDispatchFlag())){
            //获取车架号
            GpsDispatchVo gpsDispatchVo = findGpsDispatchDetailByContNo(gpsDispatch.getContNo());
            if(gpsDispatchVo == null || StringUtils.isTrimBlank(gpsDispatchVo.getVinNo()))
                throw new FmsServiceException("派单失败,未获取到车架号信息");
            TyGpsDispatchVo tyGpsDispatchVo = new TyGpsDispatchVo();
            //申请编号
            tyGpsDispatchVo.setApplyNo(gpsDispatch.getContNo());
            //现场联系人姓名
            tyGpsDispatchVo.setContactName(gpsDispatch.getAbutmentUser());
            //现场联系人电话
            tyGpsDispatchVo.setContactPhone(gpsDispatch.getAbutmentUserMobileNo());
            //派工联系人姓名
            tyGpsDispatchVo.setPiccontactName(gpsDispatch.getDispatchWorkerUser());
            //派工联系人电话
            tyGpsDispatchVo.setPiccontactPhone(gpsDispatch.getDispatchWorkerUserMobileNo());
            //上门时间
            tyGpsDispatchVo.setInstalltime(DateUtils.dateToStr(gpsDispatch.getInstallDate(),DateUtils.formatStr_yyyyMMddHHmmss));
            //拉车账号,固定,在第三方接口处统一赋值
            tyGpsDispatchVo.setCarAccount("");
            //上门地址
            tyGpsDispatchVo.setAddressCode(gpsDispatch.getInstallCounty());
            //详细地址
            tyGpsDispatchVo.setAddressDetail(gpsDispatch.getInstallAddress());
            //备注,暂设为空
            tyGpsDispatchVo.setRemark("");
            //车辆信息集合
            List<TyGpsDispatchCarVo> car = new ArrayList<>();
            //车辆信息
            TyGpsDispatchCarVo tyGpsDispatchCarVo = new TyGpsDispatchCarVo();
            //车主姓名
            tyGpsDispatchCarVo.setOwnerName("");
            //身份证号
            tyGpsDispatchCarVo.setOwnerCard("");
            //车型
            tyGpsDispatchCarVo.setCarBrand("");
            //车牌
            tyGpsDispatchCarVo.setCarNo("");
            //车架
            tyGpsDispatchCarVo.setCarVin(gpsDispatchVo.getVinNo());
            //有线设备年期
            tyGpsDispatchCarVo.setWiredPeriod(StringUtils.getValue(gpsDispatch.getGpsWiredYears()));
            //有线设备数量
            tyGpsDispatchCarVo.setWiredNum(StringUtils.getValue(gpsDispatch.getGpsWiredNum()));
            //无线设备年期
            tyGpsDispatchCarVo.setWirelessPeriod(StringUtils.getValue(gpsDispatch.getGpsWirelessYears()));
            //无线设备数量
            tyGpsDispatchCarVo.setWirelessNum(StringUtils.getValue(gpsDispatch.getGpsWirelessNum()));
            car.add(tyGpsDispatchCarVo);
            tyGpsDispatchVo.setCar(car);
            try {
                TyGpsDispatchVo result = ResponseEntityUtils.getRestResponseData(tyGpsDispatchRpc.sendGpsDispatch(tyGpsDispatchVo));
                if(result == null)
                    throw new FmsServiceException("天易派单失败,原因:接口返回正常,未收到内容");
                if(TyGpsResultEnums.SUCCESS.getResult().equals(result.getResult())) {
                    if(StringUtils.isTrimBlank(result.getOrderNo()))
                        throw new FmsServiceException("天易派单失败,原因:接口返回正常,未收到工单号");
                    return result.getOrderNo();
                } else{
                    throw new FmsServiceException("天易派单失败,原因:" + result.getMessage());
                }
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("天易派单失败,原因:天易接口调用出错");
            }
        }
        return null;
    }


    /**
     * @Title:
     * @Description:  根据dispatchId获取派单信息
     * @param dispatchId
     * @return GpsDispatch
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public GpsDispatch findGpsDispatchByDispatchId(String dispatchId){
        return gpsDispatchRepository.selectByPrimaryKey(dispatchId);
    }

    /**
     * @param gpsDispatchMonthlyVo
     * @Description: 查询gps月结一览信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/17 20:26
     */
    @Override
    public PageInfoExtend<GpsDispatchMonthlyVo> findGpsDispatchMonthlysVosListByPage(GpsDispatchMonthlyVo gpsDispatchMonthlyVo) {
        gpsDispatchMonthlyVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());//个人标识

        //月结任务号
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getMonthlySettlementNo()))
            gpsDispatchMonthlyVo.setMonthlySettlementNo(null);
        else
            gpsDispatchMonthlyVo.setMonthlySettlementNo(SqlUtil.likePattern(gpsDispatchMonthlyVo.getMonthlySettlementNo()));

        //月结状态
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getMonthlySts()))
            gpsDispatchMonthlyVo.setMonthlySts(null);
        else
            gpsDispatchMonthlyVo.setMonthlySts(gpsDispatchMonthlyVo.getMonthlySts());

        //出租人区域
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getGroupDistrict()))
            gpsDispatchMonthlyVo.setGroupDistrict(null);
        else
            gpsDispatchMonthlyVo.setGroupDistrict(SqlUtil.likePattern(gpsDispatchMonthlyVo.getGroupDistrict()));

        //车架号
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getVinNo()))
            gpsDispatchMonthlyVo.setVinNo(null);
        else
            gpsDispatchMonthlyVo.setVinNo(SqlUtil.likePattern(gpsDispatchMonthlyVo.getVinNo()));

        //起始时间
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getExpectInstallStartDateStr()))
            gpsDispatchMonthlyVo.setExpectInstallStartDateStr(null);
        else
            gpsDispatchMonthlyVo.setExpectInstallStartDateStr(gpsDispatchMonthlyVo.getExpectInstallStartDateStr());

        //结束时间
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getExpectInstallEndDateStr()))
            gpsDispatchMonthlyVo.setExpectInstallEndDateStr(null);
        else
            gpsDispatchMonthlyVo.setExpectInstallEndDateStr(gpsDispatchMonthlyVo.getExpectInstallEndDateStr());

        //承租人
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getLessee()))
            gpsDispatchMonthlyVo.setLessee(null);
        else
            gpsDispatchMonthlyVo.setLessee(SqlUtil.likePattern(gpsDispatchMonthlyVo.getLessee()));

        //gps厂商
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getGpsSeller()))
            gpsDispatchMonthlyVo.setGpsSeller(null);

        //盗抢险投保渠道
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getTheftInsuranceType()))
            gpsDispatchMonthlyVo.setTheftInsuranceType(null);
        return gpsDispatchRepository.selectListVoByPage("selectGpsDispatchMonthlysVosListByPage",gpsDispatchMonthlyVo,gpsDispatchMonthlyVo.getPageQuery());
    }


    /**
     * @param gpsDispatchMonthlyVo
     * @Description: 查询派单月结信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/28 15:13
     */
    @Override
    public PageInfoExtend<GpsDispatchMonthlyVo> findGpsDispatchMonthlysVos(GpsDispatchMonthlyVo gpsDispatchMonthlyVo) {
        gpsDispatchMonthlyVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());//个人标识

        if(gpsDispatchMonthlyVo.getDispatchIds() == null || gpsDispatchMonthlyVo.getDispatchIds().size() == 0){
            gpsDispatchMonthlyVo.setDispatchIds(null);
        }
        //月结任务号
        if(StringUtils.isTrimBlank(gpsDispatchMonthlyVo.getMonthlySettlementNo()))
            gpsDispatchMonthlyVo.setMonthlySettlementNo(null);
        else
            gpsDispatchMonthlyVo.setMonthlySettlementNo(gpsDispatchMonthlyVo.getMonthlySettlementNo());
        return gpsDispatchRepository.selectListVoByPage("selectGpsDispatchMonthlysVosByPage",gpsDispatchMonthlyVo,gpsDispatchMonthlyVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description:   根据合同号查询派单信息详情
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    @Override
    public GpsDispatchVo findGpsDispatchDetailByContNo(String contNo){
        GpsDispatchVo gpsDispatchVo = null;
        if(StringUtils.isNotTrimBlank(contNo)) {
            gpsDispatchVo = new GpsDispatchVo();
            gpsDispatchVo.setContNo(contNo);
            //个人申请类型
            gpsDispatchVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
            //gps融资项
            gpsDispatchVo.setFinItemGps(FinItemEnums.GPS.getCode());
            gpsDispatchVo = gpsDispatchRepository.selectGpsDispatchVo(gpsDispatchVo);
        }
        return gpsDispatchVo;
    }

    /**
     * @Title:
     * @Description:   查询天易派单状态
     * @param dispatchId
     * @param tyOrderNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/05 08:33:45
     */
    public GpsDispatch findTyGpsDisPatch(String dispatchId,String tyOrderNo){
        if(StringUtils.isTrimBlank(dispatchId))
            throw new FmsServiceException("未获取到派单记录id");
        if(StringUtils.isTrimBlank(tyOrderNo))
            throw new FmsServiceException("未获取到天易工单号");
        try {
            TyGpsDispatchQueryVo result = ResponseEntityUtils.getRestResponseData(tyGpsDispatchRpc.findGpsDisPatch(tyOrderNo));
            if(result == null)
                throw new FmsServiceException("查询天易派单状态失败,原因:接口返回正常,未收到内容");
            if(TyGpsResultEnums.SUCCESS.getResult().equals(result.getResult())){
                if(StringUtils.isTrimBlank(result.getStatus())){
                    throw new FmsServiceException("查询天易派单状态失败,原因:接口返回正常,未获取到派单状态");
                }

                List<TyGpsDispatchTerminalVo> terminalVos = result.getTerminal();
//                if(ArrayUtils.isNullOrLengthZero(terminalVos)) {
//                    String statusName = TyGpsResultEnums.status.getStatusName(result.getStatus());
//                    statusName = statusName == null ? result.getStatus() : statusName;
//                    throw new FmsServiceException("天易派单状态:" + statusName + "暂未获取到设备信息");
//                }

                GpsDispatch gpsDispatch = findGpsDispatchByDispatchId(dispatchId);
                if(gpsDispatch == null)
                    throw new FmsServiceException("未获取到派单记录");
                //获取车架号
                GpsDispatchVo gpsDispatchVo = findGpsDispatchDetailByContNo(gpsDispatch.getContNo());
                if(gpsDispatchVo == null)
                    throw new FmsServiceException("获取派单记录对应的车架号失败");
                //有线设备号
                String wiredDeviceNo = null;
                //无线设备号
                String wirelessDeviceNo = null;
                //安装状态
                String installStatus = result.getStatus();
                //获取设备号
                if(ArrayUtils.isNotNullAndLengthNotZero(terminalVos)){
                    for(TyGpsDispatchTerminalVo terminalVo : terminalVos){
                        if(gpsDispatchVo.getVinNo().equals(terminalVo.getCarVin())){
                            if(TyGpsTerminalModelTypeEnums.WIRED.getType().equals(terminalVo.getModel()))
                                wiredDeviceNo = terminalVo.getImei();
                            else if(TyGpsTerminalModelTypeEnums.WIRELESS.getType().equals(terminalVo.getModel()))
                                wirelessDeviceNo = terminalVo.getImei();
                        }
                    }
                }
                if(StringUtils.notEquals(gpsDispatch.getWiredDeviceNo(), wiredDeviceNo)
                        || StringUtils.notEquals(gpsDispatch.getWirelessDeviceNo(), wirelessDeviceNo)
                        || StringUtils.notEquals(gpsDispatch.getInstallStatus(),installStatus)){
                    gpsDispatch.setWiredDeviceNo(wiredDeviceNo);
                    gpsDispatch.setWirelessDeviceNo(wirelessDeviceNo);
                    gpsDispatch.setInstallStatus(installStatus);
                    gpsDispatchRepository.updateByPrimaryKeySelectiveData(gpsDispatch,true);
                }
                return gpsDispatch;
            } else
                throw new FmsServiceException("查询天易派单状态失败,原因:" + result.getMessage());
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("查询天易派单状态失败,原因:天易接口调用出错");
        }
    }

}
