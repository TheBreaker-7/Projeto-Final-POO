
package br.edu.ifrn.model;

import java.io.*;
import java.util.*;

public class Usuario {
    private String nome;
    private String matricula;
    private String senha;
    private String typeUser;
    List <Usuario> user = new ArrayList <> ();

   
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    
    public void cadastrarUser(Usuario usr) throws IOException {
        user.add(usr);
        
	escrever(user);
    }
    
    private static void escrever(List user) throws IOException {
        
	File arq = new File("Usuarios.txt");

        try{
            //Criando o arquivo fisicamente (createNewFile)
            arq.createNewFile();
                        
            //Passando no construtor do FileWriter qual arquivo irá ser manipulado
            //O parâmetro true indica que reescrevemos no arquivo sem sobrescrever.
            //O false apagaria o conteúdo do arquivo e escreveria o novo conteúdo.
            //Por padrão ele é false (caso não tenha segundo parâmetro).
            FileWriter fileWriter = new FileWriter(arq, true);
                        
            //A classe PrintWriter serve para escrever fisicamente no arquivo.
            //Precisa passar o objeto fileWriter no seu construtor.
            PrintWriter printWriter = new PrintWriter(fileWriter);
                        
            //Utilizamos o método print() para escrever na
            // mesma linha e uma vírgula no final.
            //O println forçará a troca de linha para o prox aluno.
            for (int i = 0; i < user.size(); i++){
                Usuario us = (Usuario) user.get(i);
		printWriter.print(us.getNome() + ",");
		printWriter.print(us.getMatricula()+ ",");
                printWriter.print(us.getSenha()+ ",");
                printWriter.print(us.getTypeUser());
		printWriter.println("");
            }
                        
            //O método flush libera a escrita no arquivo.
            printWriter.flush();
                        
            //O método close fecha o arquivo (obrigatório);
            printWriter.close();
                        
	} catch (IOException e){
            e.printStackTrace();
            }
                
    }
    public static String ler (String caminho) throws FileNotFoundException, IOException {
        
        String texto = "";
        String str = "";
        File arq2 = new File(caminho);
        BufferedReader lr = new BufferedReader(new FileReader(arq2));
        
        while ( (str = lr.readLine())!=null ){
            texto += str + "\n";
        }
        lr.close();
        return texto;
    }
    
}
