package cn.com.leadu.fms.prebiz.vo;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: CreditModelVo
 * @Description:
 * @date 2018/5/14
 */
@Data
public class CreditModelVo {

    /** 
     * @Fields  : 申请号
     * @author qiaomengnan
     */ 
    private String applyNo;

    /** 
     * @Fields  : 性别
     * @author qiaomengnan
     */ 
    private String sex;

    /** 
     * @Fields  : 婚姻状况
     * @author qiaomengnan
     */ 
    private String marriageStatus;

    /**
     * @Fields  : 户口类别
     * @author qiaomengnan
     */
    private String censusType;

    /**
     * @Fields  : 学历
     * @author qiaomengnan
     */
    private String eduBgType;

    /**
     * @Fields  : 职业
     * @author qiaomengnan
     */
    private String profession;

    /** 
     * @Fields  : 在职年限
     * @author qiaomengnan
     */ 
    private String workYear;


    /**
     * @Fields  : 居住状况
     * @author qiaomengnan
     */
    private String resideCond;

    /**
     * @Fields  : 户籍所在省份
     * @author qiaomengnan
     */
    private String censusProv;

    /**
     * @Fields  : 户籍所在城市
     * @author qiaomengnan
     */
    private String censusCity;

    /**
     * @Fields  : 车辆类型
     * @author qiaomengnan
     */
    private String vehicleForm;


    /**
     * @Fields  : 新车/二手车车辆指导价(元)
     * @author qiaomengnan
     */
    private BigDecimal guidePrice;


    /**
     * @Fields  : 车龄（月）
     * @author qiaomengnan
     */
    private BigDecimal vehAgeMonths;


    /**
     * @Fields  : 融资额
     * @author qiaomengnan
     */
    private BigDecimal finAmount;


    @ExcelTitle(value = "申请号" ,sort = 1)
    public String getApplyNo() {
        return applyNo;
    }

    @ExcelTitle(value = "性别" ,sort = 2 , codeType = CommonCodeTypeConstants.GENDER)
    public String getSex() {
        return sex;
    }

    @ExcelTitle(value = "婚姻状况" ,sort = 3 , codeType = CommonCodeTypeConstants.MARRIAGE_STATUS)
    public String getMarriageStatus() {
        return marriageStatus;
    }

    @ExcelTitle(value = "户口类别" ,sort = 4 , codeType = CommonCodeTypeConstants.CENSUS_TYPE)
    public String getCensusType() {
        return censusType;
    }

    @ExcelTitle(value = "学历" ,sort = 5 , codeType = CommonCodeTypeConstants.EDU_BG_TYPE)
    public String getEduBgType() {
        return eduBgType;
    }

    @ExcelTitle(value = "车辆使用城市" ,sort = 6, areaType = CommonAreaConstants.BAS_AREA_VALUE)
    public String getVehicleUseCity(){
        return "";
    }

    @ExcelTitle(value = "职务" ,sort = 7 , codeType = CommonCodeTypeConstants.PROFESSION_TYPE)
    public String getProfession() {
        return profession;
    }

    @ExcelTitle(value = "在职年限" ,sort = 8)
    public String getWorkYear() {
        return workYear;
    }

    @ExcelTitle(value = "居住状况" ,sort = 9)
    public String getResideCond() {
        return resideCond;
    }

    @ExcelTitle(value = "房产区域" ,sort = 10)
    public String getPropertyArea() {
        return "";
    }

    @ExcelTitle(value = "房产抵押情况" ,sort = 11)
    public String getPropertyMortgage() {
        return "";
    }

    @ExcelTitle(value = "房产面积" ,sort = 12)
    public String getRealEstateArea(){
        return "";
    }

    @ExcelTitle(value = "实际居住城市" ,sort = 13)
    public String getRealLivingCity(){
        return "";
    }

    @ExcelTitle(value = "户籍所在省份" ,sort = 14 , areaType = CommonAreaConstants.BAS_AREA_VALUE)
    public String getCensusProv() {
        return censusProv;
    }

