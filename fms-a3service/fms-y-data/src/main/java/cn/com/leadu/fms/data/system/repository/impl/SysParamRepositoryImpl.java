package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.common.vo.CommonParamVo;
import cn.com.leadu.fms.data.system.dao.SysParamDao;
import cn.com.leadu.fms.data.system.repository.SysParamRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: SysParamRepositoryImpl
 * @Description: 系统常量表Repository 实现层
 * @date 2018-03-09
 */
@Repository
public class SysParamRepositoryImpl extends AbstractBaseRepository<SysParamDao, SysParam> implements SysParamRepository {

    /**
     * @Title:
     * @Description: 新增系统常量表
     * @param sysParam
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int insertData(SysParam sysParam) {
        return super.insert(sysParam);
    }

    /**
     * @Title:
     * @Description: 批量保存系统常量表
     * @param sysParams
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int insertDataList(List<SysParam> sysParams){
        return super.insertListByJdbcTemplate(sysParams);
    }

    /**
     * @Title:
     * @Description: 修改系统常量表
     * @param sysParam
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int updateByPrimaryKeyData(SysParam sysParam) {
        return super.updateByPrimaryKey(sysParam);
    }

    /**
     * @Title:
     * @Description: 批量修改系统常量表
     * @param sysParams
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysParam> sysParams){
        return super.insertListByJdbcTemplate(sysParams);
    }

    /**
     * @Title:
     * @Description: 动态修改系统常量表
     * @param sysParam
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysParam sysParam) {
        return super.updateByPrimaryKeySelective(sysParam);
    }

    /**
     * @Title:
     * @Description: 批量动态修改系统常量表
     * @param sysParams
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysParam> sysParams) {
        return super.updateListByPrimaryKeySelective(sysParams);
    }

    /**
     * @Title:
     * @Description: 根据条件修改系统常量表
     * @param sysParam
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int updateByExampleData(SysParam sysParam, Example example) {
        return super.updateByExample(sysParam,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改系统常量表
     * @param sysParam
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int updateByExampleSelectiveData(SysParam sysParam, Example example){
        return super.updateByExampleSelective(sysParam,example);
    }
    
    /**
     * @Title:
     * @Description: 根据paramKeyId删除系统常量表
     * @param sysParam
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public int deleteData(SysParam sysParam) {
        return super.delete(sysParam);
    }

    /**
     * @Title:
     * @Description: 根据paramKeyId集合批量删除系统常量表
     * @param sysParam
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public int deleteDataList(List paramKeyIds,SysParam sysParam){
        return super.deleteByIds(paramKeyIds,sysParam);
    }

    /**
     * @Title:
     * @Description: 查询全部系统常量表
     * @return List<SysParam>
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public List<SysParam> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个系统常量表
     * @param example
     * @return SysParam
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public SysParam selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询系统常量表
     * @param example
     * @return List<SysParam>
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public List<SysParam> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过paramKeyId查询系统常量表
     * @param paramKeyId
     * @return SysParam
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public SysParam selectByPrimaryKey(Object paramKeyId) {
        return super.selectByPrimaryKey(paramKeyId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询系统常量表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysParam>
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @Override
    public PageInfoExtend<SysParam> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询系统常量表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysParam>
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public PageInfoExtend<SysParam> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description:   查询所有系统常量,用于前后台系统常量取得
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/19 09:07:08
     */
    public List<CommonParamVo> selectSysParams(){
        return baseDao.selectSysParams();
    }

}
