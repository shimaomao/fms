package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.PersonBasicChangeDao;
import cn.com.leadu.fms.data.postbiz.repository.PersonBasicChangeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.PersonBasicChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.personbasicchange.PersonBasicChangeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: PersonBasicChangeRepositoryImpl
 * @Description: 个人基本信息变更表Repository 实现层
 * @date 2018-08-31
 */
@Repository
public class PersonBasicChangeRepositoryImpl extends AbstractBaseRepository<PersonBasicChangeDao, PersonBasicChange> implements PersonBasicChangeRepository {

    /**
     * @Title:
     * @Description: 新增个人基本信息变更表
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int insertData(PersonBasicChange personBasicChange) {
        return super.insert(personBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量保存个人基本信息变更表
     * @param personBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int insertDataList(List<PersonBasicChange> personBasicChanges){
        return super.insertListByJdbcTemplate(personBasicChanges);
    }

    /**
     * @Title:
     * @Description: 修改个人基本信息变更表
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeyData(PersonBasicChange personBasicChange) {
        return super.updateByPrimaryKey(personBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量修改个人基本信息变更表
     * @param personBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PersonBasicChange> personBasicChanges){
        return super.updateListByPrimaryKey(personBasicChanges);
    }

    /**
     * @Title:
     * @Description: 动态修改个人基本信息变更表
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PersonBasicChange personBasicChange) {
        return super.updateByPrimaryKeySelective(personBasicChange);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人基本信息变更表
     * @param personBasicChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PersonBasicChange> personBasicChanges) {
        return super.updateListByPrimaryKeySelective(personBasicChanges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人基本信息变更表
     * @param personBasicChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByExampleData(PersonBasicChange personBasicChange, Example example) {
        return super.updateByExample(personBasicChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改个人基本信息变更表
     * @param personBasicChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByExampleSelectiveData(PersonBasicChange personBasicChange, Example example){
        return super.updateByExampleSelective(personBasicChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据personChangeId删除个人基本信息变更表
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int deleteData(PersonBasicChange personBasicChange) {
        return super.delete(personBasicChange);
    }

    /**
     * @Title:
     * @Description: 根据personChangeId集合批量删除个人基本信息变更表
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int deleteDataList(List personChangeIds,PersonBasicChange personBasicChange){
        return super.deleteByIds(personChangeIds,personBasicChange);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除个人基本信息变更表
     * @param example
     * @param personBasicChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int deleteExampleData(Example example,PersonBasicChange personBasicChange){
        return super.deleteByExample(example,personBasicChange);
    }

    /**
     * @Title:
     * @Description: 查询全部个人基本信息变更表
     * @return List<PersonBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public List<PersonBasicChange> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个个人基本信息变更表
     * @param example
     * @return PersonBasicChange
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public PersonBasicChange selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询个人基本信息变更表
     * @param example
     * @return List<PersonBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public List<PersonBasicChange> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过personChangeId查询个人基本信息变更表
     * @param personChangeId
     * @return PersonBasicChange
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public PersonBasicChange selectByPrimaryKey(Object personChangeId) {
        return super.selectByPrimaryKey(personChangeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询个人基本信息变更表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PersonBasicChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public PageInfoExtend<PersonBasicChange> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询个人基本信息变更表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改个人基本信息变更表
     * @param personBasicChange,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeyData(PersonBasicChange personBasicChange,boolean exclusive) {
        return super.updateByPrimaryKey(personBasicChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改个人基本信息变更表,并进行排他
     * @param personBasicChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PersonBasicChange> personBasicChanges,boolean exclusive){
        return super.updateListByPrimaryKey(personBasicChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改个人基本信息变更表,并进行排他
     * @param personBasicChange
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PersonBasicChange personBasicChange,boolean exclusive) {
        return super.updateByPrimaryKeySelective(personBasicChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人基本信息变更表,并进行排他
     * @param personBasicChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PersonBasicChange> personBasicChanges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(personBasicChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人基本信息变更表,并进行排他
     * @param personBasicChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByExampleData(PersonBasicChange personBasicChange, Example example,boolean exclusive) {
        return super.updateByExample(personBasicChange,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改个人基本信息变更表,并进行排他
     * @param personBasicChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-31 18:16:22
     */
    @Override
    public int updateByExampleSelectiveData(PersonBasicChange personBasicChange, Example example,boolean exclusive){
        return super.updateByExampleSelective(personBasicChange,example,exclusive);
    }

    /**
     * 根据申请编号获取个人基本信息
     *
     * @param applyNo
     * @return
     */
    @Override
    public PersonBasicChangeVo selectPersonBasicChangeByApplyNo(String applyNo) {
        return baseDao.selectPersonBasicChangeByApplyNo(applyNo);
    }

}
