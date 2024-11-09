package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 12/05/2021
 * @brief  class Pessoa
 */
@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED) // Define a herança JOINED, onde Pessoa vai ser uma tabela e as classes filhas terão suas próprias tabelas.
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Size(min = 1, message = "O nome precisa ser válido.")
    private String nome;
    
    @Size(min=1,message = "O Celular precisa ser válido.")
    private String cel;

    @Override
    public String toString() {
        return nome + cel;
    }
}
