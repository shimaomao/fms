package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinancialVoucherDataRepository;
import cn.com.leadu.fms.finance.service.FinancialVoucherAssisService;
import cn.com.leadu.fms.finance.service.FinancialVoucherDataService;
import cn.com.leadu.fms.pojo.finance.entity.FinancialVoucherData;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherassis.FinancialVoucherAssisVo;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataService
 * @Description: 财务凭证数据业务实现层
 * @date 2018-06-21
 */
@Service
public class FinancialVoucherDataServiceImpl implements FinancialVoucherDataService {

    /**
     * @Fields  : 财务凭证数据repository
     */
    @Autowired
    private FinancialVoucherDataRepository financialVoucherDataRepository;

    /** 
     * @Fields  : 财务凭证辅助核算service
     * @author qiaomengnan
     */ 
    @Autowired
    private FinancialVoucherAssisService financialVoucherAssisService;

    /**
     * @Title:
     * @Description: 分页查询财务凭证数据
     * @param finVouDataVo
     * @return PageInfoExtend<FinancialVoucherData>
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:10
     */
    public PageInfoExtend<FinancialVoucherData> findFinVouDataVosByPage(FinancialVoucherDataVo finVouDataVo){
        if(StringUtils.isTrimBlank(finVouDataVo.getVoucherNo()))
            finVouDataVo.setVoucherNo(null);
        else
            finVouDataVo.setVoucherNo(SqlUtil.likePattern(finVouDataVo.getVoucherNo()));
        if(StringUtils.isTrimBlank(finVouDataVo.getVoucherBizCode()))
            finVouDataVo.setVoucherBizCode(null);
        else
            finVouDataVo.setVoucherBizCode(SqlUtil.likePattern(finVouDataVo.getVoucherBizCode()));
        PageInfoExtend<FinancialVoucherData> pageInfo
                = financialVoucherDataRepository.selectListVoByPage("selectFinancialVoucherDataVos",finVouDataVo,finVouDataVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 根据凭证号查询对应的凭证数据
     * @param:  voucherNo 凭证号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/16 0016 19:37
     */
    public List<FinancialVoucherDataVo> findFinVouDataVoDetails(String voucherNo){
        if(StringUtils.isNotTrimBlank(voucherNo)){
            List<FinancialVoucherDataVo> financialVoucherDataVoList = financialVoucherDataRepository.selectFinVouDataVoDetails(voucherNo);
            //根据财务凭证id获取财务凭证核算数据
            if(ArrayUtils.isNotNullAndLengthNotZero(financialVoucherDataVoList)){
                for (FinancialVoucherDataVo financialVoucherDataVo : financialVoucherDataVoList){
                    if(StringUtils.isNotTrimBlank(financialVoucherDataVo.getVoucherDataId())){
                        String str;
                        StringBuffer str2 = new StringBuffer();
                        List<FinancialVoucherAssisVo> financialVoucherAssisVoList = findFinVouAssisVosByVouDataId(financialVoucherDataVo.getVoucherDataId());
                        //拼接辅助核算类型与核算项目值(公司：xx/客户：xx)
                        if (ArrayUtils.isNotNullAndLengthNotZero(financialVoucherAssisVoList)){
                            for (FinancialVoucherAssisVo financialVoucherAssisVo : financialVoucherAssisVoList){
                                str=financialVoucherAssisVo.getAssisAccountTypeName()+":"+financialVoucherAssisVo.getAssisAccountValue();
                                str2.append(str);
                                str2.append("/");
                            }
                        }
                        //把最后一个"/"截掉,并封装到集合中
                        if(str2.length() > 0){
                            String substring = str2.substring(0, str2.length() - 1);
                            if(StringUtils.isNotTrimBlank(substring))
                            financialVoucherDataVo.setAssisStr(substring);
                        }
                    }
                }

            }
            return financialVoucherDataVoList;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   根据财务凭证id获取财务凭证核算数据
     * @param voucherDataId 财务凭证id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 03:01:10
     */
    public List<FinancialVoucherAssisVo> findFinVouAssisVosByVouDataId(String voucherDataId){
        if(StringUtils.isNotTrimBlank(voucherDataId))
            return financialVoucherAssisService.findFinVouAssisVosByVouDataId(voucherDataId);
        return null;
    }

    /**
     * @Title:
     * @Description:   根据凭证号集合获取凭证数据
     * @param voucherNos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 05:25:14
     */
    public List<FinancialVoucherData> findFinancialVoucherDatas(List<String> voucherNos){
        if(ArrayUtils.isNotNullAndLengthNotZero(voucherNos)) {
            Example example = SqlUtil.newExample(FinancialVoucherData.class);
            example.createCriteria().andIn("voucherNo", voucherNos);
            return financialVoucherDataRepository.selectListByExample(example);
        }
        return null;
    }

}
