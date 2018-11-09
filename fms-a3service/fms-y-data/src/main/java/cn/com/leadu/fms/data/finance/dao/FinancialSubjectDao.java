package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinancialSubject;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: FinancialSubjectDao
 * @Description: 财务科目管理dao层
 * @date 2018-06-20
 */
public interface FinancialSubjectDao extends BaseDao<FinancialSubject> {

    List<FinancialSubjectVo> selectFinancialSubjectsByPage(@Param("financialSubjectVo") FinancialSubjectVo financialSubjectVo);

    FinancialSubjectVo selectFinancialSubjectVoByPrimaryKey(@Param("subjectId") String subjectId);
}