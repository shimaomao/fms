package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.CountDistributeOverdueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxue
 * @ClassName: ContRepaySkedController
 * @Description: 逾期数据统计分配处理
 * @date 2018-05-08
 */
@RestController
@RequestMapping("count_distribute_overdue")
public class CountDistributeOverdueController {

    @Autowired
    private CountDistributeOverdueService countDistributeOverDueDataService;
    /**
     * @Title:
     * @Description: 分页查询财务科目管理信息
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "distributeOverdueData" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> distributeOverdueData(){
        countDistributeOverDueDataService.distributeOverdueData();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
