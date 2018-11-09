package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.postbiz.service.OverdueCstmAddrService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmAddrRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmaddr.OverdueCstmAddrVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmaddr.vo.OverdueCstmAddrDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrService
 * @Description: 逾期客户地址信息业务实现层
 * @date 2018-05-17
 */
@Service
public class OverdueCstmAddrServiceImpl implements OverdueCstmAddrService {

    /**
     * @Fields  : 逾期客户地址信息repository
     */
    @Autowired
    private OverdueCstmAddrRepository overdueCstmAddrRepository;

    /**
     * @Title:
     * @Description: 分页查询逾期客户地址信息
     * @param overdueCstmAddrVo
     * @return PageInfoExtend<OverdueCstmAddr>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public PageInfoExtend<OverdueCstmAddr> findOverdueCstmAddrsByPage(OverdueCstmAddrVo overdueCstmAddrVo){
        Example example = SqlUtil.newExample(OverdueCstmAddr.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OverdueCstmAddr> pageInfo = overdueCstmAddrRepository.selectListByExamplePage(example,overdueCstmAddrVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存逾期客户地址信息
     * @param overdueCstmAddrSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public void saveOverdueCstmAddr(OverdueCstmAddrSaveVo overdueCstmAddrSaveVo){
        overdueCstmAddrRepository.insertData(overdueCstmAddrSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改逾期客户地址信息
     * @param overdueCstmAddrModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public void modifyOverdueCstmAddr(OverdueCstmAddrModifyVo overdueCstmAddrModifyVo){
        overdueCstmAddrRepository.updateByPrimaryKeySelectiveData(overdueCstmAddrModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueCstmAddrId删除逾期客户地址信息
     * @param overdueCstmAddrDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public void deleteOverdueCstmAddr(OverdueCstmAddrDeleteVo overdueCstmAddrDeleteVo){
        overdueCstmAddrRepository.deleteData(overdueCstmAddrDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueCstmAddrId集合删除逾期客户地址信息
     * @param overdueCstmAddrDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public void deleteOverdueCstmAddrsByOverdueCstmAddrIds(OverdueCstmAddrDeleteListVo overdueCstmAddrDeleteListVo){
        overdueCstmAddrRepository.deleteDataList(overdueCstmAddrDeleteListVo.getOverdueCstmAddrIds(),overdueCstmAddrDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmAddrId获取逾期客户地址信息
     * @param overdueCstmAddrId
     * @return OverdueCstmAddr
     * @throws
     * @author lijunjun
     * @date 2018-5-17 14:48:57
     */
    public OverdueCstmAddr findOverdueCstmAddrByOverdueCstmAddrId(String overdueCstmAddrId){
        return overdueCstmAddrRepository.selectByPrimaryKey(overdueCstmAddrId);
    }

}
