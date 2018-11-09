package cn.com.leadu.fms.webclient.insurance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.webclient.insurance.rpc.ContInsurClaimRpc;
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
 * @ClassName: ContInsurClaimController
 * @Description: 保险理赔controller
 * @date 2018-05-14
 */
@RestController
@RequestMapping("cont_insur_claim")
public class ContInsurClaimController {

    /**
     * @Fields  : 保险理赔rpc
     */
    @Autowired
    private ContInsurClaimRpc contInsurClaimRpc;

    /**
     * @Title:
     * @Description: 分页查询保险理赔信息一览
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "findContInsurClaimsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPage(ContInsurClaimVo contInsurClaimVo){
        Map contInsurClaimVoMap = contInsurClaimVo == null?null:(Map) JSON.toJSON(contInsurClaimVo);
        return contInsurClaimRpc.findContInsurClaimsByPage(contInsurClaimVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询保险理赔查询页面
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsurClaimsByPageSelect" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPageSelect(ContInsurClaimVo contInsurClaimVo){
        Map contInsurClaimVoMap = contInsurClaimVo == null?null:(Map) JSON.toJSON(contInsurClaimVo);
        return contInsurClaimRpc.findContInsurClaimsByPageSelect(contInsurClaimVoMap);
    }

    /**
     * @Title:
     * @Description: 保存保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "saveContInsurClaim",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return contInsurClaimRpc.saveContInsurClaim(contInsurClaimVo);
    }

    /**
     * @Title:
     * @Description:  修改保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "modifyContInsurClaim",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo){
        return contInsurClaimRpc.modifyContInsurClaim(contInsurClaimVo);
    }

    /**
     * @Title:
     * @Description:   根据contInsurClaimId集合删除保险理赔
     * @param contInsurClaimIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "deleteContInsurClaimsByContInsurClaimIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContInsurClaimsByContInsurClaimIds(@RequestBody List<String> contInsurClaimIds){
        ContInsurClaimVo contInsurClaimVo = new ContInsurClaimVo();
        contInsurClaimVo.setContInsurClaimIds(contInsurClaimIds);
        return contInsurClaimRpc.deleteContInsurClaimsByContInsurClaimIds(contInsurClaimVo);
    }

    /**
     * @Title:
     * @Description:  根据contInsurClaimId获取保险理赔
     * @param contInsurClaimId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @RequestMapping(value = "findContInsurClaimByContInsurClaimId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimByContInsurClaimId(String contInsurClaimId){
        return contInsurClaimRpc.findContInsurClaimByContInsurClaimId(contInsurClaimId);
    }

    /**
     * @Title:
     * @Description: 根据合同编号查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findDetailedByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailedByContNo(String contVehinsId,String contInsurClaimId,String serviceId){
        return contInsurClaimRpc.findDetailedByContNo(contVehinsId,contInsurClaimId,serviceId);
    }

    /**
     * @Title:
     * @Description: 取保险理赔详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findDetailContInsurClaim", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailContInsurClaim(String serviceId){
        return contInsurClaimRpc.findDetailContInsurClaim(serviceId);
    }

    /**
     * @Title:
     * @Description: 保险理赔excel导出
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsurClaimsByPageSelect2" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPageSelect2(ContInsurClaimVo contInsurClaimVo){
        Map contInsurClaimVoMap = contInsurClaimVo == null?null:(Map) JSON.toJSON(contInsurClaimVo);
        return contInsurClaimRpc.findContInsurClaimsByPageSelect2(contInsurClaimVoMap);
    }

}
