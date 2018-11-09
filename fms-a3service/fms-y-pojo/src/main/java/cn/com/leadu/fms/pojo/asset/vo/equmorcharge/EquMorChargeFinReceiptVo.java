package cn.com.leadu.fms.pojo.asset.vo.equmorcharge;

import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeFinReceiptVo
 * @Description: 财务收款 vo
 * @date 2018/6/9
 */
@Data
public class EquMorChargeFinReceiptVo {

    private String taskId;

    private String taskDefinitionKey;

    private String memo;

    private String equMorTaskNo;

    private List<ContReceiptVo> contReceiptVos;

}
