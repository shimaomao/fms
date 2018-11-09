package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlement.MonthlySettlementVo;
import cn.com.leadu.fms.webclient.cost.rpc.MonthlySettlementRpc;
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
 * @ClassName: MonthlySettlementController
 * @Description: gps月结任务表controller
 * @date 2018-05-28
 */
@RestController
@RequestMapping("monthly_settlement")
public class MonthlySettlementController {

    /**
     * @Fields  : gps月结任务表rpc
     */
    @Autowired
    private MonthlySettlementRpc monthlySettlementRpc;

    /**
     * @Title:
     * @Description: 分页查询gps月结任务表信息
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "findMonthlySettlementsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementsByPage(MonthlySettlementVo monthlySettlementVo){
        Map monthlySettlementVoMap = monthlySettlementVo == null?null:(Map) JSON.toJSON(monthlySettlementVo);
        return monthlySettlementRpc.findMonthlySettlementsByPage(monthlySettlementVoMap);
    }

    /**
     * @Title:
     * @Description: 保存gps月结任务表
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "saveMonthlySettlement",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlySettlement(@RequestBody MonthlySettlementVo monthlySettlementVo){
        return monthlySettlementRpc.saveMonthlySettlement(monthlySettlementVo);
    }

    /** 
    * @Description: 保存月结申请
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/29 10:37
    */ 
    @RequestMapping(value = "saveMonthlySettlementWithGps",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlySettlementWithGps(@RequestBody MonthlySettlementVo monthlySettlementVo){
        return monthlySettlementRpc.saveMonthlySettlementWithGps(monthlySettlementVo);
    }

    /**
     * @Title:
     * @Description:  修改gps月结任务表
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "modifyMonthlySettlement",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMonthlySettlement(@RequestBody MonthlySettlementVo monthlySettlementVo){
        return monthlySettlementRpc.modifyMonthlySettlement(monthlySettlementVo);
    }

    /**
     * @Title:
     * @Description:   根据monthlySettlementId集合删除gps月结任务表
     * @param monthlySettlementIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "deleteMonthlySettlementsByMonthlySettlementIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlySettlementsByMonthlySettlementIds(@RequestBody List<String> monthlySettlementIds){
        MonthlySettlementVo monthlySettlementVo = new MonthlySettlementVo();
        monthlySettlementVo.setMonthlySettlementIds(monthlySettlementIds);
        return monthlySettlementRpc.deleteMonthlySettlementsByMonthlySettlementIds(monthlySettlementVo);
    }

    /**
     * @Title:
     * @Description:  根据monthlySettlementId获取gps月结任务表
     * @param monthlySettlementId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "findMonthlySettlementByMonthlySettlementId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementByMonthlySettlementId(String monthlySettlementId){
        return monthlySettlementRpc.findMonthlySettlementByMonthlySettlementId(monthlySettlementId);
    }

    /** 
    * @Description: 根据monthlySettlementNo获取gps月结任务表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 17:38
    */ 
    @RequestMapping(value = "findMonthlySettlementBySettlementNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementBySettlementNo(String monthlySettlementNo){
        return monthlySettlementRpc.findMonthlySettlementBySettlementNo(monthlySettlementNo);
    }

    /**
     * @Title:
     * @Description: 根据monthlySettlementNo获取gps月结任务表(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findMonthlySettlementVoBySettlementNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementVoBySettlementNo(String monthlySettlementNo){
        return monthlySettlementRpc.findMonthlySettlementVoBySettlementNo(monthlySettlementNo);
    }
}
