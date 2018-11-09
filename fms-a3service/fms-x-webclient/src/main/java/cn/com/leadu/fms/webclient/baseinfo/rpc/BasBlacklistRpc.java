package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist.BasBlacklistVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistController
 * @Description: 黑名单rpc
 * @date 2018-05-04
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasBlacklistRpc {

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param basBlacklistVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/findBasBlacklistsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasBlacklistsByPage(@RequestParam Map<String,Object> basBlacklistVoMap);

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/saveBasBlacklist",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasBlacklist(@RequestBody BasBlacklistVo basBlacklistVo);

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/modifyBasBlacklist",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasBlacklist(@RequestBody BasBlacklistVo basBlacklistVo);

    /**
     * @Title:
     * @Description:   根据blacklistId集合删除黑名单
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/deleteBasBlacklistsByBlacklistIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasBlacklistsByBlacklistIds(@RequestBody BasBlacklistVo basBlacklistVo);

    /**
     * @Title:
     * @Description:  根据blacklistId获取黑名单
     * @param blacklistId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/findBasBlacklistByBlacklistId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasBlacklistByBlacklistId(@RequestParam("blacklistId") String blacklistId);

    /**
     * @Title:
     * @Description:  根据订单编号，获取该订单中全部的黑名单中的人员
     * @param applyNo 申请编号
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/findBasBlacklistVosByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasBlacklistVosByApplyNo(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description: 保存订单中全部热人员信息到黑名单中
     * @param basBlacklistVo 参数
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "api/baseinfo/bas_blacklist/saveBasBlacklistByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> saveBasBlacklistByApplyNo(@RequestBody BasBlacklistVo basBlacklistVo);

}
