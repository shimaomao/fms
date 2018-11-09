package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.baseinfo.service.BasSalesService;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesModifyVo;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.BasSalesSaveVo;
import cn.com.leadu.fms.business.common.util.activiti.ActBasSalesUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasSalesRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.*;

/**
 * @author yanfengbo
 * @ClassName: BasSalesService
 * @Description: 实际销售方业务实现层
 * @date 2018-05-03
 */
@Slf4j
@Service
public class BasSalesServiceImpl implements BasSalesService {

    /**
     * @Fields  : 实际销售方repository
     */
    @Autowired
    private BasSalesRepository basSalesRepository;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields : 业务编号管理业务service
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields : 日志service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 分页查询实际销售方
     * @param basSalesVo
     * @return PageInfoExtend<BasSales>
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public PageInfoExtend<BasSalesVo> findBasSalessByPage(BasSalesVo basSalesVo){

        if(StringUtils.isTrimBlank(basSalesVo.getSalesCode())){
            basSalesVo.setSalesCode(null);
        }else {
            basSalesVo.setSalesCode(SqlUtil.likePattern(basSalesVo.getSalesCode()));
        }

        if(StringUtils.isTrimBlank(basSalesVo.getSalesName())){
            basSalesVo.setSalesName(null);
        }else {
            basSalesVo.setSalesName(SqlUtil.likePattern(basSalesVo.getSalesName()));
        }

        if(StringUtils.isTrimBlank(basSalesVo.getSalesTaskStatus()))
            basSalesVo.setSalesTaskStatus(null);
        PageInfoExtend<BasSalesVo> pageInfo = basSalesRepository.selectListVoByPage("selectBasSalessBypage", basSalesVo, basSalesVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存实际销售方
     * @param basSalesSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Transactional
    public void saveBasSales(BasSalesSaveVo basSalesSaveVo,SysUser sysUser){
        //取任务号
        String salesTaskNo = numGenerateService.getNumGenerateByNumType(NumTypeEnums.BAS_SALES_NUM_TYPE.getType());
        //工作流引擎
        ActRuTaskVo actRuTaskVo = ActBasSalesUtils.startBasSales(salesTaskNo, "1", "实际销售方");
        if(actRuTaskVo!=null){
            //实际销售方状态设为待审批
            basSalesSaveVo.setSalesTaskStatus(actRuTaskVo.getTaskCode());
            //当前节点用户
            basSalesSaveVo.setPresentUser(actRuTaskVo.getNextAssignee());
            //采番任务号保存
            basSalesSaveVo.setSalesTaskNo(salesTaskNo);
            basSalesRepository.insertData(basSalesSaveVo.getEntity());
            //保存附件信息
            bizFilesService.modifyBizFilesList(basSalesSaveVo.getBizFilesList(),basSalesSaveVo.getSalesCode(),
                    BizCodeTypeEnums.BAS_SALES.getCodeType());
        }
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(salesTaskNo);
        workflowLog.setWfLogType(BizTypeEnums.BAS_SALES.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        //workflowLog.setRemark1(basSalesSaveVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 修改实际销售方
     * @param basSalesModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @Transactional
    public void modifyBasSales(BasSalesModifyVo basSalesModifyVo,SysUser sysUser){
        ActRuTaskVo actRuTaskVo = null;
        //如果taskId不为空则说明是退回再提交,否则是第一次提交
        if(StringUtils.isNotTrimBlank(basSalesModifyVo.getTaskId())&&!basSalesModifyVo.getTaskId().equals("undefined")){
            //流程引擎
            actRuTaskVo = ActBasSalesUtils.approvalAgree(basSalesModifyVo.getTaskId());
        }else {
            //工作流引擎
            actRuTaskVo = ActBasSalesUtils.startBasSales(basSalesModifyVo.getSalesTaskNo(), "1", "实际销售方");
        }
        //实际销售方状态设为待审批
        if (StringUtils.isNotTrimBlank(actRuTaskVo.getTaskCode())){
            basSalesModifyVo.setSalesTaskStatus(actRuTaskVo.getTaskCode());
        }else {
            throw new FmsServiceException("无法获取实际销售方状态!");
        }
        //当前节点用户
        basSalesModifyVo.setPresentUser(actRuTaskVo.getNextAssignee());
        basSalesRepository.updateByPrimaryKeySelectiveData(basSalesModifyVo.getEntity());
        //保存附件信息
        bizFilesService.modifyBizFilesList(basSalesModifyVo.getBizFilesList(),basSalesModifyVo.getSalesCode(),
                BizCodeTypeEnums.BAS_SALES.getCodeType());
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basSalesModifyVo.getSalesTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_SALES.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basSalesModifyVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SUBMIT.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description:  通过salesId删除实际销售方
     * @param basSalesDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public void deleteBasSales(BasSalesDeleteVo basSalesDeleteVo){
        basSalesRepository.deleteData(basSalesDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过salesId集合删除实际销售方
     * @param basSalesDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public void deleteBasSalessBySalesIds(BasSalesDeleteListVo basSalesDeleteListVo){
        basSalesRepository.deleteDataList(basSalesDeleteListVo.getSalesIds(),basSalesDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据salesId获取实际销售方
     * @param salesId
     * @return BasSales
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    public BasSalesVo findBasSalesBySalesId(String salesId,String serviceId){
        //如果serviceId不为空则说明是从我的任务中点过来的,否则是从一览过来的
        BasSalesVo basSalesVo;
        if(StringUtils.isNotTrimBlank(serviceId)&&!serviceId.equals("undefined")){
            Example example = SqlUtil.newExample(BasSales.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("salesTaskNo",serviceId);
            BasSales basSales = basSalesRepository.selectOneByExample(example);
            basSalesVo = EntityUtils.getEntity(basSales, new BasSalesVo());
        }else {
            basSalesVo = basSalesRepository.selectBasSalesBysalesId(salesId);
        }
        //查询附件
        basSalesVo.setBizFilesList(bizFilesService.findBizFilesList(basSalesVo.getSalesCode(), BizCodeTypeEnums.BAS_SALES.getCodeType()));
        return basSalesVo;
    }

    /**
     * @Title:
     * @Description: 实际销售方审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void approval(BasSalesVo basSalesVo,SysUser sysUser){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActBasSalesUtils.approvalAgree(basSalesVo.getTaskId());

        if(actRuTaskVo!=null){
            //状态更新为审批通过
            basSalesVo.setSalesTaskStatus(actRuTaskVo.getTaskCode());
            //当前节点用户
            basSalesVo.setPresentUser(actRuTaskVo.getNextAssignee());
            basSalesRepository.updateByPrimaryKeySelectiveData(basSalesVo.getEntity());
        }
        auditPass(basSalesVo,actRuTaskVo,sysUser);
    }

    /**
     * @Title:
     * @Description: 实际销售方审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public void sendBack(BasSalesVo basSalesVo,SysUser sysUser){
        //流程引擎
        ActRuTaskVo actRuTaskVo = ActBasSalesUtils.approvalReturnSuperior(basSalesVo.getTaskId());

        if(actRuTaskVo!=null){
            //状态更新为退回
            basSalesVo.setSalesTaskStatus(actRuTaskVo.getTaskCode());
            //当前节点用户
            basSalesVo.setPresentUser(actRuTaskVo.getNextAssignee());
            basSalesRepository.updateByPrimaryKeySelectiveData(basSalesVo.getEntity());
        }
        auditSendBack(basSalesVo,actRuTaskVo,sysUser);

    }

    /**
     * @Title:
     * @Description: 根据salesCode获取实际销售方
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public BasSales findBasSalesBySalesCode(String salesCode){
        Example example = SqlUtil.newExample(BasSales.class);
        example.createCriteria().andEqualTo("salesCode", salesCode);
        return basSalesRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 审核通过共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditPass(BasSalesVo basSalesVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basSalesVo.getSalesTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_SALES.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basSalesVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(APPROVAL.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }


    /**
     * @Title:
     * @Description: 审核退回共同操作
     * @param
     * @return void
     * @throws
     * @author yanfengbo
     */
    public void  auditSendBack(BasSalesVo basSalesVo,ActRuTaskVo actRuTaskVo,SysUser sysUser){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(sysUser.getUser());
        workflowLog.setWfLogNo(basSalesVo.getSalesTaskNo());
        workflowLog.setWfLogType(BizTypeEnums.BAS_SALES.getType());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(basSalesVo.getRemark1());
        //workflowLog.setWfLogSubNo("");
        workflowLog.setActType(SENDBACK.getType());
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLogService.insertWorkFlowLog(workflowLog);
    }
}
