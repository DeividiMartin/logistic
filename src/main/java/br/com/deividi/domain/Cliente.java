package br.com.deividi.domain;

import br.com.deividi.domain.exception.RegraNegocioException;
import jakarta.persistence.*;

@Entity
@Table(name = "clientes", uniqueConstraints = @UniqueConstraint(name = "uk_cliente_cpf", columnNames = "cpf"))
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(nullable = false, length = 11)
    private String cpf;

    protected Cliente() {
        // obrigatório para JPA
    }

    public Cliente(String nome, String cpf) {
            if (nome == null || nome.isBlank()) {
                throw new RegraNegocioException("Nome do cliente é obrigatório");
            }
            this.nome = nome;
            this.cpf = cpf;
            this.cpf = normalizarCpf(cpf);
        }

        private String normalizarCpf(String cpf) {
            if (cpf == null || cpf.isBlank()) {
                throw new RegraNegocioException("CPF é obrigatório");
            }
            String cpfNumeros = cpf.replaceAll("\\D", "");
            if (cpfNumeros.length() != 11) {
                throw new RegraNegocioException("CPF deve ter 11 dígitos");
            }
            return cpfNumeros;
        }

        public Long getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
                return cpf;
        }
}