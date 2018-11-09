package cn.com.leadu.fms.webclient.asset.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepay.EquMorRepayVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: EquMorRepayController
 * @Description: 资方抵押还款计划rpc
 * @date 2018-05-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface EquMorRepayRpc {

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划信息
     * @param equMorRepayVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    @RequestMapping(value = "api/asset/equ_mor_repay/findEquMorRepaysByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorRepaysByPage(@RequestParam Map<String, Object> equMorRepayVoMap);

    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepayVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    @RequestMapping(value = "api/asset/equ_mor_repay/saveEquMorRepay",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveEquMorRepay(@RequestBody EquMorRepayVo equMorRepayVo);

    /**
     * @Title:
     * @Description:  修改资方抵押还款计划
     * @param equMorRepayVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    @RequestMapping(value = "api/asset/equ_mor_repay/modifyEquMorRepay",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyEquMorRepay(@RequestBody EquMorRepayVo equMorRepayVo);

    /**
     * @Title:
     * @Description:   根据equMorRepayId集合删除资方抵押还款计划
     * @param equMorRepayVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    @RequestMapping(value = "api/asset/equ_mor_repay/deleteEquMorRepaysByEquMorRepayIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteEquMorRepaysByEquMorRepayIds(@RequestBody EquMorRepayVo equMorRepayVo);

    /**
     * @Title:
     * @Description:  根据equMorRepayId获取资方抵押还款计划
     * @param equMorRepayId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:57:36
     */
    @RequestMapping(value = "api/asset/equ_mor_repay/findEquMorRepayByEquMorRepayId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findEquMorRepayByEquMorRepayId(@RequestParam("equMorRepayId") String equMorRepayId);

}
