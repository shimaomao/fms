package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.rpc.baseinfo.BasAreaRpc;
import cn.com.leadu.fms.business.rpc.system.SysCodeRpc;
import cn.com.leadu.fms.business.rpc.system.SysParamRpc;
import cn.com.leadu.fms.business.service.*;
import cn.com.leadu.fms.common.constant.CommonAreaConstants;
import cn.com.leadu.fms.common.constant.enums.CommonCodeRedisKeyEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BasAreaRedisKeyEnums;
import cn.com.leadu.fms.common.constant.enums.system.CommonParamRedisKeyEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.common.vo.CommonParamVo;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonConstantServiceImpl
 * @Description: 共通常量
 * @date 2018/6/20
 */
@Slf4j
@Service
public class CommonConstantServiceImpl implements CommonConstantService {

    /**
     * @Fields  : 常量service
     * @author qiaomengnan
     */
    @Autowired(required = false)
    private CommonParamService commonParamService;

    /**
     * @Fields  : 字典service
     * @author qiaomengnan
     */
    @Autowired(required = false)
    private CommonCodeService commonCodeService;

    /**
     * @Fields  : 省市service
     * @author qiaomengnan
     */
    @Autowired(required = false)
    private CommonBasAreaService commonBasAreaService;

    /**
     * @Fields  : redis
     * @author qiaomengnan
     */
    @Autowired
    private RedisService redisService;

    /**
     * @Fields  : 系统常量rpc
     * @author qiaomengnan
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 数据字典rpc
     * @author qiaomengnan
     */
    @Autowired
    private SysCodeRpc sysCodeRpc;

    /**
     * @Fields  : 省市rpc
     * @author qiaomengnan
     */
    @Autowired
    private BasAreaRpc basAreaRpc;

    private static final ThreadLocal<Map<String,CommonParamVo>> localCommonParamVos = new ThreadLocal<>();

    private static final ThreadLocal<Map<String,CommonCodeVo>>  localCommonCodeVos = new ThreadLocal<>();

    private static final ThreadLocal<Map<String,List<CommonCodeVo>>>  localCommonCodeVosTree = new ThreadLocal<>();

    private static final ThreadLocal<Map<String,BasAreaTreeVo>> localBasAreaTreeVos = new ThreadLocal<>();

    /**
     * @Title:
     * @Description:   根据城市编码获取城市名称
     * @param areaCode
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/26 10:07:17
     */
    public String findBasAreaName(String areaCode){
        String basAreaName = null;
        if(StringUtils.isNotTrimBlank(areaCode)){
            //当前线程中获取
            Map<String,BasAreaTreeVo> basAreaTreeVos = localBasAreaTreeVos.get();
            if(basAreaTreeVos == null){
                //redis中获取
                basAreaTreeVos = getBasAreaTreeVos();
                localBasAreaTreeVos.set(basAreaTreeVos);
            }
            basAreaName = getAreaName(basAreaTreeVos,areaCode);
            if(StringUtils.isTrimBlank(basAreaName)){
                //刷新缓存后再次获取
                basAreaTreeVos = getBasAreaTreeVosResult();
                basAreaName = getAreaName(basAreaTreeVos,areaCode);
            }
        }
        return basAreaName;
    }

    /**
     * @Title:
     * @Description:  根据系统常量key 获取系统常量名称
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 11:01:18
     */
    public String findSysParamName(String paramKey){
        String paramName = null;
        if(StringUtils.isNotTrimBlank(paramKey)) {
            //线程中获取
            Map<String, CommonParamVo> commonParamVos = localCommonParamVos.get();
            if (commonParamVos == null) {
                //缓存中获取
                commonParamVos = getCommonParamVos();
                localCommonParamVos.set(commonParamVos);
            }
            paramName = getParamName(commonParamVos, paramKey);
            if (StringUtils.isTrimBlank(paramName)) {
                //刷新缓存再次获取
                commonParamVos = getCommonParamVosResult();
                paramName = getParamName(commonParamVos, paramKey);
            }
        }
        return paramName;
    }

    /**
     * @Title:
     * @Description:  根据系统常量key 获取系统常量Value
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 11:01:18
     */
    public String findSysParamValue(String paramKey){
        String paramValue = null;
        if(StringUtils.isNotTrimBlank(paramKey)) {
            //线程中获取
            Map<String, CommonParamVo> commonParamVos = localCommonParamVos.get();
            if (commonParamVos == null) {
                //缓存中获取
                commonParamVos = getCommonParamVos();
                localCommonParamVos.set(commonParamVos);
            }
            paramValue = getParamValue(commonParamVos, paramKey);
            if (StringUtils.isTrimBlank(paramValue)) {
                //刷新缓存再次获取
                commonParamVos = getCommonParamVosResult();
                paramValue = getParamValue(commonParamVos, paramKey);
            }
        }
        return paramValue;
    }

    /**
     * @Title:
     * @Description:   获取数据字典名称
     * @param codeType
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:03
     */
    public String findSysCodeValueName(String codeType,String value){
        String codeValueName = null;
        if(StringUtils.isNotTrimBlank(codeType)) {
            //线程中获取
            Map<String, CommonCodeVo> commonCodeVos = localCommonCodeVos.get();
            if (commonCodeVos == null) {
                //缓存中获取
                commonCodeVos = getCommonCodeVos();
                localCommonCodeVos.set(commonCodeVos);
            }
            codeValueName = getSysCodeValueName(commonCodeVos, codeType, value);
            if (StringUtils.isTrimBlank(codeValueName))  {
                //刷新缓存再次获取
                commonCodeVos = getCommonCodeVosResult();
                codeValueName = getSysCodeValueName(commonCodeVos, codeType, value);
            }
        }
        return codeValueName;
    }

    /**
     * @Title:
     * @Description:   获取数据字典子集集合
     * @param codeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:21
     */
    public Map<String,String> findSysCodeValues(String codeType){
        List<CommonCodeVo> commonCodeVos = null;
        if(StringUtils.isNotTrimBlank(codeType)) {
            //线程中获取
            Map<String, List<CommonCodeVo>> commonCodeVosTree = localCommonCodeVosTree.get();
            if (commonCodeVosTree == null) {
                //缓存中获取
                commonCodeVosTree = getCommonCodeVosTree();
                localCommonCodeVosTree.set(commonCodeVosTree);
            }
            commonCodeVos = getSysCodeValues(commonCodeVosTree, codeType);
            if (ArrayUtils.isNullOrLengthZero(commonCodeVos)) {
                //刷新缓存再次获取
                commonCodeVosTree = getCommonCodeVosTreeResult();
                commonCodeVos = getSysCodeValues(commonCodeVosTree, codeType);
            }
        }
        Map<String,String> result = new HashMap();
        for(CommonCodeVo vo : commonCodeVos){
            result.put(vo.getCodeValue(),vo.getCodeValueName());
        }
        return result;
    }

    /**
     * @Title:
     * @Description:   解析系统常量key 获取系统常量名称
     * @param commonParamVos
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/06 04:44:46
     */
    private String getParamName(Map<String,CommonParamVo> commonParamVos,String paramKey){
        String paramName = null;
        if(commonParamVos != null) {
            CommonParamVo commonParamVo = commonParamVos.get(paramKey);
            if(commonParamVo != null)
                paramName = commonParamVo.getParamName();
        }
        return paramName;
    }

    /**
     * @Title:
     * @Description:  解析系统常量key 获取系统常量Value
     * @param commonParamVos
     * @param paramKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 11:01:18
     */
    private String getParamValue(Map<String,CommonParamVo> commonParamVos,String paramKey){
        String paramValue = null;
        if(commonParamVos != null) {
            CommonParamVo commonParamVo = commonParamVos.get(paramKey);
            if(commonParamVo != null)
                paramValue = commonParamVo.getParamValue();
        }
        return paramValue;
    }

    /**
     * @Title:
     * @Description:   解析数据字典名称
     * @param commonCodeVos
     * @param codeType
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:03
     */
    private String getSysCodeValueName(Map<String,CommonCodeVo> commonCodeVos,String codeType,String value){
        String codeValueName = null;
        if(commonCodeVos != null){
            CommonCodeVo commonCodeVo = commonCodeVos.get(StringUtils.joinDelimiter(StringUtils.LINE, codeType,value));
            if(commonCodeVo != null)
                codeValueName = commonCodeVo.getCodeValueName();
        }
        return codeValueName;
    }

    /**
     * @Title:
     * @Description:   解析数据字典子集集合
     * @param codeType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:30:21
     */
    private List<CommonCodeVo> getSysCodeValues(Map<String,List<CommonCodeVo>> commonCodeVosTree,String codeType){
        List<CommonCodeVo> commonCodeVos = null;
        if(commonCodeVosTree != null)
            commonCodeVos = commonCodeVosTree.get(codeType);
        return commonCodeVos;
    }

    /**
     * @Title:
     * @Description:   redis中获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 02:10:17
     */
    private Map<String,CommonParamVo> getCommonParamVos(){
        Object result = redisService.get(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES.getPrefix());
        Map<String,CommonParamVo> commonParamVos = null;
        if(result != null)
            commonParamVos = (Map<String,CommonParamVo>)result;
        return commonParamVos;
    }

