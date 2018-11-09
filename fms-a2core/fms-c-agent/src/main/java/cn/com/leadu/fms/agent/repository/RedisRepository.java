package cn.com.leadu.fms.agent.repository;

import org.springframework.data.redis.core.BoundValueOperations;

import java.util.List;

/**
 * @author qiaohao
 * @InterfaceName: RedisRepository
 * @Description:
 * @date: 2017/11/16 12:48
 */
public interface RedisRepository {
    /**
     * @Title: save
     * @Description:
     * @param key
     * @param value
     * @param time
     * @return void
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:50:05
     */
	void save(Object key, Object value, int time);

    /**
     * @Title: getOperations
     * @Description:
     * @param key
     * @return org.springframework.data.redis.core.BoundValueOperations<java.lang.Object,java.lang.Object>
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:50:17
     */
	BoundValueOperations<Object, Object> getOperations(String key);

    /**
     * @Title: setIfAbsent
     * @Description:
     * @param key
     * @param value
     * @return boolean
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:50:36
     */
	boolean setIfAbsent(String key, String value);

    /**
     * @Title: save
     * @Description:
     * @param key
     * @param value
     * @return void
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:50:48
     */
	void save(Object key, Object value);

    /**
     * @Title: get
     * @Description:
     * @param key
     * @return java.lang.Object
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:51:07
     */
	Object get(Object key);

    boolean containsKey(String key);

    /**
     * @Title: delete
     * @Description:
     * @param key
     * @return void
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:51:31
     */
	void delete(Object key);

    /**
     * @Title: getAllKeys
     * @Description:
     * @param pattern
     * @return java.util.List<java.lang.String>
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:51:45
     */
    List<String> getAllKeys(String pattern);

    /**
     * @Title: deleteByPattern
     * @Description:
     * @param pattern
     * @return void
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:49:40
     */
	void deleteByPattern(String pattern);

	/**
     * @Title: getObjectList
     * @Description:
     * @param keyName
     * @return java.util.List<java.lang.Object>
     * @throws
     *
     * @author luxin
     * @date 2017/11/16 12:49:11
     */
    List<Object> getObjectList(String keyName);
}