package cn.com.leadu.fms.data.original.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskDao
 * @Description: 借阅归还任务信息dao层
 * @date 2018-06-04
 */
public interface BorrowBackTaskDao extends BaseDao<BorrowBackTask> {

    /**
     * @Title:
     * @Description: 根据借阅归还任务号获取借阅归还信息
     * @param borrowBackTaskNo
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    BorrowBackTaskVo selectBorrowBackTaskByBorrowBackTaskNo(@Param("borrowBackTaskNo") String borrowBackTaskNo);
}