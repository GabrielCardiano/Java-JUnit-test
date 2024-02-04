package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Teste da classe Conta")
class ContaTest {

  @Test
  @DisplayName("5 - Testa o construtor da classe conta.")
  void construtorTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    assertDoesNotThrow(() -> {
      PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
      new Conta("Corrente", cliente, new Banco());
    });
  }

  @Test
  @DisplayName("6 - Testa o método adicionar transação e retornar saldo da conta.")
  void adicionarTransacaoTestRetornarSaldoTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Corrente", cliente, new Banco());
    conta.adicionarTransacao(500.0, "Transação Teste");

    assertEquals(500.0, conta.retornarSaldo());
  }

  @Test
  @DisplayName("7 - Testa o método retornar resumo está retornando uma string com os valores corretamente.")
  void retornarResumoContaTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Corrente", cliente, new Banco());
    conta.adicionarTransacao(500.0, "Transação Teste");
  }

  @Test
  @DisplayName("8 - Testa o método retornar extrato está imprimindo os valores corretamente.")
  void retornarExtratoTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Corrente", cliente, new Banco());
    conta.adicionarTransacao(500.0, "Transação Teste");

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);

    conta.retornarExtrato();

    String output = outputStream.toString();
    String expectedDate =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

    assertTrue(output.contains(expectedDate));

    System.setOut(System.out);
  }

  @Test
  @DisplayName("9 - Testa o método Getter do atributo idConta está retornando.")
  void getIdContaTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Corrente", cliente, new Banco());
    assertEquals(10, conta.getIdConta().length());

  }

  @Test
  @DisplayName("10 - Testa o método método Getter do atributo pessoaCliente está retornando.")
  void getPessoaClienteTest() {
    String nome = "Zico";
    String cpf = "123.456.789-00";
    String senha = "zico123";

    PessoaCliente cliente = new PessoaCliente(nome, cpf, senha);
    Conta conta = new Conta("Corrente", cliente, new Banco());
    assertEquals(10, conta.getIdConta().length());
  }

}
