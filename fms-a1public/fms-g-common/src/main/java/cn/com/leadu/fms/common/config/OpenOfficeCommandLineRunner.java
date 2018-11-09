package cn.com.leadu.fms.common.config;

import cn.com.leadu.fms.common.util.OpenOfficeUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: CommonCommandLineRunner
 * @Description:
 * @date 2018/4/2
 */
@Order(102)
@Component
@ConditionalOnExpression("'${enabled.openOffice}' == 'true'")
public class OpenOfficeCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        WebOpenOfficeServers.initOpenOfficeConnection();
    }

}
