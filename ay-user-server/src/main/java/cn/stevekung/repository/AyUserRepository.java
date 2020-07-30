package cn.stevekung.repository;

import cn.stevekung.pojo.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AyUserRepository extends JpaRepository<AyUser, String>{
    AyUser findByNameAndPassword(String name, String password);
}
