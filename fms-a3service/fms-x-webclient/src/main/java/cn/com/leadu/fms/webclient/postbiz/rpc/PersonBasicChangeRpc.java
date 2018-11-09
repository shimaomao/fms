package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangePostVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeController
 * @Description: 个人基本信息变更表rpc
 * @date 2018-08-31
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface PersonBasicChangeRpc {

    /**
     * @Title:
     * @Description: 保存个人基本信息变更表
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/savePersonBasicChange",method = RequestMethod.POST)
    ResponseEntity<RestResponse> savePersonBasicChange(@RequestBody PersonBasicChangePostVo personBasicChangePostVo);

    /**
     * @Title:
     * @Description:  根据personTaskNo获取个人基本信息变更表
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/findCstmPersonByTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmPersonByTaskNo(@RequestParam("personTaskNo") String personTaskNo);

    /**
     * @Title:
     * @Description:  根据personTaskNo获取个人基本信息变更表
     * @param applyNo
     * @param personTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(@RequestParam("applyNo") String applyNo, @RequestParam("personTaskNo") String personTaskNo);

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/personBasicChangeApproval", method = RequestMethod.GET)
    ResponseEntity<RestResponse> personBasicChangeApproval(@RequestBody PersonBasicChangePostVo personBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/personBasicChangeBack", method = RequestMethod.GET)
    ResponseEntity<RestResponse> personBasicChangeBack(@RequestBody PersonBasicChangePostVo personBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/personBasicChangeReview", method = RequestMethod.GET)
    ResponseEntity<RestResponse> personBasicChangeReview(@RequestBody PersonBasicChangePostVo personBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param personBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/person_basic_change/personBasicChangeReviewBack", method = RequestMethod.GET)
    ResponseEntity<RestResponse> personBasicChangeReviewBack(@RequestBody PersonBasicChangePostVo personBasicChangePostVo);

}
