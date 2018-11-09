package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonBasAreaService
 * @Description:
 * @date 2018/7/25
 */
public interface CommonBasAreaService {

    /**
     * @Title:
     * @Description: 初始化省市到redis中
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    Map<String,Object> initBasAreas();

}
