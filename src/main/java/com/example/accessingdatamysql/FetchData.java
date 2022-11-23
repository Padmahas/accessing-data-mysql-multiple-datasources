package com.example.accessingdatamysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.accessingdatamysql.firstdb.TableARepository;
import com.example.accessingdatamysql.firstdb.Table_A;
import com.example.accessingdatamysql.seconddb.TableCRepository;
import com.example.accessingdatamysql.seconddb.Table_C;

//import com.example.accessingdatamysql.firstdb.TableARepository;
//import com.example.accessingdatamysql.seconddb.TableCRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/demo") // This means URL's start with /demo (after Application path)
public class FetchData {
//	@Autowired
//	private TableAOldRepository tableARepository;
//
//	@Autowired
//	private TableCOldRepository tableCRepository;
	
	@Autowired
	private TableARepository tableARepository;

	@Autowired
	private TableCRepository tableCRepository;

	@GetMapping(path = "/addDataToFirstDB")
	public @ResponseBody void addDataToFirstDB() {
		// This returns a JSON or XML with the users
//		Table_AOld tableA = new Table_AOld();
		Table_A tableA = new Table_A();
		tableA.setTable_a_col_1("test1");
		tableA.setTable_a_col_2("test2");
		tableA.setTable_a_col_3("test3");
		tableA.setTable_a_col_4("test4");
		
		System.out.println("Inserting data into first DB.");
		tableARepository.save(tableA);
		
	}
	
	@GetMapping(path = "/addDataToSecondDB")
	@Transactional("secondDBTransactionManager")
	public @ResponseBody void addDataToSecondDB() {
		// This returns a JSON or XML with the users
		
//		Table_COld tableC = new Table_COld();
		Table_C tableC = new Table_C();
		tableC.setTable_c_col_1("test1");
		tableC.setTable_c_col_2("test2");
		tableC.setTable_c_col_3("test3");
		tableC.setTable_c_col_4("test4");
		
		System.out.println("Inserting data into second DB.");
		tableCRepository.save(tableC);
	}
}
