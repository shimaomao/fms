package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcontact.CstmContactVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmContactRpc;
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
 * @ClassName: CstmContactController
 * @Description: 客户联系人信息controller
 * @date 2018-03-27
 */
@RestController
@RequestMapping("cstm_contact")
public class CstmContactController {

    /**
     * @Fields  : 客户联系人信息rpc
     */
    @Autowired
    private CstmContactRpc cstmContactRpc;

    /**
     * @Title:
     * @Description: 分页查询客户联系人信息信息
     * @param cstmContactVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findCstmContactsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmContactsByPage(CstmContactVo cstmContactVo){
        Map cstmContactVoMap = cstmContactVo == null?null:(Map) JSON.toJSON(cstmContactVo);
        return cstmContactRpc.findCstmContactsByPage(cstmContactVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户联系人信息
     * @param cstmContactVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "saveCstmContact",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmContact(@RequestBody CstmContactVo cstmContactVo){
        return cstmContactRpc.saveCstmContact(cstmContactVo);
    }

    /**
     * @Title:
     * @Description:  修改客户联系人信息
     * @param cstmContactVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "modifyCstmContact",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmContact(@RequestBody CstmContactVo cstmContactVo){
        return cstmContactRpc.modifyCstmContact(cstmContactVo);
    }

    /**
     * @Title:
     * @Description:   根据contactId集合删除客户联系人信息
     * @param contactIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "deleteCstmContactsByContactIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmContactsByContactIds(@RequestBody List<String> contactIds){
        CstmContactVo cstmContactVo = new CstmContactVo();
        cstmContactVo.setContactIds(contactIds);
        return cstmContactRpc.deleteCstmContactsByContactIds(cstmContactVo);
    }

    /**
     * @Title:
     * @Description:  根据contactId获取客户联系人信息
     * @param contactId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findCstmContactByContactId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmContactByContactId(String contactId){
        return cstmContactRpc.findCstmContactByContactId(contactId);
    }

}
