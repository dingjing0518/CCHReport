package com.by.service;
import java.util.List;
import com.by.model.MenuData;
public interface MenuDataService {
	List<MenuData> findAll();
	MenuData save(MenuData w);
	MenuData save1(MenuData w);
	MenuData save2(MenuData w);
	MenuData save3(MenuData w);
	MenuData save4(MenuData w);
	MenuData save5(MenuData w);
	MenuData save6(MenuData w);
	MenuData update(MenuData w);	
	MenuData findOne(int id);
}
