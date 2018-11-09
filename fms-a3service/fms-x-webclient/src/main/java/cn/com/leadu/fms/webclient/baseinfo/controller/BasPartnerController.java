package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasPartnerRpc;
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
 * @author huchenghao
 * @ClassName: BasPartnerController
 * @Description: 经销商信息维护controller
 * @date 2018-03-17
 */
@RestController
@RequestMapping("bas_partner")
public class BasPartnerController {

    /**
     * @Fields  : 经销商信息维护rpc
     */
    @Autowired
    private BasPartnerRpc basPartnerRpc;

    /**
     * @Title:
     * @Description: 分页查询经销商信息维护信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "findBasPartnersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnersByPage(BasPartnerVo basPartnerVo){
        Map basPartnerVoMap = basPartnerVo == null?null:(Map) JSON.toJSON(basPartnerVo);
        return basPartnerRpc.findBasPartnersByPage(basPartnerVoMap);
    }

    /**
     * @Title:
     * @Description: 保存经销商信息维护
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "saveBasPartner",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasPartner(@RequestBody BasPartnerVo basPartnerVo){
        return basPartnerRpc.saveBasPartner(basPartnerVo);
    }

    /**
     * @Title:
     * @Description:  修改经销商信息维护
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "modifyBasPartner",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasPartner(@RequestBody BasPartnerVo basPartnerVo){
        return basPartnerRpc.modifyBasPartner(basPartnerVo);
    }

    /**
     * @Title:
     * @Description:   根据partnerId集合删除经销商信息维护
     * @param partnerIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "deleteBasPartnersByPartnerIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasPartnersByPartnerIds(@RequestBody List<String> partnerIds){
        BasPartnerVo basPartnerVo = new BasPartnerVo();
        basPartnerVo.setPartnerIds(partnerIds);
        return basPartnerRpc.deleteBasPartnersByPartnerIds(basPartnerVo);
    }

    /**
     * @Title:
     * @Description:  根据partnerId获取经销商信息维护
     * @param partnerId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @RequestMapping(value = "findBasPartnerByPartnerId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnerByPartnerId(String partnerId){
        return basPartnerRpc.findBasPartnerByPartnerId(partnerId);
    }

    /**
     * @Title:
     * @Description:  根据当经销商代码，获取经销商信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-22 19:35:32
     */
    @RequestMapping(value = "findBasPartnerByLoginUser", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasPartnerByLoginUser(){
        return basPartnerRpc.findBasPartnerByLoginUser();
    }

}
