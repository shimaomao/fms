package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.constant.enums.finance.AssisAccountTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherAssisRepository;
import cn.com.leadu.fms.finance.service.FinancialVoucherAssisService;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherAssis;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherAssisServiceImpl
 * @Description: 财务凭证核算数据service
 * @date 2018/7/11
 */
@Service
public class FinancialVoucherAssisServiceImpl implements FinancialVoucherAssisService {

    @Autowired
    private FinancialVoucherAssisRepository financialVoucherAssisRepository;

    /**
     * @Title:
     * @Description:   根据财务凭证id获取财务凭证核算数据
     * @param voucherDataId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 03:01:10
     */
    public List<FinancialVoucherAssisVo> findFinVouAssisVosByVouDataId(String voucherDataId){
        List<FinancialVoucherAssisVo> finVouAssisVos = null;
        if(StringUtils.isNotTrimBlank(voucherDataId)){
            finVouAssisVos = financialVoucherAssisRepository.selectFinancialVoucherAssisVosByVouDataId(voucherDataId);
        }
        return finVouAssisVos;
    }

    /**
     * @Title:
     * @Description:   根据财务凭证id获取金蝶用户列表
     * @param vouDataIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 10:35:44
     */
    public List<KingDeeCusVo> findKingDeeCusVosByVouDataIds(List<String> vouDataIds){
        if(ArrayUtils.isNotNullAndLengthNotZero(vouDataIds)) {
            FinancialVoucherAssisVo finVouAssisVo = new FinancialVoucherAssisVo();
            finVouAssisVo.setItemCustom(AssisAccountTypeEnums.ITEM_CUSTOM.getType());
            finVouAssisVo.setVouDataIds(vouDataIds);
            return financialVoucherAssisRepository.selectKingDeeCusVosByVouDataIds(finVouAssisVo);
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 根据凭证id查询凭证辅助核算
     * @param voucherDataIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/30 11:28:27
     */
    public List<FinancialVoucherAssis> findFinVouAssisListByVouDataIds(List<String> voucherDataIds){
        List<FinancialVoucherAssis> finVouAssisList = null;
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherDataIds)){
            Example example = SqlUtil.newExample(FinancialVoucherAssis.class);
            example.createCriteria().andIn("voucherDataId",voucherDataIds);
            example.orderBy("assisAccountOrder").asc();
            return financialVoucherAssisRepository.selectListByExample(example);
        }
        return finVouAssisList;
    }

}
