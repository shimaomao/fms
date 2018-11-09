package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp.CarCollectCompVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.CarCollectCompRpc;
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
 * @author yanfengbo
 * @ClassName: CarCollectCompController
 * @Description: 收车机构维护controller
 * @date 2018-05-22
 */
@RestController
@RequestMapping("car_collect_comp")
public class CarCollectCompController {

    /**
     * @Fields  : 收车机构维护rpc
     */
    @Autowired
    private CarCollectCompRpc carCollectCompRpc;

    /**
     * @Title:
     * @Description: 分页查询收车机构维护信息
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "findCarCollectCompsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCarCollectCompsByPage(CarCollectCompVo carCollectCompVo){
        Map carCollectCompVoMap = carCollectCompVo == null?null:(Map) JSON.toJSON(carCollectCompVo);
        return carCollectCompRpc.findCarCollectCompsByPage(carCollectCompVoMap);
    }

    /**
     * @Title:
     * @Description: 保存收车机构维护
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "saveCarCollectComp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCarCollectComp(@RequestBody CarCollectCompVo carCollectCompVo){
        return carCollectCompRpc.saveCarCollectComp(carCollectCompVo);
    }

    /**
     * @Title:
     * @Description:  修改收车机构维护
     * @param carCollectCompVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "modifyCarCollectComp",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCarCollectComp(@RequestBody CarCollectCompVo carCollectCompVo){
        return carCollectCompRpc.modifyCarCollectComp(carCollectCompVo);
    }

    /**
     * @Title:
     * @Description:   根据carCollectCompId集合删除收车机构维护
     * @param carCollectCompIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "deleteCarCollectCompsByCarCollectCompIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCarCollectCompsByCarCollectCompIds(@RequestBody List<String> carCollectCompIds){
        CarCollectCompVo carCollectCompVo = new CarCollectCompVo();
        carCollectCompVo.setCarCollectCompIds(carCollectCompIds);
        return carCollectCompRpc.deleteCarCollectCompsByCarCollectCompIds(carCollectCompVo);
    }

    /**
     * @Title:
     * @Description:  根据carCollectCompId获取收车机构维护
     * @param carCollectCompId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @RequestMapping(value = "findCarCollectCompByCarCollectCompId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCarCollectCompByCarCollectCompId(String carCollectCompId){
        return carCollectCompRpc.findCarCollectCompByCarCollectCompId(carCollectCompId);
    }

}
