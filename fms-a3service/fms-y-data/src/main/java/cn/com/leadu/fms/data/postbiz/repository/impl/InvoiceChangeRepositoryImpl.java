package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.InvoiceChangeDao;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceChangeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeSearchVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeRepositoryImpl
 * @Description: 开票信息变更Repository 实现层
 * @date 2018-08-29
 */
@Repository
public class InvoiceChangeRepositoryImpl extends AbstractBaseRepository<InvoiceChangeDao, InvoiceChange> implements InvoiceChangeRepository {

    /**
     * @Title:
     * @Description: 新增开票信息变更
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int insertData(InvoiceChange invoiceChange) {
        return super.insert(invoiceChange);
    }

    /**
     * @Title:
     * @Description: 批量保存开票信息变更
     * @param invoiceChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int insertDataList(List<InvoiceChange> invoiceChanges){
        return super.insertListByJdbcTemplate(invoiceChanges);
    }

    /**
     * @Title:
     * @Description: 修改开票信息变更
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceChange invoiceChange) {
        return super.updateByPrimaryKey(invoiceChange);
    }

    /**
     * @Title:
     * @Description: 批量修改开票信息变更
     * @param invoiceChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceChange> invoiceChanges){
        return super.updateListByPrimaryKey(invoiceChanges);
    }

    /**
     * @Title:
     * @Description: 动态修改开票信息变更
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceChange invoiceChange) {
        return super.updateByPrimaryKeySelective(invoiceChange);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票信息变更
     * @param invoiceChanges
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceChange> invoiceChanges) {
        return super.updateListByPrimaryKeySelective(invoiceChanges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票信息变更
     * @param invoiceChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByExampleData(InvoiceChange invoiceChange, Example example) {
        return super.updateByExample(invoiceChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改开票信息变更
     * @param invoiceChange
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceChange invoiceChange, Example example){
        return super.updateByExampleSelective(invoiceChange,example);
    }
    
    /**
     * @Title:
     * @Description: 根据invoiceChangeId删除开票信息变更
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int deleteData(InvoiceChange invoiceChange) {
        return super.delete(invoiceChange);
    }

    /**
     * @Title:
     * @Description: 根据invoiceChangeId集合批量删除开票信息变更
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int deleteDataList(List invoiceChangeIds,InvoiceChange invoiceChange){
        return super.deleteByIds(invoiceChangeIds,invoiceChange);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除开票信息变更
     * @param example
     * @param invoiceChange
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int deleteExampleData(Example example,InvoiceChange invoiceChange){
        return super.deleteByExample(example,invoiceChange);
    }

    /**
     * @Title:
     * @Description: 查询全部开票信息变更
     * @return List<InvoiceChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public List<InvoiceChange> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个开票信息变更
     * @param example
     * @return InvoiceChange
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public InvoiceChange selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询开票信息变更
     * @param example
     * @return List<InvoiceChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public List<InvoiceChange> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过invoiceChangeId查询开票信息变更
     * @param invoiceChangeId
     * @return InvoiceChange
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public InvoiceChange selectByPrimaryKey(Object invoiceChangeId) {
        return super.selectByPrimaryKey(invoiceChangeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询开票信息变更
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<InvoiceChange>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public PageInfoExtend<InvoiceChange> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询开票信息变更vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改开票信息变更
     * @param invoiceChange,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceChange invoiceChange,boolean exclusive) {
        return super.updateByPrimaryKey(invoiceChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改开票信息变更,并进行排他
     * @param invoiceChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceChange> invoiceChanges,boolean exclusive){
        return super.updateListByPrimaryKey(invoiceChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改开票信息变更,并进行排他
     * @param invoiceChange
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceChange invoiceChange,boolean exclusive) {
        return super.updateByPrimaryKeySelective(invoiceChange,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票信息变更,并进行排他
     * @param invoiceChanges
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceChange> invoiceChanges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(invoiceChanges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票信息变更,并进行排他
     * @param invoiceChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByExampleData(InvoiceChange invoiceChange, Example example,boolean exclusive) {
        return super.updateByExample(invoiceChange,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改开票信息变更,并进行排他
     * @param invoiceChange
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:45:20
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceChange invoiceChange, Example example,boolean exclusive){
        return super.updateByExampleSelective(invoiceChange,example,exclusive);
    }

    /**
     * 根据socialCertifNo获取企业发票基本信息
     *
     * @param socialCertifNo
     * @return InvoiceChangeVo
     */
    @Override
    public InvoiceChangeVo selectApplyInvoiceVosBySocialCertifNo(String socialCertifNo) {
        return baseDao.selectApplyInvoiceVosBySocialCertifNo(socialCertifNo);
    }

    /**
     * 根据invoiceTaskNo获取企业发票基本信息
     *
     * @param invoiceTaskNo
     * @return InvoiceChangeVo
     */
    @Override
    public List<InvoiceChangeVo> selectInvoiceChangeVosByInvoiceTaskNo(String invoiceTaskNo) {
        return baseDao.selectInvoiceChangeVosByInvoiceTaskNo(invoiceTaskNo);
    }

    /**
     * 更新企业信息表
     *
     * @param invoiceChangeSearchVo
     */
    @Override
    public void updateCstmCompany(InvoiceChangeSearchVo invoiceChangeSearchVo) {
        baseDao.updateCstmCompany(invoiceChangeSearchVo);
    }

    /**
     * 根据统一社会信用编号获取applyNo
     *
     * @param invoiceChangeVo
     * @return
     */
//    @Override
//    public List<String> selectApplyNoListBySocialCertifNo(InvoiceChangeVo invoiceChangeVo) {
//        return baseDao.selectApplyNoListBySocialCertifNo(invoiceChangeVo);
//    }

}
