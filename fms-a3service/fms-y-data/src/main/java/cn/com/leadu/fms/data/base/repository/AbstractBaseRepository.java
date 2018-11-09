package cn.com.leadu.fms.data.base.repository;

import cn.com.leadu.fms.common.constant.MarkedWordsConstants;
import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.common.constant.enums.sql.TotalFlags;
import cn.com.leadu.fms.common.entity.BaseEntity;
import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.exception.FmsRuntimeException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.ReflectUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.mapperhelper.EntityHelper;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: AbstractBaseRepository
 * @Description: 抽象仓库访问基类
 * @author qiaohao
 * @date 2017/11/2
 */
@Slf4j
@Data
public abstract class AbstractBaseRepository<T extends BaseDao, K extends Entity> {

	@Autowired
	public T baseDao;

	@Autowired
	public JdbcTemplateRepository jdbcTemplateRepository;

	/**
	 * @Fields : 分页默认显示条数
	 */
	@Value("${page.pageSize}")
	private int pageSize;

	/**
	 * @Title:
	 * @Description:   录入数据并返回回去
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:48:47
	 */
	public int insert(K entity) {
		return baseDao.insert(entity);
	}

	/**
	 * @Title:
	 * @Description:   批量录入数据
	 * @param entityList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:49:01
	 */
	public int insertListByJdbcTemplate(List<K> entityList){
		return jdbcTemplateRepository.insertList(entityList);
	}

	/**
	 * @Title:
	 * @Description:   录入数据，只录入实体中属性不为null数据
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:49:22
	 */
	public int insertSelective(K entity) {
		return baseDao.insertSelective(entity);
	}

	/**
	 * @Title:
	 * @Description: 根据主键更新数据
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:04
	 */
	public int updateByPrimaryKey(K entity) {
		return baseDao.updateByPrimaryKey(entity);
	}

	/**
	 * @Title:
	 * @Description: 根据主键更新数据,并进行排他
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:04
	 */
	public int updateByPrimaryKey(K entity,boolean exclusive) {
		if(!exclusive)
			return updateByPrimaryKey(entity);
		Class clazz = (Class <K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(clazz));
		if(ArrayUtils.isNullOrLengthZero(pkColumnList))
			throw new FmsServiceException(MarkedWordsConstants.SQL_GET_ID_ERROR_MESSAGE);
		else{
			Example example = SqlUtil.newExample(clazz);
			setIdValue(example,pkColumnList,entity,clazz);
			return updateByExample(entity,example,exclusive);
		}
	}

	/**
	 * @Title:
	 * @Description:   根据主键批量更新数据
	 * @param entityList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/26 12:02:08
	 */
	public int updateListByPrimaryKey(List<K> entityList){
		return jdbcTemplateRepository.updateList(entityList,false,false);
	}

	/**
	 * @Title:
	 * @Description:   根据主键批量更新数据,并进行排他
	 * @param entityList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/26 12:02:08
	 */
	public int updateListByPrimaryKey(List<K> entityList,boolean exclusive){
		return jdbcTemplateRepository.updateList(entityList,false,exclusive);
	}

	/**
	 * @Title:
	 * @Description:   根据主键更新数据,只更新实体中不为null的数据
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:31
	 */
	public int updateByPrimaryKeySelective(K entity) {
		return baseDao.updateByPrimaryKeySelective(entity);
	}


	/**
	 * @Title:
	 * @Description:   根据主键更新数据,只更新实体中不为null的数据,并进行排他
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:31
	 */
	public int updateByPrimaryKeySelective(K entity,boolean exclusive) {
		if(!exclusive)
			return updateByPrimaryKeySelective(entity);
		Class clazz = (Class <K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(clazz));
		if(ArrayUtils.isNullOrLengthZero(pkColumnList))
			throw new FmsServiceException(MarkedWordsConstants.SQL_GET_ID_ERROR_MESSAGE);
		else{
			Example example = SqlUtil.newExample(clazz);
			setIdValue(example,pkColumnList,entity,clazz);
			return updateByExampleSelective(entity,example,exclusive);
		}
	}


	/**
	 * @Title:
	 * @Description:   根据主键批量更新数据,只更新实体中不为null的数据
	 * @param entityList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:31
	 */
	public int updateListByPrimaryKeySelective(List<K> entityList) {
		return jdbcTemplateRepository.updateList(entityList,true,false);
	}

	/**
	 * @Title:
	 * @Description:   根据主键批量更新数据,只更新实体中不为null的数据,并进行排他
	 * @param entityList
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:50:31
	 */
	public int updateListByPrimaryKeySelective(List<K> entityList, boolean exclusive) {
		return jdbcTemplateRepository.updateList(entityList,true,exclusive);
	}

