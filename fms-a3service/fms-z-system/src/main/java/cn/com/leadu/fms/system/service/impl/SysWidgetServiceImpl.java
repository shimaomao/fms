package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysWidgetRepository;
import cn.com.leadu.fms.pojo.system.entity.SysWidget;
import cn.com.leadu.fms.pojo.system.vo.syswidget.SysWidgetVo;
import cn.com.leadu.fms.system.service.SysWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetService
 * @Description: 画面控件管理业务实现层
 * @date 2018-03-09
 */
@Service
public class SysWidgetServiceImpl implements SysWidgetService {

    /**
     * @Fields  : 画面控件管理repository
     */
    @Autowired
    private SysWidgetRepository sysWidgetRepository;

    /**
     * @Title:
     * @Description: 分页查询画面控件管理
     * @param sysWidgetVo
     * @return PageInfoExtend<SysWidget>
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    public PageInfoExtend<SysWidget> findSysWidgetsByPage(SysWidgetVo sysWidgetVo){
        Example example = SqlUtil.newExample(SysWidget.class);
        Example.Criteria criteria = example.createCriteria();
        // 类型
        if (StringUtils.isNotTrimBlank(sysWidgetVo.getWidgetType())) {
            criteria.andEqualTo("widgetType", sysWidgetVo.getWidgetType());
        }
        // 识别ID
        if (StringUtils.isNotTrimBlank(sysWidgetVo.getWidgetId())) {
            criteria.andLike("widgetId", SqlUtil.likePattern(sysWidgetVo.getWidgetId()));
        }
        // 名称
        if (StringUtils.isNotTrimBlank(sysWidgetVo.getWidgetName())) {
            criteria.andLike("widgetName", SqlUtil.likePattern(sysWidgetVo.getWidgetName()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysWidget> pageInfo = sysWidgetRepository.selectListByExamplePage(example,sysWidgetVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:   查出全部类型是画面的画面控件数据并以树的形式返回
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    @Override
    public Map<String, String> findSysWidgetByTree() {
        Map<String,String> sysWidgetMap = getSysWidgetByTree();
        return sysWidgetMap;
    }

    /**
     * @Title:
     * @Description:   查出全部类型是画面的画面控件数据并以树的形式返
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    private Map<String, String> getSysWidgetByTree() {
        Example example =SqlUtil.newExample(SysWidget.class);
        Example.Criteria criteria = example.createCriteria();
        // 类型 0；画面
        criteria.andEqualTo("widgetType", '0');
        SqlUtil.setOrderByCreateTimeDesc(example);
        List<SysWidget> sysWidgetList = sysWidgetRepository.selectListByExample(example);
        Map<String, String> resultMap = new HashMap<>();
        if (sysWidgetList != null && sysWidgetList.size() > 0) {
            for (SysWidget sysWidget : sysWidgetList) {
                resultMap.put(sysWidget.getWidgetId(), sysWidget.getWidgetName());
            }
        }
        return resultMap;
    }
}
