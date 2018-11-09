package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.postbiz.service.InvoiceAutoService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceAutoRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoiceauto.InvoiceAutoVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoSaveVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoModifyVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoDeleteVo;
import cn.com.leadu.fms.postbiz.validator.invoiceauto.vo.InvoiceAutoDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceAutoService
 * @Description: 自动开票信息业务实现层
 */
@Service
public class InvoiceAutoServiceImpl implements InvoiceAutoService {

    /**
     * @Fields  : 自动开票信息repository
     */
    @Autowired
    private InvoiceAutoRepository invoiceAutoRepository;

    /**
     * @Title:
     * @Description: 分页查询自动开票信息
     * @param invoiceAutoVo
     * @return PageInfoExtend<InvoiceAuto>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public PageInfoExtend<InvoiceAuto> findInvoiceAutosByPage(InvoiceAutoVo invoiceAutoVo){
        Example example = SqlUtil.newExample(InvoiceAuto.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<InvoiceAuto> pageInfo = invoiceAutoRepository.selectListByExamplePage(example,invoiceAutoVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存自动开票信息
     * @param invoiceAutoSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public void saveInvoiceAuto(InvoiceAutoSaveVo invoiceAutoSaveVo){
        invoiceAutoRepository.insertData(invoiceAutoSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改自动开票信息
     * @param invoiceAutoModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public void modifyInvoiceAuto(InvoiceAutoModifyVo invoiceAutoModifyVo){
        invoiceAutoRepository.updateByPrimaryKeySelectiveData(invoiceAutoModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过invoiceAutoId删除自动开票信息
     * @param invoiceAutoDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public void deleteInvoiceAuto(InvoiceAutoDeleteVo invoiceAutoDeleteVo){
        invoiceAutoRepository.deleteData(invoiceAutoDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过invoiceAutoId集合删除自动开票信息
     * @param invoiceAutoDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public void deleteInvoiceAutosByInvoiceAutoIds(InvoiceAutoDeleteListVo invoiceAutoDeleteListVo){
        invoiceAutoRepository.deleteDataList(invoiceAutoDeleteListVo.getInvoiceAutoIds(),invoiceAutoDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据invoiceAutoId获取自动开票信息
     * @param invoiceAutoId
     * @return InvoiceAuto
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:04:20
     */
    public InvoiceAuto findInvoiceAutoByInvoiceAutoId(String invoiceAutoId){
        return invoiceAutoRepository.selectByPrimaryKey(invoiceAutoId);
    }

    /**
     * @Title:
     * @Description:   保存自动开票集合
     * @param invoiceAutos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 08:42:08
     */
    @Transactional
    public void saveInvoiceAutos(List<InvoiceAuto> invoiceAutos){
        invoiceAutoRepository.insertDataList(invoiceAutos);
    }

    /**
     * @Title:
     * @Description:   根据发票号码查询自动开票信息
     * @param infoNumbers
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 05:08:46
     */
    public List<InvoiceAuto> findInvoiceAutosByInfoNumbers(List<String> infoNumbers){
        if(ArrayUtils.isNotNullAndLengthNotZero(infoNumbers)){
            Example example = SqlUtil.newExample(InvoiceAuto.class);
            example.createCriteria().andIn("infonumber",infoNumbers);
            return invoiceAutoRepository.selectListByExample(example);
        }
        return null;
    }

}
