package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasVehicleService;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasVehicleRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.BasVehicleSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasVehicleService
 * @Description: 车辆信息维护业务实现层
 * @date 2018-03-20
 */
@Service
public class BasVehicleServiceImpl implements BasVehicleService {

    /**
     * @Fields  : 车辆信息维护repository
     */
    @Autowired
    private BasVehicleRepository basVehicleRepository;

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护
     * @param basVehicleVo
     * @return PageInfoExtend<BasVehicle>
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public PageInfoExtend<BasVehicle> findBasVehiclesByPage(BasVehicleVo basVehicleVo){
        Example example = SqlUtil.newExample(BasVehicle.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank( basVehicleVo.getVehicleLevel()))
            criteria.andEqualTo("vehicleLevel",basVehicleVo.getVehicleLevel());
        if(StringUtils.isNotTrimBlank(basVehicleVo.getVehicleName())){
            criteria.andLike("vehicleName",SqlUtil.likePattern(basVehicleVo.getVehicleName()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BasVehicle> pageInfo = basVehicleRepository.selectListByExamplePage(example,basVehicleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存车辆信息维护
     * @param basVehicleSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public void saveBasVehicle(BasVehicleSaveVo basVehicleSaveVo){
        basVehicleRepository.insertData(basVehicleSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改车辆信息维护
     * @param basVehicleModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public void modifyBasVehicle(BasVehicleModifyVo basVehicleModifyVo){
        basVehicleRepository.updateByPrimaryKeySelectiveData(basVehicleModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过vehicleId删除车辆信息维护
     * @param basVehicleDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public void deleteBasVehicle(BasVehicleDeleteVo basVehicleDeleteVo){
        basVehicleRepository.deleteData(basVehicleDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过vehicleId集合删除车辆信息维护
     * @param basVehicleDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public void deleteBasVehiclesByVehicleIds(BasVehicleDeleteListVo basVehicleDeleteListVo){
        Example example = SqlUtil.newExample(BasVehicle.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("vehicleId", basVehicleDeleteListVo.getVehicleIds());
        List<BasVehicle> basVehicleList = basVehicleRepository.selectListByExample(example);
        for(BasVehicle basVehicle : basVehicleList){
            Example exampleP = SqlUtil.newExample(BasVehicle.class);
            Example.Criteria criteriaP = exampleP.createCriteria();
            criteriaP.andEqualTo("parentVehicleCode", basVehicle.getVehicleCode())
                    .andNotIn("vehicleId", basVehicleDeleteListVo.getVehicleIds());
            List<BasVehicle> basVehicleListP = basVehicleRepository.selectListByExample(exampleP);
            if(basVehicleListP != null && basVehicleListP.size()>0){
                throw new FmsServiceException("请先删除父级代码为" + basVehicle.getVehicleCode() + "的车型");
            }
        }
        basVehicleRepository.deleteDataList(basVehicleDeleteListVo.getVehicleIds(),basVehicleDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据vehicleId获取车辆信息维护
     * @param vehicleId
     * @return BasVehicle
     * @throws
     * @author niehaibing
     * @date 2018-3-20 13:33:20
     */
    public BasVehicleVo findBasVehicleByVehicleId(String vehicleId){
        return basVehicleRepository.findBasVehicleByVehicleId(vehicleId);
    }

    /**
     * @Title:
     * @Description:  根据vehicleCode获取车辆信息维护
     * @param vehicleCode
     * @return BasVehicle
     * @throws
     * @author huchenghao
     * @date 2018-3-20 13:33:20
     */
    public BasVehicle findBasVehicleByVehicleCode(String vehicleCode){
        Example example=SqlUtil.newExample(BasVehicle.class);
        example.createCriteria().andEqualTo("vehicleCode",vehicleCode);
        return basVehicleRepository.selectOneByExample(example);
    }



    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param basVehicleVo
     * @return PageInfoExtend<BasVehicleVo>
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @Override
    public PageInfoExtend<BasVehicleVo> findBasVehiclesVosByPage(BasVehicleVo basVehicleVo) {
        // 车型名称
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehicleName())) {
            basVehicleVo.setVehicleName(SqlUtil.likePattern(basVehicleVo.getVehicleName()));
        } else {
            basVehicleVo.setVehicleName(null);
        }
        // 车系名称
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehSeriesName())) {
            basVehicleVo.setVehSeriesName(SqlUtil.likePattern(basVehicleVo.getVehSeriesName()));
        } else {
            basVehicleVo.setVehSeriesName(null);
        }
        // 品牌名称
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehBrandName())) {
            basVehicleVo.setVehBrandName(SqlUtil.likePattern(basVehicleVo.getVehBrandName()));
        } else {
            basVehicleVo.setVehBrandName(null);
        }
        // 制造商名称
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehMakerName())) {
            basVehicleVo.setVehMakerName(SqlUtil.likePattern(basVehicleVo.getVehMakerName()));
        } else {
            basVehicleVo.setVehMakerName(null);
        }
        // 车辆Code
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehicleCodes())) {
            basVehicleVo.setVehicleCodeList(StringUtils.splitCommaToList(basVehicleVo.getVehicleCodes()));
        }
        // 车辆类型
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehicleTypes())) {
            basVehicleVo.setVehicleTypeList(StringUtils.splitCommaToList(basVehicleVo.getVehicleTypes()));
        }
        //是否启用
        if(StringUtils.isTrimBlank(basVehicleVo.getEnableFlag())){
            basVehicleVo.setEnableFlag(null);
        }
        // 车辆指导价
        if (StringUtils.isNotTrimBlank(basVehicleVo.getGuidePrice())) {
            basVehicleVo.setGuidePrice(basVehicleVo.getGuidePrice());
        } else {
            basVehicleVo.setGuidePrice(null);
        }
        PageInfoExtend<BasVehicleVo> pageInfo = basVehicleRepository.selectListVoByPage("selectBasVehicleVosByPages", basVehicleVo, basVehicleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param basVehicleVo
     * @return PageInfoExtend<BasVehicleVo>
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @Override
    public PageInfoExtend<BasVehicleVo> findBasVehicleLevelsByPage(BasVehicleVo basVehicleVo) {
        // 名称
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehicleName())) {
            basVehicleVo.setVehicleName(SqlUtil.likePattern(basVehicleVo.getVehicleName()));
        } else {
            basVehicleVo.setVehicleName(null);
        }
        // 层级
        if (StringUtils.isNotTrimBlank(basVehicleVo.getVehicleLevel())) {
            basVehicleVo.setVehicleLevel(basVehicleVo.getVehicleLevel());
        } else {
            basVehicleVo.setVehicleLevel(null);
        }
        PageInfoExtend<BasVehicleVo> pageInfo = basVehicleRepository.selectListVoByPage("findBasVehicleLevelsByPages", basVehicleVo, basVehicleVo.getPageQuery());
        return pageInfo;
    }
    /**
     * @Title:
     * @Description: 根据车辆型号取得相关信息
     * @param vehicleCode
     * @return PageInfoExtend<BasVehicle>
     * @throws
     * @author huchenghao
     * @date 2018-3-30 17:33:19
     */
    @Override
    public BasVehicleVo findBasVehicleVoByVehicleCode(String vehicleCode) {
        return basVehicleRepository.selectBasVehicleVoByVehicleCode(vehicleCode);
    }
}
