import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonagemTest {
  @Test
  public void testChecaItem() {
    Personagem jogador;
    Item faca;
    faca = new Item("faca", "faca");
    jogador = new Personagem();
    jogador.addItem(faca);

    assertEquals(true, jogador.checaItem(faca));

  }

  @Test
  public void testProcuraItem() {
    Personagem jogador;
    Item faca;
    faca = new Item("faca", "faca");
    jogador = new Personagem();
    jogador.addItem(faca);

    assertEquals(faca, jogador.procuraItem("faca"));
  }
}