    /**
     * @Title:
     * @Description:  刷新缓存并再次从redis中获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 02:10:17
     */
    private Map<String,CommonParamVo> getCommonParamVosResult(){
        Map<String,CommonParamVo> commonParamVos = null;
        if(commonParamService == null){
            try {
                ResponseEntityUtils.getRestResponseData(sysParamRpc.initSysParamsValue());
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("刷新系统常量失败");
            }
        } else
            commonParamService.initSysParamsValue();
        commonParamVos = getCommonParamVos();
        return commonParamVos;
    }

    /**
     * @Title:
     * @Description:   redis中获取省市数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/26 09:59:59
     */
    private Map<String,BasAreaTreeVo> getBasAreaTreeVos(){
        Map<String,BasAreaTreeVo> basAreaTreeVos = null;
        Object result = redisService.get(BasAreaRedisKeyEnums.FMS_COMMON_AREA_VALUES.getPrefix());
        if(result != null)
            basAreaTreeVos = (Map<String,BasAreaTreeVo>)result;
        return basAreaTreeVos;
    }

    /**
     * @Title:
     * @Description:   刷新缓存，再次从redis中获取省市数据
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/26 09:59:59
     */
    private Map<String,BasAreaTreeVo> getBasAreaTreeVosResult(){
        Map<String,BasAreaTreeVo> basAreaTreeVos = null;
        if(commonBasAreaService == null){
            try {
                ResponseEntityUtils.getRestResponseData(basAreaRpc.initBasAreas()) ;
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("刷新省市数据失败");
            }
        }else{
            commonBasAreaService.initBasAreas();
        }
        basAreaTreeVos = getBasAreaTreeVos();
        return basAreaTreeVos;
    }

    /**
     * @Title:
     * @Description:   redis中获取数据字典
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:21:19
     */
    private Map<String,CommonCodeVo> getCommonCodeVos(){
        Object result =  redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES.getPrefix());
        Map<String,CommonCodeVo> commonCodeVos = null;
        if(result != null)
            commonCodeVos = (Map<String,CommonCodeVo>)result;
        return commonCodeVos;
    }

    /**
     * @Title:
     * @Description:   获取数据字典
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:21:19
     */
    private Map<String,CommonCodeVo> getCommonCodeVosResult(){
        Map<String,CommonCodeVo> commonCodeVos = null;
        if(commonCodeService == null){
            try {
                ResponseEntityUtils.getRestResponseData(sysCodeRpc.initCommonCodeValue()) ;
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("刷新数据字典失败");
            }
        } else
            commonCodeService.initCommonCodeValue();
        commonCodeVos = getCommonCodeVos();
        return commonCodeVos;
    }

    /**
     * @Title:
     * @Description:   从redis中获取数据字典Tree
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:21:19
     */
    private Map<String,List<CommonCodeVo>> getCommonCodeVosTree(){
        Object result =  redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_TREE.getPrefix());
        Map<String,List<CommonCodeVo>> commonCodeVosTree = null;
        if(result != null)
            commonCodeVosTree = (Map<String,List<CommonCodeVo>>)result;
        return commonCodeVosTree;
    }

    /**
     * @Title:
     * @Description:   刷新缓存,从redis获取数据字典Tree
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 03:21:19
     */
    private Map<String,List<CommonCodeVo>> getCommonCodeVosTreeResult(){
        Map<String,List<CommonCodeVo>> commonCodeVosTree = null;
        if(commonCodeService == null){
            try {
                ResponseEntityUtils.getRestResponseData(sysCodeRpc.initCommonCodeValue()) ;
            } catch (FmsRpcException ex) {
                log.error(ex.getMessage());
                ex.printStackTrace();
                throw new FmsServiceException("刷新数据字典Tree失败");
            }
        } else
            commonCodeService.initCommonCodeValue();
        commonCodeVosTree = getCommonCodeVosTree();
        return commonCodeVosTree;
    }

    /**
     * @Title:
     * @Description:   获取省市名称
     * @param basAreaTreeVos
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/26 10:08:37
     */
    private String getAreaName(Map<String,BasAreaTreeVo> basAreaTreeVos,String value){
        if(basAreaTreeVos != null){
            BasAreaTreeVo basAreaTreeVo = basAreaTreeVos.get(CommonAreaConstants.PROVINCE);
            if(basAreaTreeVo != null) {
                if(basAreaTreeVo.getAreaMap() != null)
                    return basAreaTreeVo.getAreaMap().get(value);
            }
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   清空本次线程所存储的值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/08/08 11:30:02
     */
    public void clearLocal(){
        localBasAreaTreeVos.remove();;
        localCommonCodeVos.remove();
        localCommonCodeVosTree.remove();
        localCommonParamVos.remove();
    }

}

