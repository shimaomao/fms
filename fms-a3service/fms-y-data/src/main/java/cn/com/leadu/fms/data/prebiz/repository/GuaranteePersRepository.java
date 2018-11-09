package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersRepository
 * @Description: 担保个人信息Repository层
 * @date 2018-03-30
 */
public interface GuaranteePersRepository {

	/**
	 * @Title:
	 * @Description: 新增担保个人信息
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int insertData(GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 批量保存担保个人信息
	 * @param guaranteePerss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int insertDataList(List<GuaranteePers> guaranteePerss);

	/**
	 * @Title:
	 * @Description: 修改担保个人信息
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByPrimaryKeyData(GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 批量修改担保个人信息
	 * @param guaranteePerss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByPrimaryKeyDataList(List<GuaranteePers> guaranteePerss);

	/**
	 * @Title:
	 * @Description: 动态修改担保个人信息
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByPrimaryKeySelectiveData(GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 批量动态修改担保个人信息
	 * @param guaranteePerss
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<GuaranteePers> guaranteePerss);

	/**
	 * @Title:
	 * @Description: 根据条件修改担保个人信息
	 * @param guaranteePers
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByExampleData(GuaranteePers guaranteePers, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改担保个人信息
	 * @param guaranteePers
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int updateByExampleSelectiveData(GuaranteePers guaranteePers, Example example);

	/**
	 * @Title:
	 * @Description: 根据guarPersId删除担保个人信息
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int deleteData(GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 根据guarPersId集合批量删除担保个人信息
	 * @param guarPersIds
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int deleteDataList(List guarPersIds, GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除担保个人信息
	 * @param example
	 * @param guaranteePers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	int deleteExampleData(Example example, GuaranteePers guaranteePers);

	/**
	 * @Title:
	 * @Description: 查询全部担保个人信息
	 * @return List<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	List<GuaranteePers> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个担保个人信息
	 * @param example
	 * @return GuaranteePers
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	GuaranteePers selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询担保个人信息
	 * @param example
	 * @return List<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	List<GuaranteePers> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过guarPersId查询担保个人信息
	 * @param guarPersId
	 * @return GuaranteePers
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	GuaranteePers selectByPrimaryKey(Object guarPersId);

	/**
	 * @Title:
	 * @Description: 分页查询担保个人信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	PageInfoExtend<GuaranteePers> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询担保个人信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<GuaranteePers>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-30 10:55:12
	 */
	PageInfoExtend<GuaranteePers> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
