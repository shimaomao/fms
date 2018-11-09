package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasBlacklistService;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BlackLevelEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BlackSourceEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.CstmRelationIdentityTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.baseinfo.repository.BasBlacklistRepository;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBlacklist;
import cn.com.leadu.fms.pojo.baseinfo.vo.basblacklist.BasBlacklistVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basblacklist.vo.BasBlacklistDeleteListVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: BasBlacklistService
 * @Description: 黑名单业务实现层
 * @date 2018-05-04
 */
@Service
public class BasBlacklistServiceImpl implements BasBlacklistService {

    /**
     * @Fields : 黑名单repository
     */
    @Autowired
    private BasBlacklistRepository basBlacklistRepository;
    /**
     * @Fields : 客户个人信息repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;
    /**
     * @Fields : 客户企业信息repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;
    /**
     * @Fields : 客户个人配偶信息repository
     */
    @Autowired
    private CstmPersMateRepository cstmPersMateRepository;
    /**
     * @Fields : 客户联系人信息repository
     */
    @Autowired
    private CstmContactRepository cstmContactRepository;
    /**
     * @Fields : 担保个人信息repository
     */
    @Autowired
    private GuaranteePersRepository guaranteePersRepository;
    /**
     * @Fields : 担保企业信息repository
     */
    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;
    /**
     * @Fields : 共通借款人息repository
     */
    @Autowired
    private CommonBorrowerRepository commonBorrowerRepository;

