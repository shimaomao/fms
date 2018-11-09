package cn.com.leadu.fms.postbiz.controller;


import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.postbiz.service.OverdueContService;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecont.vo.OverdueContSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: OverdueContController
 * @Description: 逾期合同信息相关接口
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_cont")
public class OverdueContController {

    /**
     * @Fields  : 逾期合同信息service
     */
    @Autowired
    private OverdueContService overdueContService;

    /**
     * @Title:
     * @Description: 分页查询逾期合同信息信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findOverdueContsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContsByPage(OverdueContVo overdueContVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueContService.findOverdueContsByPage(overdueContVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存逾期合同信息
     * @param overdueContSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "saveOverdueCont",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCont(@Valid @RequestBody OverdueContSaveVo overdueContSaveVo){
        overdueContService.saveOverdueCont(overdueContSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改逾期合同信息
     * @param overdueContModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "modifyOverdueCont",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCont(@Valid @RequestBody OverdueContModifyVo overdueContModifyVo){
        overdueContService.modifyOverdueCont(overdueContModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除逾期合同信息
     * @param overdueContDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "deleteOverdueCont",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCont(@Valid @RequestBody OverdueContDeleteVo overdueContDeleteVo){
        overdueContService.deleteOverdueCont(overdueContDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueContId集合删除逾期合同信息
     * @param overdueContDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "deleteOverdueContsByOverdueContIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueContsByOverdueContIds(@Valid @RequestBody OverdueContDeleteListVo overdueContDeleteListVo){
        overdueContService.deleteOverdueContsByOverdueContIds(overdueContDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 通过contNo取得逾期合同信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findOverdueContByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueContService.findOverdueContByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:
     * @param overdueContVo 分页查询逾期合同vo数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    @RequestMapping(value = "findOverdueContVosByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContVosByPage(OverdueContVo overdueContVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueContService.findOverdueContVosByPage(overdueContVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:
     * @param contNo 根据合同号获取逾期合同号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    @RequestMapping(value = "findOverdueContVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContVoByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueContService.findOverdueContVoByContNo(contNo)), HttpStatus.OK);
    }

}
