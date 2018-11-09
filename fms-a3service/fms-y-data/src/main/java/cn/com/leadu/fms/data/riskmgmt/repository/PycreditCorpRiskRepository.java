package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskRepository
 * @Description: 企业风险Repository层
 * @date 2018-06-04
 */
public interface PycreditCorpRiskRepository {

	/**
	 * @Title:
	 * @Description: 新增企业风险
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int insertData(PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 批量保存企业风险
	 * @param pycreditCorpRisks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int insertDataList(List<PycreditCorpRisk> pycreditCorpRisks);

	/**
	 * @Title:
	 * @Description: 修改企业风险
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeyData(PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 批量修改企业风险
	 * @param pycreditCorpRisks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpRisk> pycreditCorpRisks);

	/**
	 * @Title:
	 * @Description: 动态修改企业风险
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业风险
	 * @param pycreditCorpRisks
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpRisk> pycreditCorpRisks);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业风险
	 * @param pycreditCorpRisk
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByExampleData(PycreditCorpRisk pycreditCorpRisk, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险
	 * @param pycreditCorpRisk
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByExampleSelectiveData(PycreditCorpRisk pycreditCorpRisk, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpRiskId删除企业风险
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int deleteData(PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 根据pycreditCorpRiskId集合批量删除企业风险
	 * @param pycreditCorpRiskIds
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int deleteDataList(List pycreditCorpRiskIds,PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除企业风险
	 * @param example
	 * @param pycreditCorpRisk
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int deleteExampleData(Example example,PycreditCorpRisk pycreditCorpRisk);

	/**
	 * @Title:
	 * @Description: 查询全部企业风险
	 * @return List<PycreditCorpRisk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	List<PycreditCorpRisk> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个企业风险
	 * @param example
	 * @return PycreditCorpRisk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PycreditCorpRisk selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询企业风险
	 * @param example
	 * @return List<PycreditCorpRisk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	List<PycreditCorpRisk> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditCorpRiskId查询企业风险
	 * @param pycreditCorpRiskId
	 * @return PycreditCorpRisk
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PycreditCorpRisk selectByPrimaryKey(Object pycreditCorpRiskId);

	/**
	 * @Title:
	 * @Description: 分页查询企业风险
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditCorpRisk>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PageInfoExtend<PycreditCorpRisk> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询企业风险vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改企业风险
	 * @param pycreditCorpRisk,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeyData(PycreditCorpRisk pycreditCorpRisk,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改企业风险,并进行排他
	 * @param pycreditCorpRisks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeyDataList(List<PycreditCorpRisk> pycreditCorpRisks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改企业风险,并进行排他
	 * @param pycreditCorpRisk
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditCorpRisk pycreditCorpRisk,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改企业风险,并进行排他
	 * @param pycreditCorpRisks
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditCorpRisk> pycreditCorpRisks,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改企业风险,并进行排他
	 * @param pycreditCorpRisk
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByExampleData(PycreditCorpRisk pycreditCorpRisk, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险,并进行排他
	 * @param pycreditCorpRisk
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:11:03
	 */
	int updateByExampleSelectiveData(PycreditCorpRisk pycreditCorpRisk, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改企业风险,并进行排他
	 * @param name
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditCorpRisk> selectPycreditCorpRiskList(String name, int ceilingNumber);

	/** 
	* @Description: 查询最近一条企业风险实体
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 14:52
	*/ 
    PycreditCorpRisk selectLastPycreditCorpRiskByDocumentNo(String name);
}
