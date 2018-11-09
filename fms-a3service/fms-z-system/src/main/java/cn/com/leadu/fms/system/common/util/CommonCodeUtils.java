package cn.com.leadu.fms.system.common.util;

import cn.com.leadu.fms.system.service.SysCodeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: CommonCodeUtils
 * @Description: 针对数据字典缓存的存放获取，做共通处理
 * @date 2018/3/27
 */
@Data
@Component
public class CommonCodeUtils {



    @Autowired
    private SysCodeService sysCodeService;

    private static CommonCodeUtils commonCodeUtils = null;

    public CommonCodeUtils(){
        CommonCodeUtils.commonCodeUtils = this;
    }


}
