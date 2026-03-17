import com.mrsoft.banco.ContaInvestimento;
import com.mrsoft.banco.Titular;

public class Principal2 {

    public static void main(String[] args) {
        Titular titular = new Titular("João Silva", "12345678900");
        ContaInvestimento conta1 = new ContaInvestimento(titular, 1234, 56789);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100.00);

        conta1.imprimirDemonstrativo();

        conta1.creditarRendimento(5);
        conta1.imprimirDemonstrativo();
    }
}
