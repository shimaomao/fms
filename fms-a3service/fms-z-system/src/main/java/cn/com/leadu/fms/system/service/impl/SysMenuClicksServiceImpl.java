package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysMenuClicksRepository;
import cn.com.leadu.fms.pojo.system.entity.SysMenuClicks;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import cn.com.leadu.fms.system.service.SysMenuClicksService;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteListVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksDeleteVo;
import cn.com.leadu.fms.system.validator.sysmenuclicks.vo.SysMenuClicksModifyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysMenuClicksService
 * @Description: 利率因子业务实现层
 * @date 2018-05-03
 */
@Service
public class SysMenuClicksServiceImpl implements SysMenuClicksService {

    /**
     * @Fields  : 利率因子repository
     */
    @Autowired
    private SysMenuClicksRepository sysMenuClicksRepository;

    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param sysMenuClicksVo
     * @return PageInfoExtend<SysMenuClicks>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public PageInfoExtend<SysMenuClicksVo> findSysMenuClickssByPage(SysMenuClicksVo sysMenuClicksVo){
        PageInfoExtend<SysMenuClicksVo> pageInfo = sysMenuClicksRepository.selectListVoByPage("selectSysMenuClicksByPage",sysMenuClicksVo, sysMenuClicksVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 根据用户获取常用菜单List
     * @param sysMenuClicksVo
     * @return List<SysMenuClicksVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public List<SysMenuClicksVo> findSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo){
        List<SysMenuClicksVo> sysMenuClicksVoList = sysMenuClicksRepository.selectSysMenuClicksByUser(sysMenuClicksVo);
        return sysMenuClicksVoList;
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysMenuClicksVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    @Transactional
    public void saveSysMenuClicks(SysMenuClicksVo sysMenuClicksVo){
        Example example = SqlUtil.newExample(SysMenuClicks.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysMenuClicksVo.getMenuLink())){
            criteria.andEqualTo("menuLink", sysMenuClicksVo.getMenuLink());
        }
        if(StringUtils.isNotTrimBlank(sysMenuClicksVo.getUser())){
            criteria.andEqualTo("user", sysMenuClicksVo.getUser());
        }
        SysMenuClicks sysMenuClicks = sysMenuClicksRepository.selectOneByExample(example);
        if(sysMenuClicks == null){
            // 如果还没有点击过当前菜单，向表中登录一条数据
            sysMenuClicksVo.setClicksCount(1);
            sysMenuClicksRepository.insertData(sysMenuClicksVo.getEntity());
        } else {
            // 已经产生数据，当前菜单点击次数+1
            sysMenuClicks.setClicksCount(sysMenuClicks.getClicksCount() + 1);
            sysMenuClicksRepository.updateByExampleData(sysMenuClicks, example);
        }
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param sysMenuClicksModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public void modifySysMenuClicks(SysMenuClicksModifyVo sysMenuClicksModifyVo){
        sysMenuClicksRepository.updateByPrimaryKeySelectiveData(sysMenuClicksModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过menuClicksId删除利率因子
     * @param sysMenuClicksDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public void deleteSysMenuClicks(SysMenuClicksDeleteVo sysMenuClicksDeleteVo){
        sysMenuClicksRepository.deleteData(sysMenuClicksDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过menuClicksId集合删除利率因子
     * @param sysMenuClicksDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public void deleteSysMenuClickssByMenuClicksIds(SysMenuClicksDeleteListVo sysMenuClicksDeleteListVo){
        sysMenuClicksRepository.deleteDataList(sysMenuClicksDeleteListVo.getMenuClicksIds(),sysMenuClicksDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据menuClicksId获取利率因子
     * @param menuClicksId
     * @return SysMenuClicks
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:18
     */
    public SysMenuClicks findSysMenuClicksByMenuClicksId(String menuClicksId){
        return sysMenuClicksRepository.selectByPrimaryKey(menuClicksId);
    }

}
