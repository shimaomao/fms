package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysUserInfoDao;
import cn.com.leadu.fms.data.system.repository.SysUserInfoRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysUserInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysUserInfoRepositoryImpl
 * @Description: 消息用户操作管理Repository 实现层
 * @date 2018-04-25
 */
@Repository
public class SysUserInfoRepositoryImpl extends AbstractBaseRepository<SysUserInfoDao, SysUserInfo> implements SysUserInfoRepository {

    /**
     * @Title:
     * @Description: 新增消息用户操作管理
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int insertData(SysUserInfo sysUserInfo) {
        return super.insert(sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 批量保存消息用户操作管理
     * @param sysUserInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int insertDataList(List<SysUserInfo> sysUserInfos){
        return super.insertListByJdbcTemplate(sysUserInfos);
    }

    /**
     * @Title:
     * @Description: 修改消息用户操作管理
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int updateByPrimaryKeyData(SysUserInfo sysUserInfo) {
        return super.updateByPrimaryKey(sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 批量修改消息用户操作管理
     * @param sysUserInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysUserInfo> sysUserInfos){
        return super.updateListByPrimaryKey(sysUserInfos);
    }

    /**
     * @Title:
     * @Description: 动态修改消息用户操作管理
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysUserInfo sysUserInfo) {
        return super.updateByPrimaryKeySelective(sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 批量动态修改消息用户操作管理
     * @param sysUserInfos
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysUserInfo> sysUserInfos) {
        return super.updateListByPrimaryKeySelective(sysUserInfos);
    }

    /**
     * @Title:
     * @Description: 根据条件修改消息用户操作管理
     * @param sysUserInfo
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int updateByExampleData(SysUserInfo sysUserInfo, Example example) {
        return super.updateByExample(sysUserInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改消息用户操作管理
     * @param sysUserInfo
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int updateByExampleSelectiveData(SysUserInfo sysUserInfo, Example example){
        return super.updateByExampleSelective(sysUserInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据userInfoId删除消息用户操作管理
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public int deleteData(SysUserInfo sysUserInfo) {
        return super.delete(sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 根据userInfoId集合批量删除消息用户操作管理
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public int deleteDataList(List userInfoIds,SysUserInfo sysUserInfo){
        return super.deleteByIds(userInfoIds,sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除消息用户操作管理
     * @param example
     * @param sysUserInfo
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public int deleteExampleData(Example example,SysUserInfo sysUserInfo){
        return super.deleteByExample(example,sysUserInfo);
    }

    /**
     * @Title:
     * @Description: 查询全部消息用户操作管理
     * @return List<SysUserInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public List<SysUserInfo> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个消息用户操作管理
     * @param example
     * @return SysUserInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public SysUserInfo selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询消息用户操作管理
     * @param example
     * @return List<SysUserInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public List<SysUserInfo> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过userInfoId查询消息用户操作管理
     * @param userInfoId
     * @return SysUserInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public SysUserInfo selectByPrimaryKey(Object userInfoId) {
        return super.selectByPrimaryKey(userInfoId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysUserInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    @Override
    public PageInfoExtend<SysUserInfo> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询消息用户操作管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:12:34
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
