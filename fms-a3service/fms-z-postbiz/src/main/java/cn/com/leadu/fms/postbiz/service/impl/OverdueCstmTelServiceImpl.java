package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.postbiz.service.OverdueCstmTelService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueCstmTelRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecstmtel.vo.OverdueCstmTelDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelService
 * @Description: 逾期客户电话信息业务实现层
 * @date 2018-05-17
 */
@Service
public class OverdueCstmTelServiceImpl implements OverdueCstmTelService {

    /**
     * @Fields  : 逾期客户电话信息repository
     */
    @Autowired
    private OverdueCstmTelRepository overdueCstmTelRepository;

    /**
     * @Title:
     * @Description: 分页查询逾期客户电话信息
     * @param overdueCstmTelVo
     * @return PageInfoExtend<OverdueCstmTel>
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public PageInfoExtend<OverdueCstmTel> findOverdueCstmTelsByPage(OverdueCstmTelVo overdueCstmTelVo){
        Example example = SqlUtil.newExample(OverdueCstmTel.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OverdueCstmTel> pageInfo = overdueCstmTelRepository.selectListByExamplePage(example,overdueCstmTelVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存逾期客户电话信息
     * @param overdueCstmTelSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public void saveOverdueCstmTel(OverdueCstmTelSaveVo overdueCstmTelSaveVo){
        overdueCstmTelRepository.insertData(overdueCstmTelSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改逾期客户电话信息
     * @param overdueCstmTelModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public void modifyOverdueCstmTel(OverdueCstmTelModifyVo overdueCstmTelModifyVo){
        overdueCstmTelRepository.updateByPrimaryKeySelectiveData(overdueCstmTelModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueCstmTelId删除逾期客户电话信息
     * @param overdueCstmTelDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public void deleteOverdueCstmTel(OverdueCstmTelDeleteVo overdueCstmTelDeleteVo){
        overdueCstmTelRepository.deleteData(overdueCstmTelDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueCstmTelId集合删除逾期客户电话信息
     * @param overdueCstmTelDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public void deleteOverdueCstmTelsByOverdueCstmTelIds(OverdueCstmTelDeleteListVo overdueCstmTelDeleteListVo){
        overdueCstmTelRepository.deleteDataList(overdueCstmTelDeleteListVo.getOverdueCstmTelIds(),overdueCstmTelDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmTelId获取逾期客户电话信息
     * @param overdueCstmTelId
     * @return OverdueCstmTel
     * @throws
     * @author lijunjun
     * @date 2018-5-17 10:37:53
     */
    public OverdueCstmTel findOverdueCstmTelByOverdueCstmTelId(String overdueCstmTelId){
        return overdueCstmTelRepository.selectByPrimaryKey(overdueCstmTelId);
    }

}
