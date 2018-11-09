package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.WlTemp02Dao;
import cn.com.leadu.fms.data.system.repository.WlTemp02Repository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.WlTemp02;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTemp02RepositoryImpl
 * @Description: 数据迁移Repository 实现层
 * @date 2018-08-04
 */
@Repository
public class WlTemp02RepositoryImpl extends AbstractBaseRepository<WlTemp02Dao, WlTemp02> implements WlTemp02Repository {

    /**
     * @Title:
     * @Description: 新增数据迁移
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int insertData(WlTemp02 wlTemp02) {
        return super.insert(wlTemp02);
    }

    /**
     * @Title:
     * @Description: 批量保存数据迁移
     * @param wlTemp02s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int insertDataList(List<WlTemp02> wlTemp02s){
        return super.insertListByJdbcTemplate(wlTemp02s);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeyData(WlTemp02 wlTemp02) {
        return super.updateByPrimaryKey(wlTemp02);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移
     * @param wlTemp02s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTemp02> wlTemp02s){
        return super.updateListByPrimaryKey(wlTemp02s);
    }

    /**
     * @Title:
     * @Description: 动态修改数据迁移
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTemp02 wlTemp02) {
        return super.updateByPrimaryKeySelective(wlTemp02);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移
     * @param wlTemp02s
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTemp02> wlTemp02s) {
        return super.updateListByPrimaryKeySelective(wlTemp02s);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移
     * @param wlTemp02
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByExampleData(WlTemp02 wlTemp02, Example example) {
        return super.updateByExample(wlTemp02,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移
     * @param wlTemp02
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByExampleSelectiveData(WlTemp02 wlTemp02, Example example){
        return super.updateByExampleSelective(wlTemp02,example);
    }
    
    /**
     * @Title:
     * @Description: 根据temp02Id删除数据迁移
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int deleteData(WlTemp02 wlTemp02) {
        return super.delete(wlTemp02);
    }

    /**
     * @Title:
     * @Description: 根据temp02Id集合批量删除数据迁移
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int deleteDataList(List temp02Ids,WlTemp02 wlTemp02){
        return super.deleteByIds(temp02Ids,wlTemp02);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除数据迁移
     * @param example
     * @param wlTemp02
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int deleteExampleData(Example example,WlTemp02 wlTemp02){
        return super.deleteByExample(example,wlTemp02);
    }

    /**
     * @Title:
     * @Description: 查询全部数据迁移
     * @return List<WlTemp02>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public List<WlTemp02> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个数据迁移
     * @param example
     * @return WlTemp02
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public WlTemp02 selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询数据迁移
     * @param example
     * @return List<WlTemp02>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public List<WlTemp02> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过temp02Id查询数据迁移
     * @param temp02Id
     * @return WlTemp02
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public WlTemp02 selectByPrimaryKey(Object temp02Id) {
        return super.selectByPrimaryKey(temp02Id);
    }
    
    /**
     * @Title:
     * @Description: 分页查询数据迁移
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WlTemp02>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public PageInfoExtend<WlTemp02> selectListByExamplePage(Example example, PageQuery pageQuery){
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
     * @date 2018-8-4 18:17:45
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTemp02,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeyData(WlTemp02 wlTemp02,boolean exclusive) {
        return super.updateByPrimaryKey(wlTemp02,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移,并进行排他
     * @param wlTemp02s
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTemp02> wlTemp02s,boolean exclusive){
        return super.updateListByPrimaryKey(wlTemp02s,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改数据迁移,并进行排他
     * @param wlTemp02
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTemp02 wlTemp02,boolean exclusive) {
        return super.updateByPrimaryKeySelective(wlTemp02,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移,并进行排他
     * @param wlTemp02s
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTemp02> wlTemp02s,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(wlTemp02s,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移,并进行排他
     * @param wlTemp02
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByExampleData(WlTemp02 wlTemp02, Example example,boolean exclusive) {
        return super.updateByExample(wlTemp02,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移,并进行排他
     * @param wlTemp02
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:17:45
     */
    @Override
    public int updateByExampleSelectiveData(WlTemp02 wlTemp02, Example example,boolean exclusive){
        return super.updateByExampleSelective(wlTemp02,example,exclusive);
    }

}
