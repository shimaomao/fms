package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdGroupRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdGroup;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import cn.com.leadu.fms.product.service.ProdGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdGroupService
 * @Description: 产品方案机构权限业务实现层
 * @date 2018-04-05
 */
@Service
public class ProdGroupServiceImpl implements ProdGroupService {

    /**
     * @Fields  : 产品方案机构权限repository
     */
    @Autowired
    private ProdGroupRepository prodGroupRepository;

    /**
     * @Title:
     * @Description: 分页查询产品方案机构权限
     * @param prodGroupVo
     * @return PageInfoExtend<ProdGroup>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public PageInfoExtend<ProdGroup> findProdGroupsByPage(ProdGroupVo prodGroupVo){
        Example example = SqlUtil.newExample(ProdGroup.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdGroup> pageInfo = prodGroupRepository.selectListByExamplePage(example,prodGroupVo.getPageQuery());
        return pageInfo;
    }


    /**
     * @Title:
     * @Description:  根据prodGroupId获取产品方案机构权限
     * @param prodGroupId
     * @return ProdGroup
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:36:32
     */
    public ProdGroup findProdGroupByProdGroupId(String prodGroupId){
        return prodGroupRepository.selectByPrimaryKey(prodGroupId);
    }

    @Override
    public List<ProdGroup> findProdGroupsByProduct(String product) {
        Example example = SqlUtil.newExample(ProdGroup.class);
        example.createCriteria().andEqualTo("product",product);
        example.setOrderByClause("group_code asc");
        List<ProdGroup> prodGroupList = prodGroupRepository.selectListByExample(example);
        if(ArrayUtils.isNullOrLengthZero(prodGroupList)){
            prodGroupList = new ArrayList<>();
        }
        return prodGroupList;
    }

    @Override
    public void deleteProdGroupsByProducts(List<String> products) {
        Example example = SqlUtil.newExample(ProdIntrst.class);
        example.createCriteria().andIn("product",products);
        prodGroupRepository.deleteExampleData(example, new ProdGroup());
    }

}
