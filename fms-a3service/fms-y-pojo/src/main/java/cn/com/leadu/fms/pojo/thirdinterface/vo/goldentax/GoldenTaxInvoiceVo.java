package cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceVo
 * @Description: 金税开票
 * @date 2018/7/17
 */
@Data
public class GoldenTaxInvoiceVo {

    /**
     * @Fields  : 要开具的发票种类（0：专用发票1：废旧物资发票2：普通发票）   必填 是    长度 2
     * @author qiaomengnan
     */
    private String infokind;

    /**
     * @Fields  : 购方名称）   必填 是    长度 20
     * @author qiaomengnan
     */
    private String infoclientname;

    /**
     * @Fields  : 购方税号（公司必填）   必填 否    长度 20
     * @author qiaomengnan
     */
    private String infoclienttaxcode;

    /**
     * @Fields  : 购方开户行及账号（专用发票必填）   必填 否    长度 16位，精确到小数点后面两位
     * @author qiaomengnan
     */
    private String infoclientbankaccount;

    /**
     * @Fields  : 购方地址电话（专用发票必填）   必填 否    长度 20位，精确到小数点后面两位
     * @author qiaomengnan
     */
    private String infoclientaddressphone;

    /**
     * @Fields  : 销方开户行及账号（专用发票必填）   必填 否    长度 16位，精确到小数点后面两位
     * @author qiaomengnan
     */
    private String infosellerbankaccount;

    /**
     * @Fields  : 销方地址电话（专用发票必填）   必填 否    长度 20位，精确到小数点后面两位
     * @author qiaomengnan
     */
    private String infoselleraddressphone;

    /**
     * @Fields  : 备注   必填 否    长度
     * @author qiaomengnan
     */
    private String infonotes;

    /**
     * @Fields  : 开票人   必填 是    长度 4
     * @author qiaomengnan
     */
    private String infoinvoicer;

    /**
     * @Fields  : 复核人   必填 否    长度 4
     * @author qiaomengnan
     */
    private String infochecker;

    /**
     * @Fields  : 收款人   必填 否    长度 4
     * @author qiaomengnan
     */
    private String infocashier;

    /**
     * @Fields  : 如不为空，则开具销货清单，此为发票上商品名称栏的清单信息，应为“(详见销货清单)”字样   必填 否    长度 1
     * @author qiaomengnan
     */
    private String infolistname;

    /**
     * @Fields  : 是销售单据编号，可为空   必填 否    长度 20
     * @author qiaomengnan
     */
    private String infobillnumber;

    private List<GoldenTaxInvoiceDetailVo> detail = new ArrayList<>();

}
