
package br.edu.ifrn.model;

import java.io.*;
import java.util.*;

public class Contato {
    private String nome;
    private String endereco;
    private String nascimento;
    private String telFixo;
    private String celular;
    private String turma;
    List <Contato> contatos = new ArrayList <> ();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getTelFixo() {
        return telFixo;
    }

    public void setTelFixo(String telFixo) {
        this.telFixo = telFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
    
    public void addContato(Contato cont) throws IOException {
        contatos.add(cont);
        
	escrever(contatos);
    }
    
    private static void escrever(List contatos) throws IOException {
        
	File arquivo = new File("Contatos.txt");

        try{
            //Criando o arquivo fisicamente (createNewFile)
            arquivo.createNewFile();
            
            FileWriter fileWriter = new FileWriter(arquivo, true);
                        
            //A classe PrintWriter serve para escrever fisicamente no arquivo.
            //Precisa passar o objeto fileWriter no seu construtor.
            PrintWriter printWriter = new PrintWriter(fileWriter);
                        
            
            for (int i = 0; i < contatos.size(); i++){
                Contato a = (Contato) contatos.get(i);
		printWriter.print(a.getNome() + ",");
		printWriter.print(a.getEndereco()+ ",");
		printWriter.print(a.getNascimento()+ ",");
                printWriter.print(a.getTelFixo()+ ",");
                printWriter.print(a.getCelular()+ ",");
                printWriter.print(a.getTurma());
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
