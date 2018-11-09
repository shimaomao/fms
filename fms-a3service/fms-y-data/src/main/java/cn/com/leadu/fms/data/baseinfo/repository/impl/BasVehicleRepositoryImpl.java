package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.dao.BasVehicleDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasVehicleRepositoryImpl
 * @Description: 车辆信息维护Repository 实现层
 * @date 2018-03-20
 */
@Repository
public class BasVehicleRepositoryImpl extends AbstractBaseRepository<BasVehicleDao, BasVehicle> implements BasVehicleRepository {

    /**
     * @Title:
     * @Description: 新增车辆信息维护
     * @param basVehicle
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int insertData(BasVehicle basVehicle) {
        return super.insert(basVehicle);
    }

    /**
     * @Title:
     * @Description: 批量保存车辆信息维护
     * @param basVehicles
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int insertDataList(List<BasVehicle> basVehicles){
        return super.insertListByJdbcTemplate(basVehicles);
    }

    /**
     * @Title:
     * @Description: 修改车辆信息维护
     * @param basVehicle
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int updateByPrimaryKeyData(BasVehicle basVehicle) {
        return super.updateByPrimaryKey(basVehicle);
    }

    /**
     * @Title:
     * @Description: 批量修改车辆信息维护
     * @param basVehicles
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasVehicle> basVehicles){
        return super.updateListByPrimaryKey(basVehicles);
    }

    /**
     * @Title:
     * @Description: 动态修改车辆信息维护
     * @param basVehicle
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasVehicle basVehicle) {
        return super.updateByPrimaryKeySelective(basVehicle);
    }

    /**
     * @Title:
     * @Description: 批量动态修改车辆信息维护
     * @param basVehicles
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasVehicle> basVehicles) {
        return super.updateListByPrimaryKeySelective(basVehicles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改车辆信息维护
     * @param basVehicle
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int updateByExampleData(BasVehicle basVehicle, Example example) {
        return super.updateByExample(basVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改车辆信息维护
     * @param basVehicle
     * @param example
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int updateByExampleSelectiveData(BasVehicle basVehicle, Example example){
        return super.updateByExampleSelective(basVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据vehicleId删除车辆信息维护
     * @param basVehicle
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public int deleteData(BasVehicle basVehicle) {
        return super.delete(basVehicle);
    }

    /**
     * @Title:
     * @Description: 根据vehicleId集合批量删除车辆信息维护
     * @param basVehicle
     * @return int
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    public int deleteDataList(List vehicleIds,BasVehicle basVehicle){
        return super.deleteByIds(vehicleIds,basVehicle);
    }

    /**
     * @Title:
     * @Description: 查询全部车辆信息维护
     * @return List<BasVehicle>
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public List<BasVehicle> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个车辆信息维护
     * @param example
     * @return BasVehicle
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public BasVehicle selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询车辆信息维护
     * @param example
     * @return List<BasVehicle>
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public List<BasVehicle> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过vehicleId查询车辆信息维护
     * @param vehicleId
     * @return BasVehicle
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public BasVehicle selectByPrimaryKey(Object vehicleId) {
        return super.selectByPrimaryKey(vehicleId);
    }

    /**
     * @Title:
     * @Description: 通过vehicleId查询车辆信息维护
     * @param vehicleId
     * @return BasVehicle
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public BasVehicleVo findBasVehicleByVehicleId(String vehicleId) {
        return baseDao.findBasVehicleByVehicleId(vehicleId);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasVehicle>
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    @Override
    public PageInfoExtend<BasVehicle> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasVehicle>
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:19
     */
    public PageInfoExtend<BasVehicleVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public BasVehicleVo selectBasVehicleVoByVehicleCode(String vehicleCode) {
        return baseDao.selectBasVehicleVoByVehicleCode(vehicleCode);
    }

    /**
     * @Title:
     * @Description: 根据车型代码取得车型名称,并封装合同号与车型名称的对应关系,为了后续更新合同任务信息车型信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public String findVehicleNameForContConfirm(String vehicleCode) {
        return baseDao.findVehicleNameForContConfirm(vehicleCode);
    }

}
