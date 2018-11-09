package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmperson.CstmPersonVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmPersonRpc;
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
 * @ClassName: CstmPersonController
 * @Description: 客户个人基本信息controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_person")
public class CstmPersonController {

    /**
     * @Fields  : 客户个人基本信息rpc
     */
    @Autowired
    private CstmPersonRpc cstmPersonRpc;

    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息信息
     * @param cstmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "findCstmPersonsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonsByPage(CstmPersonVo cstmPersonVo){
        Map cstmPersonVoMap = cstmPersonVo == null?null:(Map) JSON.toJSON(cstmPersonVo);
        return cstmPersonRpc.findCstmPersonsByPage(cstmPersonVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户个人基本信息
     * @param cstmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "saveCstmPerson",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmPerson(@RequestBody CstmPersonVo cstmPersonVo){
        return cstmPersonRpc.saveCstmPerson(cstmPersonVo);
    }

    /**
     * @Title:
     * @Description:  修改客户个人基本信息
     * @param cstmPersonVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "modifyCstmPerson",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPerson(@RequestBody CstmPersonVo cstmPersonVo){
        return cstmPersonRpc.modifyCstmPerson(cstmPersonVo);
    }

    /**
     * @Title:
     * @Description:   根据cstmPersonId集合删除客户个人基本信息
     * @param cstmPersonIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "deleteCstmPersonsByCstmPersonIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersonsByCstmPersonIds(@RequestBody List<String> cstmPersonIds){
        CstmPersonVo cstmPersonVo = new CstmPersonVo();
        cstmPersonVo.setCstmPersonIds(cstmPersonIds);
        return cstmPersonRpc.deleteCstmPersonsByCstmPersonIds(cstmPersonVo);
    }

    /**
     * @Title:
     * @Description:  根据cstmPersonId获取客户个人基本信息
     * @param cstmPersonId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @RequestMapping(value = "findCstmPersonByCstmPersonId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonByCstmPersonId(String cstmPersonId){
        return cstmPersonRpc.findCstmPersonByCstmPersonId(cstmPersonId);
    }

}
