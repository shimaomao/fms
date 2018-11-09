package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.webclient.finance.rpc.ContOverdueRpc;
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
 * @author lijunjun
 * @ClassName: ContOverdueController
 * @Description: 还款逾期罚息controller
 * @date 2018-05-08
 */
@RestController
@RequestMapping("cont_overdue")
public class ContOverdueController {

    /**
     * @Fields  : 还款逾期罚息rpc
     */
    @Autowired
    private ContOverdueRpc contOverdueRpc;

    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息信息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "findContOverduesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverduesByPage(ContOverdueVo contOverdueVo){
        Map contOverdueVoMap = contOverdueVo == null?null:(Map) JSON.toJSON(contOverdueVo);
        return contOverdueRpc.findContOverduesByPage(contOverdueVoMap);
    }

    /**
     * @Title:
     * @Description: 保存还款逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "saveContOverdue",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContOverdue(@RequestBody ContOverdueVo contOverdueVo){
        return contOverdueRpc.saveContOverdue(contOverdueVo);
    }

    /**
     * @Title:
     * @Description:  修改还款逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "modifyContOverdue",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContOverdue(@RequestBody ContOverdueVo contOverdueVo){
        return contOverdueRpc.modifyContOverdue(contOverdueVo);
    }

    /**
     * @Title:
     * @Description:   根据contOverdueId集合删除还款逾期罚息
     * @param contOverdueIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "deleteContOverduesByContOverdueIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContOverduesByContOverdueIds(@RequestBody List<String> contOverdueIds){
        ContOverdueVo contOverdueVo = new ContOverdueVo();
        contOverdueVo.setContOverdueIds(contOverdueIds);
        return contOverdueRpc.deleteContOverduesByContOverdueIds(contOverdueVo);
    }

    /**
     * @Title:
     * @Description:  根据contOverdueId获取还款逾期罚息
     * @param contOverdueId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "findContOverdueByContOverdueId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueByContOverdueId(String contOverdueId){
        return contOverdueRpc.findContOverdueByContOverdueId(contOverdueId);
    }

}
