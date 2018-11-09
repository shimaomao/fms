package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueCstmRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmController
 * @Description: 逾期客户信息controller
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_cstm")
public class OverdueCstmController {

    /**
     * @Fields  : 逾期客户信息rpc
     */
    @Autowired
    private OverdueCstmRpc overdueCstmRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmsByPage(OverdueCstmVo overdueCstmVo){
        Map overdueCstmVoMap = overdueCstmVo == null?null:(Map) JSON.toJSON(overdueCstmVo);
        return overdueCstmRpc.findOverdueCstmsByPage(overdueCstmVoMap);
    }

    /**
     * @Title:
     * @Description: 保存各种信息
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "saveOverdueCstmInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmInfo(@RequestBody OverdueCstmPostVo overdueCstmPostVo){
        return overdueCstmRpc.saveOverdueCstmInfo(overdueCstmPostVo);
    }

    /**
     * @Title:
     * @Description: 催收函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "collectionLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionLetterDownload(@RequestBody OverdueCstmPostVo overdueCstmPostVo){
        return overdueCstmRpc.collectionLetterDownload(overdueCstmPostVo);
    }

    /**
     * @Title:
     * @Description: 律师函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "lawyerLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawyerLetterDownload(@RequestBody OverdueCstmPostVo overdueCstmPostVo){
        return overdueCstmRpc.lawyerLetterDownload(overdueCstmPostVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmByOverdueCstmId(String overdueCstmId){
        return overdueCstmRpc.findOverdueCstmByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmVoByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmVoByOverdueCstmId(String overdueCstmId){
        return overdueCstmRpc.findOverdueCstmVoByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取还款信息和逾期信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContRepaySkedAndOverduByoverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedAndOverduByoverdueCstmId(OverdueCstmVo overdueCstmVo){
        Map<String, Object> overdueCstmVoMap = overdueCstmVo == null?null:(Map) JSON.toJSON(overdueCstmVo);
        return overdueCstmRpc.findContRepaySkedAndOverduByoverdueCstmId(overdueCstmVoMap);
    }

    /**
     * @Title:
     * @Description:  当前销售未还剩余本金 -->打开 合同还款计划表
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContRepaySkedVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedVoByContNo(OverdueCstmVo overdueCstmVo){
        Map<String, Object> overdueCstmVoMap = overdueCstmVo == null?null:(Map) JSON.toJSON(overdueCstmVo);
        return overdueCstmRpc.findContRepaySkedVoByContNo(overdueCstmVoMap);
    }

    /**
     * @Title:
     * @Description:  当前财务未还剩余本金 -->打开【财务还款计划表】*关联合同还款计划表取得扣款状态
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContOverdueVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueVoByContNo(OverdueCstmVo overdueCstmVo){
        Map<String, Object> overdueCstmVoMap = overdueCstmVo == null?null:(Map) JSON.toJSON(overdueCstmVo);
        return overdueCstmRpc.findContOverdueVoByContNo(overdueCstmVoMap);
    }

    /**
     * @Title:
     * @Description:  获取登记电话、地址等基础信息
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueRegisterInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueRegisterInfo(OverdueCstmPostVo overdueCstmPostVo){
        Map<String, Object> overdueCstmPostVoMap = overdueCstmPostVo == null?null:(Map) JSON.toJSON(overdueCstmPostVo);
        return overdueCstmRpc.findOverdueRegisterInfo(overdueCstmPostVoMap);
    }

    /**
     * @Title:
     * @Description: 获取分配人员信息
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findAssignUsers", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssignUsers(){
        return overdueCstmRpc.findAssignUsers();
    }
}
