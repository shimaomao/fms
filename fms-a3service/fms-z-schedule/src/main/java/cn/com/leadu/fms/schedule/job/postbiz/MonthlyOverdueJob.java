package cn.com.leadu.fms.schedule.job.postbiz;

import cn.com.leadu.fms.schedule.rpc.postbiz.MonthlyOverdueRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @description:  每月定时统计逾期数据
 * @author wangxue
 * @since 2018/9/26
 */
@Slf4j
public class MonthlyOverdueJob implements Job {

    @Autowired
    private MonthlyOverdueRpc monthlyOverdueRpc;

    @Value("${fms.cron.expression.postbiz.monthly_overdue_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute MonthlyOverdueJob");
            monthlyOverdueRpc.analyseMonthlyOverdue();
        }
    }
}
