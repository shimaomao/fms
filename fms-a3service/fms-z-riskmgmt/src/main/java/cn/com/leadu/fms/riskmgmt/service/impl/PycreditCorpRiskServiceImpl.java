package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.riskmgmt.service.PycreditCorpRiskService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpRiskRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorprisk.PycreditCorpRiskVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo.PycreditCorpRiskDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskService
 * @Description: 企业风险业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditCorpRiskServiceImpl implements PycreditCorpRiskService {

    /**
     * @Fields  : 企业风险repository
     */
    @Autowired
    private PycreditCorpRiskRepository pycreditCorpRiskRepository;

    /**
     * @Title:
     * @Description: 分页查询企业风险
     * @param pycreditCorpRiskVo
     * @return PageInfoExtend<PycreditCorpRisk>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public PageInfoExtend<PycreditCorpRisk> findPycreditCorpRisksByPage(PycreditCorpRiskVo pycreditCorpRiskVo){
        Example example = SqlUtil.newExample(PycreditCorpRisk.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditCorpRisk> pageInfo = pycreditCorpRiskRepository.selectListByExamplePage(example,pycreditCorpRiskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存企业风险
     * @param pycreditCorpRiskSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public void savePycreditCorpRisk(PycreditCorpRiskSaveVo pycreditCorpRiskSaveVo){
        pycreditCorpRiskRepository.insertData(pycreditCorpRiskSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改企业风险
     * @param pycreditCorpRiskModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public void modifyPycreditCorpRisk(PycreditCorpRiskModifyVo pycreditCorpRiskModifyVo){
        pycreditCorpRiskRepository.updateByPrimaryKeySelectiveData(pycreditCorpRiskModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpRiskId删除企业风险
     * @param pycreditCorpRiskDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public void deletePycreditCorpRisk(PycreditCorpRiskDeleteVo pycreditCorpRiskDeleteVo){
        pycreditCorpRiskRepository.deleteData(pycreditCorpRiskDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpRiskId集合删除企业风险
     * @param pycreditCorpRiskDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public void deletePycreditCorpRisksByPycreditCorpRiskIds(PycreditCorpRiskDeleteListVo pycreditCorpRiskDeleteListVo){
        pycreditCorpRiskRepository.deleteDataList(pycreditCorpRiskDeleteListVo.getPycreditCorpRiskIds(),pycreditCorpRiskDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditCorpRiskId获取企业风险
     * @param pycreditCorpRiskId
     * @return PycreditCorpRisk
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:03
     */
    public PycreditCorpRisk findPycreditCorpRiskByPycreditCorpRiskId(String pycreditCorpRiskId){
        return pycreditCorpRiskRepository.selectByPrimaryKey(pycreditCorpRiskId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业风险,并进行排他
     * @param name
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditCorpRisk> selectPycreditCorpRiskList(String name, int ceilingNumber){
        return pycreditCorpRiskRepository.selectPycreditCorpRiskList(name,ceilingNumber);
    }
}
