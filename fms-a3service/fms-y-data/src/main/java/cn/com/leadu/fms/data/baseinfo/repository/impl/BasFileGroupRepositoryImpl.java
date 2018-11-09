package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.BasFileGroupDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileGroupRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupRepositoryImpl
 * @Description: 附件组Repository 实现层
 */
@Repository
public class BasFileGroupRepositoryImpl extends AbstractBaseRepository<BasFileGroupDao, BasFileGroup> implements BasFileGroupRepository {

    /**
     * @Title:
     * @Description: 新增附件组
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int insertData(BasFileGroup basFileGroup) {
        return super.insert(basFileGroup);
    }

    /**
     * @Title:
     * @Description: 批量保存附件组
     * @param basFileGroups
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int insertDataList(List<BasFileGroup> basFileGroups){
        return super.insertListByJdbcTemplate(basFileGroups);
    }

    /**
     * @Title:
     * @Description: 修改附件组
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeyData(BasFileGroup basFileGroup) {
        return super.updateByPrimaryKey(basFileGroup);
    }

    /**
     * @Title:
     * @Description: 批量修改附件组
     * @param basFileGroups
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasFileGroup> basFileGroups){
        return super.updateListByPrimaryKey(basFileGroups);
    }

    /**
     * @Title:
     * @Description: 动态修改附件组
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasFileGroup basFileGroup) {
        return super.updateByPrimaryKeySelective(basFileGroup);
    }

    /**
     * @Title:
     * @Description: 批量动态修改附件组
     * @param basFileGroups
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BasFileGroup> basFileGroups) {
        return super.updateListByPrimaryKeySelective(basFileGroups);
    }

    /**
     * @Title:
     * @Description: 根据条件修改附件组
     * @param basFileGroup
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByExampleData(BasFileGroup basFileGroup, Example example) {
        return super.updateByExample(basFileGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改附件组
     * @param basFileGroup
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByExampleSelectiveData(BasFileGroup basFileGroup, Example example){
        return super.updateByExampleSelective(basFileGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据basFileGroupId删除附件组
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int deleteData(BasFileGroup basFileGroup) {
        return super.delete(basFileGroup);
    }

    /**
     * @Title:
     * @Description: 根据basFileGroupId集合批量删除附件组
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int deleteDataList(List basFileGroupIds,BasFileGroup basFileGroup){
        return super.deleteByIds(basFileGroupIds,basFileGroup);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除附件组
     * @param example
     * @param basFileGroup
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int deleteExampleData(Example example,BasFileGroup basFileGroup){
        return super.deleteByExample(example,basFileGroup);
    }

    /**
     * @Title:
     * @Description: 查询全部附件组
     * @return List<BasFileGroup>
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public List<BasFileGroup> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个附件组
     * @param example
     * @return BasFileGroup
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public BasFileGroup selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询附件组
     * @param example
     * @return List<BasFileGroup>
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public List<BasFileGroup> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过basFileGroupId查询附件组
     * @param basFileGroupId
     * @return BasFileGroup
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public BasFileGroup selectByPrimaryKey(Object basFileGroupId) {
        return super.selectByPrimaryKey(basFileGroupId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询附件组
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasFileGroup>
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public PageInfoExtend<BasFileGroup> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询附件组vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改附件组
     * @param basFileGroup,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeyData(BasFileGroup basFileGroup,boolean exclusive) {
        return super.updateByPrimaryKey(basFileGroup,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改附件组,并进行排他
     * @param basFileGroups
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasFileGroup> basFileGroups,boolean exclusive){
        return super.updateListByPrimaryKey(basFileGroups,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改附件组,并进行排他
     * @param basFileGroup
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasFileGroup basFileGroup,boolean exclusive) {
        return super.updateByPrimaryKeySelective(basFileGroup,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改附件组,并进行排他
     * @param basFileGroups
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<BasFileGroup> basFileGroups,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(basFileGroups,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改附件组,并进行排他
     * @param basFileGroup
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByExampleData(BasFileGroup basFileGroup, Example example,boolean exclusive) {
        return super.updateByExample(basFileGroup,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改附件组,并进行排他
     * @param basFileGroup
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @Override
    public int updateByExampleSelectiveData(BasFileGroup basFileGroup, Example example,boolean exclusive){
        return super.updateByExampleSelective(basFileGroup,example,exclusive);
    }

    /**
     * @Title:
     * @Description:  查询附件类型下一级子类附件
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-30 22:06:58
     */
    @Override
    public List<BasFileTypeVo> selectBasFileTypeChiByFileType(String fileType) {
        return baseDao.selectBasFileTypeChiByFileType(fileType);
    }

}
