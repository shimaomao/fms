package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.OrigFileDetailDao;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowPostVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OrigFileDetailRepositoryImpl
 * @Description: 原件归档明细信息Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class OrigFileDetailRepositoryImpl extends AbstractBaseRepository<OrigFileDetailDao, OrigFileDetail> implements OrigFileDetailRepository {

    /**
     * @Title:
     * @Description: 新增原件归档明细信息
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int insertData(OrigFileDetail origFileDetail) {
        return super.insert(origFileDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存原件归档明细信息
     * @param origFileDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int insertDataList(List<OrigFileDetail> origFileDetails){
        return super.insertListByJdbcTemplate(origFileDetails);
    }

    /**
     * @Title:
     * @Description: 修改原件归档明细信息
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeyData(OrigFileDetail origFileDetail) {
        return super.updateByPrimaryKey(origFileDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改原件归档明细信息
     * @param origFileDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OrigFileDetail> origFileDetails){
        return super.updateListByPrimaryKey(origFileDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改原件归档明细信息
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OrigFileDetail origFileDetail) {
        return super.updateByPrimaryKeySelective(origFileDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改原件归档明细信息
     * @param origFileDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<OrigFileDetail> origFileDetails) {
        return super.updateListByPrimaryKeySelective(origFileDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改原件归档明细信息
     * @param origFileDetail
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByExampleData(OrigFileDetail origFileDetail, Example example) {
        return super.updateByExample(origFileDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改原件归档明细信息
     * @param origFileDetail
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByExampleSelectiveData(OrigFileDetail origFileDetail, Example example){
        return super.updateByExampleSelective(origFileDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据origFileDetailId删除原件归档明细信息
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int deleteData(OrigFileDetail origFileDetail) {
        return super.delete(origFileDetail);
    }

    /**
     * @Title:
     * @Description: 根据origFileDetailId集合批量删除原件归档明细信息
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int deleteDataList(List origFileDetailIds,OrigFileDetail origFileDetail){
        return super.deleteByIds(origFileDetailIds,origFileDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除原件归档明细信息
     * @param example
     * @param origFileDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int deleteExampleData(Example example,OrigFileDetail origFileDetail){
        return super.deleteByExample(example,origFileDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部原件归档明细信息
     * @return List<OrigFileDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public List<OrigFileDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个原件归档明细信息
     * @param example
     * @return OrigFileDetail
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public OrigFileDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询原件归档明细信息
     * @param example
     * @return List<OrigFileDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public List<OrigFileDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过origFileDetailId查询原件归档明细信息
     * @param origFileDetailId
     * @return OrigFileDetail
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public OrigFileDetail selectByPrimaryKey(Object origFileDetailId) {
        return super.selectByPrimaryKey(origFileDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询原件归档明细信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OrigFileDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public PageInfoExtend<OrigFileDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询原件归档明细信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改原件归档明细信息
     * @param origFileDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeyData(OrigFileDetail origFileDetail,boolean exclusive) {
        return super.updateByPrimaryKey(origFileDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改原件归档明细信息,并进行排他
     * @param origFileDetails
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OrigFileDetail> origFileDetails,boolean exclusive){
        return super.updateListByPrimaryKey(origFileDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改原件归档明细信息,并进行排他
     * @param origFileDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OrigFileDetail origFileDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(origFileDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改原件归档明细信息,并进行排他
     * @param origFileDetails
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<OrigFileDetail> origFileDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(origFileDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改原件归档明细信息,并进行排他
     * @param origFileDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByExampleData(OrigFileDetail origFileDetail, Example example,boolean exclusive) {
        return super.updateByExample(origFileDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改原件归档明细信息,并进行排他
     * @param origFileDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public int updateByExampleSelectiveData(OrigFileDetail origFileDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(origFileDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细vo
     * @param origFileDetailVo
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileDetails(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileDetailsVosByPage(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细vo
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileBorrowDetails(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 查询资料邮寄附件明细vo
     * @param borrowTaskNo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo) {
        return baseDao.selectOrigFileBorrowMailByBorrowTaskNo(borrowTaskNo);
    }

    /**
     * @Title:
     * @Description: 查询资料邮寄附件明细vo（借阅归还）
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-30 17:21:08
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileBorrowBackMailByBorrowTaskNo(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileBorrowBackMailByBorrowTaskNo(origFileDetailVo);
    }

    /**
     * @param borrowBackTaskNo
     * @return BorrowBackTaskVo
     * @throws
     * @Title:
     * @Description: 据借阅归还任务号获取财务制单初始化信息
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public BorrowBackTaskVo selectBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo) {
        return baseDao.selectBorrowTaskMakeVoucherByBorrowBackTaskNo(borrowBackTaskNo);
    }

    /**
     * @Title:
     * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
     * @param borrowBackTaskNo
     * @return BorrowBackTaskVo
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo) {
        return baseDao.selectOrigFileBorrowMailByBorrowBackTaskNo(borrowBackTaskNo);
    }

    /**
     * @param origFileDetailVo
     * @return BorrowBackTaskVo
     * @throws
     * @Title:
     * @Description: 据借阅归还任务号获取资管审核邮寄附件明细信息列表
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @Override
    public List<OrigFileDetailVo> selectOrigFileBorrowExamineByBorrowBackTaskNo(OrigFileDetailVo origFileDetailVo) {
        return baseDao.selectOrigFileBorrowExamineByBorrowBackTaskNo(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 取待打印客户信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public BorrowBackTaskVo selectCustomerInformationByBorrowBackTaskNo(String borrowBackTaskNo,String bizCodeType){
        return baseDao.selectCustomerInformationByBorrowBackTaskNo(borrowBackTaskNo,bizCodeType);
    }

}
