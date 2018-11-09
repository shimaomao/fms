package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyCreditAntiInterfaceVo
 * @Description: 鹏远征信 个人反欺诈接口
 * @date 2018-06-6
 */
@Data
public class PyCreditAntiInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PyCreditAntiInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String name;//姓名
    private String documentNo;//证件号码
    private String phone;//手机
    private String queryType= PyConfigConstants.config.getAntiQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getAntiSubReportId();//收费子报告

}