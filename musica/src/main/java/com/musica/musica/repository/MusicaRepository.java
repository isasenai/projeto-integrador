package com.musica.musica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.musica.musica.models.Musica;

public interface MusicaRepository extends CrudRepository<Musica, String> {

	Musica findByCodigo(long codigo);
	
	List<Musica> findByNome(String nome);
	
	@Query(value = "select u from Musica u where u.nome like %?1%")
	List<Musica>findByNomesMusica(String nome);
}
