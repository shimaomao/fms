package cn.com.leadu.fms.finance.service.impl;/**
 * Created by yyq on 2018/6/4.
 */

import cn.com.leadu.fms.business.common.util.activiti.ActPilferMonthlyUtils;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.ActTypeEnums;
import cn.com.leadu.fms.common.constant.enums.ApproveFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.MonthlyPilferInsuranceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.finance.service.PilferMonthlyPayService;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.cost.entity.MonthlyPilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
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
 * @description: 盗抢险月结付款service
 * @author: yangyiquan
 * @create: 2018-06-04 18:17
 **/
@Service
public class PilferMonthlyPayServiceImpl implements PilferMonthlyPayService {
    /**
     * * @Fields  : 盗抢险月结任务信息Repository层
     */
    @Autowired
    private MonthlyPilferInsuranceRepository monthlyPilferInsuranceRepository;

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
     * @param pilferInsuranceApproveVo
     * @Description: 盗抢险月结财务制单
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/4 18:11
     */
    @Override
    @Transactional
    public void makeVoucher(PilferInsuranceApproveVo pilferInsuranceApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        //
        if(ApproveFlagEnums.SUBMIT.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//通过
            act = ActTypeEnums.SUBMIT.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalAgree(pilferInsuranceApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalReturnSuperior(pilferInsuranceApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }

        //更新财务付款表
        ContPay contPay = new ContPay();
        contPay.setContPayId(pilferInsuranceApproveVo.getContPayId());
        contPay.setPayAccBank(pilferInsuranceApproveVo.getPayAccBank());
        contPay.setPayAccBranch(pilferInsuranceApproveVo.getPayAccBranch());
        contPay.setPayAccountName(pilferInsuranceApproveVo.getPayAccountName());
        contPay.setPayAccountNo(pilferInsuranceApproveVo.getPayAccountNo());
        contPay.setPayEleBankNo(pilferInsuranceApproveVo.getPayEleBankNo());
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);

        //审批操作
        this.approveCommon(pilferInsuranceApproveVo,act,actRuTaskVo);
    }

    /**
     * @param pilferInsuranceApproveVo
     * @Description: 盗抢险月结财务付款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/4 18:11
     */
    @Override
    @Transactional
    public void payment(PilferInsuranceApproveVo pilferInsuranceApproveVo) {
        ActRuTaskVo actRuTaskVo = null;
        String act = "";
        String payStatus = "";
        //流程引擎
        if(ApproveFlagEnums.SUBMIT.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//通过
            act = ActTypeEnums.SUBMIT.getType();
            payStatus = PayStatusEnums.REQUEST.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalAgree(pilferInsuranceApproveVo.getTaskId());
        }else if(ApproveFlagEnums.BACK.getType().equals(pilferInsuranceApproveVo.getApprovalFlag())){//退回
            act = ActTypeEnums.SENDBACK.getType();
            payStatus = PayStatusEnums.CONFIRM.getType();
            actRuTaskVo = ActPilferMonthlyUtils.approvalReturnSuperior(pilferInsuranceApproveVo.getTaskId());
        }else{
            throw new FmsServiceException("没有对应的操作");
        }

        //更新财务付款表
        ContPay contPay = new ContPay();
        contPay.setContPayId(pilferInsuranceApproveVo.getContPayId());
        contPay.setPayStatus(payStatus);
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);

        //审批操作
        this.approveCommon(pilferInsuranceApproveVo,act,actRuTaskVo);

    }


    @Override
    @Transactional
    public void approveCommon(PilferInsuranceApproveVo pilferInsuranceApproveVo, String act, ActRuTaskVo actRuTaskVo) {
        //更新状态
        MonthlyPilferInsurance monthlySettlement = new MonthlyPilferInsurance();
        String contractBizStatusUpd = actRuTaskVo.getTaskCode();
        monthlySettlement.setMonthlyPilferInsuranceSts(contractBizStatusUpd);
        Example example = SqlUtil.newExample(MonthlyPilferInsurance.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("monthlyPilferInsuranceNo",pilferInsuranceApproveVo.getMonthlyPilferInsuranceNo());
        //当前节点用户
//        monthlySettlement.setPresentUser(actRuTaskVo.getNextAssignee());
        monthlySettlement.setPresentUser(actRuTaskVo.getNextAssignee());
        monthlyPilferInsuranceRepository.updateByExampleSelectiveData(monthlySettlement,example);

        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(pilferInsuranceApproveVo.getUser());
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setRemark1(pilferInsuranceApproveVo.getMemo());
        workflowLog.setWfLogType(BizTypeEnums.THEFT_MONTHLY.getType());
        workflowLog.setWfLogNo(pilferInsuranceApproveVo.getMonthlyPilferInsuranceNo());
        workflowLog.setStatus(contractBizStatusUpd);
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /**
     * @Title:
     * @Description: 盗抢险月结付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    @Transactional
    public String printPilferMonthly(PilferInsuranceApproveVo pilferInsuranceApproveVo){
        //收付款银行及款项金额相关信息
        if(pilferInsuranceApproveVo == null){
            throw new FmsServiceException("未找到相关数据");
        }
        if(pilferInsuranceApproveVo.getContPay() == null){
            throw new FmsServiceException("未找到相关数据");
        }

        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(pilferInsuranceApproveVo);
        pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
        if(pilferInsuranceApproveVo.getContPay().getPayAmount()!=null){
            pdfVariables.put("payAmount", StringUtils.defaultString(pilferInsuranceApproveVo.getContPay().getPayAmount().toString()));
        }
        pdfVariables.put("recAccountName", StringUtils.defaultString(pilferInsuranceApproveVo.getContPay().getRecAccountName()));
        pdfVariables.put("recAccBranch", pilferInsuranceApproveVo.getContPay().getRecAccBank()+" "+pilferInsuranceApproveVo.getContPay().getRecAccBranch());
        pdfVariables.put("recAccountNo", pilferInsuranceApproveVo.getContPay().getRecAccountNo());
        pdfVariables.put("payAccountName", pilferInsuranceApproveVo.getPayAccountName());
        if(pilferInsuranceApproveVo.getPayAccBank() != null && pilferInsuranceApproveVo.getPayAccBranch() != null){
            pdfVariables.put("payAccBranch", pilferInsuranceApproveVo.getPayAccBank()+" "+pilferInsuranceApproveVo.getPayAccBranch());
        }
        pdfVariables.put("payAccountNo", pilferInsuranceApproveVo.getPayAccountNo());

        //pdfVo封装pdf附件中客户相关信息
        PdfCreateVo pdfCreateVo=new PdfCreateVo();
        //pdf附件每页显示客户信息条数
        pdfCreateVo.setPageSize(30);
        // 附件信息(客户信息相关键值对)
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < pilferInsuranceApproveVo.getPilferInsuranceVoList().size(); i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("no", i + 1);
            jsonObject.put("chuzu", pilferInsuranceApproveVo.getPilferInsuranceVoList().get(i).getRentPerson());
            jsonObject.put("chengzu", pilferInsuranceApproveVo.getPilferInsuranceVoList().get(i).getLessee());
            jsonObject.put("chejiahao", pilferInsuranceApproveVo.getPilferInsuranceVoList().get(i).getVinNo());
            jsonArray.add(jsonObject);
        }
        pdfCreateVo.setFjDataArray(jsonArray);

        //输出pdf
        String filePath = commonPdfService.createWithFj(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_PILFER_MONTHLY.getType(),TplTypeKeyEnums.WL_PAYMENT_FJ.getType(),pdfCreateVo);
        return filePath;
    }
}
