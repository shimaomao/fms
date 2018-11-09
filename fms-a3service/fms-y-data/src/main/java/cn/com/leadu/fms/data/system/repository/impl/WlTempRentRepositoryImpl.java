package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.WlTempRentDao;
import cn.com.leadu.fms.data.system.repository.WlTempRentRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.WlTempRent;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WlTempRentRepositoryImpl
 * @Description: 数据迁移Repository 实现层
 * @date 2018-08-04
 */
@Repository
public class WlTempRentRepositoryImpl extends AbstractBaseRepository<WlTempRentDao, WlTempRent> implements WlTempRentRepository {

    /**
     * @Title:
     * @Description: 新增数据迁移
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int insertData(WlTempRent wlTempRent) {
        return super.insert(wlTempRent);
    }

    /**
     * @Title:
     * @Description: 批量保存数据迁移
     * @param wlTempRents
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int insertDataList(List<WlTempRent> wlTempRents){
        return super.insertListByJdbcTemplate(wlTempRents);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRent wlTempRent) {
        return super.updateByPrimaryKey(wlTempRent);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移
     * @param wlTempRents
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRent> wlTempRents){
        return super.updateListByPrimaryKey(wlTempRents);
    }

    /**
     * @Title:
     * @Description: 动态修改数据迁移
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRent wlTempRent) {
        return super.updateByPrimaryKeySelective(wlTempRent);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移
     * @param wlTempRents
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRent> wlTempRents) {
        return super.updateListByPrimaryKeySelective(wlTempRents);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移
     * @param wlTempRent
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByExampleData(WlTempRent wlTempRent, Example example) {
        return super.updateByExample(wlTempRent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移
     * @param wlTempRent
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRent wlTempRent, Example example){
        return super.updateByExampleSelective(wlTempRent,example);
    }
    
    /**
     * @Title:
     * @Description: 根据rentId删除数据迁移
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int deleteData(WlTempRent wlTempRent) {
        return super.delete(wlTempRent);
    }

    /**
     * @Title:
     * @Description: 根据rentId集合批量删除数据迁移
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int deleteDataList(List rentIds,WlTempRent wlTempRent){
        return super.deleteByIds(rentIds,wlTempRent);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除数据迁移
     * @param example
     * @param wlTempRent
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int deleteExampleData(Example example,WlTempRent wlTempRent){
        return super.deleteByExample(example,wlTempRent);
    }

    /**
     * @Title:
     * @Description: 查询全部数据迁移
     * @return List<WlTempRent>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public List<WlTempRent> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个数据迁移
     * @param example
     * @return WlTempRent
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public WlTempRent selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询数据迁移
     * @param example
     * @return List<WlTempRent>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public List<WlTempRent> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过rentId查询数据迁移
     * @param rentId
     * @return WlTempRent
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public WlTempRent selectByPrimaryKey(Object rentId) {
        return super.selectByPrimaryKey(rentId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询数据迁移
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<WlTempRent>
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public PageInfoExtend<WlTempRent> selectListByExamplePage(Example example, PageQuery pageQuery){
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
     * @date 2018-8-4 18:27:19
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改数据迁移
     * @param wlTempRent,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeyData(WlTempRent wlTempRent,boolean exclusive) {
        return super.updateByPrimaryKey(wlTempRent,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改数据迁移,并进行排他
     * @param wlTempRents
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeyDataList(List<WlTempRent> wlTempRents,boolean exclusive){
        return super.updateListByPrimaryKey(wlTempRents,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改数据迁移,并进行排他
     * @param wlTempRent
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(WlTempRent wlTempRent,boolean exclusive) {
        return super.updateByPrimaryKeySelective(wlTempRent,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改数据迁移,并进行排他
     * @param wlTempRents
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<WlTempRent> wlTempRents,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(wlTempRents,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改数据迁移,并进行排他
     * @param wlTempRent
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByExampleData(WlTempRent wlTempRent, Example example,boolean exclusive) {
        return super.updateByExample(wlTempRent,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改数据迁移,并进行排他
     * @param wlTempRent
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-8-4 18:27:19
     */
    @Override
    public int updateByExampleSelectiveData(WlTempRent wlTempRent, Example example,boolean exclusive){
        return super.updateByExampleSelective(wlTempRent,example,exclusive);
    }

}
