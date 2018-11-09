package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.companybasicchange.CompanyBasicChangePostVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.CompanyBasicChangeRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijunjun
 * @ClassName: CompanyBasicChangeController
 * @Description: 企业基本信息变更controller
 * @date 2018-09-01
 */
@RestController
@RequestMapping("company_basic_change")
public class CompanyBasicChangeController {

    /**
     * @Fields  : 企业基本信息变更rpc
     */
    @Autowired
    private CompanyBasicChangeRpc companyBasicChangeRpc;

    /**
     * @Title:
     * @Description: 保存企业基本信息变更
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "saveCompanyBasicChange",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCompanyBasicChange(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo){
        return companyBasicChangeRpc.saveCompanyBasicChange(companyBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业变更信息
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "findCstmCompanyByTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanyByTaskNo(String companyTaskNo){
        return companyBasicChangeRpc.findCstmCompanyByTaskNo(companyTaskNo);
    }

    /**
     * @Title:
     * @Description:  根据companyTaskNo获取企业变更信息
     * @param applyNo
     * @param companyTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 10:10:36
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo, String companyTaskNo){
        return companyBasicChangeRpc.findApplyCstmPersonByApplyNo(applyNo, companyTaskNo);
    }

    /**
     * @Title:
     * @Description: 资管审核通过
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeApproval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeApproval(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo){
        return companyBasicChangeRpc.companyBasicChangeApproval(companyBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管审核退回
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeBack(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo){
        return companyBasicChangeRpc.companyBasicChangeBack(companyBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管复核通过
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeReview",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeReview(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo){
        return companyBasicChangeRpc.companyBasicChangeReview(companyBasicChangePostVo);
    }

    /**
     * @Title:
     * @Description: 资管复核退回
     * @param companyBasicChangePostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @RequestMapping(value = "companyBasicChangeReviewBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> companyBasicChangeReviewBack(@RequestBody CompanyBasicChangePostVo companyBasicChangePostVo){
        return companyBasicChangeRpc.companyBasicChangeReviewBack(companyBasicChangePostVo);
    }

}
