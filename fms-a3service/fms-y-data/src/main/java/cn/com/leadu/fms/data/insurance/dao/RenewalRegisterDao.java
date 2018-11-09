package cn.com.leadu.fms.data.insurance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.insurance.entity.RenewalRegister;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RenewalRegisterDao
 * @Description: 续保任务登记dao层
 * @date 2018-05-17
 */
public interface RenewalRegisterDao extends BaseDao<RenewalRegister> {
    /**
     * @Title:
     * @Description: 分页查询续保任务一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<RenewalRegisterVo> selectRenewalRegistersByPage(@Param("renewalRegisterVo")RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 根据任务号查找续保任务
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    List<RenewalRegisterVo> selectRenewalRegistersByTaskNo(@Param("renewalRegisterVo")RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 查找保险到期前三日保险信息
     * @param  renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date
     */
    List<RenewalRegisterVo> selectRenewalRegistersPriorMonth(@Param("renewalRegisterVo")RenewalRegisterVo renewalRegisterVo);

    /**
     * @Title:
     * @Description: 查找即将到期保险信息
     * @param  renewalRegisterVo
     * @return RenewalRegisterVo
     * @throws
     * @author ningyangyang
     * @date
     */
    List<RenewalRegisterVo> selectContInsurance(@Param("renewalRegisterVo")RenewalRegisterVo renewalRegisterVo);

/**
 * @Title:
 * @Description: 查找到期日前1个月保险信息
 * @param  renewalRegisterVo
 * @return RenewalRegisterVo
 * @throws
 * @author ningyangyang
 * @date
 */
    List<ContInsuranceVo> selectContInsuranPerMonth(@Param("renewalRegisterVo")RenewalRegisterVo renewalRegisterVo);
}