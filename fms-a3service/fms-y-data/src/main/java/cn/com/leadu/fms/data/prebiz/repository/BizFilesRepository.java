package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BizFilesRepository
 * @Description: 附件信息Repository层
 * @date 2018-04-09
 */
public interface BizFilesRepository {

	/**
	 * @Title:
	 * @Description: 新增附件信息
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int insertData(BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 批量保存附件信息
	 * @param bizFiless
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int insertDataList(List<BizFiles> bizFiless);

	/**
	 * @Title:
	 * @Description: 修改附件信息
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByPrimaryKeyData(BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 批量修改附件信息
	 * @param bizFiless
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByPrimaryKeyDataList(List<BizFiles> bizFiless);

	/**
	 * @Title:
	 * @Description: 动态修改附件信息
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByPrimaryKeySelectiveData(BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 批量动态修改附件信息
	 * @param bizFiless
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByPrimaryKeySelectiveDataList(List<BizFiles> bizFiless);

	/**
	 * @Title:
	 * @Description: 根据条件修改附件信息
	 * @param bizFiles
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByExampleData(BizFiles bizFiles, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改附件信息
	 * @param bizFiles
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int updateByExampleSelectiveData(BizFiles bizFiles, Example example);

	/**
	 * @Title:
	 * @Description: 根据fileId删除附件信息
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int deleteData(BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 根据fileId集合批量删除附件信息
	 * @param fileIds
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int deleteDataList(List fileIds, BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除附件信息
	 * @param example
	 * @param bizFiles
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	int deleteExampleData(Example example, BizFiles bizFiles);

	/**
	 * @Title:
	 * @Description: 查询全部附件信息
	 * @return List<BizFiles>
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	List<BizFiles> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个附件信息
	 * @param example
	 * @return BizFiles
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	BizFiles selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询附件信息
	 * @param example
	 * @return List<BizFiles>
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	List<BizFiles> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过fileId查询附件信息
	 * @param fileId
	 * @return BizFiles
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	BizFiles selectByPrimaryKey(Object fileId);

	/**
	 * @Title:
	 * @Description: 分页查询附件信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BizFiles>
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	PageInfoExtend<BizFiles> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询附件信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BizFiles>
	 * @throws
	 * @author huchenghao
	 * @date 2018-4-9 14:55:49
	 */
	PageInfoExtend<BizFiles> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
