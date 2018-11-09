package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchenghao
 * @ClassName: BizFilesController
 * @Description: 附件信息相关接口
 * @date 2018-04-09
 */
@RestController
@RequestMapping("biz_files")
public class BizFilesController {

    /**
     * @Fields  : 附件信息service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询附件信息信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilessByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilessByPage(BizFilesVo bizFilesVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilessByPage(bizFilesVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据bizCode和bizCodeType获取附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilesByBizInfo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesByBizInfo(BizFilesVo bizFilesVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizInfo(bizFilesVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存附件信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "saveBizFilesBasPartner",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBizFilesBasPartner(@RequestBody BasPartnerVo basPartnerVo){
        bizFilesService.saveBizFiles(basPartnerVo.getBizfilesVo().getBizFilesListVos(),basPartnerVo.getPartnerCode(),BizCodeTypeEnums.PARTNER.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存实际销售方附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "saveSalesBizFilesBasSales",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSalesBizFilesBasSales(@RequestBody BasSalesVo basSalesVo){
        bizFilesService.saveBizFiles(basSalesVo.getBizfilesVo().getBizFilesListVos(),basSalesVo.getSalesCode(),BizCodeTypeEnums.BAS_SALES.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存保险理赔附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "saveBizFilesContInsurClaim",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBizFilesContInsurClaim(@RequestBody ContInsurClaimVo contInsurClaimVo){
        bizFilesService.saveBizFiles(contInsurClaimVo.getBizfilesVo().getBizFilesListVos(),contInsurClaimVo.getContInsurClaimId(),BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存续保任务附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "saveBizFilesRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBizFilesRenewalRegister(@RequestBody RenewalRegisterVo renewalRegisterVo){
        bizFilesService.saveBizFiles(renewalRegisterVo.getBizfilesVo().getBizFilesListVos(),renewalRegisterVo.getRenewalRegisterId(),BizCodeTypeEnums.RENEWAL_REGISTER.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 修改附件信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "updateBizFilesBasPartner",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateBizFilesBasPartner(@RequestBody BasPartnerVo basPartnerVo){
        bizFilesService.updateBizFiles(basPartnerVo.getBizfilesVo().getBizFilesListVos(),basPartnerVo.getPartnerCode(),BizCodeTypeEnums.PARTNER.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 修改实际销售方附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "updateSalesBizFilesBasSales",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> updateSalesBizFilesBasSales(@RequestBody BasSalesVo basSalesVo){
        bizFilesService.updateBizFiles(basSalesVo.getBizfilesVo().getBizFilesListVos(),basSalesVo.getSalesCode(),BizCodeTypeEnums.BAS_SALES.getCodeType());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取附件信息
     * @param bizCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilesByBizCode",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesByBizCode(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.PARTNER.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取实际销售方附件信息
     * @param bizCode
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findSalesBizFilesByBizCode",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSalesBizFilesByBizCode(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.BAS_SALES.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取保险理赔附件信息
     * @param bizCode
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findBizFilesContInsurClaim",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesContInsurClaim(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.CONT_INSUR_CLAIM.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取盗抢险附件信息
     * @param bizCode
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findPilferInsuranceBizFilesByBizCode",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceBizFilesByBizCode(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.PILFER_INSURANCE_FILE.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取续保一览附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findBizFilesRenewalRegister",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesRenewalRegister(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.RENEWAL_REGISTER.getCodeType())), HttpStatus.OK);
    }

    /** 
    * @Description: 获取解抵押附件
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/23 9:52
    */ 
    @RequestMapping(value = "findBizFilesMortgageRegister",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesMortgageRegister(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.MORTGAGE_REGISTER.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Description: 获取解抵押申请附件
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 9:52
     */
    @RequestMapping(value = "findBizFilesMortgageRelFile",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesMortgageRelFile(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.EQU_MORTGAGE_REL_FILE.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取收车机构维护附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findBizFilesCarCollectComp",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesCarCollectComp(String bizCode){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByBizCode(bizCode,BizCodeTypeEnums.CAR_COLLECT_COMP.getCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据fileId获取附件信息
     * @param fileId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilesByFileId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesByFileId(String fileId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesByFileId(fileId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据业务编码和业务类型返回文件list
     * @param: bizCode     业务编码
     * @param: bizCodeType 业务类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 9:54
     */
    @RequestMapping(value = "findBizFilesList", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesList(String bizCode, String bizCodeType){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesService.findBizFilesList(bizCode,bizCodeType)), HttpStatus.OK);
    }


}
