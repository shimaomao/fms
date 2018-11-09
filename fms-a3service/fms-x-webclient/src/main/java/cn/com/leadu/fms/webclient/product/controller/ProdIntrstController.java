package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.webclient.product.rpc.ProdIntrstRpc;
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
 * @ClassName: ProdIntrstController
 * @Description: 产品利率controller
 * @date 2018-03-27
 */
@RestController
@RequestMapping("prod_intrst")
public class ProdIntrstController {

    /**
     * @Fields  : 产品利率rpc
     */
    @Autowired
    private ProdIntrstRpc prodIntrstRpc;

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "findProdIntrstsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstsByPage(ProdIntrstVo prodIntrstVo){
        Map prodIntrstVoMap = prodIntrstVo == null?null:(Map) JSON.toJSON(prodIntrstVo);
        return prodIntrstRpc.findProdIntrstsByPage(prodIntrstVoMap);
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "saveProdIntrst",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveProdIntrst(@RequestBody ProdIntrstVo prodIntrstVo){
        return prodIntrstRpc.saveProdIntrst(prodIntrstVo);
    }

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param prodIntrstVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "modifyProdIntrst",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyProdIntrst(@RequestBody ProdIntrstVo prodIntrstVo){
        return prodIntrstRpc.modifyProdIntrst(prodIntrstVo);
    }

    /**
     * @Title:
     * @Description:   根据prodIntrstId集合删除产品利率
     * @param prodIntrstIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "deleteProdIntrstsByProdIntrstIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteProdIntrstsByProdIntrstIds(@RequestBody List<String> prodIntrstIds){
        ProdIntrstVo prodIntrstVo = new ProdIntrstVo();
        prodIntrstVo.setProdIntrstIds(prodIntrstIds);
        return prodIntrstRpc.deleteProdIntrstsByProdIntrstIds(prodIntrstVo);
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstId获取产品利率
     * @param prodIntrstId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "findProdIntrstByProdIntrstId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findProdIntrstByProdIntrstId(String prodIntrstId){
        return prodIntrstRpc.findProdIntrstByProdIntrstId(prodIntrstId);
    }

}
