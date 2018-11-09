package cn.com.leadu.fms.pojo.system.vo.sysuser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * @author wangxue
 * @ClassName: SysUserSelectVo
 * @Description: 登录时用户信息载体
 * @date 2018/3/19
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUserLoginVo {

    private String user; // 用户账号

    private String userPassword; // 用户密码

    private String code; // 验证Code

    private String timeStamp; // 时间戳
}
