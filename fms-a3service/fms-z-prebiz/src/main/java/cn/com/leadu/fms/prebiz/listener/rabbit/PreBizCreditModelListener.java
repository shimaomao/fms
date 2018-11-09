//package cn.com.leadu.fms.prebiz.listener.rabbit;
//
//import cn.com.leadu.fms.prebiz.common.constant.PreBizRabbitMqQueues;
//import cn.com.leadu.fms.prebiz.service.CreditModelService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Component;
//
///**
// * @author qiaomengnan
// * @ClassName: PreBizCreditModelListener
// * @Description: 信用模型监听
// * @date 2018/5/14
// */
//@Component
//@RabbitListener(queues = PreBizRabbitMqQueues.PRE_BIZ_CREDIT_MODEL)
//@Slf4j
//public class PreBizCreditModelListener {
//
//
//    @Autowired
//    private CreditModelService creditModelService;
//
//    /**
//     * @Title:
//     * @Description:    根据申请编号生成信用模型
//     * @param applyNo
//     * @return
//     * @throws
//     * @author qiaomengnan
//     * @date 2018/05/14 02:47:19
//     */
//    @RabbitHandler
//    public void execute(@Payload String applyNo){
//        creditModelService.generatePreBizCreditModel(applyNo);
//    }
//
//}
