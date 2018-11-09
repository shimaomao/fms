package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.product.service.ProdIntrstFactorService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdIntrstFactorRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorSaveVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorModifyVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorDeleteVo;
import cn.com.leadu.fms.product.validator.prodintrstfactor.vo.ProdIntrstFactorDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorService
 * @Description: 产品利率业务实现层
 * @date 2018-03-27
 */
@Service
public class ProdIntrstFactorServiceImpl implements ProdIntrstFactorService {

    /**
     * @Fields  : 产品利率repository
     */
    @Autowired
    private ProdIntrstFactorRepository prodIntrstFactorRepository;

    /**
     * @Title:
     * @Description: 分页查询产品利率
     * @param prodIntrstFactorVo
     * @return PageInfoExtend<ProdIntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public PageInfoExtend<ProdIntrstFactor> findProdIntrstFactorsByPage(ProdIntrstFactorVo prodIntrstFactorVo){
        Example example = SqlUtil.newExample(ProdIntrstFactor.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdIntrstFactor> pageInfo = prodIntrstFactorRepository.selectListByExamplePage(example,prodIntrstFactorVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstFactorSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public void saveProdIntrstFactor(ProdIntrstFactorSaveVo prodIntrstFactorSaveVo){
        prodIntrstFactorRepository.insertData(prodIntrstFactorSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改产品利率
     * @param prodIntrstFactorModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public void modifyProdIntrstFactor(ProdIntrstFactorModifyVo prodIntrstFactorModifyVo){
        prodIntrstFactorRepository.updateByPrimaryKeySelectiveData(prodIntrstFactorModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过prodIntrstFactorId删除产品利率
     * @param prodIntrstFactorDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public void deleteProdIntrstFactor(ProdIntrstFactorDeleteVo prodIntrstFactorDeleteVo){
        prodIntrstFactorRepository.deleteData(prodIntrstFactorDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过prodIntrstFactorId集合删除产品利率
     * @param prodIntrstFactorDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public void deleteProdIntrstFactorsByProdIntrstFactorIds(ProdIntrstFactorDeleteListVo prodIntrstFactorDeleteListVo){
        prodIntrstFactorRepository.deleteDataList(prodIntrstFactorDeleteListVo.getProdIntrstFactorIds(),prodIntrstFactorDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据prodIntrstFactorId获取产品利率
     * @param prodIntrstFactorId
     * @return ProdIntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    public ProdIntrstFactor findProdIntrstFactorByProdIntrstFactorId(String prodIntrstFactorId){
        return prodIntrstFactorRepository.selectByPrimaryKey(prodIntrstFactorId);
    }

    /**
     * @Title:
     * @Description:  根据产品方案代码，取得产品的利率方案信息
     * @param product
     * @return List<ProdIntrstFactorVo>
     * @throws
     * @author wangxue
     * @date 2018-3-27 15:45:28
     */
    public Map<String, List<ProdIntrstFactorVo>> findProdIntrstFactorVosByProduct(String product) {
        Map<String, List<ProdIntrstFactorVo>> resultMap = new HashMap<>();
        // 取得全部的利率方案的利率因子信息
        List<ProdIntrstFactorVo> totalList = prodIntrstFactorRepository.selectProdIntrstFactorListByProduct(product);
        if (ArrayUtils.isNotNullAndLengthNotZero(totalList)) {
            String intrstNo = "";
            List<ProdIntrstFactorVo> tempList = new ArrayList<>();
            for (ProdIntrstFactorVo prodIntrstFactorVo : totalList) {
                if (intrstNo.equals(prodIntrstFactorVo.getIntrstNo())) {
                    tempList.add(prodIntrstFactorVo);
                } else {
                    if (!"".equals(intrstNo)) {
                        resultMap.put(intrstNo, tempList);
                    }
                    intrstNo = prodIntrstFactorVo.getIntrstNo();
                    tempList = new ArrayList<>();
                    tempList.add(prodIntrstFactorVo);
                }
            }
            if (!"".equals(intrstNo)) {
                resultMap.put(intrstNo, tempList);
            }
        }
        return resultMap;
    }
}
