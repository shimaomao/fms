package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.common.constant.CommonPropertyConstants;
import cn.com.leadu.fms.common.constant.PyConfigConstants;
import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditCropDebtTypeEnums;
import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditCropRiskTypeEnums;
import cn.com.leadu.fms.common.constant.enums.riskmgmt.PycreditTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.riskmgmt.repository.*;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.riskmgmt.entity.*;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.thirdinterface.*;
import cn.com.leadu.fms.riskmgmt.constant.CommonConstants;
import cn.com.leadu.fms.riskmgmt.rpc.thirdinterface.PyInterfaceRpc;
import cn.com.leadu.fms.riskmgmt.service.*;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.impl.util.json.JSONArray;
import org.activiti.engine.impl.util.json.JSONException;
import org.activiti.engine.impl.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liujinge
 * @ClassName: ApplyRiskService
 * @Description: 风控管理
 * @date 2018-06-05
 */
@Service
@Slf4j
public class PycreditRiskServiceImpl implements PycreditRiskService {

    @Autowired
    private PyInterfaceRpc pyInterfaceRpc;
    @Autowired
    private PycreditListService pycreditListService;
    @Autowired
    private PycreditAntiService pycreditAntiService;
    @Autowired
    private PycreditAddrService pycreditAddrService;
    @Autowired
    private PycreditPersonBkcheckService pycreditPersonBkcheckService;
    @Autowired
    private PycreditCorpBkcheckService pycreditCorpBkcheckService;
    @Autowired
    private PycreditCorpRiskService pycreditCorpRiskService;
    @Autowired
    private PycreditCorpDebtService pycreditCorpDebtService;
    @Autowired
    private PycreditDriverService pycreditDriverService;

    /**
     * @Fields  : 鹏元查询一览repository
     */
    @Autowired
    private PycreditListRepository pycreditListRepository;
    /**
     * @Fields  : 反欺诈repository
     */
    @Autowired
    private PycreditAntiRepository pycreditAntiRepository;
    /**
     * @Fields  : 地址核查repository
     */
    @Autowired
    private PycreditAddrRepository pycreditAddrRepository;
    /**
     * @Fields  : 卡核查及交易repository
     */

    /**
     * @Fields  : 个人银行卡核查repository
     */
    @Autowired
    private PycreditPersonBkcheckRepository pycreditPersonBkcheckRepository;
    /**
     * @Fields  : 企业银行卡核查repository
     */
    @Autowired
    private PycreditCorpBkcheckRepository pycreditCorpBkcheckRepository;
    /**
     * @Fields  : 驾驶证核查repository
     */
    @Autowired
    private PycreditDriverRepository pycreditDriverRepository;
    /**
     * @Fields  : 企业风险repository
     */
    @Autowired
    private PycreditCorpRiskRepository pycreditCorpRiskRepository;
    /**
     * @Fields  : 企业债务repository
     */
    @Autowired
    private PycreditCorpDebtRepository pycreditCorpDebtRepository;

    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @param pycreditListVo
     * @Description: 鹏远征信报告
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 15:34
     */
    @Override
    @Transactional
    public PycreditListVo saveApplyRiskPyCredit(PycreditListVo pycreditListVo) {
        try {
//                    ANTI("1","反欺诈分析"),
//                    ADDR1("21","地址核验-居住地"),
//                    ADDR2("22","地址核验-单位地址"),
//                    CARD_CHECK("3","卡核查及交易"),  //不使用
//                    PERSON_BKCHECK("4","个人银行卡核查"),
//                    CORP_BKCHECK("5","企业银行卡核查"),
//                    DRIVER("6","驾驶证核查"),
//                    DRIVER1("61","个人驾驶证基本信息核查"),
//                    DRIVER2("62","个人驾驶证状态查询"),
//                    DRIVER3("63","个人驾驶证准驾车型核查"),
//                    DRIVER4("64","个人驾驶证初次领证日期核查"),
//                    DRIVER5("65","个人驾驶证档案编号核查"),
//                    CORP_RISK("7","企业风险"),
//                    CORP_DEBT("8","企业债务")
            //反欺诈分析
            if(pycreditListVo.getPycreditType()!=null&&"1".equals(pycreditListVo.getPycreditType())){
                pycreditListVo=savePyCreditAnti(pycreditListVo);
            }
            //地址核验
            else if(pycreditListVo.getPycreditType()!=null&&("21".equals(pycreditListVo.getPycreditType())||"22".equals(pycreditListVo.getPycreditType()))){
                pycreditListVo=savePyCreditAddr(pycreditListVo);
            }
            //卡核查及交易
            else if(pycreditListVo.getPycreditType()!=null&&"3".equals(pycreditListVo.getPycreditType())){

            }
            //个人银行卡核查
            else if(pycreditListVo.getPycreditType()!=null&&"4".equals(pycreditListVo.getPycreditType())){
                pycreditListVo=savePyCreditPersonBkcheck(pycreditListVo);
            }
            //企业银行卡核查
            else if(pycreditListVo.getPycreditType()!=null&&"5".equals(pycreditListVo.getPycreditType())){
                pycreditListVo=savePyCreditCorpBkcheck(pycreditListVo);
            }
            //驾驶证核查
            else if(pycreditListVo.getPycreditType()!=null&&("6".equals(pycreditListVo.getPycreditType())||"61".equals(pycreditListVo.getPycreditType())||
                "62".equals(pycreditListVo.getPycreditType())||"63".equals(pycreditListVo.getPycreditType())||
                "64".equals(pycreditListVo.getPycreditType())||"65".equals(pycreditListVo.getPycreditType()))){
                pycreditListVo=savePycreditDriver(pycreditListVo);
            }
            //企业风险
            else if(pycreditListVo.getPycreditType()!=null&&"7".equals(pycreditListVo.getPycreditType())){
                pycreditListVo=savePyCreditCorpRisk(pycreditListVo);
            }
            //企业债务
            else if(pycreditListVo.getPycreditType()!=null&&"8".equals(pycreditListVo.getPycreditType())){
                pycreditListVo=savePycreditCorpDebt(pycreditListVo);
            }

        } catch (FmsServiceException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException(ex.getMessage());
        }  catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("第三方接口异常");
        }
        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信反欺诈
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/11 15:34
     */
    public PycreditListVo savePyCreditAnti(PycreditListVo pycreditListVo) throws Exception {
        //反欺诈查询
        PycreditAnti commonEntity=pycreditAntiRepository.selectLastPycreditAntiByDocumentNo(pycreditListVo.getDocumentNo());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            pycreditListVo.setPycreditAnti(commonEntity);
        }else{
            commonEntity = new PycreditAnti();//重新构造查询
            //如果第一次或者查询日期超过上限天数
            //根据对象调用接口
            PyCreditAntiInterfaceVo commonVo  =new PyCreditAntiInterfaceVo();
//            commonVo.setRefID("cs002");//业务流水号(自定义CHAR(30)，可以为空)
//            commonVo.setName("测试一");//姓名
//            commonVo.setDocumentNo("110000199001011112");//证件号码
//            commonVo.setPhone("13712345670");//手机
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setName(pycreditListVo.getName());//姓名
            commonVo.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码
            commonVo.setPhone(pycreditListVo.getPhone());//手机
            Map<String,String> resultMap= ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }

            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject jsonResult = new JSONObject(t);          //通过String又得到每个元素的对象
                //得到对象中的元素
                JSONObject resultidcard= jsonResult.optJSONObject("policeCheckInfo");
                JSONObject result_item= resultidcard.optJSONObject("item");
                if (result_item.has("result")) {
                    commonEntity.setResult(PycreditTypeUtils.getResult(result_item.getString("result")));// 身份认证结果
                }
                JSONObject mobileCheckInfo= jsonResult.optJSONObject("mobileCheckInfo");
                if ("1".equals(mobileCheckInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(mobileCheckInfo.getString("treatResult")));//核查状态
                    JSONObject mobileCheckInfo_item = mobileCheckInfo.optJSONObject("item");
                    if (mobileCheckInfo_item.has("nameCheckResult")) {
                        commonEntity.setNameCheckResult(mobileCheckInfo_item.getString("nameCheckResult"));//姓名核查结果
                    }
                    if (mobileCheckInfo_item.has("documentNoCheckResult")) {
                        commonEntity.setDocumentNoCheckResult(mobileCheckInfo_item.getString("documentNoCheckResult"));//证件号码核查结果
                    }
                    if (mobileCheckInfo_item.has("phoneCheckResult")) {
                        commonEntity.setPhoneCheckResult(mobileCheckInfo_item.getString("phoneCheckResult"));//手机号码核查结果
                    }
                    if (mobileCheckInfo_item.has("areaInfo")) {
                        commonEntity.setAreaInfo(mobileCheckInfo_item.getString("areaInfo"));//手机号码归属地
                    }
                    if (mobileCheckInfo_item.has("operator")) {
                        commonEntity.setOperator(PycreditTypeUtils.getOperator(mobileCheckInfo_item.getString("operator")));//运营商名称
                    }
                }else if("2".equals(mobileCheckInfo.getString("treatResult"))){//2代表未查到
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(mobileCheckInfo.getString("treatResult")));//核查状态
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(mobileCheckInfo.getString("treatResult")));
                }

                JSONObject personAntiSpoofingInfo= jsonResult.optJSONObject("personAntiSpoofingInfo");
                if ("1".equals(mobileCheckInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                    if (personAntiSpoofingInfo.has("riskScore")) {
                        commonEntity.setAntiResult(personAntiSpoofingInfo.getString("riskScore") + "、" + personAntiSpoofingInfo.getString("riskLevel") + "、" + personAntiSpoofingInfo.getString("suggest"));//风险评分、风险等级、风险建议
                    }
                }
                JSONObject mobileStatusInfo= jsonResult.optJSONObject("mobileStatusInfo");
                if ("1".equals(mobileStatusInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                    JSONObject mobileStatusInfo_item = mobileStatusInfo.optJSONObject("item");
                    if (mobileStatusInfo_item.has("phoneStatus")) {
                        commonEntity.setPhoneStatus(PycreditTypeUtils.getPhoneStatus(mobileStatusInfo_item.getString("phoneStatus")));//手机状态
                    }
                    if (mobileStatusInfo_item.has("timeLength")) {
                        commonEntity.setTimeLength(mobileStatusInfo_item.getString("timeLength"));//手机号码在网时长
                    }
                }
                JSONObject personAntiSpoofingDescInfo= jsonResult.optJSONObject("personAntiSpoofingDescInfo");
                if ("1".equals(personAntiSpoofingDescInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                    if (personAntiSpoofingDescInfo.has("personAntiSpoofingDesc")) {
                        commonEntity.setPersonAntiSpoofingDesc(personAntiSpoofingDescInfo.getString("personAntiSpoofingDesc"));//个人反欺诈综述信息
                    }
                }


            }
            commonEntity.setName(pycreditListVo.getApplyNo());//姓名
            commonEntity.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码
            commonEntity.setPhone(pycreditListVo.getPhone());//手机
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
            pycreditAntiRepository.insertData(commonEntity);
        }

        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditAntiId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditAnti(commonEntity);

        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信地址核验
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/11 15:34
     */
    public PycreditListVo savePyCreditAddr(PycreditListVo pycreditListVo) throws Exception{
        //地址核查查询
        PycreditAddr commonEntity=pycreditAddrRepository.selectLastPycreditAddrByDocumentNo(pycreditListVo.getDocumentNo());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            pycreditListVo.setPycreditAddr(commonEntity);
        }else{
            commonEntity = new PycreditAddr();//重新构造查询
            //根据对象调用接口
            PyAddrInterfaceVo commonVo  =new PyAddrInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setName(pycreditListVo.getName());//姓名(可以为空)
            commonVo.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码(可以为空)
            commonVo.setMobile(pycreditListVo.getPhone());//手机
            if(PycreditTypeEnums.ADDR1.getType().equals(pycreditListVo.getPycreditType())){
                commonVo.setAddress(pycreditListVo.getResideAddr());//居住地址
            }else{
                commonVo.setAddress(pycreditListVo.getCompAddr());//单位地址
            }


//            commonVo.setName("测试一");//姓名(可以为空)
//            commonVo.setDocumentNo("110000199001011112");//证件号码(可以为空)
//            commonVo.setMobile("13300000001");//手机
//            commonVo.setAddress("广东省深圳市福田区地址1");//居住地址
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject jsonResult = new JSONObject(t);          //通过String又得到每个元素的对象
                jsonResult= jsonResult.optJSONObject("addressCheckInfo");
                //得到对象中的元素
                if ("1".equals(jsonResult.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(jsonResult.getString("treatResult")));//核查状态
                    commonEntity.setProvinceCheckResult(jsonResult.getString("provinceCheckResult"));   //省核查结果
                    commonEntity.setCityCheckResult(jsonResult.getString("cityCheckResult"));   //市核查结果
                    commonEntity.setCountyCheckResult(jsonResult.getString("countyCheckResult"));   //区/县核查结果
                    commonEntity.setDetailAddressCheckResult(jsonResult.getString("detailAddressCheckResult"));   //详细地址核查结果
                    commonEntity.setAddrCheck("省、市、县、详细地址核查结果:"+jsonResult.getString("provinceCheckResult")+"、"+jsonResult.getString("cityCheckResult")+"、"+jsonResult.getString("countyCheckResult")+"、"+jsonResult.getString("detailAddressCheckResult"));
                }else if("2".equals(jsonResult.getString("treatResult"))){//2代表未查到
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(jsonResult.getString("treatResult")));//核查状态
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(jsonResult.getString("treatResult")));
                }
            }
            commonEntity.setName(pycreditListVo.getName());//姓名(可以为空)
            commonEntity.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码(可以为空)
            commonEntity.setMobile(pycreditListVo.getPhone());//手机
            commonEntity.setAddress(pycreditListVo.getResideAddr());//地址
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
            pycreditAddrRepository.insertData(commonEntity);
        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditAddrId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditAddr(commonEntity);
        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信个人银行卡核查
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/12 15:34
     */
    public PycreditListVo savePyCreditPersonBkcheck(PycreditListVo pycreditListVo) throws Exception{
        //个人银行卡核查查询
        PycreditPersonBkcheck commonEntity = pycreditPersonBkcheckRepository.selectLastPycreditPersonBkcheckByDocumentNo(pycreditListVo.getDocumentNo());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            pycreditListVo.setPycreditPersonBkcheck(commonEntity);
        }else{
            commonEntity = new PycreditPersonBkcheck();
            //根据对象调用接口
            PyCreditPersonBkcheckInterfaceVo commonVo  = new PyCreditPersonBkcheckInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setName(pycreditListVo.getName());//姓名
            commonVo.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码
            commonVo.setAccountNo(pycreditListVo.getAccountNo());//银行账号
            commonVo.setOpenBankNo(pycreditListVo.getOpenBankNo());//开户行行号(可以为空)
//            commonVo.setName("测试一");//公司名称
//            commonVo.setDocumentNo("110000199001011112");//证件号码
//            commonVo.setAccountNo("6225768610373340");//银行账号
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject jsonResult = new JSONObject(t);          //通过String又得到每个元素的对象
                JSONObject personBankCheckInfo = jsonResult.optJSONObject("personBankCheckInfo");
                //得到对象中的元素
                if ("1".equals(personBankCheckInfo.getString("treatResult"))) {
                    // treatResult的值代表1：查得，2：未查得，3：其它原因未查得
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(personBankCheckInfo.getString("treatResult")));
                    JSONObject item = personBankCheckInfo.optJSONObject("item");
                    commonEntity.setStatus(PycreditTypeUtils.getResult(item.getString("status")));//核查结果
                }else if("2".equals(personBankCheckInfo.has("treatResult"))){
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(personBankCheckInfo.getString("treatResult")));
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(personBankCheckInfo.getString("treatResult")));
                }
            }
            commonEntity.setName(pycreditListVo.getName());//姓名(可以为空)
            commonEntity.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码(可以为空)
            commonEntity.setAccountNo(pycreditListVo.getAccountNo());//银行账号
            commonEntity.setOpenBankNo(pycreditListVo.getOpenBankNo());//开户行行号(可以为空)
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
            pycreditPersonBkcheckRepository.insertData(commonEntity);

        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditPersonBkcheckId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditPersonBkcheck(commonEntity);
        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信企业银行卡核查
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/12 15:34
     */
    public PycreditListVo savePyCreditCorpBkcheck(PycreditListVo pycreditListVo) throws Exception{
        //企业银行卡核查查询
        PycreditCorpBkcheck commonEntity = pycreditCorpBkcheckRepository.selectLastPycreditCorpBkcheckByDocumentNo(pycreditListVo.getName());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            pycreditListVo.setPycreditCorpBkcheck(commonEntity);
        }else{
            commonEntity = new PycreditCorpBkcheck();
            //根据对象调用接口
            PyCreditCorpBkcheckInterfaceVo commonVo  =new PyCreditCorpBkcheckInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setCorpName(pycreditListVo.getName());//姓名
            commonVo.setAccountNo(pycreditListVo.getAccountNo());//银行账号
            commonVo.setOpenBankNo(pycreditListVo.getOpenBankNo());//开户行行号
//            commonVo.setCorpName("测试一");//公司名称
//            commonVo.setAccountNo("6226620403042404");//银行账号
//            commonVo.setOpenBankNo("303584000004");//开户行行号
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));;//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject jsonResult = new JSONObject(t);          //通过String又得到每个元素的对象
                JSONObject corpBankCheckInfo = jsonResult.optJSONObject("corpBankCheckInfo");
                //得到对象中的元素
                //得到对象中的元素
                if ("1".equals(corpBankCheckInfo.getString("treatResult"))) {
                    // treatResult的值代表1：查得，2：未查得，3：其它原因未查得
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpBankCheckInfo.getString("treatResult")));
                    JSONObject item = corpBankCheckInfo.optJSONObject("item");
                    commonEntity.setTreatResult(PycreditTypeUtils.getResult(item.getString("status")));//核查结果
                }else if("2".equals(corpBankCheckInfo.has("treatResult"))){
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpBankCheckInfo.getString("treatResult")));
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(corpBankCheckInfo.getString("treatResult")));
                }
            }
            commonEntity.setCorpName(pycreditListVo.getName());//姓名(可以为空)
            commonEntity.setAccountNo(pycreditListVo.getAccountNo());//银行账号
            commonEntity.setOpenBankNo(pycreditListVo.getOpenBankNo());//开户行行号
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
            pycreditCorpBkcheckRepository.insertData(commonEntity);

        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditCorpBkcheckId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditCorpBkcheck(commonEntity);
        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信驾驶证
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/11 15:34
     */
    public PycreditListVo savePycreditDriver(PycreditListVo pycreditListVo) throws Exception {
        //查询最近一条驾驶证核查实体
        PycreditDriver commonEntity = pycreditDriverRepository.selectLastPycreditDriverByDocumentNo(pycreditListVo.getDocumentNo());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            pycreditListVo.setPycreditDriver(commonEntity);
        }else{
            commonEntity = new PycreditDriver();
            //根据对象调用接口
            PycreditDriverInterfaceVo commonVo  =new PycreditDriverInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setName(pycreditListVo.getActCarUser());//姓名
            commonVo.setDocumentNo(pycreditListVo.getDriLicenseNo());//证件号码
            commonVo.setCarModels(conversionQuasiDriveModel(pycreditListVo.getCarModels()));//准驾车型   可以为空
            commonVo.setFirstGetDocDate(pycreditListVo.getFirstGetDate());//初次领证日期  格式yyyy-mm-dd  可以为空
            commonVo.setArchviesNo(pycreditListVo.getActLicenseNo());//档案编号 可以为空
//            commonVo.setName("测试一");//姓名
//            commonVo.setDocumentNo("110000199001011112");//证件号码
//            commonVo.setCarModels("B2E");//准驾车型
//            commonVo.setFirstGetDocDate("1999-07-04");//初次领证日期
//            commonVo.setArchviesNo("450728823049");//准驾车型
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));;//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
                //得到对象中的元素
                if (treatResult.has("driverBaseCheck")) {//基本信息核查
                    JSONObject driverBaseCheck= treatResult.optJSONObject("driverBaseCheck");
                    if ("1".equals(driverBaseCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                        JSONObject driverBaseCheck_item= driverBaseCheck.optJSONObject("item");
                        commonEntity.setTreatResult(driverBaseCheck.getString("treatResult"));         //核查状态
                        commonEntity.setNameCheckResult(driverBaseCheck_item.getString("nameCheckResult"));         //姓名核查结果
                        commonEntity.setDocumentNoCheckResult(driverBaseCheck_item.getString("documentNoCheckResult"));         //证件号码核查结果
                    }else if("2".equals(driverBaseCheck.getString("treatResult"))){//2代表未查到
                        commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(driverBaseCheck.getString("treatResult")));//核查状态
                        commonEntity.setNameCheckResult(PycreditTypeUtils.getTreatResult(driverBaseCheck.getString("treatResult")));//姓名核查结果
                        commonEntity.setDocumentNoCheckResult(PycreditTypeUtils.getTreatResult(driverBaseCheck.getString("treatResult")));//证件号码核查结果
                    }else{
                        throw new FmsServiceException(PycreditTypeUtils.getTreatResult(driverBaseCheck.getString("treatResult")));
                    }
                }
                if (treatResult.has("driverLicenseStatusInfo")) {//驾驶证状态
                    JSONObject driverLicenseStatusInfo= treatResult.optJSONObject("driverLicenseStatusInfo");
                    if ("1".equals(driverLicenseStatusInfo.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                        commonEntity.setTreatResult(driverLicenseStatusInfo.getString("treatResult"));         //核查状态
                        commonEntity.setDriverLicenseStatusDesc(driverLicenseStatusInfo.getString("driverLicenseStatusDesc"));         //驾驶证状态
                    }else if("2".equals(driverLicenseStatusInfo.getString("treatResult"))){//2代表未查到
//                        commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(driverLicenseStatusInfo.getString("treatResult")));//核查状态
                        commonEntity.setDriverLicenseStatusDesc(PycreditTypeUtils.getTreatResult(driverLicenseStatusInfo.getString("treatResult")));
                    }else{
                        throw new FmsServiceException(PycreditTypeUtils.getTreatResult(driverLicenseStatusInfo.getString("treatResult")));
                    }
                }
                String checkResult = "";
                if (treatResult.has("driverCarModelsCheck")) {//驾驶证准驾车辆核查
                    JSONObject driverCarModelsCheck= treatResult.optJSONObject("driverCarModelsCheck");
                    if ("1".equals(driverCarModelsCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                        commonEntity.setTreatResult(driverCarModelsCheck.getString("treatResult"));         //核查状态
                        checkResult = checkResult.concat(driverCarModelsCheck.getString("checkResult"));         //驾驶证准驾车辆核查
                    }else if("2".equals(driverCarModelsCheck.getString("treatResult"))){//2代表未查到
//                        commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(driverCarModelsCheck.getString("treatResult")));//核查状态
                        checkResult = PycreditTypeUtils.getTreatResult(driverCarModelsCheck.getString("treatResult"));
                    }else{
                        throw new FmsServiceException(PycreditTypeUtils.getTreatResult(driverCarModelsCheck.getString("treatResult")));
                    }
                }
                if (treatResult.has("driverFirstGetDocNoDateCheck")) {//驾驶证初次领证时间核查
                    JSONObject driverFirstGetDocNoDateCheck= treatResult.optJSONObject("driverFirstGetDocNoDateCheck");
                    if ("1".equals(driverFirstGetDocNoDateCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                        commonEntity.setTreatResult(driverFirstGetDocNoDateCheck.getString("treatResult"));         //核查状态
                        checkResult = checkResult.concat(" ").concat(driverFirstGetDocNoDateCheck.getString("checkResult"));         //驾驶证初次领证时间核查
                    }else if("2".equals(driverFirstGetDocNoDateCheck.getString("treatResult"))){//2代表未查到
//                        commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(driverFirstGetDocNoDateCheck.getString("treatResult")));//核查状态
                        checkResult = checkResult.concat(" ").concat(PycreditTypeUtils.getTreatResult(driverFirstGetDocNoDateCheck.getString("treatResult")));
                    }else{
                        throw new FmsServiceException(PycreditTypeUtils.getTreatResult(driverFirstGetDocNoDateCheck.getString("treatResult")));
                    }
                }
                if (treatResult.has("driverArchviesNoCheck")) {//驾驶证档案编号核查
                    JSONObject driverArchviesNoCheck= treatResult.optJSONObject("driverArchviesNoCheck");
                    if ("1".equals(driverArchviesNoCheck.getString("treatResult"))) {//如果核查状态为1代表查得才继续插值
                        commonEntity.setTreatResult(driverArchviesNoCheck.getString("treatResult"));         //核查状态
                        checkResult = checkResult.concat(" ").concat(driverArchviesNoCheck.getString("checkResult"));         //驾驶证档案编号核查
                    }else if("2".equals(driverArchviesNoCheck.getString("treatResult"))){//2代表未查到
//                        commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(driverArchviesNoCheck.getString("treatResult")));//核查状态
                        checkResult = checkResult.concat(" ").concat(PycreditTypeUtils.getTreatResult(driverArchviesNoCheck.getString("treatResult")));
                    }else{
                        throw new FmsServiceException(PycreditTypeUtils.getTreatResult(driverArchviesNoCheck.getString("treatResult")));
                    }
                }
                commonEntity.setCheckResult(checkResult);
            }
            commonEntity.setName(pycreditListVo.getName());//姓名
            commonEntity.setDocumentNo(pycreditListVo.getDocumentNo());//证件号码
            commonEntity.setCarModels(conversionQuasiDriveModel(pycreditListVo.getCarModels()));//准驾车型   可以为空
            commonEntity.setFirstGetDate(pycreditListVo.getFirstGetDate());//初次领证日期  格式yyyy-mm-dd  可以为空
            commonEntity.setArchviesNo(pycreditListVo.getArchviesNo());//档案编号 可以为空
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
            pycreditDriverRepository.insertData(commonEntity);

        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditDriverId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditDriver(commonEntity);
        return pycreditListVo;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信企业风险
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/12 15:34
     */
    public PycreditListVo savePyCreditCorpRisk(PycreditListVo pycreditListVo)throws Exception {
        //企业风险实体
        PycreditCorpRisk commonEntity = pycreditCorpRiskRepository.selectLastPycreditCorpRiskByDocumentNo(pycreditListVo.getName());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            commonEntity.setCorpRisk(this.getRiskMessage(commonEntity));//企业风险信息
            pycreditListVo.setPycreditCorpRisk(commonEntity);
        }else{
            commonEntity = new PycreditCorpRisk();
            //根据对象调用接口
            PyCreditCorpRiskInterfaceVo commonVo  =new PyCreditCorpRiskInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setCorpName(pycreditListVo.getName());//企业名称
//            commonVo.setCorpName("查得啊");//企业名称
//                commonVo.setRegisterNO(pycreditListVo.getRegisterNO());//工商注册号
//                commonVo.setOrgCode(pycreditListVo.getOrgCode());//企业机构代码
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject jsonResult = new JSONObject(t);          //通过String又得到每个元素的对象
                //得到对象中的元素
                JSONObject corpRiskInfo = jsonResult.optJSONObject("corpRiskInfo");
                if("1".equals(corpRiskInfo.get("treatResult"))){//1代表查得
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpRiskInfo.getString("treatResult")));//核查状态
                    JSONObject stat = corpRiskInfo.optJSONObject("stat");
                    if (stat.has("alCount")) {
                        commonEntity.setAlCount(stat.getInt("alCount"));//司法案例信息条数
                        commonEntity.setCqggCount(stat.getInt("cqggCount"));//催欠公告信息条数
                        commonEntity.setKtggCount(stat.getInt("ktggCount"));//开庭公告信息条数
                        commonEntity.setQtsfggCount(stat.getInt("qtsfggCount"));//其他司法公告信息条数
                        commonEntity.setSplcCount(stat.getInt("splcCount"));//审判流程信息条数
                        commonEntity.setSwCount(stat.getInt("swCount"));//税务行政执法信息条数
                        commonEntity.setWdyqCount(stat.getInt("wdyqCount"));//网贷逾期信息条数
                        commonEntity.setZxCount(stat.getInt("zxCount"));//司法执行信息条数
                        commonEntity.setSxCount(stat.getInt("sxCount"));//司法失信信息条数
                        commonEntity.setCorpRisk(this.getRiskMessage(commonEntity));//企业风险信息
                    }
                }else if("2".equals(corpRiskInfo.getString("treatResult"))){//2代表未查到
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpRiskInfo.getString("treatResult")));//核查状态
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(corpRiskInfo.getString("treatResult")));
                }

            }
            commonEntity.setCorpName(pycreditListVo.getName());//企业名称
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
//                commonEntity.setRegisterNO(pycreditListVo.getRegisterNO());//工商注册号
//                commonEntity.setOrgCode(pycreditListVo.getOrgCode());//企业机构代码

            pycreditCorpRiskRepository.insertData(commonEntity);

        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditCorpRiskId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditCorpRisk(commonEntity);
        return pycreditListVo;
    }

    /**
    * @Description: 构造企业风险信息
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/3 17:14
    */
    private String getRiskMessage(Object obj){
        String riskMsg = "";
        for(PycreditCropRiskTypeEnums riskType : PycreditCropRiskTypeEnums.values()){

            try {
                //如果风险条数大于0，记录下来
                if(Integer.parseInt(CommonUtils.getPropertyValueByObject(riskType.getType(), obj).toString())>0){
                    riskMsg += riskType.getDesc() + ":" + CommonUtils.getPropertyValueByObject(riskType.getType(), obj).toString()+";";
                }
            } catch (Exception e) {
                //不存在风险条数,或转换出错会报错，直接跳过
                continue;
            }
        }
        return riskMsg;
    }
    /**
     * @param pycreditListVo
     * @Description: 鹏远征信企业债务
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/12 15:34
     */
    public PycreditListVo savePycreditCorpDebt(PycreditListVo pycreditListVo)throws Exception {
        //企业债务查询
        PycreditCorpDebt commonEntity = pycreditCorpDebtRepository.selectLastPycreditCorpDebtByDocumentNo(pycreditListVo.getName());
        if(commonEntity != null && DateUtils.getDay(commonEntity.getQueryDate(),new Date())<=CommonConstants.ceilingNumber){
            commonEntity.setCorpDebt(this.getDebtMessage(commonEntity));//债务信息
            pycreditListVo.setPycreditCorpDebt(commonEntity);
        }else{
            commonEntity = new PycreditCorpDebt();
            //根据对象调用接口
            PyCreditCorpDebtInterfaceVo commonVo  =new PyCreditCorpDebtInterfaceVo();
            commonVo.setRefID(pycreditListVo.getApplyNo());//业务流水号(自定义CHAR(30)，可以为空)
            commonVo.setCorpName(pycreditListVo.getName());//企业名称
//            commonVo.setCorpName("测试一");//企业名称
//                commonVo.setRegisterNO(pycreditListVo.getRegisterNO());//工商注册号
//                commonVo.setOrgCode(pycreditListVo.getOrgCode());//企业机构代码
            Map<String,String> resultMap = ResponseEntityUtils.getRestResponseData(pyInterfaceRpc.requestUnzipApi(commonVo));;//调用接口
            //解析JSON并更新到地址核查表
            //非空验证
            JSONObject jsonObject = new JSONObject(resultMap.get(CommonPropertyConstants.RESULT));
            if(jsonObject.has("status")&&jsonObject.get("status").toString().equals("2")){
                throw new FmsServiceException(jsonObject.get("errorMessage").toString());
            }
            JSONObject returnValue = jsonObject.optJSONObject("returnValue");
            JSONArray cisReport = returnValue.optJSONArray("cisReport");
            for (int i = 0; i < cisReport.length(); i++) {           //解析对象且又嵌套着数组
                String t = cisReport.getString(i);                   //遍历过程将cisReport数组元素赋给String型变量
                JSONObject treatResult = new JSONObject(t);          //通过String又得到每个元素的对象
                JSONObject corpDebtInfo = treatResult.optJSONObject("corpDebtInfo");
                System.out.print(corpDebtInfo.getString("treatResult"));        //得到对象中的元素
                if("1".equals(corpDebtInfo.get("treatResult"))){//1代表查得
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpDebtInfo.getString("treatResult")));//核查状态
                    JSONObject corpDebtSummaryInfo = corpDebtInfo.optJSONObject("corpDebtSummaryInfo");
                    //得到对象中的元素
                    if (corpDebtSummaryInfo.has("morgualInfo")) {
                        commonEntity.setMorgualInfo(corpDebtSummaryInfo.getString("morgualInfo"));//动产抵押
                        commonEntity.setMorDetailInfo(corpDebtSummaryInfo.getString("morDetailInfo"));//动产抵押物
                        commonEntity.setSharesFrostInfo(corpDebtSummaryInfo.getString("sharesFrostInfo"));//股权冻结
                        commonEntity.setSharesImpawnInfo(corpDebtSummaryInfo.getString("sharesImpawnInfo"));//股权出质
                        commonEntity.setLiquidationInfo(corpDebtSummaryInfo.getString("liquidationInfo"));//清算信息
                        commonEntity.setCorpDebt(this.getDebtMessage(commonEntity));//债务信息
                    }
                }else if("2".equals(corpDebtInfo.getString("treatResult"))){//2代表未查到
                    commonEntity.setTreatResult(PycreditTypeUtils.getTreatResult(corpDebtInfo.getString("treatResult")));//核查状态
                }else{
                    throw new FmsServiceException(PycreditTypeUtils.getTreatResult(corpDebtInfo.getString("treatResult")));
                }
            }
            commonEntity.setCorpName(pycreditListVo.getName());//企业名称
//            commonEntity.setConditionsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString() +"_conditionsXml.txt"));//接口请求链接
//            commonEntity.setCisReportsXml(getFilePath(commonVo.getRefID()+ "_"+commonVo.getSubreportIDs()+"_"+DateUtils.getCurrentDateString()+"_cisReportsXml.txt"));//接口返回链接
            commonEntity.setConditionsXml(resultMap.get(CommonPropertyConstants.CONDITIONS_XML));//接口请求链接
            commonEntity.setCisReportsXml(resultMap.get(CommonPropertyConstants.CIS_REPORTS_XML));//接口返回链接
            commonEntity.setQueryDate(DateUtils.getNowDate());//查询日期
//                commonEntity.setRegisterNO(pycreditListVo.getRegisterNO());//工商注册号
//                commonEntity.setOrgCode(pycreditListVo.getOrgCode());//企业机构代码

            pycreditCorpDebtRepository.insertData(commonEntity);

        }
        //更新鹏远查询一览的鹏元信息id
        pycreditListVo.setPycreditResultId(commonEntity.getPycreditCorpDebtId());
        pycreditListRepository.updateByPrimaryKeySelectiveData(pycreditListVo.getEntity());
        //填充返回pycreditListVo
        pycreditListVo.setPycreditCorpDebt(commonEntity);
        return pycreditListVo;
    }

    /**
     * @Description: 构造企业债务信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/9/3 17:14
     */
    private String getDebtMessage(Object obj){
        String debtMsg = "";
        for(PycreditCropDebtTypeEnums debtType : PycreditCropDebtTypeEnums.values()){
            try {
                //有债务信息
                if(!CommonUtils.getPropertyValueByObject(debtType.getType(), obj).toString().startsWith("无")){
                    debtMsg += debtType.getDesc() + ":" + CommonUtils.getPropertyValueByObject(debtType.getType(), obj).toString()+";";
                }
            } catch (Exception e) {
                //无债务信息,或转换出错会报错，直接跳过
                continue;
            }
        }
        return debtMsg;
    }

    /**
     * @param filePath
     * @Description: 文件下载
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/28 15:34
     */
    public String getFilePath(String filePath){
        return CommonFileUtils.getRootPath(CommonFileUtils.joinFilePath(FileTypePathEnums.PY_FILES.getType(),filePath));
    }

    /**
     * @Description: 将驾驶证代码转换成实际准架车型
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/30 15:30
     */
    private String conversionQuasiDriveModel(String quasiDriveModel){
        if(StringUtils.isTrimBlank(quasiDriveModel)){
            return "";
        }else{
            String carModels = "";
            String[] models = quasiDriveModel.split(StringUtils.COMMA);
            for(String model : models){
                try {//如果已经是准架车型，这里转换会报错，直接返回准驾车型就行了
                    Integer.parseInt(model);
                } catch (NumberFormatException e) {
                    return quasiDriveModel;
                }
                String modelName = commonConstantService.findSysCodeValueName("quasiDriveModel",model);
                if(StringUtils.isTrimBlank(modelName)){
                    throw new FmsServiceException("未从数据字典中获取到准架车型");
                }
                carModels = carModels + modelName;
            }
            return carModels;
        }
    }
}