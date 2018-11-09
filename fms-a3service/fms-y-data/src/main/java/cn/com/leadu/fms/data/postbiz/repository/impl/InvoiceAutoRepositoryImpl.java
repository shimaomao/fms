package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.InvoiceAutoDao;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceAutoRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoRepositoryImpl
 * @Description: 自动开票信息Repository 实现层
 */
@Repository
public class InvoiceAutoRepositoryImpl extends AbstractBaseRepository<InvoiceAutoDao, InvoiceAuto> implements InvoiceAutoRepository {

    /**
     * @Title:
     * @Description: 新增自动开票信息
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int insertData(InvoiceAuto invoiceAuto) {
        return super.insert(invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 批量保存自动开票信息
     * @param invoiceAutos
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int insertDataList(List<InvoiceAuto> invoiceAutos){
        return super.insertListByJdbcTemplate(invoiceAutos);
    }

    /**
     * @Title:
     * @Description: 修改自动开票信息
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceAuto invoiceAuto) {
        return super.updateByPrimaryKey(invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 批量修改自动开票信息
     * @param invoiceAutos
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceAuto> invoiceAutos){
        return super.updateListByPrimaryKey(invoiceAutos);
    }

    /**
     * @Title:
     * @Description: 动态修改自动开票信息
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceAuto invoiceAuto) {
        return super.updateByPrimaryKeySelective(invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 批量动态修改自动开票信息
     * @param invoiceAutos
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceAuto> invoiceAutos) {
        return super.updateListByPrimaryKeySelective(invoiceAutos);
    }

    /**
     * @Title:
     * @Description: 根据条件修改自动开票信息
     * @param invoiceAuto
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByExampleData(InvoiceAuto invoiceAuto, Example example) {
        return super.updateByExample(invoiceAuto,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改自动开票信息
     * @param invoiceAuto
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceAuto invoiceAuto, Example example){
        return super.updateByExampleSelective(invoiceAuto,example);
    }
    
    /**
     * @Title:
     * @Description: 根据invoiceAutoId删除自动开票信息
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int deleteData(InvoiceAuto invoiceAuto) {
        return super.delete(invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 根据invoiceAutoId集合批量删除自动开票信息
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int deleteDataList(List invoiceAutoIds,InvoiceAuto invoiceAuto){
        return super.deleteByIds(invoiceAutoIds,invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除自动开票信息
     * @param example
     * @param invoiceAuto
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int deleteExampleData(Example example,InvoiceAuto invoiceAuto){
        return super.deleteByExample(example,invoiceAuto);
    }

    /**
     * @Title:
     * @Description: 查询全部自动开票信息
     * @return List<InvoiceAuto>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public List<InvoiceAuto> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个自动开票信息
     * @param example
     * @return InvoiceAuto
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public InvoiceAuto selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询自动开票信息
     * @param example
     * @return List<InvoiceAuto>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public List<InvoiceAuto> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过invoiceAutoId查询自动开票信息
     * @param invoiceAutoId
     * @return InvoiceAuto
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public InvoiceAuto selectByPrimaryKey(Object invoiceAutoId) {
        return super.selectByPrimaryKey(invoiceAutoId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询自动开票信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<InvoiceAuto>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public PageInfoExtend<InvoiceAuto> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询自动开票信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改自动开票信息
     * @param invoiceAuto,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeyData(InvoiceAuto invoiceAuto,boolean exclusive) {
        return super.updateByPrimaryKey(invoiceAuto,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改自动开票信息,并进行排他
     * @param invoiceAutos
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeyDataList(List<InvoiceAuto> invoiceAutos,boolean exclusive){
        return super.updateListByPrimaryKey(invoiceAutos,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改自动开票信息,并进行排他
     * @param invoiceAuto
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(InvoiceAuto invoiceAuto,boolean exclusive) {
        return super.updateByPrimaryKeySelective(invoiceAuto,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改自动开票信息,并进行排他
     * @param invoiceAutos
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<InvoiceAuto> invoiceAutos,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(invoiceAutos,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改自动开票信息,并进行排他
     * @param invoiceAuto
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByExampleData(InvoiceAuto invoiceAuto, Example example,boolean exclusive) {
        return super.updateByExample(invoiceAuto,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改自动开票信息,并进行排他
     * @param invoiceAuto
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    @Override
    public int updateByExampleSelectiveData(InvoiceAuto invoiceAuto, Example example,boolean exclusive){
        return super.updateByExampleSelective(invoiceAuto,example,exclusive);
    }

}
