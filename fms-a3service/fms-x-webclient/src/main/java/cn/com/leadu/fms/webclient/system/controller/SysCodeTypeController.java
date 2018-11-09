package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import cn.com.leadu.fms.webclient.system.rpc.SysCodeTypeRpc;
import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeController
 * @Description: 字典数据类型controller
 * @date 2018-03-08
 */
@RestController
@RequestMapping("sys_code_type")
public class SysCodeTypeController {

    @Autowired
    private SysCodeTypeRpc sysCodeTypeRpc;

    /**
     * @Title:
     * @Description: 分页查询字典数据类型信息
     * @param sysCodeTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "findSysCodeTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysOrganizationPropertyByPage(SysCodeTypeVo sysCodeTypeVo){
        Map sysCodeTypeVoMap = sysCodeTypeVo == null?null:(Map) JSON.toJSON(sysCodeTypeVo);
        return sysCodeTypeRpc.findSysCodeTypesByPage(sysCodeTypeVoMap);
    }
    /**
     * @Title:
     * @Description: 保存字典数据类型
     * @param sysCodeTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "saveSysCodeType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysCodeType(@RequestBody SysCodeTypeVo sysCodeTypeVo){
        return sysCodeTypeRpc.saveSysCodeType(sysCodeTypeVo);
    }

    /**
     * @Title:
     * @Description:  修改字典数据类型
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "modifySysCodeType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysCodeType(@RequestBody SysCodeTypeVo sysCodeTypeVo){
        return sysCodeTypeRpc.modifySysCodeType(sysCodeTypeVo);
    }

    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeTypeId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "findSysCodeTypeById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeTypeById(String codeTypeId){
        return sysCodeTypeRpc.findSysCodeTypeById(codeTypeId);
    }

    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeType
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "findSysCodeTypeByCodeType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeTypeByCodeType(String codeType){
        return sysCodeTypeRpc.findSysCodeTypeByCodeType(codeType);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除字典数据类型
     * @param ids
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @RequestMapping(value = "deleteSysCodeTypeByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCodeTypeByIds(@RequestBody List<String> ids){
        SysCodeTypeVo sysCodeTypeVo = new SysCodeTypeVo();
        sysCodeTypeVo.setCodeTypeIds(ids);
        return sysCodeTypeRpc.deleteSysCodeTypeByIds(sysCodeTypeVo);
    }

}
