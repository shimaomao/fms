package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import cn.com.leadu.fms.webclient.product.rpc.IntrstFactorRpc;
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
 * @ClassName: IntrstFactorController
 * @Description: 利率因子controller
 * @date 2018-03-27
 */
@RestController
@RequestMapping("intrst_factor")
public class IntrstFactorController {

    /**
     * @Fields  : 利率因子rpc
     */
    @Autowired
    private IntrstFactorRpc intrstFactorRpc;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "findIntrstFactorsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorsByPage(IntrstFactorVo intrstFactorVo){
        Map intrstFactorVoMap = intrstFactorVo == null?null:(Map) JSON.toJSON(intrstFactorVo);
        return intrstFactorRpc.findIntrstFactorsByPage(intrstFactorVoMap);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "saveIntrstFactor",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveIntrstFactor(@RequestBody IntrstFactorVo intrstFactorVo){
        return intrstFactorRpc.saveIntrstFactor(intrstFactorVo);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "modifyIntrstFactor",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyIntrstFactor(@RequestBody IntrstFactorVo intrstFactorVo){
        return intrstFactorRpc.modifyIntrstFactor(intrstFactorVo);
    }

    /**
     * @Title:
     * @Description:   根据intrstFactorId集合删除利率因子
     * @param intrstFactorIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "deleteIntrstFactorsByIntrstFactorIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteIntrstFactorsByIntrstFactorIds(@RequestBody List<String> intrstFactorIds){
        IntrstFactorVo intrstFactorVo = new IntrstFactorVo();
        intrstFactorVo.setIntrstFactorIds(intrstFactorIds);
        return intrstFactorRpc.deleteIntrstFactorsByIntrstFactorIds(intrstFactorVo);
    }

    /**
     * @Title:
     * @Description:  根据intrstFactorId获取利率因子
     * @param intrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "findIntrstFactorByIntrstFactorId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorByIntrstFactorId(String intrstFactorId) {
        return intrstFactorRpc.findIntrstFactorByIntrstFactorId(intrstFactorId);
    }

    /**
     * @Title:
     * @Description: 取得全部启用的利率因子
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-27 18:07:17
     */
    @RequestMapping(value = "findIntrstFactorAllList" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorAllList(){
        return intrstFactorRpc.findIntrstFactorAllList();
    }

}
