package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysLogDao;
import cn.com.leadu.fms.data.system.repository.SysLogRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysLog;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysLogRepositoryImpl
 * @Description: 日志管理Repository 实现层
 * @date 2018-03-22
 */
@Repository
public class SysLogRepositoryImpl extends AbstractBaseRepository<SysLogDao, SysLog> implements SysLogRepository {

    /**
     * @Title:
     * @Description: 新增日志管理
     * @param sysLog
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int insertData(SysLog sysLog) {
        return super.insert(sysLog);
    }

    /**
     * @Title:
     * @Description: 批量保存日志管理
     * @param sysLogs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int insertDataList(List<SysLog> sysLogs){
        return super.insertListByJdbcTemplate(sysLogs);
    }

    /**
     * @Title:
     * @Description: 修改日志管理
     * @param sysLog
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int updateByPrimaryKeyData(SysLog sysLog) {
        return super.updateByPrimaryKey(sysLog);
    }

    /**
     * @Title:
     * @Description: 批量修改日志管理
     * @param sysLogs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysLog> sysLogs){
        return super.insertListByJdbcTemplate(sysLogs);
    }

    /**
     * @Title:
     * @Description: 动态修改日志管理
     * @param sysLog
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysLog sysLog) {
        return super.updateByPrimaryKeySelective(sysLog);
    }

    /**
     * @Title:
     * @Description: 批量动态修改日志管理
     * @param sysLogs
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysLog> sysLogs) {
        return super.updateListByPrimaryKeySelective(sysLogs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改日志管理
     * @param sysLog
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int updateByExampleData(SysLog sysLog, Example example) {
        return super.updateByExample(sysLog,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改日志管理
     * @param sysLog
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int updateByExampleSelectiveData(SysLog sysLog, Example example){
        return super.updateByExampleSelective(sysLog,example);
    }
    
    /**
     * @Title:
     * @Description: 根据logId删除日志管理
     * @param sysLog
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public int deleteData(SysLog sysLog) {
        return super.delete(sysLog);
    }

    /**
     * @Title:
     * @Description: 根据logId集合批量删除日志管理
     * @param sysLog
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public int deleteDataList(List logIds,SysLog sysLog){
        return super.deleteByIds(logIds,sysLog);
    }

    /**
     * @Title:
     * @Description: 查询全部日志管理
     * @return List<SysLog>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public List<SysLog> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个日志管理
     * @param example
     * @return SysLog
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public SysLog selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询日志管理
     * @param example
     * @return List<SysLog>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public List<SysLog> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过logId查询日志管理
     * @param logId
     * @return SysLog
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public SysLog selectByPrimaryKey(Object logId) {
        return super.selectByPrimaryKey(logId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询日志管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysLog>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    @Override
    public PageInfoExtend<SysLog> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询日志管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysLog>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-22 15:02:45
     */
    public PageInfoExtend<SysLog> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
