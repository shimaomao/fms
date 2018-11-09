package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.common.constant.enums.asset.MortgateStsEnums;
import cn.com.leadu.fms.asset.service.MortgageRegisterService;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteListVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterModifyVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterSaveVo;
import cn.com.leadu.fms.business.rpc.baseinfo.BasFileTypeRpc;
import cn.com.leadu.fms.business.rpc.system.SysTplTypesRpc;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileStatusEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.OpenOfficeUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.WordPoiUtils;
import cn.com.leadu.fms.data.asset.repository.MortgageRegisterRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.FileSendRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgagePostVo;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterService
 * @Description: 解抵押过户信息业务实现层
 * @date 2018-05-18
 */
@Slf4j
@Service
public class MortgageRegisterServiceImpl implements MortgageRegisterService {

    /**
     * @Fields  : 解抵押过户信息repository
     */
    @Autowired
    private MortgageRegisterRepository mortgageRegisterRepository;

    /**
     * @Fields  : 附件类型rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    /**
     * @Fields  : 模板管理rpc
     */
    @Autowired
    private SysTplTypesRpc sysTplTypeRpc;

    /**
     * @Fields  : 附件service
     */
    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Fields  : 资料邮寄附件Repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Fields  : 资料邮寄附件明细Repository层
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields : 资料邮寄Repository层
     */
    @Autowired
    private FileSendRepository fileSendRepository;

