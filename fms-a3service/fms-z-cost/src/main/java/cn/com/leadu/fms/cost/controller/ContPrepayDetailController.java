package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.cost.service.ContPrepayDetailService;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteListVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailModifyVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailSaveVo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.contprepaydetail.ContPrepayDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailController
 * @Description: 提前还款明细相关接口
 * @date 2018-05-11
 */
@RestController
@RequestMapping("cont_prepay_detail")
public class ContPrepayDetailController {

    /**
     * @Fields  : 提前还款明细service
     */
    @Autowired
    private ContPrepayDetailService contPrepayDetailService;

    /**
     * @Title:
     * @Description: 分页查询提前还款明细信息
     * @param contPrepayDetailVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "findContPrepayDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepayDetailsByPage(ContPrepayDetailVo contPrepayDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepayDetailService.findContPrepayDetailsByPage(contPrepayDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存提前还款明细
     * @param contPrepayDetailSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "saveContPrepayDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepayDetail(@Valid @RequestBody ContPrepayDetailSaveVo contPrepayDetailSaveVo){
        contPrepayDetailService.saveContPrepayDetail(contPrepayDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改提前还款明细
     * @param contPrepayDetailModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "modifyContPrepayDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContPrepayDetail(@Valid @RequestBody ContPrepayDetailModifyVo contPrepayDetailModifyVo){
        contPrepayDetailService.modifyContPrepayDetail(contPrepayDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除提前还款明细
     * @param contPrepayDetailDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "deleteContPrepayDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepayDetail(@Valid @RequestBody ContPrepayDetailDeleteVo contPrepayDetailDeleteVo){
        contPrepayDetailService.deleteContPrepayDetail(contPrepayDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contPrepayDetailId集合删除提前还款明细
     * @param contPrepayDetailDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "deleteContPrepayDetailsByContPrepayDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepayDetailsByContPrepayDetailIds(@Valid @RequestBody ContPrepayDetailDeleteListVo contPrepayDetailDeleteListVo){
        contPrepayDetailService.deleteContPrepayDetailsByContPrepayDetailIds(contPrepayDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contPrepayDetailId获取提前还款明细
     * @param contPrepayDetailId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:31
     */
    @RequestMapping(value = "findContPrepayDetailByContPrepayDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepayDetailByContPrepayDetailId(String contPrepayDetailId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contPrepayDetailService.findContPrepayDetailByContPrepayDetailId(contPrepayDetailId)), HttpStatus.OK);
    }

}
