package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/4/28.
 */

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 合同一览查询
 * @author: yangyiquan
 * @create: 2018-04-28 11:01
 **/
@RestController
@RequestMapping("contract")
public class ContractController {

    /**
     * @Fields  : 合同信息业务Service
     */
    @Autowired
    private ContractService contractService;

    /** 
    * @Description: 分页查询合同信息一览
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/4/28 11:31
    */
    @RequestMapping(value="findContractListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractListByPage(ContractListVo contractListVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContractListByPage(contractListVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Description: 当月新增放款车辆明细查询合同信息一览
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/28 11:31
     */
    @RequestMapping(value="findNewLoanByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findNewLoanByPage(ContractListVo contractListVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findNewLoanByPage(contractListVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Description: 当月新增放款车辆明细导出
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/4/28 11:31
     */
    @RequestMapping(value="findNewLoanExport",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findNewLoanExport(ContractListVo contractListVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findNewLoanExport(contractListVo,sysUser)), HttpStatus.OK);
    }

    /**
    * @Description: 合同一览信息选择
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/28 16:55
    */
    @RequestMapping(value="findContractSelectListByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractSelectListByPage(ContractListVo contractListVo, @AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContractSelectListByPage(contractListVo,sysUser)), HttpStatus.OK);
    }

    /**
     * @Description: 根据状态查找合同
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/14 11:31
     */
    @RequestMapping(value="findContractsByContractStatus",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractsByContractStatus(Contract contract){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContractsByContractStatus(contract)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取合同详情顶部信息
     * @param contNo
     * @return ApplyBaseInfoVo
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value="findContBaseInfo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContBaseInfo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContBaseInfo(contNo)), HttpStatus.OK);
    }

    /**
     * @Description: 根据合同编号查找合同
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:31
     */
    @RequestMapping(value="findContractByContractNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractByContractNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContractByContractNo(contNo)), HttpStatus.OK);
    }

    /**
    * @Description: 获取财务核算代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 16:37
    */
    @RequestMapping(value="findContractVoFinassCodes",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractVoFinassCodes(String applyNo,String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractService.findContractVoFinassCodes(applyNo,contNo)), HttpStatus.OK);
    }

}
