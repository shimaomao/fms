package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangePostVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeController
 * @Description: 企业基本信息变更rpc
 * @date 2018-09-01
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface CompanyBasicChangeRpc {

    /**
     * @Title:
     * @Description: 保存企业基本信息变更
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/saveCompanyBasicChange",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveCompanyBasicChange(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo);

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业基本信息变更
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/findCstmCompanyByTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findCstmCompanyByTaskNo(@RequestParam("companyTaskNo") String companyTaskNo);

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业基本信息变更
     * @param applyNo
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(@RequestParam("applyNo") String applyNo, @RequestParam("companyTaskNo") String companyTaskNo);

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/companyBasicChangeApproval", method = RequestMethod.GET)
    ResponseEntity<RestResponse> companyBasicChangeApproval(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/companyBasicChangeBack", method = RequestMethod.GET)
    ResponseEntity<RestResponse> companyBasicChangeBack(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/companyBasicChangeReview", method = RequestMethod.GET)
    ResponseEntity<RestResponse> companyBasicChangeReview(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo);

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "api/postbiz/company_basic_change/companyBasicChangeReviewBack", method = RequestMethod.GET)
    ResponseEntity<RestResponse> companyBasicChangeReviewBack(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo);

}
