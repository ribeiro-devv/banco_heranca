import com.mrsoft.banco.Conta;
import com.mrsoft.banco.Titular;

public class Principal3 {

    public static void main(String[] args) {
        Conta conta1 = new Conta();

        conta1.setTitular(new Titular("João Silva", "12345678900"));
        conta1.setAgencia(1234);
        conta1.setNumero(56789);
        conta1.setTipo(Conta.ESPECIAL);
        conta1.setLimiteChequeEspecial(100);
        conta1.setTarifaMensal(25);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100.00);

        conta1.imprimirDemonstrativo();

        conta1.sacar(150.00);
        conta1.imprimirDemonstrativo();

        conta1.debitarTarifaMensal();
        conta1.imprimirDemonstrativo();
    }
}
