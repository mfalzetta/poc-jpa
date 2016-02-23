package br.com.matta;

import br.com.matta.model.Test;
import br.com.matta.repository.JpaUtil;
import br.com.matta.repository.TestRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class MainApp {

    public static void main(String[] args) {
        TestRepository repository = null;
        try {
            repository = new TestRepository();
            repository.save(new Test("Teste", "Teste"));


        }catch (Exception e){
            System.out.println("Erro = [" + e.getMessage() + "]");
        }finally {
            System.out.println("Encerrando o repositorio.");
            if(repository != null) {
                repository.close();
                System.out.println("Repositorio encerrado.");
            }
        }
    }
}
