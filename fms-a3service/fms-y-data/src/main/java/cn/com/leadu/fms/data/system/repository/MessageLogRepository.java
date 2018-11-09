package cn.com.leadu.fms.data.system.repository;

/**
 * Created by wangxue on 2018/3/16.
 */

import cn.com.leadu.fms.pojo.system.entity.MessageLog;

/**
 * @author wangxue
 * @ClassName: MessageLogRepository
 * @Description: 短信发送日志Repository层
 * @date 2018-03-16
 */
public interface MessageLogRepository {

    /**
     * @Title:
     * @Description: 新增短信发送日志
     * @param messageLog
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-16 17:11:24
     */
    int insertData(MessageLog messageLog);
}
