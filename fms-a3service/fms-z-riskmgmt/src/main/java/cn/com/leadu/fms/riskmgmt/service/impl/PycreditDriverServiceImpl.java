package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.riskmgmt.service.PycreditDriverService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditDriverRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditdriver.PycreditDriverVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo.PycreditDriverDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverService
 * @Description: 驾驶证核查业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditDriverServiceImpl implements PycreditDriverService {

    /**
     * @Fields  : 驾驶证核查repository
     */
    @Autowired
    private PycreditDriverRepository pycreditDriverRepository;

    /**
     * @Title:
     * @Description: 分页查询驾驶证核查
     * @param pycreditDriverVo
     * @return PageInfoExtend<PycreditDriver>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public PageInfoExtend<PycreditDriver> findPycreditDriversByPage(PycreditDriverVo pycreditDriverVo){
        Example example = SqlUtil.newExample(PycreditDriver.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditDriver> pageInfo = pycreditDriverRepository.selectListByExamplePage(example,pycreditDriverVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存驾驶证核查
     * @param pycreditDriverSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public void savePycreditDriver(PycreditDriverSaveVo pycreditDriverSaveVo){
        pycreditDriverRepository.insertData(pycreditDriverSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改驾驶证核查
     * @param pycreditDriverModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public void modifyPycreditDriver(PycreditDriverModifyVo pycreditDriverModifyVo){
        pycreditDriverRepository.updateByPrimaryKeySelectiveData(pycreditDriverModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditDriverId删除驾驶证核查
     * @param pycreditDriverDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public void deletePycreditDriver(PycreditDriverDeleteVo pycreditDriverDeleteVo){
        pycreditDriverRepository.deleteData(pycreditDriverDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditDriverId集合删除驾驶证核查
     * @param pycreditDriverDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public void deletePycreditDriversByPycreditDriverIds(PycreditDriverDeleteListVo pycreditDriverDeleteListVo){
        pycreditDriverRepository.deleteDataList(pycreditDriverDeleteListVo.getPycreditDriverIds(),pycreditDriverDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditDriverId获取驾驶证核查
     * @param pycreditDriverId
     * @return PycreditDriver
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:44
     */
    public PycreditDriver findPycreditDriverByPycreditDriverId(String pycreditDriverId){
        return pycreditDriverRepository.selectByPrimaryKey(pycreditDriverId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改驾驶证核查,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditDriver> selectPycreditDriverList(String documentNo, int ceilingNumber){
        return pycreditDriverRepository.selectPycreditDriverList(documentNo,ceilingNumber);
    }
}
