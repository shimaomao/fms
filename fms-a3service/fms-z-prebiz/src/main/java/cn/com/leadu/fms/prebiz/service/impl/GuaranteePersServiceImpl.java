package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.prebiz.service.GuaranteePersService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteePersRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersSaveVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersModifyVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersDeleteVo;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.GuaranteePersDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersService
 * @Description: 担保个人信息业务实现层
 * @date 2018-03-30
 */
@Service
public class GuaranteePersServiceImpl implements GuaranteePersService {

    /**
     * @Fields  : 担保个人信息repository
     */
    @Autowired
    private GuaranteePersRepository guaranteePersRepository;

    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询担保个人信息
     * @param guaranteePersVo
     * @return PageInfoExtend<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public PageInfoExtend<GuaranteePers> findGuaranteePerssByPage(GuaranteePersVo guaranteePersVo){
        Example example = SqlUtil.newExample(GuaranteePers.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<GuaranteePers> pageInfo = guaranteePersRepository.selectListByExamplePage(example,guaranteePersVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存担保个人信息
     * @param guaranteePersSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public void saveGuaranteePers(GuaranteePersSaveVo guaranteePersSaveVo){
        guaranteePersRepository.insertData(guaranteePersSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改担保个人信息
     * @param guaranteePersModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public void modifyGuaranteePers(GuaranteePersModifyVo guaranteePersModifyVo){
        guaranteePersRepository.updateByPrimaryKeySelectiveData(guaranteePersModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过guarPersId删除担保个人信息
     * @param guaranteePersDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public void deleteGuaranteePers(GuaranteePersDeleteVo guaranteePersDeleteVo){
        guaranteePersRepository.deleteData(guaranteePersDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过guarPersId集合删除担保个人信息
     * @param guaranteePersDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public void deleteGuaranteePerssByGuarPersIds(GuaranteePersDeleteListVo guaranteePersDeleteListVo){
        guaranteePersRepository.deleteDataList(guaranteePersDeleteListVo.getGuarPersIds(),guaranteePersDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据guarPersId获取担保个人信息
     * @param guarPersId
     * @return GuaranteePers
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:13
     */
    public GuaranteePers findGuaranteePersByGuarPersId(String guarPersId){
        return guaranteePersRepository.selectByPrimaryKey(guarPersId);
    }

    /**
     * 批量保存担保人信息
     * @param guaranteePersList
     */
    @Override
    public void saveGuaranteePresList(List<GuaranteePers> guaranteePersList,String applyNo) {
        if(guaranteePersList.size()>0){
           // String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
            for (GuaranteePers guaranteePers:guaranteePersList) {
                guaranteePers.setApplyNo(applyNo);
            }
            guaranteePersRepository.insertDataList(guaranteePersList);
        }
    }
    /**
     * @Title:
     * @Description:  根据订单编号获取担保人信息
     * @param applyNo
     * @return List<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public List<GuaranteePers> findGuaranteePersByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(GuaranteePers.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        if(guaranteePersRepository.selectListByExample(example) == null){
            List<GuaranteePers> guaranteePersList = new ArrayList<>();
            return guaranteePersList;
        }
        return guaranteePersRepository.selectListByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据订单编号更新担保人信息
     * @param applyNo
     * @return List<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public void updateGuaranteePersByApplyNo(List<GuaranteePers> guaranteePersList, String applyNo) {
        Example example = SqlUtil.newExample(GuaranteePers.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        List<GuaranteePers>  CstmContactGetList =  guaranteePersRepository.selectListByExample(example);
        List<GuaranteePers> CstmContactAddList = new ArrayList<>();
        List<GuaranteePers> CstmContactKeepList = new ArrayList<>();
        List<GuaranteePers> CstmContactUpdateList = new ArrayList<>();
        if(guaranteePersList.size()!=0){
            for(GuaranteePers cstmcon:guaranteePersList){
                if(cstmcon.getApplyNo()==null){
                    cstmcon.setApplyNo(applyNo);
                    CstmContactAddList.add(cstmcon);
                }
                if(CstmContactGetList.size()!=0){
                    for(GuaranteePers con:CstmContactGetList){
                        if(con.getGuarPersId().equals(cstmcon.getGuarPersId())){
                            CstmContactKeepList.add(con);
                            CstmContactUpdateList.add(cstmcon);
                        }
                    }
                }
            }
            CstmContactGetList.removeAll(CstmContactKeepList); //要删除的
            if(CstmContactGetList.size()>0){
                for(GuaranteePers con: CstmContactGetList){
                    guaranteePersRepository.deleteData(con);
                }
            }
            guaranteePersRepository.insertDataList(CstmContactAddList);
            guaranteePersRepository.updateByPrimaryKeySelectiveDataList(CstmContactUpdateList);
        }else{
            guaranteePersRepository.deleteExampleData(example,new GuaranteePers());
        }
    }

}
