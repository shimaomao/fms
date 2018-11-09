package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitTask;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskSearchVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: LawsuitTaskDao
 * @Description: 诉讼任务信息dao层
 */
public interface LawsuitTaskDao extends BaseDao<LawsuitTask> {

    /**
     * 分页查询诉讼任务一览
     * @param lawsuitTaskSearchVo
     * @return
     */
    List<LawsuitTaskSearchVo> selectLawsuitTasksByPage(@Param("lawsuitTaskSearchVo") LawsuitTaskSearchVo lawsuitTaskSearchVo);

    /**
     * 根据lawsuitTaskNo获取诉讼任务信息
     * @param lawsuitTaskNo
     * @return
     */
    LawsuitTaskSearchVo selectLawsuitTasksByTaskNo(@Param("lawsuitTaskNo") String lawsuitTaskNo);

    /**
     * 根据overdueContId获取诉讼基本信息
     * @param overdueContId
     * @return
     */
    LawsuitTaskSearchVo selectLawsuitTasksByOverdueContId(@Param("overdueContId") String overdueContId);

    /**
     * 根据lawsuitTaskNo获取诉讼登记信息
     * @param lawsuitTaskNo
     * @return
     */
    LawsuitTaskSearchVo selectLawsuitRegistersByTaskNo(@Param("lawsuitTaskNo") String lawsuitTaskNo);

    /**
     * 根据lawsuitTaskNo获取逾期任务跟进信息List
     * @param lawsuitTaskNo
     * @return
     */
    List<LawsuitRegisterVo> getLawsuitRegisterVoList(@Param("lawsuitTaskNo") String lawsuitTaskNo);

    /**
     * 获取诉讼任务表中所有的逾期合同ID
     * @param
     * @return List<String>
     * @author wangxue
     * @date 2018-9-19
     */
    List<String> selectAllOverdueContIds();

    /**
     * 根据任务号获取历史诉讼登记信息List
     * @param lawsuitTaskNo
     * @return
     */
    List<LawsuitRegisterVo> selectLawsuitRegisterVosByLawsuitTaskNo(@Param("lawsuitTaskNo") String lawsuitTaskNo);

}