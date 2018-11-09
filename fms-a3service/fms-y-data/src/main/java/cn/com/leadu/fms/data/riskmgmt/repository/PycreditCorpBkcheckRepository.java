package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckRepository
 * @Description: 企业银行卡核查Repository层
 * @date 2018-06-04
 */
public interface PycreditCorpBkcheckRepository {

	/**
	 * @Title:
	 * @Description: 新增企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int insertData(PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 批量保存企业银行卡核查
	 * @param pycreditCorpBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int insertDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks);

	/**
	 * @Title:
	 * @Description: 修改企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeyData(PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 批量修改企业银行卡核查
	 * @param pycreditCorpBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks);

	/**
	 * @Title:
	 * @Description: 动态修改企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业银行卡核查
	 * @param pycreditCorpBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByExampleData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByExampleSelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpBkcheckId删除企业银行卡核查
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int deleteData(PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpBkcheckId集合批量删除企业银行卡核查
	 * @param pycreditCorpBkcheckIds
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int deleteDataList(List pycreditCorpBkcheckIds,PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除企业银行卡核查
	 * @param example
	 * @param pycreditCorpBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int deleteExampleData(Example example,PycreditCorpBkcheck pycreditCorpBkcheck);

	/**
	 * @Title:
	 * @Description: 查询全部企业银行卡核查
	 * @return List<PycreditCorpBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	List<PycreditCorpBkcheck> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个企业银行卡核查
	 * @param example
	 * @return PycreditCorpBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PycreditCorpBkcheck selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询企业银行卡核查
	 * @param example
	 * @return List<PycreditCorpBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	List<PycreditCorpBkcheck> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditCorpBkcheckId查询企业银行卡核查
	 * @param pycreditCorpBkcheckId
	 * @return PycreditCorpBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PycreditCorpBkcheck selectByPrimaryKey(Object pycreditCorpBkcheckId);

	/**
	 * @Title:
	 * @Description: 分页查询企业银行卡核查
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditCorpBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PageInfoExtend<PycreditCorpBkcheck> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询企业银行卡核查vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改企业银行卡核查
	 * @param pycreditCorpBkcheck,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeyData(PycreditCorpBkcheck pycreditCorpBkcheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改企业银行卡核查,并进行排他
	 * @param pycreditCorpBkchecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改企业银行卡核查,并进行排他
	 * @param pycreditCorpBkcheck
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业银行卡核查,并进行排他
	 * @param pycreditCorpBkchecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpBkcheck> pycreditCorpBkchecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业银行卡核查,并进行排他
	 * @param pycreditCorpBkcheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByExampleData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业银行卡核查,并进行排他
	 * @param pycreditCorpBkcheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:18
	 */
	int updateByExampleSelectiveData(PycreditCorpBkcheck pycreditCorpBkcheck, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业银行卡核查,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpBkcheck> selectPycreditCorpBkcheckList(String name, int ceilingNumber);

	/** 
	* @Description:  查询最近一条企业银行卡核查
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 14:26
	*/ 
    PycreditCorpBkcheck selectLastPycreditCorpBkcheckByDocumentNo(String name);
}
