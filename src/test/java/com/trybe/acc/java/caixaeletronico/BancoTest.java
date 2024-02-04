package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes para a classe Banco")
class BancoTest {

  @Test
  @DisplayName("20 - Testa o gerador de número único para nova conta.")
  void gerarNumeroNovaContaTest() {
    Banco banco = new Banco();
    String accNumber = banco.gerarNumeroNovaConta();

    assertNotNull(accNumber);
    assertEquals(10, accNumber.length());
  }

  @Test
  @DisplayName("21 - Testa o método adicionar pessoa cliente retorna o objeto pessoa cliente.")
  void adicionarPessoaClienteTest() {
    Banco banco = new Banco();
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    assertEquals(cpf, cliente.getCpf());
    assertTrue(cliente.validarSenha(senha));

    boolean cadastradoComSucesso = banco.getPessoasClientes().stream()
        .anyMatch(c -> cpf.equals(c.getCpf()) && c.validarSenha(senha));

    assertTrue(cadastradoComSucesso);
  }

  @Test
  @DisplayName("22 - Testa o método login da pessoa cliente retorna o objeto pessoa cliente corretamente.")
  void pessoaClienteLoginTest() {
    Banco banco = new Banco();
    String nome = "personName";
    String cpf = "123.456.789-00";
    String senha = "password";

    PessoaCliente pessoaCliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    assertEquals(cpf, pessoaCliente.getCpf());
    assertTrue(pessoaCliente.validarSenha(senha));

    boolean cadastradoComSucesso = banco.getPessoasClientes().stream()
        .anyMatch(c -> cpf.equals(c.getCpf()) && c.validarSenha(senha));

    assertTrue(cadastradoComSucesso);
  }

  @Test
  @DisplayName("23 - Testa se o método transferir fundos está transferindo corretamente.")
  void depositarTestTransferirFundosTestmostrarExtratoTest() {
    Banco banco = new Banco();

    // Cadastra clientes.
    String nome = "John Doe";
    String senha = "password";
    String cpf = "123.456.789-00";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    // Adiciona contas.
    banco.adicionarConta("Corrente", cliente);
    banco.adicionarConta("Poupança", cliente);

    // Deposita 1000.
    int paraConta = 0;
    double quantia = 1000.0;
    banco.depositar(cliente, paraConta, quantia);
    assertEquals(1000, cliente.retornarSaldoContaEspecifica(0));

    // Transfere fundos da conta 0 para a 1.
    banco.transferirFundos(cliente, 0, 1, 500.0);
    assertEquals(500, cliente.retornarSaldoContaEspecifica(0));
    assertEquals(500, cliente.retornarSaldoContaEspecifica(1));
  }

  @Test
  @DisplayName("24 - Testa se o método sacar está funcionando corretamente.")
  void depositarTestSacarTestMostrarExtratoTest() {
    Banco banco = new Banco();

    // Cadastra clientes.
    String nome = "John Doe";
    String senha = "password";
    String cpf = "123.456.789-00";
    PessoaCliente cliente = banco.adicionarPessoaCliente(nome, cpf, senha);

    // Adiciona contas.
    banco.adicionarConta("Corrente", cliente);
    banco.adicionarConta("Poupança", cliente);

    // Deposita 1000.
    int paraConta = 0;
    double quantia = 1000.0;
    banco.depositar(cliente, paraConta, quantia);
    assertEquals(1000, cliente.retornarSaldoContaEspecifica(0));

    // Transfere fundos da conta 0 para a 1.
    banco.transferirFundos(cliente, 0, 1, 500.0);
    assertEquals(500, cliente.retornarSaldoContaEspecifica(0));
    assertEquals(500, cliente.retornarSaldoContaEspecifica(1));
  }
}
