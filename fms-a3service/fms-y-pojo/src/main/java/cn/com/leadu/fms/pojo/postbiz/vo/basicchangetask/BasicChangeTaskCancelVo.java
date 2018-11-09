package cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask;

import lombok.Data;

/**
 * Created by root on 2018/10/11.
 */
@Data
public class BasicChangeTaskCancelVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 变更任务号
     * @author lijunjun
     */
    private String basicTaskNo;

    /**
     * @Fields  : 变更任务状态
     * @author lijunjun
     */
    private String basicTaskStatus;

    /**
     * @Fields  : 承租人
     * @author lijunjun
     */
    private String cstmName;

    /**
     * @Fields  : 变更类型
     * @author lijunjun
     */
    private String changeType;

    /**
     * @Fields  : 取消备注
     * @author lijunjun
     */
    private String remark;

    /**
     * @Fields  : 当前节点登录用户
     * @author lijunjun
     */
    private String presentUser;


}
