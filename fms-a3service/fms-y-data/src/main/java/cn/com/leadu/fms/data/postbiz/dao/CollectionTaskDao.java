package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CstmAddrInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskDao
 * @Description: 催收任务dao层
 */
public interface CollectionTaskDao extends BaseDao<CollectionTask> {

    /**
     * 分页获取催收任务信息
     * @param collectionTaskVo
     * @return
     */
    List<CollectionTaskVo> selectCollectionTasksByPage(@Param("collectionTaskVo") CollectionTaskVo collectionTaskVo);

    /**
     * 获取承租人逾期信息
     * @param overdueCstmVo
     * @return
     */
    List<OverdueCstmVo> selectCstmInfosByPage(@Param("overdueCstmVo") OverdueCstmVo overdueCstmVo);

    /**
     * 根据overdueCstmId获取客户地址信息
     * @param overdueCstmId
     * @return CollectionTaskVo
     */
    CollectionTaskVo selectCstmAddrPerInfosByOverdueCstmId(@Param("overdueCstmId") String overdueCstmId);

    /**
     * 根据certifNo获取客户地址信息
     * @param certifNo
     * @return
     */
    List<CstmAddrInfoVo> getCstmAddrInfoVoList(@Param("certifNo") String certifNo);

    /**
     * 根据collectionTaskNo获取催收任务信息
     * @param collectionTaskNo
     * @return
     */
    CollectionTaskVo selectCollectionTaskByCollectionTaskNo(@Param("collectionTaskNo") String collectionTaskNo);

    /**
     * 取得上门催收任务表中全部的逾期客户ID
     * @return List<String>
     * @author wangxue
     * @date 2018-9-19
     */
    List<String> selectAllOverdueCstmIds();

    /**
     * 根据任务号获取所有逾期合同号
     * @param collectionTaskNo
     * @return
     */
    List<OverdueCstmPostVo> selectContNoListByCollectionTaskNo(@Param("collectionTaskNo") String collectionTaskNo);

    /**
     * 获取委托书需要数据
     * @param collectionTaskNo
     * @return
     */
    List<CollectionLetterVo> selectProxyLetterInfo(@Param("collectionTaskNo") String collectionTaskNo);

    /**
     * 获取律师函需要数据
     * @param collectionTaskNo
     * @return
     */
    List<LawyerLetterVo> selectLawyerLetterVoList(@Param("collectionTaskNo") String collectionTaskNo);

}