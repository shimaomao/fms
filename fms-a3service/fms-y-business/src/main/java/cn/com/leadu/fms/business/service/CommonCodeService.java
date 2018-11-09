package cn.com.leadu.fms.business.service;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonCodeService
 * @Description: 共通字典service
 * @date 2018/4/19
 */
public interface CommonCodeService {

    /**
     * @Title:
     * @Description:  刷新字典缓存
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/03 12:56:59
     */
    Map<String,Object> initCommonCodeValue();

}
