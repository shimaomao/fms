package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.prebiz.dao.ApplyCancelDao;
import cn.com.leadu.fms.data.prebiz.repository.ApplyCancelRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyCancel;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import org.springframework.stereotype.Repository;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
@Repository
public class ApplyCancelRepositoryImpl extends AbstractBaseRepository<ApplyCancelDao, ApplyCancel> implements ApplyCancelRepository {

    //分页查询融资申请取消vo
    public PageInfoExtend<ApplyCancel> selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }


    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return ApplyCancelVo
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    public ApplyCancelVo selectApplyCancelVoByApplyNo(String applyNo){
        return baseDao.selectApplyCancelVoByApplyNo(applyNo);

    }
}
