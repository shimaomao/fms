package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.crmperson.CrmPersonVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CrmPersonRpc;
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
 * @ClassName: CrmPersonController
 * @Description: CRM个人信息controller
 * @date 2018-05-23
 */
@RestController
@RequestMapping("crm_person")
public class CrmPersonController {

    /**
     * @Fields  : CRM个人信息rpc
     */
    @Autowired
    private CrmPersonRpc crmPersonRpc;

    /**
     * @Title:
     * @Description: 分页查询CRM个人信息信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "findCrmPersonsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonsByPage(CrmPersonVo crmPersonVo){
        Map crmPersonVoMap = crmPersonVo == null?null:(Map) JSON.toJSON(crmPersonVo);
        return crmPersonRpc.findCrmPersonsByPage(crmPersonVoMap);
    }

    /**
     * @Title:
     * @Description: 保存CRM个人信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "saveCrmPerson",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCrmPerson(@RequestBody CrmPersonVo crmPersonVo){
        return crmPersonRpc.saveCrmPerson(crmPersonVo);
    }

    /**
     * @Title:
     * @Description:  修改CRM个人信息
     * @param crmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "modifyCrmPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCrmPerson(@RequestBody CrmPersonVo crmPersonVo){
        return crmPersonRpc.modifyCrmPerson(crmPersonVo);
    }

    /**
     * @Title:
     * @Description:   根据personId集合删除CRM个人信息
     * @param personIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "deleteCrmPersonsByPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCrmPersonsByPersonIds(@RequestBody List<String> personIds){
        CrmPersonVo crmPersonVo = new CrmPersonVo();
        crmPersonVo.setPersonIds(personIds);
        return crmPersonRpc.deleteCrmPersonsByPersonIds(crmPersonVo);
    }

    /**
     * @Title:
     * @Description:  根据personId获取CRM个人信息
     * @param personId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "findCrmPersonByPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonByPersonId(String personId){
        return crmPersonRpc.findCrmPersonByPersonId(personId);
    }

    /**
     * @Title:
     * @Description:  根据证件号码获取CRM个人信息
     * @param certifNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 17:28:08
     */
    @RequestMapping(value = "findCrmPersonByCertifNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCrmPersonByCertifNo(String certifNo){
        return crmPersonRpc.findCrmPersonByCertifNo(certifNo);
    }

}
