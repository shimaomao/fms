package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileRepository
 * @Description: 产品附件管理Repository层
 * @date 2018-04-05
 */
public interface ProdFileRepository {

	/**
	 * @Title:
	 * @Description: 新增产品附件管理
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int insertData(ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 批量保存产品附件管理
	 * @param prodFiles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int insertDataList(List<ProdFile> prodFiles);

	/**
	 * @Title:
	 * @Description: 修改产品附件管理
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByPrimaryKeyData(ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 批量修改产品附件管理
	 * @param prodFiles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByPrimaryKeyDataList(List<ProdFile> prodFiles);

	/**
	 * @Title:
	 * @Description: 动态修改产品附件管理
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByPrimaryKeySelectiveData(ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品附件管理
	 * @param prodFiles
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdFile> prodFiles);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品附件管理
	 * @param prodFile
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByExampleData(ProdFile prodFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品附件管理
	 * @param prodFile
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int updateByExampleSelectiveData(ProdFile prodFile, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodFileId删除产品附件管理
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int deleteData(ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 根据prodFileId集合批量删除产品附件管理
	 * @param prodFileIds
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int deleteDataList(List prodFileIds, ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品附件管理
	 * @param example
	 * @param prodFile
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	int deleteExampleData(Example example, ProdFile prodFile);

	/**
	 * @Title:
	 * @Description: 查询全部产品附件管理
	 * @return List<ProdFile>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	List<ProdFile> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品附件管理
	 * @param example
	 * @return ProdFile
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	ProdFile selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品附件管理
	 * @param example
	 * @return List<ProdFile>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	List<ProdFile> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodFileId查询产品附件管理
	 * @param prodFileId
	 * @return ProdFile
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	ProdFile selectByPrimaryKey(Object prodFileId);

	/**
	 * @Title:
	 * @Description: 分页查询产品附件管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdFile>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	PageInfoExtend<ProdFile> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品附件管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdFile>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:54:11
	 */
	PageInfoExtend<ProdFile> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);


	/**
	 * @Title:
	 * @Description: 通过产品方案查询
	 * @param product
	 * @return List<ProdFileVo>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-5 21:36:32
	 */
	List<ProdFileVo> selectProdFileVosByProduct(String product);

}
