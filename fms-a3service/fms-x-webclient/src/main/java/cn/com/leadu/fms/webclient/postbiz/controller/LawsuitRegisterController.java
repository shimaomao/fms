package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.LawsuitRegisterRpc;
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
 * @author lijunjun
 * @ClassName: LawsuitRegisterController
 * @Description: 诉讼登记信息controller
 */
@RestController
@RequestMapping("lawsuit_register")
public class LawsuitRegisterController {

    /**
     * @Fields  : 诉讼登记信息rpc
     */
    @Autowired
    private LawsuitRegisterRpc lawsuitRegisterRpc;

    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "findLawsuitRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegistersByPage(LawsuitRegisterVo lawsuitRegisterVo){
        Map lawsuitRegisterVoMap = lawsuitRegisterVo == null?null:(Map) JSON.toJSON(lawsuitRegisterVo);
        return lawsuitRegisterRpc.findLawsuitRegistersByPage(lawsuitRegisterVoMap);
    }

    /**
     * @Title:
     * @Description: 保存诉讼登记信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "saveLawsuitRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLawsuitRegister(@RequestBody LawsuitRegisterVo lawsuitRegisterVo){
        return lawsuitRegisterRpc.saveLawsuitRegister(lawsuitRegisterVo);
    }

    /**
     * @Title:
     * @Description:  修改诉讼登记信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "modifyLawsuitRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLawsuitRegister(@RequestBody LawsuitRegisterVo lawsuitRegisterVo){
        return lawsuitRegisterRpc.modifyLawsuitRegister(lawsuitRegisterVo);
    }

    /**
     * @Title:
     * @Description:   根据lawsuitRegisterId集合删除诉讼登记信息
     * @param lawsuitRegisterIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "deleteLawsuitRegistersByLawsuitRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLawsuitRegistersByLawsuitRegisterIds(@RequestBody List<String> lawsuitRegisterIds){
        LawsuitRegisterVo lawsuitRegisterVo = new LawsuitRegisterVo();
        lawsuitRegisterVo.setLawsuitRegisterIds(lawsuitRegisterIds);
        return lawsuitRegisterRpc.deleteLawsuitRegistersByLawsuitRegisterIds(lawsuitRegisterVo);
    }

    /**
     * @Title:
     * @Description:  根据lawsuitRegisterId获取诉讼登记信息
     * @param lawsuitRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "findLawsuitRegisterByLawsuitRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegisterByLawsuitRegisterId(String lawsuitRegisterId){
        return lawsuitRegisterRpc.findLawsuitRegisterByLawsuitRegisterId(lawsuitRegisterId);
    }

}
