package cn.com.leadu.fms.pojo.system.entity;

import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.tkmapper.IdGenerator;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: MessageLog
 * @Description: 短信发送日志实体
 * @date 2018/3/16.
 */
@Data
public class MessageLog extends BaseEntity<MessageLog> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
    private String id;

    private String phone;  //发送手机号

    private Date sendTime; //发送时间

    private String content;; //发送内容

    private String projectName;//项目名称

    private String serviceName;//业务名称  例如 申请订单

    private String classFunctionName;//类与方法名称 例如 cn.leadu.control.service.impl.类名.方法名
}
