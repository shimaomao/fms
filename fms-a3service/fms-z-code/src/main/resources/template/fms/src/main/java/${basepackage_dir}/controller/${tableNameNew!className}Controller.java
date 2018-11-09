<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package ${basepackage}.${servername}.controller;

import ${basepackage}.extend.response.ResponseEnums;
import ${basepackage}.extend.response.RestResponse;
import ${basepackage}.extend.response.RestResponseGenerator;
import ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll}.${tableNameNew!className}Vo;
import ${basepackage}.${servername}.service.${tableNameNew!className}Service;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Controller
 * @Description: ${servicename}相关接口
 */
@RestController
@RequestMapping("${table.sqlName}")
public class ${tableNameNew!className}Controller {

    /**
     * @Fields  : ${servicename}service
     */
    @Autowired
    private ${tableNameNew!className}Service ${tableNameNewLowerCase!classNameLower}Service;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(${tableNameNewLowerCase!classNameLower}Service.find${tableNameNew!className}sByPage(${tableNameNewLowerCase!classNameLower}Vo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}SaveVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "save${tableNameNew!className}",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> save${tableNameNew!className}(@Valid @RequestBody ${tableNameNew!className}SaveVo ${tableNameNewLowerCase!classNameLower}SaveVo){
        ${tableNameNewLowerCase!classNameLower}Service.save${tableNameNew!className}(${tableNameNewLowerCase!classNameLower}SaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}ModifyVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "modify${tableNameNew!className}",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modify${tableNameNew!className}(@Valid @RequestBody ${tableNameNew!className}ModifyVo ${tableNameNewLowerCase!classNameLower}ModifyVo){
        ${tableNameNewLowerCase!classNameLower}Service.modify${tableNameNew!className}(${tableNameNewLowerCase!classNameLower}ModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}DeleteVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "delete${tableNameNew!className}",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> delete${tableNameNew!className}(@Valid @RequestBody ${tableNameNew!className}DeleteVo ${tableNameNewLowerCase!classNameLower}DeleteVo){
        ${tableNameNewLowerCase!classNameLower}Service.delete${tableNameNew!className}(${tableNameNewLowerCase!classNameLower}DeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据${pkColumnFirstLower}集合删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}DeleteListVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @RequestMapping(value = "delete${tableNameNew!className}sBy${pkColumn}s" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> delete${tableNameNew!className}sBy${pkColumn}s(@Valid @RequestBody ${tableNameNew!className}DeleteListVo ${tableNameNewLowerCase!classNameLower}DeleteListVo){
        ${tableNameNewLowerCase!classNameLower}Service.delete${tableNameNew!className}sBy${pkColumn}s(${tableNameNewLowerCase!classNameLower}DeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(${tableNameNewLowerCase!classNameLower}Service.find${tableNameNew!className}By${pkColumn}(${pkColumnFirstLower})), HttpStatus.OK);
    }

}
