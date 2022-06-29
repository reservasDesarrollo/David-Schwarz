package xcale.service;

import xcale.entity.User;

public interface UserService extends BaseService<User,Integer >{
   User getUserByUserName(String user);
}
