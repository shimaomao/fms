package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.GuaranteePersRpc;
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
 * @ClassName: GuaranteePersController
 * @Description: 担保个人信息controller
 * @date 2018-03-30
 */
@RestController
@RequestMapping("guarantee_pers")
public class GuaranteePersController {

    /**
     * @Fields  : 担保个人信息rpc
     */
    @Autowired
    private GuaranteePersRpc guaranteePersRpc;

    /**
     * @Title:
     * @Description: 分页查询担保个人信息信息
     * @param guaranteePersVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "findGuaranteePerssByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteePerssByPage(GuaranteePersVo guaranteePersVo){
        Map guaranteePersVoMap = guaranteePersVo == null?null:(Map) JSON.toJSON(guaranteePersVo);
        return guaranteePersRpc.findGuaranteePerssByPage(guaranteePersVoMap);
    }

    /**
     * @Title:
     * @Description: 保存担保个人信息
     * @param guaranteePersVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "saveGuaranteePers",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGuaranteePers(@RequestBody GuaranteePersVo guaranteePersVo){
        return guaranteePersRpc.saveGuaranteePers(guaranteePersVo);
    }

    /**
     * @Title:
     * @Description:  修改担保个人信息
     * @param guaranteePersVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "modifyGuaranteePers",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGuaranteePers(@RequestBody GuaranteePersVo guaranteePersVo){
        return guaranteePersRpc.modifyGuaranteePers(guaranteePersVo);
    }

    /**
     * @Title:
     * @Description:   根据guarPersId集合删除担保个人信息
     * @param guarPersIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "deleteGuaranteePerssByGuarPersIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteePerssByGuarPersIds(@RequestBody List<String> guarPersIds){
        GuaranteePersVo guaranteePersVo = new GuaranteePersVo();
        guaranteePersVo.setGuarPersIds(guarPersIds);
        return guaranteePersRpc.deleteGuaranteePerssByGuarPersIds(guaranteePersVo);
    }

    /**
     * @Title:
     * @Description:  根据guarPersId获取担保个人信息
     * @param guarPersId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "findGuaranteePersByGuarPersId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteePersByGuarPersId(String guarPersId){
        return guaranteePersRpc.findGuaranteePersByGuarPersId(guarPersId);
    }

}
