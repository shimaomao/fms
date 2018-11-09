package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasAreaService;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaSaveVo;
import cn.com.leadu.fms.business.service.CommonBasAreaService;
import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.CommonPropertyConstants;
import cn.com.leadu.fms.common.constant.enums.baseinfo.AreaEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BasAreaRedisKeyEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasAreaRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author niehaibing
 * @ClassName: BasAreaService
 * @Description: 省市县信息维护业务实现层
 * @date 2018-03-15
 */
@Service
public class BasAreaServiceImpl implements BasAreaService , CommonBasAreaService {

    /**
     * @Fields  : 省市县信息维护repository
     */
    @Autowired
    private BasAreaRepository basAreaRepository;

    /**
     * @Fields  : redis
     * @author qiaomengnan
     */
    @Autowired
    private RedisService redisService;

    /**
     * @Title:
     * @Description: 分页查询省市县信息维护
     * @param basAreaVo
     * @return PageInfoExtend<BasArea>
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public PageInfoExtend<BasAreaVo> findBasAreasByPage(BasAreaVo basAreaVo){
        if(StringUtils.isNotTrimBlank( basAreaVo.getAreaName())){
            basAreaVo.setAreaName(SqlUtil.likePattern(basAreaVo.getAreaName()));
        }else{
            basAreaVo.setAreaName(null);
        }
        if(StringUtils.isNotTrimBlank(basAreaVo.getAreaCode())){
            basAreaVo.setAreaCode(SqlUtil.likePattern(basAreaVo.getAreaCode()));
        }else{
            basAreaVo.setAreaCode(null);
        }
        PageInfoExtend<BasAreaVo> pageInfo = basAreaRepository.selectListVoByPage("selectBasAreaVosByPage",basAreaVo,basAreaVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存省市县信息维护
     * @param basAreaSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public void saveBasArea(BasAreaSaveVo basAreaSaveVo){
        basAreaRepository.insertData(basAreaSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改省市县信息维护
     * @param basAreaModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public void modifyBasArea(BasAreaModifyVo basAreaModifyVo){
        basAreaRepository.updateByPrimaryKeySelectiveData(basAreaModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过areaId删除省市县信息维护
     * @param basAreaDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public void deleteBasArea(BasAreaDeleteVo basAreaDeleteVo){
        basAreaRepository.deleteData(basAreaDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过areaId集合删除省市县信息维护
     * @param basAreaDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public void deleteBasAreasByAreaIds(BasAreaDeleteListVo basAreaDeleteListVo){
        basAreaRepository.deleteDataList(basAreaDeleteListVo.getAreaIds(),basAreaDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据areaId获取省市县信息维护
     * @param areaId
     * @return BasArea
     * @throws
     * @author niehaibing
     * @date 2018-3-15 16:20:27
     */
    public BasAreaVo findBasAreaByAreaId(String areaId){
        return basAreaRepository.selectBasAreaVosByAreaId(areaId);
    }

    /**
     * @Title:
     * @Description: 返回省市树状
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:44
     */
    public Map<String,Object> findBasAreas(){
        Object result = redisService.get(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES.getPrefix());
        if(result == null)
            return initBasAreas();
        else{
            Map<String,Object> results = new HashMap<>();
            Integer version = (Integer) redisService.get(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES_VERSION.getPrefix());
            if(version == null)
                version = 0;
            results.put(CommonPropertyConstants.COMMON_AREA_VALUES,(Map<String,BasAreaTreeVo>)result);
            results.put(CommonPropertyConstants.COMMON_AREA_VALUES_VERSION,version);
            return results;
        }
    }

    /**
     * @Title:
     * @Description: 初始化省市到redis中
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    public Map<String,Object> initBasAreas(){
        Map<String,BasAreaTreeVo> basAreaTreeVos = findBasAreaByTree();
        if(basAreaTreeVos != null) {
            Map<String, Object> result = new HashMap<>();
            //设置版本值
            Integer version = (Integer) redisService.get(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES_VERSION.getPrefix());
            if (version == null)
                version = 0;
            else
                version += 1;
            redisService.save(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES.getPrefix(), basAreaTreeVos);
            redisService.save(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES_VERSION.getPrefix(), version);
            result.put(CommonPropertyConstants.COMMON_AREA_VALUES, basAreaTreeVos);
            result.put(CommonPropertyConstants.COMMON_AREA_VALUES_VERSION, version);
            return result;
        }
        return null;
    }

    /**
     * @Title:
     * @Description: 查询省市版本值
     * @param:
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/24 0024 23:45
     */
    public Integer findBasAreaValuesVersion(){
        //返回版本值
        Integer version = (Integer) redisService.get(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES_VERSION.getPrefix());
        if(version == null)
            version = 0;
        return version;
    }

