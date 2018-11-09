package cn.com.leadu.fms.asset.validator.mortgageremind.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindVo
 * @Description: 抵押提醒删除时载体及验证
 * @date 2018-07-27
 */
@Data
public class MortgageRemindDeleteListVo extends BaseVo<MortgageRemind> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 抵押提醒id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> morRemindIds;

}