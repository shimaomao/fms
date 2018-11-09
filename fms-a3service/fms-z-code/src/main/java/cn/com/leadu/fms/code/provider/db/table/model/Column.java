package cn.com.leadu.fms.code.provider.db.table.model;

import java.util.List;

import cn.com.leadu.fms.code.generator.GeneratorProperties;
import cn.com.leadu.fms.code.provider.db.table.model.ForeignKey.ReferenceKey;
import cn.com.leadu.fms.code.provider.db.table.model.util.ColumnHelper;
import cn.com.leadu.fms.code.util.GLogger;
import cn.com.leadu.fms.code.util.StringHelper;
import cn.com.leadu.fms.code.util.TestDataGenerator;
import cn.com.leadu.fms.code.util.typemapping.ActionScriptDataTypesUtils;
import cn.com.leadu.fms.code.util.typemapping.DatabaseDataTypesUtils;
import cn.com.leadu.fms.code.util.typemapping.JavaPrimitiveTypeMapping;
import cn.com.leadu.fms.code.util.typemapping.JdbcType;

/**
 * 鐢ㄤ簬鐢熸垚浠ｇ爜鐨凜olumb瀵硅薄.瀵瑰簲鏁版嵁搴撹〃column
 * 
 * @author badqiu
 * @email badqiu(a)gmail.com
 */
public class Column implements java.io.Serializable, Cloneable {
	/**
	 * Reference to the containing table
	 */
	private Table _table;

	/**
	 * The java.sql.Types type
	 */
	private int _sqlType;

	/**
	 * The sql typename. provided by JDBC driver
	 */
	private String _sqlTypeName;

	/**
	 * The name of the column
	 */
	private String _sqlName;

	/**
	 * True if the column is a primary key
	 */
	private boolean _isPk;

	/**
	 * True if the column is a foreign key
	 */
	private boolean _isFk;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _size;

	private int _precision;

	/**
	 * @todo-javadoc Describe the column
	 */
	private int _decimalDigits;

	/**
	 * True if the column is nullable
	 */
	private boolean _isNullable;

	/**
	 * True if the column is indexed
	 */
	private boolean _isIndexed;

	/**
	 * True if the column is unique
	 */
	private boolean _isUnique;

	/**
	 * Null if the DB reports no default value
	 */
	private String _defaultValue;

	/**
	 * The comments of column
	 */
	private String _remarks;

	private String colNameOld;

	/**
	 * @param table
	 * @param sqlType
	 * @param sqlTypeName
	 * @param sqlName
	 * @param size
	 * @param decimalDigits
	 * @param isPk
	 * @param isNullable
	 * @param isIndexed
	 * @param isUnique
	 * @param defaultValue
	 * @param remarks
	 */
	public Column(Table table, int sqlType, String sqlTypeName, String sqlName, int size, int precision, int decimalDigits, boolean isPk, boolean isNullable, boolean isIndexed, boolean isUnique, String defaultValue, String remarks, String colNameO) {
		if (sqlName == null)
			throw new NullPointerException("sqlName must be not null");
		_table = table;
		_sqlType = sqlType;
		_sqlName = sqlName;
		_sqlTypeName = sqlTypeName;
		_size = size;
		_precision = precision;
		_decimalDigits = decimalDigits;
		_isPk = isPk;
		_isNullable = isNullable;
		_isIndexed = isIndexed;
		_isUnique = isUnique;
		_defaultValue = defaultValue;
		_remarks = remarks;
		colNameOld = colNameO;

		GLogger.trace(sqlName + " isPk -> " + _isPk);

		initOtherProperties();
	}

	public Column(Column c) {
		this(c.getTable(), c.getSqlType(), c.getSqlTypeName(), c.getSqlName(), c.getSize(), c.getPrecision(), c.getDecimalDigits(), c.getIsPk(), c.isNullable(), c.isIndexed(), c.isUnique(), c.getDefaultValue(), c.getRemarks(), c.getColNameOld());
	}

	public Column() {
	}

	public String getColNameOld() {
		return colNameOld;
	}

	public void setColNameOld(String colNameOld) {
		this.colNameOld = colNameOld;
	}

	/**
	 * Gets the SqlType attribute of the Column object
	 * 
	 * @return The SqlType value
	 */
	public int getSqlType() {
		return _sqlType;
	}

	/**
	 * Gets the Table attribute of the DbColumn object
	 * 
	 * @return The Table value
	 */
	public Table getTable() {
		return _table;
	}

	/**
	 * Gets the Size attribute of the DbColumn object
	 * 
	 * @return The Size value
	 */
	public int getSize() {
		return _size;
	}

