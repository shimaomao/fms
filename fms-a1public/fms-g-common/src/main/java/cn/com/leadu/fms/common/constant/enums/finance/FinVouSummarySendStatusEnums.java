package cn.com.leadu.fms.common.constant.enums.finance;

/**
 * @author qiaomengnan
 * @ClassName: FinVouSummarySendStatusEnums
 * @Description: 财务凭证管理发送状态
 * @date 2018/7/31
 */
public enum FinVouSummarySendStatusEnums {

    NO_SEND("0","未发送"),
    SEND("1","已发送"),
    SEND_ERROR("2","发送失败");

    private String status;

    private String desc;

    FinVouSummarySendStatusEnums(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

}
