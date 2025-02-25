package com.example.apiT.repository;

import com.example.apiT.model.Tenda;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TendaRepository extends MongoRepository<Tenda, String> {

    
    List<Tenda> findByDisponivel(boolean disponivel);
    
    List<Tenda> findByTamanho(String tamanho);

    List<Tenda> findByNomeContaining(String nome);
    
    List<Tenda> findByPrecoDiariaBetween(double minPreco, double maxPreco);
    
    @Query("{ 'disponivel': true, 'precoDiaria': { $lt: ?0 } }")
    List<Tenda> buscarTendasDisponiveisComPrecoAbaixo(double precoMaximo);

    @Query("{ 'nome': { $regex: ?0, $options: 'i' } }")
    List<Tenda> buscarTendasPorNomeComecandoCom(String nome);

    @Query("{ 'disponivel': true }")
    long countTendasDisponiveis();

    @Query("{ 'disponivel': true, 'precoDiaria': { $lt: ?0 }, 'tamanho': ?1 }")
    List<Tenda> buscarTendasDisponiveisComPrecoAbaixoETamanhoEspecifico(double precoMaximo, String tamanho);
   
    List<Tenda> findAllByOrderByPrecoDiariaAsc();

    List<Tenda> findAllByOrderByPrecoDiariaDesc();
}
