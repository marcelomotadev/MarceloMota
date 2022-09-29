/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Personagem personagem;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        personagem = new Personagem();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room hallPrincipal, escritorio, jardim, piscina, banheiro, cozinha;
        
        NPC Adriel, Ferdinando, Marta, James, Leonard;

        Item Carcaca, Faca, Relogio, Luvas, Taca, Tesoura, Veneno, Pano, Celular;
      
        // create the rooms

        hallPrincipal = new Room("no hall principal");
        escritorio = new Room("num escritorio");
        jardim = new Room("no jardim da mansao");
        piscina = new Room("na piscina");
        banheiro = new Room("no banheiro");
        cozinha = new Room("na cozinha");
        
        // create Itens

        Carcaca = new Item("Carcaca", "Restos de um pato inteiro assado, so sobraram os ossos e pedacos pequenos de cartilagem e carne. Devia estar delicioso.");

        Faca = new Item("Faca", "Uma faca de cozinha afiada e brilhante, parece ser muito bem cuidada, mas ha uma irregularidade em sua ponta. ");

        Relogio = new Item("Relogio", "Um relogio de bolso antiquado mas bem bonito. Talvez pertenca a algum dos convidados da festa ou ate mesmo ao dono da mansao. Olhando bem nao eh bem um relogio parece mais um cronometro antigo, 5 minutos e 29 segundos que estranho...");

        Luvas = new Item("Luvas", "Um par de luvas elegantes, provavelmente feitas para serem usadas por um mordomo. Nao eh um lugar comum para encontrar algo assim.");

        Taca = new Item("Taca", "Uma taca cheia de vinho, parecia que alguem estava bebendo nela");

        Tesoura = new Item("Tesoura", "Uma tesoura simples de jardinaria, usada para podar arvores e arbustos, sempre esta com o proprio");

        Veneno = new Item("Veneno", "Um frasco de veneno com tamanho razoavel, que pode ser encontrado na cabana do jardim (ou qualquer outro lugar do tipo). Aparenta estar vazio, e a borda ainda esta umida.");
        
        Pano = new Item("Pano", "Um pano simples, rasgado ao meio. Onde estara a outra metade?");

        Celular = new Item("Celular", "Um celular que aparenta ser de ultima geracao, porem descarregado");
        
        // create NPC's

        Adriel = new NPC("Adriel",  " Meu nome eh Adriel, venho servindo ao dono desta mansao faz 30 anos. Portanto, a ultima pessoa que voce deveria suspeitar seria de mim! \n Eu estava servindo os convidados a noite inteira! Meu patrao, como sempre, sobrecarregou a minha funcao, nao tive tempo nem de respirar, imagine de mata-lo! Sei muito bem que ele nao me tratava da melhor maneira, mas jamais faria uma atrocidade dessas. " , "M - minhas luvas? Onde elas estavam? Nao as vejo desde o inicio da festa, sera que alguem as tomou de mim?", Luvas);
        
        Ferdinando = new NPC("Ferdinando", "Opa, precisa do que? Deveria estar investigando a morte do chefe, nao? Eu estava a noite toda na cozinha, fui proibido de ir para o hall durante o evento. Sim, eu vi o cozinheiro indo para a floresta, ate ajudei ele a pegar o mel, ele sempre eh gente fina comigo. ", "Ah, pera, alguem usou meu pote de veneno? Quando foi isso? Nao acredito que alguem mexeu nas minhas coisas.", Veneno);

        Marta = new NPC("Marta", " Ola, nao imaginei que viesse parar aqui. Eu sou a Marta, a faxineira da mansao. Esta piscina nao eh utilizada ha anos, entretanto sempre fui ordenada a deixar ela impecavel, acho que nessa familia eh mais sobre aparencia do que utilidade, nao eh mesmo?. Estava no hall quando os convidados chegaram, estava calor entao vim para ca. A noite esta bastante agradavel, nao? Eh, Digo pelo clima claro, nao pelo ocorrido.", " Opa, vejo que achou meu pano, O QUE? VOCE QUEM RASGOU? AI MEU DEUS MEU EMPREGO. Vc encontrou rasgado? Muito estranho. por que fariam isso com meu pano?, Eu estava no escritorio limpando moveis quando o James entrou pedindo privacidade, agora deixe-me preciso arranjar um novo pano", Pano);

        James = new NPC("James","Sou James King, amigo de longa data do dono dessa mansao e co-criador da empresa Sublime Comunications. Sou a ultima pessoa que deve suspeitar sobre o assassinato, estava no banheiro o tempo todo, acho que o frango que o chef fez faz mal ao meu estomago. Realmente uma perda terrivel tivemos hoje, a empresa nao sera a mesma sem ele para co-administrar comigo.","Vejo que encontrou minha taca, poderia devolve-la? Eh um vinho do porto muito caro e estava esperando uma ocasiao especial para abri-la, nao esta sabendo? ontem fui promovido a CEO da Sublime Comunications, hoje foi uma festa para comemorar minha promocao, foi uma verdadeira fatalidade que fizeram.", Taca);

        Leonard = new NPC("Leonard","Me chamo Leonard, sou o chefe de cozinha, fui contratado ano passado para fazer o menu das festas extravagantes do senhor dono. Nao sei nada sobre o assassinato do senhor dono, certamente nao fui eu! Estava na minha cozinha o tempo todo preparando a comida para a festa. Fazer pato laqueado no mel de cacau com ervas e frutas demanda tempo, ter que usar ingredientes que eu mesmo colhi no dia está muito alem do meu salario! ","Voce achou minha faca de cozinha? bem que eu senti falta dela fazendo o pato hoje, afio ela todos os dias, ela pode cortar ate madeira.", Faca);



        // adiciona os itens

        jardim.addItem(Tesoura);
        jardim.addItem(Luvas);
        cozinha.addItem(Faca);
        cozinha.addItem(Carcaca);
        escritorio.addItem(Pano);
        escritorio.addItem(Relogio);
        piscina.addItem(Veneno);
        piscina.addItem(Taca);
        banheiro.addItem(Celular);

        // adiciona os npcs

        jardim.addNPC(Ferdinando);
        hallPrincipal.addNPC(Adriel);
        piscina.addNPC(Marta);
        banheiro.addNPC(James);
        cozinha.addNPC(Leonard);

        // initialise room exits

        hallPrincipal.setExit("leste", piscina);
        hallPrincipal.setExit("oeste", jardim);
        hallPrincipal.setExit("norte", escritorio);
        hallPrincipal.setExit("sul", cozinha);

        piscina.setExit("oeste", hallPrincipal);

        jardim.setExit("leste", hallPrincipal);

        escritorio.setExit("sul", hallPrincipal);
        escritorio.setExit("oeste", banheiro);

        banheiro.setExit("leste", escritorio);

        cozinha.setExit("norte", hallPrincipal);

        currentRoom = hallPrincipal;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
        

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar. Adeus!");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bem vindo a Mansao Capello");
        System.out.println("Voce foi chamado para resolver um crime em que a vitima foi o Dono da Mansao, Intereja com os NPCs e os Objetos para encontrar dicas.");
        System.out.println("Digite '" + CommandWord.AJUDA + "' se precisar de ajuda.");
        System.out.println();
        System.out.println("Aparentemente houve um breve apagao e todos os convidados ficaram muito nervosos, muitos gritos e quando a luz acendeu entraram em desespero: O velho dono da mansao largado no chao");
        System.out.println();
        System.out.println("Suas opcoes sao");
        System.out.println("ir: recebe um argumento Lugar, quando quiser ir para outro local");
        System.out.println("observar: nao recebe argumento, retorna as pessoas disponiveis para conversar e itens disponiveis para pegar naquela Lugar");
        System.out.println("inspecionar: recebe um argumento sala/item, retorna as pessoas presentes na sala ou a descricao do item");
        System.out.println("pegar: recebe um argumento item, guarda o item no seu inventario");
        System.out.println("conversar: recebe um argumento NPC, conversa com o npc");
        System.out.println("inventario: nao recebe argumento, retorna os itens no seu inventario");
        System.out.println("prender: recebe um argumento Nome, quando tiver certeza de quem e o assassino prenda a pessoa");
        System.out.println("ajuda: lembrar comandos disponiveis");
        System.out.println("sair: encerra o jogo");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Eu nao sei o que isto significa.");
                break;

            case AJUDA:
                printHelp();
                break;

            case IR:
                goRoom(command);
                break;

            case SAIR:
                wantToQuit = quit(command);
                break;
            
            case PRENDER:
                wantToQuit = prender(command);
                break;
            
            case INSPECIONAR:
                analisa(command);
                break;

            case INVENTARIO:
                inventario(command);
                break;

            case CONVERSAR:
                falarCom(command);
                break;

            case PEGAR:
                pegaItem(command);
                break;

        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("Voce esta no " + currentRoom.getLongDescription());
        System.out.println("explore essa area para encontrar novas pistas, interagindo com objetos ou conversando com os npcs.");
        System.out.println();
        System.out.println("Seus comandos sao:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir onde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Nao existe uma porta nessa direcao.");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair do que?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    private boolean prender(Command command){
        if(command.hasSecondWord()) {
        if (command.getSecondWord().equals("James")) {
            System.out.println("Parabens voce se provou verdadeiro detetive! Obrigado por jogar.");
            return true;
        } else {
            System.out.println("Sherlock Holmes acha voce uma vergonha da profissao! Obrigado por jogar.");
            return true;
        }
        } else {
            System.out.println("Prender quem?");
            return false;
        }
    }

    private void inventario(Command command) {
        personagem.listaItens();
    }

    private void falarCom(Command command) {
        if(!command.hasSecondWord()) {
              // if there is no second word, we don't know where to go...
              System.out.println("Falar com quem?");
              return;
          }
  
        String nome = command.getSecondWord();
  
        NPC npc = currentRoom.encontraNPC(nome);
  
        if(npc != null) {
          if (personagem.checaItem(npc.getItemChave())) {
            System.out.println(npc.getFalasChave());
          }
          else {
            System.out.println(npc.getFalas());
          }
        }
        else {
          System.out.println("Nao entendo o que quer dizer...");
        }
        
      }

    private void analisa(Command command) {
        if(!command.hasSecondWord()) {
              // if there is no second word, we don't know where to go...
              System.out.println("Inpescionar o que? (sala/item)");
              return;
          }
  
        String SegundaPalavra = command.getSecondWord();
        
        if (SegundaPalavra.equals("item")) {
          System.out.println("Qual item?");
        }
        else if (SegundaPalavra.equals("sala")) {
          currentRoom.mostraElementos();
        }
        else{
          Item item = personagem.procuraItem(SegundaPalavra);
          if (item != null) {
            System.out.println("Descricao: " + item.getDescricao());
          }
          else {
             System.out.println("Nao entendo o que quer dizer...");
          }
        }
      }

      private void pegaItem(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Pegar o que?");
            return;
        }

        String nomeItem = command.getSecondWord();
        Item item = currentRoom.encontraItem(nomeItem);

      if(item != null) {
        currentRoom.removeItem(item);
        personagem.addItem(item);     
        System.out.println("Voce obteve o item " + nomeItem);
        System.out.println("\nDecricao: " + item.getDescricao());
        
      }
      else {
        System.out.println("Nao entendo o que quer dizer...");
      }
    }
    
    
}
