package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmPersAddrRpc;
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
 * @ClassName: CstmPersAddrController
 * @Description: 客户个人地址信息controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_addr")
public class CstmPersAddrController {

    /**
     * @Fields  : 客户个人地址信息rpc
     */
    @Autowired
    private CstmPersAddrRpc cstmPersAddrRpc;

    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息信息
     * @param cstmPersAddrVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "findCstmPersAddrsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersAddrsByPage(CstmPersAddrVo cstmPersAddrVo){
        Map cstmPersAddrVoMap = cstmPersAddrVo == null?null:(Map) JSON.toJSON(cstmPersAddrVo);
        return cstmPersAddrRpc.findCstmPersAddrsByPage(cstmPersAddrVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户个人地址信息
     * @param cstmPersAddrVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "saveCstmPersAddr",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmPersAddr(@RequestBody CstmPersAddrVo cstmPersAddrVo){
        return cstmPersAddrRpc.saveCstmPersAddr(cstmPersAddrVo);
    }

    /**
     * @Title:
     * @Description:  修改客户个人地址信息
     * @param cstmPersAddrVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "modifyCstmPersAddr",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersAddr(@RequestBody CstmPersAddrVo cstmPersAddrVo){
        return cstmPersAddrRpc.modifyCstmPersAddr(cstmPersAddrVo);
    }

    /**
     * @Title:
     * @Description:   根据persAddrId集合删除客户个人地址信息
     * @param persAddrIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "deleteCstmPersAddrsByPersAddrIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersAddrsByPersAddrIds(@RequestBody List<String> persAddrIds){
        CstmPersAddrVo cstmPersAddrVo = new CstmPersAddrVo();
        cstmPersAddrVo.setPersAddrIds(persAddrIds);
        return cstmPersAddrRpc.deleteCstmPersAddrsByPersAddrIds(cstmPersAddrVo);
    }

    /**
     * @Title:
     * @Description:  根据persAddrId获取客户个人地址信息
     * @param persAddrId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @RequestMapping(value = "findCstmPersAddrByPersAddrId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersAddrByPersAddrId(String persAddrId){
        return cstmPersAddrRpc.findCstmPersAddrByPersAddrId(persAddrId);
    }

}
