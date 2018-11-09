package cn.com.leadu.fms.thirdinterface.service;

import java.util.Map;

/**
 * @author yanggang
 * @ClassName: PyInterfaceService
 * @Description: 调用接口
 * @date 2018-6-13 9:18:12
 */
public interface PyInterfaceService {

    /**
     * @Title:
     * @Description: 调用接口
     * @param obj 接口所需要的实体类
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-6-13 9:18:12
     */
    Map<String, String> requestUnzipApi(Object obj) throws Exception;
}
