package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueContRepository
 * @Description: 逾期合同信息Repository层
 * @date 2018-05-16
 */
public interface OverdueContRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期合同信息
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int insertData(OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 批量保存逾期合同信息
	 * @param overdueConts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int insertDataList(List<OverdueCont> overdueConts);

	/**
	 * @Title:
	 * @Description: 修改逾期合同信息
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByPrimaryKeyData(OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 批量修改逾期合同信息
	 * @param overdueConts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByPrimaryKeyDataList(List<OverdueCont> overdueConts);

	/**
	 * @Title:
	 * @Description: 动态修改逾期合同信息
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByPrimaryKeySelectiveData(OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期合同信息
	 * @param overdueConts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueCont> overdueConts);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期合同信息
	 * @param overdueCont
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByExampleData(OverdueCont overdueCont, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期合同信息
	 * @param overdueCont
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int updateByExampleSelectiveData(OverdueCont overdueCont, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueContId删除逾期合同信息
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int deleteData(OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 根据overdueContId集合批量删除逾期合同信息
	 * @param overdueContIds
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int deleteDataList(List overdueContIds, OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期合同信息
	 * @param example
	 * @param overdueCont
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	int deleteExampleData(Example example, OverdueCont overdueCont);

	/**
	 * @Title:
	 * @Description: 查询全部逾期合同信息
	 * @return List<OverdueCont>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	List<OverdueCont> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期合同信息
	 * @param example
	 * @return OverdueCont
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	OverdueCont selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期合同信息
	 * @param example
	 * @return List<OverdueCont>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	List<OverdueCont> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueContId查询逾期合同信息
	 * @param overdueContId
	 * @return OverdueCont
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	OverdueCont selectByPrimaryKey(Object overdueContId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期合同信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueCont>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	PageInfoExtend<OverdueCont> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期合同信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 14:32:22
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据contNo获取逾期合同信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	OverdueContVo selectOverdueContByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 获取合同的历史最高逾期天数和历史逾期次数
	 * @return List<OverdueContVo>
	 * @throws
	 * @author wangxue
	 * @date
	 */
	List<OverdueContVo> selectOverdueDaysHisAndOverdueTimes();

	/**
	 * @Title:
	 * @Description: 获取逾期客户表中的全部订单编号
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-04 11:24:39
	 */
	List<String> selectAllApplyNosByOverdue();

	/**
	 * @Title:
	 * @Description:   根据合同号获取逾期合同号
	 * @param overdueContVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/09/17 04:14:21
	 */
	OverdueContVo selectOverdueContVoByContNo(OverdueContVo overdueContVo);

	/**
	 * @Title:
	 * @Description:  获取全部的当前正在逾期的逾期合同ID集合
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018/09/17 04:14:21
	 */
	List<String> selectOverdueContIdsByOverdueFlag();

}
