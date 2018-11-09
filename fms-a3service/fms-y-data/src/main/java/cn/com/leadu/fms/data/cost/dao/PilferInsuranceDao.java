package cn.com.leadu.fms.data.cost.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.cost.entity.PilferInsurance;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.CstmDetailVo;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceDao
 * @Description: 盗抢险信息dao层
 * @date 2018-05-31
 */
public interface PilferInsuranceDao extends BaseDao<PilferInsurance> {

    /** 
    * @Description: 查询盗抢险月结信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 17:28
    */ 
    List<PilferInsuranceVo> selectPilferInsuranceMonthlysVosByPage(@Param("pilferInsuranceVo") PilferInsuranceVo pilferInsuranceVo);

    /** 
    * @Description:  查询盗抢险月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/17 21:21
    */ 
    List<PilferInsuranceVo> selectPilferInsuranceMonthlysVosListByPage(@Param("pilferInsuranceVo") PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<PilferInsuranceVo> selectPilferInsurancesByPage(@Param("pilferInsuranceVo") PilferInsuranceVo pilferInsuranceVo);

    /**
     * @Title:
     * @Description: 根据合同号查询一条客户基本信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    CstmDetailVo selectOneCstmDetailByContNo(@Param("contNo") String contNo);
}