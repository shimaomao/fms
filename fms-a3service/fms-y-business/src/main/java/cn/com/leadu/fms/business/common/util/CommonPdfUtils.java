package cn.com.leadu.fms.business.common.util;

import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.CommonPropertyConstants;
import cn.com.leadu.fms.common.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonPdfUtils
 * @Description: pdf模板工具类
 * @date 2018/6/13
 */
public class CommonPdfUtils {

    /**
     * @Title:
     * @Description:   返回海翼申请合同模板需要从数据字典中取值的map
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/14 11:45:34
     */
    public static Map<String,String> getEquMorSeaWingApplyCodeValues(){
        //需要从数据字典中取值
        Map<String,String> codeValues = new HashMap<>();
        //海翼租赁期限
        /*codeValues.put(StringUtils.joinDelimiter(StringUtils.LINE, CommonPropertyConstants.LEASE_PERIOD, CommonCodeTypeConstants.PROD_FIN_PERIOD_TYPE),CommonPropertyConstants.LEASE_PERIOD_NAME);*/
        codeValues.put(CommonPropertyConstants.LEASE_PERIOD,CommonPropertyConstants.LEASE_PERIOD_NAME);
        //终端支付方式
        codeValues.put(CommonPropertyConstants.RENT_PAY_MODE, CommonPropertyConstants.RENT_PAY_MODE_NAME);
        //业务类型
        codeValues.put(CommonPropertyConstants.LICENSE_ATTR,CommonPropertyConstants.LICENSE_ATTR_NAME);
        //业务类别
        codeValues.put(CommonPropertyConstants.SERVICE_CATEGORY,CommonPropertyConstants.SERVICE_CATEGORY_NAME);
        return codeValues;
    }

}
