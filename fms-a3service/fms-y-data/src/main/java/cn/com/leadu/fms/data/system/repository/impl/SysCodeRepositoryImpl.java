package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysCodeDao;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.system.repository.SysCodeRepository;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeRepositoryImpl
 * @Description: 字典数数值Repository 实现层
 * @date 2018-03-09
 */
@Repository
public class SysCodeRepositoryImpl extends AbstractBaseRepository<SysCodeDao, SysCode> implements SysCodeRepository {

    /**
     * @Title:
     * @Description: 新增字典数数值
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int insertData(SysCode sysCode) {
        return super.insert(sysCode);
    }

    /**
     * @Title:
     * @Description: 批量保存字典数数值
     * @param sysCodes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int insertDataList(List<SysCode> sysCodes){
        return super.insertListByJdbcTemplate(sysCodes);
    }

    /**
     * @Title:
     * @Description: 修改字典数数值
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int updateByPrimaryKeyData(SysCode sysCode) {
        return super.updateByPrimaryKey(sysCode);
    }

    /**
     * @Title:
     * @Description: 批量修改字典数数值
     * @param sysCodes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysCode> sysCodes){
        return super.updateListByPrimaryKey(sysCodes);
    }

    /**
     * @Title:
     * @Description: 动态修改字典数数值
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysCode sysCode) {
        return super.updateByPrimaryKeySelective(sysCode);
    }

    /**
     * @Title:
     * @Description: 批量动态修改字典数数值
     * @param sysCodes
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysCode> sysCodes) {
        return super.updateListByPrimaryKeySelective(sysCodes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改字典数数值
     * @param sysCode
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int updateByExampleData(SysCode sysCode, Example example) {
        return super.updateByExample(sysCode,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改字典数数值
     * @param sysCode
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int updateByExampleSelectiveData(SysCode sysCode, Example example){
        return super.updateByExampleSelective(sysCode,example);
    }
    
    /**
     * @Title:
     * @Description: 根据codeValueId删除字典数数值
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public int deleteData(SysCode sysCode) {
        return super.delete(sysCode);
    }

    /**
     * @Title:
     * @Description: 虚拟删除 根据定义的列名删除
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public int deleteByIds(List ids,SysCode sysCode,String primaryKey){
        return super.deleteByIds(ids,sysCode,primaryKey);
    }
    /**
     * @Title:
     * @Description: 根据codeValueId集合批量删除字典数数值
     * @param sysCode
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public int deleteDataList(List codeValueIds,SysCode sysCode){
        return super.deleteByIds(codeValueIds,sysCode);
    }

    /**
     *  根据条件删除
     * @param example
     * @param sysCode
     * @return
     */
    public int deleteExampleData(Example example,SysCode sysCode){
        return super.deleteByExample(example,sysCode);
    }

    /**
     * @Title:
     * @Description: 查询全部字典数数值
     * @return List<SysCode>
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public List<SysCode> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个字典数数值
     * @param example
     * @return SysCode
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public SysCode selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询字典数数值
     * @param example
     * @return List<SysCode>
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public List<SysCode> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过codeValueId查询字典数数值
     * @param codeValueId
     * @return SysCode
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public SysCode selectByPrimaryKey(Object codeValueId) {
        return super.selectByPrimaryKey(codeValueId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询字典数数值
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysCode>
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    @Override
    public PageInfoExtend<SysCode> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询字典数数值vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysCode>
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public PageInfoExtend<SysCodeVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public SysCodeVo selectSysCodeVoById(String codeValueId) {
        return baseDao.selectSysCodeVoById(codeValueId);
    }

}
