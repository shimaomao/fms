package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import cn.com.leadu.fms.webclient.cost.rpc.PilferInsuranceRpc;
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
 * @ClassName: PilferInsuranceController
 * @Description: 盗抢险信息controller
 * @date 2018-05-31
 */
@RestController
@RequestMapping("pilfer_insurance")
public class PilferInsuranceController {

    /**
     * @Fields  : 盗抢险信息rpc
     */
    @Autowired
    private PilferInsuranceRpc pilferInsuranceRpc;

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "findPilferInsurancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsurancesByPage(PilferInsuranceVo pilferInsuranceVo){
        Map pilferInsuranceVoMap = pilferInsuranceVo == null?null:(Map) JSON.toJSON(pilferInsuranceVo);
        return pilferInsuranceRpc.findPilferInsurancesByPage(pilferInsuranceVoMap);
    }

    /**
     * @Title:
     * @Description: 保存盗抢险信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "savePilferInsurance",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> savePilferInsurance(@RequestBody PilferInsuranceVo pilferInsuranceVo){
        return pilferInsuranceRpc.savePilferInsurance(pilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:  修改盗抢险信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "modifyPilferInsurance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyPilferInsurance(@RequestBody PilferInsuranceVo pilferInsuranceVo){
        return pilferInsuranceRpc.modifyPilferInsurance(pilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:   根据pilferInsuranceId集合删除盗抢险信息
     * @param pilferInsuranceIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "deletePilferInsurancesByPilferInsuranceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deletePilferInsurancesByPilferInsuranceIds(@RequestBody List<String> pilferInsuranceIds){
        PilferInsuranceVo pilferInsuranceVo = new PilferInsuranceVo();
        pilferInsuranceVo.setPilferInsuranceIds(pilferInsuranceIds);
        return pilferInsuranceRpc.deletePilferInsurancesByPilferInsuranceIds(pilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description:  根据pilferInsuranceId获取盗抢险信息
     * @param pilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "findPilferInsuranceByPilferInsuranceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceByPilferInsuranceId(String pilferInsuranceId){
        return pilferInsuranceRpc.findPilferInsuranceByPilferInsuranceId(pilferInsuranceId);
    }

    /** 
    * @Description: 查询盗抢险月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 18:39
    */ 
    @RequestMapping(value = "findPilferInsuranceMonthlysVosListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceMonthlysVosListByPage(PilferInsuranceVo pilferInsuranceVo){
        Map pilferInsuranceVoMap = pilferInsuranceVo == null?null:(Map) JSON.toJSON(pilferInsuranceVo);
        return pilferInsuranceRpc.findPilferInsuranceMonthlysVosListByPage(pilferInsuranceVoMap);
    }

    /**
     * @Description: 查询盗抢险月结信息 ,不分页 ,POST请求
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/28 15:39
     */
    @RequestMapping(value = "findPilferInsuranceMonthlysVos" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findPilferInsuranceMonthlysVos(@RequestBody PilferInsuranceVo pilferInsuranceVo){
        return pilferInsuranceRpc.findPilferInsuranceMonthlysVos(pilferInsuranceVo);
    }

    /**
     * @Title:
     * @Description: 根据合同号获取盗抢险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findPilferInsuranceVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceVoByContNo(String contNo){
        return pilferInsuranceRpc.findPilferInsuranceVoByContNo(contNo);
    }
}
