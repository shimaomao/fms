package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.CapitalAssetsVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.CapitalAssetsTaskRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huzongcheng
 * @ClassName: capitalAssetsTaskController
 * @Description: 转固定资产任务相关接口
 */
@RestController
@RequestMapping("capital_assets")
public class CapitalAssetsTaskController {

    /**
     * @Fields : 保证金变更任务service
     */
    @Autowired
    private CapitalAssetsTaskRpc capitalAssetsTaskRpc;


    /**
     * @param vo 参数实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 总经理审批操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "approve", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approve(@RequestBody CapitalAssetsVo vo) {
        capitalAssetsTaskRpc.approve(vo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