	public int getPrecision() {
		return _precision;
	}

	/**
	 * Gets the DecimalDigits attribute of the DbColumn object
	 * 
	 * @return The DecimalDigits value
	 */
	public int getDecimalDigits() {
		return _decimalDigits;
	}

	/**
	 * Gets the SqlTypeName attribute of the Column object
	 * 
	 * @return The SqlTypeName value
	 */
	public String getSqlTypeName() {
		return _sqlTypeName;
	}

	/**
	 * Gets the SqlName attribute of the Column object
	 * 
	 * @return The SqlName value
	 */
	public String getSqlName() {
		if (_sqlName == null)
			throw new NullPointerException();
		return _sqlName;
	}

	public void setSqlName(String v) {
		if (StringHelper.isBlank(v))
			throw new IllegalArgumentException("sqlName must be not blank");
		if (!v.equalsIgnoreCase(_sqlName)) {
			throw new IllegalArgumentException("cannot change property:sqlName value");
		}
		this._sqlName = v;
	}

	/**
	 * Gets the Pk attribute of the Column object
	 * 
	 * @return The Pk value
	 */
	public boolean getIsPk() {
		return _isPk;
	}

	/**
	 * Gets the Fk attribute of the Column object
	 * 
	 * @return The Fk value
	 */
	public boolean isFk() {
		return _isFk;
	}

	/**
	 * Gets the Nullable attribute of the Column object
	 * 
	 * @return The Nullable value
	 */
	public boolean isNullable() {
		return _isNullable;
	}

	/**
	 * Gets the Indexed attribute of the DbColumn object
	 * 
	 * @return The Indexed value
	 */
	public boolean isIndexed() {
		return _isIndexed;
	}

	/**
	 * Gets the Unique attribute of the DbColumn object
	 * 
	 * @return The Unique value
	 */
	public boolean isUnique() {
		return _isUnique;
	}

	/**
	 * Gets the DefaultValue attribute of the DbColumn object
	 * 
	 * @return The DefaultValue value
	 */
	public String getDefaultValue() {
		return _defaultValue;
	}

	/**
	 * 鍒楃殑鏁版嵁搴撳娉�
	 * 
	 * @return
	 */
	public String getRemarks() {
		return _remarks == null ? "" : _remarks;
	}

	public void setUpdatable(boolean updatable) {
		this.updatable = updatable;
	}

	public void setInsertable(boolean insertable) {
		this.insertable = insertable;
	}

	public void setNullable(boolean v) {
		this._isNullable = v;
	}

	public void setUnique(boolean unique) {
		_isUnique = unique;
	}

	public void setPk(boolean v) {
		this._isPk = v;
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public int hashCode() {
		if (getTable() != null) {
			return (getTable().getSqlName() + "#" + getSqlName()).hashCode();
		} else {
			return (getSqlName()).hashCode();
		}
	}

	/**
	 * Describe what the method does
	 * 
	 * @param o
	 *            Describe what the parameter does
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for method parameter
	 * @todo-javadoc Write javadocs for return value
	 */
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof Column) {
			Column other = (Column) o;
			if (getSqlName().equals(other.getSqlName())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	public String toString() {
		return getSqlName();
	}

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// ignore
			return null;
		}
	}

	/**
	 * Describe what the method does
	 * 
	 * @return Describe the return value
	 * @todo-javadoc Write javadocs for method
	 * @todo-javadoc Write javadocs for return value
	 */
	protected String prefsPrefix() {
		return "tables/" + getTable().getSqlName() + "/columns/" + getSqlName();
	}

	/**
	 * Sets the Pk attribute of the DbColumn object
	 * 
	 * @param flag
	 *            The new Pk value
	 */
	void setFk(boolean flag) {
		_isFk = flag;
	}

	public String getUnderscoreName() {
		return getSqlName().toLowerCase();
	}

	/**
	 * 鏍规嵁鍒楀悕锛屾牴鎹畇qlName璁＄畻寰楀嚭锛岀ず渚嬪�硷細 BirthDate
	 **/
	public String getColumnName() {
		return columnName;
	}

	public boolean getIsQueryReserve() {
		return "ID".equalsIgnoreCase(columnName) || "createDate".equalsIgnoreCase(columnName) || "updateDate".equalsIgnoreCase(columnName);
	}

	/**
	 * 绗竴涓瓧姣嶅皬鍐欑殑columName,绛変环浜�: StringHelper.uncapitalize(getColumnName()),绀轰緥鍊�: birthDate
	 **/
	public String getColumnNameFirstLower() {
		return StringHelper.uncapitalize(getColumnName());
	}

