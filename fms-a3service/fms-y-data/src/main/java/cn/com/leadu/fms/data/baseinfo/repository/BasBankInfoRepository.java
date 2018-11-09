package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoRepository
 * @Description: 银行账号维护Repository层
 * @date 2018-03-26
 */
public interface BasBankInfoRepository {

	/**
	 * @Title:
	 * @Description: 新增银行账号维护
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int insertData(BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 批量保存银行账号维护
	 * @param basBankInfos
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int insertDataList(List<BasBankInfo> basBankInfos);

	/**
	 * @Title:
	 * @Description: 修改银行账号维护
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByPrimaryKeyData(BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 批量修改银行账号维护
	 * @param basBankInfos
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByPrimaryKeyDataList(List<BasBankInfo> basBankInfos);

	/**
	 * @Title:
	 * @Description: 动态修改银行账号维护
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByPrimaryKeySelectiveData(BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 批量动态修改银行账号维护
	 * @param basBankInfos
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasBankInfo> basBankInfos);

	/**
	 * @Title:
	 * @Description: 根据条件修改银行账号维护
	 * @param basBankInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByExampleData(BasBankInfo basBankInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改银行账号维护
	 * @param basBankInfo
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int updateByExampleSelectiveData(BasBankInfo basBankInfo, Example example);

	/**
	 * @Title:
	 * @Description: 根据bankId删除银行账号维护
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int deleteData(BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 根据bankId集合批量删除银行账号维护
	 * @param bankIds
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int deleteDataList(List bankIds, BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除银行账号维护
	 * @param example
	 * @param basBankInfo
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	int deleteExampleData(Example example, BasBankInfo basBankInfo);

	/**
	 * @Title:
	 * @Description: 查询全部银行账号维护
	 * @return List<BasBankInfo>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	List<BasBankInfo> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个银行账号维护
	 * @param example
	 * @return BasBankInfo
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	BasBankInfo selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询银行账号维护
	 * @param example
	 * @return List<BasBankInfo>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	List<BasBankInfo> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过bankId查询银行账号维护
	 * @param bankId
	 * @return BasBankInfo
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	BasBankInfo selectByPrimaryKey(Object bankId);

	/**
	 * @Title:
	 * @Description: 分页查询银行账号维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasBankInfo>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	PageInfoExtend<BasBankInfo> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询银行账号维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasBankInfo>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	PageInfoExtend<BasBankInfoVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);


	/**
	 * @Title:
	 * @Description: 通过主键关联sys_group表查询bas_bank_info
	 * @param bankId
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-26 13:51:12
	 */
	public BasBankInfoVo selectBasBankInfoFromSysGroupById(String bankId);

}
