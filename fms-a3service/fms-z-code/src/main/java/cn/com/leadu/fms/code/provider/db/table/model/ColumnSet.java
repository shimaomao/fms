package cn.com.leadu.fms.code.provider.db.table.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import cn.com.leadu.fms.code.util.StringHelper;
/**
 * 鍖呭惈涓�缁凜olumn瀵硅薄鐨勫鍣ㄧ被
 * @author badqiu
 *
 */
public class ColumnSet implements java.io.Serializable{
	private static final long serialVersionUID = -6500047411657968878L;
	
	private LinkedHashSet<Column> columns = new LinkedHashSet<Column>();

	public ColumnSet(){
	}
	
	public ColumnSet(Collection<? extends Column> columns) {
        super();
        this.columns = new LinkedHashSet(columns);
    }

    public LinkedHashSet<Column> getColumns() {
		return columns;
	}

	public void setColumns(LinkedHashSet<Column> columns) {
		this.columns = columns;
	}
	
	public void addColumn(Column c) {
		columns.add(c);
	}

	public Column getBySqlName(String name,int sqlType) {
		for(Column c : columns) {
			if(name.equalsIgnoreCase(c.getSqlName()) && c.getSqlType() == sqlType) {
				return c;
			}
		}
		return null;
	}
	
	public Column getBySqlName(String name) {
	    if(name == null) return null;
	    
		for(Column c : columns) {
			if(name.equalsIgnoreCase(c.getSqlName())) {
				return c;
			}
		}
		return null;
	}
	
	public Column getByName(String name) {
	    if(name == null) return null;
	    
        Column c = getBySqlName(name);
        if(c == null) {
            c = getBySqlName(StringHelper.toUnderscoreName(name));
        }
        return c;
	}

	public Column getByName(String name,int sqlType) {
        Column c = getBySqlName(name,sqlType);
        if(c == null) {
            c = getBySqlName(StringHelper.toUnderscoreName(name),sqlType);
        }
        return c;
	}
	
    public Column getByColumnName(String name) {
        if(name == null) return null;
        
        for(Column c : columns) {
            if(name.equals(c.getColumnName())) {
                return c;
            }
        }
        return null;
    }
	/**
	 * 寰楀埌鏄富閿殑鍏ㄩ儴column
	 * @return
	 */	
	public List<Column> getPkColumns() {
		List results = new ArrayList();
		for(Column c : getColumns()) {
			if(c.getIsPk())
				results.add(c);
		}
		return results;
	}
	
	/**
	 * 寰楀埌涓嶆槸涓婚敭鐨勫叏閮╟olumn
	 * @return
	 */
	public List<Column> getNotPkColumns() {
		List results = new ArrayList();
		for(Column c : getColumns()) {
			if(!c.getIsPk())
				results.add(c);
		}
		return results;
	}
	
	/**
	 * 寰楀埌涓婚敭鎬绘暟
	 * @return
	 */
	public int getPkCount() {
		int pkCount = 0;
		for(Column c : columns){
			if(c.getIsPk()) {
				pkCount ++;
			}
		}
		return pkCount;
	}
	
	/** 寰楀埌鍗曚富閿紝绛変环浜巊etPkColumns().get(0)  */
	public Column getPkColumn() {
		if(getPkColumns().isEmpty()) {
			return null;
		}
		return getPkColumns().get(0);
	}
	
	public List<Column> getEnumColumns() {
        List results = new ArrayList();
        for(Column c : getColumns()) {
            if(!c.isEnumColumn())
                results.add(c);
        }
        return results;	    
	}
}