    /**
     * @param basBlacklistVo
     * @return PageInfoExtend<BasBlacklist>
     * @throws
     * @Title:
     * @Description: 分页查询黑名单
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public PageInfoExtend<BasBlacklist> findBasBlacklistsByPage(BasBlacklistVo basBlacklistVo) {
        Example example = SqlUtil.newExample(BasBlacklist.class);
        Example.Criteria criteria = example.createCriteria();
        //客户名称
        if (StringUtils.isNotTrimBlank(basBlacklistVo.getName())) {
            criteria.andLike("name", SqlUtil.likePattern(basBlacklistVo.getName()));
        }
        //证件号码
        if (StringUtils.isNotTrimBlank(basBlacklistVo.getCertifNo())) {
            criteria.andLike("certifNo", SqlUtil.likePattern(basBlacklistVo.getCertifNo()));
        }

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BasBlacklist> pageInfo = basBlacklistRepository.selectListByExamplePage(example, basBlacklistVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param basBlacklistSaveVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 保存黑名单
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Transactional
    public void saveBasBlacklist(BasBlacklistSaveVo basBlacklistSaveVo) {
        basBlacklistRepository.insertData(basBlacklistSaveVo.getEntity());
    }

    /**
     * @param basBlacklistModifyVo
     * @return
     * @throws
     * @Title:
     * @Description: 修改黑名单
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Transactional
    public void modifyBasBlacklist(BasBlacklistModifyVo basBlacklistModifyVo) {
        basBlacklistRepository.updateByPrimaryKeySelectiveData(basBlacklistModifyVo.getEntity());
    }

    /**
     * @param basBlacklistDeleteVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过blacklistId删除黑名单
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Transactional
    public void deleteBasBlacklist(BasBlacklistDeleteVo basBlacklistDeleteVo) {
        basBlacklistRepository.deleteData(basBlacklistDeleteVo.getEntity());
    }

    /**
     * @param basBlacklistDeleteListVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过blacklistId集合删除黑名单
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    @Transactional
    public void deleteBasBlacklistsByBlacklistIds(BasBlacklistDeleteListVo basBlacklistDeleteListVo) {
        basBlacklistRepository.deleteDataList(basBlacklistDeleteListVo.getBlacklistIds(), basBlacklistDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 根据blacklistId获取黑名单
     * @param blacklistId
     * @return BasBlacklist
     * @author yangyiquan
     * @date 2018-5-4 14:06:29
     */
    public BasBlacklist findBasBlacklistByBlacklistId(String blacklistId) {
        return basBlacklistRepository.selectByPrimaryKey(blacklistId);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取该订单中全部的黑名单中的人员
     * @param basBlacklistVo 参数
     * @return List<BasBlacklistVo>
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @Override
    public List<BasBlacklistVo> findBasBlacklistVosByApplyNo(BasBlacklistVo basBlacklistVo) {
        // 订单编号为空的场合，返回一个空的list
        if (StringUtils.isTrimBlank(basBlacklistVo.getApplyNo())) {
            return new ArrayList<>();
        }
        // 根据订单编号获取订单中全部的人员信息
        List<BasBlacklistVo> personList = findAllPersonInfoByApplyNo(basBlacklistVo.getApplyNo());
        // 获取黑黑名单数据（姓名，证件号，电话号码符合其中一个）
        List<BasBlacklist> basBlacklists = findBasBlacklistsByVoList(personList);
        // 循环人员信息，找出在黑名单中的人员信息
        List<BasBlacklistVo> basBlacklistVoList = new ArrayList<>();
        for (BasBlacklistVo blacklistVo : personList) {
            BasBlacklist tempBlack = checkInBasBlacklists(blacklistVo, basBlacklists);
            if (tempBlack != null) {
                // 关系类型名称
                blacklistVo.setRelationTypeName(CstmRelationIdentityTypeEnums.getTypeByCode(blacklistVo.getRelationType()));
                blacklistVo.setMemo(tempBlack.getMemo()); // 说明
                blacklistVo.setBlackLevel(tempBlack.getBlackLevel()); // 黑名单级别
                basBlacklistVoList.add(blacklistVo);
            }
        }
        return basBlacklistVoList;
    }

    /**
     * @Title:
     * @Description: 保存订单中全部热人员信息到黑名单中
     * @param basBlacklistVo 参数
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    @Override
    @Transactional
    public void saveBasBlacklistByApplyNo(BasBlacklistVo basBlacklistVo) {
        // 循环处理订单中的人员信息，将没有在黑名单中的人员加入黑名单
        List<BasBlacklist> addBasBlacklistList = new ArrayList<>(); // 新增数据
        List<BasBlacklist> updBasBlacklistList = new ArrayList<>(); // 更新的数据
        String nowDate = DateUtils.dateToStr(new Date(), DateUtils.formatStr_yyyyMMdd);// 当前时间
        if (ArrayUtils.isNotNullAndLengthNotZero(basBlacklistVo.getApplyNoList())) {
            // 循环处理全部的申请编号信息
            for (String applyNo : basBlacklistVo.getApplyNoList()) {
                saveOneBasBlacklistByApplyNo(applyNo, basBlacklistVo.getRegisterType(), nowDate, addBasBlacklistList, updBasBlacklistList);
            }
        }
        // 保存需要新增到黑名单中的数据
        if (ArrayUtils.isNotNullAndLengthNotZero(addBasBlacklistList)) {
            basBlacklistRepository.insertDataList(addBasBlacklistList);
        }
        // 保存需要更新的黑名单数据
        if (ArrayUtils.isNotNullAndLengthNotZero(updBasBlacklistList)) {
            basBlacklistRepository.updateByPrimaryKeySelectiveDataList(updBasBlacklistList);
        }
    }

    /**
     * @Title:
     * @Description: 保存订单中全部的人员信息到黑名单中
     * @param applyNo 申请编号
     * @param registerType 加入黑名单类型
     * @param nowDate 当前时间
     * @param addBasBlacklistList 新增黑名单数据
     * @param updBasBlacklistList 更新黑名单数据
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private void saveOneBasBlacklistByApplyNo(String applyNo, String registerType, String nowDate, List<BasBlacklist> addBasBlacklistList
            , List<BasBlacklist> updBasBlacklistList){
        // 根据订单编号获取订单中全部的人员信息
        List<BasBlacklistVo> personList = findAllPersonInfoByApplyNo(applyNo);
        // 获取黑黑名单数据（姓名，证件号，电话号码符合其中一个）
        List<BasBlacklist> basBlacklists = findBasBlacklistsByVoList(null);
        String registerTypeStr = "1".equals(registerType) ? "风控审批" : "逾期客户";
        for (BasBlacklistVo blacklistVo : personList) {
            BasBlacklist basBlacklist = checkInBasBlacklists(blacklistVo, basBlacklists);
            // 拼接此次的说明
            String memo = nowDate.concat(registerTypeStr).concat("：申请编号: ").concat(applyNo)
                    .concat("，关系类型: ").concat(CstmRelationIdentityTypeEnums.getTypeByCode(blacklistVo.getRelationType()));
            if (basBlacklist == null) {
                // 人员信息不再黑名单中，则将人员信息加入黑名单
                basBlacklist = blacklistVo.getEntity();
                basBlacklist.setSource(BlackSourceEnums.MANUAL_INPUT.getType());// 来源：手动录入
                basBlacklist.setBlackLevel(BlackLevelEnums.LOW_LEVEL.getType()); // 级别：低
                // 说明 如果长度大于1000，则截取前1000个字符
                basBlacklist.setMemo(StringUtils.subStringBegin(memo, 1000));
                addBasBlacklistList.add(basBlacklist);
                basBlacklists.add(basBlacklist); // 本次新增的数据追加到黑名单信息中，以排除一次新增中出现重复的人员信息
            } else {
                if (StringUtils.isTrimBlank(basBlacklist.getBlacklistId())) {
                    // 排除本次新增重复的数据
                    continue;
                }
                BasBlacklist modifyBlacklist = new BasBlacklist();
                modifyBlacklist.setName(blacklistVo.getName()); // 客户姓名
                modifyBlacklist.setCertifNo(blacklistVo.getCertifNo()); // 证件号码
                modifyBlacklist.setMobileNo(blacklistVo.getMobileNo()); // 手机号码
                // 说明 如果长度大于1000，则截取前1000个字符
                String remark = StringUtils.joinDelimiter("；", basBlacklist.getMemo(),memo);
                modifyBlacklist.setMemo(StringUtils.subStringBegin(remark, 1000));
                modifyBlacklist.setBlacklistId(basBlacklist.getBlacklistId()); // 黑名单ID
                updBasBlacklistList.add(modifyBlacklist);
            }
        }
    }

    /**
     * @Title:
     * @Description: 判断人员信息是否在黑名单中
     * @param blacklistVo   人员信息
     * @param basBlacklists 黑名单集合
     * @return BasBlacklist
     * @throws
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private BasBlacklist checkInBasBlacklists(BasBlacklistVo blacklistVo, List<BasBlacklist> basBlacklists) {
        if (ArrayUtils.isNotNullAndLengthNotZero(basBlacklists)) {
            for (BasBlacklist basBlack : basBlacklists) {
                if (checkIsSameBasBlackList(blacklistVo, basBlack)) {
                    return basBlack;
                }
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description 比较两个黑名单人员是否一致
     * @param blacklistVo  人员信息1
     * @param basBlacklist 人员信息2
     * @return BasBlacklist
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private boolean checkIsSameBasBlackList(BasBlacklistVo blacklistVo, BasBlacklist basBlacklist) {
        if (StringUtils.isNotTrimBlank(blacklistVo.getMobileNo()) && blacklistVo.getName().equals(basBlacklist.getName())
                && blacklistVo.getMobileNo().equals(basBlacklist.getMobileNo())) {
            // 姓名和电话号码各自相等
            return true;
        } else if (StringUtils.isNotTrimBlank(blacklistVo.getCertifNo()) && blacklistVo.getCertifNo().equals(basBlacklist.getCertifNo())
                && blacklistVo.getName().equals(basBlacklist.getName())) {
            // 姓名和证件号码各自相等
            return true;
        }
        return false;
    }

    /**
     * @Title:
     * @Description: 根据人员信息集合，获取姓名证件号，电话号码符合其中一个的黑名单数据
     * @param basBlacklistVoList 人员信息集合
     * @return List<BasBlacklist>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklist> findBasBlacklistsByVoList(List<BasBlacklistVo> basBlacklistVoList) {
        // 客户姓名集合
        List<String> nameList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(basBlacklistVoList)) {
            // 循环订单的人员信息，获取客户姓名集合
            for (BasBlacklistVo vo : basBlacklistVoList) {
                // 客户姓名
                if (StringUtils.isNotTrimBlank(vo.getName())) {
                    nameList.add(vo.getName());
                }
            }
        }
        // 获取姓名在客户姓名集合中的黑名单数据
        Example example = SqlUtil.newExample(BasBlacklist.class);
        Example.Criteria criteria = example.createCriteria();
        if (ArrayUtils.isNotNullAndLengthNotZero(nameList)) {
            criteria.andIn("name", nameList);
        }
        // 获取黑名单数据集合
        List<BasBlacklist> basBlacklistList = basBlacklistRepository.selectListByExample(example);
        if (basBlacklistList == null) {
            basBlacklistList = new ArrayList<>();
        }
        return basBlacklistList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取订单中全部的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findAllPersonInfoByApplyNo(String applyNo) {
        List<BasBlacklistVo> basBlacklistVoList = new ArrayList<>();
        // 客户个人基本信息
        basBlacklistVoList.addAll(findCstmPersonTelImfoByApplyNo(applyNo));
        // 客户企业基本信息
        basBlacklistVoList.addAll(findCstmCompanyPerInfoByApplyNo(applyNo));
        // 客户个人配偶信息
        basBlacklistVoList.addAll(findCstmPerMatePerInfoByApplyNo(applyNo));
        // 客户联系人信息
        basBlacklistVoList.addAll(findCstmContractPerInfoByApplyNo(applyNo));
        // 担保个人信息
        basBlacklistVoList.addAll(findGuaranteePersPerInfoByApplyNo(applyNo));
        // 担保企业信息
        basBlacklistVoList.addAll(findGuaranteeCompPerInfoByApplyNo(applyNo));
        // 共同借款人信息
        basBlacklistVoList.addAll(findCommonBorrowerPerInfoByApplyNo(applyNo));
        return basBlacklistVoList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取客户个人基本信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findCstmPersonTelImfoByApplyNo(String applyNo) {
        // 返回结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取客户个人基本信息
        Example example = SqlUtil.newExample(CstmPerson.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        CstmPerson cstmPerson = cstmPersonRepository.selectOneByExample(example);
        if (cstmPerson != null) {
            // 主贷人信息
            resultList.add(getBasBlacklistVo(cstmPerson.getName(), cstmPerson.getCertifNo(), cstmPerson.getMobileNo(), CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()));
            // 实际用车人的信息
            BasBlacklistVo driver = getBasBlacklistVo(cstmPerson.getDriver(), null, cstmPerson.getDriverMobno(), CstmRelationIdentityTypeEnums.DRIVER.getCode());
            if (checkNameCertifNoMobileNo(driver)) {
                resultList.add(driver);
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取客户企业基本信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findCstmCompanyPerInfoByApplyNo(String applyNo) {
        // 返回结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取客户企业基本信息
        Example example = SqlUtil.newExample(CstmCompany.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        CstmCompany cstmCompany = cstmCompanyRepository.selectOneByExample(example);
        if (cstmCompany != null) {
            // 企业客户信息
            resultList.add(getBasBlacklistVo(cstmCompany.getName(), cstmCompany.getSocialCertifNo(), cstmCompany.getCompTel(), CstmRelationIdentityTypeEnums.PRINCIPAL_LENDER.getCode()));
            // 企业法人信息
            BasBlacklistVo compLegalRep = getBasBlacklistVo(cstmCompany.getCompLegalRep(), cstmCompany.getCertifNo(), cstmCompany.getMobileNo(), CstmRelationIdentityTypeEnums.COMPANY_LEGAL.getCode());
            if (checkNameCertifNoMobileNo(compLegalRep)) {
                resultList.add(compLegalRep);
            }
            // 企业联系人信息
            BasBlacklistVo contract = getBasBlacklistVo(cstmCompany.getContactName(), null, cstmCompany.getContactMobno(), CstmRelationIdentityTypeEnums.COMPANY_CONTACT.getCode());
            if (checkNameCertifNoMobileNo(contract)) {
                resultList.add(contract);
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取客户个人配偶信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findCstmPerMatePerInfoByApplyNo(String applyNo) {
        // 返回结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取客户个人配偶信息
        Example example = SqlUtil.newExample(CstmPersMate.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        CstmPersMate cstmPersMate = cstmPersMateRepository.selectOneByExample(example);
        if (cstmPersMate != null) {
            // 配偶信息
            BasBlacklistVo mate = getBasBlacklistVo(cstmPersMate.getName(), cstmPersMate.getCertifNo(), cstmPersMate.getMobileNo(), CstmRelationIdentityTypeEnums.MATE.getCode());
            if (checkNameCertifNoMobileNo(mate)) {
                resultList.add(mate);
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取客户联系人信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findCstmContractPerInfoByApplyNo(String applyNo) {
        // 返回的结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取订单的联系人信息
        Example example = SqlUtil.newExample(CstmContact.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<CstmContact> cstmContactList = cstmContactRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(cstmContactList)) {
            for (CstmContact cstmContact : cstmContactList) {
                // 联系人信息
                BasBlacklistVo contact = getBasBlacklistVo(cstmContact.getName(), null, cstmContact.getMobileNo(), CstmRelationIdentityTypeEnums.CONTACT.getCode());
                if (checkNameCertifNoMobileNo(contact)) {
                    resultList.add(contact);
                }
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取担保人信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findGuaranteePersPerInfoByApplyNo(String applyNo) {
        // 返回的结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取订单的联系人信息
        Example example = SqlUtil.newExample(GuaranteePers.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<GuaranteePers> guaranteePersList = guaranteePersRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteePersList)) {
            for (GuaranteePers guaranteePers : guaranteePersList) {
                // 担保人信息
                BasBlacklistVo guarantee = getBasBlacklistVo(guaranteePers.getName(), guaranteePers.getCertifNo(), guaranteePers.getMobileNo(), CstmRelationIdentityTypeEnums.GUARANTEE_PERSON.getCode());
                if (checkNameCertifNoMobileNo(guarantee)) {
                    resultList.add(guarantee);
                }
                // 担保人配偶信息
                BasBlacklistVo mate = getBasBlacklistVo(guaranteePers.getMateName(), guaranteePers.getMateCertifNo(), guaranteePers.getMateMobileNo(), CstmRelationIdentityTypeEnums.GUARANTEE_PERSON_MATE.getCode());
                if (checkNameCertifNoMobileNo(mate)) {
                    resultList.add(mate);
                }
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取担保企业信息中的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findGuaranteeCompPerInfoByApplyNo(String applyNo) {
        // 返回的结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号，获取订单的联系人信息
        Example example = SqlUtil.newExample(GuaranteeComp.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<GuaranteeComp> guaranteeCompList = guaranteeCompRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(guaranteeCompList)) {
            for (GuaranteeComp guaranteeComp : guaranteeCompList) {
                // 担保企业信息
                BasBlacklistVo company = getBasBlacklistVo(guaranteeComp.getName(), guaranteeComp.getSocialCertifNo(), guaranteeComp.getCompTel(), CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY.getCode());
                if (checkNameCertifNoMobileNo(company)) {
                    resultList.add(company);
                }
                // 担保企业法人信息
                BasBlacklistVo legalRep = getBasBlacklistVo(guaranteeComp.getCompLegalRep(), guaranteeComp.getCertifNo(), guaranteeComp.getMobileNo(), CstmRelationIdentityTypeEnums.GUARANTEE_COMPANY_LEGAL.getCode());
                if (checkNameCertifNoMobileNo(legalRep)) {
                    resultList.add(legalRep);
                }
            }
        }
        return resultList;
    }

    /**
     * @Title:
     * @Description: 根据订单编号获取共同借款人信息的人员信息
     * @param applyNo 订单编号
     * @return List<BasBlacklistVo>
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private List<BasBlacklistVo> findCommonBorrowerPerInfoByApplyNo(String applyNo) {
        // 返回的结果
        List<BasBlacklistVo> resultList = new ArrayList<>();
        // 根据申请编号获取共同借款人信息
        Example example = SqlUtil.newExample(CommonBorrower.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        List<CommonBorrower> commonBorrowerList = commonBorrowerRepository.selectListByExample(example);
        if (ArrayUtils.isNotNullAndLengthNotZero(commonBorrowerList)) {
            for (CommonBorrower commonBorrower : commonBorrowerList) {
                // 共同借款人电话信息
                BasBlacklistVo blacklistVo = getBasBlacklistVo(commonBorrower.getName(), commonBorrower.getCertifNo(), commonBorrower.getMobileNo(), CstmRelationIdentityTypeEnums.COMMON_BORR.getCode());
                if (checkNameCertifNoMobileNo(blacklistVo)) {
                    resultList.add(blacklistVo);
                }
            }
        }
        return resultList;
    }


    /**
     * @Title:
     * @Description: 根据订单编号获取订单中全部的人员信息
     * @param name         姓名
     * @param certifNo     证件号码
     * @param mobileNo     手机号码
     * @param relationType 关系类型
     * @return BasBlacklistVo
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private BasBlacklistVo getBasBlacklistVo(String name, String certifNo, String mobileNo, String relationType) {
        BasBlacklistVo basBlacklistVo = new BasBlacklistVo();
        basBlacklistVo.setName(name);// 姓名
        basBlacklistVo.setCertifNo(certifNo);// 证件号码
        basBlacklistVo.setMobileNo(mobileNo);// 手机号码
        basBlacklistVo.setRelationType(relationType);// 关系类型
        return basBlacklistVo;
    }

    /**
     * @Title:
     * @Description: 判断是否数据是否可以加入黑名单
     * @param basBlacklistVo 数据
     * @return boolean
     * @author wangxue
     * @date 2018-9-21 14:06:28
     */
    private boolean checkNameCertifNoMobileNo(BasBlacklistVo basBlacklistVo) {
        if (StringUtils.isNotTrimBlank(basBlacklistVo.getName()) && StringUtils.isNotTrimBlank(basBlacklistVo.getMobileNo())) {
            // 客户姓名和手机号码都不为空
            return true;
        } else if (StringUtils.isNotTrimBlank(basBlacklistVo.getCertifNo()) && StringUtils.isNotTrimBlank(basBlacklistVo.getName())) {
            //姓名和证件号不为空
            return true;
        }
        return false;
    }
}
