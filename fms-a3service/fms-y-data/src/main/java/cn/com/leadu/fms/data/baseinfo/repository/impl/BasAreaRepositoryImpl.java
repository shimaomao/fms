package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.dao.BasAreaDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasAreaRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasAreaRepositoryImpl
 * @Description: 省市县信息维护Repository 实现层
 * @date 2018-03-15
 */
@Repository
public class BasAreaRepositoryImpl extends AbstractBaseRepository<BasAreaDao, BasArea> implements BasAreaRepository {

    /**
     * @Title:
     * @Description: 新增省市县信息维护
     * @param basArea
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int insertData(BasArea basArea) {
        return super.insert(basArea);
    }

    /**
     * @Title:
     * @Description: 批量保存省市县信息维护
     * @param basAreas
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int insertDataList(List<BasArea> basAreas){
        return super.insertListByJdbcTemplate(basAreas);
    }

    /**
     * @Title:
     * @Description: 修改省市县信息维护
     * @param basArea
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int updateByPrimaryKeyData(BasArea basArea) {
        return super.updateByPrimaryKey(basArea);
    }

    /**
     * @Title:
     * @Description: 批量修改省市县信息维护
     * @param basAreas
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasArea> basAreas){
        return super.updateListByPrimaryKey(basAreas);
    }

    /**
     * @Title:
     * @Description: 动态修改省市县信息维护
     * @param basArea
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasArea basArea) {
        return super.updateByPrimaryKeySelective(basArea);
    }

    /**
     * @Title:
     * @Description: 批量动态修改省市县信息维护
     * @param basAreas
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasArea> basAreas) {
        return super.updateListByPrimaryKeySelective(basAreas);
    }

    /**
     * @Title:
     * @Description: 根据条件修改省市县信息维护
     * @param basArea
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int updateByExampleData(BasArea basArea, Example example) {
        return super.updateByExample(basArea,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改省市县信息维护
     * @param basArea
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int updateByExampleSelectiveData(BasArea basArea, Example example){
        return super.updateByExampleSelective(basArea,example);
    }
    
    /**
     * @Title:
     * @Description: 根据areaId删除省市县信息维护
     * @param basArea
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public int deleteData(BasArea basArea) {
        return super.delete(basArea);
    }

    /**
     * @Title:
     * @Description: 根据areaId集合批量删除省市县信息维护
     * @param basArea
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    public int deleteDataList(List areaIds,BasArea basArea){
        return super.deleteByIds(areaIds,basArea);
    }

    /**
     * @Title:
     * @Description: 查询全部省市县信息维护
     * @return List<BasArea>
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public List<BasArea> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个省市县信息维护
     * @param example
     * @return BasArea
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public BasArea selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询省市县信息维护
     * @param example
     * @return List<BasArea>
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public List<BasArea> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过areaId查询省市县信息维护
     * @param areaId
     * @return BasArea
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public BasArea selectByPrimaryKey(Object areaId) {
        return super.selectByPrimaryKey(areaId);
    }

    /**
     * @Title:
     * @Description: 通过areaId查询省市县信息维护
     * @param areaId
     * @return BasArea
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public BasAreaVo selectBasAreaVosByAreaId(String areaId) {
        return baseDao.selectBasAreaVosByAreaId(areaId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询省市县信息维护
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasArea>
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    @Override
    public PageInfoExtend<BasArea> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询省市县信息维护vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasArea>
     * @throws
     * @author niehaibing
     * @date 2018-3-15 11:09:30
     */
    public PageInfoExtend<BasAreaVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public BasAreaVo selectBaseAreaVoById(Object id) {
       return baseDao.selectBaseAreaVoById(id);
    }

}
