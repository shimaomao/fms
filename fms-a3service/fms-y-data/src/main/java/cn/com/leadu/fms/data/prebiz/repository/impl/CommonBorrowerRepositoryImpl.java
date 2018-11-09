package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.CommonBorrowerDao;
import cn.com.leadu.fms.data.prebiz.repository.CommonBorrowerRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerRepositoryImpl
 * @Description: 共同借款人Repository 实现层
 * @date 2018-05-25
 */
@Repository
public class CommonBorrowerRepositoryImpl extends AbstractBaseRepository<CommonBorrowerDao, CommonBorrower> implements CommonBorrowerRepository {

    /**
     * @Title:
     * @Description: 新增共同借款人
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int insertData(CommonBorrower commonBorrower) {
        return super.insert(commonBorrower);
    }

    /**
     * @Title:
     * @Description: 批量保存共同借款人
     * @param commonBorrowers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int insertDataList(List<CommonBorrower> commonBorrowers){
        return super.insertListByJdbcTemplate(commonBorrowers);
    }

    /**
     * @Title:
     * @Description: 修改共同借款人
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int updateByPrimaryKeyData(CommonBorrower commonBorrower) {
        return super.updateByPrimaryKey(commonBorrower);
    }

    /**
     * @Title:
     * @Description: 批量修改共同借款人
     * @param commonBorrowers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<CommonBorrower> commonBorrowers){
        return super.updateListByPrimaryKey(commonBorrowers);
    }

    /**
     * @Title:
     * @Description: 动态修改共同借款人
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int updateByPrimaryKeySelectiveData(CommonBorrower commonBorrower) {
        return super.updateByPrimaryKeySelective(commonBorrower);
    }

    /**
     * @Title:
     * @Description: 批量动态修改共同借款人
     * @param commonBorrowers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    public int updateByPrimaryKeySelectiveDataList(List<CommonBorrower> commonBorrowers) {
        return super.updateListByPrimaryKeySelective(commonBorrowers);
    }

    /**
     * @Title:
     * @Description: 根据条件修改共同借款人
     * @param commonBorrower
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int updateByExampleData(CommonBorrower commonBorrower, Example example) {
        return super.updateByExample(commonBorrower,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改共同借款人
     * @param commonBorrower
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int updateByExampleSelectiveData(CommonBorrower commonBorrower, Example example){
        return super.updateByExampleSelective(commonBorrower,example);
    }
    
    /**
     * @Title:
     * @Description: 根据comBorrowerId删除共同借款人
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public int deleteData(CommonBorrower commonBorrower) {
        return super.delete(commonBorrower);
    }

    /**
     * @Title:
     * @Description: 根据comBorrowerId集合批量删除共同借款人
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    public int deleteDataList(List comBorrowerIds,CommonBorrower commonBorrower){
        return super.deleteByIds(comBorrowerIds,commonBorrower);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除共同借款人
     * @param example
     * @param commonBorrower
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    public int deleteExampleData(Example example,CommonBorrower commonBorrower){
        return super.deleteByExample(example,commonBorrower);
    }

    /**
     * @Title:
     * @Description: 查询全部共同借款人
     * @return List<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public List<CommonBorrower> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个共同借款人
     * @param example
     * @return CommonBorrower
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public CommonBorrower selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询共同借款人
     * @param example
     * @return List<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public List<CommonBorrower> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过comBorrowerId查询共同借款人
     * @param comBorrowerId
     * @return CommonBorrower
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public CommonBorrower selectByPrimaryKey(Object comBorrowerId) {
        return super.selectByPrimaryKey(comBorrowerId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询共同借款人
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<CommonBorrower>
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @Override
    public PageInfoExtend<CommonBorrower> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询共同借款人vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
