package cn.com.leadu.fms.data.original.repository;

import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: FileSendRepository
 * @Description: 资料邮寄Repository层
 * @date 2018-05-04
 */
public interface FileSendRepository {

	/**
	 * @Title:
	 * @Description: 新增资料邮寄
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int insertData(FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 批量保存资料邮寄
	 * @param fileSends
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int insertDataList(List<FileSend> fileSends);

	/**
	 * @Title:
	 * @Description: 修改资料邮寄
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByPrimaryKeyData(FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 批量修改资料邮寄
	 * @param fileSends
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByPrimaryKeyDataList(List<FileSend> fileSends);

	/**
	 * @Title:
	 * @Description: 动态修改资料邮寄
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByPrimaryKeySelectiveData(FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 批量动态修改资料邮寄
	 * @param fileSends
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByPrimaryKeySelectiveDataList(List<FileSend> fileSends);

	/**
	 * @Title:
	 * @Description: 根据条件修改资料邮寄
	 * @param fileSend
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByExampleData(FileSend fileSend, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改资料邮寄
	 * @param fileSend
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int updateByExampleSelectiveData(FileSend fileSend, Example example);

	/**
	 * @Title:
	 * @Description: 根据filePostId删除资料邮寄
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int deleteData(FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 根据filePostId集合批量删除资料邮寄
	 * @param filePostIds
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int deleteDataList(List filePostIds, FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除资料邮寄
	 * @param example
	 * @param fileSend
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	int deleteExampleData(Example example, FileSend fileSend);

	/**
	 * @Title:
	 * @Description: 查询全部资料邮寄
	 * @return List<FileSend>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	List<FileSend> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个资料邮寄
	 * @param example
	 * @return FileSend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	FileSend selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询资料邮寄
	 * @param example
	 * @return List<FileSend>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	List<FileSend> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过filePostId查询资料邮寄
	 * @param filePostId
	 * @return FileSend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	FileSend selectByPrimaryKey(Object filePostId);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FileSend>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	PageInfoExtend<FileSend> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询资料邮寄vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-4 16:51:02
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
