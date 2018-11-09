package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasFileTypeService;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeSaveVo;
import cn.com.leadu.fms.business.common.util.CommonTreeDataUtils;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileGroupRepository;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileTypeRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeService
 * @Description: 附件类型管理表业务实现层
 * @date 2018-03-19
 */
@Service
public class BasFileTypeServiceImpl implements BasFileTypeService {

    /**
     * @Fields : 附件类型管理表repository
     */
    @Autowired
    private BasFileTypeRepository basFileTypeRepository;

    /**
     * @Fields : 附件组repository
     */
    @Autowired
    private BasFileGroupRepository basFileGroupRepository;

    /**
     * @param basFileTypeVo
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @Title:
     * @Description: 分页查询附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public PageInfoExtend<BasFileType> findBasFileTypeByPage(BasFileTypeVo basFileTypeVo) {
        Example example = SqlUtil.newExample(BasFileType.class);
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteriaOr = example.createCriteria();

        if(StringUtils.isNotTrimBlank(basFileTypeVo.getFileTypeName())){
            criteria.andLike("fileTypeName", SqlUtil.likePattern(basFileTypeVo.getFileTypeName()));
        }
        // 检索附件类型 和该附件类型的子节点
        if(StringUtils.isNotTrimBlank(basFileTypeVo.getFileType())){
            criteriaOr.andEqualTo("fileType",basFileTypeVo.getFileType());
            Example example1 = SqlUtil.newExample(BasFileGroup.class);
            example1.createCriteria().andEqualTo("fileTypePar",basFileTypeVo.getFileType());
            List<BasFileGroup> basFileGroupList = basFileGroupRepository.selectListByExample(example1);
            if(ArrayUtils.isNotNullAndLengthNotZero(basFileGroupList)){
                List<String> parentFileTypes = new ArrayList();
                for(BasFileGroup basFileGroup:basFileGroupList){
                    parentFileTypes.add(basFileGroup.getFileTypeChi());
                }
                criteriaOr.orIn("fileType",parentFileTypes);
            }

            //parentFileTypes.add(basFileTypeVo.getFileType());
        }
        //and（A or B）条件
        example.and(criteriaOr);
        example.setOrderByClause("file_type = '"+ basFileTypeVo.getFileType() +"' desc, update_time desc");
        PageInfoExtend<BasFileType> pageInfo = basFileTypeRepository.selectListByExamplePage(example,basFileTypeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param basFileTypeSaveVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 保存附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Transactional
    public void saveBasFileType(BasFileTypeSaveVo basFileTypeSaveVo) {
        if(basFileTypeSaveVo.getFileType()==null){
            basFileTypeSaveVo.setFileType(UUIDUtils.getUUID());
        }
        basFileTypeRepository.insertData(basFileTypeSaveVo.getEntity());
        if(ArrayUtils.isNotNullAndLengthNotZero(basFileTypeSaveVo.getChiBasFiles())){
            List<BasFileGroup> basFileGroupList = new ArrayList<>();
            for(BasFileTypeVo basFileTypeVo:basFileTypeSaveVo.getChiBasFiles()){
                BasFileGroup basFileGroup = new BasFileGroup();
                basFileGroup.setFileTypePar(basFileTypeSaveVo.getFileType());
                basFileGroup.setFileTypeChi(basFileTypeVo.getFileType());
                basFileGroupList.add(basFileGroup);
            }
            basFileGroupRepository.insertDataList(basFileGroupList);
        }

    }

    /**
     * @param basFileTypeModifyVo
     * @return
     * @throws
     * @Title:
     * @Description: 修改附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Transactional
    public void modifyBasFileType(BasFileTypeModifyVo basFileTypeModifyVo) {
        Example example  = SqlUtil.newExample(BasFileGroup.class);
        example.createCriteria().andEqualTo("fileTypePar",basFileTypeModifyVo.getFileType());
        basFileGroupRepository.deleteExampleData(example,new BasFileGroup());
        basFileTypeRepository.updateByPrimaryKeySelectiveData(basFileTypeModifyVo.getEntity());
        if(ArrayUtils.isNotNullAndLengthNotZero(basFileTypeModifyVo.getChiBasFiles())){
            List<BasFileGroup> basFileGroupList = new ArrayList<>();
            for(BasFileTypeVo basFileTypeVo:basFileTypeModifyVo.getChiBasFiles()){
                BasFileGroup basFileGroup = new BasFileGroup();
                basFileGroup.setFileTypePar(basFileTypeModifyVo.getFileType());
                basFileGroup.setFileTypeChi(basFileTypeVo.getFileType());
                basFileGroupList.add(basFileGroup);
            }
            basFileGroupRepository.insertDataList(basFileGroupList);
        }
    }

    /**
     * @param basFileTypeDeleteVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过fileTypeId删除附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public void deleteBasFileType(BasFileTypeDeleteVo basFileTypeDeleteVo) {
        basFileTypeRepository.deleteData(basFileTypeDeleteVo.getEntity());
    }

    /**
     * @param basFileTypeDeleteListVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过fileTypeId集合删除附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @Transactional
    public String deleteBasFileTypesByFileTypeIds(BasFileTypeDeleteListVo basFileTypeDeleteListVo) {

       //得到附件类型ID集合
        List<String> fileTypeIds = basFileTypeDeleteListVo.getFileTypeIds();
        List<String> deleteFileTypeIds = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(fileTypeIds)){
            for(String fileTypeId : fileTypeIds){
                //遍历集合并通过id调用findBasFileTypeByFileTypeId()方法查询对应的basFileType表
                BasFileType basFileType = findBasFileTypeByFileTypeId(fileTypeId);
                //把当前id对应的类型表的类型代码作为父节点类型代码查找是否有下一级节点
                List<BasFileTypeVo> nextBasFileTypes = findNextBasFileTypeVosByParentFileType(basFileType.getFileType());
                if(ArrayUtils.isNotNullAndLengthNotZero(nextBasFileTypes)){
                    for(BasFileTypeVo nextBasFileTypeVo : nextBasFileTypes){
                        if(nextBasFileTypeVo == null){ //无子节点
                            deleteFileTypeIds.add(fileTypeId);
                        }else{
                            throw new FmsServiceException("存在子附件类型，删除失败");
                        }
                    }
                }else{
                    deleteFileTypeIds.add(fileTypeId);
                }
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(deleteFileTypeIds)){
            basFileTypeDeleteListVo.setFileTypeIds(fileTypeIds);
            basFileTypeRepository.deleteDataList(basFileTypeDeleteListVo.getFileTypeIds(), basFileTypeDeleteListVo.getEntity());
            Example example = SqlUtil.newExample(BasFileGroup.class);
            example.createCriteria().andIn("fileTypePar",deleteFileTypeIds).andIn("fileTypeChi",deleteFileTypeIds);
            basFileGroupRepository.deleteExampleData(example,new BasFileGroup());

        }
        return "删除成功";
    }

    /**
     * @param fileTypeId
     * @return BasFileType
     * @throws
     * @Title:
     * @Description: 根据fileTypeId获取附件类型管理表
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    public BasFileType findBasFileTypeByFileTypeId(String fileTypeId) {
        return basFileTypeRepository.selectByPrimaryKey(fileTypeId);
    }

    /**
     * @Title:
     * @Description: 查询附件类型管理树
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public List<BootstrapTreeViewNodeVo> findBasFileTypeByTree() {
        List<BasFileTypeVo> basFileTypeVoList = basFileTypeRepository.selectBasFileTypeByTree();
        List<BootstrapTreeViewNodeVo> nodes = CommonTreeDataUtils.getTrees(basFileTypeVoList);
        return nodes;
    }

    /**
     * @Title:
     * @Description: 通过上级类型代码获得下一级子节点集合
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public List<BasFileTypeVo> findNextBasFileTypeVosByParentFileType(String parentFileType){
        if (StringUtils.isTrimBlank(parentFileType))
            parentFileType = null;
        return basFileTypeRepository.selectNextBasFileTypeVosByParentFileType(parentFileType);
    }


    /**
     * @Title:
     * @Description: 根据fileTypeId获取BasFileTypeVo，画面详情显示
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-30 13:51:12
     */
    public BasFileTypeVo findBasFileTypeVoByFileTypeId(String fileTypeId) {
        if (StringUtils.isTrimBlank(fileTypeId))
            fileTypeId = null;
        BasFileTypeVo basFileTypeVo =  basFileTypeRepository.selectBasFileTypeVoByPrimaryKey(fileTypeId);
        //查找当前附件的下一级子类附件
        basFileTypeVo.setChiBasFiles(basFileGroupRepository.selectBasFileTypeChiByFileType(basFileTypeVo.getFileType()));
        return basFileTypeVo;
    }
    

