package cn.com.leadu.fms.pojo.finance.vo.finbackfill;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author yanfengbo
 * @ClassName: FinBackfillVoExcel
 * @Description: 财务回填导出excel Vo
 * @date
 */
@ExcelTitle(value = "财务回填信息")
@Data
public class FinBackfillVoExcel extends PageQuery<FinBackfill> {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 承租人
     * @author yanfengbo
     */
    private String name;

    /**
     * @Fields  : 车架号
     * @author yanfengbo
     */
    private String vinNo;

    /**
     * @Fields  : 合同编号
     * @author yanfengbo
     */
    private String contNo;

    /**
     * @Fields  : 出租人
     * @author yanfengbo
     */
    private String groupName;

    /**
     * @Fields  : 车款
     * @author yanfengbo
     */
    private BigDecimal carprice1;

    /**
     * @Fields  : 实际成本金额(对应车款)
     * @author yanfengbo
     */
    private BigDecimal carprice2;

    /**
     * @Fields  : 实际税金金额(对应车款)
     * @author yanfengbo
     */
    private BigDecimal carprice3;

    /**
     * @Fields  : 供应商(对应车款)
     * @author yanfengbo
     */
    private String carpriceName;

    /**
     * @Fields  : 购置税
     * @author yanfengbo
     */
    private BigDecimal purchasetax1;

    /**
     * @Fields  : 实际成本金额(对应购置税)
     * @author yanfengbo
     */
    private BigDecimal purchasetax2;

    /**
     * @Fields  : 实际税金金额(对应购置税)
     * @author yanfengbo
     */
    private BigDecimal purchasetax3;

    /**
     * @Fields  : 供应商(对应购置税)
     * @author yanfengbo
     */
    private String purchasetaxName;

    /**
     * @Fields  : 保险费
     * @author yanfengbo
     */
    private BigDecimal insurance1;

    /**
     * @Fields  : 实际成本金额(对应保险费)
     * @author yanfengbo
     */
    private BigDecimal insurance2;

    /**
     * @Fields  : 实际税金金额(对应保险费)
     * @author yanfengbo
     */
    private BigDecimal insurance3;

    /**
     * @Fields  : 供应商(对应保险)
     * @author yanfengbo
     */
    private String insuranceName;

    /**
     * @Fields  : 精品/家装费
     * @author yanfengbo
     */
    private BigDecimal extra1;

    /**
     * @Fields  : 实际成本金额(对应精品/家装费)
     * @author yanfengbo
     */
    private BigDecimal extra2;

    /**
     * @Fields  : 实际税金金额(对应精品/家装费)
     * @author yanfengbo
     */
    private BigDecimal extra3;

    /**
     * @Fields  : 供应商(对应精品/家装费)
     * @author yanfengbo
     */
    private String extraName;

    /**
     * @Fields  : 上牌费
     * @author yanfengbo
     */
    private BigDecimal license1;

    /**
     * @Fields  : 实际成本金额(对应上牌费)
     * @author yanfengbo
     */
    private BigDecimal license2;

    /**
     * @Fields  : 实际税金金额(对应上牌费)
     * @author yanfengbo
     */
    private BigDecimal license3;

    /**
     * @Fields  : 供应商(对应上牌费)
     * @author yanfengbo
     */
    private String licenseName;

    @ExcelTitle(value = "承租人", sort = 1 ,types = {ExcelTypeConstants.ONE})
    public String getName(){return name;}

    @ExcelTitle(value = "车架号", sort = 2 ,types = {ExcelTypeConstants.ONE})
    public String getVinNo(){return vinNo;}

    @ExcelTitle(value = "合同编号", sort = 3 ,types = {ExcelTypeConstants.ONE})
    public String getContNo(){return contNo;}

    @ExcelTitle(value = "出租人", sort = 4)
    public String getGroupName(){return groupName;}

    @ExcelTitle(value = "车款", sort = 5)
    public BigDecimal getCarprice1(){return carprice1;}

    @ExcelTitle(value = "实际成本金额(对应车款)  ", sort = 6)
    public BigDecimal getCarprice2(){return carprice2;}

    @ExcelTitle(value = "实际税金金额(对应车款)", sort = 7)
    public BigDecimal getCarprice3(){return carprice3;}

    @ExcelTitle(value = "供应商(对应车款)", sort = 8)
    public String getCarpriceName(){return carpriceName;}

    @ExcelTitle(value = "购置税", sort = 9)
    public BigDecimal getPurchasetax1(){return purchasetax1;}

    @ExcelTitle(value = "实际成本金额(对应购置税)", sort = 10)
    public BigDecimal getPurchasetax2(){return purchasetax2;}

    @ExcelTitle(value = "实际税金金额(对应购置税)", sort = 11)
    public BigDecimal getPurchasetax3(){return purchasetax3;}

    @ExcelTitle(value = "供应商(对应购置税)", sort = 12)
    public String getPurchasetaxName(){return purchasetaxName;}

    @ExcelTitle(value = "保险费", sort = 13)
    public BigDecimal getInsurance1(){return insurance1;}

    @ExcelTitle(value = "实际成本金额(对应保险费)", sort = 14)
    public BigDecimal getInsurance2(){return insurance2;}

    @ExcelTitle(value = "实际税金金额(对应保险费)", sort = 15)
    public BigDecimal getInsurance3(){return insurance3;}

    @ExcelTitle(value = "供应商(对应保险费)", sort = 16)
    public String getInsuranceName(){return insuranceName;}

    @ExcelTitle(value = "精品/家装费", sort = 17)
    public BigDecimal getExtra1(){return extra1;}

    @ExcelTitle(value = "实际成本金额(对应精品/家装费)", sort = 18)
    public BigDecimal getExtra2(){return extra2;}

    @ExcelTitle(value = "实际税金金额(对应精品/家装费)", sort = 19)
    public BigDecimal getExtra3(){return extra3;}

    @ExcelTitle(value = "供应商(对应精品/家装费)", sort = 20)
    public String getExtraName(){return extraName;}

    @ExcelTitle(value = "上牌费", sort = 21)
    public BigDecimal getLicense1(){return license1;}

    @ExcelTitle(value = "实际成本金额(对应上牌费)", sort = 22)
    public BigDecimal getLicense2(){return license2;}

    @ExcelTitle(value = "实际税金金额(对应上牌费)", sort = 23)
    public BigDecimal getLicense3(){return license3;}

    @ExcelTitle(value = "供应商(对应上牌费)", sort = 24)
    public String getLicenseName(){return licenseName;}
}
