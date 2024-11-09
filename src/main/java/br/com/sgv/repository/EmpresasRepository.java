package br.com.sgv.repository;


import br.com.sgv.model.Empresas;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Marcelo
 */
public interface EmpresasRepository extends CrudRepository<Empresas,Long> {
    
}
