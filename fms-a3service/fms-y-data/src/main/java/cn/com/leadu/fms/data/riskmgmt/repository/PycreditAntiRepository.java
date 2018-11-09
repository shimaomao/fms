package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAntiRepository
 * @Description: 反欺诈分析Repository层
 * @date 2018-06-04
 */
public interface PycreditAntiRepository {

	/**
	 * @Title:
	 * @Description: 新增反欺诈分析
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int insertData(PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 批量保存反欺诈分析
	 * @param pycreditAntis
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int insertDataList(List<PycreditAnti> pycreditAntis);

	/**
	 * @Title:
	 * @Description: 修改反欺诈分析
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeyData(PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 批量修改反欺诈分析
	 * @param pycreditAntis
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeyDataList(List<PycreditAnti> pycreditAntis);

	/**
	 * @Title:
	 * @Description: 动态修改反欺诈分析
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeySelectiveData(PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 批量动态修改反欺诈分析
	 * @param pycreditAntis
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditAnti> pycreditAntis);

	/**
	 * @Title:
	 * @Description: 根据条件修改反欺诈分析
	 * @param pycreditAnti
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByExampleData(PycreditAnti pycreditAnti, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改反欺诈分析
	 * @param pycreditAnti
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByExampleSelectiveData(PycreditAnti pycreditAnti, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditAntiId删除反欺诈分析
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int deleteData(PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 根据pycreditAntiId集合批量删除反欺诈分析
	 * @param pycreditAntiIds
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int deleteDataList(List pycreditAntiIds,PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除反欺诈分析
	 * @param example
	 * @param pycreditAnti
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int deleteExampleData(Example example,PycreditAnti pycreditAnti);

	/**
	 * @Title:
	 * @Description: 查询全部反欺诈分析
	 * @return List<PycreditAnti>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	List<PycreditAnti> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个反欺诈分析
	 * @param example
	 * @return PycreditAnti
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	PycreditAnti selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询反欺诈分析
	 * @param example
	 * @return List<PycreditAnti>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	List<PycreditAnti> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditAntiId查询反欺诈分析
	 * @param pycreditAntiId
	 * @return PycreditAnti
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	PycreditAnti selectByPrimaryKey(Object pycreditAntiId);

	/**
	 * @Title:
	 * @Description: 分页查询反欺诈分析
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditAnti>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	PageInfoExtend<PycreditAnti> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询反欺诈分析vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改反欺诈分析
	 * @param pycreditAnti,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeyData(PycreditAnti pycreditAnti,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改反欺诈分析,并进行排他
	 * @param pycreditAntis
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeyDataList(List<PycreditAnti> pycreditAntis,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改反欺诈分析,并进行排他
	 * @param pycreditAnti
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditAnti pycreditAnti,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改反欺诈分析,并进行排他
	 * @param pycreditAntis
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditAnti> pycreditAntis,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改反欺诈分析,并进行排他
	 * @param pycreditAnti
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByExampleData(PycreditAnti pycreditAnti, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改反欺诈分析,并进行排他
	 * @param pycreditAnti
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:08:52
	 */
	int updateByExampleSelectiveData(PycreditAnti pycreditAnti, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改反欺诈分析,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditAnti> selectPycreditAntiList(String documentNo,int ceilingNumber);

	/** 
	* @Description: 查询最近一条查询记录
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/3 15:29
	*/ 
	PycreditAnti selectLastPycreditAntiByDocumentNo(String documentNo);

}
