package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdIntrstFactorRepository;
import cn.com.leadu.fms.data.product.repository.ProdIntrstRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.product.service.ProdIntrstFactorService;
import cn.com.leadu.fms.product.service.ProdIntrstService;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstDeleteListVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstDeleteVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstModifyVo;
import cn.com.leadu.fms.product.validator.prodintrst.vo.ProdIntrstSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author niehaibing
 * @ClassName: ProdIntrstService
 * @Description: 产品利率业务实现层
 * @date 2018-03-27
 */
@Service
public class ProdIntrstServiceImpl implements ProdIntrstService {

    /**
     * @Fields  : 产品利率repository
     */
    @Autowired
    private ProdIntrstRepository prodIntrstRepository;

    @Autowired
    private ProdIntrstFactorService prodIntrstFactorService;

    @Autowired
    private ProdIntrstFactorRepository prodIntrstFactorRepository;
    /**
     * @Title:
     * @Description: 分页查询产品利率
     * @param prodIntrstVo
     * @return PageInfoExtend<ProdIntrst>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public PageInfoExtend<ProdIntrst> findProdIntrstsByPage(ProdIntrstVo prodIntrstVo){
        Example example = SqlUtil.newExample(ProdIntrst.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdIntrst> pageInfo = prodIntrstRepository.selectListByExamplePage(example,prodIntrstVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public void saveProdIntrst(ProdIntrstSaveVo prodIntrstSaveVo){
        prodIntrstRepository.insertData(prodIntrstSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改产品利率
     * @param prodIntrstModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public void modifyProdIntrst(ProdIntrstModifyVo prodIntrstModifyVo){
        prodIntrstRepository.updateByPrimaryKeySelectiveData(prodIntrstModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过prodIntrstId删除产品利率
     * @param prodIntrstDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public void deleteProdIntrst(ProdIntrstDeleteVo prodIntrstDeleteVo){
        prodIntrstRepository.deleteData(prodIntrstDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过prodIntrstId集合删除产品利率
     * @param prodIntrstDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public void deleteProdIntrstsByProdIntrstIds(ProdIntrstDeleteListVo prodIntrstDeleteListVo){
        prodIntrstRepository.deleteDataList(prodIntrstDeleteListVo.getProdIntrstIds(),prodIntrstDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstId获取产品利率
     * @param prodIntrstId
     * @return ProdIntrst
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:28
     */
    public ProdIntrst findProdIntrstByProdIntrstId(String prodIntrstId){
        return prodIntrstRepository.selectByPrimaryKey(prodIntrstId);
    }

    /**
     * @Title:
     * @Description:  根据产品代码，获取产品的全部利率方案信息
     * @param product
     * @return List<ProdIntrstVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:46:28
     */
    public List<ProdIntrstVo> findProdIntrstVoByProduct(String product) {
        // 取得全部利率方案
        Example example = SqlUtil.newExample(ProdIntrst.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("product",product);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        List<ProdIntrst> prodIntrstList = prodIntrstRepository.selectListByExample(example);
        // 利率方案
        List<ProdIntrstVo> prodIntrstVoList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstList)) {
            // 取得全部利率方案因子
            Map<String, List<ProdIntrstFactorVo>> prodIntrstFactorMap = prodIntrstFactorService.findProdIntrstFactorVosByProduct(product);
            for (ProdIntrst prodIntrst : prodIntrstList) {
                ProdIntrstVo prodIntrstVo = EntityUtils.getEntity(prodIntrst, new ProdIntrstVo());
                prodIntrstVo.setProdIntrstFactorVoList(prodIntrstFactorMap.get(prodIntrstVo.getIntrstNo()));
                prodIntrstVoList.add(prodIntrstVo);
            }
        }
        return prodIntrstVoList;
    }

    /**
     * @Title:
     * @Description:  根据产品代码，获取产品的全部利率方案信息
     * @param product
     * @return List<ProdIntrstVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:46:28
     */
    public String findMaxIntrstNoByProduct(String product){
         return prodIntrstRepository.selectIntrstNoMax(product);
    }

    /**
     * @Title:
     * @Description:  根据产品代码删除利率方案
     * @param products
     * @return List<ProdIntrstVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:46:28
     */
    @Override
    public void deleteProdIntrstsByProduct(List<String> products) {
        Example example = SqlUtil.newExample(ProdIntrst.class);
        example.createCriteria().andIn("product",products);
        prodIntrstRepository.deleteExampleData(example, new ProdIntrst());
        prodIntrstFactorRepository.deleteExampleData(example, new ProdIntrstFactor());
    }
}
