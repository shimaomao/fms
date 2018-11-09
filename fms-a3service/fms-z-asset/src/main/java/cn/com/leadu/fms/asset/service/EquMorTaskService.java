package cn.com.leadu.fms.asset.service;

import cn.com.leadu.fms.pojo.asset.entity.EquMorTask;

/**
 * @author qiaomengnan
 * @ClassName: EquMorTaskService
 * @Description: 资方抵押任务业务层
 * @date 2018-05-30
 */
public interface EquMorTaskService {

	/**
	 * @Title:
	 * @Description:   保存资方抵押任务
	 * @param equMorTask
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/01 05:57:28
	 */
	void saveEquMorTask(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description: 修改资方抵押任务
	 * @param equMorTask
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-30 16:58:52
	 */
	void modifyEquMorTask(EquMorTask equMorTask);

	/**
	 * @Title:
	 * @Description:   根据资方抵押任务号查询抵押任务
	 * @param equMorTaskNo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/11 02:58:41
	 */
	EquMorTask findEquMorTaskByEquMorTaskNo(String equMorTaskNo);

}
