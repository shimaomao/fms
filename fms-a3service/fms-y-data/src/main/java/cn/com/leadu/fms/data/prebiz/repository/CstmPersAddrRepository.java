package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrRepository
 * @Description: 客户个人地址信息Repository层
 * @date 2018-03-26
 */
public interface CstmPersAddrRepository {

	/**
	 * @Title:
	 * @Description: 新增客户个人地址信息
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int insertData(CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 批量保存客户个人地址信息
	 * @param cstmPersAddrs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int insertDataList(List<CstmPersAddr> cstmPersAddrs);

	/**
	 * @Title:
	 * @Description: 修改客户个人地址信息
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByPrimaryKeyData(CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 批量修改客户个人地址信息
	 * @param cstmPersAddrs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByPrimaryKeyDataList(List<CstmPersAddr> cstmPersAddrs);

	/**
	 * @Title:
	 * @Description: 动态修改客户个人地址信息
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByPrimaryKeySelectiveData(CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户个人地址信息
	 * @param cstmPersAddrs
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<CstmPersAddr> cstmPersAddrs);

	/**
	 * @Title:
	 * @Description: 根据条件修改客户个人地址信息
	 * @param cstmPersAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByExampleData(CstmPersAddr cstmPersAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改客户个人地址信息
	 * @param cstmPersAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int updateByExampleSelectiveData(CstmPersAddr cstmPersAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据persAddrId删除客户个人地址信息
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int deleteData(CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 根据persAddrId集合批量删除客户个人地址信息
	 * @param persAddrIds
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int deleteDataList(List persAddrIds, CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除客户个人地址信息
	 * @param example
	 * @param cstmPersAddr
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	int deleteExampleData(Example example, CstmPersAddr cstmPersAddr);

	/**
	 * @Title:
	 * @Description: 查询全部客户个人地址信息
	 * @return List<CstmPersAddr>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	List<CstmPersAddr> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户个人地址信息
	 * @param example
	 * @return CstmPersAddr
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	CstmPersAddr selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户个人地址信息
	 * @param example
	 * @return List<CstmPersAddr>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	List<CstmPersAddr> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过persAddrId查询客户个人地址信息
	 * @param persAddrId
	 * @return CstmPersAddr
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	CstmPersAddr selectByPrimaryKey(Object persAddrId);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人地址信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersAddr>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	PageInfoExtend<CstmPersAddr> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询客户个人地址信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<CstmPersAddr>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-3-26 21:06:53
	 */
	PageInfoExtend<CstmPersAddr> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
