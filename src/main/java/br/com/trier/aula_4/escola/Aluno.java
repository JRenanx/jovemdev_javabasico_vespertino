package br.com.trier.aula_4.escola;

import java.util.List;
import java.util.stream.Collectors;

import br.com.trier.aula_5.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
public class Aluno {

    @NonNull
    private String nome;
    private List<Boletim> boletin;
    
   
   
    public void cadastraNotas(Disciplina disciplina, List<Double> nota) {
        boletin.add(new Boletim());
    }

    public List<Double> pegarNotasDaDisciplina(Disciplina disciplina) {
        Boletim b = boletin.stream().filter(s -> s.getDisciplina().equals(disciplina)).findAny().orElse(null);
        if (b != null)
            return b.getNotas();
        else
            return null;
    }

    public String pegarMediaDaDisciplina() {

        String res = boletin.stream().map(ba -> ba.getDisciplina().getNome() + " - " + ba.media())
                .collect(Collectors.joining("\n"));

        return res;
    }


}
