package cn.com.leadu.fms.data.insurance.repository;

import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimRepository
 * @Description: 保险理赔Repository层
 * @date 2018-05-14
 */
public interface ContInsurClaimRepository {

	/**
	 * @Title:
	 * @Description: 新增保险理赔
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int insertData(ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 批量保存保险理赔
	 * @param contInsurClaims
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int insertDataList(List<ContInsurClaim> contInsurClaims);

	/**
	 * @Title:
	 * @Description: 修改保险理赔
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByPrimaryKeyData(ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 批量修改保险理赔
	 * @param contInsurClaims
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByPrimaryKeyDataList(List<ContInsurClaim> contInsurClaims);

	/**
	 * @Title:
	 * @Description: 动态修改保险理赔
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByPrimaryKeySelectiveData(ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 批量动态修改保险理赔
	 * @param contInsurClaims
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContInsurClaim> contInsurClaims);

	/**
	 * @Title:
	 * @Description: 根据条件修改保险理赔
	 * @param contInsurClaim
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByExampleData(ContInsurClaim contInsurClaim, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改保险理赔
	 * @param contInsurClaim
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int updateByExampleSelectiveData(ContInsurClaim contInsurClaim, Example example);

	/**
	 * @Title:
	 * @Description: 根据contInsurClaimId删除保险理赔
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int deleteData(ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 根据contInsurClaimId集合批量删除保险理赔
	 * @param contInsurClaimIds
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int deleteDataList(List contInsurClaimIds,ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除保险理赔
	 * @param example
	 * @param contInsurClaim
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	int deleteExampleData(Example example,ContInsurClaim contInsurClaim);

	/**
	 * @Title:
	 * @Description: 查询全部保险理赔
	 * @return List<ContInsurClaim>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	List<ContInsurClaim> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个保险理赔
	 * @param example
	 * @return ContInsurClaim
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	ContInsurClaim selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询保险理赔
	 * @param example
	 * @return List<ContInsurClaim>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	List<ContInsurClaim> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contInsurClaimId查询保险理赔
	 * @param contInsurClaimId
	 * @return ContInsurClaim
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	ContInsurClaim selectByPrimaryKey(Object contInsurClaimId);

	/**
	 * @Title:
	 * @Description: 分页查询保险理赔
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContInsurClaim>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	PageInfoExtend<ContInsurClaim> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询保险理赔vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-14 10:35:21
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据保险信息id查询合同车辆保险信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public ContInsurClaimVo selectContInsuranceByContVehinsId(String contVehinsId);

	/**
	 * @Title:
	 * @Description: 根据contInsurClaimId和contVehinsId查询保险理赔表和合同车辆信息表
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public ContInsurClaimVo selectContInsurClaimAndContInsurance(String contInsurClaimId,String contVehinsId);

    /**
     * @Title:
     * @Description: 保险理赔状态为退回时查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    ContInsurClaimVo selectDetailedByReturn(String contInsurClaimId);

	/**
	 * @Title:
	 * @Description: 根据保险理赔任务号和业务类型查询财务付款表
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public ContPay selectContPayByContInsurClaimNo(String bizCode,String paymentType);

}
