package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmcompany.CstmCompanyVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmCompanyRpc;
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
 * @author ningyangyang
 * @ClassName: CstmCompanyController
 * @Description: 客户企业基本信息controller
 * @date 2018-03-27
 */
@RestController
@RequestMapping("cstm_company")
public class CstmCompanyController {

    /**
     * @Fields  : 客户企业基本信息rpc
     */
    @Autowired
    private CstmCompanyRpc cstmCompanyRpc;

    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息信息
     * @param cstmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "findCstmCompanysByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanysByPage(CstmCompanyVo cstmCompanyVo){
        Map cstmCompanyVoMap = cstmCompanyVo == null?null:(Map) JSON.toJSON(cstmCompanyVo);
        return cstmCompanyRpc.findCstmCompanysByPage(cstmCompanyVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户企业基本信息
     * @param cstmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "saveCstmCompany",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmCompany(@RequestBody CstmCompanyVo cstmCompanyVo){
        return cstmCompanyRpc.saveCstmCompany(cstmCompanyVo);
    }

    /**
     * @Title:
     * @Description:  修改客户企业基本信息
     * @param cstmCompanyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "modifyCstmCompany",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmCompany(@RequestBody CstmCompanyVo cstmCompanyVo){
        return cstmCompanyRpc.modifyCstmCompany(cstmCompanyVo);
    }

    /**
     * @Title:
     * @Description:   根据cstmCompanyId集合删除客户企业基本信息
     * @param cstmCompanyIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "deleteCstmCompanysByCstmCompanyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmCompanysByCstmCompanyIds(@RequestBody List<String> cstmCompanyIds){
        CstmCompanyVo cstmCompanyVo = new CstmCompanyVo();
        cstmCompanyVo.setCstmCompanyIds(cstmCompanyIds);
        return cstmCompanyRpc.deleteCstmCompanysByCstmCompanyIds(cstmCompanyVo);
    }

    /**
     * @Title:
     * @Description:  根据cstmCompanyId获取客户企业基本信息
     * @param cstmCompanyId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @RequestMapping(value = "findCstmCompanyByCstmCompanyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmCompanyByCstmCompanyId(String cstmCompanyId){
        return cstmCompanyRpc.findCstmCompanyByCstmCompanyId(cstmCompanyId);
    }

}
