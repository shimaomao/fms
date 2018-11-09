package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/4/28.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: fms
 * @description: 合同一览信息查询Controller
 * @author: yangyiquan
 * @create: 2018-04-28 12:00
 **/
@RestController
@RequestMapping("contract")
public class ContractController {
    /**
     * @Fields: 合同信息一览rpc
     */
    @Autowired
    private ContractRpc contractRpc;

    /** 
    * @Description: 合同一览信息查询
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/4/28 12:36
    */
    @RequestMapping(value = "findContractListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractListByPage(ContractListVo contractListVo){
        Map<String, Object> contractListVoMap = contractListVo == null ? null : (Map) JSON.toJSON(contractListVo);
        return contractRpc.findContractListByPage(contractListVoMap);
    }

    /**
     * @Description: 当月新增放款车辆明细一览信息查询
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/28 12:36
     */
    @RequestMapping(value = "findNewLoanByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findNewLoanByPage(ContractListVo contractListVo){
        Map<String, Object> contractListVoMap = contractListVo == null ? null : (Map) JSON.toJSON(contractListVo);
        return contractRpc.findNewLoanByPage(contractListVoMap);
    }

    /**
     * @Description: 当月新增放款车辆明细导出
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/28 12:36
     */
    @RequestMapping(value = "findNewLoanExport",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findNewLoanExport(ContractListVo contractListVo){
        Map<String, Object> contractListVoMap = contractListVo == null ? null : (Map) JSON.toJSON(contractListVo);
        return contractRpc.findNewLoanExport(contractListVoMap);
    }

    /**
    * @Description: 合同一览信息选择
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/28 16:53
    */
    @RequestMapping(value = "findContractSelectListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractSelectListByPage(ContractListVo contractListVo){
        Map<String, Object> contractListVoMap = contractListVo == null ? null : (Map) JSON.toJSON(contractListVo);
        return contractRpc.findContractSelectListByPage(contractListVoMap);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取合同详情顶部信息
     * @param contNo
     * @return ApplyBaseInfoVo
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "findContBaseInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContBaseInfo(String contNo){
        return contractRpc.findContBaseInfo(contNo);
    }
}
