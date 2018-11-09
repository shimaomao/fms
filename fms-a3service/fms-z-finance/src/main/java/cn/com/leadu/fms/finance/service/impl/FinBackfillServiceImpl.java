package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonFinBackfillService;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.FilBackfillStsEnums;
import cn.com.leadu.fms.common.constant.enums.finance.InputModeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.CommonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.data.finance.repository.FinBackfillRepository;
import cn.com.leadu.fms.finance.service.FinBackfillService;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillDeleteListVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillDeleteVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillModifyVo;
import cn.com.leadu.fms.finance.validator.finbackfill.vo.FinBackfillSaveVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVoExcel;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: FinBackfillService
 * @Description: 融资回填业务实现层
 * @date 2018-05-11
 */
@Service
@Slf4j
public class FinBackfillServiceImpl implements FinBackfillService {

    private static final Logger logger = LoggerFactory.getLogger(FinBackfillServiceImpl.class);

    /**
     * @Fields  : 融资回填repository
     */
    @Autowired
    private FinBackfillRepository finBackfillRepository;

    @Autowired
    private CommonFinBackfillService commonFinBackfillService;

    /**
     * @Fields  : 融资回填明细repository
     */
    @Autowired
    private FinBackfillDetailRepository finBackfillDetailRepository;
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Title:
     * @Description: 分页查询融资回填
     * @param finBackfillVo
     * @return PageInfoExtend<FinBackfill>
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public PageInfoExtend<FinBackfillVo> findFinBackfillsByPage(FinBackfillVo finBackfillVo){
        if (StringUtils.isNotTrimBlank(finBackfillVo.getContNo())){
            finBackfillVo.setContNo(SqlUtil.likePattern(finBackfillVo.getContNo()));
        } else {
            finBackfillVo.setContNo(null);
        }
        if (StringUtils.isNotTrimBlank(finBackfillVo.getName())){
            finBackfillVo.setName(SqlUtil.likePattern(finBackfillVo.getName()));
        }else{
            finBackfillVo.setName(null);
        }
        if (StringUtils.isTrimBlank(finBackfillVo.getFilBackfillSts())){
            finBackfillVo.setFilBackfillSts(null);
        }
        //车架号
        if (StringUtils.isNotTrimBlank(finBackfillVo.getVinNo())){
            finBackfillVo.setVinNo(SqlUtil.likePattern(finBackfillVo.getVinNo()));
        }else{
            finBackfillVo.setVinNo(null);
        }
        //业务类型
        if(StringUtils.isTrimBlank(finBackfillVo.getLicenseAttr()))
            finBackfillVo.setLicenseAttr(null);
        PageInfoExtend<FinBackfillVo> pageInfo = finBackfillRepository.selectListVoByPage("selectFinBackfillsByPage", finBackfillVo, finBackfillVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存融资回填
     * @param finBackfillSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public void saveFinBackfill(FinBackfillSaveVo finBackfillSaveVo){
        finBackfillRepository.insertData(finBackfillSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 财务回填
     * @param finBackfillVo
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    @Transactional
    @Override
    public void finBackfill(FinBackfillVo finBackfillVo){
        List<FinBackfillDetail> finBackfillDetailList = new ArrayList<>();
        List<FinBackfillDetailVo> finBackfillDetailVoList = finBackfillVo.getFinBackfillDetailVoList();
        BigDecimal costTotal = BigDecimal.ZERO;
        BigDecimal finTotal = BigDecimal.ZERO;
        BigDecimal taxTotal = BigDecimal.ZERO;
        Example example = SqlUtil.newExample(FinBackfill.class);
        example.createCriteria().andEqualTo("filBackfillId", finBackfillVo.getFilBackfillId());
        FinBackfill finBackfill = finBackfillRepository.selectOneByExample(example);

        if (ArrayUtils.isNotNullAndLengthNotZero(finBackfillDetailVoList)) {
            for (FinBackfillDetailVo finBackfillDetailVo : finBackfillDetailVoList) {
                //实际税金计算check
                if(!YesNoFlagEnums.YES.getType().equals(finBackfillDetailVo.getShowDetail())){//不是用来展示的明细
                    // 财务投资额
                    costTotal = costTotal.add(CommonUtils.TrimBigDecimal(finBackfillDetailVo.getActualCostAmount()));
                }
                finBackfillDetailList.add(finBackfillDetailVo.getEntity());
            }
        }
        //财务融资额 = 财务投资额-首付
        finTotal =  costTotal.subtract(finBackfill.getInitAmount());

        if(finBackfillVo.getInvestTotal() == null || finBackfillVo.getInvestTotal().compareTo(costTotal) != 0){
            throw new FmsServiceException("财务实际投资额计算不正确");
        }
        if(finBackfillVo.getFinTotal() == null || finBackfillVo.getFinTotal().compareTo(finTotal) != 0){
            throw new FmsServiceException("财务实际融资额计算不正确");
        }
        List<ContReceipt> contReceiptList = new ArrayList<>();
        //回填处理时
        if(YesNoFlagEnums.NO.getType().equals(finBackfillVo.getFlag())) {
            if (ArrayUtils.isNotNullAndLengthNotZero(finBackfillDetailVoList)) {
                for (int i = 0; i < finBackfillDetailList.size(); i++) {
                    FinBackfillDetail finBackfillDetail = finBackfillDetailList.get(i);
                    //保险和购置税回填的时候，如果融资额比发票金额高的时候，要往收款明细导入那边插一条数据，可以抵扣租金，
                    // 备注内容格式：保险发票差额,任务号：xxx,合同号：xxx；购置税发票差额,任务号：xxx,合同号：xxx
                    if (BigDecimalUtils.getNotNullBigDecimal(finBackfillDetail.getFinAmount()).
                            compareTo(BigDecimalUtils.getNotNullBigDecimal(finBackfillDetail.getActualFinAmount())) > 0) {
                        if (FinItemEnums.INSURANCE.getCode().equals(finBackfillDetailList.get(i).getFinItem()) ||
                                FinItemEnums.PURTAX.getCode().equals(finBackfillDetailList.get(i).getFinItem())) {
                            BigDecimal amount = BigDecimalUtils.getNotNullBigDecimal(finBackfillDetail.getFinAmount()).
                                    subtract(BigDecimalUtils.getNotNullBigDecimal(finBackfillDetail.getActualFinAmount()));

                            ContReceipt contReceipt = new ContReceipt();
                            contReceipt.setInputMode(InputModeEnums.SHORTFALL.getType());//数据来源 差额
                            contReceipt.setReceiptAmount(amount);
                            contReceipt.setRestAmount(amount);//剩余金额
                            String memo = "";
                            if (FinItemEnums.PURTAX.getCode().equals(finBackfillDetailList.get(i).getFinItem())) {
                                memo = "购置税发票差额，合同号：" + finBackfillVo.getContNo();
                            } else {
                                memo = "保险(第" + finBackfillDetail.getFinItemYear() + "年)发票差额，合同号：" + finBackfillVo.getContNo();
                            }

                            contReceipt.setMemo(memo);//备注
                            contReceiptList.add(contReceipt);
                        }
                    }
                }
            }
        }

        //更新财务回填明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(finBackfillDetailList)){
            finBackfillDetailRepository.updateByPrimaryKeySelectiveDataList(finBackfillDetailList);
        }
        if(finBackfillVo != null){
            FinBackfill finBackfillObj =  finBackfillVo.getEntity();
            if(YesNoFlagEnums.YES.getType().equals(finBackfillVo.getFlag())){
                finBackfillObj.setFilBackfillSts(FilBackfillStsEnums.BEING_BACKFILL.getType());
            }else if(YesNoFlagEnums.NO.getType().equals(finBackfillVo.getFlag())){
                finBackfillObj.setFilBackfillSts(FilBackfillStsEnums.ALREADY_BACKFILL.getType());
            }
            //更新财务回填表
            finBackfillRepository.updateByPrimaryKeySelectiveData(finBackfillObj);
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(contReceiptList)){
            //登录财务收款表
            contReceiptRepository.insertDataList(contReceiptList);
        }
        if(YesNoFlagEnums.NO.getType().equals(finBackfillVo.getFlag())){
            commonFinBackfillService.finBackfill(finBackfillVo);
        }

    }

    /**
     * @Title:
     * @Description: 修改融资回填
     * @param finBackfillModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public void modifyFinBackfill(FinBackfillModifyVo finBackfillModifyVo){
        finBackfillRepository.updateByPrimaryKeySelectiveData(finBackfillModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过filBackfillId删除融资回填
     * @param finBackfillDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public void deleteFinBackfill(FinBackfillDeleteVo finBackfillDeleteVo){
        finBackfillRepository.deleteData(finBackfillDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过filBackfillId集合删除融资回填
     * @param finBackfillDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public void deleteFinBackfillsByFilBackfillIds(FinBackfillDeleteListVo finBackfillDeleteListVo){
        finBackfillRepository.deleteDataList(finBackfillDeleteListVo.getFilBackfillIds(),finBackfillDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据filBackfillId获取融资回填
     * @param filBackfillId
     * @return FinBackfill
     * @throws
     * @author lijunjun
     * @date 2018-5-11 16:12:19
     */
    public FinBackfillVo findFinBackfillByFilBackfillId(String filBackfillId){
        BigDecimal financeInvestTotal = BigDecimal.ZERO;
        FinBackfillVo finBackfillVo = finBackfillRepository.selectFinBackfillByFilBackfillId(filBackfillId);
        //设置代收手续费名称
        for(FinBackfillDetailVo finBackfillDetailVo : finBackfillVo.getFinBackfillDetailVoList()){
            if(FinItemEnums.COLLECTING_POUNDAGE.getCode().equals(finBackfillDetailVo.getFinItem())){
                finBackfillDetailVo.setFinItemName(FinItemEnums.COLLECTING_POUNDAGE.getDesc());
                finBackfillDetailVo.setFinTax(BigDecimal.ZERO);
            }
        }

        return finBackfillVo;
    }

    /**
     * @Title:
     * @Description: 导出财务回填excel
     * @param finBackfillVo
     * @return
     * @throws
     * @author yanfengbo
     */
    public PageInfoExtend<FinBackfillVoExcel> findFinBackfillsForExportExcel(FinBackfillVo finBackfillVo){
        finBackfillVo.setPaymentType(BizTypeEnums.CONT_NO.getType());
        finBackfillVo.setPerson(ApplyTypeEnums.PERSON.getType());
        //回填状态
        if (StringUtils.isTrimBlank(finBackfillVo.getFilBackfillSts())){
            finBackfillVo.setFilBackfillSts(null);
        }
        //合同号
        if (StringUtils.isNotTrimBlank(finBackfillVo.getContNo())){
            finBackfillVo.setContNo(SqlUtil.likePattern(finBackfillVo.getContNo()));
        } else {
            finBackfillVo.setContNo(null);
        }
        //申请姓名
        if (StringUtils.isNotTrimBlank(finBackfillVo.getName())){
            finBackfillVo.setName(SqlUtil.likePattern(finBackfillVo.getName()));
        }else{
            finBackfillVo.setName(null);
        }
        //车架号
        if (StringUtils.isNotTrimBlank(finBackfillVo.getVinNo())){
            finBackfillVo.setVinNo(SqlUtil.likePattern(finBackfillVo.getVinNo()));
        }else{
            finBackfillVo.setVinNo(null);
        }
        return finBackfillRepository.selectListVoByPage("selectFinBackfillsForExportExcel", finBackfillVo, finBackfillVo.getPageQuery());
    }
}
