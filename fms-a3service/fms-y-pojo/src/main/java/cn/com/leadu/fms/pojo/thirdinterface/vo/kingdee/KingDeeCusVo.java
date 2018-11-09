package cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeCusVo
 * @Description: 客户信息
 * @date 2018/7/17
 */
@Data
public class KingDeeCusVo {

    /** 
     * @Fields  : 客户代码
     * @author qiaomengnan
     */
    @NotBlank(message = "客户代码不能为空")
    private String fnumber;

    /** 
     * @Fields  : 客户名称
     * @author qiaomengnan
     */
    @NotBlank(message = "客户名称不能为空")
    private String fname;

    /** 
     * @Fields  : 类别代码
     * @author qiaomengnan
     */
    @NotBlank(message = "类别代码不能为空")
    private String parentid;

}
