package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.EquMorRepayDetailDao;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailRepositoryImpl
 * @Description: 资方抵押还款计划Repository 实现层
 */
@Repository
public class EquMorRepayDetailRepositoryImpl extends AbstractBaseRepository<EquMorRepayDetailDao, EquMorRepayDetail> implements EquMorRepayDetailRepository {

    /**
     * @Title:
     * @Description: 新增资方抵押还款计划
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int insertData(EquMorRepayDetail equMorRepayDetail) {
        return super.insert(equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存资方抵押还款计划
     * @param equMorRepayDetails
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int insertDataList(List<EquMorRepayDetail> equMorRepayDetails){
        return super.insertListByJdbcTemplate(equMorRepayDetails);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeyData(EquMorRepayDetail equMorRepayDetail) {
        return super.updateByPrimaryKey(equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押还款计划
     * @param equMorRepayDetails
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorRepayDetail> equMorRepayDetails){
        return super.updateListByPrimaryKey(equMorRepayDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改资方抵押还款计划
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorRepayDetail equMorRepayDetail) {
        return super.updateByPrimaryKeySelective(equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押还款计划
     * @param equMorRepayDetails
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorRepayDetail> equMorRepayDetails) {
        return super.updateListByPrimaryKeySelective(equMorRepayDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押还款计划
     * @param equMorRepayDetail
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByExampleData(EquMorRepayDetail equMorRepayDetail, Example example) {
        return super.updateByExample(equMorRepayDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押还款计划
     * @param equMorRepayDetail
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByExampleSelectiveData(EquMorRepayDetail equMorRepayDetail, Example example){
        return super.updateByExampleSelective(equMorRepayDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equMorRepayDetailId删除资方抵押还款计划
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int deleteData(EquMorRepayDetail equMorRepayDetail) {
        return super.delete(equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 根据equMorRepayDetailId集合批量删除资方抵押还款计划
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int deleteDataList(List equMorRepayDetailIds,EquMorRepayDetail equMorRepayDetail){
        return super.deleteByIds(equMorRepayDetailIds,equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方抵押还款计划
     * @param example
     * @param equMorRepayDetail
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int deleteExampleData(Example example,EquMorRepayDetail equMorRepayDetail){
        return super.deleteByExample(example,equMorRepayDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部资方抵押还款计划
     * @return List<EquMorRepayDetail>
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public List<EquMorRepayDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方抵押还款计划
     * @param example
     * @return EquMorRepayDetail
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public EquMorRepayDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方抵押还款计划
     * @param example
     * @return List<EquMorRepayDetail>
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public List<EquMorRepayDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equMorRepayDetailId查询资方抵押还款计划
     * @param equMorRepayDetailId
     * @return EquMorRepayDetail
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public EquMorRepayDetail selectByPrimaryKey(Object equMorRepayDetailId) {
        return super.selectByPrimaryKey(equMorRepayDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquMorRepayDetail>
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public PageInfoExtend<EquMorRepayDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepayDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeyData(EquMorRepayDetail equMorRepayDetail,boolean exclusive) {
        return super.updateByPrimaryKey(equMorRepayDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押还款计划,并进行排他
     * @param equMorRepayDetails
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorRepayDetail> equMorRepayDetails,boolean exclusive){
        return super.updateListByPrimaryKey(equMorRepayDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方抵押还款计划,并进行排他
     * @param equMorRepayDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorRepayDetail equMorRepayDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equMorRepayDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押还款计划,并进行排他
     * @param equMorRepayDetails
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorRepayDetail> equMorRepayDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equMorRepayDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押还款计划,并进行排他
     * @param equMorRepayDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByExampleData(EquMorRepayDetail equMorRepayDetail, Example example,boolean exclusive) {
        return super.updateByExample(equMorRepayDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押还款计划,并进行排他
     * @param equMorRepayDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    @Override
    public int updateByExampleSelectiveData(EquMorRepayDetail equMorRepayDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(equMorRepayDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 获取需要插入抵押还款计划详细表
     * @return List<EquMorRepayDetailVo>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByEquTaskNo(String equMorTaskNo){
        return baseDao.selectEquMorRepayDetailVosByEquTaskNo(equMorTaskNo);
    }


    /**
     * @Title:
     * @Description: 资方抵押还款计划详情表获取一览数据
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public List<EquMorRepayDetailVo> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo){
        return baseDao.selectEquMorRepayDetailVosByPage(equMorRepayDetailVo);
    }
}
