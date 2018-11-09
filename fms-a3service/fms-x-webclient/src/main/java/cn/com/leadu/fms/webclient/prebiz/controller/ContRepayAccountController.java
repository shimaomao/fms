package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/5/9.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContRepayAccountRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: fms
 * @description: 客户还款信息一览
 * @author: yangyiquan
 * @create: 2018-05-09 11:47
 **/
@RestController
@RequestMapping("contRepayAccount")
public class ContRepayAccountController {

    /**
     * @Fields: 客户还款信息rpc
     */
    @Autowired
    private ContRepayAccountRpc contRepayAccountRpc;

    /** 
    * @Description: 分页查询客户还款信息一览
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 12:05
    */
    @RequestMapping(value = "findContRepayAccountListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepayAccountListByPage(ContRepayAccountListVo contRepayAccountListVo){
        Map<String, Object> contRepayAccountListVoMap = contRepayAccountListVo == null ? null : (Map) JSON.toJSON(contRepayAccountListVo);
        return contRepayAccountRpc.findContRepayAccountListByPage(contRepayAccountListVoMap);
    }

    /** 
    * @Description: 根据合同号取得融资合同还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 16:45
    */ 
    @RequestMapping(value = "findContRepayAccountByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepayAccountByContNo(String contNo){
        return contRepayAccountRpc.findContRepayAccountByContNo(contNo);
    }

    /** 
    * @Description: 动态修改客户还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 18:29
    */ 
    @RequestMapping(value = "modifyContRepayAccount",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContRepayAccount(@RequestBody ContRepayAccountVo contRepayAccountVo){
        return contRepayAccountRpc.modifyContRepayAccount(contRepayAccountVo);
    }
}
