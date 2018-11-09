package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.common.vo.CommonParamVo;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: SysParamRepository
 * @Description: 系统常量表Repository层
 * @date 2018-03-09
 */
public interface SysParamRepository {

	/**
	 * @Title:
	 * @Description: 新增系统常量表
	 * @param sysParam
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int insertData(SysParam sysParam);

	/**
	 * @Title:
	 * @Description: 批量保存系统常量表
	 * @param sysParams
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int insertDataList(List<SysParam> sysParams);

	/**
	 * @Title:
	 * @Description: 修改系统常量表
	 * @param sysParam
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByPrimaryKeyData(SysParam sysParam);

	/**
	 * @Title:
	 * @Description: 批量修改系统常量表
	 * @param sysParams
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByPrimaryKeyDataList(List<SysParam> sysParams);

	/**
	 * @Title:
	 * @Description: 动态修改系统常量表
	 * @param sysParam
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByPrimaryKeySelectiveData(SysParam sysParam);

	/**
	 * @Title:
	 * @Description: 批量动态修改系统常量表
	 * @param sysParams
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysParam> sysParams);

	/**
	 * @Title:
	 * @Description: 根据条件修改系统常量表
	 * @param sysParam
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByExampleData(SysParam sysParam, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改系统常量表
	 * @param sysParam
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int updateByExampleSelectiveData(SysParam sysParam, Example example);

	/**
	 * @Title:
	 * @Description: 根据paramKeyId删除系统常量表
	 * @param sysParam
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int deleteData(SysParam sysParam);

	/**
	 * @Title:
	 * @Description: 根据paramKeyId集合批量删除系统常量表
	 * @param paramKeyIds
	 * @param sysParam
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	int deleteDataList(List paramKeyIds, SysParam sysParam);

	/**
	 * @Title:
	 * @Description: 查询全部系统常量表
	 * @return List<SysParam>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	List<SysParam> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个系统常量表
	 * @param example
	 * @return SysParam
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	SysParam selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询系统常量表
	 * @param example
	 * @return List<SysParam>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	List<SysParam> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过paramKeyId查询系统常量表
	 * @param paramKeyId
	 * @return SysParam
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	SysParam selectByPrimaryKey(Object paramKeyId);

	/**
	 * @Title:
	 * @Description: 分页查询系统常量表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysParam>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	PageInfoExtend<SysParam> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询系统常量表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysParam>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	PageInfoExtend<SysParam> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:   查询所有系统常量,用于前后台系统常量取得
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/19 09:07:08
	 */
	List<CommonParamVo> selectSysParams();

}
