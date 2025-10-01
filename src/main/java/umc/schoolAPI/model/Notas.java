package umc.schoolAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double nota1;
    private Double nota2;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;
}
