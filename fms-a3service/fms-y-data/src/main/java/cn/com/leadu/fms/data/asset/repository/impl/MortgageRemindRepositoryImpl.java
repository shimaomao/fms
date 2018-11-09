package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.MortgageRemindDao;
import cn.com.leadu.fms.data.asset.repository.MortgageRemindRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindRepositoryImpl
 * @Description: 抵押提醒Repository 实现层
 * @date 2018-07-27
 */
@Repository
public class MortgageRemindRepositoryImpl extends AbstractBaseRepository<MortgageRemindDao, MortgageRemind> implements MortgageRemindRepository {

    /**
     * @Title:
     * @Description: 新增抵押提醒
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int insertData(MortgageRemind mortgageRemind) {
        return super.insert(mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 批量保存抵押提醒
     * @param mortgageReminds
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int insertDataList(List<MortgageRemind> mortgageReminds){
        return super.insertListByJdbcTemplate(mortgageReminds);
    }

    /**
     * @Title:
     * @Description: 修改抵押提醒
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeyData(MortgageRemind mortgageRemind) {
        return super.updateByPrimaryKey(mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 批量修改抵押提醒
     * @param mortgageReminds
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MortgageRemind> mortgageReminds){
        return super.updateListByPrimaryKey(mortgageReminds);
    }

    /**
     * @Title:
     * @Description: 动态修改抵押提醒
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MortgageRemind mortgageRemind) {
        return super.updateByPrimaryKeySelective(mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 批量动态修改抵押提醒
     * @param mortgageReminds
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MortgageRemind> mortgageReminds) {
        return super.updateListByPrimaryKeySelective(mortgageReminds);
    }

    /**
     * @Title:
     * @Description: 根据条件修改抵押提醒
     * @param mortgageRemind
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByExampleData(MortgageRemind mortgageRemind, Example example) {
        return super.updateByExample(mortgageRemind,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改抵押提醒
     * @param mortgageRemind
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByExampleSelectiveData(MortgageRemind mortgageRemind, Example example){
        return super.updateByExampleSelective(mortgageRemind,example);
    }
    
    /**
     * @Title:
     * @Description: 根据morRemindId删除抵押提醒
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int deleteData(MortgageRemind mortgageRemind) {
        return super.delete(mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 根据morRemindId集合批量删除抵押提醒
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int deleteDataList(List morRemindIds,MortgageRemind mortgageRemind){
        return super.deleteByIds(morRemindIds,mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除抵押提醒
     * @param example
     * @param mortgageRemind
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int deleteExampleData(Example example,MortgageRemind mortgageRemind){
        return super.deleteByExample(example,mortgageRemind);
    }

    /**
     * @Title:
     * @Description: 查询全部抵押提醒
     * @return List<MortgageRemind>
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public List<MortgageRemind> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个抵押提醒
     * @param example
     * @return MortgageRemind
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public MortgageRemind selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询抵押提醒
     * @param example
     * @return List<MortgageRemind>
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public List<MortgageRemind> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过morRemindId查询抵押提醒
     * @param morRemindId
     * @return MortgageRemind
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public MortgageRemind selectByPrimaryKey(Object morRemindId) {
        return super.selectByPrimaryKey(morRemindId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询抵押提醒
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<MortgageRemind>
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public PageInfoExtend<MortgageRemind> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询抵押提醒vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改抵押提醒
     * @param mortgageRemind,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeyData(MortgageRemind mortgageRemind,boolean exclusive) {
        return super.updateByPrimaryKey(mortgageRemind,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改抵押提醒,并进行排他
     * @param mortgageReminds
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<MortgageRemind> mortgageReminds,boolean exclusive){
        return super.updateListByPrimaryKey(mortgageReminds,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改抵押提醒,并进行排他
     * @param mortgageRemind
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(MortgageRemind mortgageRemind,boolean exclusive) {
        return super.updateByPrimaryKeySelective(mortgageRemind,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改抵押提醒,并进行排他
     * @param mortgageReminds
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<MortgageRemind> mortgageReminds,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(mortgageReminds,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改抵押提醒,并进行排他
     * @param mortgageRemind
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByExampleData(MortgageRemind mortgageRemind, Example example,boolean exclusive) {
        return super.updateByExample(mortgageRemind,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改抵押提醒,并进行排他
     * @param mortgageRemind
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:58
     */
    @Override
    public int updateByExampleSelectiveData(MortgageRemind mortgageRemind, Example example,boolean exclusive){
        return super.updateByExampleSelective(mortgageRemind,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据ID获取数据信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public MortgageRemindVo selectMortgageRemindVosBymorRemindId(String morRemindId){
        return baseDao.selectMortgageRemindVosBymorRemindId(morRemindId);
    }
}
