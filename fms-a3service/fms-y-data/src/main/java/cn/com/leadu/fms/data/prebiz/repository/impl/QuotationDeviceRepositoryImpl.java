package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.QuotationDeviceDao;
import cn.com.leadu.fms.data.prebiz.repository.QuotationDeviceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceRepositoryImpl
 * @Description: 报价器信息Repository 实现层
 * @date 2018-06-02
 */
@Repository
public class QuotationDeviceRepositoryImpl extends AbstractBaseRepository<QuotationDeviceDao, QuotationDevice> implements QuotationDeviceRepository {

    /**
     * @Title:
     * @Description: 新增报价器信息
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int insertData(QuotationDevice quotationDevice) {
        return super.insert(quotationDevice);
    }

    /**
     * @Title:
     * @Description: 批量保存报价器信息
     * @param quotationDevices
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int insertDataList(List<QuotationDevice> quotationDevices){
        return super.insertListByJdbcTemplate(quotationDevices);
    }

    /**
     * @Title:
     * @Description: 修改报价器信息
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeyData(QuotationDevice quotationDevice) {
        return super.updateByPrimaryKey(quotationDevice);
    }

    /**
     * @Title:
     * @Description: 批量修改报价器信息
     * @param quotationDevices
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<QuotationDevice> quotationDevices){
        return super.updateListByPrimaryKey(quotationDevices);
    }

    /**
     * @Title:
     * @Description: 动态修改报价器信息
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeySelectiveData(QuotationDevice quotationDevice) {
        return super.updateByPrimaryKeySelective(quotationDevice);
    }

    /**
     * @Title:
     * @Description: 批量动态修改报价器信息
     * @param quotationDevices
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<QuotationDevice> quotationDevices) {
        return super.updateListByPrimaryKeySelective(quotationDevices);
    }

    /**
     * @Title:
     * @Description: 根据条件修改报价器信息
     * @param quotationDevice
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByExampleData(QuotationDevice quotationDevice, Example example) {
        return super.updateByExample(quotationDevice,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改报价器信息
     * @param quotationDevice
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByExampleSelectiveData(QuotationDevice quotationDevice, Example example){
        return super.updateByExampleSelective(quotationDevice,example);
    }
    
    /**
     * @Title:
     * @Description: 根据quotationDeviceId删除报价器信息
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int deleteData(QuotationDevice quotationDevice) {
        return super.delete(quotationDevice);
    }

    /**
     * @Title:
     * @Description: 根据quotationDeviceId集合批量删除报价器信息
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int deleteDataList(List quotationDeviceIds,QuotationDevice quotationDevice){
        return super.deleteByIds(quotationDeviceIds,quotationDevice);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除报价器信息
     * @param example
     * @param quotationDevice
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int deleteExampleData(Example example,QuotationDevice quotationDevice){
        return super.deleteByExample(example,quotationDevice);
    }

    /**
     * @Title:
     * @Description: 查询全部报价器信息
     * @return List<QuotationDevice>
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public List<QuotationDevice> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个报价器信息
     * @param example
     * @return QuotationDevice
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public QuotationDevice selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询报价器信息
     * @param example
     * @return List<QuotationDevice>
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public List<QuotationDevice> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过quotationDeviceId查询报价器信息
     * @param quotationDeviceId
     * @return QuotationDevice
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public QuotationDevice selectByPrimaryKey(Object quotationDeviceId) {
        return super.selectByPrimaryKey(quotationDeviceId);
    }

    /**
     * @Title:
     * @Description: 通过quotationDeviceId查询报价器信息
     * @param quotationDeviceId
     * @return QuotationDevice
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public QuotationDeviceVo selectQuotationDeviceByQuotationDeviceId(String quotationDeviceId) {
        return baseDao.selectQuotationDeviceByQuotationDeviceId(quotationDeviceId);
    }

    /**
     * @Title:
     * @Description: 分页查询报价器信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<QuotationDevice>
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public PageInfoExtend<QuotationDevice> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询报价器信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改报价器信息
     * @param quotationDevice,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeyData(QuotationDevice quotationDevice,boolean exclusive) {
        return super.updateByPrimaryKey(quotationDevice,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改报价器信息,并进行排他
     * @param quotationDevices
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeyDataList(List<QuotationDevice> quotationDevices,boolean exclusive){
        return super.updateListByPrimaryKey(quotationDevices,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改报价器信息,并进行排他
     * @param quotationDevice
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(QuotationDevice quotationDevice,boolean exclusive) {
        return super.updateByPrimaryKeySelective(quotationDevice,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改报价器信息,并进行排他
     * @param quotationDevices
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<QuotationDevice> quotationDevices,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(quotationDevices,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改报价器信息,并进行排他
     * @param quotationDevice
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByExampleData(QuotationDevice quotationDevice, Example example,boolean exclusive) {
        return super.updateByExample(quotationDevice,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改报价器信息,并进行排他
     * @param quotationDevice
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-6-2 18:19:52
     */
    @Override
    public int updateByExampleSelectiveData(QuotationDevice quotationDevice, Example example,boolean exclusive){
        return super.updateByExampleSelective(quotationDevice,example,exclusive);
    }

}
