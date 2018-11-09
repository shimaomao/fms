package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: BasPartnerController
 * @Description: 经销商信息维护rpc
 * @date 2018-03-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasPartnerRpc {

    /**
     * @Title:
     * @Description: 分页查询经销商信息维护信息
     * @param basPartnerVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/findBasPartnersByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasPartnersByPage(@RequestParam Map<String, Object> basPartnerVoMap);

    /**
     * @Title:
     * @Description: 保存经销商信息维护
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/saveBasPartner",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasPartner(@RequestBody BasPartnerVo basPartnerVo);

    /**
     * @Title:
     * @Description:  修改经销商信息维护
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/modifyBasPartner",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasPartner(@RequestBody BasPartnerVo basPartnerVo);

    /**
     * @Title:
     * @Description:   根据partnerId集合删除经销商信息维护
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/deleteBasPartnersByPartnerIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasPartnersByPartnerIds(@RequestBody BasPartnerVo basPartnerVo);

    /**
     * @Title:
     * @Description:  根据partnerId获取经销商信息维护
     * @param partnerId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/findBasPartnerByPartnerId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasPartnerByPartnerId(@RequestParam("partnerId") String partnerId);

    /**
     * @Title:
     * @Description:  根据当经销商代码，获取经销商信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-22 19:35:32
     */
    @RequestMapping(value = "api/baseinfo/bas_partner/findBasPartnerByLoginUser", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasPartnerByLoginUser();

}
