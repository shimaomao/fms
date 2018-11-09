package cn.com.leadu.fms.data.asset.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeDao
 * @Description: 资方抵押费用dao层
 * @date 2018-05-30
 */
public interface EquMorChargeDao extends BaseDao<EquMorCharge> {

    /**
     * @Title:
     * @Description: 查询资方抵押申请合同列表
     * @param equMorApplyVo
     * @return  List<equMorChargeApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    List<EquMorApplyVo> selectEquMorApplyVos(@Param("equMorApplyVo") EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description: 查询资方抵押申请合同详情
     * @param equMorApplyVo
     * @return  EquMorChargeApplyVo
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    EquMorApplyVo selectEquMorApplyVoByContNo(@Param("equMorApplyVo") EquMorApplyVo equMorApplyVo);


    /**
     * @Title:
     * @Description: 查询资方抵押申请合同详情列表
     * @param equMorApplyVo
     * @return  List<EquMorChargeApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    List<EquMorApplyVo> selectEquMorApplyVosByContNos(@Param("equMorApplyVo") EquMorApplyVo equMorApplyVo);

    /**
     * @Title:
     * @Description: 查询资方抵押申请模板下载详情
     * @param equMorApplyVo
     * @return  List<EquMorApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    List<EquMorApplyVo> selectExportEquMorApplyVos(@Param("equMorApplyVo") EquMorApplyVo equMorApplyVo);

}