package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.cost.dao.OverdueExemptDetailDao;
import cn.com.leadu.fms.data.cost.repository.OverdueExemptDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExemptDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptDetailRepositoryImpl
 * @Description: 罚息免除任务明细表Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class OverdueExemptDetailRepositoryImpl extends AbstractBaseRepository<OverdueExemptDetailDao, OverdueExemptDetail> implements OverdueExemptDetailRepository {

    /**
     * @Title:
     * @Description: 新增罚息免除任务明细表
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int insertData(OverdueExemptDetail overdueExemptDetail) {
        return super.insert(overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存罚息免除任务明细表
     * @param overdueExemptDetails
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int insertDataList(List<OverdueExemptDetail> overdueExemptDetails){
        return super.insertListByJdbcTemplate(overdueExemptDetails);
    }

    /**
     * @Title:
     * @Description: 修改罚息免除任务明细表
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int updateByPrimaryKeyData(OverdueExemptDetail overdueExemptDetail) {
        return super.updateByPrimaryKey(overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改罚息免除任务明细表
     * @param overdueExemptDetails
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueExemptDetail> overdueExemptDetails){
        return super.updateListByPrimaryKey(overdueExemptDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改罚息免除任务明细表
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueExemptDetail overdueExemptDetail) {
        return super.updateByPrimaryKeySelective(overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改罚息免除任务明细表
     * @param overdueExemptDetails
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueExemptDetail> overdueExemptDetails) {
        return super.updateListByPrimaryKeySelective(overdueExemptDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改罚息免除任务明细表
     * @param overdueExemptDetail
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int updateByExampleData(OverdueExemptDetail overdueExemptDetail, Example example) {
        return super.updateByExample(overdueExemptDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改罚息免除任务明细表
     * @param overdueExemptDetail
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int updateByExampleSelectiveData(OverdueExemptDetail overdueExemptDetail, Example example){
        return super.updateByExampleSelective(overdueExemptDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueExemptDetailId删除罚息免除任务明细表
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public int deleteData(OverdueExemptDetail overdueExemptDetail) {
        return super.delete(overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 根据overdueExemptDetailId集合批量删除罚息免除任务明细表
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    public int deleteDataList(List overdueExemptDetailIds,OverdueExemptDetail overdueExemptDetail){
        return super.deleteByIds(overdueExemptDetailIds,overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除罚息免除任务明细表
     * @param example
     * @param overdueExemptDetail
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    public int deleteExampleData(Example example,OverdueExemptDetail overdueExemptDetail){
        return super.deleteByExample(example,overdueExemptDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部罚息免除任务明细表
     * @return List<OverdueExemptDetail>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public List<OverdueExemptDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个罚息免除任务明细表
     * @param example
     * @return OverdueExemptDetail
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public OverdueExemptDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询罚息免除任务明细表
     * @param example
     * @return List<OverdueExemptDetail>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public List<OverdueExemptDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueExemptDetailId查询罚息免除任务明细表
     * @param overdueExemptDetailId
     * @return OverdueExemptDetail
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public OverdueExemptDetail selectByPrimaryKey(Object overdueExemptDetailId) {
        return super.selectByPrimaryKey(overdueExemptDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询罚息免除任务明细表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueExemptDetail>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    @Override
    public PageInfoExtend<OverdueExemptDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询罚息免除任务明细表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:43:43
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
