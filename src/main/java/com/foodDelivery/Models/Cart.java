package com.foodDelivery.Models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
	private Map<Integer, CartItem> items;

	public Cart() {
		this.items = new HashMap<>();
	}
	
	public void addItem(CartItem ci){
		int itemId = ci.getItemId();
		if(items.containsKey(itemId)) {
			ci.setQuantity(items.get(itemId).getQuantity()+ci.getQuantity());
			items.put(itemId, ci);
		}else {
			items.put(itemId, ci);		
		}
	}
	
	public void updateItem(int itemId, int quantity){
		if(items.containsKey(itemId)) {
			if(quantity <= 0) {
				items.remove(itemId);
			}else {
				items.get(itemId).setQuantity(quantity);
			}
		}
	}
	
	public void removeItem(int itemId){
		items.remove(itemId);
	}
	
	public Map<Integer, CartItem> getItems() {
		return items;
	}
	
	public void clear() {
		items.clear();
	}
	
}
