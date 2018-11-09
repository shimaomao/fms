package cn.com.leadu.fms.finance.rpc.thirdinterface;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeResultFileVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeRpc
 * @Description: 金蝶rpc
 * @date 2018/7/28
 */
@FeignClient("${fms.feigns.serverNames.fmsThirdInterface}")
public interface KingDeeRpc {

    /**
     * @Title:
     * @Description:   金蝶客户同步
     * @param kingDeeCusVos 客户信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    @RequestMapping(value = "king_dee/kingDeeCus" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse<KingDeeResultFileVo>> kingDeeCus(@Valid @RequestBody List<KingDeeCusVo> kingDeeCusVos);

    /**
     * @Title:
     * @Description:   金蝶财务核算代码同步
     * @param kingDeeVchVos 核算代码信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:24:49
     */
    @RequestMapping(value = "king_dee/kingDeeVoucher" ,method = RequestMethod.POST)
    ResponseEntity<RestResponse<KingDeeResultFileVo>> kingDeeVoucher(@Valid @RequestBody List<KingDeeVchVo> kingDeeVchVos);

}
