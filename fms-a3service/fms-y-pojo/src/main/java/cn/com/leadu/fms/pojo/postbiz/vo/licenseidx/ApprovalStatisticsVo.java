package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import lombok.Data;

/**
 * Created by leadu on 2018/10/13.
 */@Data
public class ApprovalStatisticsVo {

    /**
     * @Fields  : 区域
     * @author group_district
     */
    private String groupDistrict;

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
