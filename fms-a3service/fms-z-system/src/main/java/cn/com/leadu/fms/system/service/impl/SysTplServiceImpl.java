package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.service.CommonExcelService;
import cn.com.leadu.fms.business.service.TempCommonExcelService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.*;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.system.entity.*;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.pojo.system.vo.wltemp01.WlTempAllVo;
import cn.com.leadu.fms.system.service.SysTplItemService;
import cn.com.leadu.fms.system.service.SysTplService;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplDeleteListVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplModifyVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplService
 * @Description: 模板管理业务实现层
 * @date 2018-03-12
 */
@Service
public class SysTplServiceImpl implements SysTplService {

    /**
     * @Fields  : 模板管理repository
     */
    @Autowired
    private SysTplRepository sysTplRepository;

    @Autowired
    private SysTplItemService sysTplItemService;

    @Autowired
    private TempCommonExcelService commonExcelService;

    @Autowired
    private WlTemp02Repository wlTemp02Repository;
    @Autowired
    private WlTemp01Repository wlTemp01Repository;
    @Autowired
    private WlTempRentRepository wlTempRentRepository;
    @Autowired
    private WlTempRentOverRepository wlTempRentOverRepository;
    @Autowired
    private WlTempRentBadRepository wlTempRentBadRepository;

    /**
     * @Title:
     * @Description: 分页查询模板信息Vo
     * @param sysTplVo
     * @return PageInfoExtend<SysTpl>
     * @throws
     * @author wangxue
     * @date 2018-3-12 15:16:19
     */
    public PageInfoExtend<SysTplVo> findSysTplVosByPage(SysTplVo sysTplVo){
        // 模板类型
        if (StringUtils.isTrimBlank(sysTplVo.getTplType())) {
            sysTplVo.setTplType(null);
        }
        // 模板名称
        if (StringUtils.isNotTrimBlank(sysTplVo.getTplName())) {
            sysTplVo.setTplName(SqlUtil.likePattern(sysTplVo.getTplName()));
        } else {
            sysTplVo.setTplName(null);
        }
        // 模板类型
        if (StringUtils.isNotTrimBlank(sysTplVo.getTplTypeName())) {
            sysTplVo.setTplTypeName(SqlUtil.likePattern(sysTplVo.getTplTypeName()));
        } else {
            sysTplVo.setTplTypeName(null);
        }

        PageInfoExtend<SysTplVo> pageInfo = sysTplRepository.selectListVoByPage("selectSysTplVosByPages", sysTplVo, sysTplVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存模板管理
     * @param sysTplSaveVo
     * @return java.lang.String
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public void saveSysTpl(SysTplSaveVo sysTplSaveVo){
        sysTplRepository.insertData(sysTplSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改模板管理
     * @param sysTplModifyVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public void modifySysTpl(SysTplModifyVo sysTplModifyVo){
        sysTplRepository.updateByPrimaryKeySelectiveData(sysTplModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过tplId集合删除模板管理
     * @param sysTplDeleteListVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public void deleteSysTplsByTplIds(SysTplDeleteListVo sysTplDeleteListVo){
        sysTplRepository.deleteDataList(sysTplDeleteListVo.getTplIds(),sysTplDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据tplId获取模板管理
     * @param tplId
     * @return SysTpl
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    public SysTplVo findSysTplVoByTplId(String tplId){
        SysTplVo sysTplVo = sysTplRepository.selectSysTplVoByTplId(tplId);
        // 取得可设置项目
        List<SysTplItemVo> sysTplItemVoList = sysTplItemService.findSysTplItemListByTplTypeKey(sysTplVo.getTplTypeKey());
        if (ArrayUtils.isNotNullAndLengthNotZero(sysTplItemVoList)) {
            sysTplVo.setTplItemList(sysTplItemVoList);
        } else {
            sysTplVo.setTplItemList(new ArrayList<>());
        }
        return sysTplVo;
    }

    /**
     * @Title:
     * @Description:  根据tplName获取模板信息
     * @param tplName
     * @return SysTpl
     * @throws
     * @author wubaoliang
     * @date 2018-3-16 15:16:19
     */
    @Override
    public SysTpl findSysTplByTplName(String tplName) {
        if (StringUtils.isNotTrimBlank(tplName)) {
            Example example = SqlUtil.newExample(SysTpl.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("tplName", tplName);
            SqlUtil.setOrderByUpdateTimeDesc(example);
            return sysTplRepository.selectOneByExample(example);
        }
        return null;
    }

    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板信息
     * @param sysTplVo
     * @return String
     * @throws
     * @author huchenghao
     * @date 2018-3-16 15:16:19
     */
    @Override
    public List<SysTpl> findSysTplListByBasFileTypeList(SysTplVo sysTplVo) {
        Example example = SqlUtil.newExample(SysTpl.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("tplTypeKey",sysTplVo.getTplTypeKeys());
        SqlUtil.setOrderByUpdateTimeDesc(example);
        List<SysTpl> sysTplList=sysTplRepository.selectListByExample(example);
        return sysTplList;
    }


    @Transactional
    @Override
    public void importdatas(){

        String filePath0 = "C:\\data\\fms_file\\datamove\\all.xlsx";
        String filePath1 = "C:\\data\\fms_file\\datamove\\rent.xlsx";
        String filePath2 = "C:\\data\\fms_file\\datamove\\rentOver.xlsx";
        String filePath3 = "C:\\data\\fms_file\\datamove\\rentBad.xlsx";

        List<WlTempAllVo> wlTempAlls = commonExcelService.importExcelToData(filePath0,WlTempAllVo.class);
        List<WlTempRent> wlTempRents = commonExcelService.importExcelToData(filePath1,WlTempRent.class);
        List<WlTempRentOver> wlTempRentOvers = commonExcelService.importExcelToData(filePath2,WlTempRentOver.class);
        List<WlTempRentBad> wlTempRentBads = commonExcelService.importExcelToData(filePath3,WlTempRentBad.class);

        wlTempRentRepository.insertDataList(wlTempRents);
        wlTempRentOverRepository.insertDataList(wlTempRentOvers);
        wlTempRentBadRepository.insertDataList(wlTempRentBads);
        List<WlTemp01> wlTemp01s = new ArrayList<WlTemp01>();
        List<WlTemp02> wlTemp02s = new ArrayList<WlTemp02>();
        for(WlTempAllVo wlTempAllVo : wlTempAlls){
            WlTemp01 wlTemp01 = EntityUtils.getEntity(wlTempAllVo, new WlTemp01());

            WlTemp02 wlTemp02 = EntityUtils.getEntity(wlTempAllVo, new WlTemp02());
            wlTemp02.setColumnk1(wlTempAllVo.getColumn1());
            wlTemp01s.add(wlTemp01);
            wlTemp02s.add(wlTemp02);
        }
        wlTemp01Repository.insertDataList(wlTemp01s);
        wlTemp02Repository.insertDataList(wlTemp02s);
    }
}