	/**
	 * @Title:
	 * @Description: 根据组合条件更新实体
	 * @param entity
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:51:05
	 */
	public int updateByExample(K entity, Example example) {
		checkUpdateExampleNullOrTrim(example);
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		return baseDao.updateByExample(entity, example);
	}

	/**
	 * @Title:
	 * @Description: 根据组合条件更新实体,并进行排他
	 * @param entity
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:51:05
	 */
	public int updateByExample(K entity, Example example, boolean exclusive) {
		checkUpdateExampleNullOrTrim(example);
		if(!exclusive)
			return updateByExample(entity, example);
		if(entity.getUpdateLastTime() == null)
			throw new FmsServiceException(MarkedWordsConstants.SQL_GET_UPDATE_TIME_LAST_ERROR_MESSAGE);
		List<Example.Criteria> criteriaList = example.getOredCriteria();
		if(ArrayUtils.isNullOrLengthZero(criteriaList))
			example.createCriteria().andEqualTo(SqlUtil.ENTITY_UPDATE_TIME, DateUtils.dateToStr(entity.getUpdateLastTime(),DateUtils.formatStr_yyyyMMddHHmmssSSS));
		else {
			for (Example.Criteria criteria : criteriaList) {
				criteria.andEqualTo(SqlUtil.ENTITY_UPDATE_TIME, DateUtils.dateToStr(entity.getUpdateLastTime(),DateUtils.formatStr_yyyyMMddHHmmssSSS));
			}
		}
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		int result = baseDao.updateByExample(entity, example);
        if(result == 0)
            throw new FmsServiceException(MarkedWordsConstants.SQL_EXCLUSIVE_ERROR_MESSAGE);
		return result;
	}

	/**
	 * @Title:
	 * @Description:   根据组合条件更新实体,只更新实体中属性不为null的数据
	 * @param entity
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:51:33
	 */
	public int updateByExampleSelective(K entity, Example example) {
		checkUpdateExampleNullOrTrim(example);
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		return baseDao.updateByExampleSelective(entity, example);
	}

	/**
	 * @Title:
	 * @Description:   根据组合条件更新实体,只更新实体中属性不为null的数据
	 * @param entity
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:51:33
	 */
	public int updateByExampleSelective(K entity, Example example,boolean exclusive) {
		checkUpdateExampleNullOrTrim(example);
		if(!exclusive)
			return updateByExampleSelective(entity, example);
		if(entity.getUpdateLastTime() == null)
			throw new FmsServiceException(MarkedWordsConstants.SQL_GET_UPDATE_TIME_LAST_ERROR_MESSAGE);
		List<Example.Criteria> criteriaList = example.getOredCriteria();
		if(ArrayUtils.isNullOrLengthZero(criteriaList))
			example.createCriteria().andEqualTo(SqlUtil.ENTITY_UPDATE_TIME,DateUtils.dateToStr(entity.getUpdateLastTime(),DateUtils.formatStr_yyyyMMddHHmmssSSS));
		else {
			for (Example.Criteria criteria : criteriaList) {
				criteria.andEqualTo(SqlUtil.ENTITY_UPDATE_TIME, DateUtils.dateToStr(entity.getUpdateLastTime(),DateUtils.formatStr_yyyyMMddHHmmssSSS));
			}
		}
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		int result = baseDao.updateByExampleSelective(entity, example);
		if(result == 0)
		    throw new FmsServiceException(MarkedWordsConstants.SQL_EXCLUSIVE_ERROR_MESSAGE);
		return result;
	}

	/**
	 * @Title:
	 * @Description: 物理删除一条数据
	 * @param:  entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/16  10:08
	 */
	public int deletePhysicsEntity(K entity){
		return baseDao.delete(entity);
	}

	/**
	 * @Title:
	 * @Description: 物理批量删除实体数据
	 * @param:  entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/16  10:08
	 */
	public int deletePhysicsEntityList(List ids){
		Class clazz = (Class <K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(clazz));
		if(ArrayUtils.isNullOrLengthZero(pkColumnList) || pkColumnList.size() != 1)
			throw new FmsRuntimeException(MarkedWordsConstants.SQL_ID_ONLY_ERROR_MESSAGE);
		Example example = SqlUtil.newExample(clazz);
		example.createCriteria().andIn(pkColumnList.get(0).getProperty(),ids);
		checkUpdateExampleNullOrTrim(example);
		return baseDao.deleteByExample(example);
	}

