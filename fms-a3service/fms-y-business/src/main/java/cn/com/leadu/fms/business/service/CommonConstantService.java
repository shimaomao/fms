package cn.com.leadu.fms.business.service;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonConstantService
 * @Description:
 * @date 2018/6/20
 */
public interface CommonConstantService {

    /**
     * @Title:
     * @Description:   根据城市编码获取城市名称
     * @param areaCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/26 10:07:17
     */
    String findBasAreaName(String areaCode);

    /**
     * @Title:
     * @Description:  根据系统常量key 获取系统常量名称
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 11:01:18
     */
    String findSysParamName(String paramKey);

    /**
     * @Title:
     * @Description:  根据系统常量key 获取系统常量Value
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 11:01:18
     */
    String findSysParamValue(String paramKey);

    /**
     * @Title:
     * @Description:   获取数据字典名称
     * @param codeType
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:03
     */
    String findSysCodeValueName(String codeType,String value);

    /**
     * @Title:
     * @Description:   获取数据字典子集集合
     * @param codeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:21
     */
    Map<String,String> findSysCodeValues(String codeType);

}
