import java.util.Scanner;

public class Principal {
    static void main() {

        exibeMenu menu = new exibeMenu();
        Scanner leitura = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 7) {
            menu.exibirMenu();
            opcao = leitura.nextInt();
            if (opcao == 7) break;

            String moedaAlvo = "";
            String moedaBase = "";

                switch (opcao) {
                    case 1 -> { moedaBase = "USD"; moedaAlvo = "ARS"; }
                    case 2 -> { moedaBase = "ARS"; moedaAlvo = "USD"; }
                    case 3 -> { moedaBase = "USD"; moedaAlvo = "BRL"; }
                    case 4 -> { moedaBase = "BRL"; moedaAlvo = "USD"; }
                    case 5 -> { moedaBase = "USD"; moedaAlvo = "COP"; }
                    case 6 -> { moedaBase = "COP"; moedaAlvo = "USD"; }
                    default -> System.out.println("Opção inválida!");
            }
            if (!moedaBase.isEmpty()) {
                menu.exibirMensagemValor();
                double valor = leitura.nextDouble();

                double taxa = ConverteMoeda.Conversor(moedaBase, moedaAlvo);
                double resultado = valor * taxa;

                System.out.printf("Valor %.2f [%s] corresponde ao valor final de >>> %.2f [%s]%n",
                        valor, moedaBase, resultado, moedaAlvo);
            }
        }
    }
}
