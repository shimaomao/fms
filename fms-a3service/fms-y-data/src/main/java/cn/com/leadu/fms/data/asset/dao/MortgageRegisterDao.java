package cn.com.leadu.fms.data.asset.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterDao
 * @Description: 解抵押过户信息dao层
 * @date 2018-05-18
 */
public interface MortgageRegisterDao extends BaseDao<MortgageRegister> {

    /**
     * @Title:
     * @Description: 分页查询解抵押过户一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<MortgageRegisterVo> selectMortgageRegistersByPage(@Param("mortgageRegisterVo")MortgageRegisterVo mortgageRegisterVo);

}