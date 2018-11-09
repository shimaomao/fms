package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseRepository
 * @Description: 购买合理性Repository层
 * @date 2018-05-29
 */
public interface RationalityPurchaseRepository {

	/**
	 * @Title:
	 * @Description: 新增购买合理性
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int insertData(RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 批量保存购买合理性
	 * @param rationalityPurchases
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int insertDataList(List<RationalityPurchase> rationalityPurchases);

	/**
	 * @Title:
	 * @Description: 修改购买合理性
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByPrimaryKeyData(RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 批量修改购买合理性
	 * @param rationalityPurchases
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByPrimaryKeyDataList(List<RationalityPurchase> rationalityPurchases);

	/**
	 * @Title:
	 * @Description: 动态修改购买合理性
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByPrimaryKeySelectiveData(RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 批量动态修改购买合理性
	 * @param rationalityPurchases
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<RationalityPurchase> rationalityPurchases);

	/**
	 * @Title:
	 * @Description: 根据条件修改购买合理性
	 * @param rationalityPurchase
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByExampleData(RationalityPurchase rationalityPurchase, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改购买合理性
	 * @param rationalityPurchase
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int updateByExampleSelectiveData(RationalityPurchase rationalityPurchase, Example example);

	/**
	 * @Title:
	 * @Description: 根据buyCarId删除购买合理性
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int deleteData(RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 根据buyCarId集合批量删除购买合理性
	 * @param buyCarIds
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int deleteDataList(List buyCarIds, RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除购买合理性
	 * @param example
	 * @param rationalityPurchase
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	int deleteExampleData(Example example, RationalityPurchase rationalityPurchase);

	/**
	 * @Title:
	 * @Description: 查询全部购买合理性
	 * @return List<RationalityPurchase>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	List<RationalityPurchase> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个购买合理性
	 * @param example
	 * @return RationalityPurchase
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	RationalityPurchase selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询购买合理性
	 * @param example
	 * @return List<RationalityPurchase>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	List<RationalityPurchase> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过buyCarId查询购买合理性
	 * @param buyCarId
	 * @return RationalityPurchase
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	RationalityPurchase selectByPrimaryKey(Object buyCarId);

	/**
	 * @Title:
	 * @Description: 分页查询购买合理性
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RationalityPurchase>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	PageInfoExtend<RationalityPurchase> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询购买合理性vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-29 9:52:53
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
