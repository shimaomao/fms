package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorRepository
 * @Description: 产品利率Repository层
 * @date 2018-03-27
 */
public interface ProdIntrstFactorRepository {

	/**
	 * @Title:
	 * @Description: 新增产品利率
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int insertData(ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 批量保存产品利率
	 * @param prodIntrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int insertDataList(List<ProdIntrstFactor> prodIntrstFactors);

	/**
	 * @Title:
	 * @Description: 修改产品利率
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByPrimaryKeyData(ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 批量修改产品利率
	 * @param prodIntrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByPrimaryKeyDataList(List<ProdIntrstFactor> prodIntrstFactors);

	/**
	 * @Title:
	 * @Description: 动态修改产品利率
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByPrimaryKeySelectiveData(ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品利率
	 * @param prodIntrstFactors
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdIntrstFactor> prodIntrstFactors);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品利率
	 * @param prodIntrstFactor
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByExampleData(ProdIntrstFactor prodIntrstFactor, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品利率
	 * @param prodIntrstFactor
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int updateByExampleSelectiveData(ProdIntrstFactor prodIntrstFactor, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodIntrstFactorId删除产品利率
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int deleteData(ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 根据prodIntrstFactorId集合批量删除产品利率
	 * @param prodIntrstFactorIds
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int deleteDataList(List prodIntrstFactorIds, ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品利率
	 * @param example
	 * @param prodIntrstFactor
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	int deleteExampleData(Example example, ProdIntrstFactor prodIntrstFactor);

	/**
	 * @Title:
	 * @Description: 查询全部产品利率
	 * @return List<ProdIntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	List<ProdIntrstFactor> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品利率
	 * @param example
	 * @return ProdIntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	ProdIntrstFactor selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品利率
	 * @param example
	 * @return List<ProdIntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	List<ProdIntrstFactor> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodIntrstFactorId查询产品利率
	 * @param prodIntrstFactorId
	 * @return ProdIntrstFactor
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	ProdIntrstFactor selectByPrimaryKey(Object prodIntrstFactorId);

	/**
	 * @Title:
	 * @Description: 分页查询产品利率
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdIntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	PageInfoExtend<ProdIntrstFactor> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品利率vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdIntrstFactor>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:45:27
	 */
	PageInfoExtend<ProdIntrstFactor> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据机构代码等查询条件，取得产品方案信息
	 * @param product 产品方案代码
	 * @return List<ProdIntrstFactorVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-27 15:21:58
	 */
	List<ProdIntrstFactorVo> selectProdIntrstFactorListByProduct(String product);

}
