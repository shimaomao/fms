package cn.com.leadu.fms.common.exception;

/**
 * @ClassName: FmsRuntimeException
 * @Description: 运行时异常
 * @author qiaohao
 * @date 2017/10/27
 */
public class FmsRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 5439915454935047937L;

    public FmsRuntimeException(String msg){
        super(msg);
    }

    public FmsRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