	/**
	 * @Title:
	 * @Description:   根据主键删除数据 虚拟删除
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:52:13
	 */
	public int delete(K entity) {
		return baseDao.updateByPrimaryKeySelective(entity);
	}

	/**
	 * @Title:
	 * @Description:  根据组合条件虚拟删除数据
	 * @param example
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:52:29
	 */
	public int deleteByExample(Example example,K entity){
		checkUpdateExampleNullOrTrim(example);
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		return baseDao.updateByExampleSelective(entity,example);
	}

	/**
	 * @Title:
	 * @Description:  虚拟删除 根据id删除
	 * @param ids
	 * @param entity
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 03:50:19
	 */
	public int deleteByIds(List ids,K entity){
		if(ArrayUtils.isNotNullAndLengthNotZero(ids)) {
			Class clazz = (Class<K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
			List<EntityColumn> pkColumnList = new ArrayList<>(EntityHelper.getPKColumns(clazz));
			if (ArrayUtils.isNullOrLengthZero(pkColumnList) || pkColumnList.size() != 1)
				throw new FmsRuntimeException(MarkedWordsConstants.SQL_ID_ONLY_ERROR_MESSAGE);
			return deleteByIds(ids, entity, pkColumnList.get(0).getProperty());
		}
		return 0;
	}

	/**
	 * @Title:
	 * @Description:   虚拟删除 根据定义的列名删除
	 * @param ids
	 * @param entity
	 * @param primaryKey
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:55:42
	 */
	public int deleteByIds(List ids,K entity,String primaryKey){
		if(ArrayUtils.isNotNullAndLengthNotZero(ids) && entity != null) {
			Example example = SqlUtil.newExample(entity.getClass());
			example.createCriteria().andIn(primaryKey, ids);
			checkUpdateExampleNullOrTrim(example);
			SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
			return baseDao.updateByExampleSelective(entity, example);
		}
		return 0;
	}

	/**
	 * @Title:
	 * @Description:   查询所有数据
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:56:40
	 */
	public List<K> selectAll() {
        Class clazz = (Class <K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Example example = SqlUtil.newExample(clazz);
        example.createCriteria();
        SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
        return baseDao.selectByExample(example);
	}

	/**
	 * @Title:
	 * @Description:   根据组合条件查询第一条数据
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:56:58
	 */
	public K selectOneByExample(Example example) {
	    if(ArrayUtils.isNullOrLengthZero(example.getOredCriteria()))
	        example.createCriteria();
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		List results = baseDao.selectByExample(example);
		if (ArrayUtils.isNotNullAndLengthNotZero(results))
			return (K) results.get(0);
		return null;
	}

	/**
	 * @Title:
	 * @Description:   根据主键查询数据
	 * @param id
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:57:14
	 */
	public K selectByPrimaryKey(Object id){
		Object result = baseDao.selectByPrimaryKey(id);
		if(result instanceof BaseEntity){
			BaseEntity entity = (BaseEntity)result;
			//如果状态是删除 则返回空回去
			if(DeleteFlags.NOT_EXIST.getFlag().equals(entity.getDelFlag()))
				return null;
		}
		return (K)result;
	}

	/**
	 * @Title:
	 * @Description:   根据组合条件查询数据
	 * @param example
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/24 04:57:36
	 */
	public List<K> selectListByExample(Example example) {
        if(ArrayUtils.isNullOrLengthZero(example.getOredCriteria()))
            example.createCriteria();
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		return baseDao.selectByExample(example);
	}

	/**
	 * @Title:
	 * @Description: 通用分页
	 * @param example,pageQuery
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/01/09 04:49:17
	 */
	public PageInfoExtend<K> selectListByExamplePage(Example example,PageQuery pageQuery){
        if(ArrayUtils.isNullOrLengthZero(example.getOredCriteria()))
            example.createCriteria();
		SqlUtil.andEqualToDeleteExist(example.getOredCriteria());
		return getPageInfo(example,pageQuery);
	}

	/**
	 * @Title:
	 * @Description: 通用分页 del_flag 放在外围
	 * @param example,pageQuery
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/01/09 04:49:17
	 */
	public PageInfoExtend<K> selectListByExamplePageForDel(Example example,PageQuery pageQuery){
		if(ArrayUtils.isNullOrLengthZero(example.getOredCriteria()))
			example.createCriteria();
		SqlUtil.andEqualToDeleteExist(example);
		return getPageInfo(example,pageQuery);
	}

	/**
	 * @Title:
	 * @Description: 分页封装
	 * @param example,pageQuery
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/01/09 04:49:17
	 */
	private PageInfoExtend<K> getPageInfo(Example example,PageQuery pageQuery){
		PageInfoExtend<K> pageInfoExtend = new PageInfoExtend<K>();
		//传递的标识是否是分页 或者 限制了excel的最大数量
		if(pageQuery.getPageFlag() == null || PageFlags.PAGE.getFlag().equals(pageQuery.getPageFlag()) || pageQuery.getExcelDataMax() != null){
			//如果限制了excel的最大数量则做赋值处理
			if(pageQuery.getExcelDataMax() != null) {
				setExcelDataMaxParam(pageQuery);
				setClass(pageInfoExtend);
			}
			PageInfo<K> pageInfo = PageHelper.startPage(pageQuery.getCurrenPage(),pageQuery.getPageSize()==null?pageSize:pageQuery.getPageSize())
					.doSelectPageInfo(new ISelect() {
						@Override
						public void doSelect() {
							baseDao.selectByExample(example);
						}
					});
			setPageInfoExtend(pageInfo,pageInfoExtend);
		}else{
			//不分页则全部查询
			List<K> results = baseDao.selectByExample(example);
			setPageInfoExtend(results,pageInfoExtend);
			setClass(pageInfoExtend);
		}
		pageInfoExtend.setDraw(pageQuery.getDraw());
		return pageInfoExtend;
	}

	/**
	 * @Title:
	 * @Description: 通用多表分页
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/02/12 04:40:51
	 */
	public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
		PageInfoExtend pageInfoExtend = new PageInfoExtend();
		//传递的标识是否是分页 或者 限制了excel的最大数量
		if(pageQuery.getPageFlag() == null || PageFlags.PAGE.getFlag().equals(pageQuery.getPageFlag()) || pageQuery.getExcelDataMax() != null){
			//如果限制了excel的最大数量则做赋值处理
			if(pageQuery.getExcelDataMax() != null) {
				setExcelDataMaxParam(pageQuery);
				setClass(pageInfoExtend,getBaseDaoMethodParamClassName(methodName,param));
			}
			PageInfo pageInfo = PageHelper.startPage(pageQuery.getCurrenPage(),pageQuery.getPageSize())
					.doSelectPageInfo(new ISelect() {
						@Override
						public void doSelect() {
							try {
								Method method = baseDao.getClass().getDeclaredMethod(methodName, param.getClass());
								method.invoke(baseDao, param);
							}catch (Exception ex){
                                log.error(ex.getMessage());
								ex.printStackTrace();
								throw  new FmsServiceException("查询失败");
							}
						}
					});
			setPageInfoExtend(pageInfo,pageInfoExtend);
			//是否有合计行
			if(TotalFlags.TOTAL.getFlag().equals(pageQuery.getTotalFlag())) {
				try {
					Method methodAll = baseDao.getClass().getDeclaredMethod(methodName, param.getClass());
					Object resultAll = methodAll.invoke(baseDao, param);
					if (resultAll != null) {
						List results = (List) resultAll;
						pageInfoExtend.setAll(results);
					}
				} catch (Exception ex) {
					log.error(ex.getMessage());
					ex.printStackTrace();
					throw new FmsServiceException("查询失败");
				}
			}

		}else{
			//不分页则全部查询
			try {
				Method method = baseDao.getClass().getDeclaredMethod(methodName, param.getClass());
				Object result = method.invoke(baseDao, param);
				if(result != null) {
					List results = (List) result;
					setPageInfoExtend(results,pageInfoExtend);
				}
				setClass(pageInfoExtend,getBaseDaoMethodParamClassName(methodName,param));
			}catch (Exception ex){
                log.error(ex.getMessage());
				ex.printStackTrace();
				throw  new FmsServiceException("查询失败");
			}
		}
		pageInfoExtend.setDraw(pageQuery.getDraw());
		return pageInfoExtend;
	}

	/**
	 * @Title:
	 * @Description: 如果传递过来的excel最大数量不为空，则判定是生成excel，并限制查询的最大数量
	 * @param: pageQuery
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/24 0024 21:03
	 */
	private void setExcelDataMaxParam(PageQuery pageQuery){
		if(pageQuery.getExcelDataMax() != null) {
			pageQuery.setCurrenPage(1);
			pageQuery.setPageSize(pageQuery.getExcelDataMax());
		}
	}

	/**
	 * @Title:
	 * @Description: 获取父级方法的泛型
	 * @param: methodName
	 * @param: param
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/24 0024 21:01
	 */
	private String getBaseDaoMethodParamClassName(String methodName,Object param){
		try {
			if (ArrayUtils.isNullOrLengthZero(baseDao.getClass().getInterfaces()))
				throw new FmsServiceException("无法获取父级接口");
			Method interfaceMethod = baseDao.getClass().getInterfaces()[0].getDeclaredMethod(methodName, param.getClass());
			if (interfaceMethod == null)
				throw new FmsServiceException("无法获取父级值类型");
			if (interfaceMethod.getGenericReturnType() instanceof ParameterizedType) {
				Type[] types = ((ParameterizedType) interfaceMethod.getGenericReturnType()).getActualTypeArguments();// 强制转型为带参数的泛型类型
				if (types.length < 1)
					throw new FmsServiceException("无法获取值类型");
				else if (types.length > 1)
					throw new FmsServiceException("值类型过多");
				else {
					return types[0].getTypeName();
				}
			} else {
				throw new FmsServiceException("无法获取值类型");
			}
		}catch (Exception ex){
            log.error(ex.getMessage());
			ex.printStackTrace();
			throw new FmsServiceException("获取值类型失败");
		}
	}

	/**
	 * @Title:
	 * @Description: 封装参数
	 * @param: pageInfo
	 * @param: info
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/19 14:50
	 */
	private void setPageInfoExtend(PageInfo pageInfo,PageInfoExtend pageInfoExtend){
		pageInfoExtend.setData(pageInfo.getList());
		pageInfoExtend.setRecordsTotal(pageInfo.getTotal());
		pageInfoExtend.setRecordsFiltered(pageInfo.getTotal());
	}

	/**
	 * @Title:
	 * @Description: 封装参数
	 * @param: results
	 * @param: pageInfoExtend
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/4/19 14:50
	 */
	private void setPageInfoExtend(List results,PageInfoExtend pageInfoExtend){
		if(results != null) {
			pageInfoExtend.setData(results);
			pageInfoExtend.setRecordsTotal((long) results.size());
			pageInfoExtend.setRecordsFiltered((long) results.size());
		}
	}

	private void setClass(PageInfoExtend pageInfoExtend,Class clazz){
		pageInfoExtend.setClazz(clazz.toString().replace("class ",""));
	}

	private void setClass(PageInfoExtend pageInfoExtend,String clazz){
		pageInfoExtend.setClazz(clazz);
	}

	private void setClass(PageInfoExtend pageInfoExtend){
		Class clazz = (Class <K>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
		pageInfoExtend.setClazz(clazz.toString().replace("class ",""));
	}

	private void checkUpdateExampleNullOrTrim(Example example){
		if(example == null)
			throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_NOT_NULL_ERROR_MESSAGE);
		List<Example.Criteria> criteriaList = example.getOredCriteria();
		if(ArrayUtils.isNullOrLengthZero(criteriaList))
			throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERIA_NOT_EXIST_ERROR_MESSAGE);
		for(Example.Criteria criteria : criteriaList){
			List<Example.Criterion> criterionList = criteria.getAllCriteria();
			if(ArrayUtils.isNullOrLengthZero(criterionList))
				throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_NOT_EXIST_ERROR_MESSAGE);
			for(Example.Criterion criterion : criterionList){
				if(criteria == null)
					throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_NOT_EXIST_ERROR_MESSAGE);
				if(criterion.getValue() == null)
					throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_VALUE_NOT_EXIST_ERROR_MESSAGE);
				if(criterion.getValue() instanceof String){
					if(StringUtils.isTrimBlank(criterion.getValue()))
						throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_VALUE_NOT_EXIST_ERROR_MESSAGE);
				} else if(criterion.getValue() instanceof List){
					if(ArrayUtils.isNullOrLengthZero((List)criterion.getValue()))
						throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_VALUE_NOT_EXIST_ERROR_MESSAGE);
				} else if(criterion.getValue().getClass().isArray()){
					if(Array.getLength(criterion.getValue()) < 1)
						throw new FmsServiceException(MarkedWordsConstants.SQL_EXAMPLE_CRITERION_VALUE_NOT_EXIST_ERROR_MESSAGE);
				}
			}
		}
	}

	private void setIdValue(Example example,List<EntityColumn> pkColumnList,K entity,Class clazz){
		Example.Criteria criteria = example.createCriteria();
		for(EntityColumn entityColumn : pkColumnList){
			try {
				criteria.andEqualTo(entityColumn.getProperty(), ReflectUtils.getFieldValue(entityColumn.getProperty(),entity,clazz));
			} catch (Exception ex) {
				log.error(ex.getMessage());
				ex.printStackTrace();
				throw new FmsServiceException(MarkedWordsConstants.SQL_GET_ID_VALUE_ERROR_MESSAGE);
			}
		}
	}

}
