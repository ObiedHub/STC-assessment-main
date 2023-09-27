package com.stc.stcsystemdesigntask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stc.stcsystemdesigntask.dao.PermissionGroupRepository;
import com.stc.stcsystemdesigntask.dao.PermissionRepository;
import com.stc.stcsystemdesigntask.model.Permission;
import com.stc.stcsystemdesigntask.model.PermissionGroup;
import com.stc.stcsystemdesigntask.model.enums.PermissionLevel;

@SpringBootApplication
public class StcSystemDesignTaskApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StcSystemDesignTaskApplication.class, args);
	}

	
	@Autowired
	private PermissionRepository permissionRepository;
	@Autowired
	private PermissionGroupRepository groupRepository;
	
	
	 @Override
	  public void run(String... arg0) throws Exception {
		 
		 
		 // init permissions
		 if (permissionRepository.findAll().isEmpty()) {
			 PermissionGroup admin = new PermissionGroup();
			 admin.setGroupName("admin");
			 groupRepository.save(admin);
			 
			 PermissionGroup user = new PermissionGroup();
			 user.setGroupName("user");
			 groupRepository.save(user);
			 
			 Permission per1 = new Permission();
			 per1.setPermissionGroup(admin);
			 per1.setPermissionLevel(PermissionLevel.VIEW);
			 per1.setUserEmail("a  dmin-view@stc.com");
			 permissionRepository.save(per1);
			
			 Permission per2 = new Permission();
			 per2.setPermissionGroup(admin);
			 per2.setPermissionLevel(PermissionLevel.EDIT);
			 per2.setUserEmail("admin-edit@stc.com");
			 permissionRepository.save(per2);
			 
			 Permission per3 = new Permission();
			 per3.setPermissionGroup(user);
			 per3.setPermissionLevel(PermissionLevel.VIEW);
			 per3.setUserEmail("user-view@stc.com");
			 permissionRepository.save(per3);
			 
			 Permission per4 = new Permission();
			 per4.setPermissionGroup(admin);
			 per4.setPermissionLevel(PermissionLevel.DOWNLOAD);
			 per4.setUserEmail("admin-download@stc.com");
			 permissionRepository.save(per4);
		 }
		 
	  }
}
