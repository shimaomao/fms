package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.baseinfo.service.BasSalesService;
import cn.com.leadu.fms.baseinfo.validator.bassales.vo.*;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName: BasSalesController
 * @Description: 实际销售方相关接口
 * @date 2018-05-03
 */
@RestController
@RequestMapping("bas_sales")
public class BasSalesController {

    /**
     * @Fields  : 实际销售方service
     */
    @Autowired
    private BasSalesService basSalesService;

    /**
     * @Title:
     * @Description: 分页查询实际销售方信息
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "findBasSalessByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasSalessByPage(BasSalesVo basSalesVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basSalesService.findBasSalessByPage(basSalesVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存实际销售方
     * @param basSalesSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "saveBasSales",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasSales(@Valid @RequestBody BasSalesSaveVo basSalesSaveVo,@AuthUserInfo SysUser sysUser){
        basSalesService.saveBasSales(basSalesSaveVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改实际销售方
     * @param basSalesModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "modifyBasSales",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasSales(@Valid @RequestBody BasSalesModifyVo basSalesModifyVo,@AuthUserInfo SysUser sysUser){
        basSalesService.modifyBasSales(basSalesModifyVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除实际销售方
     * @param basSalesDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "deleteBasSales",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasSales(@Valid @RequestBody BasSalesDeleteVo basSalesDeleteVo){
        basSalesService.deleteBasSales(basSalesDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据salesId集合删除实际销售方
     * @param basSalesDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "deleteBasSalessBySalesIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasSalessBySalesIds(@Valid @RequestBody BasSalesDeleteListVo basSalesDeleteListVo){
        basSalesService.deleteBasSalessBySalesIds(basSalesDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据salesId获取实际销售方
     * @param salesId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "findBasSalesBySalesId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasSalesBySalesId(String salesId,String serviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basSalesService.findBasSalesBySalesId(salesId,serviceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 实际销售方审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody BasSalesVo basSalesVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        basSalesService.approval(basSalesVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 实际销售方退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody BasSalesVo basSalesVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        basSalesService.sendBack(basSalesVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
