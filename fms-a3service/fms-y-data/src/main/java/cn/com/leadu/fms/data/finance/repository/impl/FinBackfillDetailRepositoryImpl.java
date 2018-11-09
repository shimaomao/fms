package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinBackfillDetailDao;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailRepositoryImpl
 * @Description: 融资回填明细Repository 实现层
 * @date 2018-05-12
 */
@Repository
public class FinBackfillDetailRepositoryImpl extends AbstractBaseRepository<FinBackfillDetailDao, FinBackfillDetail> implements FinBackfillDetailRepository {

    /**
     * @Title:
     * @Description: 新增融资回填明细
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int insertData(FinBackfillDetail finBackfillDetail) {
        return super.insert(finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存融资回填明细
     * @param finBackfillDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int insertDataList(List<FinBackfillDetail> finBackfillDetails){
        return super.insertListByJdbcTemplate(finBackfillDetails);
    }

    /**
     * @Title:
     * @Description: 修改融资回填明细
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int updateByPrimaryKeyData(FinBackfillDetail finBackfillDetail) {
        return super.updateByPrimaryKey(finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改融资回填明细
     * @param finBackfillDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinBackfillDetail> finBackfillDetails){
        return super.updateListByPrimaryKey(finBackfillDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改融资回填明细
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinBackfillDetail finBackfillDetail) {
        return super.updateByPrimaryKeySelective(finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资回填明细
     * @param finBackfillDetails
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public int updateByPrimaryKeySelectiveDataList(List<FinBackfillDetail> finBackfillDetails) {
        return super.updateListByPrimaryKeySelective(finBackfillDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资回填明细
     * @param finBackfillDetail
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int updateByExampleData(FinBackfillDetail finBackfillDetail, Example example) {
        return super.updateByExample(finBackfillDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资回填明细
     * @param finBackfillDetail
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int updateByExampleSelectiveData(FinBackfillDetail finBackfillDetail, Example example){
        return super.updateByExampleSelective(finBackfillDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据finBackfillDetailId删除融资回填明细
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public int deleteData(FinBackfillDetail finBackfillDetail) {
        return super.delete(finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 根据finBackfillDetailId集合批量删除融资回填明细
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public int deleteDataList(List finBackfillDetailIds,FinBackfillDetail finBackfillDetail){
        return super.deleteByIds(finBackfillDetailIds,finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除融资回填明细
     * @param example
     * @param finBackfillDetail
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public int deleteExampleData(Example example,FinBackfillDetail finBackfillDetail){
        return super.deleteByExample(example,finBackfillDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部融资回填明细
     * @return List<FinBackfillDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public List<FinBackfillDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资回填明细
     * @param example
     * @return FinBackfillDetail
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public FinBackfillDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资回填明细
     * @param example
     * @return List<FinBackfillDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public List<FinBackfillDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过finBackfillDetailId查询融资回填明细
     * @param finBackfillDetailId
     * @return FinBackfillDetail
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public FinBackfillDetail selectByPrimaryKey(Object finBackfillDetailId) {
        return super.selectByPrimaryKey(finBackfillDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资回填明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinBackfillDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    @Override
    public PageInfoExtend<FinBackfillDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资回填明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
