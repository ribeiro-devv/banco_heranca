import com.mrsoft.banco.ContaEspecial;
import com.mrsoft.banco.Titular;

public class Principal3 {

    public static void main(String[] args) {
        ContaEspecial conta1 = new ContaEspecial();

        conta1.setTitular(new Titular("João Silva", "12345678900"));
        conta1.setAgencia(1234);
        conta1.setNumero(56789);
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
