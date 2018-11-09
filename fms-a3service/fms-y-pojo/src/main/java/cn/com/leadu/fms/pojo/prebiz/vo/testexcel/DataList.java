package cn.com.leadu.fms.pojo.prebiz.vo.testexcel;

import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 模板参数载体类
 * Created by huzongcheng on 2018/9/27.
 */
@Data
public class DataList {
    private String month ;
    private BigDecimal amount ;
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date date;

    public DataList(String month, BigDecimal amount,Date date) {
        super();
        this.month = month;
        this.amount = amount;
        this.date = date;
    }

    public String getDateStr(){
        return DateUtils.dateToStr(this.date,DateUtils.formatStr_yyyyMMddHHmmss);
    }
}
