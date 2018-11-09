package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.ContReceiptDao;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptRepositoryImpl
 * @Description: 黑名单Repository 实现层
 * @date 2018-05-07
 */
@Repository
public class ContReceiptRepositoryImpl extends AbstractBaseRepository<ContReceiptDao, ContReceipt> implements ContReceiptRepository {

    /**
     * @Title:
     * @Description: 新增黑名单
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int insertData(ContReceipt contReceipt) {
        return super.insert(contReceipt);
    }

    /**
     * @Title:
     * @Description: 批量保存黑名单
     * @param contReceipts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int insertDataList(List<ContReceipt> contReceipts){
        return super.insertListByJdbcTemplate(contReceipts);
    }

    /**
     * @Title:
     * @Description: 修改黑名单
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int updateByPrimaryKeyData(ContReceipt contReceipt) {
        return super.updateByPrimaryKey(contReceipt);
    }

    /**
     * @Title:
     * @Description: 批量修改黑名单
     * @param contReceipts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContReceipt> contReceipts){
        return super.updateListByPrimaryKey(contReceipts);
    }

    /**
     * @Title:
     * @Description: 动态修改黑名单
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContReceipt contReceipt) {
        return super.updateByPrimaryKeySelective(contReceipt);
    }

    /**
     * @Title:
     * @Description: 批量动态修改黑名单
     * @param contReceipts
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContReceipt> contReceipts) {
        return super.updateListByPrimaryKeySelective(contReceipts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改黑名单
     * @param contReceipt
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int updateByExampleData(ContReceipt contReceipt, Example example) {
        return super.updateByExample(contReceipt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改黑名单
     * @param contReceipt
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int updateByExampleSelectiveData(ContReceipt contReceipt, Example example){
        return super.updateByExampleSelective(contReceipt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contReceiptId删除黑名单
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public int deleteData(ContReceipt contReceipt) {
        return super.delete(contReceipt);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptId集合批量删除黑名单
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public int deleteDataList(List contReceiptIds,ContReceipt contReceipt){
        return super.deleteByIds(contReceiptIds,contReceipt);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除黑名单
     * @param example
     * @param contReceipt
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public int deleteExampleData(Example example,ContReceipt contReceipt){
        return super.deleteByExample(example,contReceipt);
    }

    /**
     * @Title:
     * @Description: 查询全部黑名单
     * @return List<ContReceipt>
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public List<ContReceipt> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个黑名单
     * @param example
     * @return ContReceipt
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public ContReceipt selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询黑名单
     * @param example
     * @return List<ContReceipt>
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public List<ContReceipt> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contReceiptId查询黑名单
     * @param contReceiptId
     * @return ContReceipt
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public ContReceipt selectByPrimaryKey(Object contReceiptId) {
        return super.selectByPrimaryKey(contReceiptId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询黑名单
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContReceipt>
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    @Override
    public PageInfoExtend<ContReceipt> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询黑名单vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-7 18:04:31
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }
}
