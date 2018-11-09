package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailController
 * @Description: 资方抵押还款计划rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquMorRepayDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划信息
     * @param equMorRepayDetailVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/selectEquMorRepayDetailVosByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse> selectEquMorRepayDetailVosByPage(@RequestParam Map<String,Object> equMorRepayDetailVoMap);


    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/saveEquMorRepayDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorRepayDetail(@RequestBody EquMorRepayDetailVo equMorRepayDetailVo);

    /**
     * @Title:
     * @Description:  修改资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/modifyEquMorRepayDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyEquMorRepayDetail(@RequestBody EquMorRepayDetailVo equMorRepayDetailVo);

    /**
     * @Title:
     * @Description:   根据equMorRepayDetailId集合删除资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/deleteEquMorRepayDetailsByEquMorRepayDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteEquMorRepayDetailsByEquMorRepayDetailIds(@RequestBody EquMorRepayDetailVo equMorRepayDetailVo);

    /**
     * @Title:
     * @Description:  根据equMorRepayDetailId获取资方抵押还款计划
     * @param equMorRepayDetailId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/findEquMorRepayDetailByEquMorRepayDetailId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorRepayDetailByEquMorRepayDetailId(@RequestParam("equMorRepayDetailId") String equMorRepayDetailId);

    /**
     * @Title:
     * @Description:  更新还款状态
     * @param
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "api/asset/equ_mor_repay_detail/updateEquMorRepayDetailPayStatus" , method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<RestResponse> updateEquMorRepayDetailPayStatus(@RequestBody List<EquMorRepayDetail> equMorRepayDetails);

}
