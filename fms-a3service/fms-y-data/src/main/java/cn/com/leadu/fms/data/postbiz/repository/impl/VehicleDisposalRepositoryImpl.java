package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.postbiz.dao.VehicleDisposalDao;
import cn.com.leadu.fms.data.postbiz.repository.VehicleDisposalRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.SecCarInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.DisposalContVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalRepositoryImpl
 * @Description: 车辆处置Repository 实现层
 */
@Repository
public class VehicleDisposalRepositoryImpl extends AbstractBaseRepository<VehicleDisposalDao, VehicleDisposal> implements VehicleDisposalRepository {

    /**
     * @Title:
     * @Description: 新增车辆处置
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int insertData(VehicleDisposal vehicleDisposal) {
        return super.insert(vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 批量保存车辆处置
     * @param vehicleDisposals
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int insertDataList(List<VehicleDisposal> vehicleDisposals){
        return super.insertListByJdbcTemplate(vehicleDisposals);
    }

    /**
     * @Title:
     * @Description: 修改车辆处置
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeyData(VehicleDisposal vehicleDisposal) {
        return super.updateByPrimaryKey(vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 批量修改车辆处置
     * @param vehicleDisposals
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeyDataList(List<VehicleDisposal> vehicleDisposals){
        return super.updateListByPrimaryKey(vehicleDisposals);
    }

    /**
     * @Title:
     * @Description: 动态修改车辆处置
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeySelectiveData(VehicleDisposal vehicleDisposal) {
        return super.updateByPrimaryKeySelective(vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 批量动态修改车辆处置
     * @param vehicleDisposals
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<VehicleDisposal> vehicleDisposals) {
        return super.updateListByPrimaryKeySelective(vehicleDisposals);
    }

    /**
     * @Title:
     * @Description: 根据条件修改车辆处置
     * @param vehicleDisposal
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByExampleData(VehicleDisposal vehicleDisposal, Example example) {
        return super.updateByExample(vehicleDisposal,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改车辆处置
     * @param vehicleDisposal
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByExampleSelectiveData(VehicleDisposal vehicleDisposal, Example example){
        return super.updateByExampleSelective(vehicleDisposal,example);
    }
    
    /**
     * @Title:
     * @Description: 根据vehicleDisposalId删除车辆处置
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int deleteData(VehicleDisposal vehicleDisposal) {
        return super.delete(vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 根据vehicleDisposalId集合批量删除车辆处置
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int deleteDataList(List vehicleDisposalIds,VehicleDisposal vehicleDisposal){
        return super.deleteByIds(vehicleDisposalIds,vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除车辆处置
     * @param example
     * @param vehicleDisposal
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int deleteExampleData(Example example,VehicleDisposal vehicleDisposal){
        return super.deleteByExample(example,vehicleDisposal);
    }

    /**
     * @Title:
     * @Description: 查询全部车辆处置
     * @return List<VehicleDisposal>
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public List<VehicleDisposal> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个车辆处置
     * @param example
     * @return VehicleDisposal
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public VehicleDisposal selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询车辆处置
     * @param example
     * @return List<VehicleDisposal>
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public List<VehicleDisposal> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过vehicleDisposalId查询车辆处置
     * @param vehicleDisposalId
     * @return VehicleDisposal
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public VehicleDisposal selectByPrimaryKey(Object vehicleDisposalId) {
        return super.selectByPrimaryKey(vehicleDisposalId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询车辆处置
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<VehicleDisposal>
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public PageInfoExtend<VehicleDisposal> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆处置vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改车辆处置
     * @param vehicleDisposal,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeyData(VehicleDisposal vehicleDisposal,boolean exclusive) {
        return super.updateByPrimaryKey(vehicleDisposal,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改车辆处置,并进行排他
     * @param vehicleDisposals
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeyDataList(List<VehicleDisposal> vehicleDisposals,boolean exclusive){
        return super.updateListByPrimaryKey(vehicleDisposals,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改车辆处置,并进行排他
     * @param vehicleDisposal
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(VehicleDisposal vehicleDisposal,boolean exclusive) {
        return super.updateByPrimaryKeySelective(vehicleDisposal,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改车辆处置,并进行排他
     * @param vehicleDisposals
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<VehicleDisposal> vehicleDisposals,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(vehicleDisposals,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改车辆处置,并进行排他
     * @param vehicleDisposal
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByExampleData(VehicleDisposal vehicleDisposal, Example example,boolean exclusive) {
        return super.updateByExample(vehicleDisposal,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改车辆处置,并进行排他
     * @param vehicleDisposal
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public int updateByExampleSelectiveData(VehicleDisposal vehicleDisposal, Example example,boolean exclusive){
        return super.updateByExampleSelective(vehicleDisposal,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据合同编号，获取合同客户信息
     * @param contNo 合同编号
     * @return DisposalContVo
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public DisposalContVo selectDisposalContVoByContNo(String contNo) {
        return baseDao.selectDisposalContVoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 根据合同编号处置状态，获取最新收车数据的收车费用
     * @param contNo 合同编号
     * @param vehicleDisposalStatus 车辆处置状态
     * @return BigDecimal
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @Override
    public BigDecimal selectRecoveryChargeByContNo(String contNo, String vehicleDisposalStatus) {
        return baseDao.selectRecoveryChargeByContNo(contNo, vehicleDisposalStatus);
    }

    /**
     * @Title:
     * @Description: 根据处置任务号，查询构建二手车库存表需要的数据源
     * @param taskNo 处置任务号
     * @return SecCarInfoVo
     * @throws
     * @author huzongcheng
     */
    @Override
    public SecCarInfoVo selectSecCarInfoByTaskNo(String taskNo) {
        return baseDao.selectSecCarInfoByTaskNo(taskNo);
    }
}
