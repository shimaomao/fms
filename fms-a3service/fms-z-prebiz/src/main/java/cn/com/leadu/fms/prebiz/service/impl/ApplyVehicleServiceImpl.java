package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyVehicleRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.prebiz.service.ApplyFinDetailService;
import cn.com.leadu.fms.prebiz.service.ApplyVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: ApplyVehicleService
 * @Description: 融资车辆信息业务实现层
 * @date 2018-03-24
 */
@Service
public class ApplyVehicleServiceImpl implements ApplyVehicleService {

    /**
     * @Fields  : 融资车辆信息repository
     */
    @Autowired
    private ApplyVehicleRepository applyVehicleRepository;

    @Autowired
    private ApplyFinDetailService applyFinDetailService;

    /**
     * @Title:
     * @Description: 分页查询融资车辆信息
     * @param applyVehicleVo
     * @return PageInfoExtend<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    public PageInfoExtend<ApplyVehicle> findApplyVehiclesByPage(ApplyVehicleVo applyVehicleVo){
        Example example = SqlUtil.newExample(ApplyVehicle.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ApplyVehicle> pageInfo = applyVehicleRepository.selectListByExamplePage(example,applyVehicleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据applyVehicleId获取融资车辆信息
     * @param applyVehicleId
     * @return ApplyVehicle
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    public ApplyVehicle findApplyVehicleByApplyVehicleId(String applyVehicleId){
        return applyVehicleRepository.selectByPrimaryKey(applyVehicleId);
    }

    /**
     * @Title:
     * @Description:  根据applyVehicleId获取融资车辆信息
     * @param applyNo
     * @return List<ApplyVehicle>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    public List<ApplyVehicle> findApplyVehiclesByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(ApplyFinance.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        SqlUtil.setOrderByColumnAsc(example, "vehicle_no");
        return applyVehicleRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  批量保存融资车辆信息
     * @param applyVehicleList
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    @Override
    public void saveApplyVehicleList(List<ApplyVehicle> applyVehicleList) {
        applyVehicleRepository.insertDataList(applyVehicleList);
    }

    /**
     * @Title:
     * @Description:  批量更新融资车辆信息
     * @param applyVehicleList
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    @Override
    public void modifyApplyVehicleList(List<ApplyVehicle> applyVehicleList) {
        applyVehicleRepository.updateByPrimaryKeySelectiveDataList(applyVehicleList);
    }

    /**
     * @Title:
     * @Description:  根据申请编号，获取融资车辆和融资明细信息
     * @param applyNo 申请编号
     * @throws
     * @author wangxue
     * @date 2018-3-29 19:20:32
     */
    @Override
    public List<ApplyVehicleVo> findApplyVehicleVosByApplyNo(String applyNo) {
        List<ApplyVehicleVo> applyVehicleVoList = applyVehicleRepository.selectApplyVehicleVoByApplyNo(applyNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(applyVehicleVoList)) {
            // 取得融资费用明细信息
            Map<String, List<ApplyFinDetailVo>> applyFinDetailMap = applyFinDetailService.findApplyFinDetailVoMapByApplyNo(applyNo);
            for (ApplyVehicleVo applyVehicleVo : applyVehicleVoList) {
                // 融资费用明细
                List<ApplyFinDetailVo> applyFinDetailVoList = applyFinDetailMap.get(applyVehicleVo.getVehicleNo());
                if (applyFinDetailVoList == null) {
                    applyFinDetailVoList = new ArrayList<>();
                }
                applyVehicleVo.setApplyFinDetailVoList(applyFinDetailVoList);
            }
        }
        return applyVehicleVoList;
    }

    /**
     * @Title:
     * @Description:  批量删除融资车辆信息以及对应的融资明细
     * @param applyVehicleList
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:20:32
     */
    @Override
    public void deleteApplyVehicleListAndFinDetail(List<ApplyVehicle> applyVehicleList) {
        // 车辆序号
        List<String> vehicleNoList = new ArrayList<>();
        List<String> vehicleIdList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(applyVehicleList)) {
            for (ApplyVehicle applyVehicle : applyVehicleList) {
                vehicleNoList.add(applyVehicle.getVehicleNo());
                vehicleIdList.add(applyVehicle.getApplyVehicleId());
            }
            // 删除融资车辆信息你
            applyVehicleRepository.deleteDataList(vehicleIdList, new ApplyVehicle());
            // 根据订单编号和车辆序号删除对应的融资明细
            applyFinDetailService.deleteApplyFinDetailByApplyNoAndVehicleNos(applyVehicleList.get(0).getApplyNo(), vehicleNoList);
        }
    }
}
