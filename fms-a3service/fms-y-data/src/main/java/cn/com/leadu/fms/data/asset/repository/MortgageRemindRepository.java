package cn.com.leadu.fms.data.asset.repository;

import cn.com.leadu.fms.pojo.asset.entity.MortgageRemind;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindRepository
 * @Description: 抵押提醒Repository层
 * @date 2018-07-27
 */
public interface MortgageRemindRepository {

	/**
	 * @Title:
	 * @Description: 新增抵押提醒
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int insertData(MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 批量保存抵押提醒
	 * @param mortgageReminds
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int insertDataList(List<MortgageRemind> mortgageReminds);

	/**
	 * @Title:
	 * @Description: 修改抵押提醒
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeyData(MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 批量修改抵押提醒
	 * @param mortgageReminds
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeyDataList(List<MortgageRemind> mortgageReminds);

	/**
	 * @Title:
	 * @Description: 动态修改抵押提醒
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeySelectiveData(MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 批量动态修改抵押提醒
	 * @param mortgageReminds
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<MortgageRemind> mortgageReminds);

	/**
	 * @Title:
	 * @Description: 根据条件修改抵押提醒
	 * @param mortgageRemind
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByExampleData(MortgageRemind mortgageRemind, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改抵押提醒
	 * @param mortgageRemind
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByExampleSelectiveData(MortgageRemind mortgageRemind, Example example);

	/**
	 * @Title:
	 * @Description: 根据morRemindId删除抵押提醒
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int deleteData(MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 根据morRemindId集合批量删除抵押提醒
	 * @param morRemindIds
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int deleteDataList(List morRemindIds, MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除抵押提醒
	 * @param example
	 * @param mortgageRemind
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int deleteExampleData(Example example, MortgageRemind mortgageRemind);

	/**
	 * @Title:
	 * @Description: 查询全部抵押提醒
	 * @return List<MortgageRemind>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	List<MortgageRemind> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个抵押提醒
	 * @param example
	 * @return MortgageRemind
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	MortgageRemind selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询抵押提醒
	 * @param example
	 * @return List<MortgageRemind>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	List<MortgageRemind> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过morRemindId查询抵押提醒
	 * @param morRemindId
	 * @return MortgageRemind
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	MortgageRemind selectByPrimaryKey(Object morRemindId);

	/**
	 * @Title:
	 * @Description: 分页查询抵押提醒
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<MortgageRemind>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	PageInfoExtend<MortgageRemind> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询抵押提醒vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改抵押提醒
	 * @param mortgageRemind,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeyData(MortgageRemind mortgageRemind, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改抵押提醒,并进行排他
	 * @param mortgageReminds
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeyDataList(List<MortgageRemind> mortgageReminds, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改抵押提醒,并进行排他
	 * @param mortgageRemind
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(MortgageRemind mortgageRemind, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改抵押提醒,并进行排他
	 * @param mortgageReminds
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<MortgageRemind> mortgageReminds, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改抵押提醒,并进行排他
	 * @param mortgageRemind
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByExampleData(MortgageRemind mortgageRemind, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改抵押提醒,并进行排他
	 * @param mortgageRemind
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-7-27 11:05:58
	 */
	int updateByExampleSelectiveData(MortgageRemind mortgageRemind, Example example, boolean exclusive);


	/**
	 * @Title:
	 * @Description: 根据ID获取数据信息
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-8 15:31:09
	 */
	MortgageRemindVo selectMortgageRemindVosBymorRemindId(String morRemindId);

}
