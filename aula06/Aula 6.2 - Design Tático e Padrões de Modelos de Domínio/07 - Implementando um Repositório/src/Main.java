import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ContaBancariaRepositorio repositorio = new ContaBancariaRepositorioArquivo("contas-bancarias.dat");
        repositorio.salvar(new ContaBancaria("001", "Ana", new BigDecimal("480.00")));
        repositorio.salvar(new ContaBancaria("002", "Caio", new BigDecimal("-75.50")));

        for (ContaBancaria conta : repositorio.buscarComSaldoNegativo()) {
            System.out.println(conta.numero + " - " + conta.titular + " - R$ " + conta.saldo);
        }
    }

    static class ContaBancaria implements Serializable {
        private static final long serialVersionUID = 1L;
        final String numero;
        final String titular;
        final BigDecimal saldo;

        ContaBancaria(String numero, String titular, BigDecimal saldo) {
            if (numero == null || numero.trim().isEmpty() || titular == null || titular.trim().isEmpty() || saldo == null) {
                throw new IllegalArgumentException("Dados da conta inválidos.");
            }
            this.numero = numero;
            this.titular = titular;
            this.saldo = saldo;
        }
    }

    interface ContaBancariaRepositorio {
        void salvar(ContaBancaria conta);
        List<ContaBancaria> buscarComSaldoNegativo();
    }

    static class ContaBancariaRepositorioArquivo implements ContaBancariaRepositorio {
        private final String arquivo;

        ContaBancariaRepositorioArquivo(String arquivo) {
            this.arquivo = arquivo;
        }

        public void salvar(ContaBancaria conta) {
            List<ContaBancaria> contas = carregar();
            for (int i = 0; i < contas.size(); i++) {
                if (contas.get(i).numero.equals(conta.numero)) {
                    contas.set(i, conta);
                    gravar(contas);
                    return;
                }
            }
            contas.add(conta);
            gravar(contas);
        }

        public List<ContaBancaria> buscarComSaldoNegativo() {
            List<ContaBancaria> resultado = new ArrayList<ContaBancaria>();
            for (ContaBancaria conta : carregar()) {
                if (conta.saldo.signum() < 0) resultado.add(conta);
            }
            return resultado;
        }

        @SuppressWarnings("unchecked")
        private List<ContaBancaria> carregar() {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo))) {
                return (List<ContaBancaria>) entrada.readObject();
            } catch (Exception e) {
                return new ArrayList<ContaBancaria>();
            }
        }

        private void gravar(List<ContaBancaria> contas) {
            try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arquivo))) {
                saida.writeObject(contas);
            } catch (Exception e) {
                throw new IllegalStateException("Não foi possível salvar as contas.", e);
            }
        }
    }
}
