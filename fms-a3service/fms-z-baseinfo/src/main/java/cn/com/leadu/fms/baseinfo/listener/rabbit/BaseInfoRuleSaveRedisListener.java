package cn.com.leadu.fms.baseinfo.listener.rabbit;

import cn.com.leadu.fms.baseinfo.common.constant.BaseInfoRabbitMqQueues;
import cn.com.leadu.fms.baseinfo.service.RuleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: BaseInfoRuleListener
 * @Description: 规则存入redis监听
 * @date 2018/5/22
 */
@Component
@Slf4j
public class BaseInfoRuleSaveRedisListener {

    @Autowired
    private RuleService ruleService;

    @RabbitListener(queues = BaseInfoRabbitMqQueues.BASE_INFO_RULE_SAVE_REDIS)
    @RabbitHandler
    public void execute(){
        ruleService.initRule();
    }

}
