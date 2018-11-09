package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basfiletype.vo.BasFileTypeSaveVo;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeService
 * @Description: 附件类型管理表业务层
 * @date 2018-03-19
 */
public interface BasFileTypeService {

	/**
	 * @Title:
	 * @Description: 分页查询附件类型管理表
	 * @param basFileTypeVo
	 * @return PageInfoExtend<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	PageInfoExtend<BasFileType> findBasFileTypeByPage(BasFileTypeVo basFileTypeVo);

	/**
	 * @Title:
	 * @Description: 保存附件类型管理表
	 * @param basFileTypeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
    void saveBasFileType(BasFileTypeSaveVo basFileTypeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改附件类型管理表
	 * @param basFileTypeModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	void modifyBasFileType(BasFileTypeModifyVo basFileTypeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过fileTypeId删除附件类型管理表
	 * @param basFileTypeDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	void deleteBasFileType(BasFileTypeDeleteVo basFileTypeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过fileTypeId集合删除附件类型管理表
	 * @param basFileTypeDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	String deleteBasFileTypesByFileTypeIds(BasFileTypeDeleteListVo basFileTypeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据fileTypeId获取附件类型管理表
	 * @param fileTypeId
	 * @return BasFileType
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	BasFileType findBasFileTypeByFileTypeId(String fileTypeId);

	/**
	 * @Title:
	 * @Description: 查询附件类型管理树
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	List<BootstrapTreeViewNodeVo> findBasFileTypeByTree();

	/**
	 * @Title:
	 * @Description:  根据fileTypeId获取BasFileTypeVo
	 * @param fileTypeId
	 * @return BasFileType
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	BasFileTypeVo findBasFileTypeVoByFileTypeId(String fileTypeId);

	/**
	 * @Title:
	 * @Description:  根据fileType获取附件类型管理表
	 * @param fileType
	 * @return BasFileType
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	BasFileType findBasFileTypeByFileType(String fileType);

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型树
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @Title:
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    BootstrapTreeViewNodeVo findFileTypeTree(String fileType, String product, String subType);

    /**
	 * @Title:
	 * @Description:  根据fileType获取附件类型管理表
	 * @param fileType
	 * @return BasFileType
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-19 12:02:58
	 */
	List<BasFileType> getChildFileTypes(String fileType);

	/**
	 * @Title:
	 * @Description: 根据product获取附件类型Vo
	 * @param product 产品方案代码
	 * @return List<BasFileTypeVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-4-26 12:02:58
	 */
	List<BasFileTypeVo> findBasFileTypeVosByProduct(String product);
}
