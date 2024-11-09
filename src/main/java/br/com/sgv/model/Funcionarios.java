/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sgv.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Pablo Rangel <pablo.rangel@gmail.com>
 * @date 12/05/2021
 * 
 * 
 * 
 * 
 * @brief  class PessoaFisica
 * Pessoa fisica foi alterada para funcionario.
 */
@Entity
@Getter
@Setter
public class Funcionarios extends Pessoa{
    @Size(min=1,message = "O CPF precisa ser válido.")
    private String cpf;
    @Size(min=1,message = "A rua precisa ser válida.")
    private String rua;
    private int numero;
    @Size(min=1,message = "O bairro precisa ser válido.")
    private String bairro;
}