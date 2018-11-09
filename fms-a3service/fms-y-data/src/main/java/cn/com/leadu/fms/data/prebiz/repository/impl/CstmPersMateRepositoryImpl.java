package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmPersMateDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersMateRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateRepositoryImpl
 * @Description: 客户个人配偶信息Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class CstmPersMateRepositoryImpl extends AbstractBaseRepository<CstmPersMateDao, CstmPersMate> implements CstmPersMateRepository {

    /**
     * @Title:
     * @Description: 新增客户个人配偶信息
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int insertData(CstmPersMate cstmPersMate) {
        return super.insert(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 批量保存客户个人配偶信息
     * @param cstmPersMates
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int insertDataList(List<CstmPersMate> cstmPersMates){
        return super.insertListByJdbcTemplate(cstmPersMates);
    }

    /**
     * @Title:
     * @Description: 修改客户个人配偶信息
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int updateByPrimaryKeyData(CstmPersMate cstmPersMate) {
        return super.updateByPrimaryKey(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 批量修改客户个人配偶信息
     * @param cstmPersMates
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmPersMate> cstmPersMates){
        return super.insertListByJdbcTemplate(cstmPersMates);
    }

    /**
     * @Title:
     * @Description: 动态修改客户个人配偶信息
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmPersMate cstmPersMate) {
        return super.updateByPrimaryKeySelective(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户个人配偶信息
     * @param cstmPersMates
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmPersMate> cstmPersMates) {
        return super.updateListByPrimaryKeySelective(cstmPersMates);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户个人配偶信息
     * @param cstmPersMate
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int updateByExampleData(CstmPersMate cstmPersMate, Example example) {
        return super.updateByExample(cstmPersMate,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户个人配偶信息
     * @param cstmPersMate
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int updateByExampleSelectiveData(CstmPersMate cstmPersMate, Example example){
        return super.updateByExampleSelective(cstmPersMate,example);
    }
    
    /**
     * @Title:
     * @Description: 根据persMateId删除客户个人配偶信息
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public int deleteData(CstmPersMate cstmPersMate) {
        return super.delete(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 根据persMateId集合批量删除客户个人配偶信息
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public int deleteDataList(List persMateIds,CstmPersMate cstmPersMate){
        return super.deleteByIds(persMateIds,cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户个人配偶信息
     * @param example
     * @param cstmPersMate
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public int deleteExampleData(Example example,CstmPersMate cstmPersMate){
        return super.deleteByExample(example,cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 查询全部客户个人配偶信息
     * @return List<CstmPersMate>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public List<CstmPersMate> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户个人配偶信息
     * @param example
     * @return CstmPersMate
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public CstmPersMate selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户个人配偶信息
     * @param example
     * @return List<CstmPersMate>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public List<CstmPersMate> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过persMateId查询客户个人配偶信息
     * @param persMateId
     * @return CstmPersMate
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public CstmPersMate selectByPrimaryKey(Object persMateId) {
        return super.selectByPrimaryKey(persMateId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmPersMate>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public PageInfoExtend<CstmPersMate> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<CstmPersMate>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public PageInfoExtend<CstmPersMate> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
