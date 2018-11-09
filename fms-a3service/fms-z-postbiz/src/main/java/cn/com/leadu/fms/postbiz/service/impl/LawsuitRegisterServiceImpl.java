package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.postbiz.service.LawsuitRegisterService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.LawsuitRegisterRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.LawsuitRegister;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterSaveVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterModifyVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterDeleteVo;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.LawsuitRegisterDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: LawsuitRegisterService
 * @Description: 诉讼登记信息业务实现层
 */
@Service
public class LawsuitRegisterServiceImpl implements LawsuitRegisterService {

    /**
     * @Fields  : 诉讼登记信息repository
     */
    @Autowired
    private LawsuitRegisterRepository lawsuitRegisterRepository;

    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息
     * @param lawsuitRegisterVo
     * @return PageInfoExtend<LawsuitRegister>
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public PageInfoExtend<LawsuitRegister> findLawsuitRegistersByPage(LawsuitRegisterVo lawsuitRegisterVo){
        Example example = SqlUtil.newExample(LawsuitRegister.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<LawsuitRegister> pageInfo = lawsuitRegisterRepository.selectListByExamplePage(example,lawsuitRegisterVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存诉讼登记信息
     * @param lawsuitRegisterSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public void saveLawsuitRegister(LawsuitRegisterSaveVo lawsuitRegisterSaveVo){
        lawsuitRegisterRepository.insertData(lawsuitRegisterSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改诉讼登记信息
     * @param lawsuitRegisterModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public void modifyLawsuitRegister(LawsuitRegisterModifyVo lawsuitRegisterModifyVo){
        lawsuitRegisterRepository.updateByPrimaryKeySelectiveData(lawsuitRegisterModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过lawsuitRegisterId删除诉讼登记信息
     * @param lawsuitRegisterDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public void deleteLawsuitRegister(LawsuitRegisterDeleteVo lawsuitRegisterDeleteVo){
        lawsuitRegisterRepository.deleteData(lawsuitRegisterDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过lawsuitRegisterId集合删除诉讼登记信息
     * @param lawsuitRegisterDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public void deleteLawsuitRegistersByLawsuitRegisterIds(LawsuitRegisterDeleteListVo lawsuitRegisterDeleteListVo){
        lawsuitRegisterRepository.deleteDataList(lawsuitRegisterDeleteListVo.getLawsuitRegisterIds(),lawsuitRegisterDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据lawsuitRegisterId获取诉讼登记信息
     * @param lawsuitRegisterId
     * @return LawsuitRegister
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    public LawsuitRegister findLawsuitRegisterByLawsuitRegisterId(String lawsuitRegisterId){
        return lawsuitRegisterRepository.selectByPrimaryKey(lawsuitRegisterId);
    }

}
