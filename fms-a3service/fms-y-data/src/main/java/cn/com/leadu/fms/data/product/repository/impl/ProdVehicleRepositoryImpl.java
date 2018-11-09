package cn.com.leadu.fms.data.product.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.product.dao.ProdVehicleDao;
import cn.com.leadu.fms.data.product.repository.ProdVehicleRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleRepositoryImpl
 * @Description: 产品方案车型权限Repository 实现层
 * @date 2018-04-05
 */
@Repository
public class ProdVehicleRepositoryImpl extends AbstractBaseRepository<ProdVehicleDao, ProdVehicle> implements ProdVehicleRepository {

    /**
     * @Title:
     * @Description: 新增产品方案车型权限
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int insertData(ProdVehicle prodVehicle) {
        return super.insert(prodVehicle);
    }

    /**
     * @Title:
     * @Description: 批量保存产品方案车型权限
     * @param prodVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int insertDataList(List<ProdVehicle> prodVehicles){
        return super.insertListByJdbcTemplate(prodVehicles);
    }

    /**
     * @Title:
     * @Description: 修改产品方案车型权限
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int updateByPrimaryKeyData(ProdVehicle prodVehicle) {
        return super.updateByPrimaryKey(prodVehicle);
    }

    /**
     * @Title:
     * @Description: 批量修改产品方案车型权限
     * @param prodVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ProdVehicle> prodVehicles){
        return super.updateListByPrimaryKey(prodVehicles);
    }

    /**
     * @Title:
     * @Description: 动态修改产品方案车型权限
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ProdVehicle prodVehicle) {
        return super.updateByPrimaryKeySelective(prodVehicle);
    }

    /**
     * @Title:
     * @Description: 批量动态修改产品方案车型权限
     * @param prodVehicles
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public int updateByPrimaryKeySelectiveDataList(List<ProdVehicle> prodVehicles) {
        return super.updateListByPrimaryKeySelective(prodVehicles);
    }

    /**
     * @Title:
     * @Description: 根据条件修改产品方案车型权限
     * @param prodVehicle
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int updateByExampleData(ProdVehicle prodVehicle, Example example) {
        return super.updateByExample(prodVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改产品方案车型权限
     * @param prodVehicle
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int updateByExampleSelectiveData(ProdVehicle prodVehicle, Example example){
        return super.updateByExampleSelective(prodVehicle,example);
    }
    
    /**
     * @Title:
     * @Description: 根据prodVehicleId删除产品方案车型权限
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public int deleteData(ProdVehicle prodVehicle) {
        return super.delete(prodVehicle);
    }

    /**
     * @Title:
     * @Description: 根据prodVehicleId集合批量删除产品方案车型权限
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public int deleteDataList(List prodVehicleIds,ProdVehicle prodVehicle){
        return super.deleteByIds(prodVehicleIds,prodVehicle);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除产品方案车型权限
     * @param example
     * @param prodVehicle
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public int deleteExampleData(Example example,ProdVehicle prodVehicle){
        return super.deleteByExample(example,prodVehicle);
    }

    /**
     * @Title:
     * @Description: 查询全部产品方案车型权限
     * @return List<ProdVehicle>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public List<ProdVehicle> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个产品方案车型权限
     * @param example
     * @return ProdVehicle
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public ProdVehicle selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询产品方案车型权限
     * @param example
     * @return List<ProdVehicle>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public List<ProdVehicle> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过prodVehicleId查询产品方案车型权限
     * @param prodVehicleId
     * @return ProdVehicle
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public ProdVehicle selectByPrimaryKey(Object prodVehicleId) {
        return super.selectByPrimaryKey(prodVehicleId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询产品方案车型权限
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ProdVehicle>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public PageInfoExtend<ProdVehicle> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询产品方案车型权限vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ProdVehicle>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public PageInfoExtend<ProdVehicle> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 通过产品方案查询
     * @param product
     * @return List<ProdVehicleVo>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public List<ProdVehicleVo> selectProdVehicleVosByProduct(String product){
        return baseDao.selectProdVehicleVosByProduct(product);

    };

}