    /**
     * @Title:
     * @Description:
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018/02/23 03:13:07
     */
    public Map<String,BasAreaTreeVo> findBasAreaByTree(){
        Map<String,BasAreaTreeVo> basAreaTreeVos = getBasAreaVoByTree();
        return basAreaTreeVos;
    }

    @Override
    public BasArea findBasAreaByAreaCode(String areaCode) {
            Example example = SqlUtil.newExample(BasArea.class);
            Example.Criteria criteria = example.createCriteria();
            if(StringUtils.isNotTrimBlank(areaCode))
                criteria.andLike("areaCode", SqlUtil.likePattern(areaCode));
            SqlUtil.setOrderByCreateTimeDesc(example);
            return basAreaRepository.selectOneByExample(example);


    }

    /**
     * @Title:
     * @Description:   查出所有省市縣并且分出上下级
     * @return
     * @throws
     * @author huchenghao
     * @date 2018/02/25 03:37:08
     */
    private Map<String,BasAreaTreeVo> getBasAreaVoByTree(){
        Example example = SqlUtil.newExample(BasArea.class);
        SqlUtil.andEqualToDeleteExist(example.createCriteria());
        SqlUtil.setOrderByColumnAsc(example,"area_code");
        //查出所有省市縣
        List<BasArea> basAreas = basAreaRepository.selectListByExample(example);
        //保存字典树
        BasAreaTreeVo basAreaTreeVo=new BasAreaTreeVo();
        Map<String,BasAreaTreeVo> basAreaTreeVos = new LinkedHashMap<>();
        //省份list
        ArrayList<BasArea> provincelist = new ArrayList<BasArea>();
        //省份-市list
        HashMap<String,List<BasArea>> cityMap=new HashMap<String,List<BasArea>>();
        //省份-县list
        HashMap<String,List<BasArea>> areaMap=new HashMap<String,List<BasArea>>();

        //区域名称Map
        HashMap<String,String> areaNameMap=new HashMap<String,String>();

        //区域list
        for(BasArea basArea : basAreas) {
            areaNameMap.put(basArea.getAreaCode(), basArea.getAreaName());
            //循环第一级省份
            if (basArea.getAreaLevel().equals(AreaEnums.PROVINCE.getType())) {
                provincelist.add(basArea);
            }
            //循环市
            if (basArea.getAreaLevel().equals(AreaEnums.CITY.getType())) {
                mapListAdd(cityMap,basArea);
            }
            //循环县
            if (basArea.getAreaLevel().equals(AreaEnums.AREA.getType())) {
                mapListAdd(areaMap,basArea);
            }
        }

        basAreaTreeVo.setAreaMap(areaNameMap);
        basAreaTreeVo.setAreaMapList(areaMap);
        basAreaTreeVo.setCityMapList(cityMap);
        basAreaTreeVo.setProvinceList(provincelist);
        basAreaTreeVos.put(CommonAreaConstants.PROVINCE,basAreaTreeVo);
        return basAreaTreeVos;
    }
    /**
     * @Title:
     * @Description: 设置区域map
     * @return
     * @throws
     * @author huchenghao
     * @date 2018/02/25 03:37:08
     */
    private void mapListAdd(HashMap<String, List<BasArea>> areaMap, BasArea basArea) {
        if(areaMap.containsKey(basArea.getParentAreaCode())){
            areaMap.get(basArea.getParentAreaCode()).add(basArea);
        }else{
            ArrayList<BasArea> arealist = new ArrayList<BasArea>();
            arealist.add(basArea);
            areaMap.put(basArea.getParentAreaCode(), arealist);
        }
    }

}
