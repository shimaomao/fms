package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.webclient.cost.rpc.OverdueExemptRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: OverdueContController
 * @Description: 逾期罚息controller
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_exempt")
public class OverdueExemptController {

    /**
     * @Fields  : 逾期罚息信息rpc
     */
    @Autowired
    private OverdueExemptRpc overdueExemptRpc;


    /**
     * @Title:
     * @Description: 分页查询罚息免除任务表信息
     * @param overdueExemptVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @RequestMapping(value = "findOverdueExemptsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueExemptsByPage(OverdueExemptVo overdueExemptVo){
        Map overdueExemptVoMap = overdueExemptVo == null?null:(Map) JSON.toJSON(overdueExemptVo);
        return overdueExemptRpc.findOverdueExemptsByPage(overdueExemptVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findContOverdueVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueVosByPage(ContOverdueVo contOverdueVo){
        Map contOverdueVoMap = contOverdueVo == null?null:(Map) JSON.toJSON(contOverdueVo);
        return overdueExemptRpc.findContOverdueVosByPage(contOverdueVoMap);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取逾期罚息信息和合同信息(初次提交页面回显)
     * @param contNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findDetailBycontNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailBycontNo(String contNo){
        return overdueExemptRpc.findDetailBycontNo(contNo);
    }

    /**
     * @Title:
     * @Description:  根据serviceId获取逾期合同信息(退回)(二次提交页面回显)
     * @param serviceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "findDetailByServiceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailByServiceId(String serviceId){
        return overdueExemptRpc.findDetailByServiceId(serviceId);
    }

    /**
     * @Title:
     * @Description: 根据serviceId获取审批详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
   /* @RequestMapping(value = "findDetailByServiceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailByServiceId(String serviceId){
        return overdueExemptRpc.findDetailByServiceId(serviceId);
    }*/

    /**
     * @Title:
     * @Description: 罚息免除
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "entryOverdueCont",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> entryOverdueCont(@RequestBody OverdueExemptVo overdueExemptVo){
        return overdueExemptRpc.entryOverdueCont(overdueExemptVo);
    }

    /**
     * @Title:
     * @Description: 罚息免除审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody OverdueExemptVo overdueExemptVo){
        return overdueExemptRpc.approval(overdueExemptVo);
    }

    /**
     * @Title:
     * @Description: 罚息免除审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody OverdueExemptVo overdueExemptVo){
        return overdueExemptRpc.sendBack(overdueExemptVo);
    }
}
