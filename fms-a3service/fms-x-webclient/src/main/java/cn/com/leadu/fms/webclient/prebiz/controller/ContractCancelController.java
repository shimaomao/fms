package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyCancelRpc;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractCancelRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by yanfengbo
 * 融资合同取消相关接口
 */
@RestController
@RequestMapping("contract_cancel")
public class ContractCancelController {
    /*
        融资申请取消rpc
     */

    @Autowired
    private ContractCancelRpc contractCancelRpc;

    @RequestMapping(value="findContractCancelsByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractCancelsByPage(ContractCancelVo contractCancelVo){
        Map contractCancelVoMap = contractCancelVo == null?null:(Map) JSON.toJSON(contractCancelVo);
        return contractCancelRpc.findContractCancelsByPage(contractCancelVoMap);
    }


    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findContractCancelVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractCancelVoByContNo(String contNo){
        return contractCancelRpc.findContractCancelVoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description:  融资合同取消
     * @param contractCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyContractCancel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContractCancel(@RequestBody ContractCancelVo contractCancelVo){
        return contractCancelRpc.modifyContractCancel(contractCancelVo);
    }


}
