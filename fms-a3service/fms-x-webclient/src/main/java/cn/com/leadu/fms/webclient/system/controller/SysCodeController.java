package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.webclient.system.rpc.SysCodeRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeController
 * @Description: 字典数数值controller
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_code")
public class SysCodeController {

    @Autowired
    private SysCodeRpc sysCodeRpc;

    /**
     * @Title:
     * @Description: 分页查询字典数数值信息
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "findSysCodesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeByPage(SysCodeVo sysCodeVo){
        Map sysCodeVoMap = sysCodeVo == null?null:(Map) JSON.toJSON(sysCodeVo);
        return sysCodeRpc.findSysCodesByPage(sysCodeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存字典数数值
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "saveSysCode",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysCode(@RequestBody SysCodeVo sysCodeVo){
        return sysCodeRpc.saveSysCode(sysCodeVo);
    }

    /**
     * @Title:
     * @Description:  修改字典数数值
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "modifySysCode",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysCode(@RequestBody SysCodeVo sysCodeVo){
        return sysCodeRpc.modifySysCode(sysCodeVo);
    }

    /**
     * @Title:
     * @Description:  根据codeValueId获取字典数数值
     * @param codeValueId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "findSysCodeByCodeValueId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeByCodeValueId(String codeValueId){
        return sysCodeRpc.findSysCodeByCodeValueId(codeValueId);
    }

    /**
     * @Title:
     * @Description:  根据codeValue和codeType查询
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-24 13:46:54
     */
    @RequestMapping(value = "findSysCodeByCodeValue", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findSysCodeByCodeValue(@RequestBody SysCodeVo sysCodeVo){
        return sysCodeRpc.findSysCodeByCodeValue(sysCodeVo);
    }

    /**
     * @Title:
     * @Description:   根据codeValueId集合删除字典数数值
     * @param codeValueIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @RequestMapping(value = "deleteSysCodeByCodeValueIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCodeByCodeValueIds(@RequestBody List<String> codeValueIds){
        SysCodeVo sysCodeVo = new SysCodeVo();
        sysCodeVo.setCodeValueIds(codeValueIds);
        return sysCodeRpc.deleteSysCodeByCodeValueIds(sysCodeVo);
    }

    /**
     * @Title:
     * @Description:   获取共通数据字典版本
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:10:56
     */
    @RequestMapping(value = "findCommonCodeValueVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValueVersion(){
        return sysCodeRpc.findCommonCodeValueVersion();
    }

    /**
     * @Title:
     * @Description:   获取共通数据字典的所有值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:16:54
     */
    @RequestMapping(value = "findCommonCodeValuesAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValuesAll(){
        return sysCodeRpc.findCommonCodeValuesAll();
    }

    /**
     * @Title:
     * @Description:   刷新数据字典
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/03 10:36:59
     */
    @RequestMapping(value = "initCommonCodeValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initCommonCodeValue(){
        return sysCodeRpc.initCommonCodeValue();
    }

}
