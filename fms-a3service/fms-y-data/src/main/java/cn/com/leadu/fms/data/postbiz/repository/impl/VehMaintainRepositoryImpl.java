package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.VehMaintainDao;
import cn.com.leadu.fms.data.postbiz.repository.VehMaintainRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainRepositoryImpl
 * @Description: 车辆维修记录Repository 实现层
 */
@Repository
public class VehMaintainRepositoryImpl extends AbstractBaseRepository<VehMaintainDao, VehMaintain> implements VehMaintainRepository {

    /**
     * @Title:
     * @Description: 新增车辆维修记录
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int insertData(VehMaintain vehMaintain) {
        return super.insert(vehMaintain);
    }

    /**
     * @Title:
     * @Description: 批量保存车辆维修记录
     * @param vehMaintains
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int insertDataList(List<VehMaintain> vehMaintains){
        return super.insertListByJdbcTemplate(vehMaintains);
    }

    /**
     * @Title:
     * @Description: 修改车辆维修记录
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeyData(VehMaintain vehMaintain) {
        return super.updateByPrimaryKey(vehMaintain);
    }

    /**
     * @Title:
     * @Description: 批量修改车辆维修记录
     * @param vehMaintains
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeyDataList(List<VehMaintain> vehMaintains){
        return super.updateListByPrimaryKey(vehMaintains);
    }

    /**
     * @Title:
     * @Description: 动态修改车辆维修记录
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeySelectiveData(VehMaintain vehMaintain) {
        return super.updateByPrimaryKeySelective(vehMaintain);
    }

    /**
     * @Title:
     * @Description: 批量动态修改车辆维修记录
     * @param vehMaintains
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<VehMaintain> vehMaintains) {
        return super.updateListByPrimaryKeySelective(vehMaintains);
    }

    /**
     * @Title:
     * @Description: 根据条件修改车辆维修记录
     * @param vehMaintain
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByExampleData(VehMaintain vehMaintain, Example example) {
        return super.updateByExample(vehMaintain,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改车辆维修记录
     * @param vehMaintain
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByExampleSelectiveData(VehMaintain vehMaintain, Example example){
        return super.updateByExampleSelective(vehMaintain,example);
    }
    
    /**
     * @Title:
     * @Description: 根据vehMaintainId删除车辆维修记录
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int deleteData(VehMaintain vehMaintain) {
        return super.delete(vehMaintain);
    }

    /**
     * @Title:
     * @Description: 根据vehMaintainId集合批量删除车辆维修记录
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int deleteDataList(List vehMaintainIds,VehMaintain vehMaintain){
        return super.deleteByIds(vehMaintainIds,vehMaintain);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除车辆维修记录
     * @param example
     * @param vehMaintain
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int deleteExampleData(Example example,VehMaintain vehMaintain){
        return super.deleteByExample(example,vehMaintain);
    }

    /**
     * @Title:
     * @Description: 查询全部车辆维修记录
     * @return List<VehMaintain>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public List<VehMaintain> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个车辆维修记录
     * @param example
     * @return VehMaintain
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public VehMaintain selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询车辆维修记录
     * @param example
     * @return List<VehMaintain>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public List<VehMaintain> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过vehMaintainId查询车辆维修记录
     * @param vehMaintainId
     * @return VehMaintain
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public VehMaintain selectByPrimaryKey(Object vehMaintainId) {
        return super.selectByPrimaryKey(vehMaintainId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询车辆维修记录
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<VehMaintain>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public PageInfoExtend<VehMaintain> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆维修记录vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改车辆维修记录
     * @param vehMaintain,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeyData(VehMaintain vehMaintain,boolean exclusive) {
        return super.updateByPrimaryKey(vehMaintain,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改车辆维修记录,并进行排他
     * @param vehMaintains
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeyDataList(List<VehMaintain> vehMaintains,boolean exclusive){
        return super.updateListByPrimaryKey(vehMaintains,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改车辆维修记录,并进行排他
     * @param vehMaintain
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(VehMaintain vehMaintain,boolean exclusive) {
        return super.updateByPrimaryKeySelective(vehMaintain,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改车辆维修记录,并进行排他
     * @param vehMaintains
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<VehMaintain> vehMaintains,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(vehMaintains,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改车辆维修记录,并进行排他
     * @param vehMaintain
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByExampleData(VehMaintain vehMaintain, Example example,boolean exclusive) {
        return super.updateByExample(vehMaintain,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改车辆维修记录,并进行排他
     * @param vehMaintain
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public int updateByExampleSelectiveData(VehMaintain vehMaintain, Example example,boolean exclusive){
        return super.updateByExampleSelective(vehMaintain,example,exclusive);
    }


    /**
     * @Title:
     * @Description: 根据Id查询车辆详情的Vo
     * @param vehMaintainId
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @Override
    public VehMaintainVo selectVehMaintainVoByVehMaintainId(String vehMaintainId){
        return baseDao.selectVehMaintainVoByVehMaintainId(vehMaintainId);
    }

}
