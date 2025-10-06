package umc.schoolAPI.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;
private String sobrenome;
private LocalDate dataNascimento;
private String matricula;
private String cpf;
private String email;
private String telefone;
private String endereco;
private String turma;

@OneToMany(mappedBy = "aluno", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JsonManagedReference
private List<Notas> notas;
}
