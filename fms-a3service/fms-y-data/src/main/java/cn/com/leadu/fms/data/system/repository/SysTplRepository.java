package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplRepository
 * @Description: 模板管理Repository层
 * @date 2018-03-12
 */
public interface SysTplRepository {

	/**
	 * @Title:
	 * @Description: 新增模板管理
	 * @param sysTpl
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int insertData(SysTpl sysTpl);

	/**
	 * @Title:
	 * @Description: 批量保存模板管理
	 * @param sysTpls
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int insertDataList(List<SysTpl> sysTpls);

	/**
	 * @Title:
	 * @Description: 修改模板管理
	 * @param sysTpl
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByPrimaryKeyData(SysTpl sysTpl);

	/**
	 * @Title:
	 * @Description: 批量修改模板管理
	 * @param sysTpls
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByPrimaryKeyDataList(List<SysTpl> sysTpls);

	/**
	 * @Title:
	 * @Description: 动态修改模板管理
	 * @param sysTpl
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByPrimaryKeySelectiveData(SysTpl sysTpl);

	/**
	 * @Title:
	 * @Description: 批量动态修改模板管理
	 * @param sysTpls
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysTpl> sysTpls);

	/**
	 * @Title:
	 * @Description: 根据条件修改模板管理
	 * @param sysTpl
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByExampleData(SysTpl sysTpl, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改模板管理
	 * @param sysTpl
	 * @param example
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int updateByExampleSelectiveData(SysTpl sysTpl, Example example);

	/**
	 * @Title:
	 * @Description: 根据tplId删除模板管理
	 * @param sysTpl
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int deleteData(SysTpl sysTpl);

	/**
	 * @Title:
	 * @Description: 根据tplId集合批量删除模板管理
	 * @param tplIds
	 * @param sysTpl
	 * @return int
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	int deleteDataList(List tplIds, SysTpl sysTpl);

	/**
	 * @Title:
	 * @Description: 查询全部模板管理
	 * @return List<SysTpl>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	List<SysTpl> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个模板管理
	 * @param example
	 * @return SysTpl
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	SysTpl selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询模板管理
	 * @param example
	 * @return List<SysTpl>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	List<SysTpl> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过tplId查询模板管理
	 * @param tplId
	 * @return SysTpl
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	SysTpl selectByPrimaryKey(Object tplId);

	/**
	 * @Title:
	 * @Description: 分页查询模板管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysTpl>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	PageInfoExtend<SysTpl> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询模板管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysTplVo>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:18
	 */
	PageInfoExtend<SysTplVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据模板ID 获取获取模板信息
	 * @param tplId 模板ID
	 * @return SysTplVo
	 * @throws
	 * @author wangxue
	 * @date 2018-3-15 12:39:58
	 */
	SysTplVo selectSysTplVoByTplId(String tplId);

}
