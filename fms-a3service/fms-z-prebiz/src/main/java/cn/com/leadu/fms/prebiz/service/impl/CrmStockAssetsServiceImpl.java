package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.prebiz.service.CrmStockAssetsService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CrmStockAssetsRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import cn.com.leadu.fms.pojo.prebiz.vo.crmstockassets.CrmStockAssetsVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsSaveVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsModifyVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsDeleteVo;
import cn.com.leadu.fms.prebiz.validator.crmstockassets.vo.CrmStockAssetsDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsService
 * @Description: crm股东信息业务实现层
 * @date 2018-08-27
 */
@Service
public class CrmStockAssetsServiceImpl implements CrmStockAssetsService {

    /**
     * @Fields  : crm股东信息repository
     */
    @Autowired
    private CrmStockAssetsRepository crmStockAssetsRepository;

    /**
     * @Title:
     * @Description: 分页查询crm股东信息
     * @param crmStockAssetsVo
     * @return PageInfoExtend<CrmStockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public PageInfoExtend<CrmStockAssets> findCrmStockAssetssByPage(CrmStockAssetsVo crmStockAssetsVo){
        Example example = SqlUtil.newExample(CrmStockAssets.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CrmStockAssets> pageInfo = crmStockAssetsRepository.selectListByExamplePage(example,crmStockAssetsVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存crm股东信息
     * @param crmStockAssetsSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public void saveCrmStockAssets(CrmStockAssetsSaveVo crmStockAssetsSaveVo){
        crmStockAssetsRepository.insertData(crmStockAssetsSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改crm股东信息
     * @param crmStockAssetsModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public void modifyCrmStockAssets(CrmStockAssetsModifyVo crmStockAssetsModifyVo){
        crmStockAssetsRepository.updateByPrimaryKeySelectiveData(crmStockAssetsModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过stockAssetsId删除crm股东信息
     * @param crmStockAssetsDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public void deleteCrmStockAssets(CrmStockAssetsDeleteVo crmStockAssetsDeleteVo){
        crmStockAssetsRepository.deleteData(crmStockAssetsDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过stockAssetsId集合删除crm股东信息
     * @param crmStockAssetsDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public void deleteCrmStockAssetssByStockAssetsIds(CrmStockAssetsDeleteListVo crmStockAssetsDeleteListVo){
        crmStockAssetsRepository.deleteDataList(crmStockAssetsDeleteListVo.getStockAssetsIds(),crmStockAssetsDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据stockAssetsId获取crm股东信息
     * @param stockAssetsId
     * @return CrmStockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-8-27 16:51:23
     */
    public CrmStockAssets findCrmStockAssetsByStockAssetsId(String stockAssetsId){
        return crmStockAssetsRepository.selectByPrimaryKey(stockAssetsId);
    }

}
