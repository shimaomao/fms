package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangePostVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.PersonBasicChangeRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeController
 * @Description: 个人基本信息变更表controller
 * @date 2018-08-31
 */
@RestController
@RequestMapping("person_basic_change")
public class PersonBasicChangeController {

    /**
     * @Fields  : 个人基本信息变更表rpc
     */
    @Autowired
    private PersonBasicChangeRpc personBasicChangeRpc;

    /**
     * @Title:
     * @Description: 保存个人基本信息变更表
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "savePersonBasicChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> savePersonBasicChange(@RequestBody PersonBasicChangePostVo personBasicChangePostVo){
        return personBasicChangeRpc.savePersonBasicChange(personBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 根据personTaskNo获取个人基本变更信息
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "findCstmPersonByTaskNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersonByTaskNo(String personTaskNo){
        return personBasicChangeRpc.findCstmPersonByTaskNo(personTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据applyNo获取个人基本信息
     * @param applyNo
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo, String personTaskNo){
        return personBasicChangeRpc.findApplyCstmPersonByApplyNo(applyNo, personTaskNo);
    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeApproval(@RequestBody PersonBasicChangePostVo personBasicChangePostVo){
        return personBasicChangeRpc.personBasicChangeApproval(personBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeBack(@RequestBody PersonBasicChangePostVo personBasicChangePostVo){
        return personBasicChangeRpc.personBasicChangeBack(personBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管复审通过
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeReview",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeReview(@RequestBody PersonBasicChangePostVo personBasicChangePostVo){
        return personBasicChangeRpc.personBasicChangeReview(personBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "personBasicChangeReviewBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> personBasicChangeReviewBack(@RequestBody PersonBasicChangePostVo personBasicChangePostVo){
        return personBasicChangeRpc.personBasicChangeReviewBack(personBasicChangePostVo);
    }


}
