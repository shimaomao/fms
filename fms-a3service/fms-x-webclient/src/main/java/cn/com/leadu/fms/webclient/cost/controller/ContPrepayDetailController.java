package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepaydetail.ContPrepayDetailVo;
import cn.com.leadu.fms.webclient.cost.rpc.ContPrepayDetailRpc;
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
 * @author yangyiquan
 * @ClassName: ContPrepayDetailController
 * @Description: 提前还款明细controller
 * @date 2018-05-11
 */
@RestController
@RequestMapping("cont_prepay_detail")
public class ContPrepayDetailController {

    /**
     * @Fields  : 提前还款明细rpc
     */
    @Autowired
    private ContPrepayDetailRpc contPrepayDetailRpc;

    /**
     * @Title:
     * @Description: 分页查询提前还款明细信息
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "findContPrepayDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepayDetailsByPage(ContPrepayDetailVo contPrepayDetailVo){
        Map contPrepayDetailVoMap = contPrepayDetailVo == null?null:(Map) JSON.toJSON(contPrepayDetailVo);
        return contPrepayDetailRpc.findContPrepayDetailsByPage(contPrepayDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存提前还款明细
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "saveContPrepayDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepayDetail(@RequestBody ContPrepayDetailVo contPrepayDetailVo){
        return contPrepayDetailRpc.saveContPrepayDetail(contPrepayDetailVo);
    }

    /**
     * @Title:
     * @Description:  修改提前还款明细
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "modifyContPrepayDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContPrepayDetail(@RequestBody ContPrepayDetailVo contPrepayDetailVo){
        return contPrepayDetailRpc.modifyContPrepayDetail(contPrepayDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据contPrepayDetailId集合删除提前还款明细
     * @param contPrepayDetailIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "deleteContPrepayDetailsByContPrepayDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepayDetailsByContPrepayDetailIds(@RequestBody List<String> contPrepayDetailIds){
        ContPrepayDetailVo contPrepayDetailVo = new ContPrepayDetailVo();
        contPrepayDetailVo.setContPrepayDetailIds(contPrepayDetailIds);
        return contPrepayDetailRpc.deleteContPrepayDetailsByContPrepayDetailIds(contPrepayDetailVo);
    }

    /**
     * @Title:
     * @Description:  根据contPrepayDetailId获取提前还款明细
     * @param contPrepayDetailId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @RequestMapping(value = "findContPrepayDetailByContPrepayDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepayDetailByContPrepayDetailId(String contPrepayDetailId){
        return contPrepayDetailRpc.findContPrepayDetailByContPrepayDetailId(contPrepayDetailId);
    }

}
