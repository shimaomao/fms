package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainController
 * @Description: 车辆维修记录rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface VehMaintainRpc {

    /**
     * @Title:
     * @Description: 分页查询车辆维修记录信息
     * @param vehMaintainVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/findVehMaintainsVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findVehMaintainsVosByPage(@RequestParam Map<String,Object> vehMaintainVoMap);

    /**
     * @Title:
     * @Description: 保存车辆维修记录
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/saveVehMaintain",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveVehMaintain(@RequestBody VehMaintainVo vehMaintainVo);

    /**
     * @Title:
     * @Description: 修改车辆维修记录
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/modifyVehMaintain",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyVehMaintain(@RequestBody VehMaintainVo vehMaintainVo);
    /**
     * @Title:
     * @Description:  根据vehMaintainId获取车辆维修记录
     * @param vehMaintainId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/findVehMaintainVoByVehMaintainId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findVehMaintainVoByVehMaintainId(@RequestParam("vehMaintainId") String vehMaintainId);


    /**
     * @Title:
     * @Description:  导入维修记录数据
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/importVehMaintainsByExcel", method = RequestMethod.POST)
    ResponseEntity<RestResponse> importVehMaintainsByExcel(@RequestParam("filePath") String filePath);


    /**
     * @Title:
     * @Description:  下载维修记录模版
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:07
     */
    @RequestMapping(value = "api/postbiz/veh_maintain/exportVehMaintainModalExcel", method = RequestMethod.GET)
    Response exportVehMaintainModalExcel();
}
