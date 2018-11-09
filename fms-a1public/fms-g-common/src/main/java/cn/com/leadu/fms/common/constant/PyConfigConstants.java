package cn.com.leadu.fms.common.constant;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author yanggang
 * @ClassName: TyGpsConstants
 * @Description: 字符串常量配置
 * @date 2018/6/22
 */
@ConfigurationProperties(prefix = "fms.credit.py")
@Component
@Data
public class PyConfigConstants {

    // API域名
    private String url;
//    private String url = "http://test.pycredit.com:6001"; // 测试环境
//    private String url = "https://www.pycredit.com:6443"; // 生产环境

    // 返回报文压缩的URL
    private String pathZip;

    // 返回报文不压缩的URL
    private String pathUnzip;

    // 认证信息
    private String userId;
    private String passWord;

    // 是否测试模式
    private Boolean test;

    // 请求内容样本文件，实际中可使用具体对象组装
    private String queryFile;

    private String keyStoreFile;
    private String keyStorePassWord;
    private String trustStoreFile;
    private String trustStorePassWord;
    private String queryReasonID;//贷款审批查询原因ID
    //反欺诈分析接口
    private String antiQueryType;//查询类型（接口类型）
    private String antiSubReportId;//收费子报告
    // 地址核查接口
    private String addrQueryType;//查询类型（接口类型）
    private String addrSubReportId;//收费子报告
    // 卡核查及交易接口
    private String cardCheckQueryType;//查询类型（接口类型）
    private String cardCheckSubReportId;//收费子报告
    // 个人银行卡核查接口
    private String personBkCheckQueryType;//查询类型（接口类型）
    private String personBkCheckSubReportId;//收费子报告
    // 企业银行卡核查接口
    private String corpBkcheckQueryType;//查询类型（接口类型）
    private String corpBkcheckSubReportId;//收费子报告
    // 企业风险接口
    private String corpRiskQueryType;//查询类型（接口类型）
    private String corpRiskSubReportId;//收费子报告
    // 企业债务接口
    private String corpDebtQueryType;//查询类型（接口类型）
    private String corpDebtSubReportId;//收费子报告
    // 驾驶证接口
    private String driverQueryType;//查询类型（接口类型）
    private String driverSubReportId;//收费子报告
    //鹏元附件下载地址
    private String filePath;

    public PyConfigConstants(){
        config = this;
    }

    public static PyConfigConstants config = null;

}
