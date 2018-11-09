package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.basicchangetask.*;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskDao
 * @Description: 基本信息变更任务dao层
 * @date 2018-08-31
 */
public interface BasicChangeTaskDao extends BaseDao<BasicChangeTask> {

    /**
     * @Description: 分页查询合同一览信息
     * @Param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/4/27 16:26
     */
    List<ContractListVo> selectContractListByPage(@Param("validContractChangeVo") ValidContractChangeVo validContractChangeVo);

    /**
     * 生效合同变更查询
     * @param basicChangeTaskVo
     * @return
     */
    List<BasicChangeTaskVo> selectBasicChangeTaskListByPage(@Param("basicChangeTaskVo") BasicChangeTaskVo basicChangeTaskVo);

    /**
     * 生效合同变更历史查询
     * @param vo
     * @return
     */
    List<BasicChangeCompHistoryVo> selectBasicCompChangeHistorListByPage(@Param("basicChangeCompHistoryVo") BasicChangeCompHistoryVo vo);

    /**
     * 生效合同变更历史查询
     * @param vo
     * @return
     */
    List<BasicChangePersHistoryVo> selectBasicPersChangeHistorListByPage(@Param("basicChangePersHistoryVo") BasicChangePersHistoryVo vo);

    /**
     * 获取基本信息变更取消内容
     * @param basicChangeTaskCancelVo
     * @return
     */
    BasicChangeTaskCancelVo selectBasicChangeCancelVo(@Param("basicChangeTaskCancelVo") BasicChangeTaskCancelVo basicChangeTaskCancelVo);
}