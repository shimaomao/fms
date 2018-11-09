package cn.com.leadu.fms.original.service.impl;

import cn.com.leadu.fms.business.common.util.activiti.ActFilePostUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActUtils;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.FileSendRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.common.constant.enums.original.PostStatusEnums;
import cn.com.leadu.fms.original.service.FileSendService;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteListVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendDeleteVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendModifyVo;
import cn.com.leadu.fms.original.validator.filesend.vo.FileSendSaveVo;
import cn.com.leadu.fms.pojo.original.entity.FileSend;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.original.vo.filesend.FileSendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

import static cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums.ALREADY_MAILED;
import static cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums.TO_BE_SORTED;

/**
 * @author ningyangyang
 * @ClassName: FileSendService
 * @Description: 资料邮寄业务实现层
 * @date 2018-05-04
 */
@Service
public class FileSendServiceImpl implements FileSendService {

    /**
     * @Fields  : 资料邮寄repository
     */
    @Autowired
    private FileSendRepository fileSendRepository;

    /**
     * @Fields  : 资料邮寄附件详情repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;
    /**
     * @Title:
     * @Description: 分页查询资料邮寄
     * @param fileSendVo
     * @return PageInfoExtend<FileSend>
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    public PageInfoExtend<FileSend> findFileSendsByPage(FileSendVo fileSendVo){
        Example example = SqlUtil.newExample(FileSend.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("postStatus", PostStatusEnums.TO_BE_RECEIVED.getType());
        if(StringUtils.isNotTrimBlank(fileSendVo.getPostNo())){
            criteria.andEqualTo("postNo",fileSendVo.getPostNo());
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<FileSend> pageInfo = fileSendRepository.selectListByExamplePage(example,fileSendVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 资料邮寄
     * @param fileSendSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @Transactional
    public void saveFileSend(FileSendSaveVo fileSendSaveVo){
        FileSend fileSend =  fileSendSaveVo.getEntity();
        fileSend.setPostStatus(PostStatusEnums.TO_BE_RECEIVED.getType());
        List<OrigFileDetail> origFileDetailList  =   fileSendSaveVo.getOrigFileDetails();
        fileSendRepository.insertData(fileSend);
        String fileSendId = fileSend.getFilePostId();
        List<OrigFileDetail> upList = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            for(OrigFileDetail OrigFileDetail : origFileDetailList){
                OrigFileDetail orig = new OrigFileDetail();
                orig.setOrigFileDetailId(OrigFileDetail.getOrigFileDetailId());
                orig.setFilePostId(fileSendId);
                orig.setOrigFileDetailStatus(ALREADY_MAILED.getType());
                upList.add(orig);
            }
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(upList);
        }
        //启动工作流
        String taskId = ActFilePostUtils.startFilePostAndComplete(fileSend.getPostNo(), PostStatusEnums.TO_BE_RECEIVED.getType(),fileSend.getPostComp()).getId();
    }

    /**
     * @Title:
     * @Description: 资料邮寄签收
     * @param fileSendModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    @Transactional
    public void modifyFileSend(FileSendModifyVo fileSendModifyVo){
            Example example = SqlUtil.newExample(OrigFileDetail.class);
            example.createCriteria().andEqualTo("filePostId",fileSendModifyVo.getFilePostId());
            OrigFileDetail origFileDetail = new OrigFileDetail();
            origFileDetail.setOrigFileDetailStatus(TO_BE_SORTED.getType());
            origFileDetailRepository.updateByExampleSelectiveData(origFileDetail,example);
            Example ex1 = SqlUtil.newExample(FileSend.class);
            ex1.createCriteria().andEqualTo("filePostId",fileSendModifyVo.getFilePostId());
            FileSend fileSend =  new FileSend();
            fileSend.setPostStatus(PostStatusEnums.ALREADY_RECEIVED.getType());
            fileSendRepository.updateByExampleSelectiveData(fileSend,ex1);

        //签收确认
       ActUtils.complete(fileSendModifyVo.getTaskId());
    }

    /**
     * @Title:
     * @Description:  通过filePostId删除资料邮寄
     * @param fileSendDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    public void deleteFileSend(FileSendDeleteVo fileSendDeleteVo){
        fileSendRepository.deleteData(fileSendDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过filePostId集合删除资料邮寄
     * @param fileSendDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    public void deleteFileSendsByFilePostIds(FileSendDeleteListVo fileSendDeleteListVo){
        fileSendRepository.deleteDataList(fileSendDeleteListVo.getFilePostIds(),fileSendDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据filePostId获取资料邮寄
     * @param filePostId
     * @return FileSend
     * @throws
     * @author ningyangyang
     * @date 2018-5-4 16:51:03
     */
    public FileSend findFileSendByFilePostId(String filePostId){
        return fileSendRepository.selectByPrimaryKey(filePostId);
    }

}
