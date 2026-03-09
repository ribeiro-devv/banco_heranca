import com.mrsoft.banco.Conta;
import com.mrsoft.banco.Titular;

public class Principal2 {

    public static void main(String[] args) {
        Conta conta1 = new Conta();

        conta1.setTitular(new Titular("João Silva", "12345678900"));
        conta1.setAgencia(1234);
        conta1.setNumero(56789);
        conta1.setTipo(Conta.INVESTIMENTO);

        conta1.imprimirDemonstrativo();

        conta1.depositar(100.00);

        conta1.imprimirDemonstrativo();

        conta1.creditarRendimento(5);
        conta1.imprimirDemonstrativo();
    }
}
