package cn.com.leadu.fms.schedule.job.finance;

import cn.com.leadu.fms.schedule.rpc.finance.CountDistributeOverdueRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by wangxue on 2018/9/6.
 */
/**
 * @author wangxue
 * @ClassName: CountDistributeOverdueJob
 * @Description: 逾期数据统计与分配定时处理job
 * @date 2018/9/5
 */
@Slf4j
public class CountDistributeOverdueJob implements Job {

    @Autowired
    private CountDistributeOverdueRpc countDistributeOverdueRpc;

    @Value("${fms.cron.expression.finance.count_distribute_overdue_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute CountDistributeOverdueJob");
            countDistributeOverdueRpc.distributeOverdueData();
        }

    }
}
