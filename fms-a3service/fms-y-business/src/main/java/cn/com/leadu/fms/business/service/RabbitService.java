package cn.com.leadu.fms.business.service;

/**
 * @author qiaomengnan
 * @ClassName: RabbitService
 * @Description: rabbit信息处理
 * @date 2018/5/15
 */
public interface RabbitService {

    void convertAndSend(String routingKey, final Object object);

}
