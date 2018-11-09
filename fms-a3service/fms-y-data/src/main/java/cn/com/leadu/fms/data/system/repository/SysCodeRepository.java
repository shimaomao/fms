package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeRepository
 * @Description: 字典数数值Repository层
 * @date 2018-03-09
 */
public interface SysCodeRepository {

	/**
	 * @Title:
	 * @Description: 新增字典数数值
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int insertData(SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 批量保存字典数数值
	 * @param sysCodes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int insertDataList(List<SysCode> sysCodes);

	/**
	 * @Title:
	 * @Description: 修改字典数数值
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByPrimaryKeyData(SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 批量修改字典数数值
	 * @param sysCodes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByPrimaryKeyDataList(List<SysCode> sysCodes);

	/**
	 * @Title:
	 * @Description: 动态修改字典数数值
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByPrimaryKeySelectiveData(SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 批量动态修改字典数数值
	 * @param sysCodes
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysCode> sysCodes);

	/**
	 * @Title:
	 * @Description: 根据条件修改字典数数值
	 * @param sysCode
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByExampleData(SysCode sysCode, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改字典数数值
	 * @param sysCode
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int updateByExampleSelectiveData(SysCode sysCode, Example example);

	/**
	 * @Title:
	 * @Description: 根据codeValueId删除字典数数值
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int deleteData(SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 根据codeValueId集合批量删除字典数数值
	 * @param codeValueIds
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int deleteDataList(List codeValueIds, SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 虚拟删除 根据定义的列名删除
	 * @param ids
	 * @param sysCode
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	int deleteByIds(List ids,SysCode sysCode,String primaryKey);

	/**
	 *  根据条件删除
	 * @param example
	 * @param sysCode
	 * @return
	 */
	int deleteExampleData(Example example,SysCode sysCode);

	/**
	 * @Title:
	 * @Description: 查询全部字典数数值
	 * @return List<SysCode>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	List<SysCode> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个字典数数值
	 * @param example
	 * @return SysCode
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	SysCode selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询字典数数值
	 * @param example
	 * @return List<SysCode>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	List<SysCode> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过codeValueId查询字典数数值
	 * @param codeValueId
	 * @return SysCode
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	SysCode selectByPrimaryKey(Object codeValueId);

	/**
	 * @Title:
	 * @Description: 分页查询字典数数值
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysCode>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	PageInfoExtend<SysCode> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询字典数数值vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<SysCode>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-9 13:46:53
	 */
	PageInfoExtend<SysCodeVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	SysCodeVo selectSysCodeVoById(String codeValueId);
}
