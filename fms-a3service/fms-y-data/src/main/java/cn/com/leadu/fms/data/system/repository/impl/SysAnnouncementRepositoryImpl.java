package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysAnnouncementDao;
import cn.com.leadu.fms.data.system.repository.SysAnnouncementRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementRepositoryImpl
 * @Description: 利率因子Repository 实现层
 * @date 2018-04-27
 */
@Repository
public class SysAnnouncementRepositoryImpl extends AbstractBaseRepository<SysAnnouncementDao, SysAnnouncement> implements SysAnnouncementRepository {

    /**
     * @Title:
     * @Description: 新增利率因子
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int insertData(SysAnnouncement sysAnnouncement) {
        return super.insert(sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 批量保存利率因子
     * @param sysAnnouncements
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int insertDataList(List<SysAnnouncement> sysAnnouncements){
        return super.insertListByJdbcTemplate(sysAnnouncements);
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int updateByPrimaryKeyData(SysAnnouncement sysAnnouncement) {
        return super.updateByPrimaryKey(sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 批量修改利率因子
     * @param sysAnnouncements
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysAnnouncement> sysAnnouncements){
        return super.updateListByPrimaryKey(sysAnnouncements);
    }

    /**
     * @Title:
     * @Description: 动态修改利率因子
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysAnnouncement sysAnnouncement) {
        return super.updateByPrimaryKeySelective(sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 批量动态修改利率因子
     * @param sysAnnouncements
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysAnnouncement> sysAnnouncements) {
        return super.updateListByPrimaryKeySelective(sysAnnouncements);
    }

    /**
     * @Title:
     * @Description: 根据条件修改利率因子
     * @param sysAnnouncement
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int updateByExampleData(SysAnnouncement sysAnnouncement, Example example) {
        return super.updateByExample(sysAnnouncement,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改利率因子
     * @param sysAnnouncement
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int updateByExampleSelectiveData(SysAnnouncement sysAnnouncement, Example example){
        return super.updateByExampleSelective(sysAnnouncement,example);
    }
    
    /**
     * @Title:
     * @Description: 根据announceId删除利率因子
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public int deleteData(SysAnnouncement sysAnnouncement) {
        return super.delete(sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 根据announceId集合批量删除利率因子
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public int deleteDataList(List announceIds,SysAnnouncement sysAnnouncement){
        return super.deleteByIds(announceIds,sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除利率因子
     * @param example
     * @param sysAnnouncement
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    public int deleteExampleData(Example example,SysAnnouncement sysAnnouncement){
        return super.deleteByExample(example,sysAnnouncement);
    }

    /**
     * @Title:
     * @Description: 查询全部利率因子
     * @return List<SysAnnouncement>
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public List<SysAnnouncement> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个利率因子
     * @param example
     * @return SysAnnouncement
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public SysAnnouncement selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询利率因子
     * @param example
     * @return List<SysAnnouncement>
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public List<SysAnnouncement> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过announceId查询利率因子
     * @param announceId
     * @return SysAnnouncement
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public SysAnnouncement selectByPrimaryKey(Object announceId) {
        return super.selectByPrimaryKey(announceId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysAnnouncement>
     * @throws
     * @author lijunjun
     * @date 2018-4-27 11:47:37
     */
    @Override
    public PageInfoExtend<SysAnnouncement> selectListByExamplePage(Example example, PageQuery pageQuery){
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
     * @date 2018-4-27 11:47:37
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
