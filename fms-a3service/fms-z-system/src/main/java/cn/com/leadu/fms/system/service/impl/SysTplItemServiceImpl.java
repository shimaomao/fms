package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysTplItemRepository;
import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.system.service.SysTplItemService;
import cn.com.leadu.fms.system.validator.systplitem.vo.SysTplItemDeleteListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemService
 * @Description: 模板可设项目管理业务实现层
 * @date 2018-03-12
 */
@Service
public class SysTplItemServiceImpl implements SysTplItemService {

    /**
     * @Fields  : 模板可设项目管理repository
     */
    @Autowired
    private SysTplItemRepository sysTplItemRepository;

    /**
     * @Title:
     * @Description:  通过tplItemId集合删除模板可设项目管理
     * @param sysTplItemDeleteListVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    public void deleteSysTplItemsByTplItemIds(SysTplItemDeleteListVo sysTplItemDeleteListVo){
        sysTplItemRepository.deleteDataList(sysTplItemDeleteListVo.getTplItemIds(),sysTplItemDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 保存模板可设项目List
     * @param sysTplItemList
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-15 10:53:25
     */
    @Override
    public void saveSysTplItemList(List<SysTplItem> sysTplItemList) {
        sysTplItemRepository.insertDataList(sysTplItemList);
    }

    /**
     * @Title:
     * @Description: 根据tplTypeKey获取模板类型的可设置项目
     * @param tplTypeKey
     * @return List
     * @throws
     * @author wangxue
     * @date 2018-3-15 10:53:25
     */
    @Override
    public List<SysTplItemVo> findSysTplItemListByTplTypeKey(String tplTypeKey) {
        if (StringUtils.isNotTrimBlank(tplTypeKey)) {
            Example example = SqlUtil.newExample(SysTplItem.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tplTypeKey", tplTypeKey);
            SqlUtil.setOrderByUpdateTimeDesc(example);
            List<SysTplItem> sysTplItemList = sysTplItemRepository.selectListByExample(example);
            List<SysTplItemVo> sysTplItemVoList = new ArrayList<>();
            for (SysTplItem sysTplItem : sysTplItemList) {
                SysTplItemVo sysTplItemVo = EntityUtils.getEntity(sysTplItem, new SysTplItemVo());
                sysTplItemVoList.add(sysTplItemVo);
            }
            return sysTplItemVoList;
        }
        return new ArrayList<>();
    }
}
