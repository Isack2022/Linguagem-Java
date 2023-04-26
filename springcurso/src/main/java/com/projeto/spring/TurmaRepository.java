package com.projeto.spring;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.spring.curso.domain.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{

}
 