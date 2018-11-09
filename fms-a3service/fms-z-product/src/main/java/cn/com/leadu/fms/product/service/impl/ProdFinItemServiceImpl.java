package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdFinItemRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdFinItem;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.vo.prodfinitem.ProdFinItemVo;
import cn.com.leadu.fms.product.service.ProdFinItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFinItemService
 * @Description: 产品方案融资项目业务实现层
 * @date 2018-04-06
 */
@Service
public class ProdFinItemServiceImpl implements ProdFinItemService {

    /**
     * @Fields  : 产品方案融资项目repository
     */
    @Autowired
    private ProdFinItemRepository prodFinItemRepository;

    /**
     * @Title:
     * @Description: 分页查询产品方案融资项目
     * @param prodFinItemVo
     * @return PageInfoExtend<ProdFinItem>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public PageInfoExtend<ProdFinItem> findProdFinItemsByPage(ProdFinItemVo prodFinItemVo){
        Example example = SqlUtil.newExample(ProdFinItem.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdFinItem> pageInfo = prodFinItemRepository.selectListByExamplePage(example,prodFinItemVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据prodFinItemId获取产品方案融资项目
     * @param prodFinItemId
     * @return ProdFinItem
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    public ProdFinItem findProdFinItemByProdFinItemId(String prodFinItemId){
        return prodFinItemRepository.selectByPrimaryKey(prodFinItemId);
    }

    /**
     * @Title:
     * @Description:  根据product获取产品方案融资项目
     * @param product
     * @return List<ProdFinItemVo>
     * @throws
     * @author liujinge
     * @date 2018-4-6 13:39:12
     */
    @Override
    public List<ProdFinItem> findProdFinItemByProduct(String product){
        Example example = SqlUtil.newExample(ProdFinItem.class);
        example.createCriteria().andEqualTo("product",product);
        example.setOrderByClause("fin_item_type asc, fin_item asc");
        List<ProdFinItem> prodFinItemList = prodFinItemRepository.selectListByExample(example);
        if(ArrayUtils.isNullOrLengthZero(prodFinItemList)){
            prodFinItemList = new ArrayList<>();
        }
        return prodFinItemList;
    }

    @Override
    public void deleteProdFinItemByProducts(List<String> products) {
        Example example = SqlUtil.newExample(ProdIntrst.class);
        example.createCriteria().andIn("product",products);
        prodFinItemRepository.deleteExampleData(example, new ProdFinItem());
    }
}
