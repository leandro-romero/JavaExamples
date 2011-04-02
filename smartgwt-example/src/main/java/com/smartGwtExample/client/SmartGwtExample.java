package com.smartGwtExample.client;

import com.google.gwt.core.client.EntryPoint;
import com.smartgwt.client.data.DataSource;


public class SmartGwtExample implements EntryPoint {

   public void onModuleLoad()
   {      
	   DataSource dataSource = new PersonDS();
       CrudLayout crudLayout = new CrudLayout(dataSource, "person");
       
       crudLayout.show();
   }
}