package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.baseinfo.dao.BasBankInfoDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasBankInfoRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoRepositoryImpl
 * @Description: 银行账号维护Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class BasBankInfoRepositoryImpl extends AbstractBaseRepository<BasBankInfoDao, BasBankInfo> implements BasBankInfoRepository {

    /**
     * @Title:
     * @Description: 新增银行账号维护
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int insertData(BasBankInfo basBankInfo) {
        return super.insert(basBankInfo);
    }

    /**
     * @Title:
     * @Description: 批量保存银行账号维护
     * @param basBankInfos
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int insertDataList(List<BasBankInfo> basBankInfos){
        return super.insertListByJdbcTemplate(basBankInfos);
    }

    /**
     * @Title:
     * @Description: 修改银行账号维护
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int updateByPrimaryKeyData(BasBankInfo basBankInfo) {
        return super.updateByPrimaryKey(basBankInfo);
    }

    /**
     * @Title:
     * @Description: 批量修改银行账号维护
     * @param basBankInfos
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasBankInfo> basBankInfos){
        return super.updateListByPrimaryKey(basBankInfos);
    }

    /**
     * @Title:
     * @Description: 动态修改银行账号维护
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasBankInfo basBankInfo) {
        return super.updateByPrimaryKeySelective(basBankInfo);
    }

    /**
     * @Title:
     * @Description: 批量动态修改银行账号维护
     * @param basBankInfos
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasBankInfo> basBankInfos) {
        return super.updateListByPrimaryKeySelective(basBankInfos);
    }

    /**
     * @Title:
     * @Description: 根据条件修改银行账号维护
     * @param basBankInfo
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int updateByExampleData(BasBankInfo basBankInfo, Example example) {
        return super.updateByExample(basBankInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改银行账号维护
     * @param basBankInfo
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int updateByExampleSelectiveData(BasBankInfo basBankInfo, Example example){
        return super.updateByExampleSelective(basBankInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据bankId删除银行账号维护
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public int deleteData(BasBankInfo basBankInfo) {
        return super.delete(basBankInfo);
    }

    /**
     * @Title:
     * @Description: 根据bankId集合批量删除银行账号维护
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public int deleteDataList(List bankIds,BasBankInfo basBankInfo){
        return super.deleteByIds(bankIds,basBankInfo);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除银行账号维护
     * @param example
     * @param basBankInfo
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public int deleteExampleData(Example example,BasBankInfo basBankInfo){
        return super.deleteByExample(example,basBankInfo);
    }

    /**
     * @Title:
     * @Description: 查询全部银行账号维护
     * @return List<BasBankInfo>
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public List<BasBankInfo> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个银行账号维护
     * @param example
     * @return BasBankInfo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public BasBankInfo selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询银行账号维护
     * @param example
     * @return List<BasBankInfo>
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public List<BasBankInfo> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过bankId查询银行账号维护
     * @param bankId
     * @return BasBankInfo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public BasBankInfo selectByPrimaryKey(Object bankId) {
        return super.selectByPrimaryKey(bankId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询银行账号维护
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasBankInfo>
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @Override
    public PageInfoExtend<BasBankInfo> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询银行账号维护vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasBankInfo>
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public PageInfoExtend<BasBankInfoVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 通过主键关联sys_group表查询bas_bank_info
     * @param bankId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-22 22:06:58
     */
    public BasBankInfoVo selectBasBankInfoFromSysGroupById(String bankId){
        return baseDao.selectBasBankInfoFromSysGroupById(bankId);

    }

}
