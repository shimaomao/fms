package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.webclient.asset.rpc.MortgageRemindRpc;
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
 * @author ningyangyang
 * @ClassName: MortgageRemindController
 * @Description: 抵押提醒controller
 * @date 2018-07-27
 */
@RestController
@RequestMapping("mortgage_remind")
public class MortgageRemindController {

    /**
     * @Fields  : 抵押提醒rpc
     */
    @Autowired
    private MortgageRemindRpc mortgageRemindRpc;

    /**
     * @Title:
     * @Description: 分页查询抵押提醒信息
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "findMortgageRemindsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRemindsByPage(MortgageRemindVo mortgageRemindVo){
        Map mortgageRemindVoMap = mortgageRemindVo == null?null:(Map) JSON.toJSON(mortgageRemindVo);
        return mortgageRemindRpc.findMortgageRemindsByPage(mortgageRemindVoMap);
    }

    /**
     * @Title:
     * @Description: 保存抵押提醒
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "saveMortgageRemind",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgageRemind(@RequestBody MortgageRemindVo mortgageRemindVo){
        return mortgageRemindRpc.saveMortgageRemind(mortgageRemindVo);
    }

    /**
     * @Title:
     * @Description:  修改抵押提醒
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "modifyMortgageRemind",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMortgageRemind(@RequestBody MortgageRemindVo mortgageRemindVo){
        return mortgageRemindRpc.modifyMortgageRemind(mortgageRemindVo);
    }

    /**
     * @Title:
     * @Description:   根据morRemindId集合删除抵押提醒
     * @param morRemindIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "deleteMortgageRemindsByMorRemindIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRemindsByMorRemindIds(@RequestBody List<String> morRemindIds){
        MortgageRemindVo mortgageRemindVo = new MortgageRemindVo();
        mortgageRemindVo.setMorRemindIds(morRemindIds);
        return mortgageRemindRpc.deleteMortgageRemindsByMorRemindIds(mortgageRemindVo);
    }

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "findMortgageRemindByMorRemindId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRemindByMorRemindId(String morRemindId){
        return mortgageRemindRpc.findMortgageRemindByMorRemindId(morRemindId);
    }

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "selectMortgageRemindVosBymorRemindId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectMortgageRemindVosBymorRemindId(String morRemindId){
        return mortgageRemindRpc.selectMortgageRemindVosBymorRemindId(morRemindId);
    }

}
