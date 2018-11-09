package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileType;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeRepository
 * @Description: 附件类型管理表Repository层
 * @date 2018-03-19
 */
public interface BasFileTypeRepository {

	/**
	 * @Title:
	 * @Description: 新增附件类型管理表
	 * @param basFileType
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int insertData(BasFileType basFileType);

	/**
	 * @Title:
	 * @Description: 批量保存附件类型管理表
	 * @param basFileTypes
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int insertDataList(List<BasFileType> basFileTypes);

	/**
	 * @Title:
	 * @Description: 修改附件类型管理表
	 * @param basFileType
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByPrimaryKeyData(BasFileType basFileType);

	/**
	 * @Title:
	 * @Description: 批量修改附件类型管理表
	 * @param basFileTypes
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByPrimaryKeyDataList(List<BasFileType> basFileTypes);

	/**
	 * @Title:
	 * @Description: 动态修改附件类型管理表
	 * @param basFileType
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByPrimaryKeySelectiveData(BasFileType basFileType);

	/**
	 * @Title:
	 * @Description: 批量动态修改附件类型管理表
	 * @param basFileTypes
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasFileType> basFileTypes);

	/**
	 * @Title:
	 * @Description: 根据条件修改附件类型管理表
	 * @param basFileType
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByExampleData(BasFileType basFileType, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改附件类型管理表
	 * @param basFileType
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int updateByExampleSelectiveData(BasFileType basFileType, Example example);

	/**
	 * @Title:
	 * @Description: 根据fileTypeId删除附件类型管理表
	 * @param basFileType
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int deleteData(BasFileType basFileType);

	/**
	 * @Title:
	 * @Description: 根据fileTypeId集合批量删除附件类型管理表
	 * @param fileTypeIds
	 * @param basFileType
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	int deleteDataList(List fileTypeIds, BasFileType basFileType);

	/**
	 * @Title:
	 * @Description: 查询全部附件类型管理表
	 * @return List<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	List<BasFileType> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个附件类型管理表
	 * @param example
	 * @return BasFileType
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	BasFileType selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询附件类型管理表
	 * @param example
	 * @return List<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	List<BasFileType> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过fileTypeId查询附件类型管理表
	 * @param fileTypeId
	 * @return BasFileType
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	BasFileType selectByPrimaryKey(Object fileTypeId);


	/**
	 * @Title:
	 * @Description: 分页查询附件类型管理表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	PageInfoExtend<BasFileType> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询附件类型管理表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	PageInfoExtend<BasFileType> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);


	/**
	 * @Title:
	 * @Description: 查询附件类型管理树
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	public List<BasFileTypeVo> selectBasFileTypeByTree();

	/**
	 * @Title:
	 * @Description: 通过一个上级类型代码查询旗下所有层级节点的上级类型代码
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	public List<BasFileTypeVo> selectAllNodesFromBasFileType(String parentFileType);

	/**
	 * @Title:
	 * @Description: 通过上级类型代码获得下一级子节点集合
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	public List<BasFileTypeVo> selectNextBasFileTypeVosByParentFileType(String parentFileType);

	/**
	 * @Title:
	 * @Description: 根据fileTypeId获取BasFileTypeVo
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	BasFileTypeVo selectBasFileTypeVoByPrimaryKey(String fileTypeId);

	/**
	 * @Title:
	 * @Description: 分页查询附件类型管理表,del_flag 在外围
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasFileType>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-19 12:02:58
	 */
	PageInfoExtend<BasFileType> selectListByExamplePageForDel(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:  根据产品代码取得获取BasFileTypeVo
	 * @param product 产品代码
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-4-26 22:06:58
	 */
	List<BasFileTypeVo> selectBasFileTypeVoByProduct(String product);

	/**
	 * @Title:
	 * @Description:  取得获取所有BasFileType，并按照orderno进行排序
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-26 22:06:58
	 */
	List<BasFileType> selectAllBasFileTypeList();

}
