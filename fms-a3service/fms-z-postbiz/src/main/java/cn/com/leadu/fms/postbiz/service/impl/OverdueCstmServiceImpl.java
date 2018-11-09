package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BankOrganizationTypeEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.AssignmentStsEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.system.SysRoleEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueAssignmentRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmAddrRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmTelRepository;
import cn.com.leadu.fms.data.postbiz.repository.OverdueTelRegisterRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterGuaVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.ContRepaySkedOverdueTotalVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverduePostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.rpc.finance.BasBankInfoRpc;
import cn.com.leadu.fms.postbiz.service.OverdueCstmService;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmService
 * @Description: 逾期客户信息业务实现层
 * @date 2018-05-16
 */
@Slf4j
@Service
public class OverdueCstmServiceImpl implements OverdueCstmService {

    /**
     * @Fields  : 逾期客户信息repository
     */
    @Autowired
    private OverdueCstmRepository overdueCstmRepository;

    /**
     * @Fields  : 逾期客户电话信息repository
     */
    @Autowired
    private OverdueCstmTelRepository overdueCstmTelRepository;

    /**
     * @Fields  : 逾期客户地址信息repository
     */
    @Autowired
    private OverdueCstmAddrRepository overdueCstmAddrRepository;

    /**
     * @Fields  : 电话催收登记信息repository
     */
    @Autowired
    private OverdueTelRegisterRepository overdueTelRegisterRepository;

    /**
     * @Fields  : 当日逾期任务信息repository
     */
    @Autowired
    private OverdueAssignmentRepository overdueAssignmentRepository;
    @Autowired
    private CommonPdfService commonPdfService;
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;
    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息
     * @param overdueCstmVo
     * @return PageInfoExtend<OverdueCstm>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public PageInfoExtend<OverduePostVo> findOverdueCstmsByPage(OverdueCstmVo overdueCstmVo,SysUser sysUser){
        List<String> roleList = sysUserRepository.selectRolesByUser(sysUser.getUser());
        // 参数构造
        overdueCstmVo = buildParams(overdueCstmVo, roleList, sysUser);

        PageInfoExtend<OverduePostVo> pageInfo = overdueCstmRepository.selectListVoByPage("selectOverdueCstmsByPage", overdueCstmVo, overdueCstmVo.getPageQuery());
        return pageInfo;
    }

