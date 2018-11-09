package cn.com.leadu.fms.pojo.thirdinterface;

import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import lombok.Data;

/**
 * @author 杨刚
 * @ClassName: PycreditDriverInterfaceVo
 * @Description: 鹏远征信 驾驶证接口
 * @date 2018-06-6
 */
@Data
public class PycreditDriverInterfaceVo<T> extends BaseVo<T> {

    private static final long serialVersionUID = 1L;
    public PycreditDriverInterfaceVo() {
    }
    private String refID;//业务流水号(自定义CHAR(30)，可以为空)
    private String name;//姓名
    private String documentNo;//证件号码
    private String carModels;//准驾车型   可以为空
    private String firstGetDocDate;//初次领证日期  格式yyyy-mm-dd  可以为空
    private String archviesNo;//档案编号 可以为空
    private String queryType= PyConfigConstants.config.getDriverQueryType();//查询类型（接口类型）
    private String subreportIDs= PyConfigConstants.config.getDriverSubReportId();//收费子报告

}