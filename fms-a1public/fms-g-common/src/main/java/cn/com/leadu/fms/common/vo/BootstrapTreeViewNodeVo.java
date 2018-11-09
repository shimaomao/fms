package cn.com.leadu.fms.common.vo;

import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: BootstrapTreeView
 * @Description: 前端树控件对象
 * @date 2018/2/3
 */
@Data
public class BootstrapTreeViewNodeVo {

    /**
     * @Fields  : 节点id
     * @author qiaomengnan
     */
    private String id;

    /** 
     * @Fields  : 节点文字
     * @author qiaomengnan
     */ 
    private String text;

    /**
     * @Fields  : 是否是最后一个节点
     * @author qiaomengnan
     */
    private Boolean lastNode;

    /** 
     * @Fields  : (根节点)最后一个节点集合
     * @author qiaomengnan
     */ 
    private List<BootstrapTreeViewNodeVo> lastNodes;

    /** 
     * @Fields  : 直接上级id
     * @author qiaomengnan
     */ 
    private String parentId;
    
    /** 
     * @Fields  : 直接上级名称
     * @author qiaomengnan
     */ 
    private String parentText;
    
    /** 
     * @Fields  : 所有的上级节点
     * @author qiaomengnan
     */ 
    private Map<String,String> parentNodes;

    /** 
     * @Fields  : 节点状态
     * @author qiaomengnan
     */ 
    private Map<String,Boolean> state ;

    /** 
     * @Fields  : 节点附加属性
     * @author qiaomengnan
     */ 
    private Map<String,Object> attributes ;

    /** 
     * @Fields  : 子节点
     * @author qiaomengnan
     */ 
    private List<BootstrapTreeViewNodeVo> nodes;

    public BootstrapTreeViewNodeVo(){
        state = new HashMap<>();
        state.put("checked",false);
    }

    public Map<String,Object> getAttributes(){
        //判断是否是必填,如果是必填展示的内容需要做处理
        if(attributes != null && StringUtils.equals(YesNoFlagEnums.YES.getType(),StringUtils.getValue(attributes.get("fileChkFlag")))) {
            if(!this.getText().contains("&nbsp;"))
                this.setText(this.getText() + "&nbsp;<b class='form-error'>*</b>");
        }
        return attributes;
    }


}
