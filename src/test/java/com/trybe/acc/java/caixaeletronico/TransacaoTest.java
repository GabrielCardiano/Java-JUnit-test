package com.trybe.acc.java.caixaeletronico;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testes dos métodos da classe Transação")
class TransacaoTest {


  @Test
  @DisplayName("1 - Testa o método construtor da classe Transação.")
  void construtorTest() {
    Transacao transacao = new Transacao(2000, "Depósito recebido");
    assertEquals(2000, transacao.getQuantia());
  }


  @Test
  @DisplayName("2 - Testa o método Getter do atributo quantia.")
  void getQuantiaTest() {
    Transacao transacao = new Transacao(2000, "Depósito recebido");
    assertEquals(2000, transacao.getQuantia());
  }

  @Test
  @DisplayName("3 - Testa o método retornar resumo transação.")
  void retornarResumoTransacaoTest() {
    Transacao transacao = new Transacao(2000, "Depósito recebido");
    assertNotEquals(null, transacao.retornarResumoTransacao());
  }

  @Test
  @DisplayName("4 - Testa o método instante está gerando o instante corretamente.")
  void retornarInstanteTest() {
    Transacao transacao = new Transacao(2000, "Depósito recebido");

    String formatoInstante = "dd/MM/yyyy HH:mm:ss";
    DateTimeFormatter formatadorInstante = DateTimeFormatter.ofPattern(formatoInstante);
    LocalDateTime instanteAux = LocalDateTime.now();

    assertTrue(
        transacao.retornarResumoTransacao().contains(formatadorInstante.format(instanteAux)));
  }

}
