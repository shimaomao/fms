package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.CapitalAssetsVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CapitalAssetsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huzongcheng
 * @ClassName: CapitalAssetsTaskController
 * @Description: 保转固定资产任务相关接口
 */
@RestController
@RequestMapping("capital_assets")
public class CapitalAssetsTaskController {

    /**
     * @Fields : 转固定资产service
     */
    @Autowired
    private CapitalAssetsTaskService capitalAssetsTaskService;

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 总经理审批
     * @author huzongcheng
     */
    @RequestMapping(value = "approve", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approve(@RequestBody CapitalAssetsVo vo, @AuthUserInfo SysUser sysUser) {
        capitalAssetsTaskService.approve(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
