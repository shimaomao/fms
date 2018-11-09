package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasVehicleRpc;
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
 * @author niehaibing
 * @ClassName: BasVehicleController
 * @Description: 车辆信息维护controller
 * @date 2018-03-20
 */
@RestController
@RequestMapping("bas_vehicle")
public class BasVehicleController {

    /**
     * @Fields  : 车辆信息维护rpc
     */
    @Autowired
    private BasVehicleRpc basVehicleRpc;

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护信息
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "findBasVehiclesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehiclesByPage(BasVehicleVo basVehicleVo){
        Map basVehicleVoMap = basVehicleVo == null?null:(Map) JSON.toJSON(basVehicleVo);
        return basVehicleRpc.findBasVehiclesByPage(basVehicleVoMap);
    }

    /**
     * @Title:
     * @Description: 保存车辆信息维护
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "saveBasVehicle",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasVehicle(@RequestBody BasVehicleVo basVehicleVo){
        return basVehicleRpc.saveBasVehicle(basVehicleVo);
    }

    /**
     * @Title:
     * @Description:  修改车辆信息维护
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "modifyBasVehicle",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasVehicle(@RequestBody BasVehicleVo basVehicleVo){
        return basVehicleRpc.modifyBasVehicle(basVehicleVo);
    }

    /**
     * @Title:
     * @Description:   根据vehicleId集合删除车辆信息维护
     * @param vehicleIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "deleteBasVehiclesByVehicleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasVehiclesByVehicleIds(@RequestBody List<String> vehicleIds){
        BasVehicleVo basVehicleVo = new BasVehicleVo();
        basVehicleVo.setVehicleIds(vehicleIds);
        return basVehicleRpc.deleteBasVehiclesByVehicleIds(basVehicleVo);
    }

    /**
     * @Title:
     * @Description:  根据vehicleId获取车辆信息维护
     * @param vehicleId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @RequestMapping(value = "findBasVehicleByVehicleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleByVehicleId(String vehicleId){
        return basVehicleRpc.findBasVehicleByVehicleId(vehicleId);
    }

    /**
     * @Title:
     * @Description: 分页查询车型信息Vo
     * @param basVehicleVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehiclesVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehiclesVosByPage(BasVehicleVo basVehicleVo){
        Map basVehicleVoMap = basVehicleVo == null?null:(Map) JSON.toJSON(basVehicleVo);
        return basVehicleRpc.findBasVehiclesVosByPage(basVehicleVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param basVehicleVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehicleLevelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleLevelsByPage(BasVehicleVo basVehicleVo){
        Map basVehicleVoMap = basVehicleVo == null?null:(Map) JSON.toJSON(basVehicleVo);
        return basVehicleRpc.findBasVehicleLevelsByPage(basVehicleVoMap);
    }


    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param vehicleCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehicleVoByVehicleCode" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleVoByVehicleCode(String vehicleCode){
        return basVehicleRpc.findBasVehicleVoByVehicleCode(vehicleCode);
    }
}
