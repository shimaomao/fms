package cn.com.leadu.fms.data.asset.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailDao
 * @Description: 资方抵押还款计划dao层
 */
public interface EquMorRepayDetailDao extends BaseDao<EquMorRepayDetail> {

    /**
     * @Title:
     * @Description: 获取需要插入抵押还款计划详细表
     * @return List<EquMorRepayDetailVo>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByEquTaskNo(@Param("equMorTaskNo") String equMorTaskNo);


    /**
     * @Title:
     * @Description: 资方抵押还款计划详情表获取一览数据
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByPage(@Param("equMorRepayDetailVo")EquMorRepayDetailVo equMorRepayDetailVo);

}