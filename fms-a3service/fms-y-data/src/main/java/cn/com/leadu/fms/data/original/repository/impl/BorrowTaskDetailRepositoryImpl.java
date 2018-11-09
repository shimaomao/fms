package cn.com.leadu.fms.data.original.repository.impl;

import cn.com.leadu.fms.data.original.dao.BorrowTaskDetailDao;
import cn.com.leadu.fms.data.original.repository.BorrowTaskDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailRepositoryImpl
 * @Description: 借阅任务明细Repository 实现层
 * @date 2018-07-16
 */
@Repository
public class BorrowTaskDetailRepositoryImpl extends AbstractBaseRepository<BorrowTaskDetailDao, BorrowTaskDetail> implements BorrowTaskDetailRepository {

    /**
     * @Title:
     * @Description: 新增借阅任务明细
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int insertData(BorrowTaskDetail borrowTaskDetail) {
        return super.insert(borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存借阅任务明细
     * @param borrowTaskDetails
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int insertDataList(List<BorrowTaskDetail> borrowTaskDetails){
        return super.insertListByJdbcTemplate(borrowTaskDetails);
    }

    /**
     * @Title:
     * @Description: 修改借阅任务明细
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeyData(BorrowTaskDetail borrowTaskDetail) {
        return super.updateByPrimaryKey(borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅任务明细
     * @param borrowTaskDetails
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowTaskDetail> borrowTaskDetails){
        return super.updateListByPrimaryKey(borrowTaskDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改借阅任务明细
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowTaskDetail borrowTaskDetail) {
        return super.updateByPrimaryKeySelective(borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅任务明细
     * @param borrowTaskDetails
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowTaskDetail> borrowTaskDetails) {
        return super.updateListByPrimaryKeySelective(borrowTaskDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅任务明细
     * @param borrowTaskDetail
     * @param example
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByExampleData(BorrowTaskDetail borrowTaskDetail, Example example) {
        return super.updateByExample(borrowTaskDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改借阅任务明细
     * @param borrowTaskDetail
     * @param example
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByExampleSelectiveData(BorrowTaskDetail borrowTaskDetail, Example example){
        return super.updateByExampleSelective(borrowTaskDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据borrowTaskDetailId删除借阅任务明细
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int deleteData(BorrowTaskDetail borrowTaskDetail) {
        return super.delete(borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 根据borrowTaskDetailId集合批量删除借阅任务明细
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int deleteDataList(List borrowTaskDetailIds,BorrowTaskDetail borrowTaskDetail){
        return super.deleteByIds(borrowTaskDetailIds,borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除借阅任务明细
     * @param example
     * @param borrowTaskDetail
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int deleteExampleData(Example example,BorrowTaskDetail borrowTaskDetail){
        return super.deleteByExample(example,borrowTaskDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部借阅任务明细
     * @return List<BorrowTaskDetail>
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public List<BorrowTaskDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个借阅任务明细
     * @param example
     * @return BorrowTaskDetail
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public BorrowTaskDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询借阅任务明细
     * @param example
     * @return List<BorrowTaskDetail>
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public List<BorrowTaskDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过borrowTaskDetailId查询借阅任务明细
     * @param borrowTaskDetailId
     * @return BorrowTaskDetail
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public BorrowTaskDetail selectByPrimaryKey(Object borrowTaskDetailId) {
        return super.selectByPrimaryKey(borrowTaskDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询借阅任务明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BorrowTaskDetail>
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public PageInfoExtend<BorrowTaskDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询借阅任务明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改借阅任务明细
     * @param borrowTaskDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeyData(BorrowTaskDetail borrowTaskDetail,boolean exclusive) {
        return super.updateByPrimaryKey(borrowTaskDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改借阅任务明细,并进行排他
     * @param borrowTaskDetails
     * @param exclusive
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BorrowTaskDetail> borrowTaskDetails,boolean exclusive){
        return super.updateListByPrimaryKey(borrowTaskDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改借阅任务明细,并进行排他
     * @param borrowTaskDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BorrowTaskDetail borrowTaskDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(borrowTaskDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改借阅任务明细,并进行排他
     * @param borrowTaskDetails
     * @param exclusive
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BorrowTaskDetail> borrowTaskDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(borrowTaskDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改借阅任务明细,并进行排他
     * @param borrowTaskDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByExampleData(BorrowTaskDetail borrowTaskDetail, Example example,boolean exclusive) {
        return super.updateByExample(borrowTaskDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改借阅任务明细,并进行排他
     * @param borrowTaskDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    @Override
    public int updateByExampleSelectiveData(BorrowTaskDetail borrowTaskDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(borrowTaskDetail,example,exclusive);
    }

}
