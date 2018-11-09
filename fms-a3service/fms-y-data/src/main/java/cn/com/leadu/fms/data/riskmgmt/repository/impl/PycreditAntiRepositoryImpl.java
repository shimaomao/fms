package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditAntiDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditAntiRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAntiRepositoryImpl
 * @Description: 反欺诈分析Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditAntiRepositoryImpl extends AbstractBaseRepository<PycreditAntiDao, PycreditAnti> implements PycreditAntiRepository {

    /**
     * @Title:
     * @Description: 新增反欺诈分析
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int insertData(PycreditAnti pycreditAnti) {
        return super.insert(pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 批量保存反欺诈分析
     * @param pycreditAntis
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int insertDataList(List<PycreditAnti> pycreditAntis){
        return super.insertListByJdbcTemplate(pycreditAntis);
    }

    /**
     * @Title:
     * @Description: 修改反欺诈分析
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeyData(PycreditAnti pycreditAnti) {
        return super.updateByPrimaryKey(pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 批量修改反欺诈分析
     * @param pycreditAntis
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditAnti> pycreditAntis){
        return super.updateListByPrimaryKey(pycreditAntis);
    }

    /**
     * @Title:
     * @Description: 动态修改反欺诈分析
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditAnti pycreditAnti) {
        return super.updateByPrimaryKeySelective(pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 批量动态修改反欺诈分析
     * @param pycreditAntis
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditAnti> pycreditAntis) {
        return super.updateListByPrimaryKeySelective(pycreditAntis);
    }

    /**
     * @Title:
     * @Description: 根据条件修改反欺诈分析
     * @param pycreditAnti
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByExampleData(PycreditAnti pycreditAnti, Example example) {
        return super.updateByExample(pycreditAnti,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改反欺诈分析
     * @param pycreditAnti
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByExampleSelectiveData(PycreditAnti pycreditAnti, Example example){
        return super.updateByExampleSelective(pycreditAnti,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditAntiId删除反欺诈分析
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int deleteData(PycreditAnti pycreditAnti) {
        return super.delete(pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 根据pycreditAntiId集合批量删除反欺诈分析
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int deleteDataList(List pycreditAntiIds,PycreditAnti pycreditAnti){
        return super.deleteByIds(pycreditAntiIds,pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除反欺诈分析
     * @param example
     * @param pycreditAnti
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int deleteExampleData(Example example,PycreditAnti pycreditAnti){
        return super.deleteByExample(example,pycreditAnti);
    }

    /**
     * @Title:
     * @Description: 查询全部反欺诈分析
     * @return List<PycreditAnti>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public List<PycreditAnti> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个反欺诈分析
     * @param example
     * @return PycreditAnti
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public PycreditAnti selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询反欺诈分析
     * @param example
     * @return List<PycreditAnti>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public List<PycreditAnti> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditAntiId查询反欺诈分析
     * @param pycreditAntiId
     * @return PycreditAnti
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public PycreditAnti selectByPrimaryKey(Object pycreditAntiId) {
        return super.selectByPrimaryKey(pycreditAntiId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询反欺诈分析
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditAnti>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public PageInfoExtend<PycreditAnti> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询反欺诈分析vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改反欺诈分析
     * @param pycreditAnti,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeyData(PycreditAnti pycreditAnti,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditAnti,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改反欺诈分析,并进行排他
     * @param pycreditAntis
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditAnti> pycreditAntis,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditAntis,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改反欺诈分析,并进行排他
     * @param pycreditAnti
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditAnti pycreditAnti,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditAnti,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改反欺诈分析,并进行排他
     * @param pycreditAntis
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditAnti> pycreditAntis,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditAntis,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改反欺诈分析,并进行排他
     * @param pycreditAnti
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByExampleData(PycreditAnti pycreditAnti, Example example,boolean exclusive) {
        return super.updateByExample(pycreditAnti,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改反欺诈分析,并进行排他
     * @param pycreditAnti
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:52
     */
    @Override
    public int updateByExampleSelectiveData(PycreditAnti pycreditAnti, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditAnti,example,exclusive);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改反欺诈分析,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    @Override
    public List<PycreditAnti>  selectPycreditAntiList(String documentNo,int ceilingNumber){
        return baseDao.selectPycreditAntiList(documentNo,ceilingNumber);
    }

    /**
     * @param documentNo
     * @Description: 查询最近一条查询记录
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/3 15:15
     */
    @Override
    public PycreditAnti selectLastPycreditAntiByDocumentNo(String documentNo) {
        return baseDao.selectLastPycreditAntiByDocumentNo(documentNo);
    }
}
