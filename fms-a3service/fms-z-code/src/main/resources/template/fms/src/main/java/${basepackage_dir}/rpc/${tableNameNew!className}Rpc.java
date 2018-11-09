<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll}.${tableNameNew!className}Vo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Controller
 * @Description: ${servicename}rpc
 */
@FeignClient("${r'${fms.feigns.serverNames.fmsAgent}'}")
public interface ${tableNameNew!className}Rpc {

    /**
     * @Title:
     * @Description: 分页查询${servicename}信息
     * @param ${tableNameNewLowerCase!classNameLower}VoMap
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "api/${servername}/${table.sqlName}/find${tableNameNew!className}sByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> find${tableNameNew!className}sByPage(@RequestParam Map<String,Object> ${tableNameNewLowerCase!classNameLower}VoMap);

    /**
     * @Title:
     * @Description: 保存${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "api/${servername}/${table.sqlName}/save${tableNameNew!className}",method = RequestMethod.POST)
    ResponseEntity<RestResponse> save${tableNameNew!className}(@RequestBody ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo);

    /**
     * @Title:
     * @Description:  修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "api/${servername}/${table.sqlName}/modify${tableNameNew!className}",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modify${tableNameNew!className}(@RequestBody ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo);

    /**
     * @Title:
     * @Description:   根据${pkColumnFirstLower}集合删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "api/${servername}/${table.sqlName}/delete${tableNameNew!className}sBy${pkColumn}s" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> delete${tableNameNew!className}sBy${pkColumn}s(@RequestBody ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo);

    /**
     * @Title:
     * @Description:  根据${pkColumnFirstLower}获取${servicename}
     * @param ${pkColumnFirstLower}
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "api/${servername}/${table.sqlName}/find${tableNameNew!className}By${pkColumn}", method = RequestMethod.GET)
    ResponseEntity<RestResponse> find${tableNameNew!className}By${pkColumn}(@RequestParam("${pkColumnFirstLower}") String ${pkColumnFirstLower});

}
