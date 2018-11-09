package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyCreditPersonBkcheckInterfaceVo
 * @Description: 鹏远征信 个人三要素核查
 * @date 2018-06-6
 */
@Data
public class PyCreditPersonBkcheckInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PyCreditPersonBkcheckInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String name;//姓名
    private String documentNo;//证件号码
    private String accountNo;//银行账号
    private String openBankNo;//开户行行号(可以为空)
    private String queryType= PyConfigConstants.config.getPersonBkCheckQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getPersonBkCheckSubReportId();//收费子报告

}