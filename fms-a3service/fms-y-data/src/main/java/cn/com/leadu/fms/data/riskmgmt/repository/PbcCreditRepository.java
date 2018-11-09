package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PbcCreditRepository
 * @Description: 个人人行征信信息Repository层
 * @date 2018-06-04
 */
public interface PbcCreditRepository {

	/**
	 * @Title:
	 * @Description: 新增个人人行征信信息
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int insertData(PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 批量保存个人人行征信信息
	 * @param pbcCredits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int insertDataList(List<PbcCredit> pbcCredits);

	/**
	 * @Title:
	 * @Description: 修改个人人行征信信息
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeyData(PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 批量修改个人人行征信信息
	 * @param pbcCredits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeyDataList(List<PbcCredit> pbcCredits);

	/**
	 * @Title:
	 * @Description: 动态修改个人人行征信信息
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeySelectiveData(PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人人行征信信息
	 * @param pbcCredits
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<PbcCredit> pbcCredits);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人人行征信信息
	 * @param pbcCredit
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByExampleData(PbcCredit pbcCredit, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人人行征信信息
	 * @param pbcCredit
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByExampleSelectiveData(PbcCredit pbcCredit, Example example);

	/**
	 * @Title:
	 * @Description: 根据pbcCreditId删除个人人行征信信息
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int deleteData(PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 根据pbcCreditId集合批量删除个人人行征信信息
	 * @param pbcCreditIds
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int deleteDataList(List pbcCreditIds,PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除个人人行征信信息
	 * @param example
	 * @param pbcCredit
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int deleteExampleData(Example example,PbcCredit pbcCredit);

	/**
	 * @Title:
	 * @Description: 查询全部个人人行征信信息
	 * @return List<PbcCredit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	List<PbcCredit> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个个人人行征信信息
	 * @param example
	 * @return PbcCredit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PbcCredit selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询个人人行征信信息
	 * @param example
	 * @return List<PbcCredit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	List<PbcCredit> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pbcCreditId查询个人人行征信信息
	 * @param pbcCreditId
	 * @return PbcCredit
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PbcCredit selectByPrimaryKey(Object pbcCreditId);

	/**
	 * @Title:
	 * @Description: 分页查询个人人行征信信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PbcCredit>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PageInfoExtend<PbcCredit> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询个人人行征信信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改个人人行征信信息
	 * @param pbcCredit,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeyData(PbcCredit pbcCredit,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改个人人行征信信息,并进行排他
	 * @param pbcCredits
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeyDataList(List<PbcCredit> pbcCredits,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改个人人行征信信息,并进行排他
	 * @param pbcCredit
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PbcCredit pbcCredit,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人人行征信信息,并进行排他
	 * @param pbcCredits
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByPrimaryKeySelectiveDataList(List<PbcCredit> pbcCredits,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人人行征信信息,并进行排他
	 * @param pbcCredit
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByExampleData(PbcCredit pbcCredit, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人人行征信信息,并进行排他
	 * @param pbcCredit
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:07:17
	 */
	int updateByExampleSelectiveData(PbcCredit pbcCredit, Example example,boolean exclusive);

}
