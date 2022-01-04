package cn.com.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "EXPEND_TYPE")
public class ExpendType extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; //

	@Column(name = "NAME")
	private String name; //
	@Column(name = "TYPE")
	private Integer type; // 支出分类：1--日常支出；2--大额支出
	
	// 是否有效（逻辑删除）：默认值为true查询时只查询出有效的数据，对selectbykey进行专门的limit
	@Column(name = "IS_VALID")
	private Boolean isValid = true; 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
}