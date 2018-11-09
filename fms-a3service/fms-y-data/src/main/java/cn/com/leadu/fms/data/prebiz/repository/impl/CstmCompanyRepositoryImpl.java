package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmCompanyDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmCompanyRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmCompanyRepositoryImpl
 * @Description: 客户企业基本信息Repository 实现层
 * @date 2018-03-27
 */
@Repository
public class CstmCompanyRepositoryImpl extends AbstractBaseRepository<CstmCompanyDao, CstmCompany> implements CstmCompanyRepository {

    /**
     * @Title:
     * @Description: 新增客户企业基本信息
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int insertData(CstmCompany cstmCompany) {
        return super.insert(cstmCompany);
    }

    /**
     * @Title:
     * @Description: 批量保存客户企业基本信息
     * @param cstmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int insertDataList(List<CstmCompany> cstmCompanys){
        return super.insertListByJdbcTemplate(cstmCompanys);
    }

    /**
     * @Title:
     * @Description: 修改客户企业基本信息
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int updateByPrimaryKeyData(CstmCompany cstmCompany) {
        return super.updateByPrimaryKey(cstmCompany);
    }

    /**
     * @Title:
     * @Description: 批量修改客户企业基本信息
     * @param cstmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmCompany> cstmCompanys){
        return super.insertListByJdbcTemplate(cstmCompanys);
    }

    /**
     * @Title:
     * @Description: 动态修改客户企业基本信息
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmCompany cstmCompany) {
        return super.updateByPrimaryKeySelective(cstmCompany);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户企业基本信息
     * @param cstmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmCompany> cstmCompanys) {
        return super.updateListByPrimaryKeySelective(cstmCompanys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户企业基本信息
     * @param cstmCompany
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int updateByExampleData(CstmCompany cstmCompany, Example example) {
        return super.updateByExample(cstmCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户企业基本信息
     * @param cstmCompany
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int updateByExampleSelectiveData(CstmCompany cstmCompany, Example example){
        return super.updateByExampleSelective(cstmCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据cstmCompanyId删除客户企业基本信息
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public int deleteData(CstmCompany cstmCompany) {
        return super.delete(cstmCompany);
    }

    /**
     * @Title:
     * @Description: 根据cstmCompanyId集合批量删除客户企业基本信息
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public int deleteDataList(List cstmCompanyIds,CstmCompany cstmCompany){
        return super.deleteByIds(cstmCompanyIds,cstmCompany);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户企业基本信息
     * @param example
     * @param cstmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public int deleteExampleData(Example example,CstmCompany cstmCompany){
        return super.deleteByExample(example,cstmCompany);
    }

    /**
     * @Title:
     * @Description: 查询全部客户企业基本信息
     * @return List<CstmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public List<CstmCompany> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户企业基本信息
     * @param example
     * @return CstmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public CstmCompany selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户企业基本信息
     * @param example
     * @return List<CstmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public List<CstmCompany> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过cstmCompanyId查询客户企业基本信息
     * @param cstmCompanyId
     * @return CstmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public CstmCompany selectByPrimaryKey(Object cstmCompanyId) {
        return super.selectByPrimaryKey(cstmCompanyId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    @Override
    public PageInfoExtend<CstmCompany> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户企业基本信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-3-27 11:11:47
     */
    public PageInfoExtend<CstmCompany> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
