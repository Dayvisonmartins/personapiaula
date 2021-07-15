package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.enums.PhoneType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // indicando que é uma entidade
@Data //adiciona automatico getter e setter
@Builder // padrão de projetos para construção de objetos
@AllArgsConstructor // inserir construtores
@NoArgsConstructor // inserir construtores
public class Phone {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // toda vez que adicionar um dado vai ser  automaticamente incremental
    private Long id;

    @Enumerated(EnumType.STRING) //inserir o dado phone como difido pelo enum na classe PhoneType
    @Column(nullable = false) //@Collumcriar uma regra construct de bando de dados
    // nullable = false criar como obrigatório
    private PhoneType type;

    @Column(nullable = false)
    private String number;


}
