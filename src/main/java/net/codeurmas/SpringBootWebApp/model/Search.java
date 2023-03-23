package net.codeurmas.SpringBootWebApp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Search{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date keyword;

    public Search() {
		
	}
	
	public Date getKeyword() {
		return keyword;
	}

	public void setKeyword(Date keyword) {
		this.keyword = keyword;
	}

	

}
