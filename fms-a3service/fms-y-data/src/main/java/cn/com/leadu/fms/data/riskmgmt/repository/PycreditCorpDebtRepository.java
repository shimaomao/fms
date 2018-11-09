package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtRepository
 * @Description: 企业债务Repository层
 * @date 2018-06-04
 */
public interface PycreditCorpDebtRepository {

	/**
	 * @Title:
	 * @Description: 新增企业债务
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int insertData(PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 批量保存企业债务
	 * @param pycreditCorpDebts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int insertDataList(List<PycreditCorpDebt> pycreditCorpDebts);

	/**
	 * @Title:
	 * @Description: 修改企业债务
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeyData(PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 批量修改企业债务
	 * @param pycreditCorpDebts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpDebt> pycreditCorpDebts);

	/**
	 * @Title:
	 * @Description: 动态修改企业债务
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业债务
	 * @param pycreditCorpDebts
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpDebt> pycreditCorpDebts);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业债务
	 * @param pycreditCorpDebt
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByExampleData(PycreditCorpDebt pycreditCorpDebt, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业债务
	 * @param pycreditCorpDebt
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByExampleSelectiveData(PycreditCorpDebt pycreditCorpDebt, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpDebtId删除企业债务
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int deleteData(PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpDebtId集合批量删除企业债务
	 * @param pycreditCorpDebtIds
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int deleteDataList(List pycreditCorpDebtIds,PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除企业债务
	 * @param example
	 * @param pycreditCorpDebt
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int deleteExampleData(Example example,PycreditCorpDebt pycreditCorpDebt);

	/**
	 * @Title:
	 * @Description: 查询全部企业债务
	 * @return List<PycreditCorpDebt>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	List<PycreditCorpDebt> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个企业债务
	 * @param example
	 * @return PycreditCorpDebt
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PycreditCorpDebt selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询企业债务
	 * @param example
	 * @return List<PycreditCorpDebt>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	List<PycreditCorpDebt> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditCorpDebtId查询企业债务
	 * @param pycreditCorpDebtId
	 * @return PycreditCorpDebt
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PycreditCorpDebt selectByPrimaryKey(Object pycreditCorpDebtId);

	/**
	 * @Title:
	 * @Description: 分页查询企业债务
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditCorpDebt>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PageInfoExtend<PycreditCorpDebt> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询企业债务vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改企业债务
	 * @param pycreditCorpDebt,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeyData(PycreditCorpDebt pycreditCorpDebt,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改企业债务,并进行排他
	 * @param pycreditCorpDebts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpDebt> pycreditCorpDebts,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改企业债务,并进行排他
	 * @param pycreditCorpDebt
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpDebt pycreditCorpDebt,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业债务,并进行排他
	 * @param pycreditCorpDebts
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpDebt> pycreditCorpDebts,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业债务,并进行排他
	 * @param pycreditCorpDebt
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByExampleData(PycreditCorpDebt pycreditCorpDebt, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业债务,并进行排他
	 * @param pycreditCorpDebt
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:32
	 */
	int updateByExampleSelectiveData(PycreditCorpDebt pycreditCorpDebt, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业债务,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpDebt> selectPycreditCorpDebtList(String name, int ceilingNumber);

	/** 
	* @Description: 查尊最近企业债务查询
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 15:20
	*/ 
    PycreditCorpDebt selectLastPycreditCorpDebtByDocumentNo(String name);
}
