package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDetailRepository;
import cn.com.leadu.fms.finance.service.FinancialVoucherService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucher;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherDetail;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucher.FinancialVoucherVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherSaveVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherModifyVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherDeleteVo;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.FinancialVoucherDeleteListVo;
import org.apache.commons.configuration.tree.TreeUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherService
 * @Description: 凭证类型管理业务实现层
 * @date 2018-06-20
 */
@Service
public class FinancialVoucherServiceImpl implements FinancialVoucherService {

    /**
     * @Fields  : 凭证类型管理repository
     */
    @Autowired
    private FinancialVoucherRepository financialVoucherRepository;

    @Autowired
    private FinancialVoucherDetailRepository financialVoucherDetailRepository;
    /**
     * @Title:
     * @Description: 分页查询凭证类型管理
     * @param financialVoucherVo
     * @return PageInfoExtend<FinancialVoucher>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public PageInfoExtend<FinancialVoucher> findFinancialVouchersByPage(FinancialVoucherVo financialVoucherVo){
        Example example = SqlUtil.newExample(FinancialVoucher.class);
        SqlUtil.setOrderByColumnDesc(example,"voucher_name");
        PageInfoExtend<FinancialVoucher> pageInfo = financialVoucherRepository.selectListByExamplePage(example,financialVoucherVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存凭证类型管理
     * @param financialVoucherSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public void saveFinancialVoucher(FinancialVoucherSaveVo financialVoucherSaveVo){
        if(financialVoucherSaveVo!=null){
            Example example = SqlUtil.newExample(FinancialVoucher.class);
            example.createCriteria().andEqualTo("voucherType",financialVoucherSaveVo.getVoucherType());
            FinancialVoucher financialVoucher = financialVoucherRepository.selectOneByExample(example);
            if(financialVoucher!=null){
                throw new FmsServiceException("该凭证类型已经存在!");
            }else{
                financialVoucherRepository.insertData(financialVoucherSaveVo.getEntity());
            }
        }
    }

    /**
     * @Title:
     * @Description: 修改凭证类型管理
     * @param financialVoucherModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public void modifyFinancialVoucher(FinancialVoucherModifyVo financialVoucherModifyVo){
        financialVoucherRepository.updateByPrimaryKeySelectiveData(financialVoucherModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过voucherId删除凭证类型管理
     * @param financialVoucherDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public void deleteFinancialVoucher(FinancialVoucherDeleteVo financialVoucherDeleteVo){
        financialVoucherRepository.deleteData(financialVoucherDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过voucherId集合删除凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public void deleteFinancialVouchersByVoucherIds(FinancialVoucherVo financialVoucherVo){
        Example example = SqlUtil.newExample(FinancialVoucherDetail.class);
        example.createCriteria().andEqualTo("voucherType",financialVoucherVo.getVoucherType());
        FinancialVoucherDetail financialVoucherDetail = financialVoucherDetailRepository.selectOneByExample(example);
        if(financialVoucherDetail != null){
            throw new FmsServiceException("该凭证类型拥有明细，无法删除");
        }
        Example example1 = SqlUtil.newExample(FinancialVoucher.class);
        example1.createCriteria().andEqualTo("voucherType",financialVoucherVo.getVoucherType());
        financialVoucherRepository.deleteExampleData(example1,new FinancialVoucher());
    }

    /**
     * @Title:
     * @Description:  根据voucherId获取凭证类型管理
     * @param voucherType
     * @return FinancialVoucher
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    public FinancialVoucher findFinancialVoucherByVoucherId(String voucherType){
        Example example = SqlUtil.newExample(FinancialVoucher.class);
        example.createCriteria().andEqualTo("voucherType",voucherType);
        return financialVoucherRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 查询凭证信息树形结构
     * @param
     * @return PageInfoExtend<FinancialVoucher>
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @Override
    public List<BootstrapTreeViewNodeVo> findFinancialVouchersByTree() {
        Example example = SqlUtil.newExample(FinancialVoucher.class);
        SqlUtil.setOrderByColumnDesc(example,"voucher_type");
        List<FinancialVoucher> financialVouchers  = financialVoucherRepository.selectListByExample(example);
        List<BootstrapTreeViewNodeVo> bootstrapTreeViewNodeVos = new ArrayList<>();
        bootstrapTreeViewNodeVos = CommonTreeDataUtils.getTrees(financialVouchers);
//        List<BootstrapTreeViewNodeVo> bootstrapTreeViewNodeVos = new ArrayList<>();
//        if(ArrayUtils.isNotNullAndLengthNotZero(financialVouchers)){
//            for(FinancialVoucher financialVoucher:financialVouchers){
//                BootstrapTreeViewNodeVo bootstrapTreeViewNodeVo = new BootstrapTreeViewNodeVo();
//                bootstrapTreeViewNodeVo.setId(financialVoucher.getVoucherType());
//                bootstrapTreeViewNodeVo.setText(financialVoucher.getVoucherName());
//                bootstrapTreeViewNodeVos.add(bootstrapTreeViewNodeVo);
//            }
//        }

        return bootstrapTreeViewNodeVos;
    }

}
