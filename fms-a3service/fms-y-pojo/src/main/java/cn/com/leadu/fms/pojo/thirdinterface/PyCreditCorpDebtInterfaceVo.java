package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyCreditCorpDebtInterfaceVo
 * @Description: 鹏远征信 企业债务接口
 * @date 2018-06-6
 */
@Data
public class PyCreditCorpDebtInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PyCreditCorpDebtInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    //公司名称,工商注册号,企业机构代码三选一参数
    private String corpName;//公司名称
    private String registerNO;//工商注册号
    private String orgCode;//企业机构代码
    private String queryType= PyConfigConstants.config.getCorpDebtQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getCorpDebtSubReportId();//收费子报告

}