package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.prebiz.service.GuaranteeCompService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteeCompRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompSaveVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompModifyVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompDeleteVo;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.GuaranteeCompDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompService
 * @Description: 担保企业信息业务实现层
 * @date 2018-03-30
 */
@Service
public class GuaranteeCompServiceImpl implements GuaranteeCompService {

    /**
     * @Fields  : 担保企业信息repository
     */
    @Autowired
    private GuaranteeCompRepository guaranteeCompRepository;

    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询担保企业信息
     * @param guaranteeCompVo
     * @return PageInfoExtend<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public PageInfoExtend<GuaranteeComp> findGuaranteeCompsByPage(GuaranteeCompVo guaranteeCompVo){
        Example example = SqlUtil.newExample(GuaranteeComp.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<GuaranteeComp> pageInfo = guaranteeCompRepository.selectListByExamplePage(example,guaranteeCompVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存担保企业信息
     * @param guaranteeCompSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public void saveGuaranteeComp(GuaranteeCompSaveVo guaranteeCompSaveVo){
        guaranteeCompRepository.insertData(guaranteeCompSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改担保企业信息
     * @param guaranteeCompModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public void modifyGuaranteeComp(GuaranteeCompModifyVo guaranteeCompModifyVo){
        guaranteeCompRepository.updateByPrimaryKeySelectiveData(guaranteeCompModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过guarCompId删除担保企业信息
     * @param guaranteeCompDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public void deleteGuaranteeComp(GuaranteeCompDeleteVo guaranteeCompDeleteVo){
        guaranteeCompRepository.deleteData(guaranteeCompDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过guarCompId集合删除担保企业信息
     * @param guaranteeCompDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public void deleteGuaranteeCompsByGuarCompIds(GuaranteeCompDeleteListVo guaranteeCompDeleteListVo){
        guaranteeCompRepository.deleteDataList(guaranteeCompDeleteListVo.getGuarCompIds(),guaranteeCompDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据guarCompId获取担保企业信息
     * @param guarCompId
     * @return GuaranteeComp
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public GuaranteeComp findGuaranteeCompByGuarCompId(String guarCompId){
        return guaranteeCompRepository.selectByPrimaryKey(guarCompId);
    }

    /**
     * 批量保存担保企业信息
     * @param guaranteeCompList
     */
    @Override
    public void saveGuaranteeCompList(List<GuaranteeComp> guaranteeCompList,String applyNo) {
        if(guaranteeCompList.size()>0){
            //String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
            for (GuaranteeComp guaranteeComp:guaranteeCompList) {
                guaranteeComp.setApplyNo(applyNo);
            }
            guaranteeCompRepository.insertDataList(guaranteeCompList);
        }
    }
    /**
     * @Title:
     * @Description:  根据订单编号获取担保企业信息
     * @param applyNo
     * @return List<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-4-9 14:22:35
     */
    @Override
    public List<GuaranteeComp> findGuaranteeCompsByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(GuaranteeComp.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        if(guaranteeCompRepository.selectListByExample(example) == null){
            List<GuaranteeComp>  guaranteeCompList = new ArrayList<>();
            return guaranteeCompList;
        }
        return guaranteeCompRepository.selectListByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据订单编号更新担保公司信息
     * @param applyNo
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public void updateGuaranteeCompsByApplyNo(List<GuaranteeComp> guaranteeCompList, String applyNo) {
        Example example = SqlUtil.newExample(GuaranteeComp.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        List<GuaranteeComp>  CstmContactGetList =  guaranteeCompRepository.selectListByExample(example);
        List<GuaranteeComp> CstmContactAddList = new ArrayList<>();
        List<GuaranteeComp> CstmContactKeepList = new ArrayList<>();
        List<GuaranteeComp> CstmContactUpdateList = new ArrayList<>();
        if(guaranteeCompList.size()!=0){
            //CstmContactGetList.removeAll(cstmContactList);
            for(GuaranteeComp cstmcon:guaranteeCompList){
                if(cstmcon.getApplyNo()==null){
                    cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(CstmContactGetList.size()!=0){
                    for(GuaranteeComp con:CstmContactGetList){
                        if(con.getGuarCompId().equals(cstmcon.getGuarCompId())){
                            CstmContactKeepList.add(con);
                            CstmContactUpdateList.add(cstmcon);
                        }
                    }
                }
            }
            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
            if(CstmContactGetList.size()>0){
                for(GuaranteeComp con: CstmContactGetList){
                    guaranteeCompRepository.deleteData(con);
                }
            }
            guaranteeCompRepository.insertDataList(CstmContactAddList);
            guaranteeCompRepository.updateByPrimaryKeySelectiveDataList(CstmContactUpdateList);
        }else{
            guaranteeCompRepository.deleteExampleData(example,new GuaranteeComp());
        }
    }

}
