package cn.com.leadu.fms.webclient.asset.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import cn.com.leadu.fms.webclient.asset.rpc.EquMorDetailRpc;
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
 * @ClassName: EquMorDetailController
 * @Description: 资方抵押明细controller
 * @date 2018-05-30
 */
@RestController
@RequestMapping("equ_mor_detail")
public class EquMorDetailController {

    /**
     * @Fields  : 资方抵押明细rpc
     */
    @Autowired
    private EquMorDetailRpc equMorDetailRpc;

    /**
     * @Title:
     * @Description: 查询申请资方抵押明细(申请)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVos" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVos(EquMorDetailVo equMorDetailVo){
        Map equMorDetailVoMap = equMorDetailVo == null?null:(Map) JSON.toJSON(equMorDetailVo);
        return equMorDetailRpc.findEquMorDetailVos(equMorDetailVoMap);
    }
    /**
     * @Title:
     * @Description: 查询申请资方抵押明细(复审)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVoList" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVoList(EquMorDetailVo equMorDetailVo){
        Map equMorDetailVoMap = equMorDetailVo == null?null:(Map) JSON.toJSON(equMorDetailVo);
        return equMorDetailRpc.findEquMorDetailVoList(equMorDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资方抵押明细
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "saveEquMorDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.saveEquMorDetail(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  资方抵押解除申请(初次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "applyEquMorDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> applyEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.applyEquMorDetail(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  资方抵押解除申请(再次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "modifyEquMorDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquMorDetail(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.modifyEquMorDetail(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据equMorDetailId集合删除资方抵押明细
     * @param equMorDetailIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "deleteEquMorDetailsByEquMorDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquMorDetailsByEquMorDetailIds(@RequestBody List<String> equMorDetailIds){
        EquMorDetailVo equMorDetailVo = new EquMorDetailVo();
        equMorDetailVo.setEquMorDetailIds(equMorDetailIds);
        return equMorDetailRpc.deleteEquMorDetailsByEquMorDetailIds(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description: 资方抵押明细信息一览
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVosByPage(EquMorDetailVo equMorDetailVo){
        Map equMorDetailVoMap = equMorDetailVo == null?null:(Map) JSON.toJSON(equMorDetailVo);
        return equMorDetailRpc.findEquMorDetailVosByPage(equMorDetailVoMap);
    }

    /**
     * @Title:
     * @Description:  退回上一级
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.sendBack(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  复核通过
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalToVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalToVoucher(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.approvalToVoucher(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  制单
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalVoucher(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.approvalVoucher(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  财务付款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalFinance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalFinance(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.approvalFinance(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:  财务确认受收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalReceipt",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalReceipt(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.approvalReceipt(equMorDetailVo);
    }


    /**
     * @Title:
     * @Description:  解抵押确认
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalConfirm",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalConfirm(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.approvalConfirm(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printEquRel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printEquRel(@RequestBody EquMorDetailVo equMorDetailVo){
        return equMorDetailRpc.printEquRel(equMorDetailVo);
    }

}