    /**
     * @Title:
     * @Description: 分页查询解抵押过户一览
     * @param mortgageRegisterVo
     * @return PageInfoExtend<MortgageRegister>
     * @throws
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<MortgageRegisterVo> findMortgageRegistersByPage(MortgageRegisterVo mortgageRegisterVo){
        if (StringUtils.isTrimBlank(mortgageRegisterVo.getContNo()))
            mortgageRegisterVo.setContNo(null);
        else
            mortgageRegisterVo.setContNo(SqlUtil.likePattern(mortgageRegisterVo.getContNo()));

        if(StringUtils.isTrimBlank(mortgageRegisterVo.getName()))
            mortgageRegisterVo.setName(null);
        else
            mortgageRegisterVo.setName(SqlUtil.likePattern(mortgageRegisterVo.getName()));
        return mortgageRegisterRepository.selectListVoByPage("selectMortgageRegistersByPage", mortgageRegisterVo, mortgageRegisterVo.getPageQuery());
    }


    /**
    * @Description: 根据合同编号查询解抵押信息
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/5/21 14:30
    */
    @Override
    public MortgageRegister findMortgageRegisterByContNo(String contNo) {
        Example example = SqlUtil.newExample(MortgageRegister.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contNo",contNo);
        return mortgageRegisterRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 保存解抵押过户信息
     * @param mortgageRegisterSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:46
     */
    @Transactional
    @Override
    public void saveMortgageRegister(MortgageRegisterSaveVo mortgageRegisterSaveVo){
        //更新或保存解抵押过户信息
        MortgageRegister mortgageRegister = this.findMortgageRegisterByContNo(mortgageRegisterSaveVo.getContNo());
        mortgageRegisterSaveVo.setMortgateSts(MortgateStsEnums.WAIT_POST.getType());
        if(mortgageRegister == null){
            mortgageRegisterRepository.insertData(mortgageRegisterSaveVo.getEntity());
        }else{
            mortgageRegisterSaveVo.setMortgageRegisterId(mortgageRegister.getMortgageRegisterId());
            mortgageRegisterRepository.updateByPrimaryKeySelectiveData(mortgageRegisterSaveVo.getEntity());
        }
        //删除原先的附件
        bizFilesService.deleteBizFilesByBizCode(mortgageRegisterSaveVo.getContNo(),BizCodeTypeEnums.MORTGAGE_REGISTER.getCodeType());

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        List<BizFiles> bizFilesList=new ArrayList<>();
        //根据文件类型取得 解抵押附件类型
        try {
            List<BasFileType> basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.MORTGAGE_REGISTER.getCodeType()));
            //取得解抵押模板路径
            SysTplTypeVo sysTplTypeVo=new SysTplTypeVo();
            List tplTypeKeys=new ArrayList();
            for(BasFileType basFileType : basFileTypeList){
                tplTypeKeys.add(basFileType.getFileType());
            }
            sysTplTypeVo.setTplTypeKeys(tplTypeKeys);
            List<SysTplType>  sysTplTypeList = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeListByBasFileTypeList(sysTplTypeVo));
            if(sysTplTypeList.size()==0){
                throw new FmsServiceException( "缺少解抵押附件模板!");
            }
            for(SysTplType sysTpltype : sysTplTypeList){
                String filePath = CommonFileUtils.setRootPath(sysTpltype.getTplContent());//模板文件路径
                //模板文件重命名路径
                String newFilePath=filePath.substring(0,filePath.indexOf("."))+"_"+df.format(new Date())+".docx";
                //pdf路径
                String outPath=newFilePath.replace(".docx",".pdf");
                //替換文本
                Map<String,String> map = new HashMap<>();
                map.put("CONTNO",mortgageRegisterSaveVo.getContNo());
                WordPoiUtils.replaceAndGenerateWord(filePath,newFilePath,map);
                try {
                    OpenOfficeUtils.outPdf(newFilePath,outPath);//生成pdf文件
                }catch (Exception e){
                    e.printStackTrace();
                    throw new FmsServiceException( "生成pdf文件失败!");
                }
                //附件信息保存
                BizFiles bizFiles=new BizFiles();
                bizFiles.setBizCode(mortgageRegisterSaveVo.getContNo());
                bizFiles.setBizCodeType(BizCodeTypeEnums.MORTGAGE_REGISTER.getCodeType());
                bizFiles.setFileType(sysTpltype.getTplTypeKey());
                bizFiles.setFileName(sysTpltype.getTplTypeName()+mortgageRegisterSaveVo.getContNo()+".pdf");
                bizFiles.setFilePath(outPath);
                bizFilesList.add(bizFiles);
            }
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException( "保存解抵押附件失败!");
        }
        //保存生成的解抵押文件到附件信息表
        if(bizFilesList.size()>0){
            bizFilesService.saveBizFilesList(bizFilesList);
        }
        //查找资料邮寄附件信息
        Example example = SqlUtil.newExample(OrigFile.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",mortgageRegisterSaveVo.getContNo());
        criteria.andEqualTo("bizCodeType",OrigFileBizCodeTypeEnum.MORTGAGE_POST.getType());
        OrigFile origFileOld= origFileRepository.selectOneByExample(example);

        //保存资料邮寄附件信息
        OrigFile origFile = new OrigFile();
        origFile.setBizCode(mortgageRegisterSaveVo.getContNo());
        origFile.setBizCodeType(OrigFileBizCodeTypeEnum.MORTGAGE_POST.getType());//1-解除抵押类
        origFile.setOrigFileStatus(OrigFileStatusEnums.VERIFIED.getType());//待归档

        if(origFileOld == null){
            origFileRepository.insertData(origFile);
        }else{
            origFile.setOrigFileId(origFileOld.getOrigFileId());
            origFileRepository.updateByPrimaryKeySelectiveData(origFile);
        }
        //删除原先的邮寄资料明细
        Example exampleDetail = SqlUtil.newExample(OrigFileDetail.class);
        Example.Criteria criteriaDetail = exampleDetail.createCriteria();
        criteriaDetail.andEqualTo("bizCode",mortgageRegisterSaveVo.getContNo());
        criteriaDetail.andEqualTo("bizCodeType",OrigFileBizCodeTypeEnum.MORTGAGE_POST.getType());
        origFileDetailRepository.deleteExampleData(exampleDetail,new OrigFileDetail());

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();//邮寄资料明细
        //保存资料邮寄附件明细信息
        try {
            List<BasFileType> basFileTypeList = ResponseEntityUtils.getRestResponseData(basFileTypeRpc.getChildFileTypes(BizCodeTypeEnums.MORTGAGE_REGISTER_POST.getCodeType()));
            if(basFileTypeList.size() == 0){
                throw new FmsServiceException("资料邮寄附件明细信息不存在！");
            }
            for(BasFileType basFileType : basFileTypeList){
                OrigFileDetail origFileDetail = new OrigFileDetail();
                origFileDetail.setBizCodeType(OrigFileBizCodeTypeEnum.MORTGAGE_POST.getType());//1-解除抵押类
                origFileDetail.setBizCode(mortgageRegisterSaveVo.getContNo());
                origFileDetail.setFileType(basFileType.getFileType());
                origFileDetail.setFileCount(basFileType.getFileQtyLimit());
                origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.TO_BE_MAILED.getType());//待邮寄

                origFileDetailList.add(origFileDetail);
            }
            origFileDetailRepository.insertDataList(origFileDetailList);

        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("保存资料邮寄附件明细信息失败！");
        }

    }

    /**
     * @param mortgagePostVo
     * @Description: 保存解抵押资料邮寄信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/22 16:59
     */
    @Transactional
    @Override
    public void saveMortgagePost(MortgagePostVo mortgagePostVo) {
        //更新解抵押表
        MortgageRegister mortgageRegister = this.findMortgageRegisterByContNo(mortgagePostVo.getContNo());
        mortgageRegister.setMortgateSts(MortgateStsEnums.ALREDAY_POST.getType());
        mortgageRegister.setMortgageReason(mortgagePostVo.getMortgageReason());
        mortgageRegister.setPostAddrType(mortgagePostVo.getPostAddrType());
        mortgageRegister.setPostAddr(mortgagePostVo.getPostAddr());
        mortgageRegister.setPostMemo(mortgagePostVo.getPostMemo());
        mortgageRegisterRepository.updateByPrimaryKeySelectiveData(mortgageRegister);

        //保存资料邮寄表
        FileSend fileSend = new FileSend();
        fileSend.setPostComp(mortgagePostVo.getPostComp());
        fileSend.setPostDate(mortgagePostVo.getPostDate());
        fileSend.setPostNo(mortgagePostVo.getPostNo());
        fileSend.setPostMember(mortgagePostVo.getPostMember());
        fileSend.setPostMemberTel(mortgagePostVo.getPostMemberTel());
        fileSendRepository.insertData(fileSend);

        //资料邮寄明细表更新
        for (OrigFileDetail origFileDetail:mortgagePostVo.getOrigFileDetailList()){
            origFileDetail.setFilePostId(fileSend.getFilePostId());
            origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.ALREADY_MAILED.getType());//已邮寄待签收
        }
        origFileDetailRepository.updateByPrimaryKeySelectiveDataList(mortgagePostVo.getOrigFileDetailList());
    }

    /**
     * @Title:
     * @Description: 修改解抵押过户信息
     * @param mortgageRegisterModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:46
     */
    public void modifyMortgageRegister(MortgageRegisterModifyVo mortgageRegisterModifyVo){
        mortgageRegisterRepository.updateByPrimaryKeySelectiveData(mortgageRegisterModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过mortgageRegisterId删除解抵押过户信息
     * @param mortgageRegisterDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:46
     */
    public void deleteMortgageRegister(MortgageRegisterDeleteVo mortgageRegisterDeleteVo){
        mortgageRegisterRepository.deleteData(mortgageRegisterDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过mortgageRegisterId集合删除解抵押过户信息
     * @param mortgageRegisterDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:46
     */
    public void deleteMortgageRegistersByMortgageRegisterIds(MortgageRegisterDeleteListVo mortgageRegisterDeleteListVo){
        mortgageRegisterRepository.deleteDataList(mortgageRegisterDeleteListVo.getMortgageRegisterIds(),mortgageRegisterDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据mortgageRegisterId获取解抵押过户信息
     * @param mortgageRegisterId
     * @return MortgageRegister
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:46
     */
    public MortgageRegister findMortgageRegisterByMortgageRegisterId(String mortgageRegisterId){
        return mortgageRegisterRepository.selectByPrimaryKey(mortgageRegisterId);
    }

}
