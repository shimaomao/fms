package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CrmCompanyDao;
import cn.com.leadu.fms.data.prebiz.repository.CrmCompanyRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmCompany;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CrmCompanyRepositoryImpl
 * @Description: CRM企业信息Repository 实现层
 * @date 2018-05-23
 */
@Repository
public class CrmCompanyRepositoryImpl extends AbstractBaseRepository<CrmCompanyDao, CrmCompany> implements CrmCompanyRepository {

    /**
     * @Title:
     * @Description: 新增CRM企业信息
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int insertData(CrmCompany crmCompany) {
        return super.insert(crmCompany);
    }

    /**
     * @Title:
     * @Description: 批量保存CRM企业信息
     * @param crmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int insertDataList(List<CrmCompany> crmCompanys){
        return super.insertListByJdbcTemplate(crmCompanys);
    }

    /**
     * @Title:
     * @Description: 修改CRM企业信息
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int updateByPrimaryKeyData(CrmCompany crmCompany) {
        return super.updateByPrimaryKey(crmCompany);
    }

    /**
     * @Title:
     * @Description: 批量修改CRM企业信息
     * @param crmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CrmCompany> crmCompanys){
        return super.updateListByPrimaryKey(crmCompanys);
    }

    /**
     * @Title:
     * @Description: 动态修改CRM企业信息
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CrmCompany crmCompany) {
        return super.updateByPrimaryKeySelective(crmCompany);
    }

    /**
     * @Title:
     * @Description: 批量动态修改CRM企业信息
     * @param crmCompanys
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public int updateByPrimaryKeySelectiveDataList(List<CrmCompany> crmCompanys) {
        return super.updateListByPrimaryKeySelective(crmCompanys);
    }

    /**
     * @Title:
     * @Description: 根据条件修改CRM企业信息
     * @param crmCompany
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int updateByExampleData(CrmCompany crmCompany, Example example) {
        return super.updateByExample(crmCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改CRM企业信息
     * @param crmCompany
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int updateByExampleSelectiveData(CrmCompany crmCompany, Example example){
        return super.updateByExampleSelective(crmCompany,example);
    }
    
    /**
     * @Title:
     * @Description: 根据companyId删除CRM企业信息
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public int deleteData(CrmCompany crmCompany) {
        return super.delete(crmCompany);
    }

    /**
     * @Title:
     * @Description: 根据companyId集合批量删除CRM企业信息
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public int deleteDataList(List companyIds,CrmCompany crmCompany){
        return super.deleteByIds(companyIds,crmCompany);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除CRM企业信息
     * @param example
     * @param crmCompany
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public int deleteExampleData(Example example,CrmCompany crmCompany){
        return super.deleteByExample(example,crmCompany);
    }

    /**
     * @Title:
     * @Description: 查询全部CRM企业信息
     * @return List<CrmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public List<CrmCompany> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个CRM企业信息
     * @param example
     * @return CrmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public CrmCompany selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询CRM企业信息
     * @param example
     * @return List<CrmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public List<CrmCompany> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过companyId查询CRM企业信息
     * @param companyId
     * @return CrmCompany
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public CrmCompany selectByPrimaryKey(Object companyId) {
        return super.selectByPrimaryKey(companyId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询CRM企业信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CrmCompany>
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    @Override
    public PageInfoExtend<CrmCompany> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询CRM企业信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-23 18:09:00
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
