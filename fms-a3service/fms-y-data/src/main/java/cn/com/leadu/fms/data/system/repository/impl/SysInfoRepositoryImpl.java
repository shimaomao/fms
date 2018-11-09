package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysInfoDao;
import cn.com.leadu.fms.data.system.repository.SysInfoRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoRepositoryImpl
 * @Description: 消息管理Repository 实现层
 * @date 2018-04-25
 */
@Repository
public class SysInfoRepositoryImpl extends AbstractBaseRepository<SysInfoDao, SysInfo> implements SysInfoRepository {

    /**
     * @Title:
     * @Description: 新增消息管理
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int insertData(SysInfo sysInfo) {
        return super.insert(sysInfo);
    }

    /**
     * @Title:
     * @Description: 批量保存消息管理
     * @param sysInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int insertDataList(List<SysInfo> sysInfos){
        return super.insertListByJdbcTemplate(sysInfos);
    }

    /**
     * @Title:
     * @Description: 修改消息管理
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int updateByPrimaryKeyData(SysInfo sysInfo) {
        return super.updateByPrimaryKey(sysInfo);
    }

    /**
     * @Title:
     * @Description: 批量修改消息管理
     * @param sysInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysInfo> sysInfos){
        return super.insertListByJdbcTemplate(sysInfos);
    }

    /**
     * @Title:
     * @Description: 动态修改消息管理
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysInfo sysInfo) {
        return super.updateByPrimaryKeySelective(sysInfo);
    }

    /**
     * @Title:
     * @Description: 批量动态修改消息管理
     * @param sysInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysInfo> sysInfos) {
        return super.updateListByPrimaryKeySelective(sysInfos);
    }

    /**
     * @Title:
     * @Description: 根据条件修改消息管理
     * @param sysInfo
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int updateByExampleData(SysInfo sysInfo, Example example) {
        return super.updateByExample(sysInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改消息管理
     * @param sysInfo
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int updateByExampleSelectiveData(SysInfo sysInfo, Example example){
        return super.updateByExampleSelective(sysInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据infoId删除消息管理
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public int deleteData(SysInfo sysInfo) {
        return super.delete(sysInfo);
    }

    /**
     * @Title:
     * @Description: 根据infoId集合批量删除消息管理
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public int deleteDataList(List infoIds,SysInfo sysInfo){
        return super.deleteByIds(infoIds,sysInfo);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除消息管理
     * @param example
     * @param sysInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public int deleteExampleData(Example example,SysInfo sysInfo){
        return super.deleteByExample(example,sysInfo);
    }

    /**
     * @Title:
     * @Description: 查询全部消息管理
     * @return List<SysInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public List<SysInfo> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个消息管理
     * @param example
     * @return SysInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public SysInfo selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询消息管理
     * @param example
     * @return List<SysInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public List<SysInfo> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过infoId查询消息管理
     * @param infoId
     * @return SysInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public SysInfo selectByPrimaryKey(Object infoId) {
        return super.selectByPrimaryKey(infoId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询消息管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @Override
    public PageInfoExtend<SysInfo> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询消息管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
