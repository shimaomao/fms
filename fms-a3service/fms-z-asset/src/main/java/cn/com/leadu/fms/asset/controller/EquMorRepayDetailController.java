package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.asset.service.EquMorRepayDetailService;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailController
 * @Description: 资方抵押还款计划相关接口
 */
@RestController
@RequestMapping("equ_mor_repay_detail")
public class EquMorRepayDetailController {

    /**
     * @Fields  : 资方抵押还款计划service
     */
    @Autowired
    private EquMorRepayDetailService equMorRepayDetailService;

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划信息
     * @param equMorRepayDetailVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "selectEquMorRepayDetailVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(equMorRepayDetailService.selectEquMorRepayDetailVosByPage(equMorRepayDetailVo)),
                HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepayDetailSaveVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "saveEquMorRepayDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorRepayDetail(@Valid @RequestBody EquMorRepayDetailSaveVo equMorRepayDetailSaveVo){
        equMorRepayDetailService.saveEquMorRepayDetail(equMorRepayDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改资方抵押还款计划
     * @param equMorRepayDetailModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "modifyEquMorRepayDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquMorRepayDetail(@Valid @RequestBody EquMorRepayDetailModifyVo equMorRepayDetailModifyVo){
        equMorRepayDetailService.modifyEquMorRepayDetail(equMorRepayDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除资方抵押还款计划
     * @param equMorRepayDetailDeleteVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "deleteEquMorRepayDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquMorRepayDetail(@Valid @RequestBody EquMorRepayDetailDeleteVo equMorRepayDetailDeleteVo){
        equMorRepayDetailService.deleteEquMorRepayDetail(equMorRepayDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据equMorRepayDetailId集合删除资方抵押还款计划
     * @param equMorRepayDetailDeleteListVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "deleteEquMorRepayDetailsByEquMorRepayDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteEquMorRepayDetailsByEquMorRepayDetailIds(@Valid @RequestBody EquMorRepayDetailDeleteListVo equMorRepayDetailDeleteListVo){
        equMorRepayDetailService.deleteEquMorRepayDetailsByEquMorRepayDetailIds(equMorRepayDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据equMorRepayDetailId获取资方抵押还款计划
     * @param equMorRepayDetailId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:46
     */
    @RequestMapping(value = "findEquMorRepayDetailByEquMorRepayDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorRepayDetailByEquMorRepayDetailId(String equMorRepayDetailId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorRepayDetailService.findEquMorRepayDetailByEquMorRepayDetailId(equMorRepayDetailId)), HttpStatus.OK);
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
    @RequestMapping(value = "updateEquMorRepayDetailPayStatus", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateEquMorRepayDetailPayStatus(@RequestBody List<EquMorRepayDetail> equMorRepayDetails){
        equMorRepayDetailService.updateEquMorRepayDetailPayStatus(equMorRepayDetails);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
