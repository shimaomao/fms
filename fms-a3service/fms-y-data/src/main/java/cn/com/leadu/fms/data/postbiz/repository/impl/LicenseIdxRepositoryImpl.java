package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.LicenseIdxDao;
import cn.com.leadu.fms.data.postbiz.repository.LicenseIdxRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author license_idx
 * @ClassName: LicenseIdxRepositoryImpl
 * @Description: 指标管理表Repository 实现层
 */
@Repository
public class LicenseIdxRepositoryImpl extends AbstractBaseRepository<LicenseIdxDao, LicenseIdx> implements LicenseIdxRepository {

    /**
     * @Title:
     * @Description: 新增指标管理表
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int insertData(LicenseIdx licenseIdx) {
        return super.insert(licenseIdx);
    }

    /**
     * @Title:
     * @Description: 批量保存指标管理表
     * @param licenseIdxs
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int insertDataList(List<LicenseIdx> licenseIdxs){
        return super.insertListByJdbcTemplate(licenseIdxs);
    }

    /**
     * @Title:
     * @Description: 修改指标管理表
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeyData(LicenseIdx licenseIdx) {
        return super.updateByPrimaryKey(licenseIdx);
    }

    /**
     * @Title:
     * @Description: 批量修改指标管理表
     * @param licenseIdxs
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LicenseIdx> licenseIdxs){
        return super.updateListByPrimaryKey(licenseIdxs);
    }

    /**
     * @Title:
     * @Description: 动态修改指标管理表
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LicenseIdx licenseIdx) {
        return super.updateByPrimaryKeySelective(licenseIdx);
    }

    /**
     * @Title:
     * @Description: 批量动态修改指标管理表
     * @param licenseIdxs
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LicenseIdx> licenseIdxs) {
        return super.updateListByPrimaryKeySelective(licenseIdxs);
    }

    /**
     * @Title:
     * @Description: 根据条件修改指标管理表
     * @param licenseIdx
     * @param example
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByExampleData(LicenseIdx licenseIdx, Example example) {
        return super.updateByExample(licenseIdx,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改指标管理表
     * @param licenseIdx
     * @param example
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByExampleSelectiveData(LicenseIdx licenseIdx, Example example){
        return super.updateByExampleSelective(licenseIdx,example);
    }
    
    /**
     * @Title:
     * @Description: 根据licenseIdxId删除指标管理表
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int deleteData(LicenseIdx licenseIdx) {
        return super.delete(licenseIdx);
    }

    /**
     * @Title:
     * @Description: 根据licenseIdxId集合批量删除指标管理表
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int deleteDataList(List licenseIdxIds,LicenseIdx licenseIdx){
        return super.deleteByIds(licenseIdxIds,licenseIdx);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除指标管理表
     * @param example
     * @param licenseIdx
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int deleteExampleData(Example example,LicenseIdx licenseIdx){
        return super.deleteByExample(example,licenseIdx);
    }

    /**
     * @Title:
     * @Description: 查询全部指标管理表
     * @return List<LicenseIdx>
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public List<LicenseIdx> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个指标管理表
     * @param example
     * @return LicenseIdx
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public LicenseIdx selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询指标管理表
     * @param example
     * @return List<LicenseIdx>
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public List<LicenseIdx> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过licenseIdxId查询指标管理表
     * @param licenseIdxId
     * @return LicenseIdx
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public LicenseIdx selectByPrimaryKey(Object licenseIdxId) {
        return super.selectByPrimaryKey(licenseIdxId);
    }

    /**
     * @Title:
     * @Description: 分页查询指标管理表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<LicenseIdx>
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public PageInfoExtend<LicenseIdx> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询指标管理表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改指标管理表
     * @param licenseIdx,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeyData(LicenseIdx licenseIdx,boolean exclusive) {
        return super.updateByPrimaryKey(licenseIdx,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改指标管理表,并进行排他
     * @param licenseIdxs
     * @param exclusive
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeyDataList(List<LicenseIdx> licenseIdxs,boolean exclusive){
        return super.updateListByPrimaryKey(licenseIdxs,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改指标管理表,并进行排他
     * @param licenseIdx
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(LicenseIdx licenseIdx,boolean exclusive) {
        return super.updateByPrimaryKeySelective(licenseIdx,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改指标管理表,并进行排他
     * @param licenseIdxs
     * @param exclusive
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<LicenseIdx> licenseIdxs,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(licenseIdxs,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改指标管理表,并进行排他
     * @param licenseIdx
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByExampleData(LicenseIdx licenseIdx, Example example,boolean exclusive) {
        return super.updateByExample(licenseIdx,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改指标管理表,并进行排他
     * @param licenseIdx
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author license_idx
     * @date 2018-9-11 11:38:16
     */
    @Override
    public int updateByExampleSelectiveData(LicenseIdx licenseIdx, Example example,boolean exclusive){
        return super.updateByExampleSelective(licenseIdx,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 通过licenseIdxId查询指标管理表
     * @param licenseIdxId
     * @return LicenseIdx
     * @throws
     * @author license_idx
     * @date 2018-9-12 13:38:16
     */
    @Override
    public LicenseIdxVo selectVoByPrimaryKey(String licenseIdxId) {
        return baseDao.selectLicenseIdxVoById(licenseIdxId);
    }

    /**
     * @Title:
     * @Description:  根据licenseIdxNo获取指标管理表是否存在
     * @param licenseIdxNo
     * @return
     * @throws
     * @author license_idx
     * @date 2018-9-13 11:38:16
     */
    @Override
    public LicenseIdxVo selectLicenseIdxNoByPrimaryKey(String licenseIdxNo) {
        return baseDao.selectLicenseIdxNoById(licenseIdxNo);
    }

}
