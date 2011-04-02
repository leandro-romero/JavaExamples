package com.smartGwtExample.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.data.fields.DataSourceIntegerField;
import com.smartgwt.client.data.fields.DataSourceTextField;

public class PersonDS extends DataSource {

	public PersonDS() {		

		DataSourceIntegerField pkField = new DataSourceIntegerField("id");  
		pkField.setHidden(false);  
		pkField.setPrimaryKey(true);
		pkField.setCanEdit(false);

		DataSourceTextField nameField = new DataSourceTextField("name", "Name", 30, true);
		DataSourceTextField surnameField = new DataSourceTextField("surname", "Surname", 50, true);
		DataSourceIntegerField ageField = new DataSourceIntegerField("age", "Age", 3, true);

		setFields(pkField, nameField, surnameField, ageField);
		setClientOnly(true);
	}
}
