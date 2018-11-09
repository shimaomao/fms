package cn.com.leadu.fms.business.service;

/**
 * @author qiaomengnan
 * @ClassName: CommonRuleService
 * @Description: 通用规则引擎service层类
 * @date 2018/5/21
 */
public interface CommonRuleService {

    <T> T get(T data,String ruleType,String ruleKey);

}
