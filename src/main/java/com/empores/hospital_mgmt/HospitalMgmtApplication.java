package com.empores.hospital_mgmt;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class HospitalMgmtApplication {



	public static void main(String[] args) {

		SpringApplication.run(HospitalMgmtApplication.class, args);
	}

}
