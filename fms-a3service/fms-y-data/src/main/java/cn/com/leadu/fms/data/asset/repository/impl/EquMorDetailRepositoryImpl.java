package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.EquMorDetailDao;
import cn.com.leadu.fms.data.asset.repository.EquMorDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailRepositoryImpl
 * @Description: 资方抵押明细Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class EquMorDetailRepositoryImpl extends AbstractBaseRepository<EquMorDetailDao, EquMorDetail> implements EquMorDetailRepository {

    /**
     * @Title:
     * @Description: 新增资方抵押明细
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int insertData(EquMorDetail equMorDetail) {
        return super.insert(equMorDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存资方抵押明细
     * @param equMorDetails
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int insertDataList(List<EquMorDetail> equMorDetails){
        return super.insertListByJdbcTemplate(equMorDetails);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押明细
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeyData(EquMorDetail equMorDetail) {
        return super.updateByPrimaryKey(equMorDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押明细
     * @param equMorDetails
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorDetail> equMorDetails){
        return super.updateListByPrimaryKey(equMorDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改资方抵押明细
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorDetail equMorDetail) {
        return super.updateByPrimaryKeySelective(equMorDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押明细
     * @param equMorDetails
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorDetail> equMorDetails) {
        return super.updateListByPrimaryKeySelective(equMorDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押明细
     * @param equMorDetail
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByExampleData(EquMorDetail equMorDetail, Example example) {
        return super.updateByExample(equMorDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押明细
     * @param equMorDetail
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByExampleSelectiveData(EquMorDetail equMorDetail, Example example){
        return super.updateByExampleSelective(equMorDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equMorDetailId删除资方抵押明细
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int deleteData(EquMorDetail equMorDetail) {
        return super.delete(equMorDetail);
    }

    /**
     * @Title:
     * @Description: 根据equMorDetailId集合批量删除资方抵押明细
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int deleteDataList(List equMorDetailIds,EquMorDetail equMorDetail){
        return super.deleteByIds(equMorDetailIds,equMorDetail);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方抵押明细
     * @param example
     * @param equMorDetail
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int deleteExampleData(Example example,EquMorDetail equMorDetail){
        return super.deleteByExample(example,equMorDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部资方抵押明细
     * @return List<EquMorDetail>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public List<EquMorDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方抵押明细
     * @param example
     * @return EquMorDetail
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public EquMorDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方抵押明细
     * @param example
     * @return List<EquMorDetail>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public List<EquMorDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equMorDetailId查询资方抵押明细
     * @param equMorDetailId
     * @return EquMorDetail
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public EquMorDetail selectByPrimaryKey(Object equMorDetailId) {
        return super.selectByPrimaryKey(equMorDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方抵押明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquMorDetail>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public PageInfoExtend<EquMorDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押明细
     * @param equMorDetail,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeyData(EquMorDetail equMorDetail,boolean exclusive) {
        return super.updateByPrimaryKey(equMorDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押明细,并进行排他
     * @param equMorDetails
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorDetail> equMorDetails,boolean exclusive){
        return super.updateListByPrimaryKey(equMorDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方抵押明细,并进行排他
     * @param equMorDetail
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorDetail equMorDetail,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equMorDetail,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押明细,并进行排他
     * @param equMorDetails
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorDetail> equMorDetails,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equMorDetails,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押明细,并进行排他
     * @param equMorDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByExampleData(EquMorDetail equMorDetail, Example example,boolean exclusive) {
        return super.updateByExample(equMorDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押明细,并进行排他
     * @param equMorDetail
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @Override
    public int updateByExampleSelectiveData(EquMorDetail equMorDetail, Example example,boolean exclusive){
        return super.updateByExampleSelective(equMorDetail,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据ids查询所有明细(申请)
     * @param equMorDetailVo
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @Override
    public List<EquMorDetailVo> selectEquMorDetailVos(EquMorDetailVo equMorDetailVo) {
        return baseDao.selectEquMorDetailVosByPage(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description: 根据taskNo查询所有明细(复审)
     * @param equMorDetailVo
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @Override
    public List<EquMorDetailVo> selectEquMorDetailVoList(EquMorDetailVo equMorDetailVo) {
        return baseDao.selectEquMorDetailVoList(equMorDetailVo);
    }

    /**
     * @Title:
     * @Description:   抵押任务明细
     * @param bizCodeType   归档借阅类型
     * @param equMorTaskNo      抵押任务号
     * @param applyTypePerson 个人申请类型
     * @param totalFlag 费用合计类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 11:52:41
     */
    public List<EquMorDetailVo> selectEquMorDetailVosByEquMorTaskNo(String bizCodeType,String equMorTaskNo ,String applyTypePerson,String totalFlag){
        return baseDao.selectEquMorDetailVosByEquMorTaskNo(bizCodeType,equMorTaskNo,applyTypePerson,totalFlag);
    }

}
