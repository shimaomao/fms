package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskDao
 * @Description: 收车任务dao层
 */
public interface RetrieveCarsTaskDao extends BaseDao<RetrieveCarsTask> {

    /**
     * @Title:
     * @Description:   查询收车任务list
     * @param retrieveCarsTaskVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/17 11:41:25
     */
    List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVos(@Param("retrieveCarsTaskVo") RetrieveCarsTaskVo retrieveCarsTaskVo);

    /**
     * @Title:
     * @Description:   根据收车任务Id查询收车任务vo
     * @param retrieveCarId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 02:52:48
     */
    RetrieveCarsTaskVo selectRetrieveCarsTaskVoById(@Param("retrieveCarId") String retrieveCarId);

    /**
     * @Title:
     * @Description:   根据收车任务号查询收车任务vo
     * @param retrieveCarTaskNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 01:47:40
     */
    RetrieveCarsTaskVo selectRetrieveCarsTaskVoByTaskNo(@Param("retrieveCarTaskNo") String retrieveCarTaskNo);

    /**
     * @Title:
     * @Description:   获取收车任务表中全部的逾期合同ID
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018/09/19
     */
    List<String> selectAllOverdueContIds();

    /**
     * 获取委托书下载数据List
     * @param retrieveCarTaskNo
     * @return
     */
    List<CollectionLetterVo> selectproxyDownloadInfo(@Param("retrieveCarTaskNo") String retrieveCarTaskNo);

}