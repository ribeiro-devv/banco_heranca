import com.mrsoft.banco.Conta;
import com.mrsoft.banco.Titular;

public class Principal1 {

    public static void main(String[] args) {
        Titular titular = new Titular("João Silva", "12345678900");
        Conta conta1 = new Conta(titular, 1234, 56789);

//        conta1.setLimiteCredito(100.00);

        conta1.imprimirDemonstrativo();

        conta1.depositar(1000.00);

        conta1.imprimirDemonstrativo();
        conta1.sacar(200.00);
        conta1.imprimirDemonstrativo();

//        conta1.creditarRendimento(5);
    }
}
