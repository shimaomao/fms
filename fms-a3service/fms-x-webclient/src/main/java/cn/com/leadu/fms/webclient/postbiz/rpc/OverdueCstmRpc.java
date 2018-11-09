package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmController
 * @Description: 逾期客户信息rpc
 * @date 2018-05-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueCstmRpc {

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息信息
     * @param overdueCstmVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findOverdueCstmsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmsByPage(@RequestParam Map<String, Object> overdueCstmVoMap);


    /**
     * @Title:
     * @Description: 保存逾期客户各种信息
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/saveOverdueCstmInfo",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueCstmInfo(@RequestBody OverdueCstmPostVo overdueCstmPostVo);

    /**
     * @Title:
     * @Description: 催收函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/collectionLetterDownload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> collectionLetterDownload(@RequestBody OverdueCstmPostVo overdueCstmPostVo);

    /**
     * @Title:
     * @Description: 律师函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/lawyerLetterDownload",method = RequestMethod.POST)
    ResponseEntity<RestResponse> lawyerLetterDownload(@RequestBody OverdueCstmPostVo overdueCstmPostVo);

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findOverdueCstmByOverdueCstmId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmByOverdueCstmId(@RequestParam("overdueCstmId") String overdueCstmId);

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findOverdueCstmVoByOverdueCstmId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmVoByOverdueCstmId(@RequestParam("overdueCstmId") String overdueCstmId);

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取还款信息和逾期信息
     * @param overdueCstmVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findContRepaySkedAndOverduByoverdueCstmId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedAndOverduByoverdueCstmId(@RequestParam Map<String, Object> overdueCstmVoMap);

    /**
     * @Title:
     * @Description:  当前销售未还剩余本金 -->打开 合同还款计划表
     * @param overdueCstmVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findContRepaySkedVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedVoByContNo(@RequestParam Map<String, Object> overdueCstmVoMap);

    /**
     * @Title:
     * @Description:  当前财务未还剩余本金 -->打开【财务还款计划表】*关联合同还款计划表取得扣款状态
     * @param overdueCstmVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findContOverdueVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContOverdueVoByContNo(@RequestParam Map<String, Object> overdueCstmVoMap);

    /**
     * @Title:
     * @Description:  获取登记电话、地址等基础信息
     * @param overdueCstmVoPostMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findOverdueRegisterInfo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueRegisterInfo(@RequestParam Map<String, Object> overdueCstmVoPostMap);

    /**
     * @Title:
     * @Description: 获取分配人员信息
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "api/postbiz/overdue_cstm/findAssignUsers", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAssignUsers();
}
