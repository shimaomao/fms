package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.LicenseIdxVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author license_idx
 * @ClassName: LicenseIdxRepository
 * @Description: 指标管理表Repository层
 */
public interface LicenseIdxRepository {

	/**
	 * @Title:
	 * @Description: 新增指标管理表
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int insertData(LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 批量保存指标管理表
	 * @param licenseIdxs
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int insertDataList(List<LicenseIdx> licenseIdxs);

	/**
	 * @Title:
	 * @Description: 修改指标管理表
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeyData(LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 批量修改指标管理表
	 * @param licenseIdxs
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeyDataList(List<LicenseIdx> licenseIdxs);

	/**
	 * @Title:
	 * @Description: 动态修改指标管理表
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeySelectiveData(LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 批量动态修改指标管理表
	 * @param licenseIdxs
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeySelectiveDataList(List<LicenseIdx> licenseIdxs);

	/**
	 * @Title:
	 * @Description: 根据条件修改指标管理表
	 * @param licenseIdx
	 * @param example
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByExampleData(LicenseIdx licenseIdx, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改指标管理表
	 * @param licenseIdx
	 * @param example
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByExampleSelectiveData(LicenseIdx licenseIdx, Example example);

	/**
	 * @Title:
	 * @Description: 根据licenseIdxId删除指标管理表
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int deleteData(LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 根据licenseIdxId集合批量删除指标管理表
	 * @param licenseIdxIds
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int deleteDataList(List licenseIdxIds, LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除指标管理表
	 * @param example
	 * @param licenseIdx
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int deleteExampleData(Example example, LicenseIdx licenseIdx);

	/**
	 * @Title:
	 * @Description: 查询全部指标管理表
	 * @return List<LicenseIdx>
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	List<LicenseIdx> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个指标管理表
	 * @param example
	 * @return LicenseIdx
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	LicenseIdx selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询指标管理表
	 * @param example
	 * @return List<LicenseIdx>
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	List<LicenseIdx> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过licenseIdxId查询指标管理表
	 * @param licenseIdxId
	 * @return LicenseIdx
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	LicenseIdx selectByPrimaryKey(Object licenseIdxId);

	/**
	 * @Title:
	 * @Description: 分页查询指标管理表
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<LicenseIdx>
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	PageInfoExtend<LicenseIdx> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询指标管理表vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改指标管理表
	 * @param licenseIdx,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeyData(LicenseIdx licenseIdx, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改指标管理表,并进行排他
	 * @param licenseIdxs
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeyDataList(List<LicenseIdx> licenseIdxs, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改指标管理表,并进行排他
	 * @param licenseIdx
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(LicenseIdx licenseIdx, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改指标管理表,并进行排他
	 * @param licenseIdxs
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByPrimaryKeySelectiveDataList(List<LicenseIdx> licenseIdxs, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改指标管理表,并进行排他
	 * @param licenseIdx
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByExampleData(LicenseIdx licenseIdx, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改指标管理表,并进行排他
	 * @param licenseIdx
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author license_idx
	 * @date 2018-9-11 11:38:16
	 */
	int updateByExampleSelectiveData(LicenseIdx licenseIdx, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 通过licenseIdxId查询指标管理表
	 * @param licenseIdxId
	 * @return LicenseIdx
	 * @throws
	 * @author license_idx
	 * @date 2018-9-12 13:38:16
	 */
	LicenseIdxVo selectVoByPrimaryKey(String licenseIdxId);

	/**
	 * @Title:
	 * @Description:  根据licenseIdxNo获取指标管理表是否存在
	 * @param licenseIdxNo
	 * @return
	 * @throws
	 * @author license_idx
	 * @date 2018-9-13 11:38:16
	 */
	LicenseIdxVo selectLicenseIdxNoByPrimaryKey(String licenseIdxNo);

}
