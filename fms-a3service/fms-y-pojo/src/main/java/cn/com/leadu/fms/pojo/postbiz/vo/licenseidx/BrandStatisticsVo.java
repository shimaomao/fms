package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import lombok.Data;

/**
 * Created by admin on 2018/10/9.
 */@Data
public class BrandStatisticsVo extends PageQuery<LicenseIdx> implements Entity {

    /**
     * @Fields  : 品牌
     * @author vehicle_name
     */
    private String vehicleName;

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
