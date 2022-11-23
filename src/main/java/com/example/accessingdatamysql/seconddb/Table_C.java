/**
 * @author padmahasa
 *
 */
package com.example.accessingdatamysql.seconddb;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="table_c")
public class Table_C {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  private String table_c_col_1;

  private String table_c_col_2;
  
  private String table_c_col_3;
  
  private String table_c_col_4;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

/**
 * @return the table_c_col_1
 */
public String getTable_c_col_1() {
	return table_c_col_1;
}

/**
 * @param table_c_col_1 the table_c_col_1 to set
 */
public void setTable_c_col_1(String table_c_col_1) {
	this.table_c_col_1 = table_c_col_1;
}

/**
 * @return the table_c_col_2
 */
public String getTable_c_col_2() {
	return table_c_col_2;
}

/**
 * @param table_c_col_2 the table_c_col_2 to set
 */
public void setTable_c_col_2(String table_c_col_2) {
	this.table_c_col_2 = table_c_col_2;
}

/**
 * @return the table_c_col_3
 */
public String getTable_c_col_3() {
	return table_c_col_3;
}

/**
 * @param table_c_col_3 the table_c_col_3 to set
 */
public void setTable_c_col_3(String table_c_col_3) {
	this.table_c_col_3 = table_c_col_3;
}

/**
 * @return the table_c_col_4
 */
public String getTable_c_col_4() {
	return table_c_col_4;
}

/**
 * @param table_c_col_4 the table_c_col_4 to set
 */
public void setTable_c_col_4(String table_c_col_4) {
	this.table_c_col_4 = table_c_col_4;
}

}
