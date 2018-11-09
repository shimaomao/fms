package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.WlTempRentBadDao;
import cn.com.leadu.fms.data.system.repository.WlTempRentBadRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.WlTempRentBad;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentBadRepositoryImpl
 * @Description: 数据迁移Repository 实现层
 * @date 2018-08-04
 */
@Repository
public class WlTempRentBadRepositoryImpl extends AbstractBaseRepository<WlTempRentBadDao, WlTempRentBad> implements WlTempRentBadRepository {

    /**
     * @Title:
     * @Description: 新增数据迁移
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int insertData(WlTempRentBad wlTempRentBad) {
        return super.insert(wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 批量保存数据迁移
     * @param wlTempRentBads
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int insertDataList(List<WlTempRentBad> wlTempRentBads){
        return super.insertListByJdbcTemplate(wlTempRentBads);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRentBad wlTempRentBad) {
        return super.updateByPrimaryKey(wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移
     * @param wlTempRentBads
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRentBad> wlTempRentBads){
        return super.updateListByPrimaryKey(wlTempRentBads);
    }

    /**
     * @Title:
     * @Description: 动态修改数据迁移
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRentBad wlTempRentBad) {
        return super.updateByPrimaryKeySelective(wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移
     * @param wlTempRentBads
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRentBad> wlTempRentBads) {
        return super.updateListByPrimaryKeySelective(wlTempRentBads);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移
     * @param wlTempRentBad
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByExampleData(WlTempRentBad wlTempRentBad, Example example) {
        return super.updateByExample(wlTempRentBad,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移
     * @param wlTempRentBad
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRentBad wlTempRentBad, Example example){
        return super.updateByExampleSelective(wlTempRentBad,example);
    }
    
    /**
     * @Title:
     * @Description: 根据rentBadId删除数据迁移
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int deleteData(WlTempRentBad wlTempRentBad) {
        return super.delete(wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 根据rentBadId集合批量删除数据迁移
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int deleteDataList(List rentBadIds,WlTempRentBad wlTempRentBad){
        return super.deleteByIds(rentBadIds,wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除数据迁移
     * @param example
     * @param wlTempRentBad
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int deleteExampleData(Example example,WlTempRentBad wlTempRentBad){
        return super.deleteByExample(example,wlTempRentBad);
    }

    /**
     * @Title:
     * @Description: 查询全部数据迁移
     * @return List<WlTempRentBad>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public List<WlTempRentBad> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个数据迁移
     * @param example
     * @return WlTempRentBad
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public WlTempRentBad selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询数据迁移
     * @param example
     * @return List<WlTempRentBad>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public List<WlTempRentBad> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过rentBadId查询数据迁移
     * @param rentBadId
     * @return WlTempRentBad
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public WlTempRentBad selectByPrimaryKey(Object rentBadId) {
        return super.selectByPrimaryKey(rentBadId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询数据迁移
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WlTempRentBad>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public PageInfoExtend<WlTempRentBad> selectListByExamplePage(Example example, PageQuery pageQuery){
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
     * @date 2018-8-4 18:18:48
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRentBad,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRentBad wlTempRentBad,boolean exclusive) {
        return super.updateByPrimaryKey(wlTempRentBad,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移,并进行排他
     * @param wlTempRentBads
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRentBad> wlTempRentBads,boolean exclusive){
        return super.updateListByPrimaryKey(wlTempRentBads,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改数据迁移,并进行排他
     * @param wlTempRentBad
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRentBad wlTempRentBad,boolean exclusive) {
        return super.updateByPrimaryKeySelective(wlTempRentBad,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移,并进行排他
     * @param wlTempRentBads
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRentBad> wlTempRentBads,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(wlTempRentBads,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移,并进行排他
     * @param wlTempRentBad
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByExampleData(WlTempRentBad wlTempRentBad, Example example,boolean exclusive) {
        return super.updateByExample(wlTempRentBad,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移,并进行排他
     * @param wlTempRentBad
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:18:48
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRentBad wlTempRentBad, Example example,boolean exclusive){
        return super.updateByExampleSelective(wlTempRentBad,example,exclusive);
    }

}
