package cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee;

import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeResultFileVo
 * @Description: 金蝶接口返回信息 以及自定义的文件路径
 * @date 2018/7/18
 */
@Data
public class KingDeeResultFileVo {

    /** 
     * @Fields  : 操作结果状态码，0-succ，其它-操作失败。
     * @author qiaomengnan
     */ 
    private String code;

    /**
     * @Fields  : 操作结果描述信息
     * @author qiaomengnan
     */
    private String msg;

    /**
     * @Fields  : 错误说明
     * @author qiaomengnan
     */
    private String data;

    /**
     * @Fields  : 发送文件
     * @author qiaomengnan
     */
    private String sendFile;

    /**
     * @Fields  : 返回文件
     * @author qiaomengnan
     */
    private String returnFile;

}
