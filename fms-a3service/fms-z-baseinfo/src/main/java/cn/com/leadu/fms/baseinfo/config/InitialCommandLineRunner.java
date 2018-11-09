package cn.com.leadu.fms.baseinfo.config;

import cn.com.leadu.fms.baseinfo.service.BasAreaService;
import cn.com.leadu.fms.common.util.LogUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: InitialCommandLineRunner
 * @Description:    初始化项目数据
 * @date 2018/2/25
 */
@Order(101)
@Component
@Slf4j
public class InitialCommandLineRunner implements CommandLineRunner {

    @Autowired
    private BasAreaService basAreaService;

    @Override
    public void run(String... strings) throws Exception {
        LogUtils.infoLine(log,"区域城市初始化中");
        basAreaService.initBasAreas();
        LogUtils.infoLine(log,"区域城市初始化完毕");
    }

}
