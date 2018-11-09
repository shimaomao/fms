package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.postbiz.service.OverdueTelRegisterService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueTelRegisterRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueTelRegister;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.OverdueTelRegisterDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterService
 * @Description: 电话催收登记信息业务实现层
 * @date 2018-05-17
 */
@Service
public class OverdueTelRegisterServiceImpl implements OverdueTelRegisterService {

    /**
     * @Fields  : 电话催收登记信息repository
     */
    @Autowired
    private OverdueTelRegisterRepository overdueTelRegisterRepository;

    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息
     * @param overdueTelRegisterVo
     * @return PageInfoExtend<OverdueTelRegister>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public PageInfoExtend<OverdueTelRegister> findOverdueTelRegistersByPage(OverdueTelRegisterVo overdueTelRegisterVo){
        Example example = SqlUtil.newExample(OverdueTelRegister.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OverdueTelRegister> pageInfo = overdueTelRegisterRepository.selectListByExamplePage(example,overdueTelRegisterVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存电话催收登记信息
     * @param overdueTelRegisterSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public void saveOverdueTelRegister(OverdueTelRegisterSaveVo overdueTelRegisterSaveVo){
        overdueTelRegisterRepository.insertData(overdueTelRegisterSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改电话催收登记信息
     * @param overdueTelRegisterModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public void modifyOverdueTelRegister(OverdueTelRegisterModifyVo overdueTelRegisterModifyVo){
        overdueTelRegisterRepository.updateByPrimaryKeySelectiveData(overdueTelRegisterModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueTelRegisterId删除电话催收登记信息
     * @param overdueTelRegisterDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public void deleteOverdueTelRegister(OverdueTelRegisterDeleteVo overdueTelRegisterDeleteVo){
        overdueTelRegisterRepository.deleteData(overdueTelRegisterDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueTelRegisterId集合删除电话催收登记信息
     * @param overdueTelRegisterDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public void deleteOverdueTelRegistersByOverdueTelRegisterIds(OverdueTelRegisterDeleteListVo overdueTelRegisterDeleteListVo){
        overdueTelRegisterRepository.deleteDataList(overdueTelRegisterDeleteListVo.getOverdueTelRegisterIds(),overdueTelRegisterDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueTelRegisterId获取电话催收登记信息
     * @param overdueTelRegisterId
     * @return OverdueTelRegister
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    public OverdueTelRegister findOverdueTelRegisterByOverdueTelRegisterId(String overdueTelRegisterId){
        return overdueTelRegisterRepository.selectByPrimaryKey(overdueTelRegisterId);
    }

}
