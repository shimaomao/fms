package cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax;

import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceVo
 * @Description: 金税开票详细
 * @date 2018/7/17
 */
@Data
public class GoldenTaxInvoiceDetailVo {

    /**
     * @Fields  : 商品或劳务名称   必填 是    长度 100
     * @author qiaomengnan
     */
    private String listgoodsname;

    /**
     * @Fields  : 税目，4位数字，商品所属内别   必填 否    长度 4
     * @author qiaomengnan
     */
    private String listtaxitem;

    /**
     * @Fields  : 规格型号   必填 否    长度 40
     * @author qiaomengnan
     */
    private String liststandard;

    /**
     * @Fields  : 计量单位，如计量单位为空，则忽略数量和单价   必填 否    长度 22
     * @author qiaomengnan
     */
    private String listunit;

    /**
     * @Fields  : 数量   必填 否，金额不传时，单价数量必填    长度 16,8
     * @author qiaomengnan
     */
    private String listnumber;

    /**
     * @Fields  : 单价   必填 否，金额不传时，单价数量必填    长度 16,8
     * @author qiaomengnan
     */
    private BigDecimal listprice;

    /**
     * @Fields  : 金额，可以不传，由软件软件计算，如单价、数量、金额都传入则应符合计算关系    必填 否，单价数量不传时，金额必填    长度 16,8
     * @author qiaomengnan
     */
    private BigDecimal listamount;

    /**
     * @Fields  : 含税价标志，单价和金额的种类，0为不含税价，1为含税价   必填 是    长度 1
     * @author qiaomengnan
     */
    private String listpricekind;

    /**
     * @Fields  : 税额，可以不传，由软件软件计算，如传入则应符合计算关系   必填 否    长度 16,8
     * @author qiaomengnan
     */
    private String listtaxamount;

    /**
     * @Fields  : 税率，17、13、6、4等   必填 是    长度 2
     * @author qiaomengnan
     */
    private String infotaxrate;

    /**
     * @Fields  : 编码版本号，例如：16.0   必填 否，当goodstaxno不为空时，goodsnover生效且必填    长度 22
     * @author qiaomengnan
     */
    private String goodsnover;

    /**
     * @Fields  : 商品税收分类编码（国税要求必填），当goodstaxno为空，默认取开票软件bin目录下flbmxml.xml文件中的编码开票。   必填 否    长度 19
     * @author qiaomengnan
     */
    private String goodstaxno;

    /**
     * @Fields  : 是否享受税收优惠政策 0：不享受，1：享受   必填 否，当goodstaxno不为空时，taxpre才生效    长度 1
     * @author qiaomengnan
     */
    private String taxpre;

    /**
     * @Fields  : 享受税收优惠政策内容，例如：免税   必填 否，当goodstaxno不为空时，taxpre才生效    长度 50
     * @author qiaomengnan
     */
    private String taxprecon;

    /**
     * @Fields  : 零税率标识 空：非零税率，0：出口退税，1：免税，2：不征税，3：普通零税率   必填 否，当goodstaxno不为空时，taxpre才生效    长度 1
     * @author qiaomengnan
     */
    private String zerotax;

    /**
     * @Fields  : 企业自编码（可为空）   必填 否，当goodstaxno不为空时，taxpre才生效    长度 16
     * @author qiaomengnan
     */
    private String cropgoodsno;

    /**
     * @Fields  : 扣除额，差额征税才传值，其他情况不要传   必填 否，当goodstaxno不为空时，taxpre才生效    长度 16,8
     * @author qiaomengnan
     */
    private String taxdeduction;

    /**
     * @Fields  : 对应的开票信息
     * @author qiaomengnan
     */
    @JsonIgnore
    private InvoiceVo invoiceVo;

}
