package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindController
 * @Description: 抵押提醒rpc
 * @date 2018-07-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MortgageRemindRpc {

    /**
     * @Title:
     * @Description: 分页查询抵押提醒信息
     * @param mortgageRemindVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/findMortgageRemindsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMortgageRemindsByPage(@RequestParam Map<String, Object> mortgageRemindVoMap);

    /**
     * @Title:
     * @Description: 保存抵押提醒
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/saveMortgageRemind",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMortgageRemind(@RequestBody MortgageRemindVo mortgageRemindVo);

    /**
     * @Title:
     * @Description:  修改抵押提醒
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/modifyMortgageRemind",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyMortgageRemind(@RequestBody MortgageRemindVo mortgageRemindVo);

    /**
     * @Title:
     * @Description:   根据morRemindId集合删除抵押提醒
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/deleteMortgageRemindsByMorRemindIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteMortgageRemindsByMorRemindIds(@RequestBody MortgageRemindVo mortgageRemindVo);

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/findMortgageRemindByMorRemindId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMortgageRemindByMorRemindId(@RequestParam("morRemindId") String morRemindId);

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @RequestMapping(value = "api/asset/mortgage_remind/selectMortgageRemindVosBymorRemindId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> selectMortgageRemindVosBymorRemindId(@RequestParam("morRemindId") String morRemindId);

}
