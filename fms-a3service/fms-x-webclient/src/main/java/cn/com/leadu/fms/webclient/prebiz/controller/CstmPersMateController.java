package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmPersMateRpc;
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
 * @ClassName: CstmPersMateController
 * @Description: 客户个人配偶信息controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_mate")
public class CstmPersMateController {

    /**
     * @Fields  : 客户个人配偶信息rpc
     */
    @Autowired
    private CstmPersMateRpc cstmPersMateRpc;

    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息信息
     * @param cstmPersMateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "findCstmPersMatesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersMatesByPage(CstmPersMateVo cstmPersMateVo){
        Map cstmPersMateVoMap = cstmPersMateVo == null?null:(Map) JSON.toJSON(cstmPersMateVo);
        return cstmPersMateRpc.findCstmPersMatesByPage(cstmPersMateVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户个人配偶信息
     * @param cstmPersMateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "saveCstmPersMate",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmPersMate(@RequestBody CstmPersMateVo cstmPersMateVo){
        return cstmPersMateRpc.saveCstmPersMate(cstmPersMateVo);
    }

    /**
     * @Title:
     * @Description:  修改客户个人配偶信息
     * @param cstmPersMateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "modifyCstmPersMate",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersMate(@RequestBody CstmPersMateVo cstmPersMateVo){
        return cstmPersMateRpc.modifyCstmPersMate(cstmPersMateVo);
    }

    /**
     * @Title:
     * @Description:   根据persMateId集合删除客户个人配偶信息
     * @param persMateIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "deleteCstmPersMatesByPersMateIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersMatesByPersMateIds(@RequestBody List<String> persMateIds){
        CstmPersMateVo cstmPersMateVo = new CstmPersMateVo();
        cstmPersMateVo.setPersMateIds(persMateIds);
        return cstmPersMateRpc.deleteCstmPersMatesByPersMateIds(cstmPersMateVo);
    }

    /**
     * @Title:
     * @Description:  根据persMateId获取客户个人配偶信息
     * @param persMateId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "findCstmPersMateByPersMateId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersMateByPersMateId(String persMateId){
        return cstmPersMateRpc.findCstmPersMateByPersMateId(persMateId);
    }

    /**
     * @Title:
     * @Description:  续保任务登记TEST
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @RequestMapping(value = "insuranceRenewalTask", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> insuranceRenewalTask(){
        return cstmPersMateRpc.insuranceRenewalTask();
    }

}
