
public class NPC {
  private String nome;
  private String falas;
  private String falaChave;
  private Item itemChave;

  public NPC(String nome, String falas, String falaChave, Item itemChave){
    this.nome = nome;
    this.falas = falas;
    this.falaChave = falaChave;
    this.itemChave = itemChave;
  }

  public String getNome() {
    return nome;
  }

  public String getFalasChave()  {
    return falaChave;
  }

  public Item getItemChave() {
    return itemChave;
  }

  public String getFalas() {
    return falas;
  }

  public void printFalas() {
    System.out.println(falas);
  }

  public void printFalaChave() {
    System.out.println(falaChave);
  }

  

}