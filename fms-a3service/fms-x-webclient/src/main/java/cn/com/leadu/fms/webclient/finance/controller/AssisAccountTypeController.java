package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import cn.com.leadu.fms.webclient.finance.rpc.AssisAccountTypeRpc;
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
 * @author ningyangyang
 * @ClassName: AssisAccountTypeController
 * @Description: 辅助核算类型管理controller
 * @date 2018-06-23
 */
@RestController
@RequestMapping("assis_account_type")
public class AssisAccountTypeController {

    /**
     * @Fields  : 辅助核算类型管理rpc
     */
    @Autowired
    private AssisAccountTypeRpc assisAccountTypeRpc;

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理信息
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "findAssisAccountTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypesByPage(AssisAccountTypeVo assisAccountTypeVo){
        Map assisAccountTypeVoMap = assisAccountTypeVo == null?null:(Map) JSON.toJSON(assisAccountTypeVo);
        return assisAccountTypeRpc.findAssisAccountTypesByPage(assisAccountTypeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存辅助核算类型管理
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "saveAssisAccountType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveAssisAccountType(@RequestBody AssisAccountTypeVo assisAccountTypeVo){
        return assisAccountTypeRpc.saveAssisAccountType(assisAccountTypeVo);
    }

    /**
     * @Title:
     * @Description:  修改辅助核算类型管理
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "modifyAssisAccountType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyAssisAccountType(@RequestBody AssisAccountTypeVo assisAccountTypeVo){
        return assisAccountTypeRpc.modifyAssisAccountType(assisAccountTypeVo);
    }

    /**
     * @Title:
     * @Description:   根据assisAccountTypeId集合删除辅助核算类型管理
     * @param assisAccountTypeIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "deleteAssisAccountTypesByAssisAccountTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteAssisAccountTypesByAssisAccountTypeIds(@RequestBody List<String> assisAccountTypeIds){
        AssisAccountTypeVo assisAccountTypeVo = new AssisAccountTypeVo();
        assisAccountTypeVo.setAssisAccountTypeIds(assisAccountTypeIds);
        return assisAccountTypeRpc.deleteAssisAccountTypesByAssisAccountTypeIds(assisAccountTypeVo);
    }

    /**
     * @Title:
     * @Description:  根据assisAccountTypeId获取辅助核算类型管理
     * @param assisAccountTypeId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    @RequestMapping(value = "findAssisAccountTypeByAssisAccountTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypeByAssisAccountTypeId(String assisAccountTypeId){
        return assisAccountTypeRpc.findAssisAccountTypeByAssisAccountTypeId(assisAccountTypeId);
    }

   /**
    * @Title:
    * @Description: 分页查询辅助核算类型管理信息弹出框
    * @param
    * @return
    * @throws
    * @author yanfengbo
    * @date
    */
    @RequestMapping(value = "findAssisAccountTypesByPage2" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypesByPage2(AssisAccountTypeVo assisAccountTypeVo){
        Map assisAccountTypeVoMap = assisAccountTypeVo == null?null:(Map) JSON.toJSON(assisAccountTypeVo);
        return assisAccountTypeRpc.findAssisAccountTypesByPage2(assisAccountTypeVoMap);
    }

}
