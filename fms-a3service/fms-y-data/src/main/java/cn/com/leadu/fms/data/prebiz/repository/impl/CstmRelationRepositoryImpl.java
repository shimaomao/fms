package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CstmRelationDao;
import cn.com.leadu.fms.data.prebiz.repository.CstmRelationRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmRelation;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CstmRelationRepositoryImpl
 * @Description: 融资申请客户关系Repository 实现层
 * @date 2018-05-16
 */
@Repository
public class CstmRelationRepositoryImpl extends AbstractBaseRepository<CstmRelationDao, CstmRelation> implements CstmRelationRepository {

    /**
     * @Title:
     * @Description: 新增融资申请客户关系
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int insertData(CstmRelation cstmRelation) {
        return super.insert(cstmRelation);
    }

    /**
     * @Title:
     * @Description: 批量保存融资申请客户关系
     * @param cstmRelations
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int insertDataList(List<CstmRelation> cstmRelations){
        return super.insertListByJdbcTemplate(cstmRelations);
    }

    /**
     * @Title:
     * @Description: 修改融资申请客户关系
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int updateByPrimaryKeyData(CstmRelation cstmRelation) {
        return super.updateByPrimaryKey(cstmRelation);
    }

    /**
     * @Title:
     * @Description: 批量修改融资申请客户关系
     * @param cstmRelations
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CstmRelation> cstmRelations){
        return super.updateListByPrimaryKey(cstmRelations);
    }

    /**
     * @Title:
     * @Description: 动态修改融资申请客户关系
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CstmRelation cstmRelation) {
        return super.updateByPrimaryKeySelective(cstmRelation);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资申请客户关系
     * @param cstmRelations
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public int updateByPrimaryKeySelectiveDataList(List<CstmRelation> cstmRelations) {
        return super.updateListByPrimaryKeySelective(cstmRelations);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资申请客户关系
     * @param cstmRelation
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int updateByExampleData(CstmRelation cstmRelation, Example example) {
        return super.updateByExample(cstmRelation,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资申请客户关系
     * @param cstmRelation
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int updateByExampleSelectiveData(CstmRelation cstmRelation, Example example){
        return super.updateByExampleSelective(cstmRelation,example);
    }
    
    /**
     * @Title:
     * @Description: 根据relationId删除融资申请客户关系
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public int deleteData(CstmRelation cstmRelation) {
        return super.delete(cstmRelation);
    }

    /**
     * @Title:
     * @Description: 根据relationId集合批量删除融资申请客户关系
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public int deleteDataList(List relationIds,CstmRelation cstmRelation){
        return super.deleteByIds(relationIds,cstmRelation);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除融资申请客户关系
     * @param example
     * @param cstmRelation
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public int deleteExampleData(Example example,CstmRelation cstmRelation){
        return super.deleteByExample(example,cstmRelation);
    }

    /**
     * @Title:
     * @Description: 查询全部融资申请客户关系
     * @return List<CstmRelation>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public List<CstmRelation> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资申请客户关系
     * @param example
     * @return CstmRelation
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public CstmRelation selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资申请客户关系
     * @param example
     * @return List<CstmRelation>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public List<CstmRelation> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过relationId查询融资申请客户关系
     * @param relationId
     * @return CstmRelation
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public CstmRelation selectByPrimaryKey(Object relationId) {
        return super.selectByPrimaryKey(relationId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资申请客户关系
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CstmRelation>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    @Override
    public PageInfoExtend<CstmRelation> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资申请客户关系vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-16 11:40:33
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
