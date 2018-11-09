package cn.com.leadu.fms.schedule.job.postbiz;

import cn.com.leadu.fms.schedule.rpc.postbiz.AnnualInspectionRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class AnnualInspectionJob implements Job {

    @Autowired
    private AnnualInspectionRpc annualInspectionRpc;

    @Value("${fms.cron.expression.postbiz.annual_inspection_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute AnnualInspectionJob");
            annualInspectionRpc.findInfomationFromContract();
        }
    }
}
