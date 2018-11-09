package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BrandStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BusinessStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.RegionStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsListVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.system.vo.desk.DeskSearchVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContractRepository
 * @Description: 合同信息Repository层
 * @date 2018-06-11
 */
public interface ContractRepository {

	/**
	 * @Title:
	 * @Description: 新增合同信息
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int insertData(Contract contract);

	/**
	 * @Title:
	 * @Description: 批量保存合同信息
	 * @param contracts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int insertDataList(List<Contract> contracts);

	/**
	 * @Title:
	 * @Description: 修改合同信息
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeyData(Contract contract);

	/**
	 * @Title:
	 * @Description: 批量修改合同信息
	 * @param contracts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeyDataList(List<Contract> contracts);

	/**
	 * @Title:
	 * @Description: 动态修改合同信息
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeySelectiveData(Contract contract);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同信息
	 * @param contracts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<Contract> contracts);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同信息
	 * @param contract
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByExampleData(Contract contract, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同信息
	 * @param contract
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByExampleSelectiveData(Contract contract, Example example);

	/**
	 * @Title:
	 * @Description: 根据contractId删除合同信息
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int deleteData(Contract contract);

	/**
	 * @Title:
	 * @Description: 根据contractId集合批量删除合同信息
	 * @param contractIds
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int deleteDataList(List contractIds,Contract contract);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除合同信息
	 * @param example
	 * @param contract
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int deleteExampleData(Example example,Contract contract);

	/**
	 * @Title:
	 * @Description: 查询全部合同信息
	 * @return List<Contract>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	List<Contract> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个合同信息
	 * @param example
	 * @return Contract
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	Contract selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询合同信息
	 * @param example
	 * @return List<Contract>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	List<Contract> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contractId查询合同信息
	 * @param contractId
	 * @return Contract
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	Contract selectByPrimaryKey(Object contractId);

	/**
	 * @Title:
	 * @Description: 分页查询合同信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<Contract>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	PageInfoExtend<Contract> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改合同信息
	 * @param contract,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeyData(Contract contract,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改合同信息,并进行排他
	 * @param contracts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeyDataList(List<Contract> contracts,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改合同信息,并进行排他
	 * @param contract
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(Contract contract,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同信息,并进行排他
	 * @param contracts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<Contract> contracts,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同信息,并进行排他
	 * @param contract
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByExampleData(Contract contract, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同信息,并进行排他
	 * @param contract
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-11 20:12:27
	 */
	int updateByExampleSelectiveData(Contract contract, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据contNo获取合同信息
	 * @param contNo
	 * @return ContCreateVo
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	ContCreateVo selectContCreateDetailByContNo(String contNo);
	/**
	 * @Title:
	 * @Description: 根据contNo获取合同信息
	 * @param contNo
	 * @return ContCreateVo
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:48:00
	 */
	ContractVo selectContractVoByContractNo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据申请编号,查询申请合同相关的财务核算代码
	 * @param:  contractVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/6/30 0030 15:52
	 */
	ContractVo selectContractVoFinassCodes(ContractVo contractVo);

	/**
	* @Description: 自动程序更新合同结清状态
	* @param: uncleared 未结清状态
	* @param: contractEffect 合同生效清状态
	* @param: withdrawingSuccess 扣款成功状态
	* @param: automaticClearing 自动结清状态
	* @return:
	* @Author: yangyiquan
	* @Date: 2018/9/13 17:27
	*/
	int updateAutomaticClearing(String uncleared,String contractEffect,String withdrawingSuccess,String automaticClearing);

	/**
	 * @Title:
	 * @Description:   查询当月提报数据统计报表明细
	 * @param reportStatisticsListVo
	 * @return
	 * @throws
	 * @author fangshaofeng
	 * @date 2018/09/30 09:57:48
	 */
	List<ReportStatisticsListVo> selectReportStatisticsListVos(ReportStatisticsListVo reportStatisticsListVo);

	/**
	 * @Title:
	 * @Description: 查询融资租赁业务统计报表
	 * @param regionStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-08 16:38:16
	 */
	List<RegionStatisticsVo> selectRegionStatisticsListVos(RegionStatisticsVo regionStatisticsVo);

	/**
	 * @Title:
	 * @Description: 查询融资租赁业务品牌统计报表
	 * @param brandStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-09 15:38:16
	 */
	List<BrandStatisticsVo> selectBrandStatisticsListVos(BrandStatisticsVo brandStatisticsVo);

	/**
	 * @Title:
	 * @Description: 查询融资租赁业务统计报表
	 * @param businessStatisticsVo
	 * @return
	 * @throws
	 * @date 2018-10-10 16:38:16
	 */
	List<BusinessStatisticsVo> selectBusinessStatisticsListVos(BusinessStatisticsVo businessStatisticsVo);

	/**
	 * @Description: 首页工作台查询待请款合同数量
	 * @param:
	 * @return:
	 * @Author: huzongcheng
	 * @param
	 */
	Long selectRequestCount(DeskSearchVo deskSearchVo);

	/**
	 * @Description: 首页工作台查询待放款合同数量
	 * @param:
	 * @return:
	 * @Author: huzongcheng
	 * @param
	 */
	Long selectLoanCount(DeskSearchVo deskSearchVo);

	/**
	 * @Description: 首页工作台查询待归档合同数量
	 * @param:
	 * @return:
	 * @Author: huzongcheng
	 * @param
	 */
	Long selectOriginCount(DeskSearchVo deskSearchVo);

}
