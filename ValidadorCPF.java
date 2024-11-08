import java.util.Scanner;

public class ValidadorCPF {

    // Função para validar o CPF
    public static boolean validarCPF(String cpf) {
        // Remover caracteres não numéricos (como . e -)
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF tem 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se o CPF é uma sequência repetida de números
        if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") ||
            cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") ||
            cpf.equals("99999999999")) {
            return false;
        }

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
        }
        int resto = soma % 11;
        int digito1 = (resto < 2) ? 0 : 11 - resto;

        // Calcular o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
        }
        resto = soma % 11;
        int digito2 = (resto < 2) ? 0 : 11 - resto;

        // Verificar se os dígitos verificadores calculados são iguais aos fornecidos
        if (Integer.parseInt(String.valueOf(cpf.charAt(9))) == digito1 &&
            Integer.parseInt(String.valueOf(cpf.charAt(10))) == digito2) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Leitura do CPF
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o CPF para validação (com ou sem pontos e traços): ");
        String cpf = scanner.nextLine();

        // Verificação de validade do CPF
        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
        }

        scanner.close();
    }
}
