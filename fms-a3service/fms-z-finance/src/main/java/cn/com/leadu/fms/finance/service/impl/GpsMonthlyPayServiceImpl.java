package cn.com.leadu.fms.finance.service.impl;/**
 * Created by yyq on 2018/6/2.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActGpsMonthlyUtils;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.ApproveFlagEnums;
import cn.com.leadu.fms.common.constant.enums.cost.SettleStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.GpsDispatchRepository;
import cn.com.leadu.fms.data.cost.repository.MonthlySettlementRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.finance.service.GpsMonthlyPayService;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.pojo.cost.entity.MonthlySettlement;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlementApprove.MonthlySettlementApproveVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Map;

/**
 * @program: fms
 * @description: gps月结付款service
 * @author: yangyiquan
 * @create: 2018-06-02 14:02
 **/
@Service
public class GpsMonthlyPayServiceImpl implements GpsMonthlyPayService {

    /**
     * @Fields  : gps月结任务表repository
     */
    @Autowired
    private MonthlySettlementRepository monthlySettlementRepository;

    /**
     * @Fields  : 派单信息repository
     */
    @Autowired
    private GpsDispatchRepository gpsDispatchRepository;

    /**
     * * @Fields  : 财务付款表Repository层
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 审批日志录入service
     */
    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Fields  : 通用pdfservice
     * @author yanfengbo
     */
    @Autowired
    private CommonPdfService commonPdfService;

