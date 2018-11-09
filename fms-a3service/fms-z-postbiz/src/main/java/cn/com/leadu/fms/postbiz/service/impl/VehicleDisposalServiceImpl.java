package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.DisposalStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.VehicleDisposalStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.ContPrepaymentRepository;
import cn.com.leadu.fms.data.postbiz.repository.DepositChangeTaskRepository;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.DisposalContVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CapitalAssetsTaskService;
import cn.com.leadu.fms.postbiz.service.DepositChangeTaskService;
import cn.com.leadu.fms.postbiz.service.RetrieveCarsTaskService;
import cn.com.leadu.fms.postbiz.service.VehicleDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalService
 * @Description: 车辆处置业务实现层
 */
@Service
public class VehicleDisposalServiceImpl implements VehicleDisposalService {

    /**
     * @Fields  : 车辆处置repository
     */
    @Autowired
    private VehicleDisposalRepository vehicleDisposalRepository;

    /**
     * @Fields  : 收车任务service
     */
    @Autowired
    private RetrieveCarsTaskService retrieveCarsTaskService;

    /**
     * @Fields  : 提前还款repository
     */
    @Autowired
    private ContPrepaymentRepository contPrepaymentRepository;

    /**
     * @Fields  : 增加保证金任务service
     */
    @Autowired
    private DepositChangeTaskService depositChangeTaskService;

    /**
     * @Fields  : 转固定资产任务service
     */
    @Autowired
    private CapitalAssetsTaskService capitalAssetsTaskService;

    /**
     * @Fields  : 保证金变更repository
     */
    @Autowired
    private DepositChangeTaskRepository depositChangeTaskRepository;

