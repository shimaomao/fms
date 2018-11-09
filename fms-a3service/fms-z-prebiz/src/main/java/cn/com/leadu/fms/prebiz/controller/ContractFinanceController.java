package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.prebiz.service.ContractFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author huchenghao
 * @ClassName: ContractFinanceController
 * @Description: 合同信息相关接口
 * @date 2018-04-11
 */
@RestController
@RequestMapping("contract_finance")
public class ContractFinanceController {

    /**
     * @Fields  : 合同信息service
     */
    @Autowired
    private ContractFinanceService contractFinanceService;

    /**
     * @Title:
     * @Description: 分页查询合同信息信息
     * @param contractFinanceVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "findContractFinancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractFinancesByPage(ContractFinanceVo contractFinanceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractFinanceService.findContractFinancesByPage(contractFinanceVo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 根据合同号查找保证金，保证金返还方式 = 一次性的场合 ，不是一次性返回0
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 16:33
    */ 
    @RequestMapping(value = "findContractFinancesDepositByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractFinancesDepositByContNo(String contNo ){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractFinanceService.findContractFinancesDepositByContNo(contNo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 根据合同号获取合同融资信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 20:27
    */ 
    @RequestMapping(value = "findContractFinanceVoByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractFinanceVoByContNo(String contNo ){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractFinanceService.findContractFinanceVoByContNo(contNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 有模板出excel测试
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "testExport" , method = RequestMethod.GET)
    public void testExport(HttpServletResponse httpServletResponse){
        contractFinanceService.testExport(httpServletResponse);
    }
}
