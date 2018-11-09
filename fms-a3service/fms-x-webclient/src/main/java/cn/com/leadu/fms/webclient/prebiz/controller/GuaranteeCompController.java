package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.GuaranteeCompRpc;
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
 * @ClassName: GuaranteeCompController
 * @Description: 担保企业信息controller
 * @date 2018-03-30
 */
@RestController
@RequestMapping("guarantee_comp")
public class GuaranteeCompController {

    /**
     * @Fields  : 担保企业信息rpc
     */
    @Autowired
    private GuaranteeCompRpc guaranteeCompRpc;

    /**
     * @Title:
     * @Description: 分页查询担保企业信息信息
     * @param guaranteeCompVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "findGuaranteeCompsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteeCompsByPage(GuaranteeCompVo guaranteeCompVo){
        Map guaranteeCompVoMap = guaranteeCompVo == null?null:(Map) JSON.toJSON(guaranteeCompVo);
        return guaranteeCompRpc.findGuaranteeCompsByPage(guaranteeCompVoMap);
    }

    /**
     * @Title:
     * @Description: 保存担保企业信息
     * @param guaranteeCompVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "saveGuaranteeComp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGuaranteeComp(@RequestBody GuaranteeCompVo guaranteeCompVo){
        return guaranteeCompRpc.saveGuaranteeComp(guaranteeCompVo);
    }

    /**
     * @Title:
     * @Description:  修改担保企业信息
     * @param guaranteeCompVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "modifyGuaranteeComp",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGuaranteeComp(@RequestBody GuaranteeCompVo guaranteeCompVo){
        return guaranteeCompRpc.modifyGuaranteeComp(guaranteeCompVo);
    }

    /**
     * @Title:
     * @Description:   根据guarCompId集合删除担保企业信息
     * @param guarCompIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "deleteGuaranteeCompsByGuarCompIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteeCompsByGuarCompIds(@RequestBody List<String> guarCompIds){
        GuaranteeCompVo guaranteeCompVo = new GuaranteeCompVo();
        guaranteeCompVo.setGuarCompIds(guarCompIds);
        return guaranteeCompRpc.deleteGuaranteeCompsByGuarCompIds(guaranteeCompVo);
    }

    /**
     * @Title:
     * @Description:  根据guarCompId获取担保企业信息
     * @param guarCompId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "findGuaranteeCompByGuarCompId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteeCompByGuarCompId(String guarCompId){
        return guaranteeCompRpc.findGuaranteeCompByGuarCompId(guarCompId);
    }

}
