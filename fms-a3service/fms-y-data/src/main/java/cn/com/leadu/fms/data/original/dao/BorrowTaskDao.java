package cn.com.leadu.fms.data.original.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskDao
 * @Description: 借阅任务信息dao层
 * @date 2018-05-30
 */
public interface BorrowTaskDao extends BaseDao<BorrowTask> {

    /**
     * @Title:
     * @Description: 获取借阅任务详情
     * @param
     * @return List<BorrowTaskVo>
     * @throws
     * @author ningyangyang
     * @date 2018-7-26
     */
    List<BorrowTaskVo> selectBorrowTaskVosByOrigFileStatus(@Param("borrowTaskVo") BorrowTaskVo borrowTaskVo);

    /**
     * 根据借阅任务号获取合同号
     */
    String selectBizCodeByBorrowTaskNo(@Param("borrowTaskNo") String borrowTaskNo);
}