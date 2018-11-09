package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist.BasBlacklistVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasBlacklistRpc;
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
 * @author yangyiquan
 * @ClassName: BasBlacklistController
 * @Description: 黑名单controller
 * @date 2018-05-04
 */
@RestController
@RequestMapping("bas_blacklist")
public class BasBlacklistController {

    /**
     * @Fields  : 黑名单rpc
     */
    @Autowired
    private BasBlacklistRpc basBlacklistRpc;

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "findBasBlacklistsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistsByPage(BasBlacklistVo basBlacklistVo){
        Map basBlacklistVoMap = basBlacklistVo == null?null:(Map) JSON.toJSON(basBlacklistVo);
        return basBlacklistRpc.findBasBlacklistsByPage(basBlacklistVoMap);
    }

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "saveBasBlacklist",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBlacklist(@RequestBody BasBlacklistVo basBlacklistVo){
        return basBlacklistRpc.saveBasBlacklist(basBlacklistVo);
    }

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param basBlacklistVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "modifyBasBlacklist",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasBlacklist(@RequestBody BasBlacklistVo basBlacklistVo){
        return basBlacklistRpc.modifyBasBlacklist(basBlacklistVo);
    }

    /**
     * @Title:
     * @Description:   根据blacklistId集合删除黑名单
     * @param blacklistIds
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "deleteBasBlacklistsByBlacklistIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBlacklistsByBlacklistIds(@RequestBody List<String> blacklistIds){
        BasBlacklistVo basBlacklistVo = new BasBlacklistVo();
        basBlacklistVo.setBlacklistIds(blacklistIds);
        return basBlacklistRpc.deleteBasBlacklistsByBlacklistIds(basBlacklistVo);
    }

    /**
     * @Title:
     * @Description:  根据blacklistId获取黑名单
     * @param blacklistId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @RequestMapping(value = "findBasBlacklistByBlacklistId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistByBlacklistId(String blacklistId){
        return basBlacklistRpc.findBasBlacklistByBlacklistId(blacklistId);
    }

    /**
     * @Title:
     * @Description:  根据订单编号，获取该订单中全部的黑名单中的人员
     * @param applyNo 申请编号
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "findBasBlacklistVosByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBlacklistVosByApplyNo(String applyNo) {
        return basBlacklistRpc.findBasBlacklistVosByApplyNo(applyNo);
    }

    /**
     * @Title:
     * @Description: 保存订单中全部热人员信息到黑名单中
     * @param basBlacklistVo 参数
     * @return 数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @RequestMapping(value = "saveBasBlacklistByApplyNo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBlacklistByApplyNo(@RequestBody BasBlacklistVo basBlacklistVo){
        return basBlacklistRpc.saveBasBlacklistByApplyNo(basBlacklistVo);
    }

}
