package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.system.dao.SysMenuClicksDao;
import cn.com.leadu.fms.data.system.repository.SysMenuClicksRepository;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksRepositoryImpl
 * @Description: 利率因子Repository 实现层
 * @date 2018-05-03
 */
@Repository
public class SysMenuClicksRepositoryImpl extends AbstractBaseRepository<SysMenuClicksDao, SysMenuClicks> implements SysMenuClicksRepository {

    /**
     * @Title:
     * @Description: 新增利率因子
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int insertData(SysMenuClicks sysMenuClicks) {
        return super.insert(sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 批量保存利率因子
     * @param sysMenuClickss
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int insertDataList(List<SysMenuClicks> sysMenuClickss){
        return super.insertListByJdbcTemplate(sysMenuClickss);
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int updateByPrimaryKeyData(SysMenuClicks sysMenuClicks) {
        return super.updateByPrimaryKey(sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 批量修改利率因子
     * @param sysMenuClickss
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysMenuClicks> sysMenuClickss){
        return super.updateListByPrimaryKey(sysMenuClickss);
    }

    /**
     * @Title:
     * @Description: 动态修改利率因子
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysMenuClicks sysMenuClicks) {
        return super.updateByPrimaryKeySelective(sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 批量动态修改利率因子
     * @param sysMenuClickss
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysMenuClicks> sysMenuClickss) {
        return super.updateListByPrimaryKeySelective(sysMenuClickss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改利率因子
     * @param sysMenuClicks
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int updateByExampleData(SysMenuClicks sysMenuClicks, Example example) {
        return super.updateByExample(sysMenuClicks,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改利率因子
     * @param sysMenuClicks
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int updateByExampleSelectiveData(SysMenuClicks sysMenuClicks, Example example){
        return super.updateByExampleSelective(sysMenuClicks,example);
    }
    
    /**
     * @Title:
     * @Description: 根据menuClicksId删除利率因子
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public int deleteData(SysMenuClicks sysMenuClicks) {
        return super.delete(sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 根据menuClicksId集合批量删除利率因子
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    public int deleteDataList(List menuClicksIds,SysMenuClicks sysMenuClicks){
        return super.deleteByIds(menuClicksIds,sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除利率因子
     * @param example
     * @param sysMenuClicks
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    public int deleteExampleData(Example example,SysMenuClicks sysMenuClicks){
        return super.deleteByExample(example,sysMenuClicks);
    }

    /**
     * @Title:
     * @Description: 查询全部利率因子
     * @return List<SysMenuClicks>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public List<SysMenuClicks> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个利率因子
     * @param example
     * @return SysMenuClicks
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public SysMenuClicks selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询利率因子
     * @param example
     * @return List<SysMenuClicks>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public List<SysMenuClicks> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过menuClicksId查询利率因子
     * @param menuClicksId
     * @return SysMenuClicks
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public SysMenuClicks selectByPrimaryKey(Object menuClicksId) {
        return super.selectByPrimaryKey(menuClicksId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysMenuClicks>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public PageInfoExtend<SysMenuClicks> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询利率因子vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据用户获取常用菜单List
     * @param sysMenuClicksVo
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @Override
    public List<SysMenuClicksVo> selectSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo) {
        return baseDao.selectSysMenuClicksByUser(sysMenuClicksVo);
    }

}
