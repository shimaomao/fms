package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVoExcel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDao
 * @Description: 融资回填dao层
 * @date 2018-05-11
 */
public interface FinBackfillDao extends BaseDao<FinBackfill> {

    /**
     * @Title:
     * @Description: 分页获取财务回填信息
     * @param finBackfillVo 查询条件
     * @return List<FinBackfillVo>
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<FinBackfillVo> selectFinBackfillsByPage(@Param("finBackfillVo") FinBackfillVo finBackfillVo);

    /**
     * @Title:
     * @Description: 分页获取财务回填信息
     * @param filBackfillId 查询条件
     * @return FinBackfillVo
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    FinBackfillVo selectFinBackfillByFilBackfillId(@Param("filBackfillId") String filBackfillId);

    /**
     * @Title:
     * @Description: 分页获取财务回填信息
     * @param contRepaySkedVo 查询条件
     * @return ContRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-3-22 22:06:58
     */
    List<ContRepaySkedVo> selectContRepaySkedByfinBackfillVo(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVo
     * @return
     * @throws
     * @author yanfengbo
     */
    List<FinBackfillVoExcel> selectFinBackfillsForExportExcel(@Param("finBackfillVo") FinBackfillVo finBackfillVo);
}