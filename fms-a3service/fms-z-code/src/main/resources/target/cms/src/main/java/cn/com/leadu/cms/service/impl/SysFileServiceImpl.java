package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.system.service.SysFileService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysFileRepository;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileSaveVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileModifyVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteVo;
import cn.com.leadu.fms.system.validator.sysfile.vo.SysFileDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: SysFileService
 * @Description: 菜单业务实现层
 * @date 2018-03-05
 */
@Service
public class SysFileServiceImpl implements SysFileService {

    @Autowired
    private SysFileRepository sysFileRepository;

    /**
     * @Title:
     * @Description: 保存菜单
     * @param sysFileSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public void saveSysFile(SysFileSaveVo sysFileSaveVo){
        sysFileRepository.insertData(sysFileSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改菜单
     * @param sysFileModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public void modifySysFile(SysFileModifyVo sysFileModifyVo){
        sysFileRepository.updateByPrimaryKeySelectiveData(sysFileModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id删除菜单
     * @param sysFileDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public void deleteSysFile(SysFileDeleteVo sysFileDeleteVo){
        sysFileRepository.deleteData(sysFileDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id集合删除菜单
     * @param sysFileDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public void deleteSysFileByIds(SysFileDeleteListVo sysFileDeleteListVo){
        sysFileRepository.deleteDataList(sysFileDeleteListVo.getIds(),sysFileDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据id菜单
     * @param id
     * @return SysFile
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public SysFile findSysFileById(String id){
        return sysFileRepository.selectByPrimaryKey(id);
    }

    /**
     * @Title:
     * @Description: 分页查询菜单
     * @param sysFileVo
     * @return PageInfoExtend<SysFile>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    public PageInfoExtend<SysFile> findSysFileByPage(SysFileVo sysFileVo){
        Example example =SqlUtil.newExample(SysFile.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysFile> pageInfo = sysFileRepository.selectListByExamplePage(example,sysFileVo.getPageQuery());
        return pageInfo;
    }

}
