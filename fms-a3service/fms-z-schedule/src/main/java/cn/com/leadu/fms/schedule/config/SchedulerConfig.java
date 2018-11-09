package cn.com.leadu.fms.schedule.config;

import cn.com.leadu.fms.schedule.job.cost.AutoCancelPrepaymentJob;
import cn.com.leadu.fms.schedule.job.finance.ContRepaySkedJob;
import cn.com.leadu.fms.schedule.job.finance.CountDistributeOverdueJob;
import cn.com.leadu.fms.schedule.job.insurance.InsuranceMessageSendJob;
import cn.com.leadu.fms.schedule.job.insurance.InsuranceRenewalJob;
import cn.com.leadu.fms.schedule.job.postbiz.AnnualInspectionJob;
import cn.com.leadu.fms.schedule.job.postbiz.AutomaticSettleJob;
import cn.com.leadu.fms.schedule.job.postbiz.MonthlyOverdueJob;
import cn.com.leadu.fms.schedule.job.postbiz.RepayMsgSendJob;
import cn.com.leadu.fms.schedule.job.prebiz.ApplyAutoCancelJob;
import cn.com.leadu.fms.schedule.quartz.AutowiringSpringBeanJobFactory;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by qiaohao on 2017/9/24.
 */
@Configuration
@ConditionalOnProperty(name = "quartz.enabled")
public class SchedulerConfig {

    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext
                                 // injecting SpringLiquibase to ensure liquibase is already initialized and created the quartz tables:
                                 //SpringLiquibase springLiquibase
    ) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }


    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource, JobFactory jobFactory,
                                                     @Value("${quartz.scheduler.startup.delay}") Integer startupDelay,
                                                     @Qualifier("contRepaySkedJobTrigger") Trigger contRepaySkedJobTrigger,
                                                     @Qualifier("applyAutoCancelJobTrigger") Trigger applyAutoCancelJobTrigger,
                                                     @Qualifier("insuranceMessageSendJobTrigger") Trigger insuranceMessageSendJobTrigger,
                                                     @Qualifier("automaticSettleJobTrigger") Trigger automaticSettleJobTrigger,
                                                     @Qualifier("annualInspectionJobTrigger") Trigger annualInspectionJobTrigger,
                                                     @Qualifier("insuranceRenewalJobTrigger") Trigger insuranceRenewalJobTrigger,
                                                     @Qualifier("repayMsgSendJobTrigger") Trigger repayMsgSendJobTrigger,
                                                     @Qualifier("countDistributeOverdueJobTrigger") Trigger countDistributeOverdueJobTrigger,
                                                     @Qualifier("monthlyOverdueJobTrigger") Trigger monthlyOverdueJobTrigger,
                                                     @Qualifier("autoCancelPrepaymentJobTrigger") Trigger autoCancelPrepaymentJobTrigger

    ) throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // this allows to update triggers in DB when updating settings in config file:
        //用于quartz集群,QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        //factory.setOverwriteExistingJobs(true);
        //用于quartz集群,加载quartz数据源
        factory.setDataSource(dataSource);
        factory.setJobFactory(jobFactory);
        //QuartzScheduler 延时启动，应用启动完20秒后 QuartzScheduler 再启动
        factory.setStartupDelay(startupDelay);
        //用于quartz集群,加载quartz数据源配置
        factory.setQuartzProperties(quartzProperties());
        factory.setTriggers(contRepaySkedJobTrigger,applyAutoCancelJobTrigger,insuranceMessageSendJobTrigger,automaticSettleJobTrigger,insuranceRenewalJobTrigger,repayMsgSendJobTrigger,annualInspectionJobTrigger,countDistributeOverdueJobTrigger, monthlyOverdueJobTrigger,autoCancelPrepaymentJobTrigger);
        return factory;
    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean
    public JobDetailFactoryBean contRepaySkedJobDetail(){
        return CommonConfig.createJobDetail(ContRepaySkedJob.class);
    }

    @Bean
    public CronTriggerFactoryBean contRepaySkedJobTrigger(
            @Qualifier("contRepaySkedJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.prebiz.cont_repay_sked}") String cronExpression) {
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }


    @Bean
    public JobDetailFactoryBean applyAutoCancelJobDetail(){
        return CommonConfig.createJobDetail(ApplyAutoCancelJob.class);
    }

    @Bean
    public CronTriggerFactoryBean applyAutoCancelJobTrigger(
            @Qualifier("applyAutoCancelJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.prebiz.apply_auto_cancel}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  续保短信发送
     * @return
     */
    @Bean
    public JobDetailFactoryBean insuranceMessageSendJobDetail(){
        return CommonConfig.createJobDetail(InsuranceMessageSendJob.class);
    }

    @Bean
    public CronTriggerFactoryBean insuranceMessageSendJobTrigger(
            @Qualifier("insuranceMessageSendJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.insurance.insurance_message_send}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  自动结清
     * @return
     */

    @Bean
    public JobDetailFactoryBean automaticSettleJobDetail(){
        return CommonConfig.createJobDetail(AutomaticSettleJob.class);
    }

    @Bean
    public CronTriggerFactoryBean automaticSettleJobTrigger(
            @Qualifier("automaticSettleJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.postbiz.automatic_settle}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  自动查询需要年检提醒的车辆
     * @return
     */
    @Bean
    public JobDetailFactoryBean annualInspectionJobDetail(){
        return CommonConfig.createJobDetail(AnnualInspectionJob.class);
    }

    @Bean
    public CronTriggerFactoryBean annualInspectionJobTrigger(
            @Qualifier("annualInspectionJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.postbiz.annual_inspection}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }



    /**
     *  续保任务自动生成
     * @return
     */
    @Bean
    public JobDetailFactoryBean insuranceRenewalJobDetail(){
        return CommonConfig.createJobDetail(InsuranceRenewalJob.class);
    }

    @Bean
    public CronTriggerFactoryBean insuranceRenewalJobTrigger(
            @Qualifier("insuranceRenewalJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.insurance.insurance_renewal}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  还款短信发送
     * @return
     */
    @Bean
    public JobDetailFactoryBean repayMsgSendJobDetail(){
        return CommonConfig.createJobDetail(RepayMsgSendJob.class);
    }

    @Bean
    public CronTriggerFactoryBean repayMsgSendJobTrigger(
            @Qualifier("repayMsgSendJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.postbiz.repay_msg_send}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  逾期客户统计与分配
     * @return
     */
    @Bean
    public JobDetailFactoryBean countDistributeOverdueJobDetail(){
        return CommonConfig.createJobDetail(CountDistributeOverdueJob.class);
    }

    @Bean
    public CronTriggerFactoryBean countDistributeOverdueJobTrigger(
            @Qualifier("countDistributeOverdueJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.finance.count_distribute_overdue}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  每月定时统计逾期率和月度租金
     * @return
     */
    @Bean
    public JobDetailFactoryBean monthlyOverdueJobDetail(){
        return CommonConfig.createJobDetail(MonthlyOverdueJob.class);
    }

    @Bean
    public CronTriggerFactoryBean monthlyOverdueJobTrigger(
            @Qualifier("monthlyOverdueJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.postbiz.monthly_overdue}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }

    /**
     *  自动取消提前还款
     * @return
     */
    @Bean
    public JobDetailFactoryBean autoCancelPrepaymentJobDetail(){
        return CommonConfig.createJobDetail(AutoCancelPrepaymentJob.class);
    }

    @Bean
    public CronTriggerFactoryBean autoCancelPrepaymentJobTrigger(
            @Qualifier("autoCancelPrepaymentJobDetail") JobDetail jobDetail,
            @Value("${fms.cron.expression.cost.auto_cancel_prepayment}") String cronExpression){
        return CommonConfig.createCronTrigger(jobDetail, cronExpression);
    }
}
