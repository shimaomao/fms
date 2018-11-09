package cn.com.leadu.fms.common.exception;

/**
 * @ClassName: FmsRedisKeyNotFoundException
 * @Description: redis未加载到key异常
 * @author qiaohao
 * @date 2017/10/27
 */
public class FmsRedisKeyNotFoundException extends FmsRuntimeException {

	private String redisKey;

	public FmsRedisKeyNotFoundException(String msg) {
		super(msg);
	}

	public FmsRedisKeyNotFoundException(String msg, String rediskey) {
		super(msg);
        this.redisKey = redisKey;
    }

    public String getRedisKey() {
        return redisKey;
    }
}
