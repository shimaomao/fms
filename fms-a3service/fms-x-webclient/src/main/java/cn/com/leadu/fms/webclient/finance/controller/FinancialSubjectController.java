package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialSubjectRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectController
 * @Description: 财务科目管理controller
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_subject")
public class FinancialSubjectController {

    /**
     * @Fields  : 财务科目管理rpc
     */
    @Autowired
    private FinancialSubjectRpc financialSubjectRpc;

    /**
     * @Title:
     * @Description: 分页查询财务科目管理信息
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "findFinancialSubjectsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialSubjectsByPage(FinancialSubjectVo financialSubjectVo){
        Map financialSubjectVoMap = financialSubjectVo == null?null:(Map) JSON.toJSON(financialSubjectVo);
        return financialSubjectRpc.findFinancialSubjectsByPage(financialSubjectVoMap);
    }

    /**
     * @Title:
     * @Description: 保存财务科目管理
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "saveFinancialSubject",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialSubject(@RequestBody FinancialSubjectVo financialSubjectVo){
        return financialSubjectRpc.saveFinancialSubject(financialSubjectVo);
    }

    /**
     * @Title:
     * @Description:  修改财务科目管理
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "modifyFinancialSubject",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialSubject(@RequestBody FinancialSubjectVo financialSubjectVo){
        return financialSubjectRpc.modifyFinancialSubject(financialSubjectVo);
    }

    /**
     * @Title:
     * @Description:   根据subjectId集合删除财务科目管理
     * @param subjectIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "deleteFinancialSubjectsBySubjectIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialSubjectsBySubjectIds(@RequestBody List<FinancialSubjectVo> subjectIds){
        FinancialSubjectVo financialSubjectVo = new FinancialSubjectVo();
        financialSubjectVo.setFinancialSubjectVoList(subjectIds);
        return financialSubjectRpc.deleteFinancialSubjectsBySubjectIds(financialSubjectVo);
    }

    /**
     * @Title:
     * @Description:  根据subjectId获取财务科目管理
     * @param subjectId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "findFinancialSubjectBySubjectId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialSubjectBySubjectId(String subjectId){
        return financialSubjectRpc.findFinancialSubjectBySubjectId(subjectId);
    }

}
