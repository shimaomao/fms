package cn.com.leadu.fms.schedule.job.cost;

import cn.com.leadu.fms.schedule.rpc.cost.AutoCancelPrepaymentRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @program: fms
 * @description: 提前还款自动作废
 * @author: yangyiquan
 * @create: 2018-10-24 16:07
 **/
@Slf4j
public class AutoCancelPrepaymentJob implements Job {
    @Autowired
    private AutoCancelPrepaymentRpc autoCancelPrepaymentRpc;

    @Value("${fms.cron.expression.cost.auto_cancel_prepayment_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute AutoCancelPrepaymentJob");
            autoCancelPrepaymentRpc.autoCancelPrepayment();
        }
    }
}