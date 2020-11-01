package com.senforage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.senforage.dao.IResponsables;
import com.senforage.entities.Responsables;

//@EntityScan("<com.senforage.entities>")

@SpringBootApplication
public class SenforageSnApplication {

	public static void main(String[] args) {
	ApplicationContext ctx =	 SpringApplication.run(SenforageSnApplication.class, args);
	
	IResponsables iresponsables = ctx.getBean(IResponsables.class);
		
//	Responsables responsables = new Responsables();
//	responsables.setId(1);
//	responsables.setPrenom("Alpha");
//	responsables.setNom("DIA");
//	responsables.setEmail("Alpha@mail");
//	responsables.setPassword("alpha");
	
//	try {
//		iresponsables.save(responsables);
//		
//	}catch(Exception e){
//		e.printStackTrace();
//		
//	}

	
	}

}
