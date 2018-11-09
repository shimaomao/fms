package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huchenghao
 * @ClassName: ContCreateRpc
 * @Description: 生成合同rpc
 * @date 2018-03-24
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContCreateRpc {

    /**
     * @Title:
     * @Description: 根据contactNo获取客户联系人信息
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 16:18:12
     */

    @RequestMapping(value = "api/prebiz/cont_create/findContCreateByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContCreateByContNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description: 根据contactNo获取客户联系人信息
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 16:18:12
     */

    @RequestMapping(value = "api/prebiz/cont_create/findContCreateDetailByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContCreateDetailByContNo(@RequestParam("contNo") String contNo);
    /**
     * @Title:
     * @Description: 根据contactNo获取客户联系人信息
     * @param contCreateVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 16:18:12
     */
    @RequestMapping(value = "api/prebiz/cont_create/saveContCreate",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContCreate(@RequestBody ContCreateVo contCreateVo);

    /**
    * @Description: 取消合同
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 18:35
    */
    @RequestMapping(value = "api/prebiz/cont_create/cancelContCreate",method = RequestMethod.POST)
    ResponseEntity<RestResponse> cancelContCreate(@RequestBody ContCreateVo contCreateVo);
}
