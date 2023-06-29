import java.util.Scanner;
import java.util.Random;

public class MissionWithoutNorbert {

	public static void main (String[]args) {
		Scanner input = new Scanner(System.in);
		Random rnd = new Random();
		char Norbert = 'O';
		char Minions = 'M';
		char Links_Rechts_C;
		int Minions_Zahl = 11; 	//Minions Zahl mit Norbert
		int Norberts_Stelle = (int)(Math.random()*11+1);  //Zufallszahl: 1 bis 11
		int Comp = 0;
		int Player = 0;
		int Team_Comp = 0;
		int Team_Player = 0;
		int Erste_Wahl, Kopf_Zahl, Minions_ins_Team_C, Minions_ins_Team;
		boolean Norbert_bei_Player = false;
		boolean Norbert_bei_Comp = false;
		String Links_Rechts;
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
		Erste_Wahl = input.nextInt();
		Kopf_Zahl = (int)(Math.random()*(1+1));  //Zufallszahl: 1 oder 0
		
		if (Erste_Wahl != 1 && Erste_Wahl != 0)  
			do {
				System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
				System.out.println("Wähle: 0 (Kopf) oder 1 (Zahl)"); 
				Erste_Wahl = input.nextInt();
			}
			while (Erste_Wahl != 1 && Erste_Wahl != 0);
		
		
		
		Kopf_Zahl = (int)(Math.random()*(1+1));  //Zufallszahl: 1 oder 0
		
		if (Erste_Wahl == Kopf_Zahl) {
			Player += 1;
			System.out.println("Du hast gewonnen! \r\n");
		}
		else {
			Comp += 1;
			System.out.println("Computer hat gewonnen! \r\n");
		}

		do {
			if (Player > Comp) {
				System.out.println("");
				System.out.println("In deinem Team: " +Team_Player  );
				System.out.println("Im Computerts Team: " +Team_Comp  +"\r\n");
				System.out.println("Du bist am Zug. ");
				System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
				Links_Rechts = input.next();
				
				if (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"))  {
					do {
						System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
						System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
						Links_Rechts = input.next();
					}
					while (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"));
				}

				System.out.println("Wieviele Minions sollen in dein Team?");
				Minions_ins_Team = input.nextInt();
				
				if (Minions_ins_Team != 1 && Minions_ins_Team != 2 && Minions_ins_Team != 3)  
					do {
						System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
						System.out.println("Wieviele Minions sollen in dein Team?");
						Minions_ins_Team = input.nextInt();
					}
					while (Minions_ins_Team !=1 && Minions_ins_Team !=2 && Minions_ins_Team !=3);
				
				Team_Player += Minions_ins_Team;
				
				if (Minions_Zahl - Minions_ins_Team > 2) {
					System.out.println("");
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = (int)(Math.random()*3+1);
					System.out.println(Minions_ins_Team_C);
					Team_Comp += Minions_ins_Team_C;
					
				
					if(Links_Rechts.equals("l") && Links_Rechts_C == 'l') {
						if (Minions_ins_Team >= Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_ins_Team_C+Minions_ins_Team) >= Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
							Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= (Minions_ins_Team+Minions_ins_Team_C);
							
							System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
							
					}
	//					
					else if(Links_Rechts.equals("r") && Links_Rechts_C == 'r') {
						if ((Minions_Zahl-Minions_ins_Team) < Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-(Minions_ins_Team_C+Minions_ins_Team)) < Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}		
						}
						System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
						
					}
					
					if((Links_Rechts.equals("l") && Links_Rechts_C == 'r')) {
						if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team_C) < Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team;
								
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
								
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));	
							
					}
						
