package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailDao
 * @Description: 融资费用明细信息dao层
 * @date 2018-03-24
 */
public interface ApplyFinDetailDao extends BaseDao<ApplyFinDetail> {

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资费用明细信息
     * @param applyNo 订单编号
     * @return List<ApplyFinDetailVo>
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    List<ApplyFinDetailVo> selectApplyFinDetailVosByApplyNo(@Param("applyNo")String applyNo);

}