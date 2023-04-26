import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {

    private String nome;
    private String matricula;
    private Integer idade;
    List<Aluno> listaAlunos = new ArrayList<>();


    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }


    public static void operações(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Aluno:" +
                            "\n"+
                            "1 - Cadastrar Aluno"+
                            "2 - Listar Alunos");

        System.out.println("Digite uma Opção:");
        int opcao = sc.nextInt();


        if(opcao  == 1){
            cadastrar();
            operações();
        } else if (opcao == 2) {
        } else {
            System.out.println("Digite uma opção válida");
        }
    }

    public static void cadastrar(){
        Scanner sc = new Scanner(System.in);
        Aluno newAluno = new Aluno();
    }
}
