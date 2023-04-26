package com.projeto.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.spring.curso.domain.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

}
 