package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.dao.BasPartnerDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasPartnerRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasPartnerRepositoryImpl
 * @Description: 经销商信息维护Repository 实现层
 * @date 2018-03-17
 */
@Repository
public class BasPartnerRepositoryImpl extends AbstractBaseRepository<BasPartnerDao, BasPartner> implements BasPartnerRepository {

    /**
     * @Title:
     * @Description: 新增经销商信息维护
     * @param basPartner
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int insertData(BasPartner basPartner) {
        return super.insert(basPartner);
    }

    /**
     * @Title:
     * @Description: 批量保存经销商信息维护
     * @param basPartners
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int insertDataList(List<BasPartner> basPartners){
        return super.insertListByJdbcTemplate(basPartners);
    }

    /**
     * @Title:
     * @Description: 修改经销商信息维护
     * @param basPartner
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int updateByPrimaryKeyData(BasPartner basPartner) {
        return super.updateByPrimaryKey(basPartner);
    }

    /**
     * @Title:
     * @Description: 批量修改经销商信息维护
     * @param basPartners
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasPartner> basPartners){
        return super.updateListByPrimaryKey(basPartners);
    }

    /**
     * @Title:
     * @Description: 动态修改经销商信息维护
     * @param basPartner
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasPartner basPartner) {
        return super.updateByPrimaryKeySelective(basPartner);
    }

    /**
     * @Title:
     * @Description: 批量动态修改经销商信息维护
     * @param basPartners
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasPartner> basPartners) {
        return super.updateListByPrimaryKeySelective(basPartners);
    }

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
    @Override
    public int updateByExampleData(BasPartner basPartner, Example example) {
        return super.updateByExample(basPartner,example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(BasPartner basPartner, Example example){
        return super.updateByExampleSelective(basPartner,example);
    }
    
    /**
     * @Title:
     * @Description: 根据partnerId删除经销商信息维护
     * @param basPartner
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public int deleteData(BasPartner basPartner) {
        return super.delete(basPartner);
    }

    /**
     * @Title:
     * @Description: 根据partnerId集合批量删除经销商信息维护
     * @param basPartner
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    public int deleteDataList(List partnerIds,BasPartner basPartner){
        return super.deleteByIds(partnerIds,basPartner);
    }

    /**
     * @Title:
     * @Description: 查询全部经销商信息维护
     * @return List<BasPartner>
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public List<BasPartner> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个经销商信息维护
     * @param example
     * @return BasPartner
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public BasPartner selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询经销商信息维护
     * @param example
     * @return List<BasPartner>
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public List<BasPartner> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过partnerId查询经销商信息维护
     * @param partnerId
     * @return BasPartner
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public BasPartner selectByPrimaryKey(Object partnerId) {
        return super.selectByPrimaryKey(partnerId);
    }

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
    @Override
    public PageInfoExtend<BasPartner> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 查询详情BasPartner
     * @param partnerId
     * @return BasPartner
     * @throws
     * @author huchenghao
     * @date 2018-3-17 10:35:33
     */
    @Override
    public BasPartnerVo findBasPartnerByPartnerId(String partnerId){
        //1默认为行政组织
        return baseDao.findBasPartnerByPartnerId("1",partnerId);
    }
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
    public PageInfoExtend<BasPartner> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
