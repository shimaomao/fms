package cn.com.leadu.fms.thirdinterface.rpc.kingdee;

import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeCusRpc
 * @Description: 金蝶客户接入地址
 * @date 2018/7/17
 */
@FeignClient(name = "kingDeeCus",url = "${fms.kingDee.cusUrl}")
public interface KingDeeCusRpc {

    @RequestMapping(method = RequestMethod.POST)
    Response cus(@RequestBody List<KingDeeCusVo> kingDeeCusVos);
    
}
