package cn.com.leadu.fms.schedule.job.insurance;/**
 * Created by ningyangyang on 2018/6/19.
 */

import cn.com.leadu.fms.schedule.rpc.insurance.InsuranceRenewalRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Title: fms
 * @Description: 续保任务自动生成
 * @author: ningyangyang
 * @date 2018/6/19 17:33
 */
@Slf4j
public class InsuranceRenewalJob implements Job {

    @Autowired
    private InsuranceRenewalRpc insuranceRenewalRpc;

    @Value("${fms.cron.expression.insurance.insurance_renewal_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute InsuranceRenewalJob");
            insuranceRenewalRpc.insuranceRenewalTask();
        }
    }
}
