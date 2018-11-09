package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.dao.MessageLogDao;
import cn.com.leadu.fms.data.system.repository.MessageLogRepository;
import cn.com.leadu.fms.pojo.system.entity.MessageLog;
import org.springframework.stereotype.Repository;

/**
 * @author wangxue
 * @ClassName: MessageLogRepositoryImpl
 * @Description: 短信发送日志Repository 实现层
 * @date 2018-03-16
 */
@Repository
public class MessageLogRepositoryImpl extends AbstractBaseRepository<MessageLogDao, MessageLog> implements MessageLogRepository {

    /**
     * @Title:
     * @Description: 新增短信发送日志
     * @param messageLog
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-16 17:11:24
     */
    @Override
    public int insertData(MessageLog messageLog) {
        return super.insert(messageLog);
    }
}
