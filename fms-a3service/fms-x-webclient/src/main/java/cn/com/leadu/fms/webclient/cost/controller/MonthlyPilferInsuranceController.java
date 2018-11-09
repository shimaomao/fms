package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.MonthlyPilferInsuranceVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
import cn.com.leadu.fms.webclient.cost.rpc.MonthlyPilferInsuranceRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceController
 * @Description: 盗抢险月结任务信息controller
 * @date 2018-05-31
 */
@RestController
@RequestMapping("monthly_pilfer_insurance")
public class MonthlyPilferInsuranceController {

    /**
     * @Fields  : 盗抢险月结任务信息rpc
     */
    @Autowired
    private MonthlyPilferInsuranceRpc monthlyPilferInsuranceRpc;

    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "findMonthlyPilferInsurancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsurancesByPage(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        Map monthlyPilferInsuranceVoMap = monthlyPilferInsuranceVo == null?null:(Map) JSON.toJSON(monthlyPilferInsuranceVo);
        return monthlyPilferInsuranceRpc.findMonthlyPilferInsurancesByPage(monthlyPilferInsuranceVoMap);
    }

    /**
     * @Title:
     * @Description: 保存盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "saveMonthlyPilferInsurance",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlyPilferInsurance(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        return monthlyPilferInsuranceRpc.saveMonthlyPilferInsurance(monthlyPilferInsuranceVo);
    }

    /** 
    * @Description: 保存盗抢险月结任务信息，包括盗抢险信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 21:06
    */ 
    @RequestMapping(value = "saveMonthlyPilferInsuranceWithPI",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlySettlement(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        return monthlyPilferInsuranceRpc.saveMonthlyPilferInsuranceWithPI(monthlyPilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:  修改盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "modifyMonthlyPilferInsurance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMonthlyPilferInsurance(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        return monthlyPilferInsuranceRpc.modifyMonthlyPilferInsurance(monthlyPilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:   根据monthlyPilferInsuranceId集合删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(@RequestBody List<String> monthlyPilferInsuranceIds){
        MonthlyPilferInsuranceVo monthlyPilferInsuranceVo = new MonthlyPilferInsuranceVo();
        monthlyPilferInsuranceVo.setMonthlyPilferInsuranceIds(monthlyPilferInsuranceIds);
        return monthlyPilferInsuranceRpc.deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(monthlyPilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:  根据monthlyPilferInsuranceId获取盗抢险月结任务信息
     * @param monthlyPilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "findMonthlyPilferInsuranceByMonthlyPilferInsuranceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(String monthlyPilferInsuranceId){
        return monthlyPilferInsuranceRpc.findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(monthlyPilferInsuranceId);
    }

    /** 
    * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/1 11:45
    */ 
    @RequestMapping(value = "findMonthlyPilferInsuranceByPilferInsuranceNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceByPilferInsuranceNo(String monthlyPilferInsuranceNo){
        return monthlyPilferInsuranceRpc.findMonthlyPilferInsuranceByPilferInsuranceNo(monthlyPilferInsuranceNo);
    }

    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findMonthlyPilferInsuranceVoByPilferInsuranceNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceVoByPilferInsuranceNo(String monthlyPilferInsuranceNo){
        return monthlyPilferInsuranceRpc.findMonthlyPilferInsuranceVoByPilferInsuranceNo(monthlyPilferInsuranceNo);
    }

    /**
     * @Description: 月结审批操作
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/30 16:17
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo){
        return monthlyPilferInsuranceRpc.approval(pilferInsuranceApproveVo);
    }

}
