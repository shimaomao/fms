package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyCreditCorpBkcheckInterfaceVo
 * @Description: 鹏远征信 企业三要素核查
 * @date 2018-06-6
 */
@Data
public class PyCreditCorpBkcheckInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PyCreditCorpBkcheckInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String corpName;//公司名称
    private String accountNo;//银行账号
    private String openBankNo;//开户行行号
    private String queryType= PyConfigConstants.config.getCorpBkcheckQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getCorpBkcheckSubReportId();//收费子报告

}