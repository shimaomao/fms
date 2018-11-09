package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.BizActStatusRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.BizActStatus;
import cn.com.leadu.fms.pojo.prebiz.vo.bizactstatus.BizActStatusVo;
import cn.com.leadu.fms.business.service.BizActStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author niehaibing
 * @ClassName: BizActStatusService
 * @Description: 业务状态管理业务实现层
 * @date 2018-03-27
 */
@Service
public class BizActStatusServiceImpl implements BizActStatusService {

    /**
     * @Fields  : 业务状态管理repository
     */
    @Autowired
    private BizActStatusRepository bizActStatusRepository;

    /**
     * @Title:
     * @Description: 分页查询业务状态管理
     * @param bizActStatusVo
     * @return PageInfoExtend<BizActStatus>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public PageInfoExtend<BizActStatus> findBizActStatussByPage(BizActStatusVo bizActStatusVo){
        Example example = SqlUtil.newExample(BizActStatus.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BizActStatus> pageInfo = bizActStatusRepository.selectListByExamplePage(example,bizActStatusVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据actStsId获取业务状态管理
     * @param actStsId
     * @return BizActStatus
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public BizActStatus findBizActStatusByActStsId(String actStsId){
        return bizActStatusRepository.selectByPrimaryKey(actStsId);
    }

    /**
     * @Title:
     * @Description:  根据操作和操作前状态取得操作后状态
     * @param actWidgetId befStatus actStsType
     * @return String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public String getAftStsByActIdAndBef(String actWidgetId, String actStsType){
        return getAftStsByActIdAndBef(actWidgetId, "", actStsType);
    }

    /**
     * @Title:
     * @Description:  根据操作和操作前状态取得操作后状态
     * @param actWidgetId befStatus actStsType
     * @return String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 16:21:22
     */
    public String getAftStsByActIdAndBef(String actWidgetId, String befStatus, String actStsType){
        BizActStatus bizActStatusRtn = null;
        Example example = SqlUtil.newExample(BizActStatus.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("actStsType",actStsType);
        criteria.andEqualTo("actWidgetId",actWidgetId);

        if(StringUtils.isTrimBlank(befStatus)){
            Example.Criteria criteria1 = example.createCriteria();
            example.and(criteria1.andIsNull("befStatus").orEqualTo("befStatus",""));
        } else {
            criteria.andEqualTo("befStatus",befStatus);
        }
        bizActStatusRtn = bizActStatusRepository.selectOneByExample(example);
        if(bizActStatusRtn == null){
            return null;
        }
        return bizActStatusRtn.getAftStatus();
    }
}
