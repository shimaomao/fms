package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: FinancePayVo
 * @Description: 财务付款vo
 * @date 2018/6/8
 */
@Data
public class EquMorChargeFinPayVo {

    private String taskId;

    private String taskDefinitionKey;

    private String equMorTaskNo;

    private String memo;

}
