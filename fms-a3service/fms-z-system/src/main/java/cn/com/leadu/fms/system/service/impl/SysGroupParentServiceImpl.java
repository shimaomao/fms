package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.constant.enums.system.SysGroupEnums;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysGroupParentRepository;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import cn.com.leadu.fms.system.service.SysGroupParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupParentService
 * @Description: 用户组关系业务实现层
 * @date 2018-03-12
 */
@Service
public class SysGroupParentServiceImpl implements SysGroupParentService {

    /**
     * @Fields  : 用户组关系repository
     */
    @Autowired
    private SysGroupParentRepository sysGroupParentRepository;

    /**
     * @Title:
     * @Description: 根据用户组代码，获取全部用户组关系
     * @param groupCode
     * @return List
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public List<SysGroupParent> findSysGroupParentsByGroup(String groupCode) {
        Example example = SqlUtil.newExample(SysGroupParent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("groupCode", groupCode);
        SqlUtil.setOrderByCreateTimeDesc(example);
        return sysGroupParentRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 保存用户组关系List
     * @param sysGroupParentList
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public void saveSysGroupParents(List<SysGroupParent> sysGroupParentList){
        sysGroupParentRepository.insertDataList(sysGroupParentList);
    }

    /**
     * @Title:
     * @Description: 保存用户组关系
     * @param sysGroupParent
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-3-29 15:41:14
     */
    public void saveSysGroupParent(SysGroupParent sysGroupParent){
        sysGroupParentRepository.insertData(sysGroupParent);
    }

    /**
     * @Title:
     * @Description: 修改用户组关系List
     * @param sysGroupParentList
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    @Override
    public void modifySysGroupParents(List<SysGroupParent> sysGroupParentList) {
        sysGroupParentRepository.updateByPrimaryKeySelectiveDataList(sysGroupParentList);
    }

    /**
     * @Title:
     * @Description:  通过parentId集合删除用户组关系
     * @param parentIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public void deleteSysGroupParentsByParentIds(List<String> parentIds){
        sysGroupParentRepository.deleteDataList(parentIds, new SysGroupParent());
    }

    /**
     * @Title:
     * @Description:  通过code删除
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:41:14
     */
    public void deleteSysGroupParentByGroupCode(String groupCode){
        Example example=SqlUtil.newExample(SysGroupParent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("groupCode",groupCode);
        sysGroupParentRepository.deleteExampleData(example,new SysGroupParent());
    }

    /**
     * @Title:
     * @Description:  通过条件groupCode查询
     * @param groupCode
     * @return SysGroupParent
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:41:14
     */
    public SysGroupParent findSysGroupParentsByGroupCode(String groupCode){
        Example example=SqlUtil.newExample(SysGroupParent.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("groupCode",groupCode);
        criteria.andEqualTo("parentType", SysGroupEnums.ADMINISTRATIVE_TYPE.getType());
        return sysGroupParentRepository.selectOneByExample(example);
    }
    /**
     * @Title:
     * @Description:  通过对象修改对象
     * @param sysGroupParent
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:41:14
     */
    public void modifySysGroupParent(SysGroupParent sysGroupParent){
        sysGroupParentRepository.updateByPrimaryKeySelectiveData(sysGroupParent);
    }
}
