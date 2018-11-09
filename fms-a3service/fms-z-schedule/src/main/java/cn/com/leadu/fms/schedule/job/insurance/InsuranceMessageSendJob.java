package cn.com.leadu.fms.schedule.job.insurance;/**
 * Created by ningyangyang on 2018/7/6.
 */

import cn.com.leadu.fms.schedule.rpc.insurance.InsuranceMessageSendRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Title: fms
 * @Description: 续保短信发送
 * @author: ningyangyang
 * @date 2018/7/6 11:45
 */
@Slf4j
public class InsuranceMessageSendJob implements Job {

    @Autowired
    private InsuranceMessageSendRpc insuranceMessageSendRpc;

    @Value("${fms.cron.expression.insurance.insurance_message_send_enable}")
    private Boolean enable;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        if(enable != null && enable){
            log.info("execute InsuranceMessageSendJob");
            insuranceMessageSendRpc.insuranceMessageSend();
        }
    }
}
