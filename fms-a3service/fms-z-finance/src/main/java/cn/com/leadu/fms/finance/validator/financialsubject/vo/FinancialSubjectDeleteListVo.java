package cn.com.leadu.fms.finance.validator.financialsubject.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectVo
 * @Description: 财务科目管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialSubjectDeleteListVo extends BaseVo<FinancialSubject> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务科目ID
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> subjectIds;

    /**
     * @Fields  : 财务科目管理
     * @author ningyangyang
     */
    List<FinancialSubjectVo> financialSubjectVoList;

}