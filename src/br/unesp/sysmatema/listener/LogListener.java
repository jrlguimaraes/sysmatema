package br.unesp.sysmatema.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.bridge.SLF4JBridgeHandler;


public class LogListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed....");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("contextInitialized....");
		//http://www.mkyong.com/jsf2/jsf-2-log4j-integration-example/
		 
		//remove the jsf root logger, avoid duplicated logging
		//try comment out this and see the different on the console
		
		SLF4JBridgeHandler.removeHandlersForRootLogger();
		SLF4JBridgeHandler.install();

	}

}
