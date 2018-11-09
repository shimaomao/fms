package cn.com.leadu.fms.business.common.util;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.CommonCodeVo;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonCodeUtils
 * @Description: 字典取值工具类
 * @date 2018/6/13
 */
public class CommonCodeUtils {

    public static String getCodeValueName(Map<String,CommonCodeVo> commonCodeVos, String codeType, String value){
        if(commonCodeVos != null) {
            CommonCodeVo commonCodeVo = commonCodeVos.get(StringUtils.joinDelimiter(StringUtils.LINE, codeType,value));
            if(commonCodeVo != null)
                return commonCodeVo.getCodeValueName();
        }
        return null;
    }

}
