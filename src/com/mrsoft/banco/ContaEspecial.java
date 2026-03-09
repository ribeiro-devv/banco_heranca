package com.mrsoft.banco;

public class ContaEspecial {
    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;

    private double valorTotalRendimentos;
    private double tarifaMensal;
    private double limiteChequeEspecial;

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

    public double getSaldoDisponivel() {
        return getSaldo() + getLimiteChequeEspecial();
    }

    public double getValorTotalRendimentos() {
        return valorTotalRendimentos;
    }

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
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
        if (getSaldoDisponivel() < valorSaque) {
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
        System.out.printf("Saldo Disponível: R$ %.2f%n", getSaldoDisponivel());
    }

    public void debitarTarifaMensal() {
        sacar(getTarifaMensal());
    }
}

