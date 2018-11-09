package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import lombok.Data;

/**
 * Created by root on 2018/10/25.
 */
@Data
public class OrigFileStatusVo {

    /**
     * 收款状态
     */
    private String paymentSts;

    /**
     * 过户状态
     */
    private String transferSts;
}
