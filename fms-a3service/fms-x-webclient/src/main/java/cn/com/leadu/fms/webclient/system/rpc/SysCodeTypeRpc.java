package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeController
 * @Description: 字典数据类型rpc
 * @date 2018-03-08
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysCodeTypeRpc {

    /**
     * @Title:
     * @Description: 分页查询字典数据类型信息
     * @param sysCodeTypeVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/findSysCodeTypesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysCodeTypesByPage(@RequestParam Map<String, Object> sysCodeTypeVoMap);

    /**
     * @Title:
     * @Description: 保存字典数据类型
     * @param sysCodeTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/saveSysCodeType",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysCodeType(@RequestBody SysCodeTypeVo sysCodeTypeVo);

    /**
     * @Title:
     * @Description:  修改字典数据类型
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/modifySysCodeType",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysCodeType(@RequestBody SysCodeTypeVo sysCodeTypeVo);

    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeType
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/findSysCodeTypeByCodeType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysCodeTypeByCodeType(@RequestParam("codeType") String codeType);
    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeTypeId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/findSysCodeTypeById", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysCodeTypeById(@RequestParam("codeTypeId") String codeTypeId);

    /**
     * @Title:
     * @Description:   根据id集合删除字典数据类型
     * @param sysCodeTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "api/system/sys_code_type/deleteSysCodeTypeByIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysCodeTypeByIds(@RequestBody SysCodeTypeVo sysCodeTypeVo);

}
