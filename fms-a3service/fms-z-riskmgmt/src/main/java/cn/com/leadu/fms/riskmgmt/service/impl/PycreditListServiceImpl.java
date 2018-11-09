package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditTypeEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.riskmgmt.entity.*;
import cn.com.leadu.fms.riskmgmt.service.*;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditListRepository;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditlist.vo.PycreditListDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditListService
 * @Description: 鹏元查询一览业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditListServiceImpl implements PycreditListService {

    /**
     * @Fields  : 鹏元查询一览repository
     */
    @Autowired
    private PycreditListRepository pycreditListRepository;

    /**
     * @Fields  : 地址核验业务层
     */
    @Autowired
    private PycreditAddrService pycreditAddrService;

    /**
     * @Fields  : 反欺诈分析业务层
     */
    @Autowired
    private PycreditAntiService pycreditAntiService;

    /**
     * @Fields  : 卡核查及交易业务层
     */
    @Autowired
    private PycreditCardCheckService pycreditCardCheckService;

    /**
     * @Fields  : 企业债务业务层
     */
    @Autowired
    private PycreditCorpDebtService pycreditCorpDebtService;

    /**
     * @Fields  : 企业银行卡核查业务层
     */
    @Autowired
    private PycreditCorpBkcheckService pycreditCorpBkcheckService;

    /**
     * @Fields  : 企业风险业务层
     */
    @Autowired
    private PycreditCorpRiskService pycreditCorpRiskService;

    /**
     * @Fields  : 驾驶证核查业务层
     */
    @Autowired
    private PycreditDriverService pycreditDriverService;

    /**
     * @Fields  : 个人银行卡核查业务层
     */
    @Autowired
    private PycreditPersonBkcheckService pycreditPersonBkcheckService;


    /**
     * @Title:
     * @Description: 分页查询鹏元查询一览
     * @param pycreditListVo
     * @return PageInfoExtend<PycreditList>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public PageInfoExtend<PycreditList> findPycreditListsByPage(PycreditListVo pycreditListVo){
        Example example = SqlUtil.newExample(PycreditList.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditList> pageInfo = pycreditListRepository.selectListByExamplePage(example,pycreditListVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存鹏元查询一览
     * @param pycreditListSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public void savePycreditList(PycreditListSaveVo pycreditListSaveVo){
        pycreditListRepository.insertData(pycreditListSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改鹏元查询一览
     * @param pycreditListModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public void modifyPycreditList(PycreditListModifyVo pycreditListModifyVo){
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditId删除鹏元查询一览
     * @param pycreditListDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public void deletePycreditList(PycreditListDeleteVo pycreditListDeleteVo){
        pycreditListRepository.deleteData(pycreditListDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditId集合删除鹏元查询一览
     * @param pycreditListDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public void deletePycreditListsByPycreditIds(PycreditListDeleteListVo pycreditListDeleteListVo){
        pycreditListRepository.deleteDataList(pycreditListDeleteListVo.getPycreditIds(),pycreditListDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditId获取鹏元查询一览
     * @param pycreditId
     * @return PycreditList
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    public PycreditList findPycreditListByPycreditId(String pycreditId){
        return pycreditListRepository.selectByPrimaryKey(pycreditId);
    }

    /**
     * @Title:
     * @Description: 根据申请编号查询鹏元一览
     * @param applyNo
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:21
     */
    @Override
    public List<PycreditListVo> findPycreditListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(PycreditList.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<PycreditList> pycreditLists = pycreditListRepository.selectListByExample(example);

        //构建返回pycreditListVo
        List<PycreditListVo> pycreditListVoList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(pycreditLists)){
            for (PycreditList pycreditList : pycreditLists){
                PycreditListVo pycreditListVo = EntityUtils.getEntity(pycreditList, new PycreditListVo());
                if(StringUtils.isNotTrimBlank(pycreditList.getPycreditResultId())){
                    //反欺诈分析
                    if(PycreditTypeEnums.ANTI.getType().equals(pycreditList.getPycreditType())){
                        PycreditAnti pycreditAnti = pycreditAntiService.findPycreditAntiByPycreditAntiId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditAnti(pycreditAnti);
                    }else if(PycreditTypeEnums.ADDR1.getType().equals(pycreditList.getPycreditType())
                        || PycreditTypeEnums.ADDR2.getType().equals(pycreditList.getPycreditType())){
                        //地址核验
                        PycreditAddr pycreditAddr = pycreditAddrService.findPycreditAddrByPycreditAddrId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditAddr(pycreditAddr);
                    }else if(PycreditTypeEnums.PERSON_BKCHECK.getType().equals(pycreditList.getPycreditType())){
                        //个人银行卡核查
                        PycreditPersonBkcheck pycreditPersonBkcheck= pycreditPersonBkcheckService.findPycreditPersonBkcheckByPycreditPersonBkcheckId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditPersonBkcheck(pycreditPersonBkcheck);
                    }else if(PycreditTypeEnums.CARD_CHECK.getType().equals(pycreditList.getPycreditType())){
                        //卡核查及交易
                        PycreditCardCheck pycreditCardCheck= pycreditCardCheckService.findPycreditCardCheckByPycreditCardCheckId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditCardCheck(pycreditCardCheck);
                    }
                    else if(PycreditTypeEnums.CORP_BKCHECK.getType().equals(pycreditList.getPycreditType())){
                        //企业银行卡核查
                        PycreditCorpBkcheck pycreditCorpBkcheck = pycreditCorpBkcheckService.findPycreditCorpBkcheckByPycreditCorpBkcheckId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditCorpBkcheck(pycreditCorpBkcheck);
                    }else if(StringUtils.isNotTrimBlank(pycreditList.getPycreditType())
                            && pycreditList.getPycreditType().startsWith(PycreditTypeEnums.DRIVER.getType())){
                        //驾驶证核查
                        PycreditDriver pycreditDriver = pycreditDriverService.findPycreditDriverByPycreditDriverId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditDriver(pycreditDriver);
                    }else if(PycreditTypeEnums.CORP_RISK.getType().equals(pycreditList.getPycreditType())){
                        //企业风险
                        PycreditCorpRisk pycreditCorpRisk = pycreditCorpRiskService.findPycreditCorpRiskByPycreditCorpRiskId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditCorpRisk(pycreditCorpRisk);
                    }else if(PycreditTypeEnums.CORP_DEBT.getType().equals(pycreditList.getPycreditType())){
                        //企业债务
                        PycreditCorpDebt pycreditCorpDebt = pycreditCorpDebtService.findPycreditCorpDebtByPycreditCorpDebtId(pycreditList.getPycreditResultId());
                        pycreditListVo.setPycreditCorpDebt(pycreditCorpDebt);
                    }

                }
                pycreditListVoList.add(pycreditListVo);

            }
            return pycreditListVoList;
        }

        return null;
    }
}
