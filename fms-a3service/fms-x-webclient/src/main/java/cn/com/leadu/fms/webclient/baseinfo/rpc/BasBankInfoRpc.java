package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoController
 * @Description: 银行账号维护rpc
 * @date 2018-03-26
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasBankInfoRpc {

    /**
     * @Title:
     * @Description: 分页查询银行账号维护信息
     * @param basBankInfoVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/findBasBankInfosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasBankInfosByPage(@RequestParam Map<String, Object> basBankInfoVoMap);

    /**
     * @Title:
     * @Description: 保存银行账号维护
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/saveBasBankInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasBankInfo(@RequestBody BasBankInfoVo basBankInfoVo);

    /**
     * @Title:
     * @Description:  修改银行账号维护
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/modifyBasBankInfo",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasBankInfo(@RequestBody BasBankInfoVo basBankInfoVo);

    /**
     * @Title:
     * @Description:   根据bankId集合删除银行账号维护
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/deleteBasBankInfosByBankIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasBankInfosByBankIds(@RequestBody BasBankInfoVo basBankInfoVo);

    /**
     * @Title:
     * @Description:  根据bankId获取银行账号维护
     * @param bankId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/findBasBankInfoByBankId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasBankInfoByBankId(@RequestParam("bankId") String bankId,@RequestParam("serviceId") String serviceId);

    /**
     * @Title:
     * @Description: 银行账号审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/approval" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approval(@RequestBody BasBankInfoVo basBankInfoVo);

    /**
     * @Title:
     * @Description: 银行账号维护审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/baseinfo/bas_bank_info/sendBack" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody BasBankInfoVo basBankInfoVo);

}
