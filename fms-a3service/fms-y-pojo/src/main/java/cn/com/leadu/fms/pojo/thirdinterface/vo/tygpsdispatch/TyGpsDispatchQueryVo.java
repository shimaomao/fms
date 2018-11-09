package cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchQueryVo
 * @Description: gps派单查询vo
 * @date 2018/7/4 0004
 */
@Data
public class TyGpsDispatchQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 申请编号
     * @author qiaomengnan
     */
    private String  applyNo;

    /**
     * @Fields  : 执行结果
     * @author qiaomengnan
     */
    private String result;

    /**
     * @Fields  : 返回信息
     * @author qiaomengnan
     */
    private String message;

    /**
     * @Fields  : 订单状态
     * @author qiaomengnan
     */
    private String status;

    /**
     * @Fields  : 设备信息
     * @author qiaomengnan
     */
    private List<TyGpsDispatchTerminalVo> terminal;

}