    @ExcelTitle(value = "户籍所在城市" ,sort = 15 , areaType = CommonAreaConstants.BAS_AREA_VALUE)
    public String getCensusCity() {
        return censusCity;
    }

    @ExcelTitle(value = "产品车型" ,sort = 16)
    public String getProductModel(){
        return "";
    }

    @ExcelTitle(value = "车辆类型" ,sort = 17 , codeType = CommonCodeTypeConstants.VEHICLE_FORM)
    public String getVehicleForm() {
        return vehicleForm;
    }

    @ExcelTitle(value = "抵押城市" ,sort = 18)
    public String getMortgageCity(){
        return "";
    }

    @ExcelTitle(value = "新车车辆指导价_元" ,sort = 19)
    public BigDecimal getGuidePrice() {
        return guidePrice;
    }

    @ExcelTitle(value = "二手车车龄_月" ,sort = 20)
    public BigDecimal getVehAgeMonths() {
        return vehAgeMonths;
    }

    @ExcelTitle(value = "是否融先锋卫士" ,sort = 21)
    public String getVanguardGuard(){
        return "";
    }

    @ExcelTitle(value = "座位数" ,sort = 22)
    public String getPedestal(){
        return "";
    }

    @ExcelTitle(value = "融资总额" ,sort = 23)
    public BigDecimal getFinAmount(){
        return finAmount;
    }

    @ExcelTitle(value = "风险融资额" ,sort = 24)
    public BigDecimal getRiskFinAmount(){
        return finAmount;
    }

    @ExcelTitle(value = "店面所在省份" ,sort = 25)
    public String getStorefrontProv(){
        return "";
    }

    @ExcelTitle(value = "主申人驾驶证状态" ,sort = 26)
    public String getA(){
        return "";
    }

    @ExcelTitle(value = "主申人三维一致" ,sort = 27)
    public String getB(){
        return "";
    }

    @ExcelTitle(value = "主申人手机在网时长" ,sort = 28)
    public String getC(){
        return "";
    }

    @ExcelTitle(value = "主申人7天多平台" ,sort = 29)
    public String getD(){
        return "0";
    }

    @ExcelTitle(value = "主申人1个月多平台" ,sort = 30)
    public String getE(){
        return "0";
    }

    @ExcelTitle(value = "主申人3个月多平台" ,sort = 31)
    public String getF(){
        return "0";
    }

    @ExcelTitle(value = "主申人身份证命中高风险关注名单" ,sort = 32)
    public String getG(){
        return "";
    }

    @ExcelTitle(value = "主申人身份证命中中风险关注名单" ,sort = 33)
    public String getH(){
        return "";
    }

    @ExcelTitle(value = "主申人身份证命中低风险关注名单" ,sort = 34)
    public String getI(){
        return "";
    }

    @ExcelTitle(value = "主申人3个月内身份证关联多个申请信息" ,sort = 35)
    public String getJ(){
        return "";
    }

    @ExcelTitle(value = "配偶手机在网时长" ,sort = 36)
    public String getK(){
        return "";
    }

    @ExcelTitle(value = "配偶7天多平台" ,sort = 37)
    public String getL(){
        return "";
    }

    @ExcelTitle(value = "配偶1个月多平台" ,sort = 38)
    public String getM(){
        return "";
    }

    @ExcelTitle(value = "配偶3个月多平台" ,sort = 39)
    public String getN(){
        return "";
    }

    @ExcelTitle(value = "配偶身份证命中低风险关注名单" ,sort = 40)
    public String getO(){
        return "";
    }

    @ExcelTitle(value = "配偶3个月内身份证关联多个申请信息" ,sort = 41)
    public String getP(){
        return "";
    }

    @ExcelTitle(value = "是否担保人" ,sort = 42)
    public String getGuarantee(){
        return "";
    }

}
