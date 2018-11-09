package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysInfoRepository;
import cn.com.leadu.fms.pojo.system.entity.SysInfo;
import cn.com.leadu.fms.pojo.system.vo.sysinfo.SysInfoVo;
import cn.com.leadu.fms.system.service.SysInfoService;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteListVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoDeleteVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoModifyVo;
import cn.com.leadu.fms.system.validator.sysinfo.vo.SysInfoSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qiaomengnan
 * @ClassName: SysInfoService
 * @Description: 消息管理业务实现层
 * @date 2018-04-25
 */
@Service
public class SysInfoServiceImpl implements SysInfoService {

    /**
     * @Fields  : 消息管理repository
     */
    @Autowired
    private SysInfoRepository sysInfoRepository;

    /**
     * @Title:
     * @Description: 分页查询消息管理
     * @param sysInfoVo
     * @return PageInfoExtend<SysInfo>
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public PageInfoExtend<SysInfo> findSysInfosByPage(SysInfoVo sysInfoVo){
        Example example = SqlUtil.newExample(SysInfo.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysInfo> pageInfo = sysInfoRepository.selectListByExamplePage(example,sysInfoVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存消息管理
     * @param sysInfoSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public void saveSysInfo(SysInfoSaveVo sysInfoSaveVo){
        sysInfoRepository.insertData(sysInfoSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改消息管理
     * @param sysInfoModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public void modifySysInfo(SysInfoModifyVo sysInfoModifyVo){
        sysInfoRepository.updateByPrimaryKeySelectiveData(sysInfoModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过infoId删除消息管理
     * @param sysInfoDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public void deleteSysInfo(SysInfoDeleteVo sysInfoDeleteVo){
        sysInfoRepository.deleteData(sysInfoDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过infoId集合删除消息管理
     * @param sysInfoDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public void deleteSysInfosByInfoIds(SysInfoDeleteListVo sysInfoDeleteListVo){
        sysInfoRepository.deleteDataList(sysInfoDeleteListVo.getInfoIds(),sysInfoDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据infoId获取消息管理
     * @param infoId
     * @return SysInfo
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    public SysInfo findSysInfoByInfoId(String infoId){
        return sysInfoRepository.selectByPrimaryKey(infoId);
    }

}
