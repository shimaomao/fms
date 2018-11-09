package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.constant.enums.product.FinItemTypeEnums;
import cn.com.leadu.fms.product.service.FinItemService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.FinItemRepository;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemSaveVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemModifyVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemDeleteVo;
import cn.com.leadu.fms.product.validator.finitem.vo.FinItemDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: FinItemService
 * @Description: 融资项目管理业务实现层
 * @date 2018-03-19
 */
@Service
public class FinItemServiceImpl implements FinItemService {

    /**
     * @Fields  : 融资项目管理repository
     */
    @Autowired
    private FinItemRepository finItemRepository;

    /**
     * @Title:
     * @Description: 分页查询融资项目管理
     * @param finItemVo
     * @return PageInfoExtend<FinItem>
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public PageInfoExtend<FinItem> findFinItemsByPage(FinItemVo finItemVo){
        //finItemName
        Example example = SqlUtil.newExample(FinItem.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank( finItemVo.getFinItemName()))
            criteria.andLike("finItemName", SqlUtil.likePattern(finItemVo.getFinItemName()));

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<FinItem> pageInfo = finItemRepository.selectListByExamplePage(example,finItemVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存融资项目管理
     * @param finItemSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public void saveFinItem(FinItemSaveVo finItemSaveVo){
        finItemRepository.insertData(finItemSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改融资项目管理
     * @param finItemModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public void modifyFinItem(FinItemModifyVo finItemModifyVo){
        finItemRepository.updateByPrimaryKeySelectiveData(finItemModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finItemId删除融资项目管理
     * @param finItemDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public void deleteFinItem(FinItemDeleteVo finItemDeleteVo){
        finItemRepository.deleteData(finItemDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finItemId集合删除融资项目管理
     * @param finItemDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public void deleteFinItemsByFinItemIds(FinItemDeleteListVo finItemDeleteListVo){
        finItemRepository.deleteDataList(finItemDeleteListVo.getFinItemIds(),finItemDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @param finItemId
     * @return FinItem
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    public FinItem findFinItemByFinItemId(String finItemId){
        return finItemRepository.selectByPrimaryKey(finItemId);
    }

    /**
     * @Title:
     * @Description:  根据finItem获取融资项目管理
     * @param finItem
     * @return FinItem
     * @throws
     * @author huchenghao
     * @date 2018-3-19 11:03:18
     */
    public FinItem findFinItemByFinItem(String finItem){
        Example example = SqlUtil.newExample(FinItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("finItem", finItem);
        return finItemRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据product 获取融资项目信息
     * @param product
     * @return List<FinItemVo>
     * @throws
     * @author wangxue
     * @date 2018-3-19 11:03:18
     */
    @Override
    public List<FinItemVo> findFinItemVoByProduct(String product) {
        List<FinItemVo> finItemVos = new ArrayList<>();
        List<FinItemVo> tempList = finItemRepository.selectFinItemVoListByProduct(product);
        if (ArrayUtils.isNotNullAndLengthNotZero(tempList)) {
            FinItemVo tempFinItemVo = new FinItemVo();
            String finItem = "";
            for (FinItemVo finItemVo : tempList) {
                if (StringUtils.equals(finItem, finItemVo.getFinItem())) {
                    setFinItemType(tempFinItemVo, finItemVo.getFinItemType());
                } else {
                    if (StringUtils.notEquals("", finItem)) {
                        finItemVos.add(tempFinItemVo);
                    }
                    finItem = finItemVo.getFinItem();
                    tempFinItemVo = EntityUtils.getEntity(finItemVo, new FinItemVo());
                    tempFinItemVo.setInitFinalItemFlag(0);
                    tempFinItemVo.setFinalItemFlag(0);
                    tempFinItemVo.setDepositItemFlag(0);
                    setFinItemType(tempFinItemVo, finItemVo.getFinItemType());

                }
            }
            if (StringUtils.notEquals("", finItem)) {
                finItemVos.add(tempFinItemVo);
            }
        }
        return finItemVos;
    }

    /**
     * @Title:
     * @Description:  根据产品方案代码，获取产品方案信息
     * @param finItemVo 融资项目Vo
     * @param finItemType 融资项目类型
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    private void setFinItemType(FinItemVo finItemVo, String finItemType) {
        if (FinItemTypeEnums.INIT_FINAL_ITEM.getType().equals(finItemType)) {
            // 首尾付融资项目
            finItemVo.setInitFinalItemFlag(1);
        } else if (FinItemTypeEnums.DEPOSIT_ITEM.getType().equals(finItemType)) {
            // 保证金融资项目
            finItemVo.setDepositItemFlag(1);
        }else if (FinItemTypeEnums.FINAL_ITEM.getType().equals(finItemType)) {
            // 保证金融资项目
            finItemVo.setFinalItemFlag(1);
        }
    }


    /**
     * @Title:
     * @Description:  取得所有融资项目
     * @throws
     * @author wangxue
     * @date 2018-3-23 16:18:12
     */
    public List<FinItem> findAllFinItemList() {
        return finItemRepository.selectAll();
    }
}
