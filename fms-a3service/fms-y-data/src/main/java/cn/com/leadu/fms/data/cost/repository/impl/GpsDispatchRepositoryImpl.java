package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.GpsDispatchDao;
import cn.com.leadu.fms.data.cost.repository.GpsDispatchRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchRepositoryImpl
 * @Description: 派单信息Repository 实现层
 * @date 2018-05-25
 */
@Repository
public class GpsDispatchRepositoryImpl extends AbstractBaseRepository<GpsDispatchDao, GpsDispatch> implements GpsDispatchRepository {

    /**
     * @Title:
     * @Description: 新增派单信息
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int insertData(GpsDispatch gpsDispatch) {
        return super.insert(gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 批量保存派单信息
     * @param gpsDispatchs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int insertDataList(List<GpsDispatch> gpsDispatchs){
        return super.insertListByJdbcTemplate(gpsDispatchs);
    }

    /**
     * @Title:
     * @Description: 修改派单信息
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeyData(GpsDispatch gpsDispatch) {
        return super.updateByPrimaryKey(gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 批量修改派单信息
     * @param gpsDispatchs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeyDataList(List<GpsDispatch> gpsDispatchs){
        return super.updateListByPrimaryKey(gpsDispatchs);
    }

    /**
     * @Title:
     * @Description: 动态修改派单信息
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(GpsDispatch gpsDispatch) {
        return super.updateByPrimaryKeySelective(gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 批量动态修改派单信息
     * @param gpsDispatchs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public int updateByPrimaryKeySelectiveDataList(List<GpsDispatch> gpsDispatchs) {
        return super.updateListByPrimaryKeySelective(gpsDispatchs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改派单信息
     * @param gpsDispatch
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByExampleData(GpsDispatch gpsDispatch, Example example) {
        return super.updateByExample(gpsDispatch,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改派单信息
     * @param gpsDispatch
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByExampleSelectiveData(GpsDispatch gpsDispatch, Example example){
        return super.updateByExampleSelective(gpsDispatch,example);
    }
    
    /**
     * @Title:
     * @Description: 根据dispatchId删除派单信息
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int deleteData(GpsDispatch gpsDispatch) {
        return super.delete(gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 根据dispatchId集合批量删除派单信息
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public int deleteDataList(List dispatchIds,GpsDispatch gpsDispatch){
        return super.deleteByIds(dispatchIds,gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除派单信息
     * @param example
     * @param gpsDispatch
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public int deleteExampleData(Example example,GpsDispatch gpsDispatch){
        return super.deleteByExample(example,gpsDispatch);
    }

    /**
     * @Title:
     * @Description: 查询全部派单信息
     * @return List<GpsDispatch>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public List<GpsDispatch> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个派单信息
     * @param example
     * @return GpsDispatch
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public GpsDispatch selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询派单信息
     * @param example
     * @return List<GpsDispatch>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public List<GpsDispatch> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过dispatchId查询派单信息
     * @param dispatchId
     * @return GpsDispatch
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public GpsDispatch selectByPrimaryKey(Object dispatchId) {
        return super.selectByPrimaryKey(dispatchId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询派单信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<GpsDispatch>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public PageInfoExtend<GpsDispatch> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询派单信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 动态修改派单信息,并进行排他
     * @param gpsDispatch
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(GpsDispatch gpsDispatch,boolean exclusive) {
        return super.updateByPrimaryKeySelective(gpsDispatch,exclusive);
    }


    /**
     * @Title:
     * @Description:   根据合同id查询派单信息详情
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    @Override
    public GpsDispatchVo selectGpsDispatchVo(GpsDispatchVo gpsDispatchVo){
        return baseDao.selectGpsDispatchVo(gpsDispatchVo);
    }

}
