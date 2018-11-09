package cn.com.leadu.fms.common.exception;

/**
 * @author qiaomengnan
 * @ClassName: FmsException
 * @Description: 异常基类
 * @date 2018/1/7
 */
public class FmsException extends Exception {

    private static final long serialVersionUID = 5439915454935047937L;

    public FmsException(String msg){
        super(msg);
    }

    public FmsException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
