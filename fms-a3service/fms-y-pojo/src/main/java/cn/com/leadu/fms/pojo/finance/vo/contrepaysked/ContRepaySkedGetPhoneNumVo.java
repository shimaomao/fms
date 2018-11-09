package cn.com.leadu.fms.pojo.finance.vo.contrepaysked;

import java.util.List;
import lombok.Data;

/**
 * @Title: fms
 * @Description: 获取发送短信的手机号
 * @author: ningyangyang
 * @date 2018/9/3 10:14
 */

@Data
public class ContRepaySkedGetPhoneNumVo {


    /**
     * @Fields  : 客户手机号
     * @author ningyangyang
     */
    private String mobileNo;


    /**
     * @Fields  : 客户姓名
     * @author ningyangyang
     */
    private String name;

    /**
     * @Fields  : 申请号
     * @author ningyangyang
     */
    private String applyNo;

    /**
     * 联系方式List
     */
    List<String> mobileNoList;
}
