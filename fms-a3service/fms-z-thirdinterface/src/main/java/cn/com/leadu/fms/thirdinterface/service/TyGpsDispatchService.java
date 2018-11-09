package cn.com.leadu.fms.thirdinterface.service;

import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchQueryVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchService
 * @Description: gps第三方派单接口service
 * @date 2018/7/4
 */
public interface TyGpsDispatchService {

    /**
     * @Title:
     * @Description:  gps天易派单
     * @param tyGpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    TyGpsDispatchVo sendGpsDispatch(TyGpsDispatchVo tyGpsDispatchVo);

    /**
     * @Title:
     * @Description:  gps天易查单
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    TyGpsDispatchQueryVo findGpsDisPatch(String applyNo);

}
