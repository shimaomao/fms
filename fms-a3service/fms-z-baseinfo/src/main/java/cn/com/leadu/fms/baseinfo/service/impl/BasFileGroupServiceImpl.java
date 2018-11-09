package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasFileGroupService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.baseinfo.repository.BasFileGroupRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfilegroup.BasFileGroupVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupSaveVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo.BasFileGroupDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupService
 * @Description: 附件组业务实现层
 */
@Service
public class BasFileGroupServiceImpl implements BasFileGroupService {

    /**
     * @Fields  : 附件组repository
     */
    @Autowired
    private BasFileGroupRepository basFileGroupRepository;

    /**
     * @Title:
     * @Description: 分页查询附件组
     * @param basFileGroupVo
     * @return PageInfoExtend<BasFileGroup>
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public PageInfoExtend<BasFileGroup> findBasFileGroupsByPage(BasFileGroupVo basFileGroupVo){
        Example example = SqlUtil.newExample(BasFileGroup.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BasFileGroup> pageInfo = basFileGroupRepository.selectListByExamplePage(example,basFileGroupVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存附件组
     * @param basFileGroupSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public void saveBasFileGroup(BasFileGroupSaveVo basFileGroupSaveVo){
        basFileGroupRepository.insertData(basFileGroupSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改附件组
     * @param basFileGroupModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public void modifyBasFileGroup(BasFileGroupModifyVo basFileGroupModifyVo){
        basFileGroupRepository.updateByPrimaryKeySelectiveData(basFileGroupModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过basFileGroupId删除附件组
     * @param basFileGroupDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public void deleteBasFileGroup(BasFileGroupDeleteVo basFileGroupDeleteVo){
        basFileGroupRepository.deleteData(basFileGroupDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过basFileGroupId集合删除附件组
     * @param basFileGroupDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public void deleteBasFileGroupsByBasFileGroupIds(BasFileGroupDeleteListVo basFileGroupDeleteListVo){
        basFileGroupRepository.deleteDataList(basFileGroupDeleteListVo.getBasFileGroupIds(),basFileGroupDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据basFileGroupId获取附件组
     * @param basFileGroupId
     * @return BasFileGroup
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:28
     */
    public BasFileGroup findBasFileGroupByBasFileGroupId(String basFileGroupId){
        return basFileGroupRepository.selectByPrimaryKey(basFileGroupId);
    }

}
