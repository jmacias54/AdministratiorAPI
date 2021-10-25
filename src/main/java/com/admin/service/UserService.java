package com.admin.service;

import com.admin.model.in.UserIn;
import com.admin.model.out.UserOut;

public interface UserService {
	
	UserOut login(UserIn in);

}
