package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysAnnouncement;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.vo.sysannouncement.SysAnnouncementVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: SysAnnouncementRepository
 * @Description: 利率因子Repository层
 * @date 2018-04-27
 */
public interface SysAnnouncementRepository {

	/**
	 * @Title:
	 * @Description: 新增利率因子
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int insertData(SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 批量保存利率因子
	 * @param sysAnnouncements
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int insertDataList(List<SysAnnouncement> sysAnnouncements);

	/**
	 * @Title:
	 * @Description: 修改利率因子
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByPrimaryKeyData(SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 批量修改利率因子
	 * @param sysAnnouncements
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByPrimaryKeyDataList(List<SysAnnouncement> sysAnnouncements);

	/**
	 * @Title:
	 * @Description: 动态修改利率因子
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByPrimaryKeySelectiveData(SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 批量动态修改利率因子
	 * @param sysAnnouncements
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysAnnouncement> sysAnnouncements);

	/**
	 * @Title:
	 * @Description: 根据条件修改利率因子
	 * @param sysAnnouncement
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByExampleData(SysAnnouncement sysAnnouncement, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改利率因子
	 * @param sysAnnouncement
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int updateByExampleSelectiveData(SysAnnouncement sysAnnouncement, Example example);

	/**
	 * @Title:
	 * @Description: 根据announceId删除利率因子
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int deleteData(SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 根据announceId集合批量删除利率因子
	 * @param announceIds
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int deleteDataList(List announceIds, SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除利率因子
	 * @param example
	 * @param sysAnnouncement
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	int deleteExampleData(Example example, SysAnnouncement sysAnnouncement);

	/**
	 * @Title:
	 * @Description: 查询全部利率因子
	 * @return List<SysAnnouncement>
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	List<SysAnnouncement> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个利率因子
	 * @param example
	 * @return SysAnnouncement
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	SysAnnouncement selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询利率因子
	 * @param example
	 * @return List<SysAnnouncement>
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	List<SysAnnouncement> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过announceId查询利率因子
	 * @param announceId
	 * @return SysAnnouncement
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	SysAnnouncement selectByPrimaryKey(Object announceId);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<SysAnnouncement>
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	PageInfoExtend<SysAnnouncement> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询利率因子vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-4-27 11:47:37
	 */
	PageInfoExtend<SysAnnouncementVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
