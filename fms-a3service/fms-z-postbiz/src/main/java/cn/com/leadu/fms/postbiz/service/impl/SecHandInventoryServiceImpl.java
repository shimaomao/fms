package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.postbiz.SecHandInventoryEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.SecHandInventoryService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.SecHandInventoryRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import cn.com.leadu.fms.postbiz.validator.sechandinventory.vo.SecHandInventorySaveVo;
import cn.com.leadu.fms.postbiz.validator.sechandinventory.vo.SecHandInventoryModifyVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryService
 * @Description: 库存管理业务实现层
 */
@Service
public class SecHandInventoryServiceImpl implements SecHandInventoryService {

    /**
     * @Fields  : 库存管理repository
     */
    @Autowired
    private SecHandInventoryRepository secHandInventoryRepository;

    @Autowired
    private BasVehicleRepository basVehicleRepository;

    /**
     * @Title:
     * @Description: 分页查询库存管理
     * @param secHandInventoryVo
     * @return PageInfoExtend<SecHandInventory>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:22
     */
    public PageInfoExtend<SecHandInventoryVo> findSecHandInventoryVosByPage(SecHandInventoryVo secHandInventoryVo){

        if (StringUtils.isNotTrimBlank(secHandInventoryVo.getVinNo())){
            secHandInventoryVo.setVinNo(SqlUtil.likePattern(secHandInventoryVo.getVinNo()));
        }else{
            secHandInventoryVo.setVinNo(null);
        }

        if (StringUtils.isNotTrimBlank(secHandInventoryVo.getEngineNo())){
            secHandInventoryVo.setEngineNo(SqlUtil.likePattern(secHandInventoryVo.getEngineNo()));
        }else{
            secHandInventoryVo.setEngineNo(null);
        }

        if (StringUtils.isNotTrimBlank(secHandInventoryVo.getVehicleName())){
            secHandInventoryVo.setVehicleName(SqlUtil.likePattern(secHandInventoryVo.getVehicleName()));
        }else{
            secHandInventoryVo.setVehicleName(null);
        }
        //收车入库开始时间
        if(StringUtils.isTrimBlank(secHandInventoryVo.getStartTime()))
            secHandInventoryVo.setStartTime(null);
        //收车入库结束时间
        if(StringUtils.isTrimBlank(secHandInventoryVo.getEndTime()))
            secHandInventoryVo.setEndTime(null);
        PageInfoExtend<SecHandInventoryVo> pageInfo = secHandInventoryRepository.selectListVoByPage("selectSecHandInventoryVosByPage",secHandInventoryVo,secHandInventoryVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存库存管理
     * @param secHandInventorySaveVo
     * @return java.lang.String
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:22
     */
    public void saveSecHandInventory(SecHandInventorySaveVo secHandInventorySaveVo){
        Example example = new Example(SecHandInventory.class);
        //设置查询条件
        example.createCriteria().andEqualTo("vinNo",secHandInventorySaveVo.getVinNo());
        SecHandInventory secHandInventory = secHandInventoryRepository.selectOneByExample(example);
        if (secHandInventory != null) {
            throw new FmsServiceException("库存已有该车辆");
        }
        secHandInventorySaveVo.setCarSource(SecHandInventoryEnums.MANUALIMPORT.getType());
        secHandInventoryRepository.insertData(secHandInventorySaveVo.getEntity());

    }

    /**
     * @Title:
     * @Description: 修改库存管理
     * @param secHandInventoryModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:22
     */
    public void modifySecHandInventory(SecHandInventoryModifyVo secHandInventoryModifyVo){

        if (secHandInventoryModifyVo.getCarSource().equals(SecHandInventoryEnums.CARDISPOSE.getType())){
            throw new FmsServiceException("车辆处置从数据不可更改！");

        }
        secHandInventoryRepository.updateByPrimaryKeySelectiveData(secHandInventoryModifyVo.getEntity());
    }


    /**
     * @Title:
     * @Description:  根据secHandId获取库存管理
     * @param secHandId
     * @return SecHandInventory
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:22
     */
    public SecHandInventoryVo findSecHandInventoryVoBySecHandId(String secHandId){

        SecHandInventoryVo secHandInventoryVo = new SecHandInventoryVo();
        SecHandInventory secHandInventory = secHandInventoryRepository.selectByPrimaryKey(secHandId);
        if (secHandInventory != null) {
            secHandInventoryVo = EntityUtils.getEntity(secHandInventory, new SecHandInventoryVo());
            Example example = new Example(BasVehicle.class);
            //获取催人人员名称
            example.createCriteria().andEqualTo("vehicleCode",secHandInventoryVo.getVehicleCode());
            BasVehicle basVehicle = basVehicleRepository.selectOneByExample(example);
            if (basVehicle != null) {
                secHandInventoryVo.setVehicleName(basVehicle.getVehicleName());
            }

        }
        return secHandInventoryVo;
    }

}
