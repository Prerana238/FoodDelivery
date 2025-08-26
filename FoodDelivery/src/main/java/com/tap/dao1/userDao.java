package com.tap.dao1;

import java.util.List;


import com.tap.modles.user;

public interface userDao {
 
	void adduser(user user);
	void updateuser(user user);
	void deleteuser(int id);
	user getuser(int id);
	List<user>getallusers();
	user checkLogin(String username, String password);
}
