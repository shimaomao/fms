package cn.com.leadu.fms.business.service;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonParamService
 * @Description:
 * @date 2018/6/19
 */
public interface CommonParamService {

    /**
     * @Title:
     * @Description:   初始化系统常量值到redis中
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:19:43
     */
    Map<String,Object> initSysParamsValue();

}
