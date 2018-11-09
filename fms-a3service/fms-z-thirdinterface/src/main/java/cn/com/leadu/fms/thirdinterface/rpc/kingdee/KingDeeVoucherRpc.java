package cn.com.leadu.fms.thirdinterface.rpc.kingdee;

import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeVoucherRpc
 * @Description: 金蝶凭证接入地址
 * @date 2018/7/17
 */
@FeignClient(name = "kingDeeVoucher",url = "${fms.kingDee.voucherUrl}")
public interface KingDeeVoucherRpc {

    @RequestMapping(method = RequestMethod.POST)
    Response voucher(@RequestBody List<KingDeeVchVo> kingDeeVchVos);

}
