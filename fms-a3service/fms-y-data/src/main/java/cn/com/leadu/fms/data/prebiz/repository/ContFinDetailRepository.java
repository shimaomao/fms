package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailRepository
 * @Description: 合同融资费用明细Repository层
 * @date 2018-03-23
 */
public interface ContFinDetailRepository {

	/**
	 * @Title:
	 * @Description: 新增合同融资费用明细
	 * @param contFinDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int insertData(ContFinDetail contFinDetail);

	/**
	 * @Title:
	 * @Description: 批量保存合同融资费用明细
	 * @param contFinDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int insertDataList(List<ContFinDetail> contFinDetails);

	/**
	 * @Title:
	 * @Description: 修改合同融资费用明细
	 * @param contFinDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByPrimaryKeyData(ContFinDetail contFinDetail);

	/**
	 * @Title:
	 * @Description: 批量修改合同融资费用明细
	 * @param contFinDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByPrimaryKeyDataList(List<ContFinDetail> contFinDetails);

	/**
	 * @Title:
	 * @Description: 动态修改合同融资费用明细
	 * @param contFinDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByPrimaryKeySelectiveData(ContFinDetail contFinDetail);

	/**
	 * @Title:
	 * @Description: 批量动态修改合同融资费用明细
	 * @param contFinDetails
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContFinDetail> contFinDetails);

	/**
	 * @Title:
	 * @Description: 根据条件修改合同融资费用明细
	 * @param contFinDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByExampleData(ContFinDetail contFinDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改合同融资费用明细
	 * @param contFinDetail
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int updateByExampleSelectiveData(ContFinDetail contFinDetail, Example example);

	/**
	 * @Title:
	 * @Description: 根据contFinDetailId删除合同融资费用明细
	 * @param contFinDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int deleteData(ContFinDetail contFinDetail);

	/**
	 * @Title:
	 * @Description: 根据contFinDetailId集合批量删除合同融资费用明细
	 * @param contFinDetailIds
	 * @param contFinDetail
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	int deleteDataList(List contFinDetailIds, ContFinDetail contFinDetail);

	/**
	 * @Title:
	 * @Description: 查询全部合同融资费用明细
	 * @return List<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	List<ContFinDetail> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个合同融资费用明细
	 * @param example
	 * @return ContFinDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	ContFinDetail selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询合同融资费用明细
	 * @param example
	 * @return List<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	List<ContFinDetail> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contFinDetailId查询合同融资费用明细
	 * @param contFinDetailId
	 * @return ContFinDetail
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	ContFinDetail selectByPrimaryKey(Object contFinDetailId);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资费用明细
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	PageInfoExtend<ContFinDetail> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资费用明细vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
	PageInfoExtend<ContFinDetail> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询合同融资费用明细vo
	 * @param contNo
	 * @return PageInfoExtend<ContFinDetail>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-23 18:47:10
	 */
    List<ContFinDetailVo> selectContFinDetailVosByContNo(String contNo);

	/**
	 * @param contNo
	 * @Description: 根据合同编号查询融资费用明细（附带付款表）
	 * @param:
	 * @return:
	 * @Author: yangyiquan
	 * @Date: 2018/5/25 14:24
	 */
    List<ContFinPayVo> selectContFinDetailsWithContPay(String contNo);
}
