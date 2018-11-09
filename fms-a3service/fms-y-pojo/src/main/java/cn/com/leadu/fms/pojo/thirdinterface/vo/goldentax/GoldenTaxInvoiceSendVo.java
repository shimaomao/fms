package cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax;

import cn.com.leadu.fms.common.util.BigDecimalUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: GoldenTaxInvoiceSendVo
 * @Description: 金税开票发送vo
 * @date 2018/9/13 0013
 */
@Data
public class GoldenTaxInvoiceSendVo {

    private GoldenTaxInvoiceVo order = new GoldenTaxInvoiceVo();

    private Map<String,Object> option = new HashMap<>();

    public GoldenTaxInvoiceSendVo(){
        option.put("checkform",0);
    }

    /**
     * @Title:
     * @Description:   返回此发票的总金额
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 04:30:17
     */
    @JsonIgnore
    public BigDecimal getInvoiceAmount(){
        BigDecimal result = BigDecimalUtils.getZero();
        for(GoldenTaxInvoiceDetailVo vo : order.getDetail()){
            if(vo != null && vo.getListamount() != null)
                result = result.add(vo.getListamount());
        }
        return result;
    }

    /**
     * @Fields  : 发票发送返回结果
     * @author qiaomengnan
     */
    @JsonIgnore
    private GoldenTaxInvoiceResultVo goldenTaxInvoiceResultVo;

    /** 
     * @Fields  : true 同一条开票信息 金额大于指定金额,拆分成多张的数据 , false 多条开票信息组成的数据
     * @author qiaomengnan
     */ 
    @JsonIgnore
    private boolean identical;

}
