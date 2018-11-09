package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import cn.com.leadu.fms.pojo.asset.vo.equreltask.EquRelTaskVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskSaveVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskModifyVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskDeleteVo;
import cn.com.leadu.fms.asset.validator.equreltask.vo.EquRelTaskDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskService
 * @Description: 资方解押任务业务层
 * @date 2018-05-30
 */
public interface EquRelTaskService {

	/**
	 * @Title:
	 * @Description: 分页查询资方解押任务
	 * @param equRelTaskVo
	 * @return PageInfoExtend<EquRelTask>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	PageInfoExtend<EquRelTask> findEquRelTasksByPage(EquRelTaskVo equRelTaskVo);

	/**
	 * @Title:
	 * @Description: 保存资方解押任务
	 * @param equRelTaskSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
    void saveEquRelTask(EquRelTaskSaveVo equRelTaskSaveVo);


	/**
	 * @Title:
	 * @Description: 修改资方解押任务
	 * @param equRelTaskModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	void modifyEquRelTask(EquRelTaskModifyVo equRelTaskModifyVo);

	/**
	 * @Title:
	 * @Description:  通过equRelTaskId删除资方解押任务
	 * @param equRelTaskDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	void deleteEquRelTask(EquRelTaskDeleteVo equRelTaskDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过equRelTaskId集合删除资方解押任务
	 * @param equRelTaskDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	void deleteEquRelTasksByEquRelTaskIds(EquRelTaskDeleteListVo equRelTaskDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据equRelTaskId获取资方解押任务
	 * @param equRelTaskId
	 * @return EquRelTask
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:56:55
	 */
	EquRelTask findEquRelTaskByEquRelTaskId(String equRelTaskId);

}
