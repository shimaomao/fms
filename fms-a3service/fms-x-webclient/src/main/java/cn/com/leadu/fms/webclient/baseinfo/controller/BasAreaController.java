package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasAreaRpc;
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
 * @ClassName: BasAreaController
 * @Description: 省市县信息维护controller
 * @date 2018-03-15
 */
@RestController
@RequestMapping("bas_area")
public class BasAreaController {

    /**
     * @Fields  : 省市县信息维护rpc
     */
    @Autowired
    private BasAreaRpc basAreaRpc;

    /**
     * @Title:
     * @Description: 分页查询省市县信息维护信息
     * @param basAreaVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "findBasAreasByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreasByPage(BasAreaVo basAreaVo){
        Map basAreaVoMap = basAreaVo == null?null:(Map) JSON.toJSON(basAreaVo);
        return basAreaRpc.findBasAreasByPage(basAreaVoMap);
    }

    /**
     * @Title:
     * @Description: 保存省市县信息维护
     * @param basAreaVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "saveBasArea",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasArea(@RequestBody BasAreaVo basAreaVo){
        return basAreaRpc.saveBasArea(basAreaVo);
    }

    /**
     * @Title:
     * @Description:  修改省市县信息维护
     * @param basAreaVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "modifyBasArea",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasArea(@RequestBody BasAreaVo basAreaVo){
        return basAreaRpc.modifyBasArea(basAreaVo);
    }

    /**
     * @Title:
     * @Description:   根据areaId集合删除省市县信息维护
     * @param areaIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "deleteBasAreasByAreaIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasAreasByAreaIds(@RequestBody List<String> areaIds){
        BasAreaVo basAreaVo = new BasAreaVo();
        basAreaVo.setAreaIds(areaIds);
        return basAreaRpc.deleteBasAreasByAreaIds(basAreaVo);
    }

    /**
     * @Title:
     * @Description:  根据areaId获取省市县信息维护
     * @param areaId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "findBasAreaByAreaId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByAreaId(String areaId){
        return basAreaRpc.findBasAreaByAreaId(areaId);
    }

    /**
     * @Title:
     * @Description: 返回省市树状 提供给前台页面使用
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:44
     */
    @RequestMapping(value = "findBasAreas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreas(){
        return basAreaRpc.findBasAreas();
    }

    /**
     * @Title:
     * @Description: 查询省市版本值
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "findBasAreaValuesVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaValuesVersion(){
        return basAreaRpc.findBasAreaValuesVersion();
    }

    /**
     * @Title:
     * @Description: 初始化省市到redis中
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    @RequestMapping(value = "initBasAreas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initBasAreas(){
        return basAreaRpc.initBasAreas();
    }

    /**
     * @Title:
     * @Description:   查出所有省市县
     * @return
     * @throws
     * @author niehaibing
     * @date 2018/02/25 01:56:54
     */
    @RequestMapping(value = "findBasAreaByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByTree(){
        return basAreaRpc.findBasAreaByTree();
    }

    /**
     * 根据AreaCode查询信息
     * @param areaCode
     * @return
     */
    @RequestMapping(value = "findBasAreaByAreaCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasAreaByAreaCode(String areaCode){
        return basAreaRpc.findBasAreaByAreaCode(areaCode);
    }
}
