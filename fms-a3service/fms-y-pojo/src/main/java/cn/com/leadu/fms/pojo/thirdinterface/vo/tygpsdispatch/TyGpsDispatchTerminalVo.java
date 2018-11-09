package cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchTerminalVo
 * @Description: gps派单查询设备信息vo
 * @date 2018/7/4
 */
@Data
public class TyGpsDispatchTerminalVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 设备号
     * @author qiaomengnan
     */
    private String imei;

    /**
     * @Fields  : 设备类型
     * @author qiaomengnan
     */
    private String model;

    /**
     * @Fields  : 数据接收时间
     * @author qiaomengnan
     */
    private String receiveTime;

    /**
     * @Fields  : GPS时间
     * @author qiaomengnan
     */
    private String gpsTime;

    /**
     * @Fields  : 车牌号
     * @author qiaomengnan
     */
    private String carNo;

    /**
     * @Fields  : 车架号
     * @author qiaomengnan
     */
    private String carVin;

    /**
     * @Fields  : 车型
     * @author qiaomengnan
     */
    private String carBrand;

    /**
     * @Fields  : 纬度
     * @author qiaomengnan
     */
    private String lat;

    /**
     * @Fields  : 经度
     * @author qiaomengnan
     */
    private String lng;

    /**
     * @Fields  : 设备状态
     * @author qiaomengnan
     */
    private String status;

    /**
     * @Fields  : 运行状态
     * @author qiaomengnan
     */
    private String runStatus;

}
