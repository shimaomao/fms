package cn.com.leadu.fms.pojo.cost.vo.pilferinsurance;

import lombok.Data;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 客户基本信息
 * @date
 */
@Data
public class CstmDetailVo {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合同编号
     * @author yanfengbo
     */
    private String contNo;

    /**
     * @Fields  : 承租人
     * @author yanfengbo
     */
    private String lessee;

    /**
     * @Fields  : 车架号
     * @author yanfengbo
     */
    private String vinNo;

    /**
     * @Fields  : 发动机号
     * @author yanfengbo
     */
    private String engineNo;

    /**
     * @Fields  : 有线设备号
     * @author yangyiquan
     */
    private String wiredDeviceNo;

    /**
     * @Fields  : 无线设备号
     * @author yangyiquan
     */
    private String wirelessDeviceNo;
}
