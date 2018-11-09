package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailRepository
 * @Description: 融资费用明细信息Repository层
 * @date 2018-03-24
 */
public interface ApplyFinDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增融资费用明细信息
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int insertData(ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 批量保存融资费用明细信息
	 * @param applyFinDetails
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int insertDataList(List<ApplyFinDetail> applyFinDetails);

	/**
	 * @Title:
	 * @Description: 修改融资费用明细信息
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByPrimaryKeyData(ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 批量修改融资费用明细信息
	 * @param applyFinDetails
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByPrimaryKeyDataList(List<ApplyFinDetail> applyFinDetails);

	/**
	 * @Title:
	 * @Description: 动态修改融资费用明细信息
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByPrimaryKeySelectiveData(ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资费用明细信息
	 * @param applyFinDetails
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByPrimaryKeySelectiveDataList(List<ApplyFinDetail> applyFinDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资费用明细信息
	 * @param applyFinDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByExampleData(ApplyFinDetail applyFinDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资费用明细信息
	 * @param applyFinDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int updateByExampleSelectiveData(ApplyFinDetail applyFinDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据applyFinDetailId删除融资费用明细信息
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int deleteData(ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 根据applyFinDetailId集合批量删除融资费用明细信息
	 * @param applyFinDetailIds
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int deleteDataList(List applyFinDetailIds, ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 根据条件删除融资费用明细信息
	 * @param example
	 * @param applyFinDetail
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int deleteByExample(Example example, ApplyFinDetail applyFinDetail);

	/**
	 * @Title:
	 * @Description: 根据applyFinDetailId集合批量删除融资费用明细信息 物理删除
	 * @param applyFinDetailIds
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	int deletePhysicsEntityList(List applyFinDetailIds);

	/**
	 * @Title:
	 * @Description: 查询全部融资费用明细信息
	 * @return List<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	List<ApplyFinDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资费用明细信息
	 * @param example
	 * @return ApplyFinDetail
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	ApplyFinDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资费用明细信息
	 * @param example
	 * @return List<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	List<ApplyFinDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过applyFinDetailId查询融资费用明细信息
	 * @param applyFinDetailId
	 * @return ApplyFinDetail
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	ApplyFinDetail selectByPrimaryKey(Object applyFinDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询融资费用明细信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	PageInfoExtend<ApplyFinDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资费用明细信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ApplyFinDetail>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-24 14:22:32
	 */
	PageInfoExtend<ApplyFinDetail> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据订单编号 获取融资费用明细信息
	 * @param applyNo 订单编号
	 * @return List<ApplyFinDetailVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-29 17:39:58
	 */
	List<ApplyFinDetailVo> selectApplyFinDetailVosByApplyNo(String applyNo);

}
