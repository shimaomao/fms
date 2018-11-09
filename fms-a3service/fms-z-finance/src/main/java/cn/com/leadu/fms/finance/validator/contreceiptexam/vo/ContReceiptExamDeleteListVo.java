package cn.com.leadu.fms.finance.validator.contreceiptexam.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamVo
 * @Description: 财务勾稽删除时载体及验证
 * @date 2018-05-09
 */
@Data
public class ContReceiptExamDeleteListVo extends BaseVo<ContReceiptExam> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务勾稽Id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> contReceiptExamIds;

}