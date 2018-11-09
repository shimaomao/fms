package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysGroupLevelRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import cn.com.leadu.fms.system.service.SysGroupLevelService;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelModifyVo;
import cn.com.leadu.fms.system.validator.sysgrouplevel.vo.SysGroupLevelSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelService
 * @Description: 用户组层级业务实现层
 * @date 2018-03-08
 */
@Service
public class SysGroupLevelServiceImpl implements SysGroupLevelService {

    @Autowired
    private SysGroupLevelRepository sysGroupLevelRepository;

    /**
     * @Title:
     * @Description: 保存用户组层级
     * @param sysGroupLevelSaveVo
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public void saveSysGroupLevel(SysGroupLevelSaveVo sysGroupLevelSaveVo){
        sysGroupLevelRepository.insertData(sysGroupLevelSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改用户组层级
     * @param sysGroupLevelModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public void modifySysGroupLevel(SysGroupLevelModifyVo sysGroupLevelModifyVo){
        sysGroupLevelRepository.updateByPrimaryKeySelectiveData(sysGroupLevelModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过层级id集合，删除用户组层级
     * @param sysGroupLevelDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public void deleteSysGroupLevelsByIds(SysGroupLevelDeleteListVo sysGroupLevelDeleteListVo){
        sysGroupLevelRepository.deleteDataList(sysGroupLevelDeleteListVo.getGroupLevIds(),sysGroupLevelDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据层级id，取得用户组层级
     * @param groupLevId
     * @return SysGroupLevel
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public SysGroupLevel findSysGroupLevelById(String groupLevId){
        return sysGroupLevelRepository.selectByPrimaryKey(groupLevId);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组层级
     * @param sysGroupLevelVo
     * @return PageInfoExtend<SysGroupLevel>
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public PageInfoExtend<SysGroupLevel> findSysGroupLevelsByPage(SysGroupLevelVo sysGroupLevelVo){
        Example example = SqlUtil.newExample(SysGroupLevel.class);
        Example.Criteria criteria = example.createCriteria();
        // 层级代码
        if (StringUtils.isNotTrimBlank(sysGroupLevelVo.getGroupLev())) {
            criteria.andLike("groupLev",SqlUtil.likePattern(sysGroupLevelVo.getGroupLev()));
        }
        // 层级名称
        if (StringUtils.isNotTrimBlank(sysGroupLevelVo.getGroupLevName())) {
            criteria.andLike("groupLevName",SqlUtil.likePattern(sysGroupLevelVo.getGroupLevName()));
        }
        // 启用标识
        if (StringUtils.isNotTrimBlank(sysGroupLevelVo.getEnableFlag())) {
            criteria.andEqualTo("enableFlag",sysGroupLevelVo.getEnableFlag());
        }
        SqlUtil.setOrderByUpdateTimeDesc(example);
        PageInfoExtend<SysGroupLevel> pageInfo = sysGroupLevelRepository.selectListByExamplePage(example,sysGroupLevelVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据层级代码，获取用户组层级
     * @param groupLev
     * @return SysGroupLevel
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    public SysGroupLevel findSysGroupLevelByGroupLev(String groupLev) {
        if (StringUtils.isNotTrimBlank(groupLev)) {
            Example example = SqlUtil.newExample(SysGroupLevel.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("groupLev", groupLev);
            SqlUtil.andEqualToDeleteExist(criteria);
            List<SysGroupLevel> sysGroupLevelList = sysGroupLevelRepository.selectListByExample(example);
            if (ArrayUtils.isNotNullAndLengthNotZero(sysGroupLevelList)) {
                return sysGroupLevelList.get(0);
            }
        }
        return null;
    }
}