	/**
	 * 鍏ㄩ儴灏忓啓鐨刢olumName,绛変环浜�: getColumnName().toLowerCase(),绀轰緥鍊�: birthdate
	 **/
	public String getColumnNameLowerCase() {
		return getColumnName().toLowerCase();
	}

	/**
	 * 浣跨敤 getColumnNameFirstLower()鏇挎崲
	 * 
	 * @deprecated use getColumnNameFirstLower() instead
	 */
	public String getColumnNameLower() {
		return getColumnNameFirstLower();
	}

	/**
	 * 寰楀埌 jdbcSqlType绫诲瀷鍚嶇О锛岀ず渚嬪��:VARCHAR,DECIMAL, 鐜癐batis3浣跨敤璇ュ睘鎬�
	 */
	public String getJdbcSqlTypeName() {
		return getJdbcType();
	}

	/**
	 * 寰楀埌 jdbcSqlType绫诲瀷鍚嶇О锛岀ず渚嬪��:VARCHAR,DECIMAL, 鐜癐batis3浣跨敤璇ュ睘鎬�
	 */
	public String getJdbcType() {
		String result = JdbcType.getJdbcSqlTypeName(getSqlType());
		return result;
	}

	/**
	 * 鍒楃殑鍒悕锛岀瓑浠蜂簬锛歡etRemarks().isEmpty() ? getColumnNameFirstLower() : getRemarks()
	 * 
	 * <br />
	 * 绀轰緥鍊�: birthDate
	 */
	public String getColumnAlias() {
		return columnAlias;
	}

	/**
	 * 鍒楃殑甯搁噺鍚嶇О
	 * 
	 * <br />
	 * 绀轰緥鍊�: BIRTH_DATE
	 */
	public String getConstantName() {
		return StringHelper.toUnderscoreName(getColumnName()).toUpperCase();
	}

	/**
	 * 
	 * @deprecated
	 */
	public boolean getIsNotIdOrVersionField() {
		return !getIsPk();
	}

	/** 寰楀埌 rapid-validation鐨勯獙璇佽〃杈惧紡: required min-value-800 */
	public String getValidateString() {
		return isNullable() ? getNoRequiredValidateString() : "required " + getNoRequiredValidateString();
	}

	/** 寰楀埌 rapid-validation鐨勯獙璇佽〃杈惧紡: min-value-800 */
	public String getNoRequiredValidateString() {
		return ColumnHelper.getRapidValidation(this);
	}

	/** 寰楀埌JSR303 bean validation(Hibernate Validator)鐨勯獙璇佽〃杈惧紡: @NotNull @Min(100) @Max(800) */
	public String[] getHibernateValidatorConstraintNames() {
		return ColumnHelper.removeHibernateValidatorSpecialTags(getHibernateValidatorExprssion());
	}

	/** 寰楀埌JSR303 bean validation(Hibernate Validator)鐨勯獙璇佽〃杈惧紡: @NotNull @Min(100) @Max(800) */
	public String getHibernateValidatorExprssion() {
		return hibernateValidatorExprssion;
	}

	public void setHibernateValidatorExprssion(String v) {
		hibernateValidatorExprssion = v;
	}

	/** 鍒楁槸鍚︽槸String绫诲瀷 */
	public boolean getIsStringColumn() {
		return DatabaseDataTypesUtils.isString(getJavaType());
	}

	/** 鍒楁槸鍚︽槸鏃ユ湡绫诲瀷 */
	public boolean getIsDateTimeColumn() {
		return DatabaseDataTypesUtils.isDate(getJavaType());
	}

	/** 鍒楁槸鍚︽槸Number绫诲瀷 */
	public boolean getIsNumberColumn() {
		return DatabaseDataTypesUtils.isFloatNumber(getJavaType()) || DatabaseDataTypesUtils.isIntegerNumber(getJavaType());
	}

	/** 妫�鏌ユ槸鍚﹀寘鍚煇浜涘叧閿瓧,鍏抽敭瀛椾互閫楀彿鍒嗛殧 */
	public boolean contains(String keywords) {
		if (keywords == null)
			throw new IllegalArgumentException("'keywords' must be not null");
		return StringHelper.contains(getSqlName(), keywords.split(","));
	}

	public boolean isHtmlHidden() {
		return getIsPk() && _table.isSingleId();
	}

	/**
	 * 寰楀埌瀵瑰簲鐨刯avaType,濡俲ava.lang.String,
	 * 
	 * @return
	 */
	public String getJavaType() {
		return javaType;
	}

