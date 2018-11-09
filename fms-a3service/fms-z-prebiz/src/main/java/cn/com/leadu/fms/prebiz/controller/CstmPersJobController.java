package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.prebiz.service.CstmPersJobService;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobController
 * @Description: 客户个人职业信息相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_job")
public class CstmPersJobController {

    /**
     * @Fields  : 客户个人职业信息service
     */
    @Autowired
    private CstmPersJobService cstmPersJobService;

    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息信息
     * @param cstmPersJobVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "findCstmPersJobsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersJobsByPage(CstmPersJobVo cstmPersJobVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(cstmPersJobService.findCstmPersJobsByPage(cstmPersJobVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存客户个人职业信息
     * @param cstmPersJobSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
//    @RequestMapping(value = "saveCstmPersJob",method = RequestMethod.POST)
//    public ResponseEntity<RestResponse> saveCstmPersJob(@Valid @RequestBody CstmPersJobSaveVo cstmPersJobSaveVo){
//        cstmPersJobService.saveCstmPersJob(cstmPersJobSaveVo);
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description:  修改客户个人职业信息
     * @param cstmPersJobModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "modifyCstmPersJob",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersJob(@Valid @RequestBody CstmPersJobModifyVo cstmPersJobModifyVo){
        cstmPersJobService.modifyCstmPersJob(cstmPersJobModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除客户个人职业信息
     * @param cstmPersJobDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "deleteCstmPersJob",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersJob(@Valid @RequestBody CstmPersJobDeleteVo cstmPersJobDeleteVo){
        cstmPersJobService.deleteCstmPersJob(cstmPersJobDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据persJobId集合删除客户个人职业信息
     * @param cstmPersJobDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "deleteCstmPersJobsByPersJobIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersJobsByPersJobIds(@Valid @RequestBody CstmPersJobDeleteListVo cstmPersJobDeleteListVo){
        cstmPersJobService.deleteCstmPersJobsByPersJobIds(cstmPersJobDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据persJobId获取客户个人职业信息
     * @param persJobId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "findCstmPersJobByPersJobId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersJobByPersJobId(String persJobId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(cstmPersJobService.findCstmPersJobByPersJobId(persJobId)), HttpStatus.OK);
    }

}
