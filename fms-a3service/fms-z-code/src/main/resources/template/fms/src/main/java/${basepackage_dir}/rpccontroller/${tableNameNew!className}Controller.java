<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll}.${tableNameNew!className}Vo;
import ${basepackage}.webclient.${servername}.rpc.${tableNameNew!className}Rpc;
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
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Controller
 * @Description: ${servicename}controller
 */
@RestController
@RequestMapping("${table.sqlName}")
public class ${tableNameNew!className}Controller {

    /**
     * @Fields  : ${servicename}rpc
     */
    @Autowired
    private ${tableNameNew!className}Rpc ${tableNameNewLowerCase!classNameLower}Rpc;

    /**
     * @Title:
     * @Description: 分页查询${servicename}信息
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "find${tableNameNew!className}sByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> find${tableNameNew!className}sByPage(${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo){
        Map ${tableNameNewLowerCase!classNameLower}VoMap = ${tableNameNewLowerCase!classNameLower}Vo == null?null:(Map) JSON.toJSON(${tableNameNewLowerCase!classNameLower}Vo);
        return ${tableNameNewLowerCase!classNameLower}Rpc.find${tableNameNew!className}sByPage(${tableNameNewLowerCase!classNameLower}VoMap);
    }

    /**
     * @Title:
     * @Description: 保存${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "save${tableNameNew!className}",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> save${tableNameNew!className}(@RequestBody ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo){
        return ${tableNameNewLowerCase!classNameLower}Rpc.save${tableNameNew!className}(${tableNameNewLowerCase!classNameLower}Vo);
    }

    /**
     * @Title:
     * @Description:  修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "modify${tableNameNew!className}",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modify${tableNameNew!className}(@RequestBody ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo){
        return ${tableNameNewLowerCase!classNameLower}Rpc.modify${tableNameNew!className}(${tableNameNewLowerCase!classNameLower}Vo);
    }

    /**
     * @Title:
     * @Description:   根据${pkColumnFirstLower}集合删除${servicename}
     * @param ${pkColumnFirstLower}s
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "delete${tableNameNew!className}sBy${pkColumn}s" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> delete${tableNameNew!className}sBy${pkColumn}s(@RequestBody List<String> ${pkColumnFirstLower}s){
        ${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo = new ${tableNameNew!className}Vo();
        ${tableNameNewLowerCase!classNameLower}Vo.set${pkColumn}s(${pkColumnFirstLower}s);
        return ${tableNameNewLowerCase!classNameLower}Rpc.delete${tableNameNew!className}sBy${pkColumn}s(${tableNameNewLowerCase!classNameLower}Vo);
    }

    /**
     * @Title:
     * @Description:  根据${pkColumnFirstLower}获取${servicename}
     * @param ${pkColumnFirstLower}
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "find${tableNameNew!className}By${pkColumn}", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> find${tableNameNew!className}By${pkColumn}(String ${pkColumnFirstLower}){
        return ${tableNameNewLowerCase!classNameLower}Rpc.find${tableNameNew!className}By${pkColumn}(${pkColumnFirstLower});
    }

}
