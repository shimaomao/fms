package cn.com.leadu.fms.code.provider.db.table.model;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import cn.com.leadu.fms.code.util.StringHelper;
import cn.com.leadu.fms.code.util.TFMakeName;

/**
 * 鐢ㄤ簬鐢熸垚浠ｇ爜鐨凾able瀵硅薄.瀵瑰簲鏁版嵁搴撶殑table
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class Table implements java.io.Serializable, Cloneable {

	String sqlName;
	String remarks;
	String className;
	String tableNameNew;

	/** the name of the owner of the synonym if this table is a synonym */
	private String ownerSynonymName = null;
	/** real table name for oracle SYNONYM */
	private String tableSynonymName = null;

	ColumnSet columns = new ColumnSet();
	List<Column> primaryKeyColumns = new ArrayList<Column>();

	public Table() {
	}

	public Table(Table t) {
		setSqlName(t.getSqlName());
		this.remarks = t.getRemarks();
		this.className = t.getClassName();
		this.ownerSynonymName = t.getOwnerSynonymName();
		setColumns(t.getColumns());
		this.primaryKeyColumns = t.getPrimaryKeyColumns();
		this.tableAlias = t.getTableAlias();
		this.exportedKeys = t.exportedKeys;
		this.importedKeys = t.importedKeys;
		this.tableNameNew = t.tableNameNew;
	}

	public String getTableNameNew() {
			if(tableNameNew==null||"".equals(tableNameNew)) {
				tableNameNew=StringHelper.toJavaClassName(sqlName);
			}
			return tableNameNew;
	}

	public void setTableNameNew(String tableNameNew) {
			this.tableNameNew = tableNameNew;
	}

	public LinkedHashSet<Column> getColumns() {
		return columns.getColumns();
	}

	public void setColumns(LinkedHashSet<Column> columns) {
		this.columns.setColumns(columns);
	}

	public String getOwnerSynonymName() {
		return ownerSynonymName;
	}

	public void setOwnerSynonymName(String ownerSynonymName) {
		this.ownerSynonymName = ownerSynonymName;
	}

	public String getTableSynonymName() {
		return tableSynonymName;
	}

	public void setTableSynonymName(String tableSynonymName) {
		this.tableSynonymName = tableSynonymName;
	}

	/** 浣跨敤 getPkColumns() 鏇挎崲 */
	@Deprecated
	public List<Column> getPrimaryKeyColumns() {
		return primaryKeyColumns;
	}

	/** 浣跨敤 setPkColumns() 鏇挎崲 */
	@Deprecated
	public void setPrimaryKeyColumns(List<Column> primaryKeyColumns) {
		this.primaryKeyColumns = primaryKeyColumns;
	}

	/** 鏁版嵁搴撲腑琛ㄧ殑琛ㄥ悕绉�,鍏跺畠灞炴�у緢澶氶兘鏄牴鎹灞炴�ф淳鐢� */
	public String getSqlName() {
		return sqlName;
	}

	public void setSqlName(String sqlName) {
		this.sqlName = sqlName;
	}

	/** 鏁版嵁搴撲腑琛ㄧ殑琛ㄥ娉� */
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void addColumn(Column column) {
		columns.addColumn(column);
	}

	public void setClassName(String customClassName) {
		System.out.println("customClassName************************************************"+customClassName);
		this.className = customClassName;
	}

	/**
	 * 鏍规嵁sqlName寰楀埌鐨勭被鍚嶇О锛岀ず渚嬪��: UserInfo
	 * 
	 * @return
	 */
	public String getClassName() {
		if (StringHelper.isBlank(className)) {
			return StringHelper.toJavaClassName(sqlName);
		} else {
			return className;
		}
	}

	/** 鏁版嵁搴撲腑琛ㄧ殑鍒悕锛岀瓑浠蜂簬: getRemarks().isEmpty() ? getClassName() : getRemarks() */
	public String getTableAlias() {
		if (StringHelper.isNotBlank(tableAlias))
			return tableAlias;
		return StringHelper.removeCrlf(StringHelper.defaultIfEmpty(getRemarks(), getClassName()));
	}

	public void setTableAlias(String v) {
		this.tableAlias = v;
	}

	/**
	 * 绛変环浜巊etClassName().toLowerCase()
	 * 
	 * @return
	 */
	public String getClassNameLowerCase() {
		return getClassName().toLowerCase();
	}
	/**
	 * 将新的表名 第一个字母改成小写
	 * @return
	 */
	public String getTableNameNewLowerCase() {
		System.out.println("---------TableNameNewLowerCase:"+TFMakeName.tofristlower(getTableNameNew()));
		return TFMakeName.tofristlower(getTableNameNew());
	}

	/**
	 * @Title:
	 * @Description:   将名称全部改为小写
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/01 11:27:30
	 */
	public String getTableNameNewLowerCaseAll(){
		return getTableNameNew().toLowerCase();
	}

	/**
	 * @Title:
	 * @Description:   获取第一个主键的名称
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/07 06:27:06
	 */
	public String getFirstPkColumnName(){
		return this.columns.getPkColumn().getColumnName();
	}

	/**
	 * @Title:
	 * @Description:   获取第一个主键的名称，首字母是小写
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/08 01:41:36
	 */
	public String getFirstPkColumnNameFirstLower(){
		return this.columns.getPkColumn().getColumnNameFirstLower();
	}

	/**
	 * @Title:
	 * @Description:   是否存在Date类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/08 08:13:42
	 */
	public boolean getIsExistDateType(){
		for(Column column : this.columns.getColumns()){
			if(column.getJavaType() != null && column.getJavaType().indexOf("Date") != -1){
				return true;
			}
		}
		return false;

	}

	/**
	 * @Title:
	 * @Description:   是否存在BigDecimal类型
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/03/26 11:20:25
	 */
	public boolean getIsExistDecimalType(){
		for(Column column : this.columns.getColumns()){
			if(column.getJavaType() != null && column.getSqlTypeName().indexOf("DECIMAL") != -1){
				return true;
			}
		}
		return false;
	}


	/**
	 * 寰楀埌鐢ㄤ笅鍒掔嚎鍒嗛殧鐨勭被鍚嶇О锛屽className=UserInfo,鍒檜nderscoreName=user_info
	 * 
	 * @return
	 */
	public String getUnderscoreName() {
		return StringHelper.toUnderscoreName(getClassName()).toLowerCase();
	}

	/**
	 * 杩斿洖鍊间负getClassName()鐨勭涓�涓瓧姣嶅皬鍐�,濡俢lassName=UserInfo,鍒機lassNameFirstLower=userInfo
	 * 
	 * @return
	 */
	public String getClassNameFirstLower() {
		return StringHelper.uncapitalize(getClassName());
	}

	/**
	 * 鏍规嵁getClassName()璁＄畻鑰屾潵,鐢ㄤ簬寰楀埌甯搁噺鍚�,濡俢lassName=UserInfo,鍒檆onstantName=USER_INFO
	 * 
	 * @return
	 */
	public String getConstantName() {
		return StringHelper.toUnderscoreName(getClassName()).toUpperCase();
	}

	/** 浣跨敤 getPkCount() 鏇挎崲 */
	@Deprecated
	public boolean isSingleId() {
		return getPkCount() == 1 ? true : false;
	}

	/** 浣跨敤 getPkCount() 鏇挎崲 */
	@Deprecated
	public boolean isCompositeId() {
		return getPkCount() > 1 ? true : false;
	}

	/** 浣跨敤 getPkCount() 鏇挎崲 */
	@Deprecated
	public boolean isNotCompositeId() {
		return !isCompositeId();
	}

	/**
	 * 寰楀埌涓婚敭鎬绘暟
	 * 
	 * @return
	 */
	public int getPkCount() {
		return columns.getPkCount();
	}

	/**
	 * use getPkColumns()
	 * 
	 * @deprecated
	 */
	public List getCompositeIdColumns() {
		return getPkColumns();
	}

	/**
	 * 寰楀埌鏄富閿殑鍏ㄩ儴column
	 * 
	 * @return
	 */
	public List<Column> getPkColumns() {
		return columns.getPkColumns();
	}

	/**
	 * 寰楀埌涓嶆槸涓婚敭鐨勫叏閮╟olumn
	 * 
	 * @return
	 */
	public List<Column> getNotPkColumns() {
		return columns.getNotPkColumns();
	}

	/** 寰楀埌鍗曚富閿紝绛変环浜巊etPkColumns().get(0) */
	public Column getPkColumn() {
		Column c = columns.getPkColumn();
		// if(c == null) {
		// throw new IllegalStateException("not found primary key on table:"+getSqlName());
		// }
		return c;
	}

	/** 浣跨敤 getPkColumn()鏇挎崲 */
	@Deprecated
	public Column getIdColumn() {
		return getPkColumn();
	}

	public List<Column> getEnumColumns() {
		return columns.getEnumColumns();
	}

	public Column getColumnByName(String name) {
		return columns.getByName(name);
	}

	public Column getColumnBySqlName(String sqlName) {
		return columns.getBySqlName(sqlName);
	}

	public Column getRequiredColumnBySqlName(String sqlName) {
		if (getColumnBySqlName(sqlName) == null) {
			throw new IllegalArgumentException("not found column with sqlName:" + sqlName + " on table:" + getSqlName());
		}
		return getColumnBySqlName(sqlName);
	}

	/**
	 * 蹇界暐杩囨护鎺夋煇浜涘叧閿瓧鐨勫垪,鍏抽敭瀛椾笉鍖哄垎澶у皬鍐�,浠ラ�楀彿鍒嗛殧
	 * 
	 * @param ignoreKeywords
	 * @return
	 */
	public List<Column> getIgnoreKeywordsColumns(String ignoreKeywords) {
		List results = new ArrayList();
		for (Column c : getColumns()) {
			String sqlname = c.getSqlName().toLowerCase();
			if (StringHelper.contains(sqlname, ignoreKeywords.split(","))) {
				continue;
			}
			results.add(c);
		}
		return results;
	}

	/**
	 * This method was created in VisualAge.
	 */
	public void initImportedKeys(DatabaseMetaData dbmd) throws java.sql.SQLException {

		// get imported keys a

		ResultSet fkeys = dbmd.getImportedKeys(catalog, schema, this.sqlName);

		while (fkeys.next()) {
			String pktable = fkeys.getString(PKTABLE_NAME);
			String pkcol = fkeys.getString(PKCOLUMN_NAME);
			String fktable = fkeys.getString(FKTABLE_NAME);
			String fkcol = fkeys.getString(FKCOLUMN_NAME);
			String seq = fkeys.getString(KEY_SEQ);
			Integer iseq = new Integer(seq);
			getImportedKeys().addForeignKey(pktable, pkcol, fkcol, iseq);
		}
		fkeys.close();
	}

	/**
	 * This method was created in VisualAge.
	 */
	public void initExportedKeys(DatabaseMetaData dbmd) throws java.sql.SQLException {
		// get Exported keys

		ResultSet fkeys = dbmd.getExportedKeys(catalog, schema, this.sqlName);

		while (fkeys.next()) {
			String pktable = fkeys.getString(PKTABLE_NAME);
			String pkcol = fkeys.getString(PKCOLUMN_NAME);
			String fktable = fkeys.getString(FKTABLE_NAME);
			String fkcol = fkeys.getString(FKCOLUMN_NAME);
			String seq = fkeys.getString(KEY_SEQ);
			Integer iseq = new Integer(seq);
			getExportedKeys().addForeignKey(fktable, fkcol, pkcol, iseq);
		}
		fkeys.close();
	}

	/**
	 * @return Returns the exportedKeys.
	 */
	public ForeignKeys getExportedKeys() {
		if (exportedKeys == null) {
			exportedKeys = new ForeignKeys(this);
		}
		return exportedKeys;
	}

	/**
	 * @return Returns the importedKeys.
	 */
	public ForeignKeys getImportedKeys() {
		if (importedKeys == null) {
			importedKeys = new ForeignKeys(this);
		}
		return importedKeys;
	}

	public String toString() {
		return "Database Table:" + getSqlName() + " to ClassName:" + getClassName();
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// ignore
			return null;
		}
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public void setCatalog(String catalog) {
		this.catalog = catalog;
	}

	String catalog = null;
	String schema = null;

	private String tableAlias;
	private ForeignKeys exportedKeys;
	private ForeignKeys importedKeys;

	public static final String PKTABLE_NAME = "PKTABLE_NAME";
	public static final String PKCOLUMN_NAME = "PKCOLUMN_NAME";
	public static final String FKTABLE_NAME = "FKTABLE_NAME";
	public static final String FKCOLUMN_NAME = "FKCOLUMN_NAME";
	public static final String KEY_SEQ = "KEY_SEQ";
}
