package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.TransferInfoDao;
import cn.com.leadu.fms.data.postbiz.repository.TransferInfoRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: TransferInfoRepositoryImpl
 * @Description: 过户流程Repository 实现层
 * @date 2018-08-30
 */
@Repository
public class TransferInfoRepositoryImpl extends AbstractBaseRepository<TransferInfoDao, TransferInfo> implements TransferInfoRepository {

    /**
     * @Title:
     * @Description: 新增过户流程
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int insertData(TransferInfo transferInfo) {
        return super.insert(transferInfo);
    }

    /**
     * @Title:
     * @Description: 批量保存过户流程
     * @param transferInfos
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int insertDataList(List<TransferInfo> transferInfos){
        return super.insertListByJdbcTemplate(transferInfos);
    }

    /**
     * @Title:
     * @Description: 修改过户流程
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeyData(TransferInfo transferInfo) {
        return super.updateByPrimaryKey(transferInfo);
    }

    /**
     * @Title:
     * @Description: 批量修改过户流程
     * @param transferInfos
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeyDataList(List<TransferInfo> transferInfos){
        return super.updateListByPrimaryKey(transferInfos);
    }

    /**
     * @Title:
     * @Description: 动态修改过户流程
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeySelectiveData(TransferInfo transferInfo) {
        return super.updateByPrimaryKeySelective(transferInfo);
    }

    /**
     * @Title:
     * @Description: 批量动态修改过户流程
     * @param transferInfos
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<TransferInfo> transferInfos) {
        return super.updateListByPrimaryKeySelective(transferInfos);
    }

    /**
     * @Title:
     * @Description: 根据条件修改过户流程
     * @param transferInfo
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByExampleData(TransferInfo transferInfo, Example example) {
        return super.updateByExample(transferInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改过户流程
     * @param transferInfo
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByExampleSelectiveData(TransferInfo transferInfo, Example example){
        return super.updateByExampleSelective(transferInfo,example);
    }
    
    /**
     * @Title:
     * @Description: 根据transferId删除过户流程
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int deleteData(TransferInfo transferInfo) {
        return super.delete(transferInfo);
    }

    /**
     * @Title:
     * @Description: 根据transferId集合批量删除过户流程
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int deleteDataList(List transferIds,TransferInfo transferInfo){
        return super.deleteByIds(transferIds,transferInfo);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除过户流程
     * @param example
     * @param transferInfo
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int deleteExampleData(Example example,TransferInfo transferInfo){
        return super.deleteByExample(example,transferInfo);
    }

    /**
     * @Title:
     * @Description: 查询全部过户流程
     * @return List<TransferInfo>
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public List<TransferInfo> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个过户流程
     * @param example
     * @return TransferInfo
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public TransferInfo selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询过户流程
     * @param example
     * @return List<TransferInfo>
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public List<TransferInfo> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过transferId查询过户流程
     * @param transferId
     * @return TransferInfo
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public TransferInfo selectByPrimaryKey(Object transferId) {
        return super.selectByPrimaryKey(transferId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询过户流程
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<TransferInfo>
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public PageInfoExtend<TransferInfo> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询过户流程vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改过户流程
     * @param transferInfo,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeyData(TransferInfo transferInfo,boolean exclusive) {
        return super.updateByPrimaryKey(transferInfo,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改过户流程,并进行排他
     * @param transferInfos
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeyDataList(List<TransferInfo> transferInfos,boolean exclusive){
        return super.updateListByPrimaryKey(transferInfos,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改过户流程,并进行排他
     * @param transferInfo
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(TransferInfo transferInfo,boolean exclusive) {
        return super.updateByPrimaryKeySelective(transferInfo,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改过户流程,并进行排他
     * @param transferInfos
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<TransferInfo> transferInfos,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(transferInfos,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改过户流程,并进行排他
     * @param transferInfo
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByExampleData(TransferInfo transferInfo, Example example,boolean exclusive) {
        return super.updateByExample(transferInfo,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改过户流程,并进行排他
     * @param transferInfo
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @Override
    public int updateByExampleSelectiveData(TransferInfo transferInfo, Example example,boolean exclusive){
        return super.updateByExampleSelective(transferInfo,example,exclusive);
    }

    /**
     * @Description: 根据车架号 获取过户处理明细信息
     * @param: contNo 合同编号
     * @return: TransferDetailVo
     * @Author: wangxue
     * @Date: 2018/8/31 10:22
     */
    @Override
    public TransferInfoVo selectTransferDetailByContNo(String contNo,String cancelMortgageStatus,String invalidMortgageStatus) {
        return baseDao.selectTransferDetailByContNo(contNo,cancelMortgageStatus,invalidMortgageStatus);
    }

    /**
     * @Description: 根据过户任务号 获取过户处理明细信息
     * @param: transferNo 过户任务号
     * @return: TransferInfoVo
     * @Author: wangxue
     * @Date: 2018/8/31 10:22
     */
    @Override
    public TransferInfoVo selectTransferInfoVoByTransferNo(String transferNo,String cancelMortgageStatus,String invalidMortgageStatus) {
        return baseDao.selectTransferInfoVoByTransferNo(transferNo,cancelMortgageStatus,invalidMortgageStatus);
    }

    /**
     * 获取确认书需要数据
     *
     * @param contNo
     * @return
     */
    @Override
    public TransferInfoLetterVo selectTransferInfoLetterVo(String contNo) {
        return baseDao.selectTransferInfoLetterVo(contNo);
    }

    /**
     * @Title:
     * @Description: 根据合同号获取过户退保详情
     * @param
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018-10-29 17:15:00
     */
    @Override
    public List<TransferInfoRetreatsVo> findTransferInfoRetreatsByVo(TransferInfoRetreatsVo transferInfoRetreatsVo) {
        return baseDao.selectTransferInfoRetreatsVosByPage(transferInfoRetreatsVo);
    }

    /**
     * @Title:
     * @Description: 根据退保任务号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public TransferInfoRetreatsVo selectTransferInfoRetreatVoByRetreatsNo(String retreatsNo) {
        return baseDao.selectTransferInfoRetreatVoByRetreatsNo(retreatsNo);
    }

    /**
     * @Title:
     * @Description: 根据合同号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Override
    public TransferInfoRetreatsVo selectTransferInfoRetreatVoByContNo(String contNo) {
        return baseDao.selectTransferInfoRetreatVoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 根据退保任务号和业务类型查询财务付款表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContPay selectContPayByRetreatsNo(String bizCode, String paymentType){
        return baseDao.selectContPayByRetreatsNo(bizCode,paymentType);

    }
}
