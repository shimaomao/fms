package cn.com.leadu.fms.data.product.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstRepository
 * @Description: 产品利率Repository层
 * @date 2018-03-27
 */
public interface ProdIntrstRepository {

	/**
	 * @Title:
	 * @Description: 新增产品利率
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int insertData(ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 批量保存产品利率
	 * @param prodIntrsts
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int insertDataList(List<ProdIntrst> prodIntrsts);

	/**
	 * @Title:
	 * @Description: 修改产品利率
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByPrimaryKeyData(ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 批量修改产品利率
	 * @param prodIntrsts
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByPrimaryKeyDataList(List<ProdIntrst> prodIntrsts);

	/**
	 * @Title:
	 * @Description: 动态修改产品利率
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByPrimaryKeySelectiveData(ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 批量动态修改产品利率
	 * @param prodIntrsts
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByPrimaryKeySelectiveDataList(List<ProdIntrst> prodIntrsts);

	/**
	 * @Title:
	 * @Description: 根据条件修改产品利率
	 * @param prodIntrst
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByExampleData(ProdIntrst prodIntrst, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改产品利率
	 * @param prodIntrst
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int updateByExampleSelectiveData(ProdIntrst prodIntrst, Example example);

	/**
	 * @Title:
	 * @Description: 根据prodIntrstId删除产品利率
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int deleteData(ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 根据prodIntrstId集合批量删除产品利率
	 * @param prodIntrstIds
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int deleteDataList(List prodIntrstIds, ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除产品利率
	 * @param example
	 * @param prodIntrst
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	int deleteExampleData(Example example, ProdIntrst prodIntrst);

	/**
	 * @Title:
	 * @Description: 查询全部产品利率
	 * @return List<ProdIntrst>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	List<ProdIntrst> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个产品利率
	 * @param example
	 * @return ProdIntrst
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	ProdIntrst selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询产品利率
	 * @param example
	 * @return List<ProdIntrst>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	List<ProdIntrst> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过prodIntrstId查询产品利率
	 * @param prodIntrstId
	 * @return ProdIntrst
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	ProdIntrst selectByPrimaryKey(Object prodIntrstId);

	/**
	 * @Title:
	 * @Description: 分页查询产品利率
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ProdIntrst>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	PageInfoExtend<ProdIntrst> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询产品利率vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<ProdIntrst>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	PageInfoExtend<ProdIntrst> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);
	/**
	 * @Title:
	 * @Description: 查询最大的利率方案序号
	 * @param product
	 * @return String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-27 11:46:27
	 */
	String selectIntrstNoMax(String product);
}
