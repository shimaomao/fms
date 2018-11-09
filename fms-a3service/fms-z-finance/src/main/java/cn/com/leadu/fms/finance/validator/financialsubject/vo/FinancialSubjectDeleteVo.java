package cn.com.leadu.fms.finance.validator.financialsubject.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectVo
 * @Description: 财务科目管理删除时载体及验证
 * @date 2018-06-20
 */
@Data
public class FinancialSubjectDeleteVo extends BaseVo<FinancialSubject> {

    private static final long serialVersionUID = 1L;

}