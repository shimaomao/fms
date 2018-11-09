package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueContDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueContRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueContRepositoryImpl
 * @Description: 逾期合同信息Repository 实现层
 * @date 2018-05-16
 */
@Repository
public class OverdueContRepositoryImpl extends AbstractBaseRepository<OverdueContDao, OverdueCont> implements OverdueContRepository {

    /**
     * @Title:
     * @Description: 新增逾期合同信息
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int insertData(OverdueCont overdueCont) {
        return super.insert(overdueCont);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期合同信息
     * @param overdueConts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int insertDataList(List<OverdueCont> overdueConts){
        return super.insertListByJdbcTemplate(overdueConts);
    }

    /**
     * @Title:
     * @Description: 修改逾期合同信息
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int updateByPrimaryKeyData(OverdueCont overdueCont) {
        return super.updateByPrimaryKey(overdueCont);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期合同信息
     * @param overdueConts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueCont> overdueConts){
        return super.updateListByPrimaryKey(overdueConts);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期合同信息
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueCont overdueCont) {
        return super.updateByPrimaryKeySelective(overdueCont);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期合同信息
     * @param overdueConts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueCont> overdueConts) {
        return super.updateListByPrimaryKeySelective(overdueConts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期合同信息
     * @param overdueCont
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int updateByExampleData(OverdueCont overdueCont, Example example) {
        return super.updateByExample(overdueCont,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期合同信息
     * @param overdueCont
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int updateByExampleSelectiveData(OverdueCont overdueCont, Example example){
        return super.updateByExampleSelective(overdueCont,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueContId删除逾期合同信息
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public int deleteData(OverdueCont overdueCont) {
        return super.delete(overdueCont);
    }

    /**
     * @Title:
     * @Description: 根据overdueContId集合批量删除逾期合同信息
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public int deleteDataList(List overdueContIds,OverdueCont overdueCont){
        return super.deleteByIds(overdueContIds,overdueCont);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期合同信息
     * @param example
     * @param overdueCont
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public int deleteExampleData(Example example,OverdueCont overdueCont){
        return super.deleteByExample(example,overdueCont);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期合同信息
     * @return List<OverdueCont>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public List<OverdueCont> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期合同信息
     * @param example
     * @return OverdueCont
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public OverdueCont selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期合同信息
     * @param example
     * @return List<OverdueCont>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public List<OverdueCont> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueContId查询逾期合同信息
     * @param overdueContId
     * @return OverdueCont
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public OverdueCont selectByPrimaryKey(Object overdueContId) {
        return super.selectByPrimaryKey(overdueContId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期合同信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueCont>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @Override
    public PageInfoExtend<OverdueCont> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期合同信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据contNo获取逾期合同信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public OverdueContVo selectOverdueContByContNo(String contNo){
        return baseDao.selectOverdueContByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 获取合同的历史最高逾期天数和历史逾期次数
     * @return List<OverdueContVo>
     * @throws
     * @author wangxue
     * @date
     */
    @Override
    public List<OverdueContVo> selectOverdueDaysHisAndOverdueTimes() {
        return baseDao.selectOverdueDaysHisAndOverdueTimes();
    }

    /**
     * @Title:
     * @Description: 获取逾期客户表中的全部订单编号
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-9-04 11:24:39
     */
    @Override
    public List<String> selectAllApplyNosByOverdue() {
        return baseDao.selectAllApplyNosByOverdue();
    }

    /**
     * @Title:
     * @Description:   根据合同号获取逾期合同号
     * @param overdueContVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/17 04:14:21
     */
    public OverdueContVo selectOverdueContVoByContNo(OverdueContVo overdueContVo){
        return baseDao.selectOverdueContVoByContNo(overdueContVo);
    }

    /**
     * @Title:
     * @Description:  获取全部的当前正在逾期的逾期合同ID集合
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018/09/17 04:14:21
     */
    @Override
    public List<String> selectOverdueContIdsByOverdueFlag() {
        return baseDao.selectOverdueContIdsByOverdueFlag();
    }
}
