package cn.com.leadu.fms.finance.service;

/**
 * @Title: fms
 * @Description: 逾期数据统计和分配
 * @author: ningyangyang
 * @date 2018/5/22 16:24
 */
public interface CountDistributeOverdueService {

    /**
     * @Title:
     * @Description: 逾期数据统计和分配（定时任务）
     * @throws
     * @author wangxue
     * @date 2018-9-3 17:11:36
     */
    void distributeOverdueData();

}
