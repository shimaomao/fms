package cn.com.leadu.fms.system.config;

import cn.com.leadu.fms.common.util.LogUtils;
import cn.com.leadu.fms.system.service.SysCodeService;
import cn.com.leadu.fms.system.service.SysParamService;
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
    private SysParamService sysParamService;

    @Autowired
    private SysCodeService sysCodeService;

    @Override
    public void run(String... strings) throws Exception {
        LogUtils.infoLine(log,"数据字典初始化中");
        sysCodeService.initCommonCodeValue();
        LogUtils.infoLine(log,"数据字典初始化完毕");

        LogUtils.infoLine(log,"系统常量初始化中");
        sysParamService.initSysParamsValue();
        LogUtils.infoLine(log,"系统常量初始化完毕");
    }

}