    /**
     * @Title:
     * @Description: 根据fileType获取附件类型,唯一性判断
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public BasFileType findBasFileTypeByFileType(String fileType) {
        Example example = SqlUtil.newExample(BasFileType.class);
        example.createCriteria().andEqualTo("fileType", fileType);
        return basFileTypeRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型树
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @Title:
     * @author qiaomengnan
     * @date 2018-3-19 12:02:58
     */
    @Override
    public BootstrapTreeViewNodeVo findFileTypeTree(String fileType, String product, String subType){
        List<BasFileType> basFileTypeList = basFileTypeRepository.selectAllBasFileTypeList();

        BootstrapTreeViewNodeVo viewNodeVo = CommonTreeDataUtils.getTrees(basFileTypeList, fileType);
        viewNodeVo.setLastNodes(CommonTreeDataUtils.getLastNodes(viewNodeVo));
        // 产品方案存在的场合，获取产品的文件类型
        if (StringUtils.isNotTrimBlank(product)) {
            // 根据产品方案取得对应的附件类型
            List<BasFileTypeVo> basFileTypeVoList =  findBasFileTypeVosByProduct(product);
            if (ArrayUtils.isNotNullAndLengthNotZero(basFileTypeVoList)) {
                for (BasFileTypeVo basFileTypeVo : basFileTypeVoList) {
                    BootstrapTreeViewNodeVo nodeVo = new BootstrapTreeViewNodeVo();
                    nodeVo.setId(basFileTypeVo.getFileType());
                    nodeVo.setText(basFileTypeVo.getFileTypeName());
                    nodeVo.setAttributes(JSON.parseObject(JSON.toJSONString(basFileTypeVo)));
                    if (viewNodeVo.getNodes() != null) {
                        viewNodeVo.getNodes().add(nodeVo);
                    } else {
                        List<BootstrapTreeViewNodeVo> list = new ArrayList<>();
                        list.add(nodeVo);
                        viewNodeVo.setNodes(list);
                    }
                }
            }
        }
        //如果显示区分不包含，则不显示
        if(ArrayUtils.isNotNullAndLengthNotZero(viewNodeVo.getNodes())){
        for(int i= viewNodeVo.getNodes().size()-1; i>=0; i-- ){
            BootstrapTreeViewNodeVo viewNodeVoChild = viewNodeVo.getNodes().get(i);
            if(StringUtils.isNotTrimBlank(subType)){
                if(StringUtils.isNotTrimBlank(viewNodeVoChild.getAttributes().get("subType"))){
                    String subTypeCheck = viewNodeVoChild.getAttributes().get("subType").toString();
                    if(!StringUtils.splitCommaToList(subTypeCheck).contains(subType)){
                        viewNodeVo.getNodes().remove(i);
                    }
                }
            }
        }
        }
        return viewNodeVo;
    }

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型
     * @param fileType
     * @return List<String>
     * @throws
     * @Title:
     * @Description: 分页查询附件类型管理表
     * @author ningyangyang
     * @date 2018-10-30 12:02:58
     */
    @Override
    public List<BasFileType> getChildFileTypes(String fileType){
        List<BasFileTypeVo> basFileTypeVoList = basFileTypeRepository.selectBasFileTypeByTree();
        List<BasFileType> basFileTypeList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(basFileTypeVoList)){
            for(BasFileTypeVo basFileTypeVo:basFileTypeVoList){
                basFileTypeList.add(EntityUtils.getEntity(basFileTypeVo,new BasFileType()));
            }
        }
        return CommonTreeDataUtils.getChildResults(basFileTypeList, fileType);
    }

    /**
     * @Title:
     * @Description: 根据product获取附件类型Vo
     * @param product 产品方案代码
     * @return List<BasFileTypeVo>
     * @throws
     * @author wangxue
     * @date 2018-4-26 12:02:58
     */
    @Override
    public List<BasFileTypeVo> findBasFileTypeVosByProduct(String product) {
        return basFileTypeRepository.selectBasFileTypeVoByProduct(product);
    }
}



