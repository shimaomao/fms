package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.WlTemp01Dao;
import cn.com.leadu.fms.data.system.repository.WlTemp01Repository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.WlTemp01;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTemp01RepositoryImpl
 * @Description: 数据迁移Repository 实现层
 * @date 2018-08-04
 */
@Repository
public class WlTemp01RepositoryImpl extends AbstractBaseRepository<WlTemp01Dao, WlTemp01> implements WlTemp01Repository {

    /**
     * @Title:
     * @Description: 新增数据迁移
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int insertData(WlTemp01 wlTemp01) {
        return super.insert(wlTemp01);
    }

    /**
     * @Title:
     * @Description: 批量保存数据迁移
     * @param wlTemp01s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int insertDataList(List<WlTemp01> wlTemp01s){
        return super.insertListByJdbcTemplate(wlTemp01s);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeyData(WlTemp01 wlTemp01) {
        return super.updateByPrimaryKey(wlTemp01);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移
     * @param wlTemp01s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTemp01> wlTemp01s){
        return super.updateListByPrimaryKey(wlTemp01s);
    }

    /**
     * @Title:
     * @Description: 动态修改数据迁移
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTemp01 wlTemp01) {
        return super.updateByPrimaryKeySelective(wlTemp01);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移
     * @param wlTemp01s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTemp01> wlTemp01s) {
        return super.updateListByPrimaryKeySelective(wlTemp01s);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移
     * @param wlTemp01
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByExampleData(WlTemp01 wlTemp01, Example example) {
        return super.updateByExample(wlTemp01,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移
     * @param wlTemp01
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByExampleSelectiveData(WlTemp01 wlTemp01, Example example){
        return super.updateByExampleSelective(wlTemp01,example);
    }
    
    /**
     * @Title:
     * @Description: 根据temp01Id删除数据迁移
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int deleteData(WlTemp01 wlTemp01) {
        return super.delete(wlTemp01);
    }

    /**
     * @Title:
     * @Description: 根据temp01Id集合批量删除数据迁移
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int deleteDataList(List temp01Ids,WlTemp01 wlTemp01){
        return super.deleteByIds(temp01Ids,wlTemp01);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除数据迁移
     * @param example
     * @param wlTemp01
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int deleteExampleData(Example example,WlTemp01 wlTemp01){
        return super.deleteByExample(example,wlTemp01);
    }

    /**
     * @Title:
     * @Description: 查询全部数据迁移
     * @return List<WlTemp01>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public List<WlTemp01> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个数据迁移
     * @param example
     * @return WlTemp01
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public WlTemp01 selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询数据迁移
     * @param example
     * @return List<WlTemp01>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public List<WlTemp01> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过temp01Id查询数据迁移
     * @param temp01Id
     * @return WlTemp01
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public WlTemp01 selectByPrimaryKey(Object temp01Id) {
        return super.selectByPrimaryKey(temp01Id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询数据迁移
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WlTemp01>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public PageInfoExtend<WlTemp01> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询数据迁移vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTemp01,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeyData(WlTemp01 wlTemp01,boolean exclusive) {
        return super.updateByPrimaryKey(wlTemp01,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移,并进行排他
     * @param wlTemp01s
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTemp01> wlTemp01s,boolean exclusive){
        return super.updateListByPrimaryKey(wlTemp01s,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改数据迁移,并进行排他
     * @param wlTemp01
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTemp01 wlTemp01,boolean exclusive) {
        return super.updateByPrimaryKeySelective(wlTemp01,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移,并进行排他
     * @param wlTemp01s
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTemp01> wlTemp01s,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(wlTemp01s,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移,并进行排他
     * @param wlTemp01
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByExampleData(WlTemp01 wlTemp01, Example example,boolean exclusive) {
        return super.updateByExample(wlTemp01,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移,并进行排他
     * @param wlTemp01
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:09
     */
    @Override
    public int updateByExampleSelectiveData(WlTemp01 wlTemp01, Example example,boolean exclusive){
        return super.updateByExampleSelective(wlTemp01,example,exclusive);
    }

}
