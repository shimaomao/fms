package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.VehMaintainRpc;
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
 * @author qinmuqiao
 * @ClassName: VehMaintainController
 * @Description: 车辆维修记录controller
 */
@RestController
@RequestMapping("veh_maintain")
public class VehMaintainController {

    /**
     * @Fields  : 车辆维修记录rpc
     */
    @Autowired
    private VehMaintainRpc vehMaintainRpc;

    /**
     * @Title:
     * @Description: 分页查询车辆维修记录信息
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "findVehMaintainsVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehMaintainsVosByPage(VehMaintainVo vehMaintainVo){
        Map vehMaintainVoMap = vehMaintainVo == null?null:(Map) JSON.toJSON(vehMaintainVo);
        return vehMaintainRpc.findVehMaintainsVosByPage(vehMaintainVoMap);
    }

    /**
     * @Title:
     * @Description: 保存车辆维修记录
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "saveVehMaintain",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveVehMaintain(@RequestBody VehMaintainVo vehMaintainVo){
        return vehMaintainRpc.saveVehMaintain(vehMaintainVo);
    }


    /**
     * @Title:
     * @Description: 修改车辆维修记录
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "modifyVehMaintain",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyVehMaintain(@RequestBody VehMaintainVo vehMaintainVo){
        return vehMaintainRpc.modifyVehMaintain(vehMaintainVo);
    }


    /**
     * @Title:
     * @Description:  根据vehMaintainId获取车辆维修记录
     * @param vehMaintainId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "findVehMaintainVoByVehMaintainId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehMaintainVoByVehMaintainId(String vehMaintainId){
        return vehMaintainRpc.findVehMaintainVoByVehMaintainId(vehMaintainId);
    }

    /**
     * @Title:
     * @Description:   导入维修记录
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "importVehMaintainsByExcel", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> importVehMaintainsByExcel(String filePath){
        return vehMaintainRpc.importVehMaintainsByExcel(filePath);
    }


    /**
     * @Title:
     * @Description:   下载维修记录模版
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "exportVehMaintainModalExcel", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> exportVehMaintainModalExcel(){
        return CommonFeignUtils.getResponseEntity(vehMaintainRpc.exportVehMaintainModalExcel());

    }
}
