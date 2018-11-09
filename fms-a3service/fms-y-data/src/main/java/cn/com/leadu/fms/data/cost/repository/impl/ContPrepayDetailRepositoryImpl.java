package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.ContPrepayDetailDao;
import cn.com.leadu.fms.data.cost.repository.ContPrepayDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailRepositoryImpl
 * @Description: 提前还款明细Repository 实现层
 * @date 2018-05-11
 */
@Repository
public class ContPrepayDetailRepositoryImpl extends AbstractBaseRepository<ContPrepayDetailDao, ContPrepayDetail> implements ContPrepayDetailRepository {

    /**
     * @Title:
     * @Description: 新增提前还款明细
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int insertData(ContPrepayDetail contPrepayDetail) {
        return super.insert(contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存提前还款明细
     * @param contPrepayDetails
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int insertDataList(List<ContPrepayDetail> contPrepayDetails){
        return super.insertListByJdbcTemplate(contPrepayDetails);
    }

    /**
     * @Title:
     * @Description: 修改提前还款明细
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int updateByPrimaryKeyData(ContPrepayDetail contPrepayDetail) {
        return super.updateByPrimaryKey(contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改提前还款明细
     * @param contPrepayDetails
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContPrepayDetail> contPrepayDetails){
        return super.updateListByPrimaryKey(contPrepayDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改提前还款明细
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContPrepayDetail contPrepayDetail) {
        return super.updateByPrimaryKeySelective(contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改提前还款明细
     * @param contPrepayDetails
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContPrepayDetail> contPrepayDetails) {
        return super.updateListByPrimaryKeySelective(contPrepayDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改提前还款明细
     * @param contPrepayDetail
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int updateByExampleData(ContPrepayDetail contPrepayDetail, Example example) {
        return super.updateByExample(contPrepayDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改提前还款明细
     * @param contPrepayDetail
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int updateByExampleSelectiveData(ContPrepayDetail contPrepayDetail, Example example){
        return super.updateByExampleSelective(contPrepayDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contPrepayDetailId删除提前还款明细
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public int deleteData(ContPrepayDetail contPrepayDetail) {
        return super.delete(contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 根据contPrepayDetailId集合批量删除提前还款明细
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public int deleteDataList(List contPrepayDetailIds,ContPrepayDetail contPrepayDetail){
        return super.deleteByIds(contPrepayDetailIds,contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除提前还款明细
     * @param example
     * @param contPrepayDetail
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public int deleteExampleData(Example example,ContPrepayDetail contPrepayDetail){
        return super.deleteByExample(example,contPrepayDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部提前还款明细
     * @return List<ContPrepayDetail>
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public List<ContPrepayDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个提前还款明细
     * @param example
     * @return ContPrepayDetail
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public ContPrepayDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询提前还款明细
     * @param example
     * @return List<ContPrepayDetail>
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public List<ContPrepayDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contPrepayDetailId查询提前还款明细
     * @param contPrepayDetailId
     * @return ContPrepayDetail
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public ContPrepayDetail selectByPrimaryKey(Object contPrepayDetailId) {
        return super.selectByPrimaryKey(contPrepayDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询提前还款明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContPrepayDetail>
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    @Override
    public PageInfoExtend<ContPrepayDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询提前还款明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