    /**
     * @Fields  : 附件service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询车辆处置
     * @param vehicleDisposalVo
     * @return PageInfoExtend<VehicleDisposalVo>
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:09
     */
    public PageInfoExtend<VehicleDisposalVo> findVehicleDisposalVosByPage(VehicleDisposalVo vehicleDisposalVo){
        // 合同编号
        if (StringUtils.isNotTrimBlank(vehicleDisposalVo.getContNo())) {
            vehicleDisposalVo.setContNo(SqlUtil.likePattern(vehicleDisposalVo.getContNo()));
        } else {
            vehicleDisposalVo.setContNo(null);
        }
        // 车架号
        if (StringUtils.isNotTrimBlank(vehicleDisposalVo.getVinNo())) {
            vehicleDisposalVo.setVinNo(SqlUtil.likePattern(vehicleDisposalVo.getVinNo()));
        } else {
            vehicleDisposalVo.setVinNo(null);
        }
        // 车牌号
        if (StringUtils.isNotTrimBlank(vehicleDisposalVo.getVehicleLicenseNo())) {
            vehicleDisposalVo.setVehicleLicenseNo(SqlUtil.likePattern(vehicleDisposalVo.getVehicleLicenseNo()));
        } else {
            vehicleDisposalVo.setVehicleLicenseNo(null);
        }
        // 承租人
        if (StringUtils.isNotTrimBlank(vehicleDisposalVo.getCstmName())) {
            vehicleDisposalVo.setCstmName(SqlUtil.likePattern(vehicleDisposalVo.getCstmName()));
        } else {
            vehicleDisposalVo.setCstmName(null);
        }
        // 车辆处置方式
        if (StringUtils.isTrimBlank(vehicleDisposalVo.getDisposalStatus())) {
            vehicleDisposalVo.setDisposalStatus(null);
        }
        PageInfoExtend<VehicleDisposalVo> pageInfo = vehicleDisposalRepository.selectListVoByPage("selectVehicleDisposalVosByPage", vehicleDisposalVo,vehicleDisposalVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据vehicleDisposalId获取车辆处置信息Vo
     * @param vehicleDisposalId 车辆处置ID
     * @return VehicleDisposalVo
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public VehicleDisposalVo findVehicleDisposalVoByVehicleDisposalId(String vehicleDisposalId) {
        VehicleDisposalVo vehicleDisposalVo = new VehicleDisposalVo();
        VehicleDisposal vehicleDisposal = vehicleDisposalRepository.selectByPrimaryKey(vehicleDisposalId);
        if (vehicleDisposal != null) {
            vehicleDisposalVo = EntityUtils.getEntity(vehicleDisposal, new VehicleDisposalVo());
            // 根据合同号，获取客户信息
            DisposalContVo disposalContVo = vehicleDisposalRepository.selectDisposalContVoByContNo(vehicleDisposal.getContNo());
            if (disposalContVo != null) {
                vehicleDisposalVo = EntityUtils.getEntity(disposalContVo, vehicleDisposalVo);
            }
            // 根据收车任务号，获取收车任务信息
            setVehicleDisposalVoByRetrieveTask(vehicleDisposalVo, vehicleDisposal.getRecoveryTaskNo());
        }
        return vehicleDisposalVo;
    }

    /**
     * @Title:
     * @Description:  根据处置任务号，获取车辆处置信息Vo
     * @param disposalTaskNo 处置任务号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public VehicleDisposalVo findVehicleDisposalVoByDisposalTaskNo(String disposalTaskNo) {
        VehicleDisposalVo vehicleDisposalVo = new VehicleDisposalVo();
        Example example = new Example(VehicleDisposal.class);
        example.createCriteria().andEqualTo("disposalTaskNo", disposalTaskNo);
        VehicleDisposal vehicleDisposal = vehicleDisposalRepository.selectOneByExample(example);
        if (vehicleDisposal != null) {
            vehicleDisposalVo = EntityUtils.getEntity(vehicleDisposal, new VehicleDisposalVo());
            // 根据收车任务号，获取收车任务信息
            setVehicleDisposalVoByRetrieveTask(vehicleDisposalVo, vehicleDisposal.getRecoveryTaskNo());
            // 根据合同号，获取客户信息
            DisposalContVo disposalContVo = vehicleDisposalRepository.selectDisposalContVoByContNo(vehicleDisposal.getContNo());
            if (disposalContVo != null) {
                vehicleDisposalVo = EntityUtils.getEntity(disposalContVo, vehicleDisposalVo);
            }
            // 获取附件信息
            //只有转固定资产需要上传附件
            if (DisposalStatusEnums.CAPITAL_ASSETS.getType().equals(vehicleDisposalVo.getDisposalStatus())) {
                vehicleDisposalVo.setBizFilesList(bizFilesService.findBizFilesList(disposalTaskNo, BizCodeTypeEnums.CAPITAL_ASSETS_FILE.getCodeType()));
            } else if (DisposalStatusEnums.REDEMPTION.getType().equals(vehicleDisposalVo.getDisposalStatus())) {
                // 车辆赎回追加上传附件
                vehicleDisposalVo.setBizFilesList(bizFilesService.findBizFilesList(disposalTaskNo, BizCodeTypeEnums.VEHICLE_REDEEM_FILE.getCodeType()));
            }
        }
        return vehicleDisposalVo;
    }

    /**
     * @Title:
     * @Description:  根据收车任务号，设置收车信息
     * @param vehicleDisposalVo VehicleDisposalVo
     * @param recoveryTaskNo 收车任务号
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    private void setVehicleDisposalVoByRetrieveTask(VehicleDisposalVo vehicleDisposalVo, String recoveryTaskNo){
        RetrieveCarsTask retrieveCarsTask = retrieveCarsTaskService.findRetrieveCarsTaskByretRieveCarTaskNo(recoveryTaskNo);
        if (retrieveCarsTask != null) {
            // 收车费用
            vehicleDisposalVo.setRecoveryAmount(retrieveCarsTask.getActRetrAmount());
            // 入库地址
            vehicleDisposalVo.setStorageAddr(retrieveCarsTask.getStorageAddr());
            // 入库时间
            vehicleDisposalVo.setStorageDate(retrieveCarsTask.getStorageDate());
            // 收车发起时间
            vehicleDisposalVo.setRecoverySubmitDate(retrieveCarsTask.getSubmitDate());
            // 入库登记车架号
            vehicleDisposalVo.setRegisterVinNo(retrieveCarsTask.getVinNo());
            // 入库登记行驶公里数
            vehicleDisposalVo.setRegisterMileAge(retrieveCarsTask.getMileAge());
            // 入库登记车辆状态描述
            vehicleDisposalVo.setCarStatusDes(retrieveCarsTask.getCarStatusDes());
        }
    }

    /**
     * @Title:
     * @Description:  车辆处置申请提交
     * @param vehicleDisposalVo 处置信息
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    @Transactional
    public void submitVehicleDisposalApply(VehicleDisposalVo vehicleDisposalVo, SysUser sysUser) {
        vehicleDisposalVo.setUser(sysUser.getUser());
        // 车辆处置方式
        if (StringUtils.isTrimBlank(vehicleDisposalVo.getDisposalStatus())) {
            throw new FmsServiceException("车辆处置方式不能为空");
        }
        VehicleDisposal vehicleDisposal = vehicleDisposalRepository.selectByPrimaryKey(vehicleDisposalVo.getVehicleDisposalId());
        if (vehicleDisposal == null) {
            throw new FmsServiceException("车辆处置信息不存在");
        }
        // 处置申请check
        checkVehicleDisposalApply(vehicleDisposal);
        String taskNo = null;
        //提交时区分车辆处置类型
        if (DisposalStatusEnums.REDEMPTION.getType().equals(vehicleDisposalVo.getDisposalStatus())) {
            // 赎回
            // 根据合同编号，获取有效的有效提前还款数据
            taskNo = findDisposalTaskNoByContNo(vehicleDisposal.getContNo(), DisposalStatusEnums.REDEMPTION.getType());
            if (taskNo == null) {
                throw new FmsServiceException("提前还款申请未发起");
            }
            // 保存附件信息
            if (ArrayUtils.isNotNullAndLengthNotZero(vehicleDisposalVo.getBizFilesList())) {
                bizFilesService.modifyBizFilesList(vehicleDisposalVo.getBizFilesList(), taskNo, BizCodeTypeEnums.VEHICLE_REDEEM_FILE.getCodeType());
            }
        } else if (DisposalStatusEnums.CAPITAL_ASSETS.getType().equals(vehicleDisposalVo.getDisposalStatus())) {
            taskNo = capitalAssetsTaskService.submitCapitalAssets(vehicleDisposalVo, sysUser);
        } else if (DisposalStatusEnums.DEPOSIT_CHANGE.getType().equals(vehicleDisposalVo.getDisposalStatus())) {
            taskNo = findDepositChangeTaskByContNo(vehicleDisposal.getContNo());
            if (taskNo == null) {
                throw new FmsServiceException("增加保证金申请未发起");
            }
        }
        vehicleDisposalVo.setDisposalTaskNo(taskNo);
        vehicleDisposalVo.setRemark(vehicleDisposalVo.getRemark());
        modifyVehicleDisposalByVo(vehicleDisposalVo);
    }

    /**
     * @Title:
     *
     * @Description:  车辆处置申请提交check
     * @param vehicleDisposal 处置信息
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    private void checkVehicleDisposalApply(VehicleDisposal vehicleDisposal) {
        if (!VehicleDisposalStatusEnums.TO_BE_DISPOSE.getType().equals(vehicleDisposal.getVehicleDisposalStatus())) {
            throw new FmsServiceException("车辆已经处置，不可重复处置");
        }
        // 判断当前任务是否有效
        if (StringUtils.isNotTrimBlank(vehicleDisposal.getDisposalTaskNo())) {
            if (DisposalStatusEnums.CAPITAL_ASSETS.getType().equals(vehicleDisposal.getDisposalStatus())
                    || DisposalStatusEnums.DEPOSIT_CHANGE.getType().equals(vehicleDisposal.getDisposalStatus())) {
                //增加保证金和转固定资产的场合
                throw new FmsServiceException("车辆处置任务已发起，不可重复申请");
            } else if (DisposalStatusEnums.REDEMPTION.getType().equals(vehicleDisposal.getDisposalStatus())) {
                // 赎回的场合，根据任务号，获取提前还款任务
                Example example = new Example(ContPrepayment.class);
                example.createCriteria().andEqualTo("contPrepaymentNo", vehicleDisposal.getDisposalTaskNo());
                SqlUtil.setOrderByUpdateTimeDesc(example);
                ContPrepayment contPrepayment = contPrepaymentRepository.selectOneByExample(example);
                if (contPrepayment != null && !BizStatusEnums.PREPAYMENT_INVALID.getType().equals(contPrepayment.getPrepaymentSts())) {
                    // 提前还款任务没有失效的场合，正在进行的场合
                    throw new FmsServiceException("车辆处置任务已发起，不可重复申请");
                }
            }
        }
    }

    /**
     * @Title:
     * @Description:  车辆处置申请，保存处置信息
     * @param vehicleDisposalVo 处置信息
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    private void modifyVehicleDisposalByVo(VehicleDisposalVo vehicleDisposalVo){
        VehicleDisposal vehicleDisposal = new VehicleDisposal();
        // 车辆处置ID
        vehicleDisposal.setVehicleDisposalId(vehicleDisposalVo.getVehicleDisposalId());
        // 车辆处置方式
        vehicleDisposal.setDisposalStatus(vehicleDisposalVo.getDisposalStatus());
        // 处置任务号
        vehicleDisposal.setDisposalTaskNo(vehicleDisposalVo.getDisposalTaskNo());
        // 备注
        vehicleDisposal.setRemark(vehicleDisposalVo.getRemark());
        vehicleDisposalRepository.updateByPrimaryKeySelectiveData(vehicleDisposal);
    }

    /**
     * @Title:
     * @Description:  根据合同号和处置类型，获取当前正在处理中的处置任务号
     * @param contNo 合同编号
     * @param disposalStatus 车俩处置方式
     * @return String
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public String findDisposalTaskNoByContNo(String contNo, String disposalStatus) {
        if (DisposalStatusEnums.REDEMPTION.getType().equals(disposalStatus)) {
            // 赎回
            Example example = new Example(ContPrepayment.class);
            example.createCriteria().andEqualTo("contNo", contNo);
            SqlUtil.setOrderByUpdateTimeDesc(example);
            ContPrepayment contPrepayment = contPrepaymentRepository.selectOneByExample(example);
            if (contPrepayment != null && !BizStatusEnums.PREPAYMENT_INVALID.getType().equals(contPrepayment.getPrepaymentSts())) {
                return contPrepayment.getContPrepaymentNo();
            }
        } else if (DisposalStatusEnums.DEPOSIT_CHANGE.getType().equals(disposalStatus)) {
            // 增加保证金
            return findDepositChangeTaskByContNo(contNo);
        }
        return null;
    }

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo查询是否进行过保证金变更申请
     * @author huzongcheng
     * @date
     */
    public String findDepositChangeTaskByContNo(String contNo) {
        Example example = SqlUtil.newExample(DepositChangeTask.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo", contNo);
        criteria.andNotEqualTo("depositTaskStatus",BizStatusEnums.DEPOSIT_CHANGE_REFUSE.getType());
        criteria.andNotEqualTo("depositTaskStatus",BizStatusEnums.DEPOSIT_CHANGE_CANCEL.getType());
        DepositChangeTask depositChangeTask = depositChangeTaskRepository.selectOneByExample(example);
        return depositChangeTask == null ? null : depositChangeTask.getDepositTaskNo();
    }
}
