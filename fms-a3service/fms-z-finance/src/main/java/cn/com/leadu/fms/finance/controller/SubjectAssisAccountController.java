package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.SubjectAssisAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SubjectAssisAccountController
 * @Description: 财务凭证数据相关接口
 * @date 2018-06-25
 */
@RestController
@RequestMapping("subject_assis_account")
public class SubjectAssisAccountController {

    /**
     * @Fields  : 财务凭证数据service
     */
    @Autowired
    private SubjectAssisAccountService subjectAssisAccountService;

    /**
     * @Title:
     * @Description:   根据科目代码查询科目核算管理
     * @param subjectCds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:21:23
     */
    @RequestMapping(value = "findSubjectAssisAccountsBySubjectCd" , method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSubjectAssisAccountsBySubjectCd(@RequestParam List<String> subjectCds){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                subjectAssisAccountService.findSubjectAssisAccountsBySubjectCds(subjectCds)
        ), HttpStatus.OK);
    }

}
