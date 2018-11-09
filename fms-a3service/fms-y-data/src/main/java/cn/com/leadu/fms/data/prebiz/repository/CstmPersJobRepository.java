package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobRepository
 * @Description: 客户个人职业信息Repository层
 * @date 2018-03-26
 */
public interface CstmPersJobRepository {

	/**
	 * @Title:
	 * @Description: 新增客户个人职业信息
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int insertData(CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 批量保存客户个人职业信息
	 * @param cstmPersJobs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int insertDataList(List<CstmPersJob> cstmPersJobs);

	/**
	 * @Title:
	 * @Description: 修改客户个人职业信息
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByPrimaryKeyData(CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 批量修改客户个人职业信息
	 * @param cstmPersJobs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByPrimaryKeyDataList(List<CstmPersJob> cstmPersJobs);

	/**
	 * @Title:
	 * @Description: 动态修改客户个人职业信息
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByPrimaryKeySelectiveData(CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户个人职业信息
	 * @param cstmPersJobs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmPersJob> cstmPersJobs);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户个人职业信息
	 * @param cstmPersJob
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByExampleData(CstmPersJob cstmPersJob, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户个人职业信息
	 * @param cstmPersJob
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int updateByExampleSelectiveData(CstmPersJob cstmPersJob, Example example);

	/**
	 * @Title:
	 * @Description: 根据persJobId删除客户个人职业信息
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int deleteData(CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 根据persJobId集合批量删除客户个人职业信息
	 * @param persJobIds
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int deleteDataList(List persJobIds, CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户个人职业信息
	 * @param example
	 * @param cstmPersJob
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	int deleteExampleData(Example example, CstmPersJob cstmPersJob);

	/**
	 * @Title:
	 * @Description: 查询全部客户个人职业信息
	 * @return List<CstmPersJob>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	List<CstmPersJob> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户个人职业信息
	 * @param example
	 * @return CstmPersJob
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	CstmPersJob selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户个人职业信息
	 * @param example
	 * @return List<CstmPersJob>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	List<CstmPersJob> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过persJobId查询客户个人职业信息
	 * @param persJobId
	 * @return CstmPersJob
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	CstmPersJob selectByPrimaryKey(Object persJobId);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人职业信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersJob>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	PageInfoExtend<CstmPersJob> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人职业信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersJob>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 16:16:47
	 */
	PageInfoExtend<CstmPersJob> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
