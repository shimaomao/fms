package cn.com.leadu.fms.business.config;

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.business.common.util.activiti.*;
import cn.com.leadu.fms.common.constant.PyConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qiaomengnan
 * @ClassName: WebBusinessConfig
 * @Description:
 * @date 2018/3/27
 */
@Configuration
public class WebBusinessConfig {

    @Bean
    public ActUtils actUtils(){
        return new ActUtils();
    }

    @Bean
    public EtonenetParam etonenetParam(){
        return new EtonenetParam();
    }

    /**
     * @Fields  : 融资申请工作流
     * @author qiaomengnan
     */
    @Bean
    public ActContractGenerationUtils actContractGenerationUtils(){
        return new ActContractGenerationUtils();
    }

    /**
     * @Fields  : 抵押工作流工具类
     * @author qiaomengnan
     */
    @Bean
    public ActEquMorUtils actEquMorUtils (){
        return new ActEquMorUtils();
    }

    /**
     * @Fields  : 抵押工作流 先抵押后放款
     * @author qiaomengnan
     */
    @Bean
    public ActEquMortgageUtils actEquMortgageUtils(){
        return new ActEquMortgageUtils();
    }

    /**
     * @Fields  : 抵押工作流 先放款后抵押
     * @author qiaomengnan
     */
    @Bean
    public ActEquMortgagePayUtils actEquMortgagePayUtils(){
        return new ActEquMortgagePayUtils();
    }

    /**
     * 原件借阅工作流
     */
    @Bean
    public ActFileBorrowTaskUtils actFileBorrowTaskUtils(){return new ActFileBorrowTaskUtils();}

    /**
     * 借阅归还工作流
     */
    @Bean
    public ActFileBorrowBackTaskUtils actFileBorrowBackTaskUtils(){return new ActFileBorrowBackTaskUtils();}

    /**
     * 续保工作流
     */
    @Bean
    public ActRenewalRegisterUtils actRenewalRegisterUtils(){
        return new ActRenewalRegisterUtils();
    }

    @Bean
    public PyConfigConstants pyConfigConstants(){
        return new PyConfigConstants();
    }

}
