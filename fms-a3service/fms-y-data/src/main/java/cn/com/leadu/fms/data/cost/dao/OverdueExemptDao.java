package cn.com.leadu.fms.data.cost.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.ContOverdueOneVo;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptDao
 * @Description: 罚息免除任务表dao层
 * @date 2018-05-30
 */
public interface OverdueExemptDao extends BaseDao<OverdueExempt> {
    /**
     * @Title:
     * @Description: 取得罚息免除一览展示页面
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<OverdueExemptVo> selectOverdueExemptsByPage(@Param("overdueExemptVo")OverdueExemptVo overdueExemptVo);

    /**
     * @Title:
     * @Description: 取得罚息免除一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContOverdueVo> selectContOverdueVosByPage(@Param("contOverdueVo")ContOverdueVo contOverdueVo);

    /**
     * @Title:
     * @Description: 通过合同号关联查询逾期罚息表和罚息免除任务明细表信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContOverdueVo> selectContOverdueAndOverdueExemptDetailByContNo(@Param("contNo")String contNo,@Param("overdueExemptNo")String overdueExemptNo);

    /**
     * @Title:
     * @Description: 根据合同号关联查询合同信息等表并去重取得一条明细(页面上半部分)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContOverdueOneVo selectOneContOverdueVo(@Param("contNo")String contNo);

}