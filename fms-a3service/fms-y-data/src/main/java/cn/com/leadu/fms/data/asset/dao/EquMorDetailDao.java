package cn.com.leadu.fms.data.asset.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailDao
 * @Description: 资方抵押明细dao层
 * @date 2018-05-30
 */
public interface EquMorDetailDao extends BaseDao<EquMorDetail> {

    List<EquMorDetailVo> selectEquMorDetailVosByPage(@Param("equMorDetailVo") EquMorDetailVo equMorDetailVo);

    List<EquMorDetailVo> selectEquMorDetailVoList(@Param("equMorDetailVo") EquMorDetailVo equMorDetailVo);

    /**
     * @Title:
     * @Description:   抵押任务明细
     * @param bizCodeType   归档借阅类型
     * @param equMorTaskNo      抵押任务号
     * @param applyTypePerson 个人申请类型
     * @param totalFlag 费用合计类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:52:41
     */
    List<EquMorDetailVo> selectEquMorDetailVosByEquMorTaskNo(@Param("bizCodeType") String bizCodeType,@Param("equMorTaskNo") String equMorTaskNo
                ,@Param("applyTypePerson") String applyTypePerson,@Param("totalFlag") String totalFlag);

}