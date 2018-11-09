package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectController
 * @Description: 财务科目管理rpc
 * @date 2018-06-20
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialSubjectRpc {

    /**
     * @Title:
     * @Description: 分页查询财务科目管理信息
     * @param financialSubjectVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "api/finance/financial_subject/findFinancialSubjectsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialSubjectsByPage(@RequestParam Map<String,Object> financialSubjectVoMap);

    /**
     * @Title:
     * @Description: 保存财务科目管理
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "api/finance/financial_subject/saveFinancialSubject",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinancialSubject(@RequestBody FinancialSubjectVo financialSubjectVo);

    /**
     * @Title:
     * @Description:  修改财务科目管理
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "api/finance/financial_subject/modifyFinancialSubject",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinancialSubject(@RequestBody FinancialSubjectVo financialSubjectVo);

    /**
     * @Title:
     * @Description:   根据subjectId集合删除财务科目管理
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "api/finance/financial_subject/deleteFinancialSubjectsBySubjectIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinancialSubjectsBySubjectIds(@RequestBody FinancialSubjectVo financialSubjectVo);

    /**
     * @Title:
     * @Description:  根据subjectId获取财务科目管理
     * @param subjectId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "api/finance/financial_subject/findFinancialSubjectBySubjectId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialSubjectBySubjectId(@RequestParam("subjectId") String subjectId);

}
