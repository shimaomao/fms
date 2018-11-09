package cn.com.leadu.fms.product.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import cn.com.leadu.fms.product.service.IntrstFactorService;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorController
 * @Description: 利率因子相关接口
 * @date 2018-03-27
 */
@RestController
@RequestMapping("intrst_factor")
public class IntrstFactorController {

    /**
     * @Fields  : 利率因子service
     */
    @Autowired
    private IntrstFactorService intrstFactorService;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "findIntrstFactorsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorsByPage(IntrstFactorVo intrstFactorVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(intrstFactorService.findIntrstFactorsByPage(intrstFactorVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param intrstFactorSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "saveIntrstFactor",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveIntrstFactor(@Valid @RequestBody IntrstFactorSaveVo intrstFactorSaveVo){
        intrstFactorService.saveIntrstFactor(intrstFactorSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param intrstFactorModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "modifyIntrstFactor",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyIntrstFactor(@Valid @RequestBody IntrstFactorModifyVo intrstFactorModifyVo){
        intrstFactorService.modifyIntrstFactor(intrstFactorModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除利率因子
     * @param intrstFactorDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "deleteIntrstFactor",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteIntrstFactor(@Valid @RequestBody IntrstFactorDeleteVo intrstFactorDeleteVo){
        intrstFactorService.deleteIntrstFactor(intrstFactorDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据intrstFactorId集合删除利率因子
     * @param intrstFactorDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "deleteIntrstFactorsByIntrstFactorIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteIntrstFactorsByIntrstFactorIds(@Valid @RequestBody IntrstFactorDeleteListVo intrstFactorDeleteListVo){
        intrstFactorService.deleteIntrstFactorsByIntrstFactorIds(intrstFactorDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据intrstFactorId获取利率因子
     * @param intrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:10
     */
    @RequestMapping(value = "findIntrstFactorByIntrstFactorId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorByIntrstFactorId(String intrstFactorId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(intrstFactorService.findIntrstFactorByIntrstFactorId(intrstFactorId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 取得全部启用的利率因子
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-27 18:07:17
     */
    @RequestMapping(value = "findIntrstFactorAllList" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findIntrstFactorAllList(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(intrstFactorService.findIntrstFactorAllList()), HttpStatus.OK);
    }

}
