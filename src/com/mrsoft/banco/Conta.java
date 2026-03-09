package com.mrsoft.banco;

public class Conta {

    public static final int NORMAL = 0;
    public static final int INVESTIMENTO = 1;
    public static final int ESPECIAL = 2;

    private Titular titular;
    private int agencia;
    private int numero;
    private double saldo;
    private int tipo = NORMAL;

//    conta investimento
    private double valorTotalRendimentos;

//    conta especial
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        if (tipo != NORMAL && tipo != INVESTIMENTO && tipo != ESPECIAL) {
            throw new IllegalArgumentException("Tipo de conta inválido:"+ tipo + ". Use 0 para Normal, 1 para Investimento ou 2 para Especial.");

        }
        this.tipo = tipo;

        if (tipo != ESPECIAL) {
            this.limiteChequeEspecial = 0;
        }
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
        if (getTipo() != ESPECIAL) {
            throw new RuntimeException("Limite de crédito só é permitido para contas do tipo Especial.");
        }
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public void creditarRendimento(double percentualJuros) {
        if (getTipo() == INVESTIMENTO || getTipo() == ESPECIAL) {
            double valorRendimentos = getSaldo() * percentualJuros / 100;

            this.valorTotalRendimentos += valorRendimentos;
            depositar(valorRendimentos);
        } else {
            throw new RuntimeException("Crédito de rendimento só é permitido para contas do tipo Investimento ou Especial.");
        }
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
        if (getTipo() == ESPECIAL) {
            sacar(getTarifaMensal());
        } else {
            throw new RuntimeException("Debitar tarifa mensal só é permitido para contas do tipo Especial.");
        }
    }
}
