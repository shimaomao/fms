package cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceResultVo
 * @Description: 金税接口返回的信息及文件
 * @date 2018/9/12 0012
 */
@Data
public class GoldenTaxInvoiceResultVo {

    /**
     * @Fields  : 操作结果状态码，4011-succ，其它-操作失败。
     * @author qiaomengnan
     */
    private String code;

    /**
     * @Fields  : 操作结果描述信息
     * @author qiaomengnan
     */
    private String message;

    /** 
     * @Fields  : 合计不含税金额
     * @author qiaomengnan
     */ 
    private String infoamount;

    /** 
     * @Fields  : 合计税额
     * @author qiaomengnan
     */ 
    private String infotaxamount;

    /**
     * @Fields  : 开票日期
     * @author qiaomengnan
     */
    private String infoinvdate;

    /** 
     * @Fields  : 所属月份
     * @author qiaomengnan
     */ 
    private String infmonth;

    /** 
     * @Fields  : 发票十位代码
     * @author qiaomengnan
     */ 
    private String infotypecode;

    /**
     * @Fields  : 发票号码
     * @author qiaomengnan
     */
    private String infonumber;

    /** 
     * @Fields  : 销货清单标志，0–无销货清单，1–有销货清单
     * @author qiaomengnan
     */ 
    private String goodslistflag;

    /**
     * @Fields  : 发送文件
     * @author qiaomengnan
     */
    private String sendFile;

    /**
     * @Fields  : 返回文件
     * @author qiaomengnan
     */
    private String returnFile;






}
