package com.dailyPe.UserManager.repository;

import com.dailyPe.UserManager.model.Manager;
import com.dailyPe.UserManager.model.User;
import org.hibernate.engine.spi.Managed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface IManagerRepo extends JpaRepository<Manager, Long> {

}
