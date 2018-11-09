package cn.com.leadu.fms.schedule.job.prebiz;

import cn.com.leadu.fms.schedule.rpc.prebiz.ContractAutoCancelRpc;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yanfengbo
 * @ClassName: ContractAutoCancelJob
 * @Description: 未生效合同自动取消job
 * @date
 */
@Slf4j
public class ContractAutoCancelJob implements Job {

    @Autowired
    private ContractAutoCancelRpc contractAutoCancelRpc;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("execute contRepaySkedJob");
        contractAutoCancelRpc.contractAutoCancel();
    }
}
