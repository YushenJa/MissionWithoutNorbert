import java.util.Scanner;
import java.util.Random;

public class MissionWithoutNorbert {
  
	public static final char norbert = 'O';
    public static final char minions = 'M';
    
  public static void reihnfolge(int minionsZahl, int norbertsStelle) { 															// Methode, die uns immer eine Folge von Minions ausgibt
      for (int i = 1; i <= minionsZahl; i++) {  													//Schleife die uns 11 Minions zeigt, aber wenn die Schleife eine Zahl erreicht,
        if(i == norbertsStelle) {																//die mit Norberts Position übereinstimmt, ein "O" ausgibt, ansonst eine "M" 
          System.out.print(norbert);
        }
        else {
          System.out.print(minions);
        }    
      }
    }
  
//  public static void minionsAusgabe() { 															// Methode, die uns immer eine Folge von Minions ausgibt
//      for (int i=1; i<=minionsZahl; i++) {  													//Schleife die uns 11 Minions zeigt, aber wenn die Schleife eine Zahl erreicht,
//        if(i == norbertsStelle) {																//die mit Norberts Position übereinstimmt, ein "O" ausgibt, ansonst eine "M" 
//          System.out.print(norbert);
//        }
//        else {
//          System.out.print(minions);
//        }    
//      }
//    }

  
    public static void main (String[]args) {
      Scanner input = new Scanner(System.in);
      Random rnd = new Random();
      int minionsZahl = 11;   																	//Minions Zahl mit Norbert
  	  int norbertsStelle = (int)(Math.random() * minionsZahl + 1);  							//Zufallszahl: 1 bis 11
      char linksRechtsC; 																		// Seite wählen für Computer
      char linksRechts; 																		// Seite wählen für Player
      int comp = 0; 																			// Die Variable; die uns hilft, die Rotation Computer/Player oder Player/Computer im spiel zuerstellen 
      int player = 0; 																			// Die Variable; die uns hilft, die Rotation Computer/Player oder Player/Computer im spiel zuerstellen 
      int teamComp = 0; 																		//Zeigt, wie Viele Minions ist im Computers Team
      int teamPlayer = 0; 																		//Zeigt, wie Viele Minions ist im Players Team
      int ersteWahl, kopfZahl, minionsInsTeam, minionsInsTeamC;
      boolean norbertBeiPlayer = false; 														// Mit dieser Variable können wir verfolgen,in welchem Team Norbert ist 
      boolean norbertBeiComp = false; 															// Mit dieser Variable können wir verfolgen,in welchem Team Norbert ist 
      String chars = "rl"; 
      
      
      
      System.out.println("Hi, das ist das Spiel 'Mission Without Norbert' \r\n");
      System.out.println("REGELN: \r\n" +"Sie und der Computer bestimmen abwechselnd, wie viele Minions in Ihr bzw.\r\n"
          + "das Computer-Team aufgenommen werden. Dabei können Sie ein, zwei oder\r\n"
          + "drei Minions links von Norbert auswählen oder entsprechend ein, zwei oder drei\r\n"
          + "Minions rechts von Norbert.\r\n"
          + "‣ Sie müssen pro Wahl mindestens ein Minion in Ihr Team aufnehmen, selbst\r\n"
          + "wenn nur noch Norbert übrig ist.\r\n"
          + "‣ Wenn keine Minions mehr zur Auswahl stehen, ist die Wahl vorbei. Wer Norbert\r\n"
          + "in seinem Team hat, hat dann leider verloren. \r\n");
      System.out.print ("Erst mal sollen wir entscheiden, wer wählt zuerst. ");
      System.out.println ("Wähle: 0 (Kopf) oder 1 (Zahl) "); 
      
      
      //Kopf oder Zahl
      
      ersteWahl = input.nextInt();
      kopfZahl = (int)(Math.random()*(1+1));  													//Zufallszahl: 1 oder 0
      
      if (ersteWahl != 1 && ersteWahl != 0) {   												//Wir können in Variable ersteWahl nur 1 oder 0 eingeben 
        do {
          System.out.println("Falsche Eingabe, versuch es noch ein mal! "); 					//Wenn wir etwas außer 0 oder 1 eingeben 
          System.out.println("Wähle: 0 (Kopf) oder 1 (Zahl)"); 
          ersteWahl = input.nextInt();
        }
        while (ersteWahl != 1 && ersteWahl != 0); 												// Fragen wieder, bis die ersteWahl 1 oder 0 Wird
      }
      
      if (ersteWahl == kopfZahl) { 																//Wenn deine Wahl im Kopf Zahl Spiel die gleiche ist wie Zufallszall, dann wählt Player zuerst
        player += 1;
        System.out.println("Du wählst zuerst! \r\n");
      }
      else { 																					//Wenn deine Wahl im Kopf Zahl Spiel ist ungleich  Zufallszall, dann wählt Computer zuerst
        comp += 1;
        System.out.println("Computer wählt zuerst! \r\n");
      }
      
      
      //Erste Reihnfolge
      
      System.out.println("Die Reihe von Minions: ");
      reihnfolge(minionsZahl, norbertsStelle); 																			//Ausgabe von Methode Rheihnfolge
      System.out.println("");
      
      
      
      //Start des Spiels
      
      do {  																					//Das Spiel läuft, solange die Minions Zahl ungleich 0 ist  
       
    	  
    	  if (player > comp) {																	//Wenn im Kopf Zahl Player gewonnen hat 
        	comp += 2;
            System.out.println("");
            System.out.println("In deinem Team: " +teamPlayer  );
            System.out.println("Im Computerts Team: " +teamComp  +"\r\n");
            System.out.println("Du bist am Zug. ");
            System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
            
            
            linksRechts = input.next().charAt(0);
          
          if (linksRechts != 'l' && linksRechts != 'r')  { 										// Wenn Player ein Symbol außer r oder l wählt,
            do {																				// Wird es immer wieder bei Player nach einem Symbol gefragt
              System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
              System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
              linksRechts = input.next().charAt(0);
            } while (linksRechts != 'l' && linksRechts != 'r'); 								// bis Player das richtige Symbol eingeben
          }
  
         
          
          
          
          System.out.println("Wieviele Minions sollen in dein Team?");
          minionsInsTeam = input.nextInt();
          
          if (minionsInsTeam != 1 && minionsInsTeam != 2 && minionsInsTeam != 3) {	  		  	// Wenn Player eine Zahl außer 1, 2 oder 3 wählt hat,						
        	  do {																				// Wird es immer wieder bei Player nach eine Zahl gefragt
           
              System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
              System.out.println("Wieviele Minions sollen in dein Team?");
              minionsInsTeam = input.nextInt();
            } while (minionsInsTeam !=1 && minionsInsTeam !=2 && minionsInsTeam !=3); 			// bis Player die richtige Zahl eingeben
           
          }
          if (minionsZahl == 2 && minionsInsTeam == 3) {				 						// Wenn die Minions Zahl ist nur noch 2, aber Player hat 3 Minions gewählt,
              do {																				// Wird es immer wieder bei Player nach eine Zahl gefragt
                System.out.println("Falsche Eingabe, du kannst nur maximal 2 Minions ins Team nehemen! ");
                System.out.println("Wieviele Minions sollen in dein Team?");
                minionsInsTeam = input.nextInt();
              } while (minionsInsTeam !=1 && minionsInsTeam !=2); 								// bis Player die richtige Zahl eingeben (1 oder 2)
          } 
            else if (minionsZahl == 1 && (minionsInsTeam == 2 || minionsInsTeam == 3)) {		// Wenn die Minions Zahl ist nur noch 1, aber Player hat 2 oder 3 Minions gewählt,
              do {																				// Wird es immer wieder bei Player nach eine Zahl gefragt
                System.out.println("Falsche Eingabe, du kannst nur maximal 1 Minion ins Team nehemen! ");
                System.out.println("Wieviele Minions sollen in dein Team?");
                minionsInsTeam = input.nextInt();
              } while (minionsInsTeam !=1 );													// bis Player die richtige Zahl eingeben (1 oder 2)
            }
              teamPlayer += minionsInsTeam;
            
             
              
              
              
              if(linksRechts == 'l') { 															//Wenn Player wählt die Linke Seite 
                if (minionsInsTeam >= norbertsStelle && norbertBeiComp!= true) {       		 	// Überprüfen ob Player auch Norbert mitgenommen hat (überprüfen auch, ob es Norbert schon bei Computer im Team ist)
                  norbertBeiPlayer = true;														// Wenn Ja, dann wird boolean "norbertBeiPlayer" true; 
                }
              
                minionsZahl -= minionsInsTeam;													//Wir ziehen die Anzahl von Minions, die wir ins Team nehmen, von den Gesamtzahl von Minions ab. 
                norbertsStelle -= minionsInsTeam;
                
                System.out.printf(String.format("%" +(minionsInsTeam) +"s", "").replace(' ', '-'));
                
              reihnfolge(minionsZahl, norbertsStelle);
                
            }
            else if(linksRechts == 'r') { 														//Dasselbe für rechte Seite
              if ((minionsZahl-minionsInsTeam) < norbertsStelle && norbertBeiComp!= true) {
                norbertBeiPlayer = true;
              }
              
              minionsZahl = minionsZahl-(minionsInsTeam);
              
              reihnfolge(minionsZahl, norbertsStelle);
              
              System.out.printf(String.format("%" +(minionsInsTeam) +"s", "").replace(' ', '-'));
            }
          }
    	  
    	  
    	  
          
          else if ((comp > player)) {															//Wenn im Kopf Zahl Computer gewonnen hat 
              
        	  System.out.println("");
              System.out.println("In deinem Team: " +teamPlayer  );
              System.out.println("Im Computerts Team: " +teamComp  );
              System.out.println("");
              System.out.println("Computer ist am Zug. ");
              System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
              
              
              
              
              linksRechtsC = chars.charAt(rnd.nextInt(chars.length()));							//Computer wählt l oder r
              																					//Machen Computer bisshen klüger. Computer wählt nicht einfach zufällig
              if (norbertsStelle == 1 ) {														//Computer merkt pb Norbertsstelle 1 oder 11 ist. Wenn 1 ist
                linksRechtsC = 'r';																// Wenn Norbertstelle 1 ist, dann wird Computer nur von rechte Seite wählen 
              }
              else if (norbertsStelle == minionsZahl) {											// Wenn Norbertstelle 11 ist, dann wird Computer nur von linke Seite wählen 
                linksRechtsC = 'l';
              }
              System.out.println(linksRechtsC);          
              System.out.println("");
              System.out.println("Wieviele Minions sollen in dein Team?");
              
              
              
              
              minionsInsTeamC = (int)(Math.random()*3+1);
              																			
              if (minionsZahl<3 && minionsInsTeamC ==3) {										//Wenn die Minions Zahl ist nur noch 2, aber Computer hat 3 Minions gewählt,
                minionsInsTeamC-=1;																// Dann ziehen wir 1 ab
              }
              else if (minionsZahl<2 && minionsInsTeamC ==3) {									//Wenn die Minions Zahl ist nur noch 1, aber Computer hat 3 Minions gewählt,
                minionsInsTeamC-=2;																// Dann ziehen wir 2 ab
              }
              else if (minionsZahl<2 && minionsInsTeamC ==2) {									//Wenn die Minions Zahl ist nur noch 1, aber Computer hat 3 Minions gewählt,
                minionsInsTeamC-=1;																// Dann ziehen wir 1 ab
              }
              
             
              
              
              
              if (minionsInsTeamC >= norbertsStelle && linksRechtsC == 'l' && minionsZahl != 1) { // Machen Computer klüger. Wenn er Norbert nimmt, 
                if (minionsInsTeamC-norbertsStelle == 0) {										//Dann ziehen wir 1 oder 2 Minions ab, damit das Spiel fairer wäre
                  minionsInsTeamC-=1;
                }
                else if (minionsInsTeamC-norbertsStelle == 1) {
                  minionsInsTeamC-=2;
                }
              }
              else if (minionsInsTeamC > (minionsZahl - norbertsStelle) && linksRechtsC == 'r' && minionsZahl != 1) {
                minionsInsTeamC-=1;
                
                if (minionsInsTeamC-(minionsZahl -norbertsStelle) == 1) {
                  minionsInsTeamC-=1;
                }
                else if (minionsInsTeamC-(minionsZahl -norbertsStelle) == 2) {
                  minionsInsTeamC-=2;
                }
              }
              else if (minionsZahl == 1) {														// Wenn wir nur noch ein Minion haben, egal ob es Norbert ist oder nicht, nimmt Computer das letzte 
                minionsInsTeamC = 1;
              }
              
              
              
              System.out.println(minionsInsTeamC);
              teamComp += minionsInsTeamC;
              player += 2;
              
             
              
              
              
              if( linksRechtsC == 'l') {														//Dasselbe für linke Seite für Computer, wie beim Player 
                  
                  if ((minionsInsTeamC >= norbertsStelle ) && norbertBeiPlayer!= true) {
                    norbertBeiComp = true;
                  }
                  
                  minionsZahl -= minionsInsTeamC;
                  norbertsStelle -= minionsInsTeamC;
                  
                  
                  System.out.printf(String.format("%" +minionsInsTeamC +"s", "").replace(' ', '-'));
                
                  reihnfolge(minionsZahl, norbertsStelle);
                }
                
              else if(linksRechtsC == 'r') {													//Dasselbe für rechte Seite für Computer, wie beim Player 
                
                if ((minionsZahl-minionsInsTeamC) < norbertsStelle && norbertBeiComp!= true) {
                  norbertBeiComp = true;
                }
                
                minionsZahl = minionsZahl-minionsInsTeamC;
                
                reihnfolge(minionsZahl, norbertsStelle);
                
                System.out.printf(String.format("%" +minionsInsTeamC +"s", "").replace(' ', '-'));
              }
            }
        
        } while(minionsZahl>0 && minionsZahl!=0); 												// Ende der Schleife. Ende des Spiels
      
      
      
      	//Schlussfolgerungen
      
        if (norbertBeiComp == true) {															// Überprüfen ob Norbert beim Computer ist 
          System.out.println("\r\n");
          System.out.println("Computer hat verloren!");
          System.out.println("In deinem Team sind " +teamPlayer +" Minions – erfülle deine Mission WITHOUT Norbert!!!");
        }
        else if (norbertBeiPlayer == true) { 													// Überprüfen ob Norbert beim Player ist
          System.out.println("");
          System.out.println("Du hast verloren!");
            System.out.println("In deinem Team sind " + teamPlayer + " Minions – erfülle deine Mission mit Norbert.");
        }
      }
  }