package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp.CarCollectCompVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompController
 * @Description: 收车机构维护rpc
 * @date 2018-05-22
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CarCollectCompRpc {

    /**
     * @Title:
     * @Description: 分页查询收车机构维护信息
     * @param carCollectCompVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "api/postbiz/car_collect_comp/findCarCollectCompsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCarCollectCompsByPage(@RequestParam Map<String,Object> carCollectCompVoMap);

    /**
     * @Title:
     * @Description: 保存收车机构维护
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "api/postbiz/car_collect_comp/saveCarCollectComp",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCarCollectComp(@RequestBody CarCollectCompVo carCollectCompVo);

    /**
     * @Title:
     * @Description:  修改收车机构维护
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "api/postbiz/car_collect_comp/modifyCarCollectComp",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyCarCollectComp(@RequestBody CarCollectCompVo carCollectCompVo);

    /**
     * @Title:
     * @Description:   根据carCollectCompId集合删除收车机构维护
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "api/postbiz/car_collect_comp/deleteCarCollectCompsByCarCollectCompIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteCarCollectCompsByCarCollectCompIds(@RequestBody CarCollectCompVo carCollectCompVo);

    /**
     * @Title:
     * @Description:  根据carCollectCompId获取收车机构维护
     * @param carCollectCompId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "api/postbiz/car_collect_comp/findCarCollectCompByCarCollectCompId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCarCollectCompByCarCollectCompId(@RequestParam("carCollectCompId") String carCollectCompId);

}
