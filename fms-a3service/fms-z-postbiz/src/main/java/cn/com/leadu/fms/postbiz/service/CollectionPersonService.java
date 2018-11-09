package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.CollectionPerson;
import cn.com.leadu.fms.pojo.postbiz.vo.collectionperson.CollectionPersonVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonSaveVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonModifyVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonDeleteVo;
import cn.com.leadu.fms.postbiz.validator.collectionperson.vo.CollectionPersonDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qinmuqiao
 * @ClassName: CollectionPersonService
 * @Description: 催收组员业务层
 */
public interface CollectionPersonService {

	/**
	 * @Title:
	 * @Description: 分页查询催收组员
	 * @param collectionPersonVo
	 * @return PageInfoExtend<CollectionPersonVo>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
	PageInfoExtend<CollectionPersonVo> findCollectionPersonVosByPage(CollectionPersonVo collectionPersonVo);

	/**
	 * @Title:
	 * @Description: 保存催收组员
	 * @param collectionPersonSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
    void saveCollectionPerson(CollectionPersonSaveVo collectionPersonSaveVo);


	/**
	 * @Title:
	 * @Description: 修改催收组员
	 * @param collectionPersonModifyVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
	void modifyCollectionPerson(CollectionPersonModifyVo collectionPersonModifyVo);

	/**
	 * @Title:
	 * @Description:  通过collectionPersonId删除催收组员
	 * @param collectionPersonDeleteVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
	void deleteCollectionPerson(CollectionPersonDeleteVo collectionPersonDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过collectionPersonId集合删除催收组员
	 * @param collectionPersonDeleteListVo
	 * @return
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
	void deleteCollectionPersonsByCollectionPersonIds(CollectionPersonDeleteListVo collectionPersonDeleteListVo);


	/**
	 * @Title:
	 * @Description:  根据collectionPersonId获取催收组员Vo
	 * @param collectionPersonId
	 * @return CollectionPerson
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-3 10:55:13
	 */
	CollectionPersonVo findCollectionPersonVoByCollectionPersonId(String collectionPersonId);

}
