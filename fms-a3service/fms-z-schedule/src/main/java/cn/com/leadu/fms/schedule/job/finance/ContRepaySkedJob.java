package cn.com.leadu.fms.schedule.job.finance;

import cn.com.leadu.fms.schedule.rpc.finance.ContRepaySkedRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author ningyangyang
 * @ClassName: ContRepaySkedJob
 * @Description: 检查是否有合同还款逾期job
 * @date 2018/5/8
 */
@Slf4j
public class ContRepaySkedJob implements Job {

    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    @Value("${fms.cron.expression.prebiz.cont_repay_sked_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute ContRepaySkedJob");
            contRepaySkedRpc.checkContRepaySked();
        }

    }
}
