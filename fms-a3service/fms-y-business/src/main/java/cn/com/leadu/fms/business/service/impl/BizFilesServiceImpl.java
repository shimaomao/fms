package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.BizFilesRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author huchenghao
 * @ClassName: BizFilesService
 * @Description: 附件信息业务实现层
 * @date 2018-04-09
 */
@Service
public class BizFilesServiceImpl implements BizFilesService {

    /**
     * @Fields  : 附件信息repository
     */
    @Autowired
    private BizFilesRepository bizFilesRepository;

    /**
     * @Title:
     * @Description: 分页查询附件信息
     * @param bizFilesVo
     * @return PageInfoExtend<BizFiles>
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public PageInfoExtend<BizFiles> findBizFilessByPage(BizFilesVo bizFilesVo){
        Example example = SqlUtil.newExample(BizFiles.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BizFiles> pageInfo = bizFilesRepository.selectListByExamplePage(example,bizFilesVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param bizFilesVo
     * @return PageInfoExtend<BizFiles>
     * @throws
     * @Title:
     * @Description: 根据bizCode和bizCodeType获取附件信息
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public CommonBizFilesVo findBizFilesByBizInfo(BizFilesVo bizFilesVo) {
        return findBizFilesByBizCode(bizFilesVo.getBizCode(), bizFilesVo.getBizCodeType());
    }

    /**
     * @Title:
     * @Description: 保存附件信息
     * @param bizFilesList
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public void saveBizFilesList(List<BizFiles> bizFilesList){
        bizFilesRepository.insertDataList(bizFilesList);
    }

    /**
     * @Title:
     * @Description: 保存附件信息
     * @param bizFiles
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public void saveBizFilesByEntity(BizFiles bizFiles){
        bizFilesRepository.insertData(bizFiles);
    }


    /** 
    * @Description: 根据所属业务代码和代码类型删除附件信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/8 21:47
    */ 
    public void deleteBizFilesByBizCode(String bizCode,String bizCodeType){
        if(StringUtils.isTrimBlank(bizCode))
            throw new FmsServiceException("业务编码不能为空");
        if(StringUtils.isTrimBlank(bizCodeType))
            throw new FmsServiceException("业务类型不能为空");
        Example example = SqlUtil.newExample(BizFiles.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",bizCode);
        criteria.andEqualTo("bizCodeType",bizCodeType);
        bizFilesRepository.deleteExampleData(example,new BizFiles());
    }

    /**
     * @param bizCode
     * @param bizCodeType
     * @param fileType
     * @Description: 根据所属业务代码和类型，附件类型删除附件信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/30 14:16
     */
    @Override
    public void deleteBizFilesByBizCodeAndTypeAndFileType(String bizCode, String bizCodeType, String fileType) {
        Example example = SqlUtil.newExample(BizFiles.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",bizCode);
        criteria.andEqualTo("bizCodeType",bizCodeType);
        criteria.andEqualTo("fileType",fileType);
        bizFilesRepository.deleteExampleData(example,new BizFiles());
    }

    /**
     * @Title:
     * @Description:  根据fileId获取附件信息
     * @param fileId
     * @return BizFiles
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    public BizFiles findBizFilesByFileId(String fileId){
        return bizFilesRepository.selectByPrimaryKey(fileId);
    }

    /**
     * @Title:
     * @Description: 根据业务编码和业务类型返回文件list
     * @param: bizCode     业务编码
     * @param: bizCodeType 业务类型
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/14 0014 9:54
     */
    public List<BizFiles> findBizFilesList(String bizCode, String bizCodeType){
        if(StringUtils.isTrimBlank(bizCode))
            throw new FmsServiceException("业务编码不能为空");
        if(StringUtils.isTrimBlank(bizCodeType))
            throw new FmsServiceException("业务类型不能为空");
        Example example = SqlUtil.newExample(BizFiles.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",bizCode);
        criteria.andEqualTo("bizCodeType",bizCodeType);
        return bizFilesRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据fileId获取附件信息
     * @param bizCode
     * @return BizFiles
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @Override
    public CommonBizFilesVo findBizFilesByBizCode(String bizCode, String bizCodeType) {
        Example example = SqlUtil.newExample(BizFiles.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",bizCode);
        criteria.andEqualTo("bizCodeType",bizCodeType);
        List<BizFiles> bizFilesList = bizFilesRepository.selectListByExample(example);
        //生成 <附件类型：List<附件>>map
        Map<String, List<FileVo>> bizFileMap = new HashMap();
        List<FileVo> fileVoListAll = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)){
            for(int i=0; i<bizFilesList.size(); i++){
                FileVo fileVo = convert(bizFilesList.get(i), new FileVo());
                String basFileTypeValue = bizFilesList.get(i).getFileType();
                if(bizFileMap.containsKey(basFileTypeValue)){
                    bizFileMap.get(basFileTypeValue).add(fileVo);
                }else{
                    List<FileVo> fileVoList = new ArrayList<>();
                    fileVoList.add(fileVo);
                    bizFileMap.put(basFileTypeValue,fileVoList);
                }
                fileVoListAll.add(fileVo);
            }
        }
        CommonBizFilesVo bizFilesVo = new CommonBizFilesVo();
        Map<String, BizFilesListVo> bizFilesInfo = new HashMap();
        List<BizFilesListVo> bizFilesListVos = new ArrayList<>();
        //根据<附件类型：List<附件>>map 作成返回值
        Iterator it = bizFileMap.keySet().iterator();
        while (it.hasNext()) {
            BizFilesListVo bizFilesListVo = new BizFilesListVo();
            String key = it.next().toString();
            bizFilesListVo.setBasFileTypeValue(key);
            bizFilesListVo.setFileVos(bizFileMap.get(key));
            bizFilesListVos.add(bizFilesListVo);
            bizFilesInfo.put(key, bizFilesListVo);
        }
        BizFilesListVo bizFilesListVoAll = new BizFilesListVo();
        bizFilesListVoAll.setBasFileTypeValue(bizCodeType);
        bizFilesListVoAll.setFileVos(fileVoListAll);
        bizFilesInfo.put(bizCodeType,bizFilesListVoAll);
        bizFilesVo.setBizFilesListVos(bizFilesListVos);
        bizFilesVo.setBizFilesInfo(bizFilesInfo);
        //把附件类型返回
        bizFilesVo.setFileType(bizCodeType);
        return bizFilesVo;
    }

    private FileVo convert(BizFiles bizFiles, FileVo fileVo) {
        fileVo.setFileId(bizFiles.getFileId());
        String fileCompletePath = bizFiles.getFilePath();
        fileVo.setFileCompletePath(fileCompletePath);
        fileVo.setFileOriginalName(bizFiles.getFileName());
        return fileVo;
    }




    /**
     * @Title:
     * @Description:   返回业务附件集合
     * @param bizFilesListVos
     * @param bizCode
     * @param bizCoeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 11:20:42
     */
    public List<BizFiles> getBizFiles(List<BizFilesListVo> bizFilesListVos , String bizCode, String bizCoeType){
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVos)){
            List<BizFiles> bizFilesList = new ArrayList<>();
            for(BizFilesListVo bizFilesListVo : bizFilesListVos){
                if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVo.getFileVos()) && StringUtils.isNotTrimBlank(bizFilesListVo.getBasFileTypeValue())){
                    for(FileVo fileVo : bizFilesListVo.getFileVos()){
                        bizFilesList.add(getBizFiles(fileVo,bizFilesListVo,bizCode,bizCoeType));
                    }
                }
            }
            return bizFilesList;
        }
        return null;
    }


    /**
     * @Title:
     * @Description:   返回业务附件集合
     * @param bizFilesVos
     * @param bizCode
     * @param bizCoeType
     * @param notKeepID
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 11:20:42
     */
    public List<BizFiles> geBizFilesListByVos(List<BizFilesVo> bizFilesVos , String bizCode, String bizCoeType,boolean notKeepID){
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesVos)){
            List<BizFiles> bizFilesList = new ArrayList<>();
            for(BizFilesVo bizFilesVo : bizFilesVos){
               if(bizFilesVo != null){
                   if(notKeepID)
                       bizFilesVo.setFileId(null);
                   bizFilesVo.setBizCode(bizCode);
                   bizFilesVo.setBizCodeType(bizCoeType);
                   bizFilesList.add(bizFilesVo.getEntity());
               }
            }
            return bizFilesList;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   组装BizFiles数据
     * @param fileVo
     * @param bizFilesListVo
     * @param bizCode
     * @param bizCoeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 11:21:56
     */
    private BizFiles getBizFiles(FileVo fileVo,BizFilesListVo bizFilesListVo, String bizCode, String bizCoeType){
        BizFiles bizFiles = new BizFiles();
        if(StringUtils.isTrimBlank(bizFilesListVo.getBasFileTypeValue())){
            throw new FmsServiceException("附件类型不能为空");
        }
        bizFiles.setFileType(bizFilesListVo.getBasFileTypeValue());
        if(StringUtils.isTrimBlank(bizCode)){
            throw new FmsServiceException("附件bizCode不能为空");
        }
        bizFiles.setBizCode(bizCode);
        if(StringUtils.isTrimBlank(bizCoeType)){
            throw new FmsServiceException("附件bizCodeType不能为空");
        }
        bizFiles.setBizCodeType(bizCoeType);
        if(StringUtils.isTrimBlank(fileVo.getFileOriginalName())){
            throw new FmsServiceException("附件名称不能为空");
        }
        bizFiles.setFileName(fileVo.getFileOriginalName());
        if(StringUtils.isTrimBlank(fileVo.getFileCompletePath())){
            throw new FmsServiceException("附件路径不能为空");
        }
        bizFiles.setFilePath(fileVo.getFileCompletePath());
        return bizFiles;
    }

    /**
     * @Title:
     * @Description: 保存业务附件
     * @param bizFilesListVos  附件信息
     * @param bizCode   所属业务代码
     * @param bizCoeType 代码类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/11 02:37:08
     */
    @Transactional
    public List<BizFiles> saveBizFiles(List<BizFilesListVo> bizFilesListVos , String bizCode, String bizCoeType){
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVos)){
            List<BizFiles> bizFilesList = new ArrayList<>();
            for(BizFilesListVo bizFilesListVo : bizFilesListVos){
                if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVo.getFileVos()) && StringUtils.isNotTrimBlank(bizFilesListVo.getBasFileTypeValue())){
                    for(FileVo fileVo : bizFilesListVo.getFileVos()){
                        bizFilesList.add(getBizFiles(fileVo,bizFilesListVo,bizCode,bizCoeType));
                    }
                }
            }
            bizFilesRepository.insertDataList(bizFilesList);
            return bizFilesList;
        }
        return null;
    }
    /**
     * @description: 更新业务附件
     * @param bizFilesListVos
     * @param bizCode
     * @author ningyangyang
     * @param bizCodeType
     */
    @Override
    @Transactional
    public void updateBizFiles(List<BizFilesListVo> bizFilesListVos, String bizCode, String bizCodeType) {
        Example example = SqlUtil.newExample(BizFiles.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bizCode",bizCode).andEqualTo("bizCodeType",bizCodeType);
        List<BizFiles> getBizFilesList = bizFilesRepository.selectListByExample(example);  //找出所有原有附件
        List<String> getFileList = new ArrayList<>();//存储保留附件
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVos)){
            List<BizFiles> bizFilesAddList = new ArrayList<>();
            for(BizFilesListVo bizFilesListVo : bizFilesListVos){
                if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVo.getFileVos()) && StringUtils.isNotTrimBlank(bizFilesListVo.getBasFileTypeValue())){
                    for(FileVo fileVo : bizFilesListVo.getFileVos()){
                        if(fileVo.getFileId()==null){
                            BizFiles bizFile = new BizFiles();
                            bizFile.setBizCode(bizCode);
                            bizFile.setFileType(bizFilesListVo.getBasFileTypeValue());
                            bizFile.setBizCodeType(bizCodeType);
                            bizFile.setFileName(fileVo.getFileOriginalName());
                            bizFile.setFilePath(fileVo.getFileCompletePath());
                            bizFilesAddList.add(bizFile);
                        }{
                            getFileList.add(fileVo.getFileId());
                        }
                    }
                }
            }
            bizFilesRepository.insertDataList(bizFilesAddList);
            List<String> delList = new ArrayList<>();
            if(ArrayUtils.isNotNullAndLengthNotZero(getBizFilesList)){
                for(BizFiles bizFiles:getBizFilesList){
                    if(!getFileList.contains(bizFiles.getFileId())){
                        delList.add(bizFiles.getFileId());
                    }
                }
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(delList)){
                bizFilesRepository.deleteDataList(delList,new BizFiles());
            }

        }else{
            CommonBizFilesVo commonBizFilesVo = findBizFilesByBizCode(bizCode,bizCodeType);
            if(ArrayUtils.isNotNullAndLengthNotZero(commonBizFilesVo.getBizFilesListVos())){
                for(BizFilesListVo bizFilesListVo : commonBizFilesVo.getBizFilesListVos()){
                    if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesListVo.getFileVos())){
                        for(FileVo fileVo:bizFilesListVo.getFileVos()){
                            BizFiles bizFiles = new BizFiles();
                            bizFiles.setFileId(fileVo.getFileId());
                            bizFilesRepository.deleteData(bizFiles);
                        }
                    }
                }
            }

        }
    }

    /**
     * @Title:
     * @Description: 根据业务编码和业务类型更新附件信息
     * @param: bizFilesList 附件集合
     * @param: bizCode  业务编码
     * @param: bizCodeType 业务类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/18 0018 18:22
     */
    @Transactional
    public void modifyBizFilesList(List<BizFiles> bizFilesList, String bizCode, String bizCodeType){
        if(StringUtils.isTrimBlank(bizCode))
            throw new FmsServiceException("业务编码不能为空");
        if(StringUtils.isTrimBlank(bizCodeType))
            throw new FmsServiceException("业务类型不能为空");
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)){
            //防止丢失bizCode与bizType
            bizFilesList.forEach(bizFiles -> {
                if(bizFiles != null) {
                    bizFiles.setBizCode(bizCode);
                    bizFiles.setBizCodeType(bizCodeType);
                }
            });
            //本次需要添加的附件
            List<BizFiles> saveBizFilesList = new ArrayList<>();
            //本次需要删除的附件
            List<String> deleteBizFilesIdList = new ArrayList<>();
            //记录本次上传未删除的附件
            Map<String,BizFiles> noDeleteFiles = new HashMap<>();
            bizFilesList.forEach(bizFiles -> {
                if(bizFiles != null) {
                    if (StringUtils.isTrimBlank(bizFiles.getFileId())) {
                        saveBizFilesList.add(bizFiles);
                    } else
                        noDeleteFiles.put(bizFiles.getFileId(), bizFiles);
                }
            });
            //原本的附件
            List<BizFiles> existBizFilesList = findBizFilesList(bizCode,bizCodeType);
            if(ArrayUtils.isNotNullAndLengthNotZero(existBizFilesList)) {
                //得到已经删除的文件
                existBizFilesList.forEach(bizFiles -> {
                    if(bizFiles != null) {
                        if (noDeleteFiles.get(bizFiles.getFileId()) == null)
                            deleteBizFilesIdList.add(bizFiles.getFileId());
                    }
                });
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(deleteBizFilesIdList))
                //删除附件
                bizFilesRepository.deleteDataList(deleteBizFilesIdList,new BizFiles());
            if(ArrayUtils.isNotNullAndLengthNotZero(saveBizFilesList))
                //添加附件
                bizFilesRepository.insertDataList(saveBizFilesList);
        }else{
            //没有上传附件则直接删除原有附件
            deleteBizFilesByBizCode(bizCode,bizCodeType);
        }
    }

    /**
     * @Title:
     * @Description:   fileVos转换成bizFilesList
     * @param fileVos
     * @param bizCode
     * @param bizCodeType
     * @param fileType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/06 06:08:42
     */
    public List<BizFiles> getBizFilesList(List<FileVo> fileVos,String bizCode,String bizCodeType,String fileType){
        if(ArrayUtils.isNotNullAndLengthNotZero(fileVos)) {
            List<BizFiles> bizFilesList = new ArrayList<>();
            for (FileVo fileVo : fileVos) {
                BizFiles bizFiles = new BizFiles();
                bizFiles.setBizCode(bizCode);
                bizFiles.setBizCodeType(bizCodeType);
                bizFiles.setFileType(fileType);
                bizFiles.setFilePath(fileVo.getFileCompletePath());
                bizFiles.setFileName(fileVo.getFileOriginalName());
                bizFilesList.add(bizFiles);
            }
            return bizFilesList;
        }
        return null;
    }


    /**
     * @Title:
     * @Description:   bizFilesList转换为fileVos
     * @param bizFilesList
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 03:00:43
     */
    public List<FileVo> getFileVos(List<BizFiles> bizFilesList){
        if(ArrayUtils.isNotNullAndLengthNotZero(bizFilesList)) {
            List<FileVo> fileVos = new ArrayList<>();
            for (BizFiles bizFiles : bizFilesList) {
                FileVo fileVo = new FileVo();
                fileVo.setFileId(bizFiles.getFileId());
                fileVo.setFileCompletePath(bizFiles.getFilePath());
                fileVo.setFileOriginalName(bizFiles.getFileName());
                fileVos.add(fileVo);
            }
            return fileVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   根据业务信息查询file集合
     * @param bizCode
     * @param bizCodeType
     * @param fileType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/08 02:47:57
     */
    public List<BizFiles> findBizFilesByBizInfo(String bizCode,String bizCodeType,String fileType){
        Example example = SqlUtil.newExample(BizFiles.class);
        example.createCriteria().andEqualTo("bizCode",bizCode)
                .andEqualTo("bizCodeType",bizCodeType)
                .andEqualTo("fileType",fileType);
        return bizFilesRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据业务id 业务类型 文件类型删除附件
     * @param bizCodes
     * @param bizCodeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/12 03:14:10
     */
    @Transactional
    public void deleteBizFilesList(List<String> bizCodes,String bizCodeType){
        Example example = SqlUtil.newExample(BizFiles.class);
        example.createCriteria().andIn("bizCode",bizCodes)
                .andEqualTo("bizCodeType",bizCodeType);
        bizFilesRepository.deleteExampleData(example,new BizFiles());
    }

}
