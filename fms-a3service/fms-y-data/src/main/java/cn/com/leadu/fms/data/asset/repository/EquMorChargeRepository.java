package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquMorCharge;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmorapply.EquMorApplyVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorChargeRepository
 * @Description: 资方抵押费用Repository层
 * @date 2018-05-30
 */
public interface EquMorChargeRepository {

	/**
	 * @Title:
	 * @Description: 新增资方抵押费用
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int insertData(EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 批量保存资方抵押费用
	 * @param equMorCharges
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int insertDataList(List<EquMorCharge> equMorCharges);

	/**
	 * @Title:
	 * @Description: 修改资方抵押费用
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeyData(EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押费用
	 * @param equMorCharges
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeyDataList(List<EquMorCharge> equMorCharges);

	/**
	 * @Title:
	 * @Description: 动态修改资方抵押费用
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeySelectiveData(EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押费用
	 * @param equMorCharges
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorCharge> equMorCharges);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押费用
	 * @param equMorCharge
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByExampleData(EquMorCharge equMorCharge, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押费用
	 * @param equMorCharge
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByExampleSelectiveData(EquMorCharge equMorCharge, Example example);

	/**
	 * @Title:
	 * @Description: 根据equMorChargeId删除资方抵押费用
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int deleteData(EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 根据equMorChargeId集合批量删除资方抵押费用
	 * @param equMorChargeIds
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int deleteDataList(List equMorChargeIds, EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方抵押费用
	 * @param example
	 * @param equMorCharge
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int deleteExampleData(Example example, EquMorCharge equMorCharge);

	/**
	 * @Title:
	 * @Description: 查询全部资方抵押费用
	 * @return List<EquMorCharge>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	List<EquMorCharge> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方抵押费用
	 * @param example
	 * @return EquMorCharge
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	EquMorCharge selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方抵押费用
	 * @param example
	 * @return List<EquMorCharge>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	List<EquMorCharge> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equMorChargeId查询资方抵押费用
	 * @param equMorChargeId
	 * @return EquMorCharge
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	EquMorCharge selectByPrimaryKey(Object equMorChargeId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押费用
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquMorCharge>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	PageInfoExtend<EquMorCharge> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押费用vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方抵押费用
	 * @param equMorCharge,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeyData(EquMorCharge equMorCharge, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押费用,并进行排他
	 * @param equMorCharges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeyDataList(List<EquMorCharge> equMorCharges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方抵押费用,并进行排他
	 * @param equMorCharge
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquMorCharge equMorCharge, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押费用,并进行排他
	 * @param equMorCharges
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorCharge> equMorCharges, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押费用,并进行排他
	 * @param equMorCharge
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByExampleData(EquMorCharge equMorCharge, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押费用,并进行排他
	 * @param equMorCharge
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:14
	 */
	int updateByExampleSelectiveData(EquMorCharge equMorCharge, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 查询资方抵押申请合同详情
	 * @param equMorApplyVo
	 * @return  List<EquMorChargeApplyVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/30 05:35:28
	 */
	EquMorApplyVo selectEquMorApplyVoByContNo(EquMorApplyVo equMorApplyVo);

	/**
	 * @Title:
	 * @Description: 查询资方抵押申请合同详情列表
	 * @param equMorApplyVo
	 * @return  List<EquMorChargeApplyVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/30 05:35:28
	 */
	List<EquMorApplyVo> selectEquMorApplyVosByContNos(EquMorApplyVo equMorApplyVo);

	/**
	 * @Title:
	 * @Description: 查询资方抵押申请模板下载详情
	 * @param equMorApplyVo
	 * @return  List<EquMorApplyVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/30 05:35:28
	 */
	List<EquMorApplyVo> selectExportEquMorApplyVos(EquMorApplyVo equMorApplyVo);

	/**
	 * @Title:
	 * @Description: 查询资方抵押申请合同列表
	 * @param equMorApplyVo
	 * @return  List<equMorChargeApplyVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/30 05:35:28
	 */
	List<EquMorApplyVo> selectEquMorApplyVos(EquMorApplyVo equMorApplyVo);

}
