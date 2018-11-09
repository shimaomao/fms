package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import cn.com.leadu.fms.webclient.cost.rpc.GpsDispatchRpc;
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
 * @author qiaomengnan
 * @ClassName: GpsDispatchController
 * @Description: 派单信息controller
 * @date 2018-05-25
 */
@RestController
@RequestMapping("gps_dispatch")
public class GpsDispatchController {

    /**
     * @Fields  : 派单信息rpc
     */
    @Autowired
    private GpsDispatchRpc gpsDispatchRpc;

    /**
     * @Title:
     * @Description: 查询派单信息一览
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "findGpsDispatchVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchVosByPage(GpsDispatchVo gpsDispatchVo){
        Map gpsDispatchVoMap = gpsDispatchVo == null?null:(Map) JSON.toJSON(gpsDispatchVo);
        return gpsDispatchRpc.findGpsDispatchVosByPage(gpsDispatchVoMap);
    }

    /**
     * @Title:
     * @Description: 暂存派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "storageGpsDispatch",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> storageGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo){
        return gpsDispatchRpc.storageGpsDispatch(gpsDispatchVo);
    }

    /**
     * @Title:
     * @Description: 保存派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "saveGpsDispatch",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo){
        return gpsDispatchRpc.saveGpsDispatch(gpsDispatchVo);
    }

    /**
     * @Title:
     * @Description:  修改派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "modifyGpsDispatch",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo){
        return gpsDispatchRpc.modifyGpsDispatch(gpsDispatchVo);
    }

    /**
     * @Title:
     * @Description:  根据dispatchId获取派单信息
     * @param dispatchId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @RequestMapping(value = "findGpsDispatchByDispatchId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchByDispatchId(String dispatchId){
        return gpsDispatchRpc.findGpsDispatchByDispatchId(dispatchId);
    }

    /**
    * @Description: 查询派单月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/28 15:39
    */ 
    @RequestMapping(value = "findGpsDispatchMonthlysVosListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchMonthlysVosListByPage(GpsDispatchMonthlyVo gpsDispatchMonthlyVo){
        Map gpsDispatchMonthlyVoMap = gpsDispatchMonthlyVo == null?null:(Map) JSON.toJSON(gpsDispatchMonthlyVo);
        return gpsDispatchRpc.findGpsDispatchMonthlysVosListByPage(gpsDispatchMonthlyVoMap);
    }

    /**
     * @Description: 查询派单月结信息,不分页,POST
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/28 15:39
     */
    @RequestMapping(value = "findGpsDispatchMonthlysVos" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findGpsDispatchMonthlysVos(@RequestBody GpsDispatchMonthlyVo gpsDispatchMonthlyVo){
        return gpsDispatchRpc.findGpsDispatchMonthlysVos(gpsDispatchMonthlyVo);
    }

    /**
     * @Title:
     * @Description:   根据合同id查询派单信息详情
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    @RequestMapping(value = "findGpsDispatchDetailByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchDetailByContNo(String contNo){
        return gpsDispatchRpc.findGpsDispatchDetailByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:   查询天易派单状态
     * @param dispatchId
     * @param tyOrderNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/05 08:33:45
     */
    @RequestMapping(value = "findTyGpsDisPatch" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTyGpsDisPatch(String dispatchId,String tyOrderNo){
        return gpsDispatchRpc.findTyGpsDisPatch(dispatchId, tyOrderNo);
    }

}
