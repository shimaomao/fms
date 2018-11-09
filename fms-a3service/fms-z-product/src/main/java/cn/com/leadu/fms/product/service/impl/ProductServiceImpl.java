package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.constant.enums.product.FinItemTypeEnums;
import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.*;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.product.entity.*;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import cn.com.leadu.fms.pojo.product.vo.prodgroup.ProdGroupVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import cn.com.leadu.fms.pojo.product.vo.product.ProductVo;
import cn.com.leadu.fms.pojo.product.vo.prodvehicle.ProdVehicleVo;
import cn.com.leadu.fms.product.rpc.system.SysGroupRpc;
import cn.com.leadu.fms.product.service.*;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteListVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductDeleteVo;
import cn.com.leadu.fms.product.validator.product.vo.ProductModifyVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductService
 * @Description: 产品方案管理业务实现层
 * @date 2018-03-23
 */
@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    /**
     * @Fields  : 产品方案管理repository
     */
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProdIntrstRepository prodIntrstRepository;
    @Autowired
    private ProdIntrstFactorRepository prodIntrstFactorRepository;
    @Autowired
    private ProdVehicleRepository prodVehicleRepository;
    @Autowired
    private ProdVehicleService prodVehicleService;
    @Autowired
    private ProdGroupRepository prodGroupRepository;
    @Autowired
    private ProdGroupService prodGroupService;
    @Autowired
    private ProdFinItemService prodFinItemService;
    @Autowired
    private ProdFinItemRepository prodFinItemRepository;
    @Autowired
    private ProdFileRepository prodFileRepository;
    @Autowired
    private ProdFileService prodFileService;
    @Autowired
    private FinItemService finItemService;

    @Autowired
    private IntrstFactorService intrstFactorService;

    @Autowired
    private ProdIntrstService prodIntrstService;

    @Autowired
    private SysGroupRpc sysGroupRpc;

    /**
     * @Title:
     * @Description: 分页查询产品方案管理
     * @param productVo
     * @return PageInfoExtend<Product>
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public PageInfoExtend<ProductVo> findProductsByPage(ProductVo productVo){
        // 产品方案名称参数处理
        if(StringUtils.isNotTrimBlank(productVo.getProductName())){
            productVo.setProductName(SqlUtil.likePattern(productVo.getProductName()));
        }else{
            productVo.setProductName(null);
        }
        // 产品方案代码参数处理
        if(StringUtils.isNotTrimBlank(productVo.getProduct())){
            productVo.setProduct(SqlUtil.likePattern(productVo.getProduct()));
        }else{
            productVo.setProduct(null);
        }
        // 产品大类代码参数处理
        if(StringUtils.isNotTrimBlank(productVo.getProductCatg())){
            productVo.setProductCatg(SqlUtil.likePattern(productVo.getProductCatg()));
        }else{
            productVo.setProductCatg(null);
        }
        PageInfoExtend<ProductVo> pageInfo = productRepository.selectListVoByPage("selectProductVosByPage",productVo,productVo.getPageQuery());
        return pageInfo;
    }


    /**
     * @Title:
     * @Description: 保存产品方案
     * @param productVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Transactional
    public void saveProduct(ProductVo productVo) {
        String productId = productVo.getProductId();
        if(StringUtils.isTrimBlank(productId)){
            //产品方案代码重复check
            checkProduct(productVo.getProduct());

            //增加产品方案
            insertProduct(productVo);
        }else{
            //更新产品方案
            updateProduct(productVo);
        }

    }

    /**
     * @Title:
     * @Description: 判断产品方案代码唯一性
     * @param product
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public void checkProduct(String product){
        Example example = SqlUtil.newExample(Product.class);
        example.createCriteria().andEqualTo("product",product);
        Product productCheck = productRepository.selectOneByExample(example);
        if(!StringUtils.isTrimBlank(productCheck) && product.equals(productCheck.getProduct())){
            throw new FmsServiceException("产品方案代码已存在");
        }
    }

    /**
     * @Title:
     * @Description: 保存产品方案
     * @param productVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public void insertProduct(ProductVo productVo){

        //产品方案信息
        Product product= EntityUtils.getEntity(productVo,new Product());
        productRepository.insertData(product);
        //产品融资项目
        if(!StringUtils.isTrimBlank(productVo.getProdFinItems()) ||
                !StringUtils.isTrimBlank(productVo.getProdFinItemsIF()) ||
                !StringUtils.isTrimBlank(productVo.getProdFinItemsDep()) ||
                !StringUtils.isTrimBlank(productVo.getProdFinItemsFinal())) {
            List<ProdFinItem> prodFinItemList = new ArrayList<>();
            mergeProdFinItem(prodFinItemList,productVo);
            if (ArrayUtils.isNotNullAndLengthNotZero(prodFinItemList)){
                prodFinItemRepository.insertDataList(prodFinItemList);
            }
        }

        //产品利率方案
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdIntrstVoList())){
            List<ProdIntrstVo> prodIntrstVoList = productVo.getProdIntrstVoList();
            List<ProdIntrst> prodIntrstList = new ArrayList<>();
            List<ProdIntrstFactor> prodIntrstFactorList = new ArrayList<>();
            for(int i=0; i<prodIntrstVoList.size(); i++){
                //利率方案序号
                String intrstNo = StringUtils.addZeroForNum(i+1,3);
                ProdIntrst prodIntrst = prodIntrstVoList.get(i).getEntity();
                prodIntrst.setProduct(productVo.getProduct());
                prodIntrst.setIntrstNo(intrstNo);
                prodIntrstList.add(prodIntrst);
                List<ProdIntrstFactorVo> prodIntrstFactorVoList = prodIntrstVoList.get(i).getProdIntrstFactorVoList();
                if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorVoList)){
                    for(int j=0; j<prodIntrstFactorVoList.size(); j++){
                        ProdIntrstFactor prodIntrstFactor = EntityUtils.getEntity(prodIntrstFactorVoList.get(j), new ProdIntrstFactor());
                        prodIntrstFactor.setIntrstNo(intrstNo);
                        prodIntrstFactor.setProduct(productVo.getProduct());
                        prodIntrstFactorList.add(prodIntrstFactor);
                    }
                }
            }
            if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstList)){
                prodIntrstRepository.insertDataList(prodIntrstList);
            }
            if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorList)){
                prodIntrstFactorRepository.insertDataList(prodIntrstFactorList);
            }
        }
        //产品车型权限

        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdVehicleVopList())){
            List<ProdVehicle> prodVehicleList = new ArrayList<>();
            for(int i=0; i<productVo.getProdVehicleVopList().size(); i++){
                ProdVehicle prodVehicle = new ProdVehicle();
                prodVehicle.setProduct(productVo.getProduct());
                prodVehicle.setVehicleCode(productVo.getProdVehicleVopList().get(i).getVehicleCode());
                prodVehicleList.add(prodVehicle);
            }
            prodVehicleRepository.insertDataList(prodVehicleList);
        }
        //产品区域权限
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdGroupVoList())){
            List<ProdGroup> prodGroupList = new ArrayList<>();
            for(int i=0; i<productVo.getProdGroupVoList().size(); i++){
                ProdGroup prodGroup = new ProdGroup();
                prodGroup.setProduct(productVo.getProduct());
                prodGroup.setGroupCode(productVo.getProdGroupVoList().get(i).getGroupCode());
                prodGroupList.add(prodGroup);
            }
            prodGroupRepository.insertDataList(prodGroupList);
        }
        //产品附件信息
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdFileVoList())){
            List<ProdFile> prodFileList = new ArrayList<>();
            for(int i=0; i<productVo.getProdFileVoList().size(); i++){
                ProdFile prodFile = new ProdFile();
                prodFile.setProduct(productVo.getProduct());
                prodFile.setFileType(productVo.getProdFileVoList().get(i).getFileType());
                prodFileList.add(prodFile);
            }
            prodFileRepository.insertDataList(prodFileList);
        }
    }

    private void mergeProdFinItem(List<ProdFinItem> prodFinItemList, ProductVo productVo) {
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdFinItems())){
            for (int i = 0; i < productVo.getProdFinItems().size(); i++) {
                ProdFinItem prodFinItem = new ProdFinItem();
                prodFinItem.setProduct(productVo.getProduct());
                prodFinItem.setFinItem(productVo.getProdFinItems().get(i));
                prodFinItem.setFinItemType(FinItemTypeEnums.FINANCE_ITEM.getType());
                prodFinItemList.add(prodFinItem);
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdFinItemsIF())) {
            for (int i = 0; i < productVo.getProdFinItemsIF().size(); i++) {
                ProdFinItem prodFinItem = new ProdFinItem();
                prodFinItem.setProduct(productVo.getProduct());
                prodFinItem.setFinItem(productVo.getProdFinItemsIF().get(i));
                prodFinItem.setFinItemType(FinItemTypeEnums.INIT_FINAL_ITEM.getType());
                prodFinItemList.add(prodFinItem);
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdFinItemsFinal())) {
            for (int i = 0; i < productVo.getProdFinItemsFinal().size(); i++) {
                ProdFinItem prodFinItem = new ProdFinItem();
                prodFinItem.setProduct(productVo.getProduct());
                prodFinItem.setFinItem(productVo.getProdFinItemsFinal().get(i));
                prodFinItem.setFinItemType(FinItemTypeEnums.FINAL_ITEM.getType());
                prodFinItemList.add(prodFinItem);
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdFinItemsDep())) {
            for (int i = 0; i < productVo.getProdFinItemsDep().size(); i++) {
                ProdFinItem prodFinItem = new ProdFinItem();
                prodFinItem.setProduct(productVo.getProduct());
                prodFinItem.setFinItem(productVo.getProdFinItemsDep().get(i));
                prodFinItem.setFinItemType(FinItemTypeEnums.DEPOSIT_ITEM.getType());
                prodFinItemList.add(prodFinItem);
            }
        }
    }


    public void updateProduct(ProductVo productVo){
        //产品方案信息
        Product product= productVo.getEntity();
        //根据productId更新
        productRepository.updateByPrimaryKeySelectiveData(product);

        //更新前产品融资项目取得,根据融资项目类型+融资项目排序
        List<ProdFinItem> prodFinItemList = prodFinItemService.findProdFinItemByProduct(productVo.getProduct());
        List<String> deleteProdFinItemIds = new ArrayList<>();
        List<ProdFinItem> insertProdFinItemList = new ArrayList<>();
        //更新后产品融资项目
        List<ProdFinItem> prodFinItemListAfter = new ArrayList<>();
        //产品融资项目合并
        mergeProdFinItem(prodFinItemListAfter, productVo);
        //产品融资项目排序
        Collections.sort(prodFinItemListAfter,new Comparator<ProdFinItem>(){
            @Override
            public int compare(ProdFinItem arg0, ProdFinItem arg1) {
                return compareProdFinItem(arg0,arg1);
            }
        });

        //与更新前产品融资项目比较
        int bef=0, after=0;
        ProdFinItem prodFinItemAfter = null;
        ProdFinItem prodFinItem = null;
        while(bef < prodFinItemList.size() || after < prodFinItemListAfter.size()) {
            if (bef < prodFinItemList.size()) {
                prodFinItem = prodFinItemList.get(bef);
            } else {
                prodFinItem = null;
            }
            if (after < prodFinItemListAfter.size()) {
                prodFinItemAfter = prodFinItemListAfter.get(after);
            } else {
                prodFinItemAfter = null;
            }
            if (compareObj(prodFinItem, prodFinItemAfter) < 0) {
                //更新后没有该记录，删除
                deleteProdFinItemIds.add(prodFinItem.getProdFinItemId());
                bef++;
            } else if (compareObj(prodFinItem, prodFinItemAfter) > 0) {
                //更新前没有该记录，增加
                insertProdFinItemList.add(prodFinItemAfter);
                after++;
            } else {
                if (compareProdFinItem(prodFinItem, prodFinItemAfter) == 0) {
                    //不做操作
                    bef++;
                    after++;
                }
                if (compareProdFinItem(prodFinItem, prodFinItemAfter) < 0) {
                    //删除该记录
                    deleteProdFinItemIds.add(prodFinItem.getProdFinItemId());
                    bef++;
                } else if (compareProdFinItem(prodFinItem, prodFinItemAfter) > 0) {
                    //增加记录
                    insertProdFinItemList.add(prodFinItemAfter);
                    after++;
                }
            }
        }
        //删除产品融资项目
        if(ArrayUtils.isNotNullAndLengthNotZero(deleteProdFinItemIds)){
            prodFinItemRepository.deleteDataList(deleteProdFinItemIds,new ProdFinItem());
        }
        //增加产品融资项目
        if(ArrayUtils.isNotNullAndLengthNotZero(insertProdFinItemList)){
            prodFinItemRepository.insertDataList(insertProdFinItemList);
        }

        //产品利率方案
        if(ArrayUtils.isNotNullAndLengthNotZero(productVo.getProdIntrstVoList())){
            List<ProdIntrstVo> prodIntrstVoList = productVo.getProdIntrstVoList();
            List<ProdIntrst> prodIntrstInsertList = new ArrayList<>();
            List<ProdIntrst> prodIntrstUpdateList = new ArrayList<>();
            List<String> prodIntrstDeleteIds = new ArrayList<>();
            List<ProdIntrstFactor> prodIntrstFactorInsertList = new ArrayList<>();
            List<ProdIntrstFactor> prodIntrstFactorUpdateList = new ArrayList<>();
            List<String> prodIntrstFactorDeleteIds = new ArrayList<>();
            String intrstNoMaxStr = prodIntrstService.findMaxIntrstNoByProduct(productVo.getProduct());
            Integer intrstNoMax;
            if(!StringUtils.isTrimBlank(intrstNoMaxStr)){
                intrstNoMax = Integer.valueOf(intrstNoMaxStr);
            }else{
                intrstNoMax = 0;
            }

            for(int i=0; i<prodIntrstVoList.size();i++){
                //产品利率方案Id为空
                if(StringUtils.isTrimBlank(prodIntrstVoList.get(i).getProdIntrstId())){
                    //增加利率方案
                    if(!DeleteFlags.NOT_EXIST.getFlag().equals(prodIntrstVoList.get(i).getIntrstDelFlag())){
                        ProdIntrst prodIntrst = prodIntrstVoList.get(i).getEntity();
                        String intrstNo = StringUtils.addZeroForNum(++intrstNoMax,3);
                        prodIntrst.setProduct(productVo.getProduct());
                        prodIntrst.setIntrstNo(intrstNo);
                        prodIntrstInsertList.add(prodIntrst);
                        //增加利率方案因子
                        List<ProdIntrstFactorVo> prodIntrstFactorVoList = prodIntrstVoList.get(i).getProdIntrstFactorVoList();
                        for(int m=0; m<prodIntrstFactorVoList.size(); m++){
                            ProdIntrstFactor prodIntrstFactor = prodIntrstFactorVoList.get(m).getEntity();

                            prodIntrstFactor.setIntrstNo(intrstNo);
                            prodIntrstFactor.setProduct(productVo.getProduct());
                            prodIntrstFactorInsertList.add(prodIntrstFactor);
                        }
                    }
                }else{
                    //更新利率方案
                    if(!DeleteFlags.NOT_EXIST.getFlag().equals(prodIntrstVoList.get(i).getIntrstDelFlag())){
                        prodIntrstUpdateList.add(prodIntrstVoList.get(i).getEntity());
                        List<ProdIntrstFactorVo> prodIntrstFactorVoList = prodIntrstVoList.get(i).getProdIntrstFactorVoList();

                        //更新利率方案因子
                        if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorVoList)){
                            for(int m=0; m<prodIntrstFactorVoList.size(); m++){
                                prodIntrstFactorUpdateList.add(prodIntrstFactorVoList.get(m).getEntity());
                            }
                        }

                    }else{
                        //删除利率方案
                        prodIntrstDeleteIds.add(prodIntrstVoList.get(i).getProdIntrstId());
                        List<ProdIntrstFactorVo> prodIntrstFactorVoList = prodIntrstVoList.get(i).getProdIntrstFactorVoList();
                        //删除利率方案因子
                        if (ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorVoList)){
                            for(int m=0; m<prodIntrstFactorVoList.size(); m++){
                                prodIntrstFactorDeleteIds.add(prodIntrstFactorVoList.get(m).getProdIntrstFactorId());
                            }
                        }
                    }
                }
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstInsertList)){
                prodIntrstRepository.insertDataList(prodIntrstInsertList);
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstUpdateList)){
                prodIntrstRepository.updateByPrimaryKeySelectiveDataList(prodIntrstUpdateList);
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstDeleteIds)){
                prodIntrstRepository.deleteDataList(prodIntrstDeleteIds,new ProdIntrst());
            }

            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorInsertList)){
                prodIntrstFactorRepository.insertDataList(prodIntrstFactorInsertList);
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorUpdateList)){
                prodIntrstFactorRepository.updateByPrimaryKeySelectiveDataList(prodIntrstFactorUpdateList);
            }
            if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstFactorDeleteIds)){
                prodIntrstFactorRepository.deleteDataList(prodIntrstFactorDeleteIds,new ProdIntrstFactor());
            }
        }

        //更新前产品车型权限取得
        List<ProdVehicle> prodVehicleList = prodVehicleService.findProdVehicleByProduct(productVo.getProduct());
        List<ProdVehicleVo> prodVehicleVoListAfter = productVo.getProdVehicleVopList();
        List<String> deleteProdVehicleIds = new ArrayList<>();
        List<ProdVehicle> insertProdVehicleList = new ArrayList<>();
        //产品车型排序
        Collections.sort(prodVehicleVoListAfter,new Comparator<ProdVehicleVo>(){
            @Override
            public int compare(ProdVehicleVo arg0, ProdVehicleVo arg1) {
                return compareStr(arg0.getVehicleCode(),arg1.getVehicleCode());
            }
        });
        //与更新前产品车辆权限比较
        bef=0;after=0;
        ProdVehicleVo prodVehicleVoAfter = null;
        ProdVehicle prodVehicle = null;
        while(bef < prodVehicleList.size() || after < prodVehicleVoListAfter.size()) {
            if(bef < prodVehicleList.size()) {
                prodVehicle = prodVehicleList.get(bef);
            }else{
                prodVehicle = null;
            }
            if(after < prodVehicleVoListAfter.size()) {
                prodVehicleVoAfter = prodVehicleVoListAfter.get(after);
                prodVehicleVoAfter.setProduct(productVo.getProduct());
            }else{
                prodVehicleVoAfter = null;
            }
            if (compareObj(prodVehicle, prodVehicleVoAfter) < 0) {
                //更新后没有该记录，删除
                deleteProdVehicleIds.add(prodVehicle.getProdVehicleId());
                bef++;
            } else if (compareObj(prodVehicle, prodVehicleVoAfter) > 0) {
                //更新前没有该记录，增加
                insertProdVehicleList.add(prodVehicleVoAfter.getEntity());
                after++;
            } else {
                if (compareStr(prodVehicle.getVehicleCode(), prodVehicleVoAfter.getVehicleCode()) == 0) {
                    //不做操作
                    bef++;
                    after++;
                }
                if (compareStr(prodVehicle.getVehicleCode(), prodVehicleVoAfter.getVehicleCode()) < 0) {
                    //删除该记录
                    deleteProdVehicleIds.add(prodVehicle.getProdVehicleId());
                    bef++;
                } else if (compareStr(prodVehicle.getVehicleCode(), prodVehicleVoAfter.getVehicleCode()) > 0) {
                    //增加记录
                    insertProdVehicleList.add(prodVehicleVoAfter.getEntity());
                    after++;
                }
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(deleteProdVehicleIds)){
            prodVehicleRepository.deleteDataList(deleteProdVehicleIds, new ProdVehicle());
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(insertProdVehicleList)){
            prodVehicleRepository.insertDataList(insertProdVehicleList);
        }


        //更新前产品区域权限取得
        List<ProdGroup> prodGroupList = prodGroupService.findProdGroupsByProduct(productVo.getProduct());
        List<ProdGroupVo> prodGroupVoListAfter = productVo.getProdGroupVoList();
        List<String> deleteProdGroupIds = new ArrayList<>();
        List<ProdGroup> insertProdGroupList = new ArrayList<>();
        //产品车型排序
        Collections.sort(prodGroupVoListAfter,new Comparator<ProdGroupVo>(){
            @Override
            public int compare(ProdGroupVo arg0, ProdGroupVo arg1) {
                return compareStr(arg0.getGroupCode(),arg1.getGroupCode());
            }
        });
        //与更新前产品车辆权限比较
        bef=0;after=0;
        ProdGroupVo prodGroupVoAfter = null;
        ProdGroup prodGroup = null;
        while(bef < prodGroupList.size() || after < prodGroupVoListAfter.size()) {
            if (bef < prodGroupList.size()) {
                prodGroup = prodGroupList.get(bef);
            }else{
                prodGroup = null;
            }
            if (after < prodGroupVoListAfter.size()) {
                prodGroupVoAfter = prodGroupVoListAfter.get(after);
                prodGroupVoAfter.setProduct(productVo.getProduct());
            }else{
                prodGroupVoAfter = null;
            }
            if (compareObj(prodGroup, prodGroupVoAfter) < 0) {
                //更新后没有该记录，删除
                deleteProdGroupIds.add(prodGroup.getProdGroupId());
                bef++;
            } else if (compareObj(prodGroup, prodGroupVoAfter) > 0) {
                //更新前没有该记录，增加
                insertProdGroupList.add(prodGroupVoAfter.getEntity());
                after++;
            } else {
                if (compareStr(prodGroup.getGroupCode(), prodGroupVoAfter.getGroupCode()) == 0) {
                    //不做操作
                    bef++;
                    after++;
                }
                if (compareStr(prodGroup.getGroupCode(), prodGroupVoAfter.getGroupCode()) < 0) {
                    //删除该记录
                    deleteProdGroupIds.add(prodGroup.getProdGroupId());
                    bef++;
                } else if (compareStr(prodGroup.getGroupCode(), prodGroupVoAfter.getGroupCode()) > 0) {
                    //增加记录
                    insertProdGroupList.add(prodGroupVoAfter.getEntity());
                    after++;
                }
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(deleteProdGroupIds)){
            prodGroupRepository.deleteDataList(deleteProdGroupIds, new ProdGroup());
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(insertProdGroupList)){
            prodGroupRepository.insertDataList(insertProdGroupList);
        }

        //更新前产品附件权限取得
        List<ProdFile> prodFileList = prodFileService.findProdFilesByProduct(productVo.getProduct());
        List<ProdFileVo> prodFileVoListAfter = productVo.getProdFileVoList();
        List<String> deleteProdFileIds = new ArrayList<>();
        List<ProdFile> insertProdFileList = new ArrayList<>();
        //产品附件排序
        Collections.sort(prodFileVoListAfter,new Comparator<ProdFileVo>(){
            @Override
            public int compare(ProdFileVo arg0, ProdFileVo arg1) {
                return compareStr(arg0.getFileType(),arg1.getFileType());
            }
        });
        //与更新前产品附件权限比较
        bef=0;after=0;
        ProdFileVo prodFileVoAfter = null;
        ProdFile prodFile = null;
        while(bef < prodFileList.size() || after < prodFileVoListAfter.size()) {
            if(bef < prodFileList.size()) {
                prodFile = prodFileList.get(bef);
            }else{
                prodFile = null;
            }
            if(after < prodFileVoListAfter.size()) {
                prodFileVoAfter = prodFileVoListAfter.get(after);
                prodFileVoAfter.setProduct(productVo.getProduct());
            }else{
                prodFileVoAfter = null;
            }
            if (compareObj(prodFile, prodFileVoAfter) < 0) {
                //更新后没有该记录，删除
                deleteProdFileIds.add(prodFile.getProdFileId());
                bef++;
            } else if (compareObj(prodFile, prodFileVoAfter) > 0) {
                //更新前没有该记录，增加
                insertProdFileList.add(prodFileVoAfter.getEntity());
                after++;
            } else {
                if (compareStr(prodFile.getFileType(), prodFileVoAfter.getFileType()) == 0) {
                    //不做操作
                    bef++;
                    after++;
                }
                if (compareStr(prodFile.getFileType(), prodFileVoAfter.getFileType()) < 0) {
                    //删除该记录
                    deleteProdFileIds.add(prodFile.getProdFileId());
                    bef++;
                } else if (compareStr(prodFile.getFileType(), prodFileVoAfter.getFileType()) > 0) {
                    //增加记录
                    insertProdFileList.add(prodFileVoAfter.getEntity());
                    after++;
                }
            }
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(deleteProdFileIds)){
            prodFileRepository.deleteDataList(deleteProdFileIds, new ProdFile());
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(insertProdFileList)){
            prodFileRepository.insertDataList(insertProdFileList);
        }
    }
    /*
     *对象比较 空为最大值
     */
    public int compareObj(Object arg0, Object arg1){
        if(StringUtils.isTrimBlank(arg0)){
            return 1;
        }
        if(StringUtils.isTrimBlank(arg1)){
            return -1;
        }
        return 0;
    }

    /*
     *字符串比较
     */
    public int compareStr(String arg0, String arg1){
        if(StringUtils.isTrimBlank(arg0)){
            return 1;
        }
        if(StringUtils.isTrimBlank(arg1)){
            return -1;
        }
        return arg0.compareTo(arg1);
    }

    public int compareProdFinItem(ProdFinItem arg0, ProdFinItem arg1){
        String a = StringUtils.joinDelimiter(StringUtils.LINE, arg0.getFinItemType(), arg0.getFinItem());
        String b = StringUtils.joinDelimiter(StringUtils.LINE, arg1.getFinItemType(), arg1.getFinItem());
        return compareStr(a, b);
    }


    /**
     * @Title:
     * @Description: 修改产品方案管理
     * @param productModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public void modifyProduct(ProductModifyVo productModifyVo){
        productRepository.updateByPrimaryKeySelectiveData(productModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过productId删除产品方案管理
     * @param productDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public void deleteProduct(ProductDeleteVo productDeleteVo){
        productRepository.deleteData(productDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过productId集合删除产品方案管理
     * @param productDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    @Transactional
    public void deleteProductsByProductIds(ProductDeleteListVo productDeleteListVo){
        //删除产品方案
        productRepository.deleteDataList(productDeleteListVo.getProductIds(),productDeleteListVo.getEntity());
        //删除融资项目
        prodFinItemService.deleteProdFinItemByProducts(productDeleteListVo.getProducts());
        //删除利率方案
        prodIntrstService.deleteProdIntrstsByProduct(productDeleteListVo.getProducts());
        //删除车型权限
        prodVehicleService.deleteProdVehiclesByProducts(productDeleteListVo.getProducts());
        //删除用户组权限
        prodGroupService.deleteProdGroupsByProducts(productDeleteListVo.getProducts());
        //删除附件权限
        prodFileService.deleteProdFilesByProducts(productDeleteListVo.getProducts());
    }

    /**
     * @Title:
     * @Description:  根据productId获取产品方案管理
     * @param productId
     * @return Product
     * @throws
     * @author niehaibing
     * @date 2018-3-23 10:18:12
     */
    public Product findProductByProductId(String productId){
        return productRepository.selectByPrimaryKey(productId);
    }

    /**
     * @Title:
     * @Description:  根据机构代码等条件获取用户组及下层分组中的全部产品方案
     * @param productVo
     * @return List<ProductVo>
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @Override
    public List<ProductVo> findProductVoListByGroupCodes(ProductVo productVo) {
        // 根据机构代码，取得机构下的全部用户组代码
        List<String> groupCodeList = new ArrayList<>();
        try {
            groupCodeList = ResponseEntityUtils.getRestResponseData(sysGroupRpc.findSysGroupCodeListByGroupCode(productVo.getGroupCode()));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        // 产品大类代码
        if (StringUtils.isTrimBlank(productVo.getProductCatg())) {
            productVo.setProductCatg(null);
        }
        // 车辆类型
        if (StringUtils.isTrimBlank(productVo.getVehicleForm())) {
            productVo.setVehicleForm(null);
        }
        // 申请类型
        if (StringUtils.isTrimBlank(productVo.getApplyType())) {
            productVo.setApplyType(null);
        }
        return productRepository.selectProductVoListByGroupCodes(productVo, groupCodeList);
    }

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信ei息
     * @param productId
     * @return ProductVo
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @Override
    public ProductVo findProductVoByProductId(String productId) {

        //产品方案信息
        ProductVo productVo = productRepository.selectProductVoByProductId(productId);
        if(StringUtils.isTrimBlank(productVo)){
            throw new FmsServiceException( "产品方案不存在");
        }
        //产品融资项目
        List<ProdFinItem> prodFinItemList = prodFinItemService.findProdFinItemByProduct(productVo.getProduct());
        List<String> finItems = new ArrayList();
        List<String> finItemsIF = new ArrayList();
        List<String> finItemsFinal = new ArrayList();
        List<String> finItemsDep = new ArrayList();
        for(int i=0; i<prodFinItemList.size();i++){
            ProdFinItem prodFinItem = prodFinItemList.get(i);
            if(FinItemTypeEnums.FINANCE_ITEM.getType().equals(prodFinItem.getFinItemType())){
                finItems.add(prodFinItem.getFinItem());
            }else if(FinItemTypeEnums.INIT_FINAL_ITEM.getType().equals(prodFinItem.getFinItemType())){
                finItemsIF.add(prodFinItem.getFinItem());
            }else if(FinItemTypeEnums.FINAL_ITEM.getType().equals(prodFinItem.getFinItemType())){
                finItemsFinal.add(prodFinItem.getFinItem());
            }
            else{
                finItemsDep.add(prodFinItem.getFinItem());
            }
        }
        productVo.setProdFinItems(finItems);
        productVo.setProdFinItemsIF(finItemsIF);
        productVo.setProdFinItemsFinal(finItemsFinal);
        productVo.setProdFinItemsDep(finItemsDep);

        //根据产品方案代码取得利率方案信息和利率方案因子
        // 获取产品的利率方案
        List<ProdIntrstVo> prodIntrstVoList = prodIntrstService.findProdIntrstVoByProduct(productVo.getProduct());
        if(ArrayUtils.isNotNullAndLengthNotZero(prodIntrstVoList)){
            productVo.setProdIntrstVoList(prodIntrstVoList);
        }else{
            productVo.setProdIntrstVoList(new ArrayList<>());
        }


        //取得产品组织机构权限
        List<ProdGroupVo> prodGroupVoList = prodGroupRepository.selectProdGroupVosByProduct(productVo.getProduct());
        if(ArrayUtils.isNotNullAndLengthNotZero(prodGroupVoList)){
            productVo.setProdGroupVoList(prodGroupVoList);
        }else{
            productVo.setProdGroupVoList(new ArrayList<>());
        }

        //取得产品车型权限
        List<ProdVehicleVo> prodVehicleVoList = prodVehicleRepository.selectProdVehicleVosByProduct(productVo.getProduct());
        if(ArrayUtils.isNotNullAndLengthNotZero(prodVehicleVoList)){
            productVo.setProdVehicleVopList(prodVehicleVoList);
        }else{
            productVo.setProdVehicleVopList(new ArrayList<>());
        }

        //取得产品附件信息
        List<ProdFileVo> prodFileVoList = prodFileRepository.selectProdFileVosByProduct(productVo.getProduct());
        if(ArrayUtils.isNotNullAndLengthNotZero(prodFileVoList)){
            productVo.setProdFileVoList(prodFileVoList);
        }else{
            productVo.setProdFileVoList(new ArrayList<>());
        }
        return productVo;

    }

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信息
     * @param product
     * @return ProductVo
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    @Override
    public ProductVo findProductVoByProduct(String product) {
        // 取得产品方案信息
        Example example = SqlUtil.newExample(Product.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("product", product);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        Product productData = productRepository.selectOneByExample(example);
        ProductVo productVo = EntityUtils.getEntity(productData, new ProductVo());
        // 取得融资项目
        List<FinItemVo> finItemVos = finItemService.findFinItemVoByProduct(productVo.getProduct());
        productVo.setFinItemVoList(finItemVos);
        // 获取产品的利率方案
        List<ProdIntrstVo> prodIntrstVoList = prodIntrstService.findProdIntrstVoByProduct(productVo.getProduct());
        productVo.setProdIntrstVoList(prodIntrstVoList);
        // 取得产品的有权限的车型代码（包括制造商、品牌、车系、车型）
        List<String> vehicleCodeList = productRepository.selectVehicleCodeListByProduct(productVo.getProduct());
        productVo.setVehicleCodeList(vehicleCodeList);
        return productVo;
    }

}
