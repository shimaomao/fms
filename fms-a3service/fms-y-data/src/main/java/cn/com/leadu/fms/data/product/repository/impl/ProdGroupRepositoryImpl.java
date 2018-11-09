package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.product.dao.ProdGroupDao;
import cn.com.leadu.fms.data.product.repository.ProdGroupRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupRepositoryImpl
 * @Description: 产品方案机构权限Repository 实现层
 * @date 2018-04-05
 */
@Repository
public class ProdGroupRepositoryImpl extends AbstractBaseRepository<ProdGroupDao, ProdGroup> implements ProdGroupRepository {

    /**
     * @Title:
     * @Description: 新增产品方案机构权限
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int insertData(ProdGroup prodGroup) {
        return super.insert(prodGroup);
    }

    /**
     * @Title:
     * @Description: 批量保存产品方案机构权限
     * @param prodGroups
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int insertDataList(List<ProdGroup> prodGroups){
        return super.insertListByJdbcTemplate(prodGroups);
    }

    /**
     * @Title:
     * @Description: 修改产品方案机构权限
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int updateByPrimaryKeyData(ProdGroup prodGroup) {
        return super.updateByPrimaryKey(prodGroup);
    }

    /**
     * @Title:
     * @Description: 批量修改产品方案机构权限
     * @param prodGroups
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdGroup> prodGroups){
        return super.updateListByPrimaryKey(prodGroups);
    }

    /**
     * @Title:
     * @Description: 动态修改产品方案机构权限
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdGroup prodGroup) {
        return super.updateByPrimaryKeySelective(prodGroup);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品方案机构权限
     * @param prodGroups
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdGroup> prodGroups) {
        return super.updateListByPrimaryKeySelective(prodGroups);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品方案机构权限
     * @param prodGroup
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int updateByExampleData(ProdGroup prodGroup, Example example) {
        return super.updateByExample(prodGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品方案机构权限
     * @param prodGroup
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int updateByExampleSelectiveData(ProdGroup prodGroup, Example example){
        return super.updateByExampleSelective(prodGroup,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodGroupId删除产品方案机构权限
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public int deleteData(ProdGroup prodGroup) {
        return super.delete(prodGroup);
    }

    /**
     * @Title:
     * @Description: 根据prodGroupId集合批量删除产品方案机构权限
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public int deleteDataList(List prodGroupIds,ProdGroup prodGroup){
        return super.deleteByIds(prodGroupIds,prodGroup);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品方案机构权限
     * @param example
     * @param prodGroup
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public int deleteExampleData(Example example,ProdGroup prodGroup){
        return super.deleteByExample(example,prodGroup);
    }

    /**
     * @Title:
     * @Description: 查询全部产品方案机构权限
     * @return List<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public List<ProdGroup> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品方案机构权限
     * @param example
     * @return ProdGroup
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public ProdGroup selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品方案机构权限
     * @param example
     * @return List<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public List<ProdGroup> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodGroupId查询产品方案机构权限
     * @param prodGroupId
     * @return ProdGroup
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public ProdGroup selectByPrimaryKey(Object prodGroupId) {
        return super.selectByPrimaryKey(prodGroupId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品方案机构权限
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    @Override
    public PageInfoExtend<ProdGroup> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品方案机构权限vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public PageInfoExtend<ProdGroup> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }
    /**
     * @Title:
     * @Description: 通过产品方案查询
     * @param product
     * @return List<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public List<ProdGroupVo> selectProdGroupVosByProduct(String product){
        return baseDao.selectProdGroupVosByProduct(product);

    };


}
