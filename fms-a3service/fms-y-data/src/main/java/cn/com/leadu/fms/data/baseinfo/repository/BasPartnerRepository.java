package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasPartnerRepository
 * @Description: 经销商信息维护Repository层
 * @date 2018-03-17
 */
public interface BasPartnerRepository {

	/**
	 * @Title:
	 * @Description: 新增经销商信息维护
	 * @param basPartner
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int insertData(BasPartner basPartner);

	/**
	 * @Title:
	 * @Description: 批量保存经销商信息维护
	 * @param basPartners
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int insertDataList(List<BasPartner> basPartners);

	/**
	 * @Title:
	 * @Description: 修改经销商信息维护
	 * @param basPartner
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByPrimaryKeyData(BasPartner basPartner);

	/**
	 * @Title:
	 * @Description: 批量修改经销商信息维护
	 * @param basPartners
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByPrimaryKeyDataList(List<BasPartner> basPartners);

	/**
	 * @Title:
	 * @Description: 动态修改经销商信息维护
	 * @param basPartner
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByPrimaryKeySelectiveData(BasPartner basPartner);

	/**
	 * @Title:
	 * @Description: 批量动态修改经销商信息维护
	 * @param basPartners
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasPartner> basPartners);

	/**
	 * @Title:
	 * @Description: 根据条件修改经销商信息维护
	 * @param basPartner
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByExampleData(BasPartner basPartner, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改经销商信息维护
	 * @param basPartner
	 * @param example
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int updateByExampleSelectiveData(BasPartner basPartner, Example example);

	/**
	 * @Title:
	 * @Description: 根据partnerId删除经销商信息维护
	 * @param basPartner
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int deleteData(BasPartner basPartner);

	/**
	 * @Title:
	 * @Description: 根据partnerId集合批量删除经销商信息维护
	 * @param partnerIds
	 * @param basPartner
	 * @return int
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	int deleteDataList(List partnerIds, BasPartner basPartner);

	/**
	 * @Title:
	 * @Description: 查询全部经销商信息维护
	 * @return List<BasPartner>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	List<BasPartner> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个经销商信息维护
	 * @param example
	 * @return BasPartner
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	BasPartner selectOneByExample(Example partnerId);
	/**
	 * @Title:
	 * @Description: 通过条件查询一个经销商信息维护
	 * @param partnerId
	 * @return BasPartner
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	BasPartnerVo findBasPartnerByPartnerId(String partnerId);
	/**
	 * @Title:
	 * @Description: 通过条件批量查询经销商信息维护
	 * @param example
	 * @return List<BasPartner>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	List<BasPartner> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过partnerId查询经销商信息维护
	 * @param partnerId
	 * @return BasPartner
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	BasPartner selectByPrimaryKey(Object partnerId);

	/**
	 * @Title:
	 * @Description: 分页查询经销商信息维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasPartner>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	PageInfoExtend<BasPartner> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询经销商信息维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasPartner>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	PageInfoExtend<BasPartner> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
