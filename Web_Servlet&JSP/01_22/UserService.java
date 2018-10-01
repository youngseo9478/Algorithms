



public interface UserService {
	 public UserVO login(String id , String pw);
	 public int addUser(UserVO user);
	 public UserVO getUser(String uid);
	 public List<UserVO> getUserList();
	 public int removeUser(String uid);
	 public int updateUser(UserVO user);
	 public List<UserVO> searchUser(String condition, String keyword);
}
