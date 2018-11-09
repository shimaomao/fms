package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.CarCollectCompDao;
import cn.com.leadu.fms.data.postbiz.repository.CarCollectCompRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompRepositoryImpl
 * @Description: 收车机构维护Repository 实现层
 * @date 2018-05-22
 */
@Repository
public class CarCollectCompRepositoryImpl extends AbstractBaseRepository<CarCollectCompDao, CarCollectComp> implements CarCollectCompRepository {

    /**
     * @Title:
     * @Description: 新增收车机构维护
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int insertData(CarCollectComp carCollectComp) {
        return super.insert(carCollectComp);
    }

    /**
     * @Title:
     * @Description: 批量保存收车机构维护
     * @param carCollectComps
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int insertDataList(List<CarCollectComp> carCollectComps){
        return super.insertListByJdbcTemplate(carCollectComps);
    }

    /**
     * @Title:
     * @Description: 修改收车机构维护
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int updateByPrimaryKeyData(CarCollectComp carCollectComp) {
        return super.updateByPrimaryKey(carCollectComp);
    }

    /**
     * @Title:
     * @Description: 批量修改收车机构维护
     * @param carCollectComps
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CarCollectComp> carCollectComps){
        return super.updateListByPrimaryKey(carCollectComps);
    }

    /**
     * @Title:
     * @Description: 动态修改收车机构维护
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CarCollectComp carCollectComp) {
        return super.updateByPrimaryKeySelective(carCollectComp);
    }

    /**
     * @Title:
     * @Description: 批量动态修改收车机构维护
     * @param carCollectComps
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public int updateByPrimaryKeySelectiveDataList(List<CarCollectComp> carCollectComps) {
        return super.updateListByPrimaryKeySelective(carCollectComps);
    }

    /**
     * @Title:
     * @Description: 根据条件修改收车机构维护
     * @param carCollectComp
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int updateByExampleData(CarCollectComp carCollectComp, Example example) {
        return super.updateByExample(carCollectComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改收车机构维护
     * @param carCollectComp
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int updateByExampleSelectiveData(CarCollectComp carCollectComp, Example example){
        return super.updateByExampleSelective(carCollectComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据carCollectCompId删除收车机构维护
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public int deleteData(CarCollectComp carCollectComp) {
        return super.delete(carCollectComp);
    }

    /**
     * @Title:
     * @Description: 根据carCollectCompId集合批量删除收车机构维护
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public int deleteDataList(List carCollectCompIds,CarCollectComp carCollectComp){
        return super.deleteByIds(carCollectCompIds,carCollectComp);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除收车机构维护
     * @param example
     * @param carCollectComp
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public int deleteExampleData(Example example,CarCollectComp carCollectComp){
        return super.deleteByExample(example,carCollectComp);
    }

    /**
     * @Title:
     * @Description: 查询全部收车机构维护
     * @return List<CarCollectComp>
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public List<CarCollectComp> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个收车机构维护
     * @param example
     * @return CarCollectComp
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public CarCollectComp selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询收车机构维护
     * @param example
     * @return List<CarCollectComp>
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public List<CarCollectComp> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过carCollectCompId查询收车机构维护
     * @param carCollectCompId
     * @return CarCollectComp
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public CarCollectComp selectByPrimaryKey(Object carCollectCompId) {
        return super.selectByPrimaryKey(carCollectCompId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询收车机构维护
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CarCollectComp>
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Override
    public PageInfoExtend<CarCollectComp> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询收车机构维护vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