    /**
     * @param monthlySettlementApproveVo
     * @Description: Gps月结制单
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/2 14:01
     */
    @Override
    @Transactional
    public void makeVoucher(MonthlySettlementApproveVo monthlySettlementApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //流程引擎
        if(ApproveFlagEnums.SUBMIT.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//通过
            act = ActTypeEnums.SUBMIT.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalAgree(monthlySettlementApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalReturnSuperior(monthlySettlementApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }

        //更新财务付款表
        ContPay contPay = new ContPay();
        contPay.setContPayId(monthlySettlementApproveVo.getContPayId());
        contPay.setPayAccBank(monthlySettlementApproveVo.getPayAccBank());
        contPay.setPayAccBranch(monthlySettlementApproveVo.getPayAccBranch());
        contPay.setPayAccountName(monthlySettlementApproveVo.getPayAccountName());
        contPay.setPayAccountNo(monthlySettlementApproveVo.getPayAccountNo());
        contPay.setPayEleBankNo(monthlySettlementApproveVo.getPayEleBankNo());
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);
        //审批操作
        this.approveCommon(monthlySettlementApproveVo,act,actRuTaskVo);

    }

    /**
     * @param monthlySettlementApproveVo
     * @Description: Gps月结财务付款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/4 12:01
     */
    @Override
    @Transactional
    public void payment(MonthlySettlementApproveVo monthlySettlementApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        String payStatus = "";
        //流程引擎
        if(ApproveFlagEnums.SUBMIT.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//通过
            //更新月结明细状态
            Example example = SqlUtil.newExample(GpsDispatch.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("monthlySettlementNo",monthlySettlementApproveVo.getMonthlySettlementNo());
            GpsDispatch gpsDispatch = new GpsDispatch();
            gpsDispatch.setSettleStatus(SettleStatusEnums.MONTHLY_KNOT.getStatus());
            gpsDispatchRepository.updateByExampleSelectiveData(gpsDispatch,example);

            act = ActTypeEnums.SUBMIT.getType();
            payStatus = PayStatusEnums.REQUEST.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalAgree(monthlySettlementApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(monthlySettlementApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            payStatus = PayStatusEnums.CONFIRM.getType();
            actRuTaskVo = ActGpsMonthlyUtils.approvalReturnSuperior(monthlySettlementApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }
        //更新财务付款表
        ContPay contPay = new ContPay();
        contPay.setContPayId(monthlySettlementApproveVo.getContPayId());
        contPay.setPayStatus(payStatus);
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);
        //审批操作
        this.approveCommon(monthlySettlementApproveVo,act,actRuTaskVo);
    }

    /**
     * @param monthlySettlementApproveVo
     * @param act
     * @param actRuTaskVo
     * @Description: 审批共同操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/5 15:55
     */
    @Override
    @Transactional
    public void approveCommon(MonthlySettlementApproveVo monthlySettlementApproveVo, String act, ActRuTaskVo actRuTaskVo) {
        //更新状态
        MonthlySettlement monthlySettlement = new MonthlySettlement();
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        monthlySettlement.setMonthlySts(contractBizStatusUpd);
        Example example = SqlUtil.newExample(MonthlySettlement.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlySettlementNo",monthlySettlementApproveVo.getMonthlySettlementNo());
        //当前节点用户
//        monthlySettlement.setPresentUser(actRuTaskVo.getNextAssignee());
        monthlySettlement.setPresentUser(actRuTaskVo.getNextAssignee());
        monthlySettlementRepository.updateByExampleSelectiveData(monthlySettlement,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(monthlySettlementApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(monthlySettlementApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.GPS_MONTHLY.getType());
        workflowLog.setWfLogNo(monthlySettlementApproveVo.getMonthlySettlementNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: gps月结付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public String printGpsMonthly(MonthlySettlementApproveVo monthlySettlementApproveVo){
        //收付款银行及款项金额相关信息
        if(monthlySettlementApproveVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(monthlySettlementApproveVo.getContPay() == null){
            throw new FmsServiceException("未找到相关数据");
        }
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(monthlySettlementApproveVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        if(monthlySettlementApproveVo.getContPay().getPayAmount()!=null){
            pdfVariables.put("payAmount", StringUtils.defaultString(monthlySettlementApproveVo.getContPay().getPayAmount().toString()));
        }
        pdfVariables.put("recAccountName", StringUtils.defaultString(monthlySettlementApproveVo.getContPay().getRecAccountName()));
        pdfVariables.put("recAccBranch", monthlySettlementApproveVo.getContPay().getRecAccBank()+" "+monthlySettlementApproveVo.getContPay().getRecAccBranch());
        pdfVariables.put("recAccountNo", monthlySettlementApproveVo.getContPay().getRecAccountNo());
        pdfVariables.put("payAccountName", monthlySettlementApproveVo.getPayAccountName());
        if(monthlySettlementApproveVo.getPayAccBank() != null && monthlySettlementApproveVo.getPayAccBranch() != null){
            pdfVariables.put("payAccBranch", monthlySettlementApproveVo.getPayAccBank()+" "+monthlySettlementApproveVo.getPayAccBranch());
        }
        pdfVariables.put("payAccountNo", monthlySettlementApproveVo.getPayAccountNo());
        //pdfVo封装pdf附件中客户相关信息
        PdfCreateVo pdfCreateVo=new PdfCreateVo();
        //pdf附件每页显示客户信息条数
        pdfCreateVo.setPageSize(30);
        // 附件信息(客户信息相关键值对)
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < monthlySettlementApproveVo.getGpsDispatchMonthlyVo().size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no", i + 1);
            jsonObject.put("chuzu", monthlySettlementApproveVo.getGpsDispatchMonthlyVo().get(i).getRentPerson());
            jsonObject.put("chengzu", monthlySettlementApproveVo.getGpsDispatchMonthlyVo().get(i).getLessee());
            jsonObject.put("chejiahao", monthlySettlementApproveVo.getGpsDispatchMonthlyVo().get(i).getVinNo());
            jsonArray.add(jsonObject);
        }
        pdfCreateVo.setFjDataArray(jsonArray);

        //输出pdf
        String filePath = commonPdfService.createWithFj(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_GPS_MONTHLY.getType(),TplTypeKeyEnums.WL_PAYMENT_FJ.getType(),pdfCreateVo);
        return filePath;
    }
}
