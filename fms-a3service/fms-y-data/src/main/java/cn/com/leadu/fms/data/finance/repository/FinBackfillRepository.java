package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVoExcel;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinBackfillRepository
 * @Description: 融资回填Repository层
 * @date 2018-05-11
 */
public interface FinBackfillRepository {

	/**
	 * @Title:
	 * @Description: 新增融资回填
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int insertData(FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 批量保存融资回填
	 * @param finBackfills
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int insertDataList(List<FinBackfill> finBackfills);

	/**
	 * @Title:
	 * @Description: 修改融资回填
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByPrimaryKeyData(FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 批量修改融资回填
	 * @param finBackfills
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByPrimaryKeyDataList(List<FinBackfill> finBackfills);

	/**
	 * @Title:
	 * @Description: 动态修改融资回填
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByPrimaryKeySelectiveData(FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 批量动态修改融资回填
	 * @param finBackfills
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinBackfill> finBackfills);

	/**
	 * @Title:
	 * @Description: 根据条件修改融资回填
	 * @param finBackfill
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByExampleData(FinBackfill finBackfill, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改融资回填
	 * @param finBackfill
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int updateByExampleSelectiveData(FinBackfill finBackfill, Example example);

	/**
	 * @Title:
	 * @Description: 根据filBackfillId删除融资回填
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int deleteData(FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 根据filBackfillId集合批量删除融资回填
	 * @param filBackfillIds
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int deleteDataList(List filBackfillIds, FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除融资回填
	 * @param example
	 * @param finBackfill
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	int deleteExampleData(Example example, FinBackfill finBackfill);

	/**
	 * @Title:
	 * @Description: 查询全部融资回填
	 * @return List<FinBackfill>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	List<FinBackfill> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个融资回填
	 * @param example
	 * @return FinBackfill
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	FinBackfill selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询融资回填
	 * @param example
	 * @return List<FinBackfill>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	List<FinBackfill> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过filBackfillId查询融资回填
	 * @param filBackfillId
	 * @return FinBackfill
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	FinBackfill selectByPrimaryKey(Object filBackfillId);

	/**
	 * @Title:
	 * @Description: 分页查询融资回填
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinBackfill>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	PageInfoExtend<FinBackfill> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资回填vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询融资回填vo
	 * @param filBackfillId
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	FinBackfillVo selectFinBackfillByFilBackfillId(String filBackfillId);

	/**
	 * @Title:
	 * @Description: 根据财务回填信息获取融资还款计划信息
	 * @param contRepaySkedVo
	 * @return ContRepaySked
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	List<ContRepaySkedVo> selectContRepaySkedByfinBackfillVo(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 导出财务回填excel
	 * @param finBackfillVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 */
	List<FinBackfillVoExcel> selectFinBackfillsForExportExcel(FinBackfillVo finBackfillVo);
}
