package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyCreditCardCheckInterfaceVo
 * @Description: 鹏远征信 卡核和交易
 * @date 2018-06-6
 */
@Data
public class PyCreditCardCheckInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PyCreditCardCheckInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String name;//姓名
    private String documentNo;//证件号码
    private String cardNos;//银行账号
    private String queryType= PyConfigConstants.config.getCardCheckQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getCardCheckSubReportId();//收费子报告

}