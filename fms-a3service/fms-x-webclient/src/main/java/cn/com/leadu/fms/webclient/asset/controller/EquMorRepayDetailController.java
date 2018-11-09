package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.webclient.asset.rpc.EquMorRepayDetailRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailController
 * @Description: 资方抵押还款计划controller
 */
@RestController
@RequestMapping("equ_mor_repay_detail")
public class EquMorRepayDetailController {

    /**
     * @Fields  : 资方抵押还款计划rpc
     */
    @Autowired
    private EquMorRepayDetailRpc equMorRepayDetailRpc;

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划信息
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "selectEquMorRepayDetailVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo){
        Map equMorRepayDetailVoMap = equMorRepayDetailVo == null?null:(Map) JSON.toJSON(equMorRepayDetailVo);
        return equMorRepayDetailRpc.selectEquMorRepayDetailVosByPage(equMorRepayDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "saveEquMorRepayDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorRepayDetail(@RequestBody EquMorRepayDetailVo equMorRepayDetailVo){
        return equMorRepayDetailRpc.saveEquMorRepayDetail(equMorRepayDetailVo);
    }

    /**
     * @Title:
     * @Description:  修改资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "modifyEquMorRepayDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquMorRepayDetail(@RequestBody EquMorRepayDetailVo equMorRepayDetailVo){
        return equMorRepayDetailRpc.modifyEquMorRepayDetail(equMorRepayDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据equMorRepayDetailId集合删除资方抵押还款计划
     * @param equMorRepayDetailIds
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "deleteEquMorRepayDetailsByEquMorRepayDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquMorRepayDetailsByEquMorRepayDetailIds(@RequestBody List<String> equMorRepayDetailIds){
        EquMorRepayDetailVo equMorRepayDetailVo = new EquMorRepayDetailVo();
        equMorRepayDetailVo.setEquMorRepayDetailIds(equMorRepayDetailIds);
        return equMorRepayDetailRpc.deleteEquMorRepayDetailsByEquMorRepayDetailIds(equMorRepayDetailVo);
    }

    /**
     * @Title:
     * @Description:  根据equMorRepayDetailId获取资方抵押还款计划
     * @param equMorRepayDetailId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "findEquMorRepayDetailByEquMorRepayDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorRepayDetailByEquMorRepayDetailId(String equMorRepayDetailId){
        return equMorRepayDetailRpc.findEquMorRepayDetailByEquMorRepayDetailId(equMorRepayDetailId);
    }

    /**
     * @Title:
     * @Description:  更新还款状态
     * @param
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @RequestMapping(value = "updateEquMorRepayDetailPayStatus" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateEquMorRepayDetailPayStatus(@RequestBody List<EquMorRepayDetail> equMorRepayDetails){
        return equMorRepayDetailRpc.updateEquMorRepayDetailPayStatus(equMorRepayDetails);
    }
}
