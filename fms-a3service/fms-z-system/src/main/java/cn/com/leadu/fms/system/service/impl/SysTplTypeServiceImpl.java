package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.CommonFileUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysTplTypeRepository;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.system.service.SysTplItemService;
import cn.com.leadu.fms.system.service.SysTplTypeService;
import cn.com.leadu.fms.system.validator.systplitem.vo.SysTplItemDeleteListVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeModifyVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeSaveVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeService
 * @Description: 模板类型管理业务实现层
 * @date 2018-03-12
 */
@Slf4j
@Service
public class SysTplTypeServiceImpl implements SysTplTypeService {

    /**
     * @Fields  : 模板类型管理repository
     */
    @Autowired
    private SysTplTypeRepository sysTplTypeRepository;

    @Autowired
    private SysTplItemService sysTplItemService;

    /**
     * @Title:
     * @Description: 分页查询模板类型管理
     * @param sysTplTypeVo
     * @return PageInfoExtend<SysTplType>
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    public PageInfoExtend<SysTplType> findSysTplTypesByPage(SysTplTypeVo sysTplTypeVo){
        Example example = SqlUtil.newExample(SysTplType.class);
        Example.Criteria criteria = example.createCriteria();
        // 类型识别ID
        if (StringUtils.isNotTrimBlank(sysTplTypeVo.getTplTypeKey())) {
            criteria.andLike("tplTypeKey", SqlUtil.likePattern(sysTplTypeVo.getTplTypeKey()));
        }
        // 类型名称
        if (StringUtils.isNotTrimBlank(sysTplTypeVo.getTplTypeName())) {
            criteria.andLike("tplTypeName", SqlUtil.likePattern(sysTplTypeVo.getTplTypeName()));
        }
        // 模板种类
        if (StringUtils.isNotTrimBlank(sysTplTypeVo.getTplType())) {
            criteria.andEqualTo("tplType", sysTplTypeVo.getTplType());
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysTplType> pageInfo = sysTplTypeRepository.selectListByExamplePage(example,sysTplTypeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存模板类型管理
     * @param sysTplTypeSaveVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Transactional
    public void saveSysTplType(SysTplTypeSaveVo sysTplTypeSaveVo){
        // 保存可设置项目
        List<SysTplItemVo> sysTplItemVoList = sysTplTypeSaveVo.getTplItemList();
        if (ArrayUtils.isNotNullAndLengthNotZero(sysTplItemVoList)) {
            List<SysTplItem> insertSysTplItemList = new ArrayList<>();
            for (SysTplItemVo sysTplItemVo : sysTplItemVoList) {
                SysTplItem sysTplItem = new SysTplItem();
                sysTplItem.setTplItemKey(sysTplItemVo.getTplItemKey());
                sysTplItem.setTplItemName(sysTplItemVo.getTplItemName());
                sysTplItem.setTplTypeKey(sysTplTypeSaveVo.getTplTypeKey());
                insertSysTplItemList.add(sysTplItem);
            }
            sysTplItemService.saveSysTplItemList(insertSysTplItemList);
        }

        //移动合同模板到具体文件夹下
        if(TplTypeEnums.CONTRACT.getType().equals(sysTplTypeSaveVo.getTplType()))
            sysTplTypeSaveVo.setTplContent(moveFile(sysTplTypeSaveVo.getTplContent(),sysTplTypeSaveVo.getTplTypeKey()));
        // 保存模板类型
        sysTplTypeRepository.insertData(sysTplTypeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改模板类型管理
     * @param sysTplTypeModifyVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Transactional
    public void modifySysTplType(SysTplTypeModifyVo sysTplTypeModifyVo){
        // 取得原有的可设置项目
        List<SysTplItemVo> sysTplItemList = sysTplItemService.findSysTplItemListByTplTypeKey(sysTplTypeModifyVo.getTplTypeKey());
        Map<String, String> syTplItemMap = new HashMap<>();
        for (SysTplItemVo sysTplItem : sysTplItemList) {
            syTplItemMap.put(sysTplItem.getTplItemId(), sysTplItem.getTplItemId());
        }
        // 本次传入的可设置项目
        List<SysTplItemVo> sysTplItemVoList = sysTplTypeModifyVo.getTplItemList();
        Map<String,String> sysTplItemVoMap = new HashMap<>();
        for (SysTplItemVo sysTplItemVo : sysTplItemVoList) {
            sysTplItemVoMap.put(sysTplItemVo.getTplItemId(), sysTplItemVo.getTplItemId());
        }
        // 本次新增的可设置项目
        List<SysTplItem> insertSysTplItemList = new ArrayList<>();
        for (SysTplItemVo sysTplItemVo : sysTplItemVoList) {
            if (!syTplItemMap.containsKey(sysTplItemVo.getTplItemId())) {
                SysTplItem sysTplItem = new SysTplItem();
                sysTplItem.setTplItemKey(sysTplItemVo.getTplItemKey());
                sysTplItem.setTplItemName(sysTplItemVo.getTplItemName());
                sysTplItem.setTplTypeKey(sysTplTypeModifyVo.getTplTypeKey());
                insertSysTplItemList.add(sysTplItem);
            }
        }
        // 本次删除的可设置项目
        List<String> deleteSysTplItemList = new ArrayList<>();
        for (SysTplItemVo sysTplItem : sysTplItemList) {
            if (!sysTplItemVoMap.containsKey(sysTplItem.getTplItemId())) {
                deleteSysTplItemList.add(sysTplItem.getTplItemId());
            }
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(insertSysTplItemList)) {
            sysTplItemService.saveSysTplItemList(insertSysTplItemList);
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(deleteSysTplItemList)) {
            SysTplItemDeleteListVo sysTplItemDeleteListVo = new SysTplItemDeleteListVo();
            sysTplItemDeleteListVo.setTplItemIds(deleteSysTplItemList);
            sysTplItemService.deleteSysTplItemsByTplItemIds(sysTplItemDeleteListVo);
        }
        //移动合同模板到具体文件夹下
        if(TplTypeEnums.CONTRACT.getType().equals(sysTplTypeModifyVo.getTplType()))
            sysTplTypeModifyVo.setTplContent(moveFile(sysTplTypeModifyVo.getTplContent(),sysTplTypeModifyVo.getTplTypeKey()));
        sysTplTypeRepository.updateByPrimaryKeySelectiveData(sysTplTypeModifyVo.getEntity());
    }

    //移动文件
    private String moveFile(String filePath,String tplTypeKey){
        //移动模板到具体文件夹下
        String [] tplContents = filePath.split("/");
        //如果tplTypeKey存在,说明是已经上传并未修改的文件,直接继续使用,不存在说明是新上传的文件
        if(ArrayUtils.equalsContains(tplContents,tplTypeKey))
            return filePath;
        else {
            String tplContent = "/";
            for (int i = 0; i < tplContents.length - 1; i++) {
                if (StringUtils.isNotTrimBlank(tplContents[i]))
                    tplContent = CommonFileUtils.joinFilePath(tplContent, tplContents[i]);
            }
            tplContent = CommonFileUtils.joinFilePath(tplContent, FileTypePathEnums.SYS_TPL.getType());
            tplContent = CommonFileUtils.joinFilePath(tplContent, tplTypeKey);
            tplContent = CommonFileUtils.joinFilePath(tplContent, tplContents[tplContents.length - 1]);
            try {
                org.apache.commons.io.FileUtils.moveFile(new File(CommonFileUtils.setRootPath(filePath)), new File(CommonFileUtils.setRootPath(tplContent)));
            } catch (IOException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("保存合同模板失败");
            }
            return tplContent;
        }
    }

    /**
     * @Title:
     * @Description:  通过tplTypeId集合删除模板类型管理
     * @param sysTplTypeDeleteListVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @Transactional
    public ResponseEntity<RestResponse> deleteSysTplTypesByTplTypeIds(SysTplTypeDeleteListVo sysTplTypeDeleteListVo){
        Long count = sysTplTypeRepository.selectSysTplCountByTplTypeIds(sysTplTypeDeleteListVo.getTplTypeIds());
        if (count > 0) {
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse("模板类型已经被模板使用,不能删除"), HttpStatus.OK);
        }
        // 取得本次要删除的模板类型的可设置项目ID
        List<String> deleteSysTplItemList = sysTplTypeRepository.selectSysTplItemIdsByTplTypeIds(sysTplTypeDeleteListVo.getTplTypeIds());
        // 删除可设置项目
        if (ArrayUtils.isNotNullAndLengthNotZero(deleteSysTplItemList)) {
            SysTplItemDeleteListVo sysTplItemDeleteListVo = new SysTplItemDeleteListVo();
            sysTplItemDeleteListVo.setTplItemIds(deleteSysTplItemList);
            sysTplItemService.deleteSysTplItemsByTplItemIds(sysTplItemDeleteListVo);
        }
        // 删除模板类型数据
        sysTplTypeRepository.deleteDataList(sysTplTypeDeleteListVo.getTplTypeIds(),sysTplTypeDeleteListVo.getEntity());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据tplTypeId获取模板类型信息Vo
     * @param tplTypeId
     * @return SysTplType
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    public SysTplTypeVo findSysTplTypeVoByTplTypeId(String tplTypeId){
        // 取得模板类型信息
        SysTplType sysTplType = sysTplTypeRepository.selectByPrimaryKey(tplTypeId);
        SysTplTypeVo sysTplTypeVo = EntityUtils.getEntity(sysTplType, new SysTplTypeVo());
        // 取得模板类型可设置项目
        List<SysTplItemVo> sysTplItemVoList = sysTplItemService.findSysTplItemListByTplTypeKey(sysTplTypeVo.getTplTypeKey());
        if (ArrayUtils.isNotNullAndLengthNotZero(sysTplItemVoList)) {
            sysTplTypeVo.setTplItemList(sysTplItemVoList);
        } else {
            sysTplTypeVo.setTplItemList(new ArrayList<>());
        }
        return sysTplTypeVo;
    }

    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板类型信息
     * @param tplTypeKey
     * @return SysTplType
     * @throws
     * @author wubaoliang
     * @date 2018-3-15 14:38:41
     */
    @Override
    public SysTplType findSysTplTypeByTplTypeKey(String tplTypeKey) {
        if (StringUtils.isNotTrimBlank(tplTypeKey)) {
            Example example = SqlUtil.newExample(SysTplType.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tplTypeKey", tplTypeKey);
            SqlUtil.setOrderByUpdateTimeDesc(example);
            return sysTplTypeRepository.selectOneByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  根据tplTypeKeys获取模板信息
     * @param sysTplTypeVo
     * @return String
     * @throws
     * @author huchenghao
     * @date 2018-3-16 15:16:19
     */
    @Override
    public List<SysTplType> findSysTplTypeListByBasFileTypeList(SysTplTypeVo sysTplTypeVo) {
        Example example = SqlUtil.newExample(SysTplType.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("tplTypeKey",sysTplTypeVo.getTplTypeKeys());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        List<SysTplType> sysTplTypeList=sysTplTypeRepository.selectListByExample(example);
        return sysTplTypeList;
    }
}
