package cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxPrintinvVo
 * @Description: 打印发票vo
 * @date 2018/9/12 0012
 */
@Data
public class GoldenTaxPrintinvVo {

    /**
     * @Fields  : 发票种类（0：专用发票 1：旧物资发票 2：普通发票）   必填 是    长度 1
     * @author qiaomengnan
     */
    private String infokind;

    /**
     * @Fields  : 要打印发票的十位代码   必填 是    长度 10
     * @author qiaomengnan
     */
    private String infotypecode;

    /**
     * @Fields  : 要打印发票的号码   必填 是    长度 8
     * @author qiaomengnan
     */
    private String infonumber;

    /**
     * @Fields  : 销货清单标志，0–打印发票，1–打印销货清单   必填 是    长度 1
     * @author qiaomengnan
     */
    private String goodslistflag;

    /**
     * @Fields  : 是否显示边距确认对话框，1- 弹窗（弹窗下面 4 项不生效），0-不弹窗  必填 否    长度 1
     * @author qiaomengnan
     */
    private String infoshowprtdlg;

    /**
     * @Fields  : 打印机名称（默认开票软件设置的打印机   必填 否    长度 20
     * @author qiaomengnan
     */
    private String dyjmc;

    /**
     * @Fields  : 清单打印方式，1-全打，0-套打（默认）    必填 否    长度 1
     * @author qiaomengnan
     */
    private String qddyfs;

    /**
     * @Fields  : 左右偏移量，默认为 0   必填 否    长度 1
     * @author qiaomengnan
     */
    private String left;

    /**
     * @Fields  : 上下偏移，量默认为 0   必填 否    长度 1
     * @author qiaomengnan
     */
    private String top;

}
