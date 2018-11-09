package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.postbiz.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.postbiz.service.CarCollectCompService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.CarCollectCompRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp.CarCollectCompVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompSaveVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompModifyVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompDeleteVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompDeleteListVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompService
 * @Description: 收车机构维护业务实现层
 * @date 2018-05-22
 */
@Slf4j
@Service
public class CarCollectCompServiceImpl implements CarCollectCompService {

    /**
     * @Fields  : 收车机构维护repository
     */
    @Autowired
    private CarCollectCompRepository carCollectCompRepository;

    @Autowired
    private BizFilesRpc bizFilesRpc;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询收车机构维护
     * @param carCollectCompVo
     * @return PageInfoExtend<CarCollectComp>
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public PageInfoExtend<CarCollectComp> findCarCollectCompsByPage(CarCollectCompVo carCollectCompVo){
        Example example = SqlUtil.newExample(CarCollectComp.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(carCollectCompVo.getCarCollectCompCode()))
            criteria.andLike("carCollectCompCode",SqlUtil.likePattern(carCollectCompVo.getCarCollectCompCode()));

        if (StringUtils.isNotTrimBlank(carCollectCompVo.getCarCollectCompName()))
            criteria.andLike("carCollectCompName",SqlUtil.likePattern(carCollectCompVo.getCarCollectCompName()));

        SqlUtil.setOrderByUpdateTimeDesc(example);
        PageInfoExtend<CarCollectComp> pageInfo = carCollectCompRepository.selectListByExamplePage(example,carCollectCompVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存收车机构维护
     * @param carCollectCompSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Transactional
    public void saveCarCollectComp(CarCollectCompSaveVo carCollectCompSaveVo){
        // 保存附件信息
        if(carCollectCompSaveVo.getBizfilesVo()!=null){
            CarCollectCompVo carCollectCompVo = EntityUtils.getEntity(carCollectCompSaveVo, new CarCollectCompVo());
            bizFilesService.saveBizFiles(carCollectCompVo.getBizfilesVo().getBizFilesListVos(), carCollectCompVo.getCarCollectCompCode(), BizCodeTypeEnums.CAR_COLLECT_COMP.getCodeType());
        }
        carCollectCompRepository.insertData(carCollectCompSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改收车机构维护
     * @param carCollectCompModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    @Transactional
    public void modifyCarCollectComp(CarCollectCompModifyVo carCollectCompModifyVo){
        // 修改附件信息
        if(carCollectCompModifyVo.getBizfilesVo()!=null){
            CarCollectCompVo carCollectCompVo = EntityUtils.getEntity(carCollectCompModifyVo, new CarCollectCompVo());
            bizFilesService.updateBizFiles(carCollectCompVo.getBizfilesVo().getBizFilesListVos(),carCollectCompVo.getCarCollectCompCode(),BizCodeTypeEnums.CAR_COLLECT_COMP.getCodeType());
        }
        carCollectCompRepository.updateByPrimaryKeySelectiveData(carCollectCompModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过carCollectCompId删除收车机构维护
     * @param carCollectCompDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public void deleteCarCollectComp(CarCollectCompDeleteVo carCollectCompDeleteVo){
        carCollectCompRepository.deleteData(carCollectCompDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过carCollectCompId集合删除收车机构维护
     * @param carCollectCompDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public void deleteCarCollectCompsByCarCollectCompIds(CarCollectCompDeleteListVo carCollectCompDeleteListVo){
        carCollectCompRepository.deleteDataList(carCollectCompDeleteListVo.getCarCollectCompIds(),carCollectCompDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 通过carCollectCompCode获取收车机构维护
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public CarCollectComp findCarCollectCompByCarCollectCompCode(String carCollectCompCode){
        Example example = SqlUtil.newExample(CarCollectComp.class);
        example.createCriteria().andEqualTo("carCollectCompCode",carCollectCompCode);
        return carCollectCompRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  根据carCollectCompId获取收车机构维护
     * @param carCollectCompId
     * @return CarCollectComp
     * @throws
     * @author yanfengbo
     * @date 2018-5-22 10:04:12
     */
    public CarCollectCompVo findCarCollectCompByCarCollectCompId(String carCollectCompId){
        CarCollectComp carCollectComp = carCollectCompRepository.selectByPrimaryKey(carCollectCompId);
        CarCollectCompVo carCollectCompVo = EntityUtils.getEntity(carCollectComp, new CarCollectCompVo());

        try {
            CommonBizFilesVo bizFilesVo= ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesCarCollectComp(carCollectCompVo.getCarCollectCompCode()));
            carCollectCompVo.setBizfilesVo(bizFilesVo);
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return carCollectCompVo;
    }

}
