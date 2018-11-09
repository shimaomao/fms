package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.TransferInfo;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: TransferInfoRepository
 * @Description: 过户流程Repository层
 * @date 2018-08-30
 */
public interface TransferInfoRepository {

	/**
	 * @Title:
	 * @Description: 新增过户流程
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int insertData(TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 批量保存过户流程
	 * @param transferInfos
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int insertDataList(List<TransferInfo> transferInfos);

	/**
	 * @Title:
	 * @Description: 修改过户流程
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeyData(TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 批量修改过户流程
	 * @param transferInfos
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeyDataList(List<TransferInfo> transferInfos);

	/**
	 * @Title:
	 * @Description: 动态修改过户流程
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeySelectiveData(TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 批量动态修改过户流程
	 * @param transferInfos
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeySelectiveDataList(List<TransferInfo> transferInfos);

	/**
	 * @Title:
	 * @Description: 根据条件修改过户流程
	 * @param transferInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByExampleData(TransferInfo transferInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改过户流程
	 * @param transferInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByExampleSelectiveData(TransferInfo transferInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据transferId删除过户流程
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int deleteData(TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 根据transferId集合批量删除过户流程
	 * @param transferIds
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int deleteDataList(List transferIds, TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除过户流程
	 * @param example
	 * @param transferInfo
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int deleteExampleData(Example example, TransferInfo transferInfo);

	/**
	 * @Title:
	 * @Description: 查询全部过户流程
	 * @return List<TransferInfo>
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	List<TransferInfo> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个过户流程
	 * @param example
	 * @return TransferInfo
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	TransferInfo selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询过户流程
	 * @param example
	 * @return List<TransferInfo>
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	List<TransferInfo> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过transferId查询过户流程
	 * @param transferId
	 * @return TransferInfo
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	TransferInfo selectByPrimaryKey(Object transferId);

	/**
	 * @Title:
	 * @Description: 分页查询过户流程
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<TransferInfo>
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	PageInfoExtend<TransferInfo> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询过户流程vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改过户流程
	 * @param transferInfo,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeyData(TransferInfo transferInfo, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改过户流程,并进行排他
	 * @param transferInfos
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeyDataList(List<TransferInfo> transferInfos, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改过户流程,并进行排他
	 * @param transferInfo
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(TransferInfo transferInfo, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改过户流程,并进行排他
	 * @param transferInfos
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByPrimaryKeySelectiveDataList(List<TransferInfo> transferInfos, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改过户流程,并进行排他
	 * @param transferInfo
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByExampleData(TransferInfo transferInfo, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改过户流程,并进行排他
	 * @param transferInfo
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-8-30 15:15:01
	 */
	int updateByExampleSelectiveData(TransferInfo transferInfo, Example example, boolean exclusive);

	/**
	 * @Description: 根据合同编号 获取过户处理明细信息
	 * @param: contNo 合同编号
	 * @return: TransferDetailVo
	 * @Author: wangxue
	 * @Date: 2018/8/31 10:22
	 */
	TransferInfoVo selectTransferDetailByContNo(String contNo,String cancelMortgageStatus,String invalidMortgageStatus);

	/**
	 * @Description: 根据过户任务号 获取过户处理明细信息
	 * @param: transferNo 过户任务号
	 * @return: TransferInfoVo
	 * @Author: wangxue
	 * @Date: 2018/8/31 10:22
	 */
	TransferInfoVo selectTransferInfoVoByTransferNo(String transferNo,String cancelMortgageStatus,String invalidMortgageStatus);

	/**
	 * 获取确认书需要数据
	 * @param contNo
	 * @return
	 */
	TransferInfoLetterVo selectTransferInfoLetterVo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据合同号获取过户退保详情
	 * @param
	 * @return
	 * @throws
	 * @author fangshaofeng
	 * @date 2018-10-29 17:15:00
	 */
	List<TransferInfoRetreatsVo> findTransferInfoRetreatsByVo(TransferInfoRetreatsVo transferInfoRetreatsVo);

	/**
	 * @Title:
	 * @Description: 根据退保任务号查询过户退保信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	TransferInfoRetreatsVo selectTransferInfoRetreatVoByRetreatsNo(String retreatsNo);

	/**
	 * @Title:
	 * @Description: 根据合同号查询过户退保信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	TransferInfoRetreatsVo selectTransferInfoRetreatVoByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据退保任务号和业务类型查询财务付款表
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	ContPay selectContPayByRetreatsNo(String bizCode, String paymentType);

}
