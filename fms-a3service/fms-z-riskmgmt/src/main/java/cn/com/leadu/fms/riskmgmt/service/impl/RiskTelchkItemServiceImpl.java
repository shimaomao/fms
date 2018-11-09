package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.RiskTelchkItemService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskTelchkItemRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchkitem.RiskTelchkItemVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.risktelchkitem.vo.RiskTelchkItemDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemService
 * @Description: 风控电核项目表业务实现层
 * @date 2018-06-04
 */
@Service
public class RiskTelchkItemServiceImpl implements RiskTelchkItemService {

    /**
     * @Fields  : 风控电核项目表repository
     */
    @Autowired
    private RiskTelchkItemRepository riskTelchkItemRepository;

    /**
     * @Title:
     * @Description: 分页查询风控电核项目表
     * @param riskTelchkItemVo
     * @return PageInfoExtend<RiskTelchkItem>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public PageInfoExtend<RiskTelchkItem> findRiskTelchkItemsByPage(RiskTelchkItemVo riskTelchkItemVo){
        Example example = SqlUtil.newExample(RiskTelchkItem.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RiskTelchkItem> pageInfo = riskTelchkItemRepository.selectListByExamplePage(example,riskTelchkItemVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存风控电核项目表
     * @param riskTelchkItemSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public void saveRiskTelchkItem(RiskTelchkItemSaveVo riskTelchkItemSaveVo){
        riskTelchkItemRepository.insertData(riskTelchkItemSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改风控电核项目表
     * @param riskTelchkItemModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public void modifyRiskTelchkItem(RiskTelchkItemModifyVo riskTelchkItemModifyVo){
        riskTelchkItemRepository.updateByPrimaryKeySelectiveData(riskTelchkItemModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过telchkItemId删除风控电核项目表
     * @param riskTelchkItemDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public void deleteRiskTelchkItem(RiskTelchkItemDeleteVo riskTelchkItemDeleteVo){
        riskTelchkItemRepository.deleteData(riskTelchkItemDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过telchkItemId集合删除风控电核项目表
     * @param riskTelchkItemDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public void deleteRiskTelchkItemsByTelchkItemIds(RiskTelchkItemDeleteListVo riskTelchkItemDeleteListVo){
        riskTelchkItemRepository.deleteDataList(riskTelchkItemDeleteListVo.getTelchkItemIds(),riskTelchkItemDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据telchkItemId获取风控电核项目表
     * @param telchkItemId
     * @return RiskTelchkItem
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:08
     */
    public RiskTelchkItem findRiskTelchkItemByTelchkItemId(String telchkItemId){
        return riskTelchkItemRepository.selectByPrimaryKey(telchkItemId);
    }

}
