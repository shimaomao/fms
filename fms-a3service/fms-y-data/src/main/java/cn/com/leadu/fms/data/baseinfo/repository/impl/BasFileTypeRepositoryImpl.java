package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.baseinfo.dao.BasFileTypeDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileTypeRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeRepositoryImpl
 * @Description: 附件类型管理表Repository 实现层
 * @date 2018-03-19
 */
@Repository
public class BasFileTypeRepositoryImpl extends AbstractBaseRepository<BasFileTypeDao, BasFileType> implements BasFileTypeRepository {

    /**
     * @Title:
     * @Description: 新增附件类型管理表
     * @param basFileType
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int insertData(BasFileType basFileType) {
        return super.insert(basFileType);
    }

    /**
     * @Title:
     * @Description: 批量保存附件类型管理表
     * @param basFileTypes
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int insertDataList(List<BasFileType> basFileTypes){
        return super.insertListByJdbcTemplate(basFileTypes);
    }

    /**
     * @Title:
     * @Description: 修改附件类型管理表
     * @param basFileType
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int updateByPrimaryKeyData(BasFileType basFileType) {
        return super.updateByPrimaryKey(basFileType);
    }

    /**
     * @Title:
     * @Description: 批量修改附件类型管理表
     * @param basFileTypes
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasFileType> basFileTypes){
        return super.updateListByPrimaryKey(basFileTypes);
    }

    /**
     * @Title:
     * @Description: 动态修改附件类型管理表
     * @param basFileType
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasFileType basFileType) {
        return super.updateByPrimaryKeySelective(basFileType);
    }

    /**
     * @Title:
     * @Description: 批量动态修改附件类型管理表
     * @param basFileTypes
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasFileType> basFileTypes) {
        return super.updateListByPrimaryKeySelective(basFileTypes);
    }

    /**
     * @Title:
     * @Description: 根据条件修改附件类型管理表
     * @param basFileType
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int updateByExampleData(BasFileType basFileType, Example example) {
        return super.updateByExample(basFileType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改附件类型管理表
     * @param basFileType
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int updateByExampleSelectiveData(BasFileType basFileType, Example example){
        return super.updateByExampleSelective(basFileType,example);
    }
    
    /**
     * @Title:
     * @Description: 根据fileTypeId删除附件类型管理表
     * @param basFileType
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public int deleteData(BasFileType basFileType) {
        return super.delete(basFileType);
    }

    /**
     * @Title:
     * @Description: 根据fileTypeId集合批量删除附件类型管理表
     * @param basFileType
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public int deleteDataList(List fileTypeIds,BasFileType basFileType){
        return super.deleteByIds(fileTypeIds,basFileType);
    }

    /**
     * @Title:
     * @Description: 查询全部附件类型管理表
     * @return List<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public List<BasFileType> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个附件类型管理表
     * @param example
     * @return BasFileType
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public BasFileType selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询附件类型管理表
     * @param example
     * @return List<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public List<BasFileType> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过fileTypeId查询附件类型管理表
     * @param fileTypeId
     * @return BasFileType
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public BasFileType selectByPrimaryKey(Object fileTypeId) {
        return super.selectByPrimaryKey(fileTypeId);
    }

    
    /**
     * @Title:
     * @Description: 分页查询附件类型管理表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public PageInfoExtend<BasFileType> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }


    /**
     * @Title:
     * @Description: 分页查询附件类型管理表,del_flag 在外围
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Override
    public PageInfoExtend<BasFileType> selectListByExamplePageForDel(Example example, PageQuery pageQuery){
        return super.selectListByExamplePageForDel(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询附件类型管理表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public PageInfoExtend<BasFileType> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }


    /**
     * @Title:
     * @Description: 查询附件类型管理树
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public List<BasFileTypeVo> selectBasFileTypeByTree(){
        return baseDao.selectBasFileTypeByTree();

    }

    /**
     * @Title:
     * @Description: 通过一个上级类型代码查询旗下所有层级节点的上级类型代码
     * @param parentFileType
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public List<BasFileTypeVo> selectAllNodesFromBasFileType(String parentFileType){
        return baseDao.selectAllNodesFromBasFileType(parentFileType);
    }

    /**
     * @Title:
     * @Description: 通过上级类型代码获得下一级子节点集合
     * @param parentFileType
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public List<BasFileTypeVo> selectNextBasFileTypeVosByParentFileType(String parentFileType){
        return baseDao.selectNextBasFileTypeVosByParentFileType(parentFileType);
    }

    /**
     * @Title:
     * @Description: 根据fileTypeId获取BasFileTypeVo
     * @param fileTypeId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public BasFileTypeVo selectBasFileTypeVoByPrimaryKey(String fileTypeId){
        return baseDao.selectBasFileTypeVoByPrimaryKey(fileTypeId);
    }

    /**
     * @Title:
     * @Description:  根据产品代码取得获取BasFileTypeVo
     * @param product 产品代码
     * @return
     * @throws
     * @author wangxue
     * @date 2018-4-26 22:06:58
     */
    @Override
    public List<BasFileTypeVo> selectBasFileTypeVoByProduct(String product) {
        return baseDao.selectBasFileTypeVoByProduct(product);
    }

    /**
     * @Title:
     * @Description:  取得获取所有BasFileType，并按照orderno进行排序
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-4-26 22:06:58
     */
    @Override
    public List<BasFileType> selectAllBasFileTypeList() {
        return baseDao.selectAllBasFileTypeList();
    }
}
