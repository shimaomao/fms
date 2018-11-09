package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContractVehicleDao;
import cn.com.leadu.fms.data.prebiz.repository.ContractVehicleRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVehicleRepositoryImpl
 * @Description: 合同融资车辆信息Repository 实现层
 * @date 2018-03-23
 */
@Repository
public class ContractVehicleRepositoryImpl extends AbstractBaseRepository<ContractVehicleDao, ContractVehicle> implements ContractVehicleRepository {

    /**
     * @Title:
     * @Description: 新增合同融资车辆信息
     * @param contractVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int insertData(ContractVehicle contractVehicle) {
        return super.insert(contractVehicle);
    }

    /**
     * @Title:
     * @Description: 批量保存合同融资车辆信息
     * @param contractVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int insertDataList(List<ContractVehicle> contractVehicles){
        return super.insertListByJdbcTemplate(contractVehicles);
    }

    /**
     * @Title:
     * @Description: 修改合同融资车辆信息
     * @param contractVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int updateByPrimaryKeyData(ContractVehicle contractVehicle) {
        return super.updateByPrimaryKey(contractVehicle);
    }

    /**
     * @Title:
     * @Description: 批量修改合同融资车辆信息
     * @param contractVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContractVehicle> contractVehicles){
        return super.insertListByJdbcTemplate(contractVehicles);
    }

    /**
     * @Title:
     * @Description: 动态修改合同融资车辆信息
     * @param contractVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContractVehicle contractVehicle) {
        return super.updateByPrimaryKeySelective(contractVehicle);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同融资车辆信息
     * @param contractVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContractVehicle> contractVehicles) {
        return super.updateListByPrimaryKeySelective(contractVehicles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同融资车辆信息
     * @param contractVehicle
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int updateByExampleData(ContractVehicle contractVehicle, Example example) {
        return super.updateByExample(contractVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改合同融资车辆信息
     * @param contractVehicle
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int updateByExampleSelectiveData(ContractVehicle contractVehicle, Example example){
        return super.updateByExampleSelective(contractVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contVehicleId删除合同融资车辆信息
     * @param contractVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public int deleteData(ContractVehicle contractVehicle) {
        return super.delete(contractVehicle);
    }

    /**
     * @Title:
     * @Description: 根据contVehicleId集合批量删除合同融资车辆信息
     * @param contractVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public int deleteDataList(List contVehicleIds,ContractVehicle contractVehicle){
        return super.deleteByIds(contVehicleIds,contractVehicle);
    }

    /**
     * @Title:
     * @Description: 查询全部合同融资车辆信息
     * @return List<ContractVehicle>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public List<ContractVehicle> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个合同融资车辆信息
     * @param example
     * @return ContractVehicle
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public ContractVehicle selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询合同融资车辆信息
     * @param example
     * @return List<ContractVehicle>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public List<ContractVehicle> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contVehicleId查询合同融资车辆信息
     * @param contVehicleId
     * @return ContractVehicle
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public ContractVehicle selectByPrimaryKey(Object contVehicleId) {
        return super.selectByPrimaryKey(contVehicleId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询合同融资车辆信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContractVehicle>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    @Override
    public PageInfoExtend<ContractVehicle> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同融资车辆信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContractVehicle>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public PageInfoExtend<ContractVehicle> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public ContractVehicleVo selectContractVehicleVoByContNo(String contNo) {
        return baseDao.selectContractVehicleVoByContNo(contNo);
    }

    /**
     * @param contractVehicleFinanceVo
     * @Description: 查询合同车辆信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/21 16:49
     */
    @Override
    public ContractVehicleFinanceVo selectContractVehicleFinanceVoByContNo(ContractVehicleFinanceVo contractVehicleFinanceVo) {
        return baseDao.selectContractVehicleFinanceVoByContNo(contractVehicleFinanceVo);
    }

}
