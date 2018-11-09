package cn.com.leadu.fms.business.service.impl;/**
 * Created by yyq on 2018/6/12.
 */

import cn.com.leadu.fms.business.service.BasAreaNameService;
import cn.com.leadu.fms.data.baseinfo.repository.BasAreaRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: fms
 * @description: 地址共同service
 * @author: yangyiquan
 * @create: 2018-06-12 19:40
 **/
@Service
public class BasAreaNameServiceImpl implements BasAreaNameService {
    /**
     * @Fields  : 省市县信息维护repository
     */
    @Autowired
    private BasAreaRepository basAreaRepository;

    /**
     * @Description: 查询所有地址编码和名字
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/12 19:44
     */
    @Override
    public Map<String, String> getBasAreaCodeAndName() {
        Example example = SqlUtil.newExample(BasArea.class);
        SqlUtil.andEqualToDeleteExist(example.createCriteria());
        SqlUtil.setOrderByColumnAsc(example,"area_code");
        //查出所有省市縣
        List<BasArea> basAreas = basAreaRepository.selectListByExample(example);
        //区域名称Map
        Map<String,String> areaNameMap=new HashMap<String,String>();
        //区域list
        for(BasArea basArea : basAreas) {
            areaNameMap.put(basArea.getAreaCode(), basArea.getAreaName());
        }
        return areaNameMap;
    }
}
