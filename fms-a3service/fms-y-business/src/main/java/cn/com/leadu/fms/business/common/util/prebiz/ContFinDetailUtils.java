package cn.com.leadu.fms.business.common.util.prebiz;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ContFinDetailUtils
 * @Description: 合同融资费用明细辅助类
 * @date 2018/7/14
 */
public class ContFinDetailUtils {

    /**
     * @Title:  
     * @Description: contFinDetailVos
     * @param:  计算合同融资项目总额
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 17:12
     */
    public static BigDecimal getFinTotalAmount(List<ContFinDetailVo> contFinDetailVos){
        BigDecimal finTotalAmount = null;
        if(ArrayUtils.isNotNullAndLengthNotZero(contFinDetailVos)){
            finTotalAmount = BigDecimalUtils.getZero();
            //计算合同融资项目总额
            for(ContFinDetailVo contFinDetailVo : contFinDetailVos){
                if(contFinDetailVo != null && contFinDetailVo.getFinAmount() != null)
                    finTotalAmount = finTotalAmount.add(contFinDetailVo.getFinAmount());
            }
        }
        return finTotalAmount;
    }

}
