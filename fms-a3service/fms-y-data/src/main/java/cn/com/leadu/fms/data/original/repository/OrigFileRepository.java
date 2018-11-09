package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileSortVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileStatusVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: OrigFileRepository
 * @Description: 资料邮寄附件Repository层
 * @date 2018-05-03
 */
public interface OrigFileRepository {

	/**
	 * @Title:
	 * @Description: 新增资料邮寄附件
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int insertData(OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 批量保存资料邮寄附件
	 * @param origFiles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int insertDataList(List<OrigFile> origFiles);

	/**
	 * @Title:
	 * @Description: 修改资料邮寄附件
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByPrimaryKeyData(OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 批量修改资料邮寄附件
	 * @param origFiles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByPrimaryKeyDataList(List<OrigFile> origFiles);

	/**
	 * @Title:
	 * @Description: 动态修改资料邮寄附件
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByPrimaryKeySelectiveData(OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 批量动态修改资料邮寄附件
	 * @param origFiles
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByPrimaryKeySelectiveDataList(List<OrigFile> origFiles);

	/**
	 * @Title:
	 * @Description: 根据条件修改资料邮寄附件
	 * @param origFile
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByExampleData(OrigFile origFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资料邮寄附件
	 * @param origFile
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int updateByExampleSelectiveData(OrigFile origFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据origFileId删除资料邮寄附件
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int deleteData(OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 根据origFileId集合批量删除资料邮寄附件
	 * @param origFileIds
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int deleteDataList(List origFileIds, OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资料邮寄附件
	 * @param example
	 * @param origFile
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	int deleteExampleData(Example example, OrigFile origFile);

	/**
	 * @Title:
	 * @Description: 查询全部资料邮寄附件
	 * @return List<OrigFile>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	List<OrigFile> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资料邮寄附件
	 * @param example
	 * @return OrigFile
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	OrigFile selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资料邮寄附件
	 * @param example
	 * @return List<OrigFile>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	List<OrigFile> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过origFileId查询资料邮寄附件
	 * @param origFileId
	 * @return OrigFile
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	OrigFile selectByPrimaryKey(Object origFileId);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OrigFile>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend<OrigFile> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄附件vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:47
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据归档状态查询资料邮件附件信息
	 * @param origFileVo
	 * @return List<OrigFileVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
//	List<OrigFileVo> selectOrigFileVosByOrigFileStatus(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description: 根据归档状态查询资料邮件附件信息
	 * @param origFileVo
	 * @return List<OrigFileVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 14:16:47
	 */
	OrigFileVo selectOrigFileInfoByBizCodeAndBizCodeType(OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description: 获取贷前归档明细一览画面数据
	 * @param origFileDetailVo
	 * @return OrigFileSortVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	OrigFileSortVo selectOrigFileSortDetailsByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 获取保单归档明细一览画面数据
	 * @param origFileDetailVo
	 * @return OrigFileSortVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	OrigFileSortVo selectOrigFileRenewalSortDetailsByPage(OrigFileDetailVo origFileDetailVo);

	/**
	 * @Title:
	 * @Description: 获取邮寄附件明细表信息（资料邮寄用）
	 * @param origFileVo
	 * @return BorrowBackTaskVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-3 11:26:39
	 */
	List<OrigFileDetailVo> selectOrigFileMailList(@Param("origFileVo") OrigFileVo origFileVo);

	/**
	 * @Title:
	 * @Description: 查询融保险资料邮寄附件信息
	 * @param
	 * @return
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-3 14:16:46
	 */
	List<OrigFileVo> selectOrigFileVos(OrigFileVo origFileVo);

	/**
	 * 根据合同号获取过户状态与收款状态
	 * @param contNo
	 * @return
	 */
	OrigFileStatusVo selectOrigFileStatusVoByContNo(String contNo);
}
