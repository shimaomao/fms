package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinBackfillDao;
import cn.com.leadu.fms.data.finance.repository.FinBackfillRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVoExcel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillRepositoryImpl
 * @Description: 融资回填Repository 实现层
 * @date 2018-05-11
 */
@Repository
public class FinBackfillRepositoryImpl extends AbstractBaseRepository<FinBackfillDao, FinBackfill> implements FinBackfillRepository {

    /**
     * @Title:
     * @Description: 新增融资回填
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int insertData(FinBackfill finBackfill) {
        return super.insert(finBackfill);
    }

    /**
     * @Title:
     * @Description: 批量保存融资回填
     * @param finBackfills
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int insertDataList(List<FinBackfill> finBackfills){
        return super.insertListByJdbcTemplate(finBackfills);
    }

    /**
     * @Title:
     * @Description: 修改融资回填
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int updateByPrimaryKeyData(FinBackfill finBackfill) {
        return super.updateByPrimaryKey(finBackfill);
    }

    /**
     * @Title:
     * @Description: 批量修改融资回填
     * @param finBackfills
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinBackfill> finBackfills){
        return super.updateListByPrimaryKey(finBackfills);
    }

    /**
     * @Title:
     * @Description: 动态修改融资回填
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinBackfill finBackfill) {
        return super.updateByPrimaryKeySelective(finBackfill);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资回填
     * @param finBackfills
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public int updateByPrimaryKeySelectiveDataList(List<FinBackfill> finBackfills) {
        return super.updateListByPrimaryKeySelective(finBackfills);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资回填
     * @param finBackfill
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int updateByExampleData(FinBackfill finBackfill, Example example) {
        return super.updateByExample(finBackfill,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资回填
     * @param finBackfill
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int updateByExampleSelectiveData(FinBackfill finBackfill, Example example){
        return super.updateByExampleSelective(finBackfill,example);
    }
    
    /**
     * @Title:
     * @Description: 根据filBackfillId删除融资回填
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public int deleteData(FinBackfill finBackfill) {
        return super.delete(finBackfill);
    }

    /**
     * @Title:
     * @Description: 根据filBackfillId集合批量删除融资回填
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public int deleteDataList(List filBackfillIds,FinBackfill finBackfill){
        return super.deleteByIds(filBackfillIds,finBackfill);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除融资回填
     * @param example
     * @param finBackfill
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public int deleteExampleData(Example example,FinBackfill finBackfill){
        return super.deleteByExample(example,finBackfill);
    }

    /**
     * @Title:
     * @Description: 查询全部融资回填
     * @return List<FinBackfill>
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public List<FinBackfill> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资回填
     * @param example
     * @return FinBackfill
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public FinBackfill selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资回填
     * @param example
     * @return List<FinBackfill>
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public List<FinBackfill> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过filBackfillId查询融资回填
     * @param filBackfillId
     * @return FinBackfill
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public FinBackfill selectByPrimaryKey(Object filBackfillId) {
        return super.selectByPrimaryKey(filBackfillId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资回填
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinBackfill>
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Override
    public PageInfoExtend<FinBackfill> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资回填vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资回填vo
     * @param filBackfillId
     * @return FinBackfillVo
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public FinBackfillVo selectFinBackfillByFilBackfillId(String filBackfillId){
        return baseDao.selectFinBackfillByFilBackfillId(filBackfillId);
    }

    /**
     * @Title:
     * @Description: 根据财务回填信息获取融资还款计划信息
     * @param contRepaySkedVo
     * @return ContRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public List<ContRepaySkedVo> selectContRepaySkedByfinBackfillVo(ContRepaySkedVo contRepaySkedVo){
        return baseDao.selectContRepaySkedByfinBackfillVo(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVo
     * @return
     * @throws
     * @author yanfengbo
     */
    public List<FinBackfillVoExcel> selectFinBackfillsForExportExcel(FinBackfillVo finBackfillVo){
        return baseDao.selectFinBackfillsForExportExcel(finBackfillVo);
    }
}
