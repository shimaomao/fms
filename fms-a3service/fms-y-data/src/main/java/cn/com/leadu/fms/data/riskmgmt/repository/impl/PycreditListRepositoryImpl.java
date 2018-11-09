package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PycreditListDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditListRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditList;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditListRepositoryImpl
 * @Description: 鹏元查询一览Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PycreditListRepositoryImpl extends AbstractBaseRepository<PycreditListDao, PycreditList> implements PycreditListRepository {

    /**
     * @Title:
     * @Description: 新增鹏元查询一览
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int insertData(PycreditList pycreditList) {
        return super.insert(pycreditList);
    }

    /**
     * @Title:
     * @Description: 批量保存鹏元查询一览
     * @param pycreditLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int insertDataList(List<PycreditList> pycreditLists){
        return super.insertListByJdbcTemplate(pycreditLists);
    }

    /**
     * @Title:
     * @Description: 修改鹏元查询一览
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeyData(PycreditList pycreditList) {
        return super.updateByPrimaryKey(pycreditList);
    }

    /**
     * @Title:
     * @Description: 批量修改鹏元查询一览
     * @param pycreditLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditList> pycreditLists){
        return super.updateListByPrimaryKey(pycreditLists);
    }

    /**
     * @Title:
     * @Description: 动态修改鹏元查询一览
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditList pycreditList) {
        return super.updateByPrimaryKeySelective(pycreditList);
    }

    /**
     * @Title:
     * @Description: 批量动态修改鹏元查询一览
     * @param pycreditLists
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditList> pycreditLists) {
        return super.updateListByPrimaryKeySelective(pycreditLists);
    }

    /**
     * @Title:
     * @Description: 根据条件修改鹏元查询一览
     * @param pycreditList
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByExampleData(PycreditList pycreditList, Example example) {
        return super.updateByExample(pycreditList,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改鹏元查询一览
     * @param pycreditList
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByExampleSelectiveData(PycreditList pycreditList, Example example){
        return super.updateByExampleSelective(pycreditList,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pycreditId删除鹏元查询一览
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int deleteData(PycreditList pycreditList) {
        return super.delete(pycreditList);
    }

    /**
     * @Title:
     * @Description: 根据pycreditId集合批量删除鹏元查询一览
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int deleteDataList(List pycreditIds,PycreditList pycreditList){
        return super.deleteByIds(pycreditIds,pycreditList);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除鹏元查询一览
     * @param example
     * @param pycreditList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int deleteExampleData(Example example,PycreditList pycreditList){
        return super.deleteByExample(example,pycreditList);
    }

    /**
     * @Title:
     * @Description: 查询全部鹏元查询一览
     * @return List<PycreditList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public List<PycreditList> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个鹏元查询一览
     * @param example
     * @return PycreditList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public PycreditList selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询鹏元查询一览
     * @param example
     * @return List<PycreditList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public List<PycreditList> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pycreditId查询鹏元查询一览
     * @param pycreditId
     * @return PycreditList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public PycreditList selectByPrimaryKey(Object pycreditId) {
        return super.selectByPrimaryKey(pycreditId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询鹏元查询一览
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PycreditList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public PageInfoExtend<PycreditList> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询鹏元查询一览vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改鹏元查询一览
     * @param pycreditList,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeyData(PycreditList pycreditList,boolean exclusive) {
        return super.updateByPrimaryKey(pycreditList,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改鹏元查询一览,并进行排他
     * @param pycreditLists
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PycreditList> pycreditLists,boolean exclusive){
        return super.updateListByPrimaryKey(pycreditLists,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改鹏元查询一览,并进行排他
     * @param pycreditList
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PycreditList pycreditList,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pycreditList,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改鹏元查询一览,并进行排他
     * @param pycreditLists
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PycreditList> pycreditLists,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pycreditLists,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改鹏元查询一览,并进行排他
     * @param pycreditList
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByExampleData(PycreditList pycreditList, Example example,boolean exclusive) {
        return super.updateByExample(pycreditList,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改鹏元查询一览,并进行排他
     * @param pycreditList
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public int updateByExampleSelectiveData(PycreditList pycreditList, Example example,boolean exclusive){
        return super.updateByExampleSelective(pycreditList,example,exclusive);
    }

}
