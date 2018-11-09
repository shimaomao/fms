package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.PbcCreditDao;
import cn.com.leadu.fms.data.riskmgmt.repository.PbcCreditRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PbcCreditRepositoryImpl
 * @Description: 个人人行征信信息Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class PbcCreditRepositoryImpl extends AbstractBaseRepository<PbcCreditDao, PbcCredit> implements PbcCreditRepository {

    /**
     * @Title:
     * @Description: 新增个人人行征信信息
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int insertData(PbcCredit pbcCredit) {
        return super.insert(pbcCredit);
    }

    /**
     * @Title:
     * @Description: 批量保存个人人行征信信息
     * @param pbcCredits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int insertDataList(List<PbcCredit> pbcCredits){
        return super.insertListByJdbcTemplate(pbcCredits);
    }

    /**
     * @Title:
     * @Description: 修改个人人行征信信息
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeyData(PbcCredit pbcCredit) {
        return super.updateByPrimaryKey(pbcCredit);
    }

    /**
     * @Title:
     * @Description: 批量修改个人人行征信信息
     * @param pbcCredits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PbcCredit> pbcCredits){
        return super.updateListByPrimaryKey(pbcCredits);
    }

    /**
     * @Title:
     * @Description: 动态修改个人人行征信信息
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PbcCredit pbcCredit) {
        return super.updateByPrimaryKeySelective(pbcCredit);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人人行征信信息
     * @param pbcCredits
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PbcCredit> pbcCredits) {
        return super.updateListByPrimaryKeySelective(pbcCredits);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人人行征信信息
     * @param pbcCredit
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByExampleData(PbcCredit pbcCredit, Example example) {
        return super.updateByExample(pbcCredit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改个人人行征信信息
     * @param pbcCredit
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByExampleSelectiveData(PbcCredit pbcCredit, Example example){
        return super.updateByExampleSelective(pbcCredit,example);
    }
    
    /**
     * @Title:
     * @Description: 根据pbcCreditId删除个人人行征信信息
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int deleteData(PbcCredit pbcCredit) {
        return super.delete(pbcCredit);
    }

    /**
     * @Title:
     * @Description: 根据pbcCreditId集合批量删除个人人行征信信息
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int deleteDataList(List pbcCreditIds,PbcCredit pbcCredit){
        return super.deleteByIds(pbcCreditIds,pbcCredit);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除个人人行征信信息
     * @param example
     * @param pbcCredit
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int deleteExampleData(Example example,PbcCredit pbcCredit){
        return super.deleteByExample(example,pbcCredit);
    }

    /**
     * @Title:
     * @Description: 查询全部个人人行征信信息
     * @return List<PbcCredit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public List<PbcCredit> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个个人人行征信信息
     * @param example
     * @return PbcCredit
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public PbcCredit selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询个人人行征信信息
     * @param example
     * @return List<PbcCredit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public List<PbcCredit> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过pbcCreditId查询个人人行征信信息
     * @param pbcCreditId
     * @return PbcCredit
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public PbcCredit selectByPrimaryKey(Object pbcCreditId) {
        return super.selectByPrimaryKey(pbcCreditId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询个人人行征信信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<PbcCredit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public PageInfoExtend<PbcCredit> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询个人人行征信信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改个人人行征信信息
     * @param pbcCredit,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeyData(PbcCredit pbcCredit,boolean exclusive) {
        return super.updateByPrimaryKey(pbcCredit,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改个人人行征信信息,并进行排他
     * @param pbcCredits
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeyDataList(List<PbcCredit> pbcCredits,boolean exclusive){
        return super.updateListByPrimaryKey(pbcCredits,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改个人人行征信信息,并进行排他
     * @param pbcCredit
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(PbcCredit pbcCredit,boolean exclusive) {
        return super.updateByPrimaryKeySelective(pbcCredit,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改个人人行征信信息,并进行排他
     * @param pbcCredits
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<PbcCredit> pbcCredits,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(pbcCredits,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改个人人行征信信息,并进行排他
     * @param pbcCredit
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByExampleData(PbcCredit pbcCredit, Example example,boolean exclusive) {
        return super.updateByExample(pbcCredit,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改个人人行征信信息,并进行排他
     * @param pbcCredit
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    @Override
    public int updateByExampleSelectiveData(PbcCredit pbcCredit, Example example,boolean exclusive){
        return super.updateByExampleSelective(pbcCredit,example,exclusive);
    }

}
