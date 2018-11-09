package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysWidgetAttributeDao;
import cn.com.leadu.fms.data.system.repository.SysWidgetAttributeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeRepositoryImpl
 * @Description: 项目权限管理Repository 实现层
 * @date 2018-03-09
 */
@Repository
public class SysWidgetAttributeRepositoryImpl extends AbstractBaseRepository<SysWidgetAttributeDao, SysWidgetAttribute> implements SysWidgetAttributeRepository {

    /**
     * @Title:
     * @Description: 新增项目权限管理
     * @param sysWidgetAttribute
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int insertData(SysWidgetAttribute sysWidgetAttribute) {
        return super.insert(sysWidgetAttribute);
    }

    /**
     * @Title:
     * @Description: 批量保存项目权限管理
     * @param sysWidgetAttributes
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int insertDataList(List<SysWidgetAttribute> sysWidgetAttributes){
        return super.insertListByJdbcTemplate(sysWidgetAttributes);
    }

    /**
     * @Title:
     * @Description: 修改项目权限管理
     * @param sysWidgetAttribute
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int updateByPrimaryKeyData(SysWidgetAttribute sysWidgetAttribute) {
        return super.updateByPrimaryKey(sysWidgetAttribute);
    }

    /**
     * @Title:
     * @Description: 批量修改项目权限管理
     * @param sysWidgetAttributes
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysWidgetAttribute> sysWidgetAttributes){
        return super.updateListByPrimaryKey(sysWidgetAttributes);
    }

    /**
     * @Title:
     * @Description: 动态修改项目权限管理
     * @param sysWidgetAttribute
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysWidgetAttribute sysWidgetAttribute) {
        return super.updateByPrimaryKeySelective(sysWidgetAttribute);
    }

    /**
     * @Title:
     * @Description: 批量动态修改项目权限管理
     * @param sysWidgetAttributes
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysWidgetAttribute> sysWidgetAttributes) {
        return super.updateListByPrimaryKeySelective(sysWidgetAttributes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改项目权限管理
     * @param sysWidgetAttribute
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int updateByExampleData(SysWidgetAttribute sysWidgetAttribute, Example example) {
        return super.updateByExample(sysWidgetAttribute,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改项目权限管理
     * @param sysWidgetAttribute
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int updateByExampleSelectiveData(SysWidgetAttribute sysWidgetAttribute, Example example){
        return super.updateByExampleSelective(sysWidgetAttribute,example);
    }
    
    /**
     * @Title:
     * @Description: 根据widgetConId删除项目权限管理
     * @param sysWidgetAttribute
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public int deleteData(SysWidgetAttribute sysWidgetAttribute) {
        return super.delete(sysWidgetAttribute);
    }

    /**
     * @Title:
     * @Description: 根据widgetConId集合批量删除项目权限管理
     * @param sysWidgetAttribute
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public int deleteDataList(List widgetConIds,SysWidgetAttribute sysWidgetAttribute){
        return super.deleteByIds(widgetConIds,sysWidgetAttribute);
    }

    /**
     * @Title:
     * @Description: 查询全部项目权限管理
     * @return List<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public List<SysWidgetAttribute> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个项目权限管理
     * @param example
     * @return SysWidgetAttribute
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public SysWidgetAttribute selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询项目权限管理
     * @param example
     * @return List<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public List<SysWidgetAttribute> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过widgetConId查询项目权限管理
     * @param widgetConId
     * @return SysWidgetAttribute
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public SysWidgetAttribute selectByPrimaryKey(Object widgetConId) {
        return super.selectByPrimaryKey(widgetConId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询项目权限管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    @Override
    public PageInfoExtend<SysWidgetAttribute> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询项目权限管理vo
     * @param methodName
     * @param sysWidgetAttributeVo
     * @param pageQuery
     * @return PageInfoExtend<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public PageInfoExtend<SysWidgetAttributeVo> selectListVoByPage(String methodName,SysWidgetAttributeVo sysWidgetAttributeVo,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,sysWidgetAttributeVo,pageQuery);
    }

}
