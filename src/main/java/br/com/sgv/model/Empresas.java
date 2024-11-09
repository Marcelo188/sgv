package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 12/05/2021
 * @brief  class Empresas
 */
@Entity
@Table(name = "empresas") // Garantir que o nome da tabela seja 'empresas'
@Getter
@Setter
public class Empresas extends Entidade {

    @Size(min = 1, message = "O CNPJ precisa ser válido.")
    private String cnpj;

    @Size(min = 1, message = "A Razão Social precisa ser válida.")
    private String rsocial;

    @Size(min = 1, message = "O Nome Fantasia precisa ser válido.")
    private String nfantasia;
    
    @Size(min=1,message = "O Telefone precisa ser válido.")
    private String tel;
}
