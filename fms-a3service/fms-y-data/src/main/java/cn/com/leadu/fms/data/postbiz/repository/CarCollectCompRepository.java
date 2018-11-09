package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompRepository
 * @Description: 收车机构维护Repository层
 * @date 2018-05-22
 */
public interface CarCollectCompRepository {

	/**
	 * @Title:
	 * @Description: 新增收车机构维护
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int insertData(CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 批量保存收车机构维护
	 * @param carCollectComps
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int insertDataList(List<CarCollectComp> carCollectComps);

	/**
	 * @Title:
	 * @Description: 修改收车机构维护
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByPrimaryKeyData(CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 批量修改收车机构维护
	 * @param carCollectComps
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByPrimaryKeyDataList(List<CarCollectComp> carCollectComps);

	/**
	 * @Title:
	 * @Description: 动态修改收车机构维护
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByPrimaryKeySelectiveData(CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 批量动态修改收车机构维护
	 * @param carCollectComps
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByPrimaryKeySelectiveDataList(List<CarCollectComp> carCollectComps);

	/**
	 * @Title:
	 * @Description: 根据条件修改收车机构维护
	 * @param carCollectComp
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByExampleData(CarCollectComp carCollectComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改收车机构维护
	 * @param carCollectComp
	 * @param example
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int updateByExampleSelectiveData(CarCollectComp carCollectComp, Example example);

	/**
	 * @Title:
	 * @Description: 根据carCollectCompId删除收车机构维护
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int deleteData(CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 根据carCollectCompId集合批量删除收车机构维护
	 * @param carCollectCompIds
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int deleteDataList(List carCollectCompIds,CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除收车机构维护
	 * @param example
	 * @param carCollectComp
	 * @return int
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	int deleteExampleData(Example example,CarCollectComp carCollectComp);

	/**
	 * @Title:
	 * @Description: 查询全部收车机构维护
	 * @return List<CarCollectComp>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	List<CarCollectComp> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个收车机构维护
	 * @param example
	 * @return CarCollectComp
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	CarCollectComp selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询收车机构维护
	 * @param example
	 * @return List<CarCollectComp>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	List<CarCollectComp> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过carCollectCompId查询收车机构维护
	 * @param carCollectCompId
	 * @return CarCollectComp
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	CarCollectComp selectByPrimaryKey(Object carCollectCompId);

	/**
	 * @Title:
	 * @Description: 分页查询收车机构维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CarCollectComp>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	PageInfoExtend<CarCollectComp> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询收车机构维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

}
