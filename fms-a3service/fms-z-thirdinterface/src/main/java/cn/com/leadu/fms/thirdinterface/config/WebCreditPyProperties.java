package cn.com.leadu.fms.thirdinterface.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: WebCreditPyProperties
 * @Description: 鹏元征信配置
 * @date 2018/7/4
 */
@ConfigurationProperties(prefix = "fms.credit.py")
@Component
@Data
public class WebCreditPyProperties {

    private String url;

    private String pathZip;

    private String pathUnzip;

    private String userId;

    private String passWord;

    private Boolean isTest;

    private String queryFile;

    private String keyStoreFile;

    private String keyStorePassWord;

    private String trustStoreFile;

    private String trustStorePassWord;

    private String queryReasonID;

    private String antiQueryType;

    private String antiSubReportId;

    private String addrQueryType;

    private String addrSubReportId;

    private String cardCheckQueryType;

    private String cardCheckSubReportId;

    private String personBkCheckQueryType;

    private String personBkCheckSubReportId;

    private String corpBkcheckQueryType;

    private String corpBkcheckSubReportId;

    private String corpRiskQueryType;

    private String corpRiskSubReportId;

    private String corpDebtQueryType;

    private String corpDebtSubReportId;

    private String driverQueryType;

    private String driverSubReportId;

    private String filePath;

}
