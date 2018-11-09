package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.riskmgmt.service.PycreditAntiService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditAntiRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditanti.PycreditAntiVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditanti.vo.PycreditAntiDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAntiService
 * @Description: 反欺诈分析业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditAntiServiceImpl implements PycreditAntiService {

    /**
     * @Fields  : 反欺诈分析repository
     */
    @Autowired
    private PycreditAntiRepository pycreditAntiRepository;

    /**
     * @Title:
     * @Description: 分页查询反欺诈分析
     * @param pycreditAntiVo
     * @return PageInfoExtend<PycreditAnti>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public PageInfoExtend<PycreditAnti> findPycreditAntisByPage(PycreditAntiVo pycreditAntiVo){
        Example example = SqlUtil.newExample(PycreditAnti.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditAnti> pageInfo = pycreditAntiRepository.selectListByExamplePage(example,pycreditAntiVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存反欺诈分析
     * @param pycreditAntiSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public void savePycreditAnti(PycreditAntiSaveVo pycreditAntiSaveVo){
        pycreditAntiRepository.insertData(pycreditAntiSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改反欺诈分析
     * @param pycreditAntiModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public void modifyPycreditAnti(PycreditAntiModifyVo pycreditAntiModifyVo){
        pycreditAntiRepository.updateByPrimaryKeySelectiveData(pycreditAntiModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditAntiId删除反欺诈分析
     * @param pycreditAntiDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public void deletePycreditAnti(PycreditAntiDeleteVo pycreditAntiDeleteVo){
        pycreditAntiRepository.deleteData(pycreditAntiDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditAntiId集合删除反欺诈分析
     * @param pycreditAntiDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public void deletePycreditAntisByPycreditAntiIds(PycreditAntiDeleteListVo pycreditAntiDeleteListVo){
        pycreditAntiRepository.deleteDataList(pycreditAntiDeleteListVo.getPycreditAntiIds(),pycreditAntiDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditAntiId获取反欺诈分析
     * @param pycreditAntiId
     * @return PycreditAnti
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:08:53
     */
    public PycreditAnti findPycreditAntiByPycreditAntiId(String pycreditAntiId){
        return pycreditAntiRepository.selectByPrimaryKey(pycreditAntiId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改反欺诈分析,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditAnti> selectPycreditAntiList(String documentNo,int ceilingNumber){
        return pycreditAntiRepository.selectPycreditAntiList(documentNo,ceilingNumber);
    }
}
