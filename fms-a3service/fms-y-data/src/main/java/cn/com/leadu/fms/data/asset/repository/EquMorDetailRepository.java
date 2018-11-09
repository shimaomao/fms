package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.EquMorDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquMorDetailRepository
 * @Description: 资方抵押明细Repository层
 * @date 2018-05-30
 */
public interface EquMorDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增资方抵押明细
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int insertData(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 批量保存资方抵押明细
	 * @param equMorDetails
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int insertDataList(List<EquMorDetail> equMorDetails);

	/**
	 * @Title:
	 * @Description: 修改资方抵押明细
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeyData(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押明细
	 * @param equMorDetails
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeyDataList(List<EquMorDetail> equMorDetails);

	/**
	 * @Title:
	 * @Description: 动态修改资方抵押明细
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeySelectiveData(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押明细
	 * @param equMorDetails
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorDetail> equMorDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押明细
	 * @param equMorDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByExampleData(EquMorDetail equMorDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押明细
	 * @param equMorDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByExampleSelectiveData(EquMorDetail equMorDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据equMorDetailId删除资方抵押明细
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int deleteData(EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 根据equMorDetailId集合批量删除资方抵押明细
	 * @param equMorDetailIds
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int deleteDataList(List equMorDetailIds, EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资方抵押明细
	 * @param example
	 * @param equMorDetail
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int deleteExampleData(Example example, EquMorDetail equMorDetail);

	/**
	 * @Title:
	 * @Description: 查询全部资方抵押明细
	 * @return List<EquMorDetail>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	List<EquMorDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资方抵押明细
	 * @param example
	 * @return EquMorDetail
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	EquMorDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资方抵押明细
	 * @param example
	 * @return List<EquMorDetail>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	List<EquMorDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过equMorDetailId查询资方抵押明细
	 * @param equMorDetailId
	 * @return EquMorDetail
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	EquMorDetail selectByPrimaryKey(Object equMorDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<EquMorDetail>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	PageInfoExtend<EquMorDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资方抵押明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改资方抵押明细
	 * @param equMorDetail,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeyData(EquMorDetail equMorDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改资方抵押明细,并进行排他
	 * @param equMorDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeyDataList(List<EquMorDetail> equMorDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改资方抵押明细,并进行排他
	 * @param equMorDetail
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(EquMorDetail equMorDetail, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改资方抵押明细,并进行排他
	 * @param equMorDetails
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByPrimaryKeySelectiveDataList(List<EquMorDetail> equMorDetails, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改资方抵押明细,并进行排他
	 * @param equMorDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByExampleData(EquMorDetail equMorDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资方抵押明细,并进行排他
	 * @param equMorDetail
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 17:02:05
	 */
	int updateByExampleSelectiveData(EquMorDetail equMorDetail, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据ids查询所有明细(申请)
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:05
	 */
	List<EquMorDetailVo> selectEquMorDetailVos(EquMorDetailVo equMorDetailVo);

	/**
	 * @Title:
	 * @Description: 根据ids查询所有明细(复审)
	 * @param equMorDetailVo
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-30 17:02:05
	 */
	List<EquMorDetailVo> selectEquMorDetailVoList(EquMorDetailVo equMorDetailVo);

	/**
	 * @Title:
	 * @Description:   抵押任务明细
	 * @param bizCodeType   归档借阅类型
	 * @param equMorTaskNo      抵押任务号
	 * @param applyTypePerson 个人申请类型
	 * @param totalFlag 费用合计类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/08 11:52:41
	 */
	List<EquMorDetailVo> selectEquMorDetailVosByEquMorTaskNo(String bizCodeType,String equMorTaskNo ,String applyTypePerson,String totalFlag);

}
