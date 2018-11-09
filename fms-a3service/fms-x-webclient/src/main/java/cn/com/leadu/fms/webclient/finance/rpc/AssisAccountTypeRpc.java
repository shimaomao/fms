package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeController
 * @Description: 辅助核算类型管理rpc
 * @date 2018-06-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface AssisAccountTypeRpc {

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理信息
     * @param assisAccountTypeVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "api/finance/assis_account_type/findAssisAccountTypesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAssisAccountTypesByPage(@RequestParam Map<String, Object> assisAccountTypeVoMap);

    /**
     * @Title:
     * @Description: 保存辅助核算类型管理
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "api/finance/assis_account_type/saveAssisAccountType",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveAssisAccountType(@RequestBody AssisAccountTypeVo assisAccountTypeVo);

    /**
     * @Title:
     * @Description:  修改辅助核算类型管理
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "api/finance/assis_account_type/modifyAssisAccountType",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyAssisAccountType(@RequestBody AssisAccountTypeVo assisAccountTypeVo);

    /**
     * @Title:
     * @Description:   根据assisAccountTypeId集合删除辅助核算类型管理
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "api/finance/assis_account_type/deleteAssisAccountTypesByAssisAccountTypeIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteAssisAccountTypesByAssisAccountTypeIds(@RequestBody AssisAccountTypeVo assisAccountTypeVo);

    /**
     * @Title:
     * @Description:  根据assisAccountTypeId获取辅助核算类型管理
     * @param assisAccountTypeId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "api/finance/assis_account_type/findAssisAccountTypeByAssisAccountTypeId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAssisAccountTypeByAssisAccountTypeId(@RequestParam("assisAccountTypeId") String assisAccountTypeId);

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理信息弹出框
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/finance/assis_account_type/findAssisAccountTypesByPage2" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAssisAccountTypesByPage2(@RequestParam Map<String, Object> assisAccountTypeVoMap);

}
