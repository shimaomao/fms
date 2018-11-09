package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckRepository
 * @Description: 个人银行卡核查Repository层
 * @date 2018-06-04
 */
public interface PycreditPersonBkcheckRepository {

	/**
	 * @Title:
	 * @Description: 新增个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int insertData(PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 批量保存个人银行卡核查
	 * @param pycreditPersonBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int insertDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks);

	/**
	 * @Title:
	 * @Description: 修改个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeyData(PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 批量修改个人银行卡核查
	 * @param pycreditPersonBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeyDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks);

	/**
	 * @Title:
	 * @Description: 动态修改个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeySelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人银行卡核查
	 * @param pycreditPersonBkchecks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByExampleData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByExampleSelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditPersonBkcheckId删除个人银行卡核查
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int deleteData(PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 根据pycreditPersonBkcheckId集合批量删除个人银行卡核查
	 * @param pycreditPersonBkcheckIds
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int deleteDataList(List pycreditPersonBkcheckIds,PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除个人银行卡核查
	 * @param example
	 * @param pycreditPersonBkcheck
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int deleteExampleData(Example example,PycreditPersonBkcheck pycreditPersonBkcheck);

	/**
	 * @Title:
	 * @Description: 查询全部个人银行卡核查
	 * @return List<PycreditPersonBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	List<PycreditPersonBkcheck> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个个人银行卡核查
	 * @param example
	 * @return PycreditPersonBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	PycreditPersonBkcheck selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询个人银行卡核查
	 * @param example
	 * @return List<PycreditPersonBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	List<PycreditPersonBkcheck> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditPersonBkcheckId查询个人银行卡核查
	 * @param pycreditPersonBkcheckId
	 * @return PycreditPersonBkcheck
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	PycreditPersonBkcheck selectByPrimaryKey(Object pycreditPersonBkcheckId);

	/**
	 * @Title:
	 * @Description: 分页查询个人银行卡核查
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditPersonBkcheck>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	PageInfoExtend<PycreditPersonBkcheck> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询个人银行卡核查vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改个人银行卡核查
	 * @param pycreditPersonBkcheck,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeyData(PycreditPersonBkcheck pycreditPersonBkcheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改个人银行卡核查,并进行排他
	 * @param pycreditPersonBkchecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeyDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改个人银行卡核查,并进行排他
	 * @param pycreditPersonBkcheck
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改个人银行卡核查,并进行排他
	 * @param pycreditPersonBkchecks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditPersonBkcheck> pycreditPersonBkchecks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改个人银行卡核查,并进行排他
	 * @param pycreditPersonBkcheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByExampleData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人银行卡核查,并进行排他
	 * @param pycreditPersonBkcheck
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:52
	 */
	int updateByExampleSelectiveData(PycreditPersonBkcheck pycreditPersonBkcheck, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改个人银行卡核查,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditPersonBkcheck> selectPycreditPersonBkcheckList(String documentNo, int ceilingNumber);

	/** 
	* @Description: 查询最近一条个人银行卡核查 
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 11:55
	*/ 
    PycreditPersonBkcheck selectLastPycreditPersonBkcheckByDocumentNo(String documentNo);
}
