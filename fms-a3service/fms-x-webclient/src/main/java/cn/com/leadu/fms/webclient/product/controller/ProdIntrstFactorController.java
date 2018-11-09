package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.webclient.product.rpc.ProdIntrstFactorRpc;
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
 * @ClassName: ProdIntrstFactorController
 * @Description: 产品利率controller
 * @date 2018-03-27
 */
@RestController
@RequestMapping("prod_intrst_factor")
public class ProdIntrstFactorController {

    /**
     * @Fields  : 产品利率rpc
     */
    @Autowired
    private ProdIntrstFactorRpc prodIntrstFactorRpc;

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "findProdIntrstFactorsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstFactorsByPage(ProdIntrstFactorVo prodIntrstFactorVo){
        Map prodIntrstFactorVoMap = prodIntrstFactorVo == null?null:(Map) JSON.toJSON(prodIntrstFactorVo);
        return prodIntrstFactorRpc.findProdIntrstFactorsByPage(prodIntrstFactorVoMap);
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "saveProdIntrstFactor",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProdIntrstFactor(@RequestBody ProdIntrstFactorVo prodIntrstFactorVo){
        return prodIntrstFactorRpc.saveProdIntrstFactor(prodIntrstFactorVo);
    }

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param prodIntrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "modifyProdIntrstFactor",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProdIntrstFactor(@RequestBody ProdIntrstFactorVo prodIntrstFactorVo){
        return prodIntrstFactorRpc.modifyProdIntrstFactor(prodIntrstFactorVo);
    }

    /**
     * @Title:
     * @Description:   根据prodIntrstFactorId集合删除产品利率
     * @param prodIntrstFactorIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "deleteProdIntrstFactorsByProdIntrstFactorIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrstFactorsByProdIntrstFactorIds(@RequestBody List<String> prodIntrstFactorIds){
        ProdIntrstFactorVo prodIntrstFactorVo = new ProdIntrstFactorVo();
        prodIntrstFactorVo.setProdIntrstFactorIds(prodIntrstFactorIds);
        return prodIntrstFactorRpc.deleteProdIntrstFactorsByProdIntrstFactorIds(prodIntrstFactorVo);
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstFactorId获取产品利率
     * @param prodIntrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:27
     */
    @RequestMapping(value = "findProdIntrstFactorByProdIntrstFactorId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstFactorByProdIntrstFactorId(String prodIntrstFactorId){
        return prodIntrstFactorRpc.findProdIntrstFactorByProdIntrstFactorId(prodIntrstFactorId);
    }

}
