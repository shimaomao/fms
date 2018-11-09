package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.MonthlyOverdue;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: MonthlyOverdueDao
 * @Description: 逾期率统计dao层
 */
public interface MonthlyOverdueDao extends BaseDao<MonthlyOverdue> {
    /**
     * @Title:
     * @Description: 分页查询逾期统计报表
     * @param monthlyOverduesVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    List<MonthlyOverduesVo> selectMonthlyOverduesListByPage(@Param("monthlyOverduesVo") MonthlyOverduesVo monthlyOverduesVo);

}