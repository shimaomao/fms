package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.system.repository.SysUserRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.SecHandInventory;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.CollectionPersonService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.CollectionPersonRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonSaveVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonModifyVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonDeleteVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import tk.mybatis.mapper.entity.Example;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonService
 * @Description: 催收组员业务实现层
 */
@Service
public class CollectionPersonServiceImpl implements CollectionPersonService {

    /**
     * @Fields  : 催收组员repository
     */
    @Autowired
    private CollectionPersonRepository collectionPersonRepository;

    @Autowired
    private SysUserRepository sysUserRepository;

    /**
     * @Title:
     * @Description: 分页查询催收组员
     * @param collectionPersonVo
     * @return PageInfoExtend<CollectionPersonVo>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public PageInfoExtend<CollectionPersonVo> findCollectionPersonVosByPage(CollectionPersonVo collectionPersonVo){

        if (StringUtils.isNotTrimBlank(collectionPersonVo.getCollectionPersonNum())){
            collectionPersonVo.setCollectionPersonNum(SqlUtil.likePattern(collectionPersonVo.getCollectionPersonNum()));
        }else{
            collectionPersonVo.setCollectionPersonNum(null);
        }

        if (StringUtils.isTrimBlank(collectionPersonVo.getCollectionType())){
            collectionPersonVo.setCollectionType(null);
        }

        PageInfoExtend<CollectionPersonVo> pageInfo = collectionPersonRepository.selectListVoByPage("selectCollectionPersonVosByPage", collectionPersonVo, collectionPersonVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存催收组员
     * @param collectionPersonSaveVo
     * @return java.lang.String
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    public void saveCollectionPerson(CollectionPersonSaveVo collectionPersonSaveVo){
        if (alreadyHaveInfo(collectionPersonSaveVo.getEntity()) != null) {
            throw new FmsServiceException("该类型下已有此账号存在");
        }
        collectionPersonRepository.insertData(collectionPersonSaveVo.getEntity());
    }
    /**
     * @Title:
     * @Description: 修改催收组员
     * @param collectionPersonModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    public void modifyCollectionPerson(CollectionPersonModifyVo collectionPersonModifyVo){
        collectionPersonRepository.updateByPrimaryKeySelectiveData(collectionPersonModifyVo.getEntity());
    }

    //查询库中是否已经存在该类型的数据 供修改、保存使用
    public CollectionPerson alreadyHaveInfo (CollectionPerson collectionPerson){
        Example example = new Example(CollectionPerson.class);
        //设置查询条件
        example.createCriteria().andEqualTo("collectionType",collectionPerson.getCollectionType())
                .andEqualTo("collectionPersonNum",collectionPerson.getCollectionPersonNum());
        CollectionPerson collection= collectionPersonRepository.selectOneByExample(example);

        return  collection;
    }
    /**
     * @Title:
     * @Description:  通过collectionPersonId删除催收组员
     * @param collectionPersonDeleteVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    public void deleteCollectionPerson(CollectionPersonDeleteVo collectionPersonDeleteVo){
        collectionPersonRepository.deleteData(collectionPersonDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过collectionPersonId集合删除催收组员
     * @param collectionPersonDeleteListVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    public void deleteCollectionPersonsByCollectionPersonIds(CollectionPersonDeleteListVo collectionPersonDeleteListVo){
        collectionPersonRepository.deleteDataList(collectionPersonDeleteListVo.getCollectionPersonIds(),collectionPersonDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据collectionPersonId获取催收组员Vo
     * @param collectionPersonId
     * @return CollectionPerson
     * @throws
     * @author qinmuqiao
     * @date 2018-9-3 10:55:13
     */
    @Override
    public CollectionPersonVo findCollectionPersonVoByCollectionPersonId(String collectionPersonId) {
        CollectionPersonVo collectionPersonVo = new CollectionPersonVo();
        //获取催收人员信息
        CollectionPerson collectionPerson = collectionPersonRepository.selectByPrimaryKey(collectionPersonId);
        if (collectionPerson != null) {
            collectionPersonVo = EntityUtils.getEntity(collectionPerson, new CollectionPersonVo());
            Example example = new Example(SysUser.class);
            //获取催人人员名称
            example.createCriteria().andEqualTo("user",collectionPersonVo.getCollectionPersonNum());
            SysUser sysUser = sysUserRepository.selectOneByExample(example);
            if (sysUser != null) {
                collectionPersonVo.setCollectionPersonName(sysUser.getUserName());
            }

        }
        return collectionPersonVo;
    }
}
