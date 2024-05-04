package com.mycompany.gerenciabanco;
import java.util.Scanner;
import java.util.Arrays;
/**
 *
 * @author Wesley Pacca
 */
public class GerenciaBanco {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nome, sobrenome, cpf; 
        int loop=0;
        int loop2 = 0;
        
        System.out.print("Bem vindo!\nDigite seu nome:");
        nome = scan.next();
        System.out.print("Digite seu sobrenome:");
        sobrenome = scan.next();
        System.out.print("Digite seu cpf:");
        cpf = scan.next();
                
        Conta conta = new Conta(nome, sobrenome, cpf);
        do{
            System.out.printf("\nUsuário: %s\n",conta.getUser());
            int option = menu();
            switch(option){
                case 1:
                    System.out.printf("\nSaldo atual R$%.2f\n",conta.getSaldo());
                    break;
                case 2:
                    loop2 = 0;
                    do{
                        scan = new Scanner(System.in);
                        System.out.printf("Digite o valor R$ ");
                        try{
                            float valor = scan.nextFloat();
                            conta.deposita(valor);
                            System.out.print("\nDepositado com sucesso.\n");
                            loop2 = 1;
                        }catch(Exception e){
                            System.out.print("\nDigite um valor válido\n");
                        }
                    }while(loop2 == 0);
                    break;
                case 3:
                    loop2 = 0;
                    do{
                        scan = new Scanner(System.in);
                        System.out.printf("Digite o valor R$ ");
                        try{
                            float valor = scan.nextFloat();
                            conta.saque(valor);
                            System.out.print("\nFeito saque com sucesso.\n");
                            loop2 = 1;
                        }catch(Exception e){
                            System.out.print("\nDigite um valor válido\n");
                        }
                    }while(loop2 == 0);
                    break;
                case 4:
                    loop = 1;
                    System.out.printf("Até logo!");
                    break;
            }
        }while(loop == 0);
    }
    
    public static int menu(){
        Scanner scan;
        int loop=0, escolha=0;
        Integer[] options={1,2,3,4};
        boolean check;
        
        System.out.println("\nMenu\n");
        System.out.println("1 - consultar saldo\n2 - realizar depositos\n3 - realizar saques\n4 - Sair\n");
        do{
            System.out.print("Digite sua escolha: ");
            scan = new Scanner(System.in);
            try{
                escolha = scan.nextInt();
                check = Arrays.asList(options).contains(escolha);
                if(!check){
                    System.out.println("Digite um numero valido.");
                }else{
                    loop = 1;
                }                        
            }catch(Exception e){
                System.out.println("Digite um numero valido.");
            }
            
        }while(loop == 0);
        
        return escolha;
        
    }
}

class Conta{
    private String nome = "", sobrenome = "", cpf = "";
    private float saldo = 0;
    
    private void set_saldo(float saldo){
        this.saldo = saldo;
    }
    
    public Conta(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
    
    public String getUser(){
        return this.nome + " " + this.sobrenome;
    }
    
    public float getSaldo(){
        return this.saldo;
    }
    
    public void deposita(float valor){
        this.saldo += valor;
    }
    
    public void saque(float valor){
        this.saldo -= valor;
    }
}