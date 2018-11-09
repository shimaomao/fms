package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.prebiz.service.RationalityPurchaseService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.RationalityPurchaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import cn.com.leadu.fms.pojo.prebiz.vo.rationalitypurchase.RationalityPurchaseVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseSaveVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseModifyVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseDeleteVo;
import cn.com.leadu.fms.prebiz.validator.rationalitypurchase.vo.RationalityPurchaseDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseService
 * @Description: 购买合理性业务实现层
 * @date 2018-05-29
 */
@Service
public class RationalityPurchaseServiceImpl implements RationalityPurchaseService {

    /**
     * @Fields  : 购买合理性repository
     */
    @Autowired
    private RationalityPurchaseRepository rationalityPurchaseRepository;

    /**
     * @Title:
     * @Description: 分页查询购买合理性
     * @param rationalityPurchaseVo
     * @return PageInfoExtend<RationalityPurchase>
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public PageInfoExtend<RationalityPurchase> findRationalityPurchasesByPage(RationalityPurchaseVo rationalityPurchaseVo){
        Example example = SqlUtil.newExample(RationalityPurchase.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RationalityPurchase> pageInfo = rationalityPurchaseRepository.selectListByExamplePage(example,rationalityPurchaseVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存购买合理性
     * @param rationalityPurchaseSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public void saveRationalityPurchase(RationalityPurchaseSaveVo rationalityPurchaseSaveVo){
        rationalityPurchaseRepository.insertData(rationalityPurchaseSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改购买合理性
     * @param rationalityPurchaseModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public void modifyRationalityPurchase(RationalityPurchaseModifyVo rationalityPurchaseModifyVo){
        rationalityPurchaseRepository.updateByPrimaryKeySelectiveData(rationalityPurchaseModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过buyCarId删除购买合理性
     * @param rationalityPurchaseDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public void deleteRationalityPurchase(RationalityPurchaseDeleteVo rationalityPurchaseDeleteVo){
        rationalityPurchaseRepository.deleteData(rationalityPurchaseDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过buyCarId集合删除购买合理性
     * @param rationalityPurchaseDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public void deleteRationalityPurchasesByBuyCarIds(RationalityPurchaseDeleteListVo rationalityPurchaseDeleteListVo){
        rationalityPurchaseRepository.deleteDataList(rationalityPurchaseDeleteListVo.getBuyCarIds(),rationalityPurchaseDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据buyCarId获取购买合理性
     * @param buyCarId
     * @return RationalityPurchase
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public RationalityPurchase findRationalityPurchaseByBuyCarId(String buyCarId){
        return rationalityPurchaseRepository.selectByPrimaryKey(buyCarId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo更新购买合理性
     * @param rationalityPurchase
     * @return RationalityPurchase
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public void modifyRationalityPurchaseByApplyNo(RationalityPurchase rationalityPurchase,String applyNo) {
        Example example = SqlUtil.newExample(RationalityPurchase.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        RationalityPurchase oldRationalityPurchase = rationalityPurchaseRepository.selectOneByExample(example);
        rationalityPurchase.setApplyNo(applyNo);
        rationalityPurchase.setDelFlag(DeleteFlags.EXIST.getFlag());
        if(oldRationalityPurchase != null){
            rationalityPurchase.setCreateTime(oldRationalityPurchase.getCreateTime());
            rationalityPurchase.setCreator(oldRationalityPurchase.getCreator());
        }
        rationalityPurchaseRepository.updateByExampleData(rationalityPurchase,example);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取购买合理性
     * @param applyNo
     * @return RationalityPurchase
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public RationalityPurchase findRationalityPurchaseByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(RationalityPurchase.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return rationalityPurchaseRepository.selectOneByExample(example);
    }


}
