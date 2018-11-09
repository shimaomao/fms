package cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchVo
 * @Description: gps派单接口vo
 * @date 2018/7/4 0004
 */
@Data
public class TyGpsDispatchVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 申请编号
     * @author qiaomengnan
     */
    @NotBlank(message = "申请编号不能为空")
    private String applyNo;

    /** 
     * @Fields  : 现场联系人姓名
     * @author qiaomengnan
     */
    @NotBlank(message = "现场联系人姓名不能为空")
    private String contactName;

    /**
     * @Fields  : 现场联系人手机号
     * @author qiaomengnan
     */
    @NotBlank(message = "现场联系人手机号不能为空")
    private String contactPhone;

    /**
     * @Fields  : 派工联系人姓名
     * @author qiaomengnan
     */
    @NotBlank(message = "派工联系人姓名不能为空")
    private String piccontactName;

    /**
     * @Fields  : 派工联系人电手机号
     * @author qiaomengnan
     */
    @NotBlank(message = "派工联系人电手机号不能为空")
    private String piccontactPhone;

    /**
     * @Fields  : 上门时间
     * @author qiaomengnan
     */
    @NotBlank(message = "上门时间不能为空")
    private String installtime;

    /**
     * @Fields  : 拉车账号
     * @author qiaomengnan
     */
    private String carAccount;

    /**
     * @Fields  : 上门地址
     * @author qiaomengnan
     */
    @NotBlank(message = "上门地址不能为空")
    private String addressCode;

    /**
     * @Fields  : 详细地址
     * @author qiaomengnan
     */
    @NotBlank(message = "详细地址不能为空")
    private String addressDetail;

    /**
     * @Fields  : 备注
     * @author qiaomengnan
     */
    private String remark;

    /**
     * @Fields  : 车辆信息
     * @author qiaomengnan
     */
    @Size(min = 1 , message = "车辆信息不能为空")
    private List<TyGpsDispatchCarVo> car;

    //执行结果

    /**
     * @Fields  : 执行结果
     * @author qiaomengnan
     */
    private String result;

    /**
     * @Fields  : 信息
     * @author qiaomengnan
     */
    private String message;

    /**
     * @Fields  : 工单号
     * @author qiaomengnan
     */
    private String orderNo;

}
