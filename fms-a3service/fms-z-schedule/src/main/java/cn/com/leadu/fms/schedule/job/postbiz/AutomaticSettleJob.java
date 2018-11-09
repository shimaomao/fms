package cn.com.leadu.fms.schedule.job.postbiz;

import cn.com.leadu.fms.schedule.rpc.postbiz.AutomaticSettleRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description:  自动结清
 * @author:ningyangyang
 * @since:2018/5/15
 */
@Slf4j
public class AutomaticSettleJob implements Job{

    @Autowired
    private AutomaticSettleRpc automaticSettleRpc;
    @Value("${fms.cron.expression.postbiz.automatic_settle_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute AutomaticSettleJob");
            automaticSettleRpc.automaticSettle();
        }
    }
}