	/**
	 * 寰楀埌绠�鐭殑javaType鐨勫悕绉帮紝濡俢om.company.model.UserInfo,灏嗚繑鍥� UserInfo
	 * 
	 * @return
	 */
	public String getSimpleJavaType() {
		if(getSqlTypeName().indexOf("DECIMAL") != -1){
			return "BigDecimal";
		}
		return StringHelper.getJavaClassSimpleName(getJavaType());
	}

	/**
	 * 寰楀埌灏藉彲鑳界畝鐭殑javaType鐨勫悕绉帮紝濡傛灉鏄痡ava.lang.String,灏嗚繑鍥濻tring, 濡俢om.company.model.UserInfo,灏嗚繑鍥� com.company.model.UserInfo
	 * 
	 * @return
	 */
	public String getPossibleShortJavaType() {
		if (getJavaType().startsWith("java.lang.")) {
			return getSimpleJavaType();
		} else {
			return getJavaType();
		}
	}

	public boolean isPrimitive() {
		return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(getJavaType()) != null;
	}

	/**
	 * 寰楀埌鍘熺敓绫诲瀷鐨刯avaType,濡俲ava.lang.Integer灏嗚繑鍥瀒nt,鑰岄潪鍘熺敓绫诲瀷灏嗙洿鎺ヨ繑鍥瀏etSimpleJavaType()
	 * 
	 * @return
	 */
	public String getPrimitiveJavaType() {
		return JavaPrimitiveTypeMapping.getPrimitiveType(getSimpleJavaType());
	}

	/**
	 * 寰楀埌鍘熺敓绫诲瀷鐨勫寘瑁呯被鍨�,濡俰nt灏嗚繑鍥濱nteger,鑰岄潪鍘熺敓绫诲瀷灏嗙洿鎺ヨ繑鍥瀏etSimpleJavaType()
	 * 
	 * @return
	 */
	public String getWrappedJavaType() {
		return JavaPrimitiveTypeMapping.getWrapperType(getSimpleJavaType());
	}

	/** 寰楀埌ActionScript鐨勬槧灏勭被鍨�,鐢ㄤ簬Flex浠ｇ爜鐨勭敓鎴� */
	public String getAsType() {
		return asType;
	}

	/** 寰楀埌鍒楃殑娴嬭瘯鏁版嵁 */
	public String getTestData() {
		return new TestDataGenerator().getDBUnitTestData(getColumnName(), getJavaType(), getSize());
	}

	/** 鍒楁槸鍚﹀彲浠ユ洿鏂� */
	public boolean isUpdatable() {
		return updatable;
	}

	/** 鍒楁槸鍚﹀彲浠ユ彃鍏� */
	public boolean isInsertable() {
		return insertable;
	}

	/** 寰楀埌鏋氫妇(enum)鐨勭被鍚嶇О锛岀ず渚嬪�硷細SexEnum */
	public String getEnumClassName() {
		return enumClassName;
	}

	/** 鏋氫妇鍊�,浠ュ垎鍙峰垎闅�,绀轰緥鍊�:M(1,鐢�);F(0,濂�) 鎴栬�呮槸:M(鐢�);F(濂�) */
	public void setEnumString(String str) {
		this.enumString = str;
	}

	/** 鏋氫妇鍊�,浠ュ垎鍙峰垎闅�,绀轰緥鍊�:M(1,鐢�);F(0,濂�) 鎴栬�呮槸:M(鐢�);F(濂�) */
	public String getEnumString() {
		return enumString;
	}

	/** 瑙ｆ瀽getEnumString()瀛楃涓茶浆鎹负List<EnumMetaDada>瀵硅薄 */
	public List<EnumMetaDada> getEnumList() {
		return StringHelper.string2EnumMetaData(getEnumString());
	}

