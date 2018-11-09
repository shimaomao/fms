package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailController
 * @Description: 资方抵押明细rpc
 * @date 2018-05-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquMorDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询资方抵押明细信息(申请)
     * @param equMorDetailVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/findEquMorDetailVos" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorDetailVos(@RequestParam Map<String, Object> equMorDetailVoMap);

    /**
     * @Title:
     * @Description: 分页查询资方抵押明细信息(复审)
     * @param equMorDetailVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/findEquMorDetailVoList" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorDetailVoList(@RequestParam Map<String, Object> equMorDetailVoMap);

    /**
     * @Title:
     * @Description: 保存资方抵押明细
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/saveEquMorDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  资方抵押解除申请(初次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/applyEquMorDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> applyEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  资方抵押解除申请(再次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/modifyEquMorDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:   根据equMorDetailId集合删除资方抵押明细
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/deleteEquMorDetailsByEquMorDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteEquMorDetailsByEquMorDetailIds(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description: 资方抵押明细信息一览
     * @param equMorDetailVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/findEquMorDetailVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorDetailVosByPage(@RequestParam Map<String, Object> equMorDetailVoMap);

    /**
     * @Title:
     * @Description:  退回上一级
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/sendBack",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  复核通过
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/approvalToVoucher",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approvalToVoucher(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  制单
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/approvalVoucher",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approvalVoucher(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  财务付款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/approvalFinance",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approvalFinance(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  财务确认收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/approvalReceipt",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approvalReceipt(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:  确认解抵押
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/approvalConfirm",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approvalConfirm(@RequestBody EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/asset/equ_mor_detail/printEquRel",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printEquRel(EquMorDetailVo equMorDetailVo);


}