    /**
     * 检索参数构造
     * @param overdueCstmVo
     */
    private OverdueCstmVo buildParams(OverdueCstmVo overdueCstmVo, List<String> roleList,SysUser sysUser) {
        // 承租人处理
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getCstmName())){
            overdueCstmVo.setCstmName(SqlUtil.likePattern(overdueCstmVo.getCstmName()));
        }else{
            overdueCstmVo.setCstmName(null);
        }
        // 合同号处理
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getContNo())){
            overdueCstmVo.setContNo(SqlUtil.likePattern(overdueCstmVo.getContNo()));
        }else{
            overdueCstmVo.setContNo(null);
        }
        // 车架号处理
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getVinNo())){
            overdueCstmVo.setVinNo(SqlUtil.likePattern(overdueCstmVo.getVinNo()));
        }else{
            overdueCstmVo.setVinNo(null);
        }
        // 客户逾期天数起始天数处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getCstmOverdueStartDays())){
            overdueCstmVo.setCstmOverdueStartDays(null);
        }
        // 客户逾期天数结束天数处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getCstmOverdueEndDays())){
            overdueCstmVo.setCstmOverdueEndDays(null);
        }
        // 合同逾期天数起始天数处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getContOverdueStartDays())){
            overdueCstmVo.setContOverdueStartDays(null);
        }
        // 合同逾期天数结束天数处理
        if (StringUtils.isTrimBlank(overdueCstmVo.getContOverdueEndDays())){
            overdueCstmVo.setContOverdueEndDays(null);
        }
        // 当前是否逾期（逾期合同）
        if (StringUtils.isTrimBlank(overdueCstmVo.getOverdueFlag())){
            overdueCstmVo.setOverdueFlag(null);
        }
        // 催收类型
        if (StringUtils.isTrimBlank(overdueCstmVo.getAssignmentType())){
            overdueCstmVo.setAssignmentType(null);
        }
        if (roleList.contains(SysRoleEnums.FK102.getId())){
            // 如果是风控初审用户，分配人员设定为当前登录用户
            overdueCstmVo.setAssignUser(sysUser.getUser());
        } else {
            // 分配人员账号
            if (StringUtils.isTrimBlank(overdueCstmVo.getAssignUser())){
                overdueCstmVo.setAssignUser(null);
            }
        }
        // 出租人
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getGroupName())){
            overdueCstmVo.setGroupName(SqlUtil.likePattern(overdueCstmVo.getGroupName()));
        } else {
            overdueCstmVo.setGroupName(null);
        }
        // 任务处理状态
        if (StringUtils.isTrimBlank(overdueCstmVo.getAssignmentSts())){
            overdueCstmVo.setAssignmentSts(null);
        }
        return overdueCstmVo;
    }

    /**
     * @Title:
     * @Description: 保存逾期客户信息
     * @param overdueCstmPostVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Transactional
    @Override
    public void saveOverdueCstmInfo(OverdueCstmPostVo overdueCstmPostVo, SysUser sysUser) {
        //保存电话催收信息
        OverdueTelRegister overdueTelRegister = new OverdueTelRegister();
        BeanUtils.copyProperties(overdueCstmPostVo, overdueTelRegister);//逾期电话登记实体数据映射
        overdueTelRegister.setAssignDate(new Date());//分配日期
        overdueTelRegister.setAssignUser(sysUser.getUser());//分配人员账号
        //向电话催收登记表登录数据
        overdueTelRegisterRepository.insertData(overdueTelRegister);
        // 处理逾期客户地址信息（更新与插入）
        saveOverdueCstmAddr(overdueCstmPostVo);
        // 处理逾期客户电话信息（更新与插入）
        saveOverdueCstmTel(overdueCstmPostVo);
        // 更新当日逾期任务表
        updateOverdueAssignment(overdueCstmPostVo);
    }

    /**
     * @Title:
     * @Description: 催收函生成
     * @param overdueCstmPostVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public FileVo collectionLetterDownload(OverdueCstmPostVo overdueCstmPostVo) {
        if (StringUtils.isTrimBlank(overdueCstmPostVo.getContNo())){
            throw new FmsServiceException("参数不正确");
        }
        // 获取催收函生成需要数据
        CollectionLetterVo collectionLetterVo = overdueCstmRepository.selectCollectionLetterInfo(overdueCstmPostVo.getContNo());
        if (collectionLetterVo == null){
            throw new FmsServiceException("当前合同没有符合条件的逾期数据");
        }
        // 获取银行机构信息
        BasBankInfo basBankInfoGroup = getBasBankInfo(collectionLetterVo.getBelongGroup());
        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(collectionLetterVo);
        // 设定赋值项目
        buildMapParams(collectionLetterVo.getContRepaySkedVoList(), basBankInfoGroup, pdfVariables);

        FileVo fileResult = new FileVo();
        List<FileVo> files = new ArrayList<>();
        String filePath;
        FileVo fileVo;
        if (StringUtils.equals(ApplyTypeEnums.PERSON.getType(), overdueCstmPostVo.getApplyType())){
            // 生成承租人个人催告函
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_PER_CSTM.getType());
            fileVo = new FileVo();
            fileVo.setFileCompletePath(filePath);
            fileVo.setFileName("催告函-个人"+"（"+collectionLetterVo.getCstmName()+"）.pdf");
            files.add(fileVo);
            // 生成担保个人与担保企业pdf
            pdfCreateGuarantee(collectionLetterVo, pdfVariables, files);
        } else {
            // 获取催告函企业承租人下载路径
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_COM_CSTM.getType());
            fileVo = new FileVo();
            fileVo.setFileCompletePath(filePath);
            fileVo.setFileName("催告函-企业"+"（"+collectionLetterVo.getCstmName()+"）.pdf");
            files.add(fileVo);
            // 生成担保个人与担保企业pdf
            pdfCreateGuarantee(collectionLetterVo, pdfVariables, files);
        }
        String fileZipPath = CommonFileUtils.filesToZip(files,null);
        fileResult.setFilePath(fileZipPath);
        fileResult.setFileName("催告函（"+collectionLetterVo.getCstmName()+"）.zip");
        return fileResult;
    }

    /**
     * 获取银行机构信息
     * @param belongGroup
     * @return
     */
    @Override
    public BasBankInfo getBasBankInfo(String belongGroup) {
        BasBankInfo basBankInfoGroup;
        //取得出租人银行账号信息
        try {
            basBankInfoGroup = ResponseEntityUtils.getRestResponseData(basBankInfoRpc.findBasBankInfoByOrg(BankOrganizationTypeEnums.USER_GROUP.getType(), belongGroup));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("银行账号取得失败");
        }
        return basBankInfoGroup;
    }

    /**
     * @Title:
     * @Description: 律师函生成
     * @param overdueCstmPostVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public FileVo lawyerLetterDownload(OverdueCstmPostVo overdueCstmPostVo) {
        if (StringUtils.isTrimBlank(overdueCstmPostVo.getContNo())){
            throw new FmsServiceException("参数不正确");
        }

        // 获取催收函生成需要数据
        LawyerLetterVo lawyerLetterVo = overdueCstmRepository.selectLawyerLetterInfo(overdueCstmPostVo.getContNo());
        if (lawyerLetterVo == null){
            throw new FmsServiceException("当前合同没有符合条件的逾期数据");
        }
        // 获取银行机构信息
        BasBankInfo basBankInfoGroup = getBasBankInfo(lawyerLetterVo.getBelongGroup());

        //pdf的参数
        Map<String,String> pdfVariables = JsonUtils.objectToMap(lawyerLetterVo);
        // 设定赋值项目
        buildMapParams(lawyerLetterVo.getContRepaySkedVoList(), basBankInfoGroup, pdfVariables);
        Example example = SqlUtil.newExample(ContRepaySked.class);
        example.createCriteria().andEqualTo("contNo", overdueCstmPostVo.getContNo()).andEqualTo("period", "1");
        ContRepaySked contRepaySked = contRepaySkedRepository.selectOneByExample(example);
        if (contRepaySked != null){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            // 设定首期支付日期
            pdfVariables.put("firstRepayDate", sdf.format(contRepaySked.getRepayDate()));
        }
        String filePath ;
        if (StringUtils.equals(ApplyTypeEnums.PERSON.getType(), overdueCstmPostVo.getApplyType())){
            // 生成承租人个人律师函
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.LAWYER_LETTER_PER.getType());
        } else {
            // 生成承租人企业律师函
            filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.LAWYER_LETTER_COM.getType());
        }
        FileVo fileVo = new FileVo();
        fileVo.setFilePath(filePath);
        fileVo.setFileName("律师函-"+"（"+lawyerLetterVo.getCstmName()+"）.pdf");
        return fileVo;
    }

    /**
     * 设定赋值项目
     * @param contRepaySkedVoList
     * @param basBankInfoGroup
     * @return
     */
    @Override
    public void buildMapParams(List<ContRepaySkedVo> contRepaySkedVoList, BasBankInfo basBankInfoGroup, Map<String,String> pdfVariables) {
        // 初始化租金合计
        BigDecimal rent = BigDecimal.ZERO;
        // 初始化逾期违约金合计
        BigDecimal overdueSum = BigDecimal.ZERO;
        for (ContRepaySkedVo contRepaySkedVo : contRepaySkedVoList){
            overdueSum = overdueSum.add(contRepaySkedVo.getRestOverdueAmount()==null?BigDecimal.ZERO:contRepaySkedVo.getRestOverdueAmount());//计算剩余罚息金额合计
        }
        // 初始化逾期期数
        String period = "";
        String repayDate = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        if (ArrayUtils.isNotNullAndLengthNotZero(contRepaySkedVoList)){
            // 获取逾期开始期数
            String periodStart = String.valueOf(contRepaySkedVoList.get(0).getPeriod());
            // 获取逾期结束期数
            String periodEnd = String.valueOf(contRepaySkedVoList.get(contRepaySkedVoList.size()-1).getPeriod());
            repayDate = sdf.format(contRepaySkedVoList.get(contRepaySkedVoList.size()-1).getRepayDate());
            if (StringUtils.equals(periodStart, periodEnd)){
                // 期数相同，则取开始期数
                period = periodStart;
            } else {
                // 期数不相同，进行拼接
                period = periodStart.concat("-").concat(periodEnd);
            }
            for (ContRepaySkedVo contRepaySkedVo : contRepaySkedVoList){
                // 计算逾期租金合计
                rent = rent.add(contRepaySkedVo.getRent());
            }
        }
        // 设定赋值项目
        buildMap(basBankInfoGroup, rent, period, repayDate, sdf, pdfVariables, overdueSum);
    }

    /**
     * 生成担保个人与担保企业pdf
     * @param collectionLetterVo
     * @param pdfVariables
     */
    @Override
    public void pdfCreateGuarantee(CollectionLetterVo collectionLetterVo, Map<String, String> pdfVariables, List<FileVo> files) {
        String filePath;
        FileVo fileVo;
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionLetterVo.getGuaranteePersVoList())){
            CollectionLetterGuaVo collectionLetterGuaVo;
            for (GuaranteePersVo guaranteePersVo : collectionLetterVo.getGuaranteePersVoList()){
                // 担保人（企业）模板生成数据实体初始化
                collectionLetterGuaVo = new CollectionLetterGuaVo();
                // 数据映射
                BeanUtils.copyProperties(collectionLetterVo, collectionLetterGuaVo);
                // 设定担保人姓名
                collectionLetterGuaVo.setGuaranteeName(guaranteePersVo.getName());
                // 设定担保保函编号
                collectionLetterGuaVo.setGuaranteeNo(collectionLetterGuaVo.getContNo().concat("-3"));
                // 构造生成担保人Map
                Map<String,String> pdfVariablesGua = JsonUtils.objectToMap(collectionLetterGuaVo);
                pdfVariables.putAll(pdfVariablesGua);
                if (StringUtils.equals("collectionTask", collectionLetterVo.getFlag())){
                    // 如果是上门催收任务
                    // 生成担保人催告函-上门催收
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_TASK_GUA_PER.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催告函-个人"+"（"+collectionLetterGuaVo.getGuaranteeName()+"）.pdf");
                    files.add(fileVo);
                } else {
                    // 如果是逾期一览进入
                    // 生成担保人催告函
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_GUA_PER.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催告函-个人"+"（"+collectionLetterGuaVo.getGuaranteeName()+"）.pdf");
                    files.add(fileVo);
                }
            }
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(collectionLetterVo.getGuaranteeCompVoList())){
            CollectionLetterGuaVo collectionLetterGuaVo;
            for (GuaranteeCompVo guaranteeCompVo : collectionLetterVo.getGuaranteeCompVoList()){
                // 担保人（企业）模板生成数据实体初始化
                collectionLetterGuaVo = new CollectionLetterGuaVo();
                // 数据映射
                BeanUtils.copyProperties(collectionLetterVo, collectionLetterGuaVo);
                // 设定担保企业名称
                collectionLetterGuaVo.setGuaranteeName(guaranteeCompVo.getName());
                // 设定担保保函编号
                collectionLetterGuaVo.setGuaranteeNo(collectionLetterGuaVo.getContNo().concat("-3"));
                // 构造生成担保企业Map
                Map<String,String> pdfVariablesGua = JsonUtils.objectToMap(collectionLetterGuaVo);
                pdfVariables.putAll(pdfVariablesGua);
                if (StringUtils.equals("collectionTask", collectionLetterVo.getFlag())){
                    // 如果是上门催收任务
                    // 生成担保企业催告函
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_TASK_GUA_COM.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催告函-企业"+"（"+collectionLetterGuaVo.getGuaranteeName()+"）.pdf");
                    files.add(fileVo);
                } else {
                    // 如果是逾期一览进入
                    // 生成担保企业催告函
                    filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.COLLECTION_LETTER_GUA_COM.getType());
                    fileVo = new FileVo();
                    fileVo.setFileCompletePath(filePath);
                    fileVo.setFileName("催告函-企业"+"（"+collectionLetterGuaVo.getGuaranteeName()+"）.pdf");
                    files.add(fileVo);
                }
            }
        }
    }

    /**
     * @Title:
     * @Description: 获取分配人员信息
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public List<SysUser> findAssignUsers() {
        List<String> roleCodeList = new ArrayList<>();
        roleCodeList.add(SysRoleEnums.FK101.getId());// 风控初审角色
        roleCodeList.add(SysRoleEnums.FK102.getId());// 风控复审角色
        List<SysUser> sysUserList = overdueCstmRepository.selectAssignUsers(roleCodeList);
        return sysUserList;
    }

    /**
     * 设定赋值项目
     * @param basBankInfoGroup
     * @param rent
     * @param period
     * @param repayDate
     * @param sdf
     * @param pdfVariables
     */
    private void buildMap(BasBankInfo basBankInfoGroup, BigDecimal rent, String period, String repayDate
            , SimpleDateFormat sdf, Map<String, String> pdfVariables, BigDecimal overdueSum) {
        if (basBankInfoGroup != null){
            // 设定出租人开户名
            pdfVariables.put("accountName", basBankInfoGroup.getAccountName());
            // 设定出租人开户行
            pdfVariables.put("accBank", basBankInfoGroup.getAccBranchBank());
            // 设定出租人开账号
            pdfVariables.put("accountNo", basBankInfoGroup.getAccountNo());
        }
        // 设定期数
        pdfVariables.put("period", period);
        // 设定逾期租金
        pdfVariables.put("rent", String.valueOf(rent));
        pdfVariables.put("rent1", String.valueOf(rent));
        // 设定逾期日期
        pdfVariables.put("repayDate", repayDate);
        // 设定当前日期
        pdfVariables.put("nowDate", sdf.format(DateUtils.getNowDate()));
        // 设定逾期违约金
        pdfVariables.put("overdueSum", String.valueOf(overdueSum));
    }

    /**
     * 处理逾期客户电话信息（更新与插入）
     * @param overdueCstmPostVo
     */
    private void saveOverdueCstmTel(OverdueCstmPostVo overdueCstmPostVo) {
        // 逾期客户电话信息更新List初始化
        List<OverdueCstmTel> overdueCstmTelUpdateList = new ArrayList<>();
        // 逾期客户电话信息插入List初始化
        List<OverdueCstmTel> overdueCstmTelInsertList = new ArrayList<>();
        Example example ;
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmPostVo.getOverdueCstmTelList())){
            for(OverdueCstmTel overdueCstmTelEntity : overdueCstmPostVo.getOverdueCstmTelList()){
                if (overdueCstmTelEntity.getOverdueCstmTelId() != null){
                    example = SqlUtil.newExample(OverdueCstmTel.class);
                    example.createCriteria().andEqualTo("overdueCstmTelId", overdueCstmTelEntity.getOverdueCstmTelId());
                    OverdueCstmTel overdueCstmTel = overdueCstmTelRepository.selectOneByExample(example);
                    // 如果联系信息有改变，进行更新
                    if (isOverdueCstmTelChange(overdueCstmTel, overdueCstmTelEntity)){
                        // 主键不为空，则是原有的电话信息，进行更新
                        overdueCstmTelUpdateList.add(overdueCstmTelEntity);
                    }
                } else {
                    overdueCstmTelEntity.setApplyNo(overdueCstmPostVo.getApplyNo());
                    overdueCstmTelEntity.setCertifNo(overdueCstmPostVo.getCertifNo());
                    // 主键为空，则是新增的电话信息
                    overdueCstmTelInsertList.add(overdueCstmTelEntity);
                }
            }
        }

        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmTelUpdateList)){
            //更新逾期客户电话信息表
            overdueCstmTelRepository.updateByPrimaryKeySelectiveDataList(overdueCstmTelUpdateList);
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmTelInsertList)){
            //登录逾期客户电话信息表
            overdueCstmTelRepository.insertDataList(overdueCstmTelInsertList);
        }
    }

    /**
     * 校验逾期客户电话信息是否被修改
     * @param oldEntity
     * @param newEntity
     * @return
     */
    private Boolean isOverdueCstmTelChange(OverdueCstmTel oldEntity, OverdueCstmTel newEntity){
        // 验证联系人信息是否被改变
        if (StringUtils.notEquals(oldEntity.getRelationType(), newEntity.getRelationType())
                || StringUtils.notEquals(oldEntity.getCstmName(), newEntity.getCstmName())
                || StringUtils.notEquals(oldEntity.getTelNo(), newEntity.getTelNo())){
            // 联系人类型 联系人姓名 电话号码如果有任何一个改变，则需要被更新
            return true;
        }
        return false;
    }

    /**
     * 校验逾期客户地址信息是否被修改
     * @param oldEntity
     * @param newEntity
     * @return
     */
    private Boolean isOverdueCstmAddrChange(OverdueCstmAddr oldEntity, OverdueCstmAddr newEntity){
        // 验证地址人信息是否被改变
        if (StringUtils.notEquals(oldEntity.getRelationType(), newEntity.getRelationType())
                || StringUtils.notEquals(oldEntity.getCstmName(), newEntity.getCstmName())
                || StringUtils.notEquals(oldEntity.getAddrType(), newEntity.getAddrType())
                || StringUtils.notEquals(oldEntity.getAddress(), newEntity.getAddress())
                || StringUtils.notEquals(oldEntity.getValidFlag(), newEntity.getValidFlag())
                || StringUtils.notEquals(oldEntity.getMeno(), newEntity.getMeno())){
            // 联系人 类型 联系人姓名 地址类型 地址 是否有效 备注信息如果有任何一个改变，则需要被更新
            return true;
        }
        return false;
    }

    /**
     * 处理逾期客户地址信息（更新与插入）
     * @param overdueCstmPostVo
     */
    private void saveOverdueCstmAddr(OverdueCstmPostVo overdueCstmPostVo) {
        // 逾期客户地址信息更新List初始化
        List<OverdueCstmAddr> overdueCstmAddrUpdateList = new ArrayList<>();
        // 逾期客户地址信息插入List初始化
        List<OverdueCstmAddr> overdueCstmAddrInsertList = new ArrayList<>();
        Example example;
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmPostVo.getOverdueCstmAddrList())){
            for(OverdueCstmAddr overdueCstmAddrEntity : overdueCstmPostVo.getOverdueCstmAddrList()){
                if (overdueCstmAddrEntity.getOverdueCstmAddrId() != null){
                    example = SqlUtil.newExample(OverdueCstmAddr.class);
                    example.createCriteria().andEqualTo("overdueCstmAddrId", overdueCstmAddrEntity.getOverdueCstmAddrId());
                    OverdueCstmAddr overdueCstmAddr = overdueCstmAddrRepository.selectOneByExample(example);
                    // 如果联系信息有改变，进行更新
                    if (isOverdueCstmAddrChange(overdueCstmAddr, overdueCstmAddrEntity)){
                        // 主键不为空，则是原有的地址信息，进行更新
                        overdueCstmAddrUpdateList.add(overdueCstmAddrEntity);
                    }
                } else {
                    overdueCstmAddrEntity.setCertifNo(overdueCstmPostVo.getCertifNo());
                    overdueCstmAddrEntity.setApplyNo(overdueCstmPostVo.getApplyNo());
                    // 主键为空，则是新增的地址信息
                    overdueCstmAddrInsertList.add(overdueCstmAddrEntity);
                }
            }
        }

        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmAddrUpdateList)){
            //更新逾期客户地址信息表
            overdueCstmAddrRepository.updateByPrimaryKeySelectiveDataList(overdueCstmAddrUpdateList);
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmAddrInsertList)){
            //登录逾期客户地址信息表
            overdueCstmAddrRepository.insertDataList(overdueCstmAddrInsertList);
        }
    }

    private void updateOverdueAssignment(OverdueCstmPostVo overdueCstmPostVo) {
        Example overdueAssignmentExample = SqlUtil.newExample(OverdueAssignment.class);
        overdueAssignmentExample.createCriteria().andEqualTo("overdueCstmId", overdueCstmPostVo.getOverdueCstmId());
        OverdueAssignment overdueAssignment = overdueAssignmentRepository.selectOneByExample(overdueAssignmentExample);
        //设定处理状态
        if (overdueAssignment != null){
            overdueAssignment.setAssignmentSts(AssignmentStsEnums.PROCESSED.getType());//1-已处理
        }
        //更新当日逾期任务表
        overdueAssignmentRepository.updateByPrimaryKeySelectiveData(overdueAssignment);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public OverdueCstmVo findOverdueCstmByOverdueCstmId(String overdueCstmId){
        //根据逾期客户ID，检索【逾期客户表】【逾期合同表】
        OverdueCstmVo overdueCstmVo = overdueCstmRepository.selectOverdueCstmByOverdueCstmId(overdueCstmId);
        if (overdueCstmVo != null){
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmVo.getOverdueContVoList())){
                for (OverdueContVo overdueContVo : overdueCstmVo.getOverdueContVoList()){
                    if (!StringUtils.equals(overdueContVo.getOrigFileStatus(), OrigFileStatusEnums.ARCHIVED.getType())){
                        // 如果归档状态为未归档，归档逾期天数显示 当日-归档期限
                        if (overdueContVo.getOrigDeadline() != null){
                            // 获取当前日期与归档期限的日期差（取天数）
                            int days = (int) ((DateUtils.getNowDate().getTime() - overdueContVo.getOrigDeadline().getTime()) / (1000*3600*24));
                            // 归档逾期天数
                            overdueContVo.setOrigOverdueDays(days);
                        }
                    } else {
                        // 如果归档状态为已归档，归档逾期天数显示0
                        overdueContVo.setOrigOverdueDays(0);
                    }
                }
            }
            if (StringUtils.isNotTrimBlank(overdueCstmVo.getCertifNo())){
                //获取逾期客户电话信息
                Example example = SqlUtil.newExample(OverdueCstmTel.class);
                example.createCriteria().andEqualTo("certifNo", overdueCstmVo.getCertifNo());
                List<OverdueCstmTel> overdueCstmTelList = overdueCstmTelRepository.selectListByExample(example);
                if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmTelList)){
                    overdueCstmVo.setOverdueCstmTelList(overdueCstmTelList);
                }
            }
            //获取电话催收登记信息
            List<OverdueTelRegisterVo> overdueTelRegisterVoList = overdueCstmRepository.selectOverdueTelRegister(overdueCstmId);
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueTelRegisterVoList)){
                overdueCstmVo.setOverdueTelRegisterVoList(overdueTelRegisterVoList);
            }

            // 获取上门催收数据
            List<CollectionTaskVo> collectionTaskVoList = overdueCstmRepository.selectCollectionTaskList(overdueCstmId);
            if (ArrayUtils.isNotNullAndLengthNotZero(collectionTaskVoList)){
                overdueCstmVo.setCollectionTaskVoList(collectionTaskVoList);
            }
            // 获取收车信息List
            List<RetrieveCarsTaskVo> retrieveCarsTaskVoList = overdueCstmRepository.selectRetrieveCarsTaskVoList(overdueCstmId);
            if (ArrayUtils.isNotNullAndLengthNotZero(retrieveCarsTaskVoList)){
                overdueCstmVo.setRetrieveCarsTaskVoList(retrieveCarsTaskVoList);
            }

            //获取诉讼信息List
            List<LawsuitTaskVo> lawsuitTaskVoList = overdueCstmRepository.selectLawsuitTaskVoList(overdueCstmId);
            if (ArrayUtils.isNotNullAndLengthNotZero(lawsuitTaskVoList)){
                overdueCstmVo.setLawsuitTaskVoList(lawsuitTaskVoList);
            }
        }
        return overdueCstmVo;
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public OverdueCstmVo findOverdueCstmVoByOverdueCstmId(String overdueCstmId){
        //根据逾期客户ID，检索【逾期客户表】【逾期催收表】
        OverdueCstmVo overdueCstmVo = overdueCstmRepository.selectOverdueCstmVoByOverdueCstmId(overdueCstmId);
        return overdueCstmVo;
    }

    /**
     * @Title:
     * @Description:   当前逾期总额--->查看列表 合同还款计划表 + 逾期罚息表
     * @param overdueCstmVo
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public PageInfoExtend<ContRepaySkedOverdueTotalVo> findContRepaySkedAndOverduByoverdueCstmId(OverdueCstmVo overdueCstmVo){
        overdueCstmVo = solveOverdueCstm(overdueCstmVo);
        if(StringUtils.isTrimBlank(overdueCstmVo.getContNo()) && ArrayUtils.isNullOrLengthZero(overdueCstmVo.getContNoList())){
            return  PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,overdueCstmVo.getPageQuery(),ContRepaySkedVo.class);
        }
        PageInfoExtend<ContRepaySkedOverdueTotalVo> pageInfo = overdueCstmRepository.selectListVoByPage("selectContRepaySkedAndOverduByoverdueCstmId", overdueCstmVo, overdueCstmVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 当前销售未还剩余本金
     * @param overdueCstmVo
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public PageInfoExtend<ContRepaySkedVo> findContRepaySkedVoByContNo(OverdueCstmVo overdueCstmVo){
        overdueCstmVo = solveOverdueCstm(overdueCstmVo);
        if(StringUtils.isTrimBlank(overdueCstmVo.getContNo()) && ArrayUtils.isNullOrLengthZero(overdueCstmVo.getContNoList())){
            return  PageInfoExtendUtils.getPageInfoExtend(new ArrayList(),(long)0,overdueCstmVo.getPageQuery(),ContRepaySkedVo.class);
        }
        PageInfoExtend<ContRepaySkedVo> pageInfo = overdueCstmRepository.selectListVoByPage("selectContRepaySkedVoByContNo", overdueCstmVo, overdueCstmVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  当前财务未还剩余本金
     * @param overdueCstmVo
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    public PageInfoExtend<FinRepaySkedVo> findContOverdueVoByContNo(OverdueCstmVo overdueCstmVo){

        // 构造检索参数
        overdueCstmVo = solveOverdueCstm(overdueCstmVo);
        PageInfoExtend<FinRepaySkedVo> pageInfo = overdueCstmRepository.selectListVoByPage("selectContOverdueVoByContNo", overdueCstmVo, overdueCstmVo.getPageQuery());
        return pageInfo;
    }

    /**
     * 构造检索参数
     * @param overdueCstmVo
     * @return
     */
    private OverdueCstmVo solveOverdueCstm(OverdueCstmVo overdueCstmVo){
        if (StringUtils.isNotTrimBlank(overdueCstmVo.getOverdueCstmId())) {
            //获取客户的所有逾期合同的合同号
            List<String> contNoList = overdueCstmRepository.selectContNoListByOverdueCstmId(overdueCstmVo.getOverdueCstmId());
            if (ArrayUtils.isNotNullAndLengthNotZero(contNoList)) {
                overdueCstmVo.setContNoList(contNoList);
            } else {
                overdueCstmVo.setContNoList(null);
            }
        } else {
            overdueCstmVo.setContNoList(null);
        }
        if (StringUtils.isTrimBlank(overdueCstmVo.getContNo())){
            overdueCstmVo.setContNo(null);
        }
        return overdueCstmVo;
    }

    /**
     * @Title:
     * @Description:  获取登记电话、地址等基础信息
     * @param overdueCstmPostVo
     * @return OverdueCstm
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @Override
    public OverdueCstmPostVo findOverdueRegisterInfo(OverdueCstmPostVo overdueCstmPostVo){
        if (StringUtils.isNotTrimBlank(overdueCstmPostVo.getOverdueCstmTelId()) && StringUtils.isNotTrimBlank(overdueCstmPostVo.getOverdueCstmId())){
            OverdueCstmPostVo overdueCstmPostVoResult = new OverdueCstmPostVo();
            overdueCstmPostVoResult.setOverdueCstmId(overdueCstmPostVo.getOverdueCstmId());
            overdueCstmPostVoResult.setOverdueCstmTelId(overdueCstmPostVo.getOverdueCstmTelId());
            // 根据逾期客户电话信息ID获取逾期客户电话信息
            OverdueCstmTelVo overdueCstmTelVo = overdueCstmRepository.selectOverdueCstmTelVoByOverdueCstmTelId(overdueCstmPostVo.getOverdueCstmTelId());
            if(overdueCstmTelVo != null){
                overdueCstmPostVoResult.setApplyNo(overdueCstmTelVo.getApplyNo());//申请编号
                overdueCstmPostVoResult.setCstmName(overdueCstmTelVo.getCstmName());//客户姓名
                overdueCstmPostVoResult.setRelationType(overdueCstmTelVo.getRelationType());//关系类型
                overdueCstmPostVoResult.setTelNo(overdueCstmTelVo.getTelNo());//联系电话
                overdueCstmPostVoResult.setRelationer(overdueCstmTelVo.getRelationer());//联系人
            }

            //设定逾期客户地址信息List
            Example overdueCstmAddrExample = SqlUtil.newExample(OverdueCstmAddr.class);
            overdueCstmAddrExample.createCriteria().andEqualTo("certifNo", overdueCstmPostVo.getCertifNo());
            // 获取逾期客户地址信息List
            List<OverdueCstmAddr> overdueCstmAddrList = overdueCstmAddrRepository.selectListByExample(overdueCstmAddrExample);
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmAddrList)){
                overdueCstmPostVoResult.setOverdueCstmAddrList(overdueCstmAddrList);
            }

            //设定逾期客户电话信息List
            Example overdueCstmTelExample = SqlUtil.newExample(OverdueCstmTel.class);
            overdueCstmTelExample.createCriteria().andEqualTo("certifNo", overdueCstmPostVo.getCertifNo());
            // 获取逾期客户电话信息List
            List<OverdueCstmTel> overdueCstmTelList = overdueCstmTelRepository.selectListByExample(overdueCstmTelExample);
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueCstmTelList)){
                overdueCstmPostVoResult.setOverdueCstmTelList(overdueCstmTelList);
            }

            //设定电话催收登记信息List
            List<OverdueTelRegisterVo> overdueTelRegisterVoList = overdueCstmRepository.selectOverdueTelRegisterVoByOverdueCstmId(overdueCstmPostVo.getOverdueCstmId());
            if (ArrayUtils.isNotNullAndLengthNotZero(overdueTelRegisterVoList)){
                overdueCstmPostVoResult.setOverdueTelRegisterVoList(overdueTelRegisterVoList);
            }

            Example overdueAssignmentExample = SqlUtil.newExample(OverdueAssignment.class);
            overdueAssignmentExample.createCriteria().andEqualTo("overdueCstmId", overdueCstmPostVo.getOverdueCstmId());
            OverdueAssignment overdueAssignment = overdueAssignmentRepository.selectOneByExample(overdueAssignmentExample);
            //设定处理状态
            if (overdueAssignment != null){
                overdueCstmPostVoResult.setAssignmentSts(overdueAssignment.getAssignmentSts());
            }
            overdueCstmPostVoResult.setCertifNo(overdueCstmPostVo.getCertifNo());//设定证件号
            return overdueCstmPostVoResult;
        } else {
            throw new FmsServiceException("参数不正确");
        }
    }
}
