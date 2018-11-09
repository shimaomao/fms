package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ApplyVehicleDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyVehicleRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleRepositoryImpl
 * @Description: 融资车辆信息Repository 实现层
 * @date 2018-03-24
 */
@Repository
public class ApplyVehicleRepositoryImpl extends AbstractBaseRepository<ApplyVehicleDao, ApplyVehicle> implements ApplyVehicleRepository {

    /**
     * @Title:
     * @Description: 新增融资车辆信息
     * @param applyVehicle
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int insertData(ApplyVehicle applyVehicle) {
        return super.insert(applyVehicle);
    }

    /**
     * @Title:
     * @Description: 批量保存融资车辆信息
     * @param applyVehicles
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int insertDataList(List<ApplyVehicle> applyVehicles){
        return super.insertListByJdbcTemplate(applyVehicles);
    }

    /**
     * @Title:
     * @Description: 修改融资车辆信息
     * @param applyVehicle
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int updateByPrimaryKeyData(ApplyVehicle applyVehicle) {
        return super.updateByPrimaryKey(applyVehicle);
    }

    /**
     * @Title:
     * @Description: 批量修改融资车辆信息
     * @param applyVehicles
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyVehicle> applyVehicles){
        return super.insertListByJdbcTemplate(applyVehicles);
    }

    /**
     * @Title:
     * @Description: 动态修改融资车辆信息
     * @param applyVehicle
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyVehicle applyVehicle) {
        return super.updateByPrimaryKeySelective(applyVehicle);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资车辆信息
     * @param applyVehicles
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    public int updateByPrimaryKeySelectiveDataList(List<ApplyVehicle> applyVehicles) {
        return super.updateListByPrimaryKeySelective(applyVehicles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资车辆信息
     * @param applyVehicle
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int updateByExampleData(ApplyVehicle applyVehicle, Example example) {
        return super.updateByExample(applyVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资车辆信息
     * @param applyVehicle
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int updateByExampleSelectiveData(ApplyVehicle applyVehicle, Example example){
        return super.updateByExampleSelective(applyVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据applyVehicleId删除融资车辆信息
     * @param applyVehicle
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public int deleteData(ApplyVehicle applyVehicle) {
        return super.delete(applyVehicle);
    }

    /**
     * @Title:
     * @Description: 根据applyVehicleId集合批量删除融资车辆信息
     * @param applyVehicle
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    public int deleteDataList(List applyVehicleIds,ApplyVehicle applyVehicle){
        return super.deleteByIds(applyVehicleIds,applyVehicle);
    }

    /**
     * @Title:
     * @Description: 查询全部融资车辆信息
     * @return List<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public List<ApplyVehicle> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资车辆信息
     * @param example
     * @return ApplyVehicle
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public ApplyVehicle selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资车辆信息
     * @param example
     * @return List<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public List<ApplyVehicle> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyVehicleId查询融资车辆信息
     * @param applyVehicleId
     * @return ApplyVehicle
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public ApplyVehicle selectByPrimaryKey(Object applyVehicleId) {
        return super.selectByPrimaryKey(applyVehicleId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资车辆信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    @Override
    public PageInfoExtend<ApplyVehicle> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资车辆信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:31
     */
    public PageInfoExtend<ApplyVehicle> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资车辆信息
     * @param applyNo 订单编号
     * @return List<ApplyVehicleVo>
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    @Override
    public List<ApplyVehicleVo> selectApplyVehicleVoByApplyNo(String applyNo) {
        return baseDao.selectApplyVehicleVoByApplyNo(applyNo);
    }
}
