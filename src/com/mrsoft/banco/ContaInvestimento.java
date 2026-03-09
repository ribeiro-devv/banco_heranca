package com.mrsoft.banco;

public class ContaInvestimento {
    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;

    private double valorTotalRendimentos;


    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getValorTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public void creditarRendimento(double percentualJuros) {
        double valorRendimentos = getSaldo() * percentualJuros / 100;

        this.valorTotalRendimentos += valorRendimentos;
        depositar(valorRendimentos);
    }

    public void sacar(double valorSaque) {
        if (valorSaque <= 0) {
            throw new IllegalArgumentException("Valor de saque deve ser maior que 0.");
        }
        if (getSaldo() < valorSaque) {
            throw new IllegalArgumentException("Saldo insuficiente para o saque.");
        }

        saldo -= valorSaque;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            throw new IllegalArgumentException("Valor de depósito deve ser positivo.");
        }

        saldo += valorDeposito;
    }

    public void imprimirDemonstrativo() {
        System.out.println("=== Extrato da Conta ===");
        System.out.println("Titular: " + getTitular().getNome());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Número: " + getNumero());
        System.out.printf("Saldo: R$ %.2f%n", getSaldo());
    }
}