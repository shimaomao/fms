package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContCreateRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huchenghao
 * @ClassName: ContCreateController
 * @Description: 合同生成controller
 * @date 2018-03-30
 */
@RestController
@RequestMapping("cont_create")
public class ContCreateController {

    /**
     * @Fields  : 合同生成rpc
     */
    @Autowired
    private ContCreateRpc contCreateRpc;


    /**
     * @Title:
     * @Description:  根据contactNo获取客户联系人信息
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findContCreateByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContCreateByContNo(String contNo){
        return contCreateRpc.findContCreateByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:  根据contactNo获取详情
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "findContCreateDetailByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContCreateDetailByContNo(String contNo){
        return contCreateRpc.findContCreateDetailByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:  生成合同信息
     * @param contCreateVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:56:43
     */
    @RequestMapping(value = "saveContCreate", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContCreate(@Valid @RequestBody ContCreateVo contCreateVo){
        return contCreateRpc.saveContCreate(contCreateVo);
    }

    /**
    * @Description: 取消合同
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 18:35
    */
    @RequestMapping(value = "cancelContCreate", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelContCreate(@RequestBody ContCreateVo contCreateVo){
        return contCreateRpc.cancelContCreate(contCreateVo);
    }


}
