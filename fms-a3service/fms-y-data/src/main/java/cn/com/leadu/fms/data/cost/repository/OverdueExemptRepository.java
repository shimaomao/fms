package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.ContOverdueOneVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptRepository
 * @Description: 罚息免除任务表Repository层
 * @date 2018-05-30
 */
public interface OverdueExemptRepository {

	/**
	 * @Title:
	 * @Description: 新增罚息免除任务表
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int insertData(OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 批量保存罚息免除任务表
	 * @param overdueExempts
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int insertDataList(List<OverdueExempt> overdueExempts);

	/**
	 * @Title:
	 * @Description: 修改罚息免除任务表
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByPrimaryKeyData(OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 批量修改罚息免除任务表
	 * @param overdueExempts
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByPrimaryKeyDataList(List<OverdueExempt> overdueExempts);

	/**
	 * @Title:
	 * @Description: 动态修改罚息免除任务表
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByPrimaryKeySelectiveData(OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 批量动态修改罚息免除任务表
	 * @param overdueExempts
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueExempt> overdueExempts);

	/**
	 * @Title:
	 * @Description: 根据条件修改罚息免除任务表
	 * @param overdueExempt
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByExampleData(OverdueExempt overdueExempt, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改罚息免除任务表
	 * @param overdueExempt
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int updateByExampleSelectiveData(OverdueExempt overdueExempt, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueExemptId删除罚息免除任务表
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int deleteData(OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 根据overdueExemptId集合批量删除罚息免除任务表
	 * @param overdueExemptIds
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int deleteDataList(List overdueExemptIds,OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除罚息免除任务表
	 * @param example
	 * @param overdueExempt
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	int deleteExampleData(Example example,OverdueExempt overdueExempt);

	/**
	 * @Title:
	 * @Description: 查询全部罚息免除任务表
	 * @return List<OverdueExempt>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	List<OverdueExempt> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个罚息免除任务表
	 * @param example
	 * @return OverdueExempt
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	OverdueExempt selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询罚息免除任务表
	 * @param example
	 * @return List<OverdueExempt>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	List<OverdueExempt> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueExemptId查询罚息免除任务表
	 * @param overdueExemptId
	 * @return OverdueExempt
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	OverdueExempt selectByPrimaryKey(Object overdueExemptId);

	/**
	 * @Title:
	 * @Description: 分页查询罚息免除任务表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueExempt>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	PageInfoExtend<OverdueExempt> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询罚息免除任务表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-30 19:08:30
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 通过合同号关联查询逾期罚息表和罚息免除任务明细表信息
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	public List<ContOverdueVo> selectContOverdueAndOverdueExemptDetailByContNo(String contNo,String overdueExemptNo);

	/**
	 * @Title:
	 * @Description: 根据合同号关联查询合同信息等表并去重取得一条明细(页面上半部分)
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	ContOverdueOneVo selectOneContOverdueVo(String contNo);

}
