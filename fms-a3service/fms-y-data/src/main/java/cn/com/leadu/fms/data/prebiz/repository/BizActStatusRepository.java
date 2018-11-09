package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.BizActStatus;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BizActStatusRepository
 * @Description: 业务状态管理Repository层
 * @date 2018-03-27
 */
public interface BizActStatusRepository {

	/**
	 * @Title:
	 * @Description: 新增业务状态管理
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int insertData(BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 批量保存业务状态管理
	 * @param bizActStatuss
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int insertDataList(List<BizActStatus> bizActStatuss);

	/**
	 * @Title:
	 * @Description: 修改业务状态管理
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByPrimaryKeyData(BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 批量修改业务状态管理
	 * @param bizActStatuss
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByPrimaryKeyDataList(List<BizActStatus> bizActStatuss);

	/**
	 * @Title:
	 * @Description: 动态修改业务状态管理
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByPrimaryKeySelectiveData(BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 批量动态修改业务状态管理
	 * @param bizActStatuss
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByPrimaryKeySelectiveDataList(List<BizActStatus> bizActStatuss);

	/**
	 * @Title:
	 * @Description: 根据条件修改业务状态管理
	 * @param bizActStatus
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByExampleData(BizActStatus bizActStatus, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改业务状态管理
	 * @param bizActStatus
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int updateByExampleSelectiveData(BizActStatus bizActStatus, Example example);

	/**
	 * @Title:
	 * @Description: 根据actStsId删除业务状态管理
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int deleteData(BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 根据actStsId集合批量删除业务状态管理
	 * @param actStsIds
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int deleteDataList(List actStsIds, BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除业务状态管理
	 * @param example
	 * @param bizActStatus
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	int deleteExampleData(Example example, BizActStatus bizActStatus);

	/**
	 * @Title:
	 * @Description: 查询全部业务状态管理
	 * @return List<BizActStatus>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	List<BizActStatus> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个业务状态管理
	 * @param example
	 * @return BizActStatus
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	BizActStatus selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询业务状态管理
	 * @param example
	 * @return List<BizActStatus>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	List<BizActStatus> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过actStsId查询业务状态管理
	 * @param actStsId
	 * @return BizActStatus
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	BizActStatus selectByPrimaryKey(Object actStsId);

	/**
	 * @Title:
	 * @Description: 分页查询业务状态管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BizActStatus>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	PageInfoExtend<BizActStatus> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询业务状态管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BizActStatus>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 16:21:22
	 */
	PageInfoExtend<BizActStatus> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
