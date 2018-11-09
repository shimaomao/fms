package cn.com.leadu.fms.schedule.job.postbiz;

import cn.com.leadu.fms.schedule.rpc.postbiz.RepayMsgSendRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description:  自动发送短信
 * @author:ningyangyang
 * @since:2018/5/14
 */
@Slf4j
public class RepayMsgSendJob implements Job {


    @Autowired
    private RepayMsgSendRpc repayMsgSendRpc;

    @Value("${fms.cron.expression.postbiz.repay_msg_send_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute RepayMsgSendJob");
            repayMsgSendRpc.messageSend();
        }
    }
}
