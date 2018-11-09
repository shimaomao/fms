package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.BasBlacklistDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasBlacklistRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistRepositoryImpl
 * @Description: 黑名单Repository 实现层
 * @date 2018-05-04
 */
@Repository
public class BasBlacklistRepositoryImpl extends AbstractBaseRepository<BasBlacklistDao, BasBlacklist> implements BasBlacklistRepository {

    /**
     * @Title:
     * @Description: 新增黑名单
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int insertData(BasBlacklist basBlacklist) {
        return super.insert(basBlacklist);
    }

    /**
     * @Title:
     * @Description: 批量保存黑名单
     * @param basBlacklists
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int insertDataList(List<BasBlacklist> basBlacklists){
        return super.insertListByJdbcTemplate(basBlacklists);
    }

    /**
     * @Title:
     * @Description: 修改黑名单
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int updateByPrimaryKeyData(BasBlacklist basBlacklist) {
        return super.updateByPrimaryKey(basBlacklist);
    }

    /**
     * @Title:
     * @Description: 批量修改黑名单
     * @param basBlacklists
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasBlacklist> basBlacklists){
        return super.updateListByPrimaryKey(basBlacklists);
    }

    /**
     * @Title:
     * @Description: 动态修改黑名单
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasBlacklist basBlacklist) {
        return super.updateByPrimaryKeySelective(basBlacklist);
    }

    /**
     * @Title:
     * @Description: 批量动态修改黑名单
     * @param basBlacklists
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasBlacklist> basBlacklists) {
        return super.updateListByPrimaryKeySelective(basBlacklists);
    }

    /**
     * @Title:
     * @Description: 根据条件修改黑名单
     * @param basBlacklist
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int updateByExampleData(BasBlacklist basBlacklist, Example example) {
        return super.updateByExample(basBlacklist,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改黑名单
     * @param basBlacklist
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int updateByExampleSelectiveData(BasBlacklist basBlacklist, Example example){
        return super.updateByExampleSelective(basBlacklist,example);
    }
    
    /**
     * @Title:
     * @Description: 根据blacklistId删除黑名单
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public int deleteData(BasBlacklist basBlacklist) {
        return super.delete(basBlacklist);
    }

    /**
     * @Title:
     * @Description: 根据blacklistId集合批量删除黑名单
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public int deleteDataList(List blacklistIds,BasBlacklist basBlacklist){
        return super.deleteByIds(blacklistIds,basBlacklist);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除黑名单
     * @param example
     * @param basBlacklist
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public int deleteExampleData(Example example,BasBlacklist basBlacklist){
        return super.deleteByExample(example,basBlacklist);
    }

    /**
     * @Title:
     * @Description: 查询全部黑名单
     * @return List<BasBlacklist>
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public List<BasBlacklist> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个黑名单
     * @param example
     * @return BasBlacklist
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public BasBlacklist selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询黑名单
     * @param example
     * @return List<BasBlacklist>
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public List<BasBlacklist> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过blacklistId查询黑名单
     * @param blacklistId
     * @return BasBlacklist
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public BasBlacklist selectByPrimaryKey(Object blacklistId) {
        return super.selectByPrimaryKey(blacklistId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询黑名单
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasBlacklist>
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Override
    public PageInfoExtend<BasBlacklist> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询黑名单vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
