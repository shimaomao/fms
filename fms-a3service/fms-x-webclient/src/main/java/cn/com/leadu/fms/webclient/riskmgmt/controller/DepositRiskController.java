package cn.com.leadu.fms.webclient.riskmgmt.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.riskmgmt.vo.depositrisk.DepositRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.webclient.riskmgmt.rpc.DepositRiskRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: DepositRiskController
 * @Description: 风控审批Controller
 * @date 2018-06-4
 */
@RestController
@RequestMapping("deposit_risk")
public class DepositRiskController {

    @Autowired
    private DepositRiskRpc depositRiskRpc;

    /**
     * @Title:
     * @Description: 根据订单编号，取得风控初期数据
     * @param depositTaskNo 变更任务号
     * @return ApplyRiskVo
     * @throws
     * @author liujinge
     * @date 2018-6-4 20:18:12
     */
    @RequestMapping(value = "findApplyRiskInit", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyRiskInit(String depositTaskNo){
        return depositRiskRpc.findApplyRiskInit(depositTaskNo);
    }

    /** 
    * @Description: 保存风控数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/7 20:16
    */ 
    @RequestMapping(value = "saveApplyRisk", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRisk(@RequestBody DepositRiskVo depositRiskVo){
        return depositRiskRpc.saveApplyRisk(depositRiskVo);
    }

    /**
     * @param vo 参数实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody DepositRiskVo vo) {
        depositRiskRpc.sendBack(vo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo 参数实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "refuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> refuse(@RequestBody DepositRiskVo vo) {
        depositRiskRpc.refuse(vo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 15:33
     */
    @RequestMapping(value = "saveApplyRiskPyCredit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRiskPyCredit(@RequestBody PycreditListVo pycreditListVo){
        return depositRiskRpc.saveApplyRiskPyCredit(pycreditListVo);
    }
}
