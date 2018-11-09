package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysWidgetDao;
import cn.com.leadu.fms.data.system.repository.SysWidgetRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysWidget;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetRepositoryImpl
 * @Description: 画面控件管理Repository 实现层
 * @date 2018-03-09
 */
@Repository
public class SysWidgetRepositoryImpl extends AbstractBaseRepository<SysWidgetDao, SysWidget> implements SysWidgetRepository {

    /**
     * @Title:
     * @Description: 新增画面控件管理
     * @param sysWidget
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int insertData(SysWidget sysWidget) {
        return super.insert(sysWidget);
    }

    /**
     * @Title:
     * @Description: 批量保存画面控件管理
     * @param sysWidgets
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int insertDataList(List<SysWidget> sysWidgets){
        return super.insertListByJdbcTemplate(sysWidgets);
    }

    /**
     * @Title:
     * @Description: 修改画面控件管理
     * @param sysWidget
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int updateByPrimaryKeyData(SysWidget sysWidget) {
        return super.updateByPrimaryKey(sysWidget);
    }

    /**
     * @Title:
     * @Description: 批量修改画面控件管理
     * @param sysWidgets
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysWidget> sysWidgets){
        return super.insertListByJdbcTemplate(sysWidgets);
    }

    /**
     * @Title:
     * @Description: 动态修改画面控件管理
     * @param sysWidget
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysWidget sysWidget) {
        return super.updateByPrimaryKeySelective(sysWidget);
    }

    /**
     * @Title:
     * @Description: 批量动态修改画面控件管理
     * @param sysWidgets
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysWidget> sysWidgets) {
        return super.updateListByPrimaryKeySelective(sysWidgets);
    }

    /**
     * @Title:
     * @Description: 根据条件修改画面控件管理
     * @param sysWidget
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int updateByExampleData(SysWidget sysWidget, Example example) {
        return super.updateByExample(sysWidget,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改画面控件管理
     * @param sysWidget
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int updateByExampleSelectiveData(SysWidget sysWidget, Example example){
        return super.updateByExampleSelective(sysWidget,example);
    }
    
    /**
     * @Title:
     * @Description: 根据widgetUuid删除画面控件管理
     * @param sysWidget
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public int deleteData(SysWidget sysWidget) {
        return super.delete(sysWidget);
    }

    /**
     * @Title:
     * @Description: 根据widgetUuid集合批量删除画面控件管理
     * @param sysWidget
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    public int deleteDataList(List widgetUuids,SysWidget sysWidget){
        return super.deleteByIds(widgetUuids,sysWidget);
    }

    /**
     * @Title:
     * @Description: 查询全部画面控件管理
     * @return List<SysWidget>
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public List<SysWidget> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个画面控件管理
     * @param example
     * @return SysWidget
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public SysWidget selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询画面控件管理
     * @param example
     * @return List<SysWidget>
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public List<SysWidget> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过widgetUuid查询画面控件管理
     * @param widgetUuid
     * @return SysWidget
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public SysWidget selectByPrimaryKey(Object widgetUuid) {
        return super.selectByPrimaryKey(widgetUuid);
    }
    
    /**
     * @Title:
     * @Description: 分页查询画面控件管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysWidget>
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @Override
    public PageInfoExtend<SysWidget> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询画面控件管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysWidget>
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    public PageInfoExtend<SysWidget> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
