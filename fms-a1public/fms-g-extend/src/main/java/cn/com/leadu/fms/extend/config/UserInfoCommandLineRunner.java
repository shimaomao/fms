package cn.com.leadu.fms.extend.config;

import cn.com.leadu.fms.extend.common.util.UserInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: UserInfoCommandLineRunner
 * @Description: 启动时注入对当前用户操作的类
 * @date 2018/1/7
 */
@Order(103)
@Component
public class UserInfoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserInfoUtils userInfoUtils;

    @Override
    public void run(String... strings) throws Exception {
        //在此注入共通类是因为要保证日志的正常输出
        UserInfoUtils.setUserInfoUtils(userInfoUtils);
    }
}
