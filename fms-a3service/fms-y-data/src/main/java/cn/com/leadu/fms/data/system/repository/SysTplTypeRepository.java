package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeRepository
 * @Description: 模板类型管理Repository层
 * @date 2018-03-12
 */
public interface SysTplTypeRepository {

	/**
	 * @Title:
	 * @Description: 新增模板类型管理
	 * @param sysTplType
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int insertData(SysTplType sysTplType);

	/**
	 * @Title:
	 * @Description: 批量保存模板类型管理
	 * @param sysTplTypes
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int insertDataList(List<SysTplType> sysTplTypes);

	/**
	 * @Title:
	 * @Description: 修改模板类型管理
	 * @param sysTplType
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByPrimaryKeyData(SysTplType sysTplType);

	/**
	 * @Title:
	 * @Description: 批量修改模板类型管理
	 * @param sysTplTypes
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByPrimaryKeyDataList(List<SysTplType> sysTplTypes);

	/**
	 * @Title:
	 * @Description: 动态修改模板类型管理
	 * @param sysTplType
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByPrimaryKeySelectiveData(SysTplType sysTplType);

	/**
	 * @Title:
	 * @Description: 批量动态修改模板类型管理
	 * @param sysTplTypes
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysTplType> sysTplTypes);

	/**
	 * @Title:
	 * @Description: 根据条件修改模板类型管理
	 * @param sysTplType
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByExampleData(SysTplType sysTplType, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改模板类型管理
	 * @param sysTplType
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int updateByExampleSelectiveData(SysTplType sysTplType, Example example);

	/**
	 * @Title:
	 * @Description: 根据tplTypeId删除模板类型管理
	 * @param sysTplType
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int deleteData(SysTplType sysTplType);

	/**
	 * @Title:
	 * @Description: 根据tplTypeId集合批量删除模板类型管理
	 * @param tplTypeIds
	 * @param sysTplType
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	int deleteDataList(List tplTypeIds, SysTplType sysTplType);

	/**
	 * @Title:
	 * @Description: 查询全部模板类型管理
	 * @return List<SysTplType>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	List<SysTplType> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个模板类型管理
	 * @param example
	 * @return SysTplType
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	SysTplType selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询模板类型管理
	 * @param example
	 * @return List<SysTplType>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	List<SysTplType> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过tplTypeId查询模板类型管理
	 * @param tplTypeId
	 * @return SysTplType
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	SysTplType selectByPrimaryKey(Object tplTypeId);

	/**
	 * @Title:
	 * @Description: 分页查询模板类型管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysTplType>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	PageInfoExtend<SysTplType> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询模板类型管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysTplType>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	PageInfoExtend<SysTplType> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据模板类型ID集合,获取使用这些模板类型的模板的件数
	 * @param tplTypeIds 用户组Id
	 * @return Long
	 * @throws
	 * @author wangxue
	 * @date 2018-3-15 12:39:58
	 */
	Long selectSysTplCountByTplTypeIds(List<String> tplTypeIds);

	/**
	 * @Title:
	 * @Description: 根据模板类型ID集合,获取模板类型的可设置项目集合
	 * @param tplTypeIds 用户组Id
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-15 12:39:58
	 */
	List<String> selectSysTplItemIdsByTplTypeIds(List<String> tplTypeIds);

}
