package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdVehicleRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import cn.com.leadu.fms.product.service.ProdVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdVehicleService
 * @Description: 产品方案车型权限业务实现层
 * @date 2018-04-05
 */
@Service
public class ProdVehicleServiceImpl implements ProdVehicleService {

    /**
     * @Fields  : 产品方案车型权限repository
     */
    @Autowired
    private ProdVehicleRepository prodVehicleRepository;

    /**
     * @Title:
     * @Description: 分页查询产品方案车型权限
     * @param prodVehicleVo
     * @return PageInfoExtend<ProdVehicle>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public PageInfoExtend<ProdVehicle> findProdVehiclesByPage(ProdVehicleVo prodVehicleVo){
        Example example = SqlUtil.newExample(ProdVehicle.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdVehicle> pageInfo = prodVehicleRepository.selectListByExamplePage(example,prodVehicleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据prodVehicleId获取产品方案车型权限
     * @param prodVehicleId
     * @return ProdVehicle
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    public ProdVehicle findProdVehicleByProdVehicleId(String prodVehicleId){
        return prodVehicleRepository.selectByPrimaryKey(prodVehicleId);
    }


    /**
     * @Title:
     * @Description:  根据prodVehicleId获取产品方案车型权限
     * @param product
     * @return ProdVehicle
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public List<ProdVehicle> findProdVehicleByProduct(String product){
        Example example = SqlUtil.newExample(ProdVehicle.class);
        example.createCriteria().andEqualTo("product",product);
        example.setOrderByClause("vehicle_code asc");
        List<ProdVehicle> prodVehicleList = prodVehicleRepository.selectListByExample(example);
        if(ArrayUtils.isNullOrLengthZero(prodVehicleList)){
            prodVehicleList = new ArrayList<>();
        }
        return prodVehicleList;

    }

    @Override
    public void deleteProdVehiclesByProducts(List<String> products) {
        Example example = SqlUtil.newExample(ProdIntrst.class);
        example.createCriteria().andIn("product",products);
        prodVehicleRepository.deleteExampleData(example, new ProdVehicle());
    }

}
