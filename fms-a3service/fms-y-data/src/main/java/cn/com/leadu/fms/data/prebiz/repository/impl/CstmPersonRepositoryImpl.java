package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmPersonDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersonRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.CstmPersonAddTelVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersonRepositoryImpl
 * @Description: 客户个人基本信息Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class CstmPersonRepositoryImpl extends AbstractBaseRepository<CstmPersonDao, CstmPerson> implements CstmPersonRepository {

    /**
     * @Title:
     * @Description: 新增客户个人基本信息
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int insertData(CstmPerson cstmPerson) {
        return super.insert(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 批量保存客户个人基本信息
     * @param cstmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int insertDataList(List<CstmPerson> cstmPersons){
        return super.insertListByJdbcTemplate(cstmPersons);
    }

    /**
     * @Title:
     * @Description: 修改客户个人基本信息
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int updateByPrimaryKeyData(CstmPerson cstmPerson) {
        return super.updateByPrimaryKey(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 批量修改客户个人基本信息
     * @param cstmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmPerson> cstmPersons){
        return super.insertListByJdbcTemplate(cstmPersons);
    }

    /**
     * @Title:
     * @Description: 动态修改客户个人基本信息
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmPerson cstmPerson) {
        return super.updateByPrimaryKeySelective(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户个人基本信息
     * @param cstmPersons
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmPerson> cstmPersons) {
        return super.updateListByPrimaryKeySelective(cstmPersons);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户个人基本信息
     * @param cstmPerson
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int updateByExampleData(CstmPerson cstmPerson, Example example) {
        return super.updateByExample(cstmPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户个人基本信息
     * @param cstmPerson
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int updateByExampleSelectiveData(CstmPerson cstmPerson, Example example){
        return super.updateByExampleSelective(cstmPerson,example);
    }
    
    /**
     * @Title:
     * @Description: 根据cstmPersonId删除客户个人基本信息
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public int deleteData(CstmPerson cstmPerson) {
        return super.delete(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 根据cstmPersonId集合批量删除客户个人基本信息
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public int deleteDataList(List cstmPersonIds,CstmPerson cstmPerson){
        return super.deleteByIds(cstmPersonIds,cstmPerson);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户个人基本信息
     * @param example
     * @param cstmPerson
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public int deleteExampleData(Example example,CstmPerson cstmPerson){
        return super.deleteByExample(example,cstmPerson);
    }

    /**
     * @Title:
     * @Description: 查询全部客户个人基本信息
     * @return List<CstmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public List<CstmPerson> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户个人基本信息
     * @param example
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public CstmPerson selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户个人基本信息
     * @param example
     * @return List<CstmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public List<CstmPerson> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过cstmPersonId查询客户个人基本信息
     * @param cstmPersonId
     * @return CstmPerson
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public CstmPerson selectByPrimaryKey(Object cstmPersonId) {
        return super.selectByPrimaryKey(cstmPersonId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    @Override
    public PageInfoExtend<CstmPerson> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户个人基本信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmPerson>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 11:27:21
     */
    public PageInfoExtend<CstmPerson> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Description: 根据身亲编号获取客户的地址信息和电话信息
     * @param:  applyNo 申请编号
     * @return: CstmPersonAddTelVo
     * @Author: wangxue
     * @Date: 2018/9/4 17:32
     */
    @Override
    public CstmPersonAddTelVo selectCstmPersonAddTelVoByApplyNo(String applyNo) {
        return baseDao.selectCstmPersonAddTelVoByApplyNo(applyNo);
    }
}
