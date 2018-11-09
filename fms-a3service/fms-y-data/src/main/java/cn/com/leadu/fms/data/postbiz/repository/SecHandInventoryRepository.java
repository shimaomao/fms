package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: SecHandInventoryRepository
 * @Description: 二手车库存Repository层
 */
public interface SecHandInventoryRepository {

	/**
	 * @Title:
	 * @Description: 新增二手车库存
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int insertData(SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 批量保存二手车库存
	 * @param secHandInventorys
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int insertDataList(List<SecHandInventory> secHandInventorys);

	/**
	 * @Title:
	 * @Description: 修改二手车库存
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeyData(SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 批量修改二手车库存
	 * @param secHandInventorys
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeyDataList(List<SecHandInventory> secHandInventorys);

	/**
	 * @Title:
	 * @Description: 动态修改二手车库存
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeySelectiveData(SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 批量动态修改二手车库存
	 * @param secHandInventorys
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeySelectiveDataList(List<SecHandInventory> secHandInventorys);

	/**
	 * @Title:
	 * @Description: 根据条件修改二手车库存
	 * @param secHandInventory
	 * @param example
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByExampleData(SecHandInventory secHandInventory, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改二手车库存
	 * @param secHandInventory
	 * @param example
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByExampleSelectiveData(SecHandInventory secHandInventory, Example example);

	/**
	 * @Title:
	 * @Description: 根据secHandId删除二手车库存
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int deleteData(SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 根据secHandId集合批量删除二手车库存
	 * @param secHandIds
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int deleteDataList(List secHandIds, SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除二手车库存
	 * @param example
	 * @param secHandInventory
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int deleteExampleData(Example example, SecHandInventory secHandInventory);

	/**
	 * @Title:
	 * @Description: 查询全部二手车库存
	 * @return List<SecHandInventory>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	List<SecHandInventory> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个二手车库存
	 * @param example
	 * @return SecHandInventory
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	SecHandInventory selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询二手车库存
	 * @param example
	 * @return List<SecHandInventory>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	List<SecHandInventory> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过secHandId查询二手车库存
	 * @param secHandId
	 * @return SecHandInventory
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	SecHandInventory selectByPrimaryKey(Object secHandId);

	/**
	 * @Title:
	 * @Description: 分页查询二手车库存
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SecHandInventory>
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	PageInfoExtend<SecHandInventory> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询二手车库存vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改二手车库存
	 * @param secHandInventory,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeyData(SecHandInventory secHandInventory, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改二手车库存,并进行排他
	 * @param secHandInventorys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeyDataList(List<SecHandInventory> secHandInventorys, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改二手车库存,并进行排他
	 * @param secHandInventory
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(SecHandInventory secHandInventory, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改二手车库存,并进行排他
	 * @param secHandInventorys
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByPrimaryKeySelectiveDataList(List<SecHandInventory> secHandInventorys, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改二手车库存,并进行排他
	 * @param secHandInventory
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByExampleData(SecHandInventory secHandInventory, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改二手车库存,并进行排他
	 * @param secHandInventory
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author huzongcheng
	 * @date 2018-9-13 15:06:42
	 */
	int updateByExampleSelectiveData(SecHandInventory secHandInventory, Example example, boolean exclusive);

}
