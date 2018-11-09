package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysTplDao;
import cn.com.leadu.fms.data.system.repository.SysTplRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplRepositoryImpl
 * @Description: 模板管理Repository 实现层
 * @date 2018-03-12
 */
@Repository
public class SysTplRepositoryImpl extends AbstractBaseRepository<SysTplDao, SysTpl> implements SysTplRepository {

    /**
     * @Title:
     * @Description: 新增模板管理
     * @param sysTpl
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int insertData(SysTpl sysTpl) {
        return super.insert(sysTpl);
    }

    /**
     * @Title:
     * @Description: 批量保存模板管理
     * @param sysTpls
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int insertDataList(List<SysTpl> sysTpls){
        return super.insertListByJdbcTemplate(sysTpls);
    }

    /**
     * @Title:
     * @Description: 修改模板管理
     * @param sysTpl
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int updateByPrimaryKeyData(SysTpl sysTpl) {
        return super.updateByPrimaryKey(sysTpl);
    }

    /**
     * @Title:
     * @Description: 批量修改模板管理
     * @param sysTpls
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysTpl> sysTpls){
        return super.insertListByJdbcTemplate(sysTpls);
    }

    /**
     * @Title:
     * @Description: 动态修改模板管理
     * @param sysTpl
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysTpl sysTpl) {
        return super.updateByPrimaryKeySelective(sysTpl);
    }

    /**
     * @Title:
     * @Description: 批量动态修改模板管理
     * @param sysTpls
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysTpl> sysTpls) {
        return super.updateListByPrimaryKeySelective(sysTpls);
    }

    /**
     * @Title:
     * @Description: 根据条件修改模板管理
     * @param sysTpl
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int updateByExampleData(SysTpl sysTpl, Example example) {
        return super.updateByExample(sysTpl,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改模板管理
     * @param sysTpl
     * @param example
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int updateByExampleSelectiveData(SysTpl sysTpl, Example example){
        return super.updateByExampleSelective(sysTpl,example);
    }
    
    /**
     * @Title:
     * @Description: 根据tplId删除模板管理
     * @param sysTpl
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public int deleteData(SysTpl sysTpl) {
        return super.delete(sysTpl);
    }

    /**
     * @Title:
     * @Description: 根据tplId集合批量删除模板管理
     * @param sysTpl
     * @return int
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public int deleteDataList(List tplIds,SysTpl sysTpl){
        return super.deleteByIds(tplIds,sysTpl);
    }

    /**
     * @Title:
     * @Description: 查询全部模板管理
     * @return List<SysTpl>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public List<SysTpl> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个模板管理
     * @param example
     * @return SysTpl
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public SysTpl selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询模板管理
     * @param example
     * @return List<SysTpl>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public List<SysTpl> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过tplId查询模板管理
     * @param tplId
     * @return SysTpl
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public SysTpl selectByPrimaryKey(Object tplId) {
        return super.selectByPrimaryKey(tplId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询模板管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<SysTpl>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @Override
    public PageInfoExtend<SysTpl> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询模板管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<SysTplVo>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public PageInfoExtend<SysTplVo> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据模板ID 获取获取模板信息
     * @param tplId 模板ID
     * @return SysTplVo
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    @Override
    public SysTplVo selectSysTplVoByTplId(String tplId) {
        return baseDao.selectSysTplVoByTplId(tplId);
    }
}
