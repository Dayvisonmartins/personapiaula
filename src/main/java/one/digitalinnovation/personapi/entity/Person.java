package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.List;

@Entity // indicando que é uma entidade
@Data //adiciona automatico getter e setter
@Builder // padrão de projetos para construção de objetos
@AllArgsConstructor // inserir construtores
@NoArgsConstructor // inserir construtores
public class Person {

    @Id // chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //obrigatório
    private String firstName;

    @Column(nullable = false) //obrigatório
    private String lastName;

    @Column(nullable = false, unique = true) //obrigatório // unique = true só pode adicionar com CPFs unicos
    private String cpf;

    private LocalDate birthDate;

    // OneToMany relacionamento Um-para-Muitos unidirecional informa que o registro de uma entidade está relacionado com vários registros de outra entidade

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
