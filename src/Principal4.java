import com.mrsoft.banco.Conta;
import com.mrsoft.banco.ContaEspecial;
import com.mrsoft.banco.Titular;

public class Principal4 {

    public static void main(String[] args) {
        Titular titular = new Titular("João Silva", "12345678900");
        Conta conta1 = new Conta(titular, 1234, 99999);

        System.out.println(conta1);
    }
}
