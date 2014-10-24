package br.unesp.sysmatema.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class SimpleController {
	
	public String vaiPara() {
		System.out.println("OLHA O MACACO!");
		return "sucesso";
	}

}