					else if ((Links_Rechts.equals("r") && Links_Rechts_C == 'l')) {
						if ((Minions_ins_Team_C >= Norberts_Stelle) && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team < Norberts_Stelle && Norbert_bei_Comp!= true)) {
							Norbert_bei_Player = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team_C;
							
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
					}	
				}
					
				else if (Minions_Zahl - Minions_ins_Team == 2) {
					System.out.println("");
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);
					System.out.println("");
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = (int)(Math.random()*2+1);
					System.out.println(Minions_ins_Team_C);
					Team_Comp += Minions_ins_Team_C;
					
				
					if(Links_Rechts.equals("l") && Links_Rechts_C == 'l') {
						
						if (Minions_ins_Team >= Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_ins_Team_C+Minions_ins_Team) >= Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= (Minions_ins_Team+Minions_ins_Team_C);
						
						System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}	
							
						}
					}
	//					
					else if(Links_Rechts.equals("r") && Links_Rechts_C == 'r') {

						if ((Minions_Zahl-Minions_ins_Team) < Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-(Minions_ins_Team_C+Minions_ins_Team)) < Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}		
						}
						System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
					}
					
					if((Links_Rechts.equals("l") && Links_Rechts_C == 'r')) {

						if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team_C) < Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team;
								
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
								
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));	
					}
					else if ((Links_Rechts.equals("r") && Links_Rechts_C == 'l')) {

						if ((Minions_ins_Team_C >= Norberts_Stelle) && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team < Norberts_Stelle && Norbert_bei_Comp!= true)) {
							Norbert_bei_Player = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team_C;
							
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));	
						
					}
				}
				
				else if (Minions_Zahl - Minions_ins_Team == 1) {				
					System.out.println("");
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);
					System.out.println("");
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = 1;
					System.out.println(Minions_ins_Team_C);
					Team_Comp += Minions_ins_Team_C;
					
				
					if(Links_Rechts.equals("l") && Links_Rechts_C == 'l') {
						
						if (Minions_ins_Team >= Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_ins_Team_C+Minions_ins_Team) >= Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= (Minions_ins_Team+Minions_ins_Team_C);
						
						System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}	
						}
							
					}
		
					else if(Links_Rechts.equals("r") && Links_Rechts_C == 'r') {

						if ((Minions_Zahl-Minions_ins_Team) < Norberts_Stelle && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-(Minions_ins_Team_C+Minions_ins_Team)) < Norberts_Stelle && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}		
						}
						System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
					}
					
					if((Links_Rechts.equals("l") && Links_Rechts_C == 'r')) {
						
						if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team_C < Norberts_Stelle && Norbert_bei_Player!= true)) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team;
								
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
								
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));	
					}
					
					else if ((Links_Rechts.equals("r") && Links_Rechts_C == 'l')) {	
						
						if ((Minions_ins_Team_C >= Norberts_Stelle) && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						else if ((Minions_Zahl-Minions_ins_Team < Norberts_Stelle && Norbert_bei_Comp!= true)) {
							Norbert_bei_Player = true;
						}
						
						Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
						Norberts_Stelle -= Minions_ins_Team_C;
							
						System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}	
							}
						System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
					}
				}
				else {
					if( Links_Rechts.equals("r") || Links_Rechts.equals("l")) {
						
						if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
							Norbert_bei_Player = true;
						}
						
						Minions_Zahl = Minions_Zahl-Minions_ins_Team;
						
						System.out.printf(String.format("%" +Minions_ins_Team +"s", "").replace(' ', '-'));
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}		
						}	
					}
				}
			}
				
			else {
				if (Minions_Zahl > 2) {
					System.out.println("");
					System.out.println("In deinem Team: " +Team_Player  );
					System.out.println("Im Computerts Team: " +Team_Comp  );
					System.out.println("");
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);					
					System.out.println("");
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = (int)(Math.random()*3+1);
					System.out.println(Minions_ins_Team_C);
					Team_Comp += Minions_ins_Team_C;
					
					System.out.println("");
					if (Minions_Zahl-Minions_ins_Team_C != 0) {
						System.out.println("");
						System.out.println("Du bist am Zug. ");
						System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
						Links_Rechts = input.next();
						

						if (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"))  {
							do {
								System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
								System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
								Links_Rechts = input.next();
							}
							while (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"));
						}
						
						System.out.println("");
						System.out.println("Wieviele Minions sollen in dein Team?");
						Minions_ins_Team = input.nextInt();
						
						if (Minions_ins_Team != 1 && Minions_ins_Team != 2 && Minions_ins_Team != 3)  
							do {
								System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
								System.out.println("Wieviele Minions sollen in dein Team?");
								Minions_ins_Team = input.nextInt();
							}
							while (Minions_ins_Team !=1 && Minions_ins_Team !=2 && Minions_ins_Team !=3);
						
						System.out.println("");
						Team_Player += Minions_ins_Team;
						
						if(Links_Rechts.equals("l") && Links_Rechts_C == 'l') {

							if (Minions_ins_Team+Minions_ins_Team_C >= Norberts_Stelle && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if (Minions_ins_Team_C >= Norberts_Stelle && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
							
							Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= (Minions_ins_Team+Minions_ins_Team_C);
							
							System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}		
							}
						}
		
						else if(Links_Rechts.equals("r") && Links_Rechts_C == 'r') {

							if ((Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C)) < Norberts_Stelle && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team_C) < Norberts_Stelle && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
						
							Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}		
							}
							System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
						}	
						
						if((Links_Rechts.equals("l") && Links_Rechts_C == 'r')) {

							if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team_C < Norberts_Stelle && Norbert_bei_Player!= true)) {
								Norbert_bei_Comp = true;
							}
							
							Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= Minions_ins_Team; //Player hat  links gewählt, deshalb ziehen wir so viele Minions ab, wie viel hat sich der Player genommen 
									
							System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
									
								for (int i=1; i<=Minions_Zahl; i++) {
									if(i == Norberts_Stelle) {
										System.out.print(Norbert);
									}
									else {
										System.out.print(Minions);
									}	
								}
							System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));	
							
						}
						else if ((Links_Rechts.equals("r") && Links_Rechts_C == 'l')) {
							
							if ((Minions_ins_Team_C >= Norberts_Stelle) && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team < Norberts_Stelle && Norbert_bei_Comp!= true)) {
								Norbert_bei_Player = true;
							}
							
							Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= Minions_ins_Team_C;
								
							System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
								
								for (int i=1; i<=Minions_Zahl; i++) {
									if(i == Norberts_Stelle) {
										System.out.print(Norbert);
									}
									else {
										System.out.print(Minions);
									}	
								}
							System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));	
						}
					}	
					else {
						break;
					}
				}
				else if (Minions_Zahl == 2) {
					System.out.println("");
					System.out.println("In deinem Team: " +Team_Player  );
					System.out.println("Im Computerts Team: " +Team_Comp  );
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);					
					System.out.println("");
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = (int)(Math.random()*2+1);
					System.out.println(Minions_ins_Team_C);
					Team_Comp += Minions_ins_Team_C;
					
					System.out.println("");
					if (Minions_Zahl-Minions_ins_Team_C != 0) {
						System.out.println("");
						System.out.println("Du bist am Zug. ");
						System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
						Links_Rechts = input.next();
						
						if (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"))  
							do {
								System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
								System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
								Links_Rechts = input.next();
							}
							while (!Links_Rechts.equals("l") && !Links_Rechts.equals("r"));
						
						System.out.println("");
						System.out.println("Wieviele Minions sollen in dein Team?");
						Minions_ins_Team = input.nextInt();
						
						if (Minions_ins_Team != 1 && Minions_ins_Team != 2 && Minions_ins_Team != 3)  
							do {
								System.out.println("Falsche Eingabe, versuch es noch ein mal! ");
								System.out.println("Wieviele Minions sollen in dein Team?");
								Minions_ins_Team = input.nextInt();
							}
							while (Minions_ins_Team !=1 && Minions_ins_Team !=2 && Minions_ins_Team !=3);
						
						System.out.println("");
						Team_Player += Minions_ins_Team;
						
						if(Links_Rechts.equals("l") && Links_Rechts_C == 'l') {
							
							if ((Minions_ins_Team+Minions_ins_Team_C) >= Norberts_Stelle && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if (Minions_ins_Team_C >= Norberts_Stelle && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
							
							Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= (Minions_ins_Team+Minions_ins_Team_C);
							
							System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}		
							}
						}
		
						else if(Links_Rechts.equals("r") && Links_Rechts_C == 'r') {

							if ((Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C)) < Norberts_Stelle && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team_C) < Norberts_Stelle && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
							
							Minions_Zahl = Minions_Zahl-(Minions_ins_Team+Minions_ins_Team_C);
							
							for (int i=1; i<=Minions_Zahl; i++) {
								if(i == Norberts_Stelle) {
									System.out.print(Norbert);
								}
								else {
									System.out.print(Minions);
								}		
							}
							System.out.printf(String.format("%" +(Minions_ins_Team+Minions_ins_Team_C) +"s", "").replace(' ', '-'));	
						}
						
						if((Links_Rechts.equals("l") && Links_Rechts_C == 'r')) {	
							
							if ((Minions_ins_Team >= Norberts_Stelle) && Norbert_bei_Comp!= true) {
								Norbert_bei_Player = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team_C < Norberts_Stelle && Norbert_bei_Player!= true)) {
								Norbert_bei_Comp = true;
							}
							
							Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= Minions_ins_Team;
									
							System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));
									
								for (int i=1; i<=Minions_Zahl; i++) {
									if(i == Norberts_Stelle) {
										System.out.print(Norbert);
									}
									else {
										System.out.print(Minions);
									}	
								}
							System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
						}
						
						else if ((Links_Rechts.equals("r") && Links_Rechts_C == 'l')) {

							if ((Minions_ins_Team_C >= Norberts_Stelle) && Norbert_bei_Player!= true) {
								Norbert_bei_Comp = true;
							}
							else if ((Minions_Zahl-Minions_ins_Team < Norberts_Stelle && Norbert_bei_Comp!= true)) {
								Norbert_bei_Player = true;
							}
							
							Minions_Zahl -= (Minions_ins_Team+Minions_ins_Team_C);
							Norberts_Stelle -= Minions_ins_Team_C;
								
							System.out.printf(String.format("%" +(Minions_ins_Team_C) +"s", "").replace(' ', '-'));
								
								for (int i=1; i<=Minions_Zahl; i++) {
									if(i == Norberts_Stelle) {
										System.out.print(Norbert);
									}
									else {
										System.out.print(Minions);
									}	
								}
							System.out.printf(String.format("%" +(Minions_ins_Team) +"s", "").replace(' ', '-'));	
						}
					}
					else {
						break;
						
					}
				}	
				
				else if (Minions_Zahl == 1) {
					System.out.println("");
					System.out.println("In deinem Team: " +Team_Player  );
					System.out.println("Im Computerts Team: " +Team_Comp  );
					System.out.println("Computer ist am Zug. ");
					System.out.println("Von welcher Seite – l)inks oder r)echts – willst du wählen?");
					Links_Rechts_C = chars.charAt(rnd.nextInt(chars.length()));
					System.out.println(Links_Rechts_C);					
					System.out.println("");
					System.out.println("Wieviele Minions sollen in dein Team?");
					Minions_ins_Team_C = 1;
					System.out.println(Minions_ins_Team_C);
					
					
					Team_Comp += Minions_ins_Team_C;
					
					
					if( Links_Rechts_C == 'l' || Links_Rechts_C == 'r') {
						
						if ((Minions_ins_Team_C >= Norberts_Stelle ) && Norbert_bei_Player!= true) {
							Norbert_bei_Comp = true;
						}
						
						Minions_Zahl = Minions_Zahl-Minions_ins_Team_C;
						
						System.out.printf(String.format("%" +Minions_ins_Team_C +"s", "").replace(' ', '-'));
						
						for (int i=1; i<=Minions_Zahl; i++) {
							if(i == Norberts_Stelle) {
								System.out.print(Norbert);
							}
							else {
								System.out.print(Minions);
							}		
						}
					}
				}
			}
		}
		while(Minions_Zahl>0 && Minions_Zahl!=0);
		
		if (Norbert_bei_Comp == true) {
			System.out.println("\r\n");
			System.out.println("Computer hat verloren!");
			System.out.println("In deinem Team sind " +Team_Player +" Minions – erfülle deine Mission WITHOUT Norbert!!!");
		}
		else if (Norbert_bei_Player == true) {
			System.out.println("");
			System.out.println("Du hast verloren!");
			System.out.println("In deinem Team sind " + Team_Player + " Minions – erfülle deine Mission mit Norbert.");
		}
	}
}
