package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PyAddrInterfaceVo
 * @Description: 鹏远征信 地址核查
 * @date 2018-06-6
 */
@Data
public class PyAddrInterfaceVo{

    private static final long serialVersionUID = 1L;
    public PyAddrInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String name;//姓名(可以为空)
    private String documentNo;//证件号码(可以为空)
    private String mobile;//手机
    private String address;//地址
    private String queryType= PyConfigConstants.config.getAddrQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getAddrSubReportId();//收费子报告

}