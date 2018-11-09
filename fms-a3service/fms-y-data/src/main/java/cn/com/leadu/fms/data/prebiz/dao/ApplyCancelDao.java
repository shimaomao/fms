package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
public interface ApplyCancelDao extends BaseDao<ApplyCancel>{
    //分页查询融资申请取消
    List<ApplyCancelVo> selectApplyCancelByPage(@Param("applyCancelVo") ApplyCancelVo applyCancelVo);

    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return ApplyCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    ApplyCancelVo selectApplyCancelVoByApplyNo(@Param("applyNo") String applyNo);

}
