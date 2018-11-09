package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoDao
 * @Description: 银行账号维护dao层
 * @date 2018-03-26
 */
public interface BasBankInfoDao extends BaseDao<BasBankInfo> {
    /**
     * @Title:
     * @Description: 关联sys_group表分页查询bas_bank_info
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    public List<BasBankInfoVo> selectBasBankInfoFromSysGroupByPage(@Param("basBankInfoVo")BasBankInfoVo basBankInfoVo);

    /**
     * @Title:
     * @Description: 通过主键关联sys_group表查询bas_bank_info
     * @param bankId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    public  BasBankInfoVo selectBasBankInfoFromSysGroupById(@Param("bankId")String bankId);


}