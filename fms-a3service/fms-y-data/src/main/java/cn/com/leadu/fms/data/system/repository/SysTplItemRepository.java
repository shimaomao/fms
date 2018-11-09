package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemRepository
 * @Description: 模板可设项目管理Repository层
 * @date 2018-03-12
 */
public interface SysTplItemRepository {

	/**
	 * @Title:
	 * @Description: 新增模板可设项目管理
	 * @param sysTplItem
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int insertData(SysTplItem sysTplItem);

	/**
	 * @Title:
	 * @Description: 批量保存模板可设项目管理
	 * @param sysTplItems
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int insertDataList(List<SysTplItem> sysTplItems);

	/**
	 * @Title:
	 * @Description: 修改模板可设项目管理
	 * @param sysTplItem
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByPrimaryKeyData(SysTplItem sysTplItem);

	/**
	 * @Title:
	 * @Description: 批量修改模板可设项目管理
	 * @param sysTplItems
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByPrimaryKeyDataList(List<SysTplItem> sysTplItems);

	/**
	 * @Title:
	 * @Description: 动态修改模板可设项目管理
	 * @param sysTplItem
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByPrimaryKeySelectiveData(SysTplItem sysTplItem);

	/**
	 * @Title:
	 * @Description: 批量动态修改模板可设项目管理
	 * @param sysTplItems
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysTplItem> sysTplItems);

	/**
	 * @Title:
	 * @Description: 根据条件修改模板可设项目管理
	 * @param sysTplItem
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByExampleData(SysTplItem sysTplItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改模板可设项目管理
	 * @param sysTplItem
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int updateByExampleSelectiveData(SysTplItem sysTplItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据tplItemId删除模板可设项目管理
	 * @param sysTplItem
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int deleteData(SysTplItem sysTplItem);

	/**
	 * @Title:
	 * @Description: 根据tplItemId集合批量删除模板可设项目管理
	 * @param tplItemIds
	 * @param sysTplItem
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	int deleteDataList(List tplItemIds, SysTplItem sysTplItem);

	/**
	 * @Title:
	 * @Description: 查询全部模板可设项目管理
	 * @return List<SysTplItem>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	List<SysTplItem> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个模板可设项目管理
	 * @param example
	 * @return SysTplItem
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	SysTplItem selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询模板可设项目管理
	 * @param example
	 * @return List<SysTplItem>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	List<SysTplItem> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过tplItemId查询模板可设项目管理
	 * @param tplItemId
	 * @return SysTplItem
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	SysTplItem selectByPrimaryKey(Object tplItemId);

	/**
	 * @Title:
	 * @Description: 分页查询模板可设项目管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysTplItem>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	PageInfoExtend<SysTplItem> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询模板可设项目管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysTplItem>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:53:25
	 */
	PageInfoExtend<SysTplItem> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
