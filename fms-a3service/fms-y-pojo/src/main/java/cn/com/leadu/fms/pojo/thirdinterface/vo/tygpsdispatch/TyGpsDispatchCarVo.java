package cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch;

import lombok.Data;

import java.io.Serializable;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchCarVo
 * @Description: gps派单车辆信息vo
 * @date 2018/7/4 0004
 */
@Data
public class TyGpsDispatchCarVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 
     * @Fields  : 车主姓名
     * @author qiaomengnan
     */ 
    private String ownerName;

    /** 
     * @Fields  : 身份证号
     * @author qiaomengnan
     */ 
    private String ownerCard;

    /**
     * @Fields  : 车型
     * @author qiaomengnan
     */
    private String carBrand;

    /**
     * @Fields  : 车牌
     * @author qiaomengnan
     */
    private String carNo;

    /**
     * @Fields  : 车架
     * @author qiaomengnan
     */
    private String carVin;

    /**
     * @Fields  : 有线设备年期
     * @author qiaomengnan
     */
    private String wiredPeriod;

    /**
     * @Fields  : 有线设备数量
     * @author qiaomengnan
     */
    private String wiredNum;

    /**
     * @Fields  : 无线设备年期
     * @author qiaomengnan
     */
    private String wirelessPeriod;

    /**
     * @Fields  : 无线设备数量
     * @author qiaomengnan
     */
    private String wirelessNum;

}
