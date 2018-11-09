package cn.com.leadu.fms.pojo.system.vo.desk;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: RoleDeskVo
 * @Description: 主页工作台模块Vo
 */
@Data
public class RoleDeskVo {
    /**
     * @Fields  : 本月累计融资额
     */
    private BigDecimal amount;
    /**
     * @Fields  : 本月申请个数
     */
    private String applyCount;
    /**
     * @Fields  : 本月累计放款数
     */
    private Long loanCount;

    /**
     * @Fields  : 模块集合
     */
    private List<RoleApproveVo> modules;
}
