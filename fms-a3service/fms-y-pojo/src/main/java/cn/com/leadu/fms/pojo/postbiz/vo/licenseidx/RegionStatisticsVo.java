package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import lombok.Data;

/**
 * Created by admin on 2018/10/8.
 */@Data
public class RegionStatisticsVo extends PageQuery<LicenseIdx> implements Entity {

    /**
     * @Fields  : 区域
     * @author group_district
     */
    private String groupDistrict;

    /**
     * @Fields  : 合同生效日期
     */
    private String contractSerachDate;

    /**
     * @Fields  : 台数
     */
    private String numberOftables;

    /**
     * @Fields  : 月份
     */
    private String effectivedateMonth;

    /**
     * @Fields  : 合同生效日期 (年份查询)
     */
    private String yearInquiries;
}
