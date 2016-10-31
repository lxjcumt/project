package sys.spvision.core.service.ana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.spvision.core.dao.ana.MenuDao;
import sys.spvision.core.dao.ana.PermissionDao;
import sys.spvision.core.dao.ana.UserDao;
import sys.spvision.core.entity.ana.Menu;
import sys.spvision.core.entity.ana.Permission;
import sys.spvision.core.entity.ana.User;
import sys.spvision.core.util.SecurityUtil;
import sys.spvision.core.vo.ana.MenuTreeNode;

@Service
public class AnaService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	MenuDao menuDao;
	
	@Autowired
	PermissionDao permissionDao;
	
	public User checkUser(String userName, String password) {
		System.out.println(1);
		User user=userDao.getUserbyLoginname(userName) ;
		System.out.println(2);
		if(user==null){
			 return null;
		}
		String selkey=SecurityUtil.genSalt(user.getLoginName());
		boolean flag=SecurityUtil.matchPassword(user.getLoginPassword(), selkey, password);
		if(flag){
			return user;
		}
		 return null;
	}
	
	public List<MenuTreeNode> getAllMenuTreeNodes(){
		List<Menu> menus = menuDao.getAllMenus();
		
		List<MenuTreeNode> list1 = new ArrayList<MenuTreeNode>(); 
		List<MenuTreeNode> list2 = new ArrayList<MenuTreeNode>(); 
		
		MenuTreeNode mtnAll = new MenuTreeNode();
		mtnAll.setId("");
		mtnAll.setText("菜单");
		mtnAll.setChildren(list2);
		
		list1.add(mtnAll);
		
		for(int i = 0;i < menus.size();i++){
			if (menus.get(i).getLevel() == 1) {
				MenuTreeNode mtn = new MenuTreeNode();
				mtn.setId(Long.toString(menus.get(i).getId()));
				mtn.setText(menus.get(i).getName());
				mtn.setChecked(false);
				List<MenuTreeNode> list3 = new ArrayList<MenuTreeNode>(); 
				mtn.setChildren(list3);
				for(int j = 0;j < menus.size(); j++){
					if ((2 == menus.get(j).getLevel()) && (menus.get(j).getParentId() == menus.get(i).getId()))  {
						MenuTreeNode mtn2 = new MenuTreeNode();
						mtn2.setId(Long.toString(menus.get(j).getId()));
						mtn2.setText(menus.get(j).getName());
						mtn2.setChecked(false);
						list3.add(mtn2);
					}
				}
				list2.add(mtn);
			}
		}
		return list1;
	}
	
	public List<MenuTreeNode> getAllMenuTreeNodesForEdit(Long roleId){
		List<Menu> menus = menuDao.getAllMenus();
		List<Menu> usedMenus = menuDao.getUsedMenusByUserId(roleId);
		
		Map<String, Object> MenusMap = new HashMap<String, Object>(usedMenus.size());
		for(Menu um:usedMenus) {
			MenusMap.put(Long.toString(um.getId()), um.getName());
		}
		
		List<MenuTreeNode> list1 = new ArrayList<MenuTreeNode>(); 
		List<MenuTreeNode> list2 = new ArrayList<MenuTreeNode>(); 
		
		MenuTreeNode mtnAll = new MenuTreeNode();
		mtnAll.setId("");
		mtnAll.setText("菜单");
		mtnAll.setChildren(list2);
		
		list1.add(mtnAll);
		
		for(int i = 0;i < menus.size();i++){
			if (menus.get(i).getLevel() == 1) {
				MenuTreeNode mtn = new MenuTreeNode();
				mtn.setId(Long.toString(menus.get(i).getId()));
				mtn.setText(menus.get(i).getName());
				List<MenuTreeNode> list3 = new ArrayList<MenuTreeNode>(); 
				mtn.setChildren(list3);
				for(int j = 0;j < menus.size(); j++){
					if ((2 == menus.get(j).getLevel()) && (menus.get(j).getParentId() == menus.get(i).getId()))  {
						MenuTreeNode mtn2 = new MenuTreeNode();
						mtn2.setId(Long.toString(menus.get(j).getId()));
						mtn2.setText(menus.get(j).getName());
						if(null != MenusMap.get(Long.toString(menus.get(j).getId()))){
							mtn2.setChecked(true);
						}
						list3.add(mtn2);
					}
				}
				list2.add(mtn);
			}
		}
		return list1;
	}
	
	public List<MenuTreeNode> getAllMenuTreeNodesCaseForEdit(Long roleId){
		List<Menu> menus = menuDao.getAllMenus();
		List<Menu> usedMenus = menuDao.getUsedMenusByUserCaseId(roleId);
		Map<String, Object> MenusMap = new HashMap<String, Object>(usedMenus.size());
		for(Menu um:usedMenus) {
			MenusMap.put(Long.toString(um.getId()), um.getName());
		}
		
		List<MenuTreeNode> list1 = new ArrayList<MenuTreeNode>(); 
		List<MenuTreeNode> list2 = new ArrayList<MenuTreeNode>(); 
		
		MenuTreeNode mtnAll = new MenuTreeNode();
		mtnAll.setId("");
		mtnAll.setText("菜单");
		mtnAll.setChildren(list2);
		
		list1.add(mtnAll);
		
		for(int i = 0;i < menus.size();i++){
			if (menus.get(i).getLevel() == 1) {
				MenuTreeNode mtn = new MenuTreeNode();
				mtn.setId(Long.toString(menus.get(i).getId()));
				mtn.setText(menus.get(i).getName());
				List<MenuTreeNode> list3 = new ArrayList<MenuTreeNode>(); 
				mtn.setChildren(list3);
				for(int j = 0;j < menus.size(); j++){
					if ((2 == menus.get(j).getLevel()) && (menus.get(j).getParentId() == menus.get(i).getId()))  {
						MenuTreeNode mtn2 = new MenuTreeNode();
						mtn2.setId(Long.toString(menus.get(j).getId()));
						mtn2.setText(menus.get(j).getName());
						if(null != MenusMap.get(Long.toString(menus.get(j).getId()))){
							mtn2.setChecked(true);
						}
						list3.add(mtn2);
					}
				}
				list2.add(mtn);
			}
		}
		return list1;
	}
	
	
	public Map<String, Object> getUserMenus(long userId) {
		
		List<Menu> menus = menuDao.getMenusByUserId(userId);
		
		List<Object> parentMenus = new ArrayList<Object>();
		System.out.println("size:"+menus.size());
		for(Menu m1:menus) {
			//get all level1 menus
			if (m1.getLevel() == 1) {
				Map<String, Object> parentMenu = new HashMap<String, Object>();
				
				parentMenu.put("id", m1.getId());
				parentMenu.put("name", m1.getName());
				parentMenu.put("code", m1.getCode());
				
				//get each parent menu's son
				List<Object> sonMenus = new ArrayList<Object>();
				for (Menu m2:menus) {
					if ((m2.getLevel() == 2) && (m2.getParentId() == m1.getId()))  {
						Map<String, Object> sonMenu = new HashMap<String, Object>();
						sonMenu.put("id", m2.getId());
						sonMenu.put("name", m2.getName());
						sonMenu.put("code", m2.getCode());
						sonMenu.put("url", m2.getUrl());
						sonMenus.add(sonMenu);
					}
				}
				parentMenu.put("submenus", sonMenus);
				
				parentMenus.add(parentMenu);
			}
		}
		System.out.println("parentMenus.size:"+parentMenus.size());
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("menus", parentMenus);
		return result;	
	}
	
	public List<Permission> getUserPermissions(long userId) {
		return permissionDao.getPermissionsByUserId(userId);
	}
	
}
