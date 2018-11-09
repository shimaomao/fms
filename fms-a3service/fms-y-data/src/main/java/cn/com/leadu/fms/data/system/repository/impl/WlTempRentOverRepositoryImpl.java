package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.WlTempRentOverDao;
import cn.com.leadu.fms.data.system.repository.WlTempRentOverRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.WlTempRentOver;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentOverRepositoryImpl
 * @Description: 数据迁移Repository 实现层
 * @date 2018-08-04
 */
@Repository
public class WlTempRentOverRepositoryImpl extends AbstractBaseRepository<WlTempRentOverDao, WlTempRentOver> implements WlTempRentOverRepository {

    /**
     * @Title:
     * @Description: 新增数据迁移
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int insertData(WlTempRentOver wlTempRentOver) {
        return super.insert(wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 批量保存数据迁移
     * @param wlTempRentOvers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int insertDataList(List<WlTempRentOver> wlTempRentOvers){
        return super.insertListByJdbcTemplate(wlTempRentOvers);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRentOver wlTempRentOver) {
        return super.updateByPrimaryKey(wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移
     * @param wlTempRentOvers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRentOver> wlTempRentOvers){
        return super.updateListByPrimaryKey(wlTempRentOvers);
    }

    /**
     * @Title:
     * @Description: 动态修改数据迁移
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRentOver wlTempRentOver) {
        return super.updateByPrimaryKeySelective(wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移
     * @param wlTempRentOvers
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRentOver> wlTempRentOvers) {
        return super.updateListByPrimaryKeySelective(wlTempRentOvers);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移
     * @param wlTempRentOver
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByExampleData(WlTempRentOver wlTempRentOver, Example example) {
        return super.updateByExample(wlTempRentOver,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移
     * @param wlTempRentOver
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRentOver wlTempRentOver, Example example){
        return super.updateByExampleSelective(wlTempRentOver,example);
    }
    
    /**
     * @Title:
     * @Description: 根据rentOverId删除数据迁移
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int deleteData(WlTempRentOver wlTempRentOver) {
        return super.delete(wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 根据rentOverId集合批量删除数据迁移
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int deleteDataList(List rentOverIds,WlTempRentOver wlTempRentOver){
        return super.deleteByIds(rentOverIds,wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除数据迁移
     * @param example
     * @param wlTempRentOver
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int deleteExampleData(Example example,WlTempRentOver wlTempRentOver){
        return super.deleteByExample(example,wlTempRentOver);
    }

    /**
     * @Title:
     * @Description: 查询全部数据迁移
     * @return List<WlTempRentOver>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public List<WlTempRentOver> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个数据迁移
     * @param example
     * @return WlTempRentOver
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public WlTempRentOver selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询数据迁移
     * @param example
     * @return List<WlTempRentOver>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public List<WlTempRentOver> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过rentOverId查询数据迁移
     * @param rentOverId
     * @return WlTempRentOver
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public WlTempRentOver selectByPrimaryKey(Object rentOverId) {
        return super.selectByPrimaryKey(rentOverId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询数据迁移
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WlTempRentOver>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public PageInfoExtend<WlTempRentOver> selectListByExamplePage(Example example, PageQuery pageQuery){
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
     * @date 2018-8-4 18:18:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRentOver,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRentOver wlTempRentOver,boolean exclusive) {
        return super.updateByPrimaryKey(wlTempRentOver,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移,并进行排他
     * @param wlTempRentOvers
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRentOver> wlTempRentOvers,boolean exclusive){
        return super.updateListByPrimaryKey(wlTempRentOvers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改数据迁移,并进行排他
     * @param wlTempRentOver
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRentOver wlTempRentOver,boolean exclusive) {
        return super.updateByPrimaryKeySelective(wlTempRentOver,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移,并进行排他
     * @param wlTempRentOvers
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRentOver> wlTempRentOvers,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(wlTempRentOvers,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移,并进行排他
     * @param wlTempRentOver
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByExampleData(WlTempRentOver wlTempRentOver, Example example,boolean exclusive) {
        return super.updateByExample(wlTempRentOver,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移,并进行排他
     * @param wlTempRentOver
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:17
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRentOver wlTempRentOver, Example example,boolean exclusive){
        return super.updateByExampleSelective(wlTempRentOver,example,exclusive);
    }

}
