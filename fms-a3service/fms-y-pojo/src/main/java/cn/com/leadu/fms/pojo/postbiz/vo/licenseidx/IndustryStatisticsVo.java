package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import lombok.Data;

/**
 * Created by leadu on 2018/10/15.
 */@Data
public class IndustryStatisticsVo {

    /**
     * @Fields  : 单位行业类别
     */
    private String industry;

    /**
     * @Fields  : 首次申请日期
     */
    private String applytSerachDate;

    /**
     * @Fields  : 申请台数
     */
    private String numberOftables;

    /**
     * @Fields  : 月份
     */
    private String effectivedateMonth;

    /**
     * @Fields  : 首次申请日期 (年份查询)
     */
    private String yearInquiries;
}
