package cn.com.leadu.fms.pojo.prebiz.vo.contQualification;/**
 * Created by yyq on 2018/5/24.
 */

import lombok.Data;

/**
 * @program: fms
 * @description:合同资管载体
 * @author: yangyiquan
 * @create: 2018-05-24 15:42
 **/
@Data
public class ContQualificationVo {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  :
     */
    private String applyNo;

    /**
     * @Fields  :
     */
    private String contNo;

    /**
     * @Fields  :
     */
    private String remark1;

    /**
     * @Fields  :
     */
    private String user;

    /**
     * @Fields  :
     */
    private String applyType;

    /**
     * @Fields  :
     */
    private String taskId;

    /**
     * @Fields  : 退回key
     */
    private String backReasonKey;

    /**
     * @Fields  :退回原因
     */
    private String backReason;
}
