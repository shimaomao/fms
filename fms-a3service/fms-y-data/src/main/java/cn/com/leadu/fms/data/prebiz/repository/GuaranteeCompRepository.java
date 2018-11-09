package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompRepository
 * @Description: 担保企业信息Repository层
 * @date 2018-03-30
 */
public interface GuaranteeCompRepository {

	/**
	 * @Title:
	 * @Description: 新增担保企业信息
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int insertData(GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 批量保存担保企业信息
	 * @param guaranteeComps
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int insertDataList(List<GuaranteeComp> guaranteeComps);

	/**
	 * @Title:
	 * @Description: 修改担保企业信息
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByPrimaryKeyData(GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 批量修改担保企业信息
	 * @param guaranteeComps
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByPrimaryKeyDataList(List<GuaranteeComp> guaranteeComps);

	/**
	 * @Title:
	 * @Description: 动态修改担保企业信息
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByPrimaryKeySelectiveData(GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 批量动态修改担保企业信息
	 * @param guaranteeComps
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByPrimaryKeySelectiveDataList(List<GuaranteeComp> guaranteeComps);

	/**
	 * @Title:
	 * @Description: 根据条件修改担保企业信息
	 * @param guaranteeComp
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByExampleData(GuaranteeComp guaranteeComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改担保企业信息
	 * @param guaranteeComp
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int updateByExampleSelectiveData(GuaranteeComp guaranteeComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据guarCompId删除担保企业信息
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int deleteData(GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 根据guarCompId集合批量删除担保企业信息
	 * @param guarCompIds
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int deleteDataList(List guarCompIds, GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除担保企业信息
	 * @param example
	 * @param guaranteeComp
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	int deleteExampleData(Example example, GuaranteeComp guaranteeComp);

	/**
	 * @Title:
	 * @Description: 查询全部担保企业信息
	 * @return List<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	List<GuaranteeComp> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个担保企业信息
	 * @param example
	 * @return GuaranteeComp
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	GuaranteeComp selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询担保企业信息
	 * @param example
	 * @return List<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	List<GuaranteeComp> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过guarCompId查询担保企业信息
	 * @param guarCompId
	 * @return GuaranteeComp
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	GuaranteeComp selectByPrimaryKey(Object guarCompId);

	/**
	 * @Title:
	 * @Description: 分页查询担保企业信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	PageInfoExtend<GuaranteeComp> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询担保企业信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<GuaranteeComp>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 14:22:35
	 */
	PageInfoExtend<GuaranteeComp> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
