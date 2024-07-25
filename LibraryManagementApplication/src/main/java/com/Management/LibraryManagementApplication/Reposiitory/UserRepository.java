package com.Management.LibraryManagementApplication.Reposiitory;

import com.Management.LibraryManagementApplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
