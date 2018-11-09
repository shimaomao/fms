package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.prebiz.service.StockAssetsService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.StockAssetsRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import cn.com.leadu.fms.pojo.prebiz.vo.stockassets.StockAssetsVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsSaveVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsModifyVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsDeleteVo;
import cn.com.leadu.fms.prebiz.validator.stockassets.vo.StockAssetsDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsService
 * @Description: 股份资产业务实现层
 * @date 2018-05-28
 */
@Service
public class StockAssetsServiceImpl implements StockAssetsService {

    /**
     * @Fields  : 股份资产repository
     */
    @Autowired
    private StockAssetsRepository stockAssetsRepository;

    /**
     * @Title:
     * @Description: 分页查询股份资产
     * @param stockAssetsVo
     * @return PageInfoExtend<StockAssets>
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public PageInfoExtend<StockAssets> findStockAssetssByPage(StockAssetsVo stockAssetsVo){
        Example example = SqlUtil.newExample(StockAssets.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<StockAssets> pageInfo = stockAssetsRepository.selectListByExamplePage(example,stockAssetsVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存股份资产
     * @param stockAssetsSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public void saveStockAssets(StockAssetsSaveVo stockAssetsSaveVo){
        stockAssetsRepository.insertData(stockAssetsSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改股份资产
     * @param stockAssetsModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public void modifyStockAssets(StockAssetsModifyVo stockAssetsModifyVo){
        stockAssetsRepository.updateByPrimaryKeySelectiveData(stockAssetsModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过stockAssetsId删除股份资产
     * @param stockAssetsDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public void deleteStockAssets(StockAssetsDeleteVo stockAssetsDeleteVo){
        stockAssetsRepository.deleteData(stockAssetsDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过stockAssetsId集合删除股份资产
     * @param stockAssetsDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public void deleteStockAssetssByStockAssetsIds(StockAssetsDeleteListVo stockAssetsDeleteListVo){
        stockAssetsRepository.deleteDataList(stockAssetsDeleteListVo.getStockAssetsIds(),stockAssetsDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据stockAssetsId获取股份资产
     * @param stockAssetsId
     * @return StockAssets
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    public StockAssets findStockAssetsByStockAssetsId(String stockAssetsId){
        return stockAssetsRepository.selectByPrimaryKey(stockAssetsId);
    }

    /**
     * @Title:
     * @Description: 保存股份资产
     * @param stockAssetsList
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    @Override
    public void saveStockAssetsList(List<StockAssets> stockAssetsList, String applyNo) {
         if(ArrayUtils.isNotNullAndLengthNotZero(stockAssetsList)){
             for(StockAssets stockAssets:stockAssetsList){
                 stockAssets.setApplyNo(applyNo);
                 stockAssets.setStockAssetsId(null);
             }
             stockAssetsRepository.insertDataList(stockAssetsList);
         }
    }

    /**
     * @Title:
     * @Description: 根据applyNo获取股东信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    @Override
    public List<StockAssets> findStockAssetsListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(StockAssets.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        if(stockAssetsRepository.selectListByExample(example) == null){
            List<StockAssets> stockAssetsList = new ArrayList<>();
            return stockAssetsList;
        }
        return stockAssetsRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 批量更新股东信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-28 20:57:32
     */
    @Override
    public void modifyStockAssetsByApplyNo(List<StockAssets> stockAssetsList, String applyNo) {
        Example example = SqlUtil.newExample(StockAssets.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        List<StockAssets>  CstmContactGetList =  stockAssetsRepository.selectListByExample(example);
        List<StockAssets> CstmContactAddList = new ArrayList<>();
        List<StockAssets> CstmContactKeepList = new ArrayList<>();
        List<StockAssets> CstmContactUpdateList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(stockAssetsList)){
            for(StockAssets cstmcon:stockAssetsList){
                if(cstmcon.getApplyNo()==null){
                    cstmcon.setStockAssetsId(null);
                    cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(ArrayUtils.isNotNullAndLengthNotZero(CstmContactGetList)){
                    for(StockAssets con:CstmContactGetList){
                        if(con.getStockAssetsId().equals(cstmcon.getStockAssetsId())){
                            CstmContactKeepList.add(con);
                            CstmContactUpdateList.add(cstmcon);
                        }
                    }
                }
            }
            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
            if(ArrayUtils.isNotNullAndLengthNotZero(CstmContactGetList)){
                for(StockAssets con: CstmContactGetList){
                    stockAssetsRepository.deleteData(con);
                }
            }
            stockAssetsRepository.insertDataList(CstmContactAddList);
            stockAssetsRepository.updateByPrimaryKeySelectiveDataList(CstmContactUpdateList);
        }else{
            stockAssetsRepository.deleteExampleData(example,new StockAssets());
        }

//        if(ArrayUtils.isNotNullAndLengthNotZero(stockAssetsList)){
//            for(StockAssets cstmcon:stockAssetsList){
//                if(cstmcon.getApplyNo()==null){
//                    cstmcon.setApplyNo(applyNo);
//                    CstmContactAddList.add(cstmcon);
//                }
//                if(CstmContactGetList.size()!=0){
//                    for(StockAssets con:CstmContactGetList){
//                        if(con.getStockAssetsId().equals(cstmcon.getStockAssetsId())){
//                            CstmContactKeepList.add(con);
//                        }
//                    }
//                }
//            }
//            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
//            if(CstmContactGetList.size()>0){
//                for(StockAssets con: CstmContactGetList){
//                    stockAssetsRepository.deleteData(con);
//                }
//            }
//            stockAssetsRepository.insertDataList(CstmContactAddList);
//        }else{
//            stockAssetsRepository.deleteExampleData(example,new StockAssets());
//        }

    }


}
