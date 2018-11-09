package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: BasAreaController
 * @Description: 省市县信息维护rpc
 * @date 2018-03-15
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasAreaRpc {

    /**
     * @Title:
     * @Description: 分页查询省市县信息维护信息
     * @param basAreaVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreasByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreasByPage(@RequestParam Map<String, Object> basAreaVoMap);

    /**
     * @Title:
     * @Description: 保存省市县信息维护
     * @param basAreaVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/baseinfo/bas_area/saveBasArea",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasArea(@RequestBody BasAreaVo basAreaVo);

    /**
     * @Title:
     * @Description:  修改省市县信息维护
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/baseinfo/bas_area/modifyBasArea",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasArea(@RequestBody BasAreaVo basAreaVo);

    /**
     * @Title:
     * @Description:   根据areaId集合删除省市县信息维护
     * @param areaIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/baseinfo/bas_area/deleteBasAreasByAreaIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasAreasByAreaIds(@RequestBody BasAreaVo basAreaVo);

    /**
     * @Title:
     * @Description:  根据areaId获取省市县信息维护
     * @param areaId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreaByAreaId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreaByAreaId(@RequestParam("areaId") String areaId);

    /**
     * @Title:
     * @Description: 返回省市树状 提供给前台页面使用
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:44
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreas", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreas();

    /**
     * @Title:
     * @Description: 查询省市版本值
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreaValuesVersion", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreaValuesVersion();

    /**
     * @Title:
     * @Description: 初始化省市到redis中
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "api/baseinfo/bas_area/initBasAreas", method = RequestMethod.GET)
    ResponseEntity<RestResponse> initBasAreas();

    /**
     * @Title:
     * @Description:   查出所有省市县
     * @return
     * @throws
     * @author niehaibing
     * @date 2018/02/25 01:56:54
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreaByTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreaByTree();

    /**
     * findBasAreaByAreaCode
     */
    @RequestMapping(value = "api/baseinfo/bas_area/findBasAreaByAreaCode", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasAreaByAreaCode(@RequestParam("areaCode") String codeType);

}
