package cn.com.leadu.fms.schedule.job.prebiz;

import cn.com.leadu.fms.schedule.rpc.prebiz.ApplyAutoCancelRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author qiaomengnan
 * @ClassName: ApplyAutoCancelJob
 * @Description: 申请订单自动取消job
 * @date 2018/5/11
 */
@Slf4j
public class ApplyAutoCancelJob implements Job {

    @Value("${fms.cron.expression.prebiz.apply_auto_cancel_enable}")
    private Boolean enable;
    @Autowired
    private ApplyAutoCancelRpc applyAutoCancelRpc;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute ApplyAutoCancelJob");
            applyAutoCancelRpc.applyAutoCancel();
        }
    }
}
