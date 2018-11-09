package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasSalesRpc;
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
 * @ClassName: BasSalesController
 * @Description: 实际销售方controller
 * @date 2018-05-03
 */
@RestController
@RequestMapping("bas_sales")
public class BasSalesController {

    /**
     * @Fields  : 实际销售方rpc
     */
    @Autowired
    private BasSalesRpc basSalesRpc;

    /**
     * @Title:
     * @Description: 分页查询实际销售方信息
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "findBasSalessByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasSalessByPage(BasSalesVo basSalesVo){
        Map basSalesVoMap = basSalesVo == null?null:(Map) JSON.toJSON(basSalesVo);
        return basSalesRpc.findBasSalessByPage(basSalesVoMap);
    }

    /**
     * @Title:
     * @Description: 保存实际销售方
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "saveBasSales",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasSales(@RequestBody BasSalesVo basSalesVo){
        return basSalesRpc.saveBasSales(basSalesVo);
    }

    /**
     * @Title:
     * @Description:  修改实际销售方
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "modifyBasSales",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasSales(@RequestBody BasSalesVo basSalesVo){
        return basSalesRpc.modifyBasSales(basSalesVo);
    }

    /**
     * @Title:
     * @Description:   根据salesId集合删除实际销售方
     * @param salesIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "deleteBasSalessBySalesIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasSalessBySalesIds(@RequestBody List<String> salesIds){
        BasSalesVo basSalesVo = new BasSalesVo();
        basSalesVo.setSalesIds(salesIds);
        return basSalesRpc.deleteBasSalessBySalesIds(basSalesVo);
    }

    /**
     * @Title:
     * @Description:  根据salesId获取实际销售方
     * @param salesId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "findBasSalesBySalesId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasSalesBySalesId(String salesId,String serviceId){
        return basSalesRpc.findBasSalesBySalesId(salesId,serviceId);
    }

    /**
     * @Title:
     * @Description: 实际销售方审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody BasSalesVo basSalesVo){
        return basSalesRpc.approval(basSalesVo);
    }

    /**
     * @Title:
     * @Description: 实际销售方审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody BasSalesVo basSalesVo){
        return basSalesRpc.sendBack(basSalesVo);
    }

}
