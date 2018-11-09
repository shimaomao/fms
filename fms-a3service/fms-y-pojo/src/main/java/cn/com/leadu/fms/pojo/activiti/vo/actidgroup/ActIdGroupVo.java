package cn.com.leadu.fms.pojo.activiti.vo.actidgroup;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author qiaomengnan
 * @ClassName: ActIdGroupVo
 * @Description: 用户组vo
 * @date 2018/6/19
 */
@Data
public class ActIdGroupVo {

    private String id;

    private String rev;

    private String name;

    private String type;

}
