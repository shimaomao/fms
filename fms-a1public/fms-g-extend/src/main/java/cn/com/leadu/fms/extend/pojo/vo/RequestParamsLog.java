package cn.com.leadu.fms.extend.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: RequestParamsLog
 * @Description: 保存请求的参数
 * @date 2018/3/8
 */
@Data
public class RequestParamsLog {

    /**
     * @Fields  : 请求路径
     */
    private String requestUrl;

    /**
     * @Fields  : 请求参数
     */
    private String requestParams;

    /**
     * @Fields  : 请求开始时间
     */
    private Date startTime;

    /**
     * @Fields  : 请求结束时间
     */
    private Date endTime;

}
