package com.smartGwtExample.client;

import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.util.SC;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public class CrudLayout extends VLayout {

	private ListGrid itemList = new ListGrid();	
	private HLayout buttonLayout = new HLayout();
	private IButton addItemButton = new IButton();
	private IButton editItemButton = new IButton();
	private IButton removeItemButton = new IButton();
	
	public CrudLayout(final DataSource dataSource, final String itemName) {
		
		addItemButton.setTitle("Add " + itemName);
		removeItemButton.setTitle("Remove " + itemName);
		editItemButton.setTitle("Edit " + itemName);
		
		addItemButton.setAutoFit(true);
		editItemButton.setAutoFit(true);
		removeItemButton.setAutoFit(true);
		
		setMembersMargin(10);

		buttonLayout.setMembers(addItemButton, editItemButton, removeItemButton);
		buttonLayout.setMembersMargin(5);
		
		itemList.setDataSource(dataSource);
		itemList.setAutoFetchData(true);
		itemList.setWidth(600);
		itemList.setHeight(200);
		itemList.setShowAllRecords(true);
		itemList.setSelectionType(SelectionStyle.SINGLE);
		
		setMembers(itemList, buttonLayout);
		
		editItemButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (itemList.anySelected()) {
					new AddEditDialog(dataSource, itemList).show();
				} else {
					SC.say("You have to select a " + itemName + ".");
				}								
			}
		});
		
		removeItemButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				if (itemList.anySelected()) {
					itemList.removeSelectedData();	
				} else {
					SC.say("You have to select a " + itemName + ".");
				}								
			}
		});
		
		addItemButton.addClickHandler(new ClickHandler() {
			
			public void onClick(ClickEvent event) {
				new AddEditDialog(dataSource, null).show();
			}
		});
	}
}
