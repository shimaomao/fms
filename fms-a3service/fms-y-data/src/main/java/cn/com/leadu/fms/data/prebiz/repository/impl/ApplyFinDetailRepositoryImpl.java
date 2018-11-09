package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ApplyFinDetailDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyFinDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailRepositoryImpl
 * @Description: 融资费用明细信息Repository 实现层
 * @date 2018-03-24
 */
@Repository
public class ApplyFinDetailRepositoryImpl extends AbstractBaseRepository<ApplyFinDetailDao, ApplyFinDetail> implements ApplyFinDetailRepository {

    /**
     * @Title:
     * @Description: 新增融资费用明细信息
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int insertData(ApplyFinDetail applyFinDetail) {
        return super.insert(applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存融资费用明细信息
     * @param applyFinDetails
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int insertDataList(List<ApplyFinDetail> applyFinDetails){
        return super.insertListByJdbcTemplate(applyFinDetails);
    }

    /**
     * @Title:
     * @Description: 修改融资费用明细信息
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int updateByPrimaryKeyData(ApplyFinDetail applyFinDetail) {
        return super.updateByPrimaryKey(applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改融资费用明细信息
     * @param applyFinDetails
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ApplyFinDetail> applyFinDetails){
        return super.insertListByJdbcTemplate(applyFinDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改融资费用明细信息
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ApplyFinDetail applyFinDetail) {
        return super.updateByPrimaryKeySelective(applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资费用明细信息
     * @param applyFinDetails
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public int updateByPrimaryKeySelectiveDataList(List<ApplyFinDetail> applyFinDetails) {
        return super.updateListByPrimaryKeySelective(applyFinDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资费用明细信息
     * @param applyFinDetail
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int updateByExampleData(ApplyFinDetail applyFinDetail, Example example) {
        return super.updateByExample(applyFinDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资费用明细信息
     * @param applyFinDetail
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int updateByExampleSelectiveData(ApplyFinDetail applyFinDetail, Example example){
        return super.updateByExampleSelective(applyFinDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据applyFinDetailId删除融资费用明细信息
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int deleteData(ApplyFinDetail applyFinDetail) {
        return super.delete(applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 根据applyFinDetailId集合批量删除融资费用明细信息
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public int deleteDataList(List applyFinDetailIds,ApplyFinDetail applyFinDetail){
        return super.deleteByIds(applyFinDetailIds,applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 根据条件删除融资费用明细信息
     * @param example
     * @param applyFinDetail
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int deleteByExample(Example example, ApplyFinDetail applyFinDetail) {
        return super.deleteByExample(example, applyFinDetail);
    }

    /**
     * @Title:
     * @Description: 根据applyFinDetailId集合批量删除融资费用明细信息 物理删除
     * @param applyFinDetailIds
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public int deletePhysicsEntityList(List applyFinDetailIds) {
        return super.deletePhysicsEntityList(applyFinDetailIds);
    }

    /**
     * @Title:
     * @Description: 查询全部融资费用明细信息
     * @return List<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public List<ApplyFinDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资费用明细信息
     * @param example
     * @return ApplyFinDetail
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public ApplyFinDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资费用明细信息
     * @param example
     * @return List<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public List<ApplyFinDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过applyFinDetailId查询融资费用明细信息
     * @param applyFinDetailId
     * @return ApplyFinDetail
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public ApplyFinDetail selectByPrimaryKey(Object applyFinDetailId) {
        return super.selectByPrimaryKey(applyFinDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资费用明细信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public PageInfoExtend<ApplyFinDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资费用明细信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public PageInfoExtend<ApplyFinDetail> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资费用明细信息
     * @param applyNo 订单编号
     * @return List<ApplyFinDetailVo>
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    @Override
    public List<ApplyFinDetailVo> selectApplyFinDetailVosByApplyNo(String applyNo) {
        return baseDao.selectApplyFinDetailVosByApplyNo(applyNo);
    }
}
