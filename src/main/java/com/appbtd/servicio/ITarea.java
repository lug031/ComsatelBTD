package com.appbtd.servicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.appbtd.modelo.Tarea;

@EnableJpaRepositories
@Repository
public interface ITarea extends JpaRepository<Tarea, Integer>{

}
