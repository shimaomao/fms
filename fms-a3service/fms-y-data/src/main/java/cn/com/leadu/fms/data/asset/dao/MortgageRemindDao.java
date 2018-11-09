package cn.com.leadu.fms.data.asset.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindDao
 * @Description: 抵押提醒dao层
 * @date 2018-07-27
 */
public interface MortgageRemindDao extends BaseDao<MortgageRemind> {

    /**
     * @Title:
     * @Description: 分页查询抵押提醒
     * @param mortgageRemindVo
     * @return PageInfoExtend<MortgageRemind>
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    List<MortgageRemindVo> selectMortgageRemindsByPage(@Param("mortgageRemindVo") MortgageRemindVo mortgageRemindVo);

    /**
     * @Title:
     * @Description: 根据ID获取数据信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    MortgageRemindVo selectMortgageRemindVosBymorRemindId(@Param("morRemindId") String morRemindId);
}