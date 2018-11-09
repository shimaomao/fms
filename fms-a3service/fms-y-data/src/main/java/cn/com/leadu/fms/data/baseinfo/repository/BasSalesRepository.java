package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.BasSales;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: BasSalesRepository
 * @Description: 实际销售方Repository层
 * @date 2018-05-03
 */
public interface BasSalesRepository {

	/**
	 * @Title:
	 * @Description: 新增实际销售方
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int insertData(BasSales basSales);

	/**
	 * @Title:
	 * @Description: 批量保存实际销售方
	 * @param basSaless
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int insertDataList(List<BasSales> basSaless);

	/**
	 * @Title:
	 * @Description: 修改实际销售方
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByPrimaryKeyData(BasSales basSales);

	/**
	 * @Title:
	 * @Description: 批量修改实际销售方
	 * @param basSaless
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByPrimaryKeyDataList(List<BasSales> basSaless);

	/**
	 * @Title:
	 * @Description: 动态修改实际销售方
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByPrimaryKeySelectiveData(BasSales basSales);

	/**
	 * @Title:
	 * @Description: 批量动态修改实际销售方
	 * @param basSaless
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasSales> basSaless);

	/**
	 * @Title:
	 * @Description: 根据条件修改实际销售方
	 * @param basSales
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByExampleData(BasSales basSales, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改实际销售方
	 * @param basSales
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int updateByExampleSelectiveData(BasSales basSales, Example example);

	/**
	 * @Title:
	 * @Description: 根据salesId删除实际销售方
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int deleteData(BasSales basSales);

	/**
	 * @Title:
	 * @Description: 根据salesId集合批量删除实际销售方
	 * @param salesIds
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int deleteDataList(List salesIds, BasSales basSales);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除实际销售方
	 * @param example
	 * @param basSales
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	int deleteExampleData(Example example, BasSales basSales);

	/**
	 * @Title:
	 * @Description: 查询全部实际销售方
	 * @return List<BasSales>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	List<BasSales> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个实际销售方
	 * @param example
	 * @return BasSales
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	BasSales selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询实际销售方
	 * @param example
	 * @return List<BasSales>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	List<BasSales> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过salesId查询实际销售方
	 * @param salesId
	 * @return BasSales
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	BasSales selectByPrimaryKey(Object salesId);

	/**
	 * @Title:
	 * @Description: 分页查询实际销售方
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasSales>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	PageInfoExtend<BasSales> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询实际销售方vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-3 11:23:02
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 根据salesId获取实际销售方
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	BasSalesVo selectBasSalesBysalesId(String salesId);

}
