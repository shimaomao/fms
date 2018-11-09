package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgagePostVo;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import cn.com.leadu.fms.webclient.asset.rpc.MortgageRegisterRpc;
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
 * @ClassName: MortgageRegisterController
 * @Description: 解抵押过户信息controller
 * @date 2018-05-18
 */
@RestController
@RequestMapping("mortgage_register")
public class MortgageRegisterController {

    /**
     * @Fields  : 解抵押过户信息rpc
     */
    @Autowired
    private MortgageRegisterRpc mortgageRegisterRpc;

    /**
     * @Title:
     * @Description: 分页查询解抵押过户信息信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "findMortgageRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRegistersByPage(MortgageRegisterVo mortgageRegisterVo){
        Map mortgageRegisterVoMap = mortgageRegisterVo == null?null:(Map) JSON.toJSON(mortgageRegisterVo);
        return mortgageRegisterRpc.findMortgageRegistersByPage(mortgageRegisterVoMap);
    }

    /**
     * @Title:
     * @Description: 保存解抵押过户信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "saveMortgageRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgageRegister(@RequestBody MortgageRegisterVo mortgageRegisterVo){
        return mortgageRegisterRpc.saveMortgageRegister(mortgageRegisterVo);
    }

    /** 
    * @Description: 保存解抵押资料邮寄信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/22 16:54
    */ 
    @RequestMapping(value = "saveMortgagePost",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgagePost(@RequestBody MortgagePostVo mortgagePostVo){
        return mortgageRegisterRpc.saveMortgagePost(mortgagePostVo);
    }

    /**
     * @Title:
     * @Description:  修改解抵押过户信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "modifyMortgageRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMortgageRegister(@RequestBody MortgageRegisterVo mortgageRegisterVo){
        return mortgageRegisterRpc.modifyMortgageRegister(mortgageRegisterVo);
    }

    /**
     * @Title:
     * @Description:   根据mortgageRegisterId集合删除解抵押过户信息
     * @param mortgageRegisterIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "deleteMortgageRegistersByMortgageRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRegistersByMortgageRegisterIds(@RequestBody List<String> mortgageRegisterIds){
        MortgageRegisterVo mortgageRegisterVo = new MortgageRegisterVo();
        mortgageRegisterVo.setMortgageRegisterIds(mortgageRegisterIds);
        return mortgageRegisterRpc.deleteMortgageRegistersByMortgageRegisterIds(mortgageRegisterVo);
    }

    /**
     * @Title:
     * @Description:  根据mortgageRegisterId获取解抵押过户信息
     * @param mortgageRegisterId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "findMortgageRegisterByMortgageRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRegisterByMortgageRegisterId(String mortgageRegisterId){
        return mortgageRegisterRpc.findMortgageRegisterByMortgageRegisterId(mortgageRegisterId);
    }

    /** 
    * @Description: 获取解抵押附件
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/23 11:41
    */ 
    @RequestMapping(value = "findBizFilesMortgageRegister", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesMortgageRegister(String bizCode){
        return mortgageRegisterRpc.findBizFilesMortgageRegister(bizCode);
    }

}
