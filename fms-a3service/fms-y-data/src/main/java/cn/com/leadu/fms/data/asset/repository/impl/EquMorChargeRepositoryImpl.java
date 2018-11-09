package cn.com.leadu.fms.data.asset.repository.impl;

import cn.com.leadu.fms.data.asset.dao.EquMorChargeDao;
import cn.com.leadu.fms.data.asset.repository.EquMorChargeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeRepositoryImpl
 * @Description: 资方抵押费用Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class EquMorChargeRepositoryImpl extends AbstractBaseRepository<EquMorChargeDao, EquMorCharge> implements EquMorChargeRepository {

    /**
     * @Title:
     * @Description: 新增资方抵押费用
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int insertData(EquMorCharge equMorCharge) {
        return super.insert(equMorCharge);
    }

    /**
     * @Title:
     * @Description: 批量保存资方抵押费用
     * @param equMorCharges
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int insertDataList(List<EquMorCharge> equMorCharges){
        return super.insertListByJdbcTemplate(equMorCharges);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押费用
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeyData(EquMorCharge equMorCharge) {
        return super.updateByPrimaryKey(equMorCharge);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押费用
     * @param equMorCharges
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorCharge> equMorCharges){
        return super.updateListByPrimaryKey(equMorCharges);
    }

    /**
     * @Title:
     * @Description: 动态修改资方抵押费用
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorCharge equMorCharge) {
        return super.updateByPrimaryKeySelective(equMorCharge);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押费用
     * @param equMorCharges
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorCharge> equMorCharges) {
        return super.updateListByPrimaryKeySelective(equMorCharges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押费用
     * @param equMorCharge
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByExampleData(EquMorCharge equMorCharge, Example example) {
        return super.updateByExample(equMorCharge,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押费用
     * @param equMorCharge
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByExampleSelectiveData(EquMorCharge equMorCharge, Example example){
        return super.updateByExampleSelective(equMorCharge,example);
    }
    
    /**
     * @Title:
     * @Description: 根据equMorChargeId删除资方抵押费用
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int deleteData(EquMorCharge equMorCharge) {
        return super.delete(equMorCharge);
    }

    /**
     * @Title:
     * @Description: 根据equMorChargeId集合批量删除资方抵押费用
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int deleteDataList(List equMorChargeIds,EquMorCharge equMorCharge){
        return super.deleteByIds(equMorChargeIds,equMorCharge);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除资方抵押费用
     * @param example
     * @param equMorCharge
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int deleteExampleData(Example example,EquMorCharge equMorCharge){
        return super.deleteByExample(example,equMorCharge);
    }

    /**
     * @Title:
     * @Description: 查询全部资方抵押费用
     * @return List<EquMorCharge>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public List<EquMorCharge> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个资方抵押费用
     * @param example
     * @return EquMorCharge
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public EquMorCharge selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询资方抵押费用
     * @param example
     * @return List<EquMorCharge>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public List<EquMorCharge> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过equMorChargeId查询资方抵押费用
     * @param equMorChargeId
     * @return EquMorCharge
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public EquMorCharge selectByPrimaryKey(Object equMorChargeId) {
        return super.selectByPrimaryKey(equMorChargeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询资方抵押费用
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<EquMorCharge>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public PageInfoExtend<EquMorCharge> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询资方抵押费用vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改资方抵押费用
     * @param equMorCharge,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeyData(EquMorCharge equMorCharge,boolean exclusive) {
        return super.updateByPrimaryKey(equMorCharge,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改资方抵押费用,并进行排他
     * @param equMorCharges
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeyDataList(List<EquMorCharge> equMorCharges,boolean exclusive){
        return super.updateListByPrimaryKey(equMorCharges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改资方抵押费用,并进行排他
     * @param equMorCharge
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(EquMorCharge equMorCharge,boolean exclusive) {
        return super.updateByPrimaryKeySelective(equMorCharge,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改资方抵押费用,并进行排他
     * @param equMorCharges
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<EquMorCharge> equMorCharges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(equMorCharges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改资方抵押费用,并进行排他
     * @param equMorCharge
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByExampleData(EquMorCharge equMorCharge, Example example,boolean exclusive) {
        return super.updateByExample(equMorCharge,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改资方抵押费用,并进行排他
     * @param equMorCharge
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 16:58:15
     */
    @Override
    public int updateByExampleSelectiveData(EquMorCharge equMorCharge, Example example,boolean exclusive){
        return super.updateByExampleSelective(equMorCharge,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 查询资方抵押申请合同详情
     * @param equMorApplyVo
     * @return  List<EquMorChargeApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    public EquMorApplyVo selectEquMorApplyVoByContNo(EquMorApplyVo equMorApplyVo){
        return baseDao.selectEquMorApplyVoByContNo(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description: 查询资方抵押申请合同详情列表
     * @param equMorApplyVo
     * @return  List<EquMorChargeApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    public List<EquMorApplyVo> selectEquMorApplyVosByContNos(EquMorApplyVo equMorApplyVo){
        return baseDao.selectEquMorApplyVosByContNos(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description: 查询资方抵押申请模板下载详情
     * @param equMorApplyVo
     * @return  List<EquMorApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    public List<EquMorApplyVo> selectExportEquMorApplyVos(EquMorApplyVo equMorApplyVo){
        return baseDao.selectExportEquMorApplyVos(equMorApplyVo);
    }

    /**
     * @Title:
     * @Description: 查询资方抵押申请合同列表
     * @param equMorApplyVo
     * @return  List<equMorChargeApplyVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/30 05:35:28
     */
    public List<EquMorApplyVo> selectEquMorApplyVos(EquMorApplyVo equMorApplyVo){
        return baseDao.selectEquMorApplyVos(equMorApplyVo);
    }

}
