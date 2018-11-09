package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.OverdueCstmDao;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmRepositoryImpl
 * @Description: 逾期客户信息Repository 实现层
 * @date 2018-05-16
 */
@Repository
public class OverdueCstmRepositoryImpl extends AbstractBaseRepository<OverdueCstmDao, OverdueCstm> implements OverdueCstmRepository {

    /**
     * @Title:
     * @Description: 新增逾期客户信息
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int insertData(OverdueCstm overdueCstm) {
        return super.insert(overdueCstm);
    }

    /**
     * @Title:
     * @Description: 批量保存逾期客户信息
     * @param overdueCstms
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int insertDataList(List<OverdueCstm> overdueCstms){
        return super.insertListByJdbcTemplate(overdueCstms);
    }

    /**
     * @Title:
     * @Description: 修改逾期客户信息
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int updateByPrimaryKeyData(OverdueCstm overdueCstm) {
        return super.updateByPrimaryKey(overdueCstm);
    }

    /**
     * @Title:
     * @Description: 批量修改逾期客户信息
     * @param overdueCstms
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueCstm> overdueCstms){
        return super.updateListByPrimaryKey(overdueCstms);
    }

    /**
     * @Title:
     * @Description: 动态修改逾期客户信息
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueCstm overdueCstm) {
        return super.updateByPrimaryKeySelective(overdueCstm);
    }

    /**
     * @Title:
     * @Description: 批量动态修改逾期客户信息
     * @param overdueCstms
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueCstm> overdueCstms) {
        return super.updateListByPrimaryKeySelective(overdueCstms);
    }

    /**
     * @Title:
     * @Description: 根据条件修改逾期客户信息
     * @param overdueCstm
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int updateByExampleData(OverdueCstm overdueCstm, Example example) {
        return super.updateByExample(overdueCstm,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改逾期客户信息
     * @param overdueCstm
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int updateByExampleSelectiveData(OverdueCstm overdueCstm, Example example){
        return super.updateByExampleSelective(overdueCstm,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueCstmId删除逾期客户信息
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public int deleteData(OverdueCstm overdueCstm) {
        return super.delete(overdueCstm);
    }

    /**
     * @Title:
     * @Description: 根据overdueCstmId集合批量删除逾期客户信息
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public int deleteDataList(List overdueCstmIds,OverdueCstm overdueCstm){
        return super.deleteByIds(overdueCstmIds,overdueCstm);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除逾期客户信息
     * @param example
     * @param overdueCstm
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public int deleteExampleData(Example example,OverdueCstm overdueCstm){
        return super.deleteByExample(example,overdueCstm);
    }

    /**
     * @Title:
     * @Description: 查询全部逾期客户信息
     * @return List<OverdueCstm>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public List<OverdueCstm> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个逾期客户信息
     * @param example
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public OverdueCstm selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询逾期客户信息
     * @param example
     * @return List<OverdueCstm>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public List<OverdueCstm> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueCstmId查询逾期客户信息
     * @param overdueCstmId
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public OverdueCstm selectByPrimaryKey(Object overdueCstmId) {
        return super.selectByPrimaryKey(overdueCstmId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询逾期客户信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueCstm>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public PageInfoExtend<OverdueCstm> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息vo
     * @param overdueCstmId
     * @return List<OverdueCstmVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public OverdueCstmVo selectOverdueCstmByOverdueCstmId(String overdueCstmId){
        return baseDao.selectOverdueCstmByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息vo
     * @param overdueCstmId
     * @return List<OverdueCstmVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public OverdueCstmVo selectOverdueCstmVoByOverdueCstmId(String overdueCstmId){
        return baseDao.selectOverdueCstmVoByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息vo
     * @param overdueCstmId
     * @return List<String>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public List<String> selectContNoListByOverdueCstmId(String overdueCstmId){
        return baseDao.selectContNoListByOverdueCstmId(overdueCstmId);
    }

    /**
     * @Title:
     * @Description: 获取电话催收登记信息
     * @return List<OverdueTelRegisterVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public List<OverdueTelRegisterVo> selectOverdueTelRegister(String overdueCstmId){
        return baseDao.selectOverdueTelRegister(overdueCstmId);
    }

    /**
     * @Description: 根据逾期客户电话信息ID获取逾期客户电话信息
     * @return: OverdueCstmTelVo
     * @Param overdueCstmTelId
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    public OverdueCstmTelVo selectOverdueCstmTelVoByOverdueCstmTelId(String overdueCstmTelId){
        return baseDao.selectOverdueCstmTelVoByOverdueCstmTelId(overdueCstmTelId);
    }

    /**
     * @Description: 根据逾期客户信息ID获取电话催收登记信息List
     * @return: OverdueCstmTelVo
     * @Param overdueCstmTelId
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    public List<OverdueTelRegisterVo> selectOverdueTelRegisterVoByOverdueCstmId(String overdueCstmTelId){
        return baseDao.selectOverdueTelRegisterVoByOverdueCstmId(overdueCstmTelId);
    }

    /**
     * 根据overdueCstmId获取收车信息List
     *
     * @param overdueCstmId
     * @return
     */
    @Override
    public List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVoList(String overdueCstmId) {
        return baseDao.selectRetrieveCarsTaskVoList(overdueCstmId);
    }

    /**
     * 根据overdueCstmId获取诉讼信息List
     *
     * @param overdueCstmId
     * @return
     */
    @Override
    public List<LawsuitTaskVo> selectLawsuitTaskVoList(String overdueCstmId) {
        return baseDao.selectLawsuitTaskVoList(overdueCstmId);
    }

    /**
     * 获取上门催收信息List
     *
     * @param overdueCstmId
     * @return
     */
    @Override
    public List<CollectionTaskVo> selectCollectionTaskList(String overdueCstmId) {
        return baseDao.selectCollectionTaskList(overdueCstmId);
    }

    /**
     * 获取催收函数据
     *
     * @param contNo
     * @return
     */
    @Override
    public CollectionLetterVo selectCollectionLetterInfo(String contNo) {
        return baseDao.selectCollectionLetterInfo(contNo);
    }

    /**
     * 获取律师函数据
     *
     * @param contNo
     * @return
     */
    @Override
    public LawyerLetterVo selectLawyerLetterInfo(String contNo) {
        return baseDao.selectLawyerLetterInfo(contNo);
    }

    /**
     * 获取分配人员信息
     */
    @Override
    public List<SysUser> selectAssignUsers(List<String> roleCodeList) {
        return baseDao.selectAssignUsers(roleCodeList);
    }
}
