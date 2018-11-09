package cn.com.leadu.fms.webclient.product.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.webclient.product.rpc.FinItemRpc;
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
 * @ClassName: FinItemController
 * @Description: 融资项目管理controller
 * @date 2018-03-19
 */
@RestController
@RequestMapping("fin_item")
public class FinItemController {

    /**
     * @Fields  : 融资项目管理rpc
     */
    @Autowired
    private FinItemRpc finItemRpc;

    /**
     * @Title:
     * @Description: 分页查询融资项目管理信息
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findFinItemsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinItemsByPage(FinItemVo finItemVo){
        Map finItemVoMap = finItemVo == null?null:(Map) JSON.toJSON(finItemVo);
        return finItemRpc.findFinItemsByPage(finItemVoMap);
    }

    /**
     * @Title:
     * @Description: 保存融资项目管理
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "saveFinItem",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinItem(@RequestBody FinItemVo finItemVo){
        return finItemRpc.saveFinItem(finItemVo);
    }

    /**
     * @Title:
     * @Description:  修改融资项目管理
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "modifyFinItem",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinItem(@RequestBody FinItemVo finItemVo){
        return finItemRpc.modifyFinItem(finItemVo);
    }

    /**
     * @Title:
     * @Description:   根据finItemId集合删除融资项目管理
     * @param finItemIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "deleteFinItemsByFinItemIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinItemsByFinItemIds(@RequestBody List<String> finItemIds){
        FinItemVo finItemVo = new FinItemVo();
        finItemVo.setFinItemIds(finItemIds);
        return finItemRpc.deleteFinItemsByFinItemIds(finItemVo);
    }

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @param finItemId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findFinItemByFinItemId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinItemByFinItemId(String finItemId){
        return finItemRpc.findFinItemByFinItemId(finItemId);
    }

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "findAllFinItemList", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAllFinItemList(){
        return finItemRpc.findAllFinItemList();
    }

}
