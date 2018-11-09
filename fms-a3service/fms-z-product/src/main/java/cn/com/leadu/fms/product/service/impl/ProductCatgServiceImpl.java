package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProductCatgRepository;
import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import cn.com.leadu.fms.pojo.product.vo.productcatg.ProductCatgVo;
import cn.com.leadu.fms.product.service.ProductCatgService;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgSaveVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgModifyVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgDeleteVo;
import cn.com.leadu.fms.product.validator.productcatg.vo.ProductCatgDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductCatgService
 * @Description: 产品大类管理业务实现层
 * @date 2018-03-21
 */
@Service
public class ProductCatgServiceImpl implements ProductCatgService {

    /**
     * @Fields  : 产品大类管理repository
     */
    @Autowired
    private ProductCatgRepository productCatgRepository;

    /**
     * @Title:
     * @Description: 分页查询产品大类管理
     * @param productCatgVo
     * @return PageInfoExtend<ProductCatg>
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public PageInfoExtend<ProductCatg> findProductCatgsByPage(ProductCatgVo productCatgVo){
        Example example = SqlUtil.newExample(ProductCatg.class);
        if(StringUtil.isNotEmpty(productCatgVo.getProductCatg())){
            example.createCriteria().andEqualTo("productCatg",productCatgVo.getProductCatg());
        }
        if(StringUtil.isNotEmpty(productCatgVo.getProductCatgName())){
            example.createCriteria().andLike("productCatgName",SqlUtil.likePattern(productCatgVo.getProductCatgName()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProductCatg> pageInfo = productCatgRepository.selectListByExamplePage(example,productCatgVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存产品大类管理
     * @param productCatgSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public void saveProductCatg(ProductCatgSaveVo productCatgSaveVo){
        productCatgRepository.insertData(productCatgSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改产品大类管理
     * @param productCatgModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public void modifyProductCatg(ProductCatgModifyVo productCatgModifyVo){
        productCatgRepository.updateByPrimaryKeySelectiveData(productCatgModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过productCatgId删除产品大类管理
     * @param productCatgDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public void deleteProductCatg(ProductCatgDeleteVo productCatgDeleteVo){
        productCatgRepository.deleteData(productCatgDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过productCatgId集合删除产品大类管理
     * @param productCatgDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public void deleteProductCatgsByProductCatgIds(ProductCatgDeleteListVo productCatgDeleteListVo){
        productCatgRepository.deleteDataList(productCatgDeleteListVo.getProductCatgIds(),productCatgDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据productCatgId获取产品大类管理
     * @param productCatgId
     * @return ProductCatg
     * @throws
     * @author niehaibing
     * @date 2018-3-21 12:09:48
     */
    public ProductCatg findProductCatgByProductCatgId(String productCatgId){
        return productCatgRepository.selectByPrimaryKey(productCatgId);
    }


    /**
     * @Title:
     * @Description:  根据productCatg获取产品大类管理
     * @param productCatg
     * @return ProductCatg
     * @throws
     * @author huchenghao
     * @date 2018-3-21 12:09:48
     */
    public ProductCatg findProductCatgByProductCatg(String productCatg){
        Example example = SqlUtil.newExample(ProductCatg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productCatg",productCatg);
        return productCatgRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  取得全部产品大类信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-21 19:43:48
     */
    @Override
   public List<ProductCatg> findProductCatgListByAll() {
        Example example = SqlUtil.newExample(ProductCatg.class);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        return productCatgRepository.selectListByExample(example);
    }
}
