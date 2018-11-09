package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionRepository
 * @Description: 年检提醒Repository层
 */
public interface AnnualInspectionRepository {

	/**
	 * @Title:
	 * @Description: 新增年检提醒
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int insertData(AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 批量保存年检提醒
	 * @param annualInspections
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int insertDataList(List<AnnualInspection> annualInspections);

	/**
	 * @Title:
	 * @Description: 修改年检提醒
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeyData(AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 批量修改年检提醒
	 * @param annualInspections
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeyDataList(List<AnnualInspection> annualInspections);

	/**
	 * @Title:
	 * @Description: 动态修改年检提醒
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeySelectiveData(AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 批量动态修改年检提醒
	 * @param annualInspections
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<AnnualInspection> annualInspections);

	/**
	 * @Title:
	 * @Description: 根据条件修改年检提醒
	 * @param annualInspection
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByExampleData(AnnualInspection annualInspection, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改年检提醒
	 * @param annualInspection
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByExampleSelectiveData(AnnualInspection annualInspection, Example example);

	/**
	 * @Title:
	 * @Description: 根据annualInspectionId删除年检提醒
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int deleteData(AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 根据annualInspectionId集合批量删除年检提醒
	 * @param annualInspectionIds
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int deleteDataList(List annualInspectionIds,AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除年检提醒
	 * @param example
	 * @param annualInspection
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int deleteExampleData(Example example,AnnualInspection annualInspection);

	/**
	 * @Title:
	 * @Description: 查询全部年检提醒
	 * @return List<AnnualInspection>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	List<AnnualInspection> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个年检提醒
	 * @param example
	 * @return AnnualInspection
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	AnnualInspection selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询年检提醒
	 * @param example
	 * @return List<AnnualInspection>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	List<AnnualInspection> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过annualInspectionId查询年检提醒
	 * @param annualInspectionId
	 * @return AnnualInspection
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	AnnualInspection selectByPrimaryKey(Object annualInspectionId);

	/**
	 * @Title:
	 * @Description: 分页查询年检提醒
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<AnnualInspection>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	PageInfoExtend<AnnualInspection> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询年检提醒vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改年检提醒
	 * @param annualInspection,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeyData(AnnualInspection annualInspection,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改年检提醒,并进行排他
	 * @param annualInspections
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeyDataList(List<AnnualInspection> annualInspections,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改年检提醒,并进行排他
	 * @param annualInspection
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(AnnualInspection annualInspection,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改年检提醒,并进行排他
	 * @param annualInspections
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByPrimaryKeySelectiveDataList(List<AnnualInspection> annualInspections,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改年检提醒,并进行排他
	 * @param annualInspection
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByExampleData(AnnualInspection annualInspection, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改年检提醒,并进行排他
	 * @param annualInspection
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	int updateByExampleSelectiveData(AnnualInspection annualInspection, Example example,boolean exclusive);


	/**
	 * @Title:
	 * @Description: 获取合同信息表里面需要年检的车辆数据
	 * @return List<Contract>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	List<Contract> selectContractsByPaymentSts(Integer annualinspectionYear ,Integer annualinspectionDays);


	/**
	 * @Title:
	 * @Description: 根据ID获取年检Vo信息
	 * @return List<Contract>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	AnnualInspectionVo selectAnnualInspectionVoByAnnualInespectionId(String annualinspectionId);


}
