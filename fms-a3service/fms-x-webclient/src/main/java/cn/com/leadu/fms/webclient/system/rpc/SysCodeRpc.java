package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeController
 * @Description: 字典数数值rpc
 * @date 2018-03-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysCodeRpc {

    /**
     * @Title:
     * @Description: 分页查询字典数数值信息
     * @param sysCodeVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/findSysCodesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysCodesByPage(@RequestParam Map<String, Object> sysCodeVoMap);

    /**
     * @Title:
     * @Description: 保存字典数数值
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/saveSysCode",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysCode(@RequestBody SysCodeVo sysCodeVo);

    /**
     * @Title:
     * @Description: 根据codeValue和codeType查询
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/findSysCodeByCodeValue",method = RequestMethod.POST)
    ResponseEntity<RestResponse> findSysCodeByCodeValue(@RequestBody SysCodeVo sysCodeVo);

    /**
     * @Title:
     * @Description:  修改字典数数值
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/modifySysCode",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysCode(@RequestBody SysCodeVo sysCodeVo);

    /**
     * @Title:
     * @Description:  根据codeValueId获取字典数数值
     * @param codeValueId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/findSysCodeByCodeValueId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysCodeByCodeValueId(@RequestParam("codeValueId") String codeValueId);

    /**
     * @Title:
     * @Description:   根据codeValueId集合删除字典数数值
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "api/system/sys_code/deleteSysCodeByCodeValueIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysCodeByCodeValueIds(@RequestBody SysCodeVo sysCodeVo);

    /**
     * @Title:
     * @Description:   获取共通数据字典版本
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:10:56
     */
    @RequestMapping(value = "api/system/sys_code/findCommonCodeValueVersion", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCommonCodeValueVersion();

    /**
     * @Title:
     * @Description:   获取共通数据字典的所有值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:16:54
     */
    @RequestMapping(value = "api/system/sys_code/findCommonCodeValuesAll", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCommonCodeValuesAll();

    /**
     * @Title:
     * @Description:   刷新数据字典
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/03 10:36:59
     */
    @RequestMapping(value = "api/system/sys_code/initCommonCodeValue", method = RequestMethod.GET)
    ResponseEntity<RestResponse> initCommonCodeValue();

}
