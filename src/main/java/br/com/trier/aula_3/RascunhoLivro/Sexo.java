package br.com.trier.aula_3.RascunhoLivro;

import javax.swing.JOptionPane;



public enum Sexo {

   MASCULINO (1, "MASCULINO"),FEMININO(2, "FEMININO");
   
    
    private int codigo;
    private String descricao;
    
    private Sexo(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    static Sexo buscaPorCodigo(int codigo) {
        for(Sexo sexo: Sexo.values()) {
            if(codigo == sexo.codigo) {
                return sexo;
            }
        }
        return null;
    }
    
    static Sexo escolheSexo() {
        String menu = "Escolhas uma cor:\n";
        for (Sexo sexo : Sexo.values()) {
            menu += sexo.codigo + " - " + sexo.descricao + "\n";
        }
        int escolha = Integer.parseInt(JOptionPane.showInputDialog(menu));
        return buscaPorCodigo(escolha);
    }}


 



//1 - Cadastrar Autor 
//2 – Cadastrar Livros (escolher entre os autores cadastrados)
//3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)
//4 - Pesquisar por autor (listar todos os livros de um autor) 
//5 - Pesquisar por faixa de valor do livro (mínimo e máximo) 
//6 - Listar todos os livros cujo autores tenham crianças (idade <=12) 
//7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta).
//
//REGRAS: 
//1 – O título do livro, deve ser exibido sempre em minúsculo (mesmo que o usuário faça o cadastro maiúsculo). 
//2 – Não permitir cadastro de valores menores ou iguais a ZERO.
//3 - Ao cadastrar o autor, permitir apenas cadastro com nome e sobrenome (duas palavras). 
//4 - Ao exibir o valor, mostrar o símbolo da moeda na frente (R$) 
//5 - A idade do autor não pode ser negativa 
//6 - O sexo obrigatoriamente deve ser Masculino ou Feminino.
