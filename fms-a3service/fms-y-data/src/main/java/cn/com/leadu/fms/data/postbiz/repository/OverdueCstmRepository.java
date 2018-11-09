package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.CollectionLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.LawyerLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmRepository
 * @Description: 逾期客户信息Repository层
 * @date 2018-05-16
 */
public interface OverdueCstmRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期客户信息
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int insertData(OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 批量保存逾期客户信息
	 * @param overdueCstms
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int insertDataList(List<OverdueCstm> overdueCstms);

	/**
	 * @Title:
	 * @Description: 修改逾期客户信息
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByPrimaryKeyData(OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 批量修改逾期客户信息
	 * @param overdueCstms
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByPrimaryKeyDataList(List<OverdueCstm> overdueCstms);

	/**
	 * @Title:
	 * @Description: 动态修改逾期客户信息
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByPrimaryKeySelectiveData(OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期客户信息
	 * @param overdueCstms
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueCstm> overdueCstms);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期客户信息
	 * @param overdueCstm
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByExampleData(OverdueCstm overdueCstm, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期客户信息
	 * @param overdueCstm
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int updateByExampleSelectiveData(OverdueCstm overdueCstm, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmId删除逾期客户信息
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int deleteData(OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmId集合批量删除逾期客户信息
	 * @param overdueCstmIds
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int deleteDataList(List overdueCstmIds, OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期客户信息
	 * @param example
	 * @param overdueCstm
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	int deleteExampleData(Example example, OverdueCstm overdueCstm);

	/**
	 * @Title:
	 * @Description: 查询全部逾期客户信息
	 * @return List<OverdueCstm>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	List<OverdueCstm> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期客户信息
	 * @param example
	 * @return OverdueCstm
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstm selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期客户信息
	 * @param example
	 * @return List<OverdueCstm>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	List<OverdueCstm> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueCstmId查询逾期客户信息
	 * @param overdueCstmId
	 * @return OverdueCstm
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstm selectByPrimaryKey(Object overdueCstmId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueCstm>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend<OverdueCstm> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据逾期客户ID获取信息
	 * @param overdueCstmId
	 * @return OverdueCstmVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstmVo selectOverdueCstmByOverdueCstmId(String overdueCstmId);

	/**
	 * @Title:
	 * @Description: 根据逾期客户ID获取信息
	 * @param overdueCstmId
	 * @return OverdueCstmVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstmVo selectOverdueCstmVoByOverdueCstmId(String overdueCstmId);

	/**
	 * @Title:
	 * @Description: 根据逾期客户ID获取合同编号List
	 * @param overdueCstmId
	 * @return OverdueCstmVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	List<String> selectContNoListByOverdueCstmId(String overdueCstmId);

	/**
	 * @Title:
	 * @Description: 获取电话催收登记信息
	 * @return List<OverdueTelRegisterVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	List<OverdueTelRegisterVo> selectOverdueTelRegister(String overdueCstmId);

	/**
	 * @Description: 根据逾期客户电话信息ID获取逾期客户电话信息
	 * @return: OverdueCstmTelVo
	 * @Param overdueCstmTelId
	 * @Author: lijunjun
	 * @Date: 2018/5/10 19:42
	 */
	OverdueCstmTelVo selectOverdueCstmTelVoByOverdueCstmTelId(String overdueCstmTelId);

	/**
	 * @Description: 根据逾期客户信息ID获取电话催收登记信息List
	 * @return: OverdueCstmTelVo
	 * @Param overdueCstmTelId
	 * @Author: lijunjun
	 * @Date: 2018/5/10 19:42
	 */
	List<OverdueTelRegisterVo> selectOverdueTelRegisterVoByOverdueCstmId(String overdueCstmTelId);

	/**
	 * 根据overdueCstmId获取收车信息List
	 * @param overdueCstmId
	 * @return
	 */
	List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVoList(String overdueCstmId);

	/**
	 * 根据overdueCstmId获取诉讼信息List
	 * @param overdueCstmId
	 * @return
	 */
	List<LawsuitTaskVo> selectLawsuitTaskVoList(String overdueCstmId);

	/**
	 * 获取上门催收信息List
	 * @param overdueCstmId
	 * @return
	 */
	List<CollectionTaskVo> selectCollectionTaskList(String overdueCstmId);

	/**
	 * 获取催收函数据
	 * @param contNo
	 * @return
	 */
	CollectionLetterVo selectCollectionLetterInfo(String contNo);

	/**
	 * 获取律师函数据
	 * @param contNo
	 * @return
	 */
	LawyerLetterVo selectLawyerLetterInfo(String contNo);

	/**
	 * 获取分配人员信息
	 * @param roleCodeList
	 * @return
	 */
	List<SysUser> selectAssignUsers(List<String> roleCodeList);
}
