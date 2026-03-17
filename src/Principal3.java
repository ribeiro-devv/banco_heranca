import com.mrsoft.banco.ContaEspecial;
import com.mrsoft.banco.Titular;

public class Principal3 {

    public static void main(String[] args) {
        Titular titular = new Titular("João Silva", "12345678900");
        ContaEspecial conta1 = new ContaEspecial(titular, 1234, 56789, 25);

        conta1.setLimiteChequeEspecial(100);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100.00);

        conta1.imprimirDemonstrativo();

        conta1.sacar(150.00);
        conta1.imprimirDemonstrativo();

        conta1.debitarTarifaMensal();
        conta1.imprimirDemonstrativo();
    }
}
