package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueContRpc;
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
 * @ClassName: OverdueContController
 * @Description: 逾期合同信息controller
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_cont")
public class OverdueContController {

    /**
     * @Fields  : 逾期合同信息rpc
     */
    @Autowired
    private OverdueContRpc overdueContRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期合同信息信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findOverdueContsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContsByPage(OverdueContVo overdueContVo){
        Map overdueContVoMap = overdueContVo == null?null:(Map) JSON.toJSON(overdueContVo);
        return overdueContRpc.findOverdueContsByPage(overdueContVoMap);
    }

    /**
     * @Title:
     * @Description: 保存逾期合同信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "saveOverdueCont",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCont(@RequestBody OverdueContVo overdueContVo){
        return overdueContRpc.saveOverdueCont(overdueContVo);
    }

    /**
     * @Title:
     * @Description:  修改逾期合同信息
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "modifyOverdueCont",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCont(@RequestBody OverdueContVo overdueContVo){
        return overdueContRpc.modifyOverdueCont(overdueContVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueContId集合删除逾期合同信息
     * @param overdueContIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "deleteOverdueContsByOverdueContIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueContsByOverdueContIds(@RequestBody List<String> overdueContIds){
        OverdueContVo overdueContVo = new OverdueContVo();
        overdueContVo.setOverdueContIds(overdueContIds);
        return overdueContRpc.deleteOverdueContsByOverdueContIds(overdueContVo);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期合同vo数据
     * @param overdueContVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findOverdueContVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContVosByPage(OverdueContVo overdueContVo){
        Map overdueContVoMap = overdueContVo == null?null:(Map) JSON.toJSON(overdueContVo);
        return overdueContRpc.findOverdueContVosByPage(overdueContVoMap);
    }

    /**
     * @Title:
     * @Description:
     * @param contNo 根据合同号获取逾期合同号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    @RequestMapping(value = "findOverdueContVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueContVoByContNo(String contNo){
        return overdueContRpc.findOverdueContVoByContNo(contNo);
    }


}