	/** 鏄惁鏄灇涓惧垪锛岀瓑浠蜂簬:return getEnumList() != null && !getEnumList().isEmpty() */
	public boolean isEnumColumn() {
		return getEnumList() != null && !getEnumList().isEmpty();
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public void setColumnAlias(String columnAlias) {
		this.columnAlias = columnAlias;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public void setAsType(String asType) {
		this.asType = asType;
	}

	public void setEnumClassName(String enumClassName) {
		this.enumClassName = enumClassName;
	}

	// public void setBelongsTo(String foreignKey) {
	// ReferenceKey ref = ReferenceKey.fromString(foreignKey);
	// if(ref != null && _table != null) {
	// _table.getImportedKeys().addForeignKey(ref.tableName, ref.columnSqlName, getSqlName(), ref.columnSqlName.hashCode());
	// }
	// }
	//
	// public void setHasAndBelongsToMany(String foreignKey) {
	// }

	private ReferenceKey hasOne;

	public String getHasOne() {
		return ReferenceKey.toString(hasOne);
	}

	/** nullValue for ibatis sqlmap: <result property="age" column="age" nullValue="0" /> */
	public String getNullValue() {
		return JavaPrimitiveTypeMapping.getDefaultValue(getJavaType());
	}

	public boolean isHasNullValue() {
		return JavaPrimitiveTypeMapping.getWrapperTypeOrNull(getJavaType()) != null;
	}

	/**
	 * 璁剧疆many-to-one,foreignKey鏍煎紡: fk_table_name(fk_column) 鎴栬�� schema_name.fk_table_name(fk_column)
	 * 
	 * @param foreignKey
	 * @return
	 */
	public void setHasOne(String foreignKey) {
		hasOne = ReferenceKey.fromString(foreignKey);
		if (hasOne != null && _table != null) {
			// Table refTable = TableFactory.getInstance().getTable(hasOne.tableName);
			// _table.getImportedKeys().addForeignKey(refTable.getSqlName(), hasOne.columnSqlName, getSqlName(),
			// hasOne.columnSqlName.toLowerCase().hashCode());
			_table.getImportedKeys().addForeignKey(hasOne.tableName, hasOne.columnSqlName, getSqlName(), hasOne.columnSqlName.toLowerCase().hashCode());
		}
	}

	private ReferenceKey hasMany = null;

	public String getHasMany() {
		return ReferenceKey.toString(hasMany);
	}

	/**
	 * 璁剧疆one-to-many,foreignKey鏍煎紡: fk_table_name(fk_column) 鎴栬�� schema_name.fk_table_name(fk_column)
	 * 
	 * @param foreignKey
	 * @return
	 */
	public void setHasMany(String foreignKey) {
		hasMany = ReferenceKey.fromString(foreignKey);
		if (hasMany != null && _table != null) {
			// Table refTable = TableFactory.getInstance().getTable(hasMany.tableName);
			// _table.getExportedKeys().addForeignKey(refTable.getSqlName(), hasMany.columnSqlName, getSqlName(),
			// hasMany.columnSqlName.toLowerCase().hashCode());
			_table.getExportedKeys().addForeignKey(hasMany.tableName, hasMany.columnSqlName, getSqlName(), hasMany.columnSqlName.toLowerCase().hashCode());
		}
	}

	private void initOtherProperties() {
		String normalJdbcJavaType = DatabaseDataTypesUtils.getPreferredJavaType(getSqlType(), getSize(), getPrecision(), getDecimalDigits());
		javaType = GeneratorProperties.getProperty("java_typemapping." + normalJdbcJavaType, normalJdbcJavaType).trim();
		columnName = StringHelper.makeAllWordFirstLetterUpperCase(StringHelper.toUnderscoreName(getSqlName()));
		enumClassName = getColumnName() + "Enum";
		asType = ActionScriptDataTypesUtils.getPreferredAsType(getJavaType());
		columnAlias = StringHelper.removeCrlf(StringHelper.defaultIfEmpty(getRemarks(), getColumnNameFirstLower()));
		setHibernateValidatorExprssion(ColumnHelper.getHibernateValidatorExpression(this));
	}

	/** 鍒犻櫎鑱氶泦鍑芥暟鐨勭浉鍏砪har,绀轰緥杞崲 count(*) => count, max(age) => max_age, sum(income) => sum_income */
	public static String removeAggregationColumnChars(String columSqlName) {
		return columSqlName.replace('(', '_').replace(")", "").replace("*", "");
	}

	private String enumString = "";
	private String javaType;
	private String columnAlias;
	private String columnName;
	private String asType;
	private String enumClassName;
	private boolean updatable = true;
	private boolean insertable = true;
	private String hibernateValidatorExprssion;

	// private String rapidValidation;
	/**
	 * public enum ${enumClassName} { ${enumAlias}(${enumKey},${enumDesc}); private String key; private String value; }
	 * 
	 * @author badqiu
	 */
	public static class EnumMetaDada {
		private String enumAlias;
		private String enumKey;
		private String enumDesc;

		public EnumMetaDada(String enumAlias, String enumKey, String enumDesc) {
			super();
			this.enumAlias = enumAlias;
			this.enumKey = enumKey;
			this.enumDesc = enumDesc;
		}

		public String getEnumAlias() {
			return enumAlias;
		}

		public String getEnumKey() {
			return enumKey;
		}

		public String getEnumDesc() {
			return enumDesc;
		}
	}

}
