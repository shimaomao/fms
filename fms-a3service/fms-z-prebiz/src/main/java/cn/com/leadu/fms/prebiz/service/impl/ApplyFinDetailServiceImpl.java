package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyFinDetailRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfindetail.ApplyFinDetailVo;
import cn.com.leadu.fms.prebiz.service.ApplyFinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: ApplyFinDetailService
 * @Description: 融资费用明细信息业务实现层
 * @date 2018-03-24
 */
@Service
public class ApplyFinDetailServiceImpl implements ApplyFinDetailService {

    /**
     * @Fields  : 融资费用明细信息repository
     */
    @Autowired
    private ApplyFinDetailRepository applyFinDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询融资费用明细信息
     * @param applyFinDetailVo
     * @return PageInfoExtend<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public PageInfoExtend<ApplyFinDetail> findApplyFinDetailsByPage(ApplyFinDetailVo applyFinDetailVo){
        Example example = SqlUtil.newExample(ApplyFinDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ApplyFinDetail> pageInfo = applyFinDetailRepository.selectListByExamplePage(example,applyFinDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据applyFinDetailId获取融资费用明细信息
     * @param applyFinDetailId
     * @return ApplyFinDetail
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public ApplyFinDetail findApplyFinDetailByApplyFinDetailId(String applyFinDetailId){
        return applyFinDetailRepository.selectByPrimaryKey(applyFinDetailId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取融资费用明细信息
     * @param applyNo
     * @return List<ApplyFinDetail>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    public List<ApplyFinDetail> findApplyFinDetailsByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(ApplyFinance.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return applyFinDetailRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:  批量保存融资费用明细信息
     * @param applyFinDetailList
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:22:32
     */
    @Override
    public void saveApplyFinDetailList(List<ApplyFinDetail> applyFinDetailList) {
        applyFinDetailRepository.insertDataList(applyFinDetailList);
    }

    /**
     * @Title:
     * @Description:  根据订单编号，获取融资费用明细项目
     * @param applyNo
     * @throws
     * @author wangxue
     * @date 2018-3-29 19:22:32
     */
    @Override
    public Map<String, List<ApplyFinDetailVo>> findApplyFinDetailVoMapByApplyNo(String applyNo) {
        Map<String, List<ApplyFinDetailVo>> resultMap = new HashMap<>();
        // 根据订单编号 获取全部融资费用明细
        List<ApplyFinDetailVo> applyFinDetailVoList = applyFinDetailRepository.selectApplyFinDetailVosByApplyNo(applyNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(applyFinDetailVoList)) {
            String vehicleNo = "";
            List<ApplyFinDetailVo> tempList = new ArrayList<>();
            for (ApplyFinDetailVo applyFinDetailVo : applyFinDetailVoList) {
                // 融资项目名称
                if (applyFinDetailVo.getFinItemYear() != null && applyFinDetailVo.getFinItemYear() > 0) {
                    String finItemName = applyFinDetailVo.getFinItemName() + "(第" + applyFinDetailVo.getFinItemYear() + "年)";
                    applyFinDetailVo.setFinItemName(finItemName);
                }
                if (vehicleNo.equals(applyFinDetailVo.getVehicleNo())) {
                    tempList.add(applyFinDetailVo);
                } else {
                    if (!"".equals(vehicleNo)) {
                      resultMap.put(vehicleNo, tempList);
                    }
                    vehicleNo = applyFinDetailVo.getVehicleNo();
                    tempList = new ArrayList<>();
                    tempList.add(applyFinDetailVo);
                }
            }
            if (!"".equals(vehicleNo)) {
                resultMap.put(vehicleNo, tempList);
            }
        }
        return resultMap;
    }

    /**
     * @Title:
     * @Description:  根据订单编号和车辆序号，删除融资明细信息.
     * @param applyNo 订单编号
     * @param vehicleNoList 车辆序号
     * @throws
     * @author wangxue
     * @date 2018-3-29 19:22:32
     */
    @Override
    public void deleteApplyFinDetailByApplyNoAndVehicleNos(String applyNo, List<String> vehicleNoList) {
        Example example = SqlUtil.newExample(ApplyFinDetail.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applyNo", applyNo);
        criteria.andIn("vehicleNo", vehicleNoList);
        ApplyFinDetail applyFinDetail = new ApplyFinDetail();
        applyFinDetail.setDelFlag(DeleteFlags.EXIST.getFlag());
        applyFinDetailRepository.deleteByExample(example, applyFinDetail);
    }

    /**
     * @Title:
     * @Description:  根据订单编号和车辆序号，删除融资明细信息. 物理删除
     * @param applyNo 订单编号
     * @param vehicleNoList 车辆序号
     * @throws
     * @author wangxue
     * @date 2018-3-29 19:22:32
     */
    @Override
    public void deletePhysicsApplyFinDetailsByApplyNoAndVehicleNos(String applyNo, List<String> vehicleNoList) {
        Example example = SqlUtil.newExample(ApplyFinDetail.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("applyNo", applyNo);
        criteria.andIn("vehicleNo", vehicleNoList);
        SqlUtil.setOrderByColumnAsc(example, "vehicle_no");
        List<ApplyFinDetail> applyFinDetailList = applyFinDetailRepository.selectListByExample(example);
        // 需要删除的主键
        List<String> detailIds = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(applyFinDetailList)) {
            for (ApplyFinDetail applyFinDetail : applyFinDetailList) {
                detailIds.add(applyFinDetail.getApplyFinDetailId());
            }
            applyFinDetailRepository.deletePhysicsEntityList(detailIds);
        }
    }
}
