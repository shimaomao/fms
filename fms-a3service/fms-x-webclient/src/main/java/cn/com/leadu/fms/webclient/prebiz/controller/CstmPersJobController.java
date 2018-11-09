package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.CstmPersJobRpc;
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
 * @ClassName: CstmPersJobController
 * @Description: 客户个人职业信息controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("cstm_pers_job")
public class CstmPersJobController {

    /**
     * @Fields  : 客户个人职业信息rpc
     */
    @Autowired
    private CstmPersJobRpc cstmPersJobRpc;

    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息信息
     * @param cstmPersJobVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "findCstmPersJobsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersJobsByPage(CstmPersJobVo cstmPersJobVo){
        Map cstmPersJobVoMap = cstmPersJobVo == null?null:(Map) JSON.toJSON(cstmPersJobVo);
        return cstmPersJobRpc.findCstmPersJobsByPage(cstmPersJobVoMap);
    }

    /**
     * @Title:
     * @Description: 保存客户个人职业信息
     * @param cstmPersJobVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "saveCstmPersJob",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCstmPersJob(@RequestBody CstmPersJobVo cstmPersJobVo){
        return cstmPersJobRpc.saveCstmPersJob(cstmPersJobVo);
    }

    /**
     * @Title:
     * @Description:  修改客户个人职业信息
     * @param cstmPersJobVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "modifyCstmPersJob",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCstmPersJob(@RequestBody CstmPersJobVo cstmPersJobVo){
        return cstmPersJobRpc.modifyCstmPersJob(cstmPersJobVo);
    }

    /**
     * @Title:
     * @Description:   根据persJobId集合删除客户个人职业信息
     * @param persJobIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "deleteCstmPersJobsByPersJobIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCstmPersJobsByPersJobIds(@RequestBody List<String> persJobIds){
        CstmPersJobVo cstmPersJobVo = new CstmPersJobVo();
        cstmPersJobVo.setPersJobIds(persJobIds);
        return cstmPersJobRpc.deleteCstmPersJobsByPersJobIds(cstmPersJobVo);
    }

    /**
     * @Title:
     * @Description:  根据persJobId获取客户个人职业信息
     * @param persJobId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:47
     */
    @RequestMapping(value = "findCstmPersJobByPersJobId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCstmPersJobByPersJobId(String persJobId){
        return cstmPersJobRpc.findCstmPersJobByPersJobId(persJobId);
    }

}
