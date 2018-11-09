package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.jboss.logging.Field;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.Doc;
import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: SysRole
 * @Description:
 * @date 2018/1/7
 */
@ExcelTitle(value = "角色信息")
@Data
public class SysRole extends BaseEntity<SysRole> {

    /**
     * @Fields  : 角色id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
    private String roleId;
    /**
     * @Fields  : 角色名称
     */
    private String roleName; //名称
    /**
     * @Fields  : 角色代码
     */
    private String role; //代码
    /**
     * @Fields  : 启用标识
     */
    private String enableFlag;//启用
    /**
     * @Fields  : 排序
     */
    private String orderNo; //排序

    @ExcelTitle(value = "角色代码",sort = 1,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getRole() {
        return role;
    }

    @ExcelTitle(value = "角色名称",sort = 2,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getRoleName() {
        return roleName;
    }

    @ExcelTitle(value = "启用标识",sort = 3,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO},codeType = CommonCodeTypeConstants.COMMON_STATUS)
    public String getEnableFlag() {
        return enableFlag;
    }

    @ExcelTitle(value = "排序",sort = 4,types = {ExcelTypeConstants.ONE,ExcelTypeConstants.TWO})
    public String getOrderNo() {
        return orderNo;
    }

    @ExcelTitle(value = "更新时间", sort =5,types = ExcelTypeConstants.ONE)
    public String getUpdateTimeStr(){
        return DateUtils.dateToStr(updateTime,DateUtils.formatStr_yyyyMMddHHmmss);
    }

    @ExcelTitle(value = "更新人员", sort = 6,types = ExcelTypeConstants.ONE)
    public String getUpdater(){
        return updater;
    }
}
