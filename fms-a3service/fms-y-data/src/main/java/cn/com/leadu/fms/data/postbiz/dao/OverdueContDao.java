package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueContDao
 * @Description: 逾期合同信息dao层
 * @date 2018-05-16
 */
public interface OverdueContDao extends BaseDao<OverdueCont> {
    /**
     * @Title:
     * @Description: 分页查询逾期合同信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<OverdueContVo> selectOverdueContsByPage(@Param("overdueContVo")OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description: 根据contNo获取逾期合同信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    OverdueContVo selectOverdueContByContNo(@Param("contNo")String contNo);

    /**
     * @Title:
     * @Description: 获取合同的历史最高逾期天数和历史逾期次数
     * @return List<OverdueContVo>
     * @throws
     * @author wangxue
     * @date  2018-9-04 11:24:39
     */
    List<OverdueContVo> selectOverdueDaysHisAndOverdueTimes();

    /**
     * @Title:
     * @Description: 获取逾期客户表中的全部订单编号
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-9-04 11:24:39
     */
    List<String> selectAllApplyNosByOverdue();

    /**
     * @Title:
     * @Description:
     * @param overdueContVo 查询逾期合同vo数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 05:45:06
     */
    List<OverdueContVo> selectOverdueContVos(@Param("overdueContVo") OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description:   根据合同号获取逾期合同号
     * @param overdueContVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/17 04:14:21
     */
     OverdueContVo selectOverdueContVoByContNo(@Param("overdueContVo") OverdueContVo overdueContVo);

    /**
     * @Title:
     * @Description:  获取全部的当前正在逾期的逾期合同ID集合
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018/09/17 04:14:21
     */
     List<String> selectOverdueContIdsByOverdueFlag();

}