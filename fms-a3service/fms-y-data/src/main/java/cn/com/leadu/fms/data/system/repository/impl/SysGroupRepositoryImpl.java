package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysGroupDao;
import cn.com.leadu.fms.data.system.repository.SysGroupRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupDetailVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupRepositoryImpl
 * @Description: 用户组管理Repository 实现层
 * @date 2018-03-10
 */
@Repository
public class SysGroupRepositoryImpl extends AbstractBaseRepository<SysGroupDao, SysGroup> implements SysGroupRepository {

    /**
     * @Title:
     * @Description: 新增用户组管理
     * @param sysGroup
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int insertData(SysGroup sysGroup) {
        return super.insert(sysGroup);
    }

    /**
     * @Title:
     * @Description: 批量保存用户组管理
     * @param sysGroups
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int insertDataList(List<SysGroup> sysGroups){
        return super.insertListByJdbcTemplate(sysGroups);
    }

    /**
     * @Title:
     * @Description: 修改用户组管理
     * @param sysGroup
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int updateByPrimaryKeyData(SysGroup sysGroup) {
        return super.updateByPrimaryKey(sysGroup);
    }

    /**
     * @Title:
     * @Description: 批量修改用户组管理
     * @param sysGroups
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysGroup> sysGroups){
        return super.insertListByJdbcTemplate(sysGroups);
    }

    /**
     * @Title:
     * @Description: 动态修改用户组管理
     * @param sysGroup
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysGroup sysGroup) {
        return super.updateByPrimaryKeySelective(sysGroup);
    }

    /**
     * @Title:
     * @Description: 批量动态修改用户组管理
     * @param sysGroups
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysGroup> sysGroups) {
        return super.updateListByPrimaryKeySelective(sysGroups);
    }

    /**
     * @Title:
     * @Description: 根据条件修改用户组管理
     * @param sysGroup
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int updateByExampleData(SysGroup sysGroup, Example example) {
        return super.updateByExample(sysGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改用户组管理
     * @param sysGroup
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int updateByExampleSelectiveData(SysGroup sysGroup, Example example){
        return super.updateByExampleSelective(sysGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据groupId删除用户组管理
     * @param sysGroup
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public int deleteData(SysGroup sysGroup) {
        return super.delete(sysGroup);
    }

    /**
     * @Title:
     * @Description: 根据groupId集合批量删除用户组管理
     * @param sysGroup
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    public int deleteDataList(List groupIds,SysGroup sysGroup){
        return super.deleteByIds(groupIds,sysGroup);
    }

    /**
     * @Title:
     * @Description: 查询全部用户组管理
     * @return List<SysGroup>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public List<SysGroup> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个用户组管理
     * @param example
     * @return SysGroup
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public SysGroup selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询用户组管理
     * @param example
     * @return List<SysGroup>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public List<SysGroup> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过groupId查询用户组管理
     * @param groupId
     * @return SysGroup
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public SysGroup selectByPrimaryKey(Object groupId) {
        return super.selectByPrimaryKey(groupId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询用户组管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysGroup>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public PageInfoExtend<SysGroup> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysGroupVo>
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public PageInfoExtend<SysGroupVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据用户ID,获取有下级用户组的用户组信息的总件数
     * @param groupIds 查询参数
     * @return long
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public Long selectParentGroupCountByGroupIds(List<String> groupIds) {
        return baseDao.selectParentGroupCountByGroupIds(groupIds);
    }

    /**
     * @Title:
     * @Description: 根据用户组代码,获取上级用户组信息
     * @param groupCode 用户组代码
     * @return long
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @Override
    public List<SysGroupParentVo> selectParentGroupsByGroup(String groupCode) {
        return baseDao.selectParentGroupsByGroup(groupCode);
    }

    /**
     * @Title:
     * @Description: 根据组织类型，取得用户组信息树
     * @param parentType 组织类型
     * @return long
     * @throws
     * @author wangxue
     * @date 2018-3-13 17:39:58
     */
    @Override
    public List<SysGroupVo> selectSysGroupVosByTree(String parentType) {
        return baseDao.selectSysGroupVosByTree(parentType);
    }

    /**
     * @Title:
     * @Description: 根据用户组ID，取得用户组信息
     * @param groupId 用户组Id
     * @return SysGroupVo
     * @throws
     * @author wangxue
     * @date 2018-3-14 14:39:58
     */
    @Override
    public SysGroupDetailVo selectSysGroupVoByGroupId(String groupId) {
        return baseDao.selectSysGroupVoByGroupId(groupId);
    }

    /**
     * @Title:
     * @Description: 根据用户组ID，取得用户组信息
     * @param example 用户组Id
     * @return SysGroupVo
     * @throws
     * @author wangxue
     * @date 2018-3-14 14:39:58
     */
    @Override
    public SysGroup selectSysGroupVoByGroupCode(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据用户组ID，取得用户组信息
     * @param groupIds 用户组Id
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-20 14:39:58
     */
    @Override
    public List<String> selectParentIdsByGroupIds(List<String> groupIds) {
        return null;
    }
}
