import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static int liczba_rekordow_tabeli = 1;
	public static int liczba_kolumn_tabeli = 8;
	public static int liczba_autorow = 1;
	public static int liczba_ksiazek = 1;
	public static int limit_akcji = 15;
	public static List<Ksiazka> lista_ksiazek = new ArrayList<Ksiazka>();
	public static Scanner scan = new Scanner(System.in);

	public static int Pobierz_int() {
		int cyfra = 0;
		boolean flaga = true;

		while (flaga)
			try {
				cyfra = scan.nextInt();

			} catch (Exception e) {
				System.out.println("Poda³eœ niew³aœciw¹ cyfrê");
			}

		return cyfra;
	}

	public static void Wyswietl_ksiazki(List<Ksiazka> lista_ksiazek) {
		for (int i = 0; i < lista_ksiazek.size(); i++) {
			System.out.println("|------------------------------|");
			System.out.println("Tytu³: " + lista_ksiazek.get(i).tytul);
			System.out.println("ID ksi¹¿ki: " + lista_ksiazek.get(i).ID_ksiazki);
			System.out.println("Autorzy:");
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				System.out.println("  -" + " " + lista_ksiazek.get(i).autorzy.get(j).Imie + " "
						+ lista_ksiazek.get(i).autorzy.get(j).Nazwisko + ", ");
			}

			System.out.println("Rok wydania: " + lista_ksiazek.get(i).rok_wydania);
			System.out.println("Cena: " + lista_ksiazek.get(i).cena);
			System.out.println("Ocena: " + lista_ksiazek.get(i).ocena);
		}
	}

	public static String[] Podaj_imie_i_nazwisko_autora() {
		System.out.println("Podaj imiê i nazwisko autora.");
		String imie_i_nazwisko = "";

		imie_i_nazwisko = scan.nextLine();

		return imie_i_nazwisko.split(" ");
	}

	public static void Dodaj_ksiazke_do_listy_1() {

		System.out.println("Podaj liczbê autorów danej ksi¹¿ki (od 1 do 5):");

		int ilosc_autorow;
		String tytul_ksiazki;
		int rok_wydania;
		float cena_ksiazki;
		String imie_autora;
		String nazwisko_autora;

		liczba_rekordow_tabeli++;

		ilosc_autorow = scan.nextInt();

		List<Autor> lista_autorow = new ArrayList<Autor>();

		for (int i = 0; i < ilosc_autorow; i++) {
			System.out.print("Podaj imiê autora: ");

			imie_autora = scan.next();

			Autor autor = new Autor();
			autor.id_autora = liczba_autorow++;
			autor.Imie = imie_autora;

			System.out.print("Podaj nazwisko autora: ");

			nazwisko_autora = scan.next();
			autor.Nazwisko = nazwisko_autora;

			lista_autorow.add(autor);

		}

		System.out.print("Podaj tytu³ ksi¹¿ki:");
		tytul_ksiazki = scan.next();

		System.out.print("Podaj rok wydania:");

		String rok_w;
		rok_w = scan.next();
		rok_wydania = Integer.parseInt(rok_w);

		System.out.print("Podaj cenê ksi¹zki:");
		cena_ksiazki = Float.parseFloat(scan.next());

		Ksiazka ksiazka = new Ksiazka(liczba_ksiazek++, lista_autorow, tytul_ksiazki, rok_wydania, cena_ksiazki, 0);

		lista_ksiazek.add(ksiazka);

		System.out.println("Dodano now¹ ksi¹¿kê do listy");
	}

	public static void Usun_ksiazke_o_podanym_tytule2_1() {
		String tytul;
		int id_usun;
		List<Integer> id_ksie¿ek_do_usuniecia_lista = new ArrayList<Integer>();

		System.out.println("Wprowadz tytu³ ksi¹¿ki: ");
		tytul = scan.next();

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (lista_ksiazek.get(i).tytul.equals(tytul)) {
				id_ksie¿ek_do_usuniecia_lista.add(lista_ksiazek.get(i).ID_ksiazki);
			}
		}

		if (0 == id_ksie¿ek_do_usuniecia_lista.size()) {
			System.out.println("Nie ma takiej ksi¹¿ki.");
		}
		if (1 == id_ksie¿ek_do_usuniecia_lista.size()) {
			id_ksie¿ek_do_usuniecia_lista.get(0);
			for (int i = 0; i < lista_ksiazek.size(); i++) {

			}

			System.out.println("Ksi¹¿ka zosta³a usuniêta.");

		}
		if (1 < id_ksie¿ek_do_usuniecia_lista.size()) {
			System.out.println("Wybierz ID ksi¹¿ki, któr¹ chcesz usun¹æ:");

			for (int i = 0; i < lista_ksiazek.size(); i++) {
				if (lista_ksiazek.get(i).tytul.equals(tytul)) {
					System.out.println("|------------------------------|");
					System.out.println("Tytu³: " + lista_ksiazek.get(i).tytul);
					System.out.println("ID ksi¹¿ki: " + lista_ksiazek.get(i).ID_ksiazki);
					for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
						System.out.println("-" + " " + lista_ksiazek.get(i).autorzy.get(j).Imie + " "
								+ lista_ksiazek.get(i).autorzy.get(j).Nazwisko + ", ");
					}
					System.out.println("|------------------------------|");
				}
			}
			System.out.println("");
			System.out.println("Podaj ID ksi¹¿ki, któr¹ chcesz usun¹æ:");

			id_usun = scan.nextInt();

			for (int i = 0; i < lista_ksiazek.size(); i++) {
				if (id_usun == lista_ksiazek.get(i).ID_ksiazki) {
					lista_ksiazek.remove(i);
					break;
				}
			}
			System.out.println("Ksi¹¿ka zosta³a usuniêta.");
		}
	}

	public static void Usun_ksiazki_o_podanym_tytule_2_2() {
		String tytul;

		System.out.println("Wprowadz tytu³ ksi¹¿ki: ");
		tytul = scan.next();

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (lista_ksiazek.get(i).tytul.equals(tytul)) {
				lista_ksiazek.remove(i);
			}
		}
		System.out.println("Ksi¹¿ki zosta³y usuniête.");
	}

	public static void Usun_ksiazke_podanego_autora_2_3() {
		String nazwisko;
		String imie;
		int id_usun;
		List<Integer> id_ksie¿ek_do_usuniecia_lista = new ArrayList<Integer>();

		System.out.println("Wprowadz imiê Autora: ");
		imie = scan.next();
		System.out.println("Wprowadz nazwisko autora: ");
		nazwisko = scan.next();

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				if (lista_ksiazek.get(i).autorzy.get(j).Imie.equals(imie)
						&& lista_ksiazek.get(i).autorzy.get(j).Nazwisko.equals(nazwisko)) {
					System.out.println("|------------------------------|");
					System.out.println("Tytu³: " + lista_ksiazek.get(i).tytul);
					System.out.println("ID ksi¹¿ki: " + lista_ksiazek.get(i).ID_ksiazki);
					id_ksie¿ek_do_usuniecia_lista.add(lista_ksiazek.get(i).ID_ksiazki);
				}
			}
		}

		if (0 == id_ksie¿ek_do_usuniecia_lista.size()) {
			System.out.println("Nie ma takiej ksi¹¿ki.");
		}
		if (1 == id_ksie¿ek_do_usuniecia_lista.size()) {
			lista_ksiazek.remove(lista_ksiazek.get(0).ID_ksiazki);
			System.out.println("Ksi¹¿ka zosta³a usuniêta.");

		}
		if (1 < id_ksie¿ek_do_usuniecia_lista.size()) {
			System.out.println("Wybierz ID ksi¹¿ki, któr¹ chcesz usun¹æ:");
			id_usun = scan.nextInt();

			for (int i = 0; i < lista_ksiazek.size(); i++) {
				if (lista_ksiazek.get(i).ID_ksiazki == id_usun) {
					lista_ksiazek.remove(i);
				}
			}
		}
		System.out.println("Ksi¹¿ka zosta³a usuniêta.");
	}

	public static void Usun_wszystkie_ksiazki_podanego_autora_2_4() {
		String nazwisko;
		String imie;
		boolean flaga = false;
		List<Ksiazka> id_ksie¿ek_do_usuniecia_lista = new ArrayList<Ksiazka>();

		System.out.println("Wprowadz imiê Autora: ");
		imie = scan.next();
		System.out.println("Wprowadz nazwisko autora: ");
		nazwisko = scan.next();

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				System.out.println("i: " + i);
				System.out.println("j: " + j);
				if (lista_ksiazek.get(i).autorzy.get(j).Imie.equals(imie)
						&& lista_ksiazek.get(i).autorzy.get(j).Nazwisko.equals(nazwisko)) {
					id_ksie¿ek_do_usuniecia_lista.add(lista_ksiazek.get(i));
					flaga = true;
				}
			}
		}

		if (flaga) {
			for (int i = 0; i < id_ksie¿ek_do_usuniecia_lista.size(); i++) {
				lista_ksiazek.removeAll(id_ksie¿ek_do_usuniecia_lista);
			}
			System.out.println("Liczba usuniêtych ksi¹¿ek to: " + id_ksie¿ek_do_usuniecia_lista.size());
		} else {
			System.out.println("Nie znaleziono ksi¹¿ek podanego autora.");
		}

		System.out.println("Ksi¹¿ki zosta³y usuniête.");
	}

	public static void Autor_z_najwieksza_iloscia_ksiazek_3() {

		List<Autor_Liczba_Ksiazek> lista_autorow = new ArrayList<Autor_Liczba_Ksiazek>();
		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				List<Autor> autorzy = lista_ksiazek.get(i).autorzy;
				if (!Czy_lista_zawiera_autora(autorzy.get(j), lista_autorow)) {
					Autor_Liczba_Ksiazek autor_do_listy = new Autor_Liczba_Ksiazek(autorzy.get(j));
					lista_autorow.add(autor_do_listy);
				}
			}
		}

//		for (int i = 0; i <lista_ksiazek.size(); i++) {
//			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
//				for (int j2 = 0; j2 < lista_autorow.size(); j2++) {
//					if (lista_ksiazek.get(i).autorzy.get(j).equals(lista_autorow.get(j2).autor)) {
//						lista_autorow.get(j2).liczba_ksiazek+= 1;
//					}	
//				}
//			}
//		}

		for (int i = 0; i < lista_autorow.size(); i++) {
			for (int j = 0; j < lista_ksiazek.size(); j++) {
				for (int j2 = 0; j2 < lista_ksiazek.get(j).autorzy.size(); j2++) {
					if (lista_ksiazek.get(j).autorzy.get(j2).Imie.equals(lista_autorow.get(i).autor.Imie)
							&& lista_ksiazek.get(j).autorzy.get(j2).Nazwisko
									.equals(lista_autorow.get(i).autor.Nazwisko)) {
						lista_autorow.get(i).liczba_ksiazek += 1;
					}
				}
			}
		}
		for (int j = 0; j < lista_autorow.size() - 1; j++) {
			for (int i = 0; i < lista_autorow.size() - 1; i++) {
				if (lista_autorow.get(i + 1).liczba_ksiazek > lista_autorow.get(i).liczba_ksiazek) {
					Autor_Liczba_Ksiazek pomocnicza;
					pomocnicza = lista_autorow.get(i + 1);
					lista_autorow.set(i + 1, lista_autorow.get(i));
					lista_autorow.set(i, pomocnicza);
				}
			}
		}
		if (lista_autorow.get(0).liczba_ksiazek != lista_autorow.get(1).liczba_ksiazek) {
			System.out.println("Autor z najwiêksz¹ iloœci¹ ksi¹¿ek to: " + lista_autorow.get(0).autor.Imie + " "
					+ lista_autorow.get(0).autor.Nazwisko);
		} else {
			System.out.print("Autorzy z najwiêksz¹ iloœci¹ ksi¹¿ek równ¹ " + lista_autorow.get(0).liczba_ksiazek
					+ " to: " + lista_autorow.get(0).autor.Imie + " " + lista_autorow.get(0).autor.Nazwisko);
			for (int i = 1; i < lista_autorow.size() - 1; i++) {
				if (lista_autorow.get(0).liczba_ksiazek == lista_autorow.get(i).liczba_ksiazek) {
					System.out.println(
							", " + lista_autorow.get(i).autor.Imie + " " + lista_autorow.get(i).autor.Nazwisko);
				}
			}
		}

//		System.out.println("Autor z najwiêksz¹ iloœci¹ ksi¹¿ek to: " + lista_autorow.get(0).autor.Imie + " " + lista_autorow.get(0).autor.Nazwisko);
	}

	public static boolean Czy_lista_zawiera_autora(Autor autor, List<Autor_Liczba_Ksiazek> lista_autorow) {
		for (int i = 0; i < lista_autorow.size(); i++) {
			if (autor.Imie.equals(lista_autorow.get(i).autor.Imie)
					&& autor.Nazwisko.equals(lista_autorow.get(i).autor.Nazwisko)) {
				return true;
			}
		}
		return false;
	}

	public static void Wyswietl_wszystkie_ksiazki_danego_autora_4() {

		String[] imie_i_nazwisko = Podaj_imie_i_nazwisko_autora();

		String imie = imie_i_nazwisko[0];
		String nazwisko = imie_i_nazwisko[1];

		List<Ksiazka> lista_ksiazek_do_wyswietlenia = new ArrayList<Ksiazka>();

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				if (lista_ksiazek.get(i).autorzy.get(j).Imie.equals(imie)
						&& lista_ksiazek.get(i).autorzy.get(j).Nazwisko.equals(nazwisko)) {
					lista_ksiazek_do_wyswietlenia.add(lista_ksiazek.get(i));
				}
			}
		}

		if (lista_ksiazek_do_wyswietlenia.size() == 0) {
			System.out.println("Nie ma ksi¹¿ek z podanym autorem");
		} else {
			System.out.println("Wszystkie ksi¹¿ki podanego autora to: ");
			Wyswietl_ksiazki(lista_ksiazek_do_wyswietlenia);
		}
	}

	public static void Oblicz_srednia_cene_ksiazek_autora_5() {
		String[] imie_i_nazwisko = Podaj_imie_i_nazwisko_autora();

		String imie = imie_i_nazwisko[0];
		String nazwisko = imie_i_nazwisko[1];

		float suma_ceny_ksiazek = 0;
		float ilosc_ksiazek = 0;

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				if (lista_ksiazek.get(i).autorzy.get(j).Imie.equals(imie)
						&& lista_ksiazek.get(i).autorzy.get(j).Nazwisko.equals(nazwisko)) {
					ilosc_ksiazek++;
					suma_ceny_ksiazek += lista_ksiazek.get(i).cena;
				}
			}
		}
		System.out.print("Œrednia cena ksi¹¿ek autora " + imie + " " + nazwisko + " wynosi ");
		System.out.format("%.2f", (suma_ceny_ksiazek / ilosc_ksiazek));
		System.out.print(" z³.");
	}

	public static void Wyswietl_wszystkie_ksiazki_6() {
		if (lista_ksiazek.size() > 0) {
			System.out.println("Wszystkie ksi¹¿ki to: ");
			Wyswietl_ksiazki(lista_ksiazek);
		} else {
			System.out.println("Nie ma ksi¹¿ek w bibliotece");
		}

	}

	public static void Wczytaj_dane_z_pliku_7() {

	}

	public static void Zapisz_dane_z_pliku_8() throws FileNotFoundException { // lista_ksiazek.get(i).autorzy.size();
																				// dla i=1 i j=2 b³¹d
		PrintWriter plik = new PrintWriter("Baza_ksiazek.txt");
		plik.println(lista_ksiazek.size());
		for (int i = 0; i < lista_ksiazek.size(); i++) {
			for (int j = 0; j < 5; j++) {
				try {
					if (lista_ksiazek.get(i).autorzy != null) {
						/* System.out.println(lista_ksiazek.get(i).autorzy.size()); */
						plik.print(lista_ksiazek.get(i).autorzy.get(j).Imie + " "
								+ lista_ksiazek.get(i).autorzy.get(j).Nazwisko + ", ");
					}

				} catch (Exception e) {
					plik.print("0, ");
				}
			}
			plik.print(lista_ksiazek.get(i).tytul + ", " + lista_ksiazek.get(i).rok_wydania + ", "
					+ lista_ksiazek.get(i).cena + ", " + lista_ksiazek.get(i).ocena);
			plik.println();
		}
		plik.close();
		System.out.println("Plik zosta³ pomyœlnie zapisany");
	}

	public static void Wyswietl_ksiazki_o_podanej_ilosci_autorow_9() {
		System.out.println("Wprowadz liczbê autorów: ");
		int ilosc_autorow = Integer.parseInt(scan.nextLine());

		if (ilosc_autorow < 1 || ilosc_autorow > 5) {
			System.out.println("Poda³eœ b³êdn¹ liczbê.");
			return;
		}

		List<Ksiazka> lista_ksiazek_do_wyswietlenia = new ArrayList<Ksiazka>();
		for (int i = 0; i < lista_ksiazek.size(); i++) {

			if (ilosc_autorow == lista_ksiazek.get(i).autorzy.size()) {
				lista_ksiazek_do_wyswietlenia.add(lista_ksiazek.get(i));
			}
		}

		if (lista_ksiazek_do_wyswietlenia.size() == 0) {
			System.out.println("Nie ma ksi¹¿ek z podan¹ liczb¹ autorów");
			return;
		} else if (ilosc_autorow == 1) {
			System.out.println("Wszystkie ksi¹¿ki z " + ilosc_autorow + " autorem to: ");
		} else {
			System.out.println("Wszystkie ksi¹¿ki z " + ilosc_autorow + " autorami to: ");
		}

		Wyswietl_ksiazki(lista_ksiazek_do_wyswietlenia);
	}

	public static void Najlepiej_oceniana_ksi¹¿ka_11() {
		List<Ksiazka> ksiazka_do_wypisania = new ArrayList<Ksiazka>();
		float najwyzsza_ocena = lista_ksiazek.get(0).ocena;

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (najwyzsza_ocena < lista_ksiazek.get(i).ocena) {
				najwyzsza_ocena = lista_ksiazek.get(i).ocena;
				ksiazka_do_wypisania.clear();
				ksiazka_do_wypisania.add(lista_ksiazek.get(i));
			}

		}

		Wyswietl_ksiazki(ksiazka_do_wypisania);
	}

	public static void Najgorzej_oceniana_ksi¹¿ka_12() {
		List<Ksiazka> ksiazka_do_wypisania = new ArrayList<Ksiazka>();
		float najnizsza_ocena = lista_ksiazek.get(0).ocena;

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (najnizsza_ocena > lista_ksiazek.get(i).ocena) {
				najnizsza_ocena = lista_ksiazek.get(i).ocena;
				ksiazka_do_wypisania.clear();
				ksiazka_do_wypisania.add(lista_ksiazek.get(i));
			}

		}

		Wyswietl_ksiazki(ksiazka_do_wypisania);
	}

	public static void Ksi¹zka_z_zakresu_oceny_wieksze_od_podanej_wartosci_13() {

		ArrayList<Ksiazka> lista_ksiazek_z_ocena_wyzsza = new ArrayList<Ksiazka>();

		System.out.println("Wpisz ocenê:");
		float podana_ocena = Float.parseFloat(scan.nextLine());

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (podana_ocena <= lista_ksiazek.get(i).ocena) {
				lista_ksiazek_z_ocena_wyzsza.add(lista_ksiazek.get(i));
			}
		}
		Wyswietl_ksiazki(lista_ksiazek_z_ocena_wyzsza);
	}

	public static void Ksi¹zka_z_zakresu_oceny_mniejsze_od_podanej_wartosci_14() {

		ArrayList<Ksiazka> lista_ksiazek_z_ocena_najnizsza = new ArrayList<Ksiazka>();

		System.out.println("Wpisz ocenê:");
		float podana_ocena = Float.parseFloat(scan.nextLine());

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (podana_ocena >= lista_ksiazek.get(i).ocena) {
				lista_ksiazek_z_ocena_najnizsza.add(lista_ksiazek.get(i));
			}
		}
		Wyswietl_ksiazki(lista_ksiazek_z_ocena_najnizsza);
	}

	public static void Wyswietl_ksia¿ki_jako_glowny_i_wspolautor_10() {
		String[] imie_i_nazwisko = Podaj_imie_i_nazwisko_autora();

		String imie = imie_i_nazwisko[0];
		String nazwisko = imie_i_nazwisko[1];

		int ilosc_glowny = 0;
		int ilosc_wspolautor = 0;

		for (int i = 0; i < lista_ksiazek.size(); i++) {
			if (lista_ksiazek.get(i).autorzy.get(0).Imie.equals(imie)
					&& lista_ksiazek.get(i).autorzy.get(0).Nazwisko.equals(nazwisko)) {
				ilosc_glowny++;
				continue;
			}
			for (int j = 1; j < lista_ksiazek.get(i).autorzy.size(); j++) {
				if (lista_ksiazek.get(i).autorzy.get(j).Imie.equals(imie)
						&& lista_ksiazek.get(i).autorzy.get(j).Nazwisko.equals(nazwisko)) {
					ilosc_wspolautor++;
				}
			}
		}

		if (ilosc_glowny == 1) {
			System.out
					.println("Autor: " + " " + imie + nazwisko + " jest autorem g³ownym " + ilosc_glowny + " 1ksi¹zki");

		} else {
			System.out
					.println("Autor: " + imie + " " + nazwisko + " jest autorem g³ownym " + ilosc_glowny + " ksi¹¿ek");
		}
		if (ilosc_wspolautor == 1) {
			System.out
					.println("Autor: " + imie + " " + nazwisko + " jest wspó³autorem " + ilosc_wspolautor + " ksi¹¿ki");
		} else {
			System.out
					.println("Autor: " + imie + " " + nazwisko + " jest wspó³autorem " + ilosc_wspolautor + " ksi¹¿ek");
		}

	}

	public static int Wybierz_nr_operacji() {

		int prawda = 1;
		int falsz = -1;
		int czy_wprowadzona_to_liczba;
		int wartosc_wprowadzona = 0;
		int wynik = 0;

		try {
			czy_wprowadzona_to_liczba = Integer.parseInt(scan.nextLine());
			wartosc_wprowadzona = czy_wprowadzona_to_liczba;
			czy_wprowadzona_to_liczba = prawda;
		} catch (Exception e) {
			czy_wprowadzona_to_liczba = falsz;
		}

		if (czy_wprowadzona_to_liczba == 1 && wartosc_wprowadzona < limit_akcji) {
			wynik = wartosc_wprowadzona;
		} else {
			wynik = falsz;
		}
		return wynik;
	}

	public static void Tworzenie_bazy_ksiazek() throws FileNotFoundException {

		boolean flaga = true;

		String[][] Tablica_baza_ksiazek = new String[liczba_rekordow_tabeli][liczba_kolumn_tabeli];

		// Tworzenie pliku
		File plik = new File("Baza_ksiazek.txt");
		String sciezka_pliku = plik.getAbsolutePath();
		System.out.println("Plik jest w: " + sciezka_pliku);
		System.out.println("Czy plik istnieje? : " + plik.exists());

		// czytanie z pliku 7 pkt.
		Scanner odczyt_pliku = new Scanner(plik);

		while (odczyt_pliku.hasNextLine()) {
			if (flaga) {
				liczba_rekordow_tabeli = odczyt_pliku.nextInt();
				odczyt_pliku.nextLine();
				flaga = false;
			} else {
				String linijka = odczyt_pliku.nextLine();
				System.out.println("Linijka: " + linijka);

				String[] tablica = new String[liczba_kolumn_tabeli];
				tablica = linijka.split(", ");

				List<Autor> lista_autorow = new ArrayList<Autor>();

				for (int i = 0; i < 5; i++) {
					String zmienna = tablica[i];

					if (zmienna.equals("0")) {
						break;
					}
					String[] tablica2 = zmienna.split(" ");

					Autor autor = new Autor(liczba_autorow, tablica2[0], tablica2[1]);
					liczba_autorow++;
					lista_autorow.add(autor);

				}

				Ksiazka ksiazka = new Ksiazka(liczba_ksiazek, lista_autorow, tablica[5], Integer.parseInt(tablica[6]),
						Float.parseFloat(tablica[7]), Float.parseFloat(tablica[8]));
				liczba_ksiazek++;
				lista_ksiazek.add(ksiazka);
			}

		}
	}

	public static void main(String[] args) throws FileNotFoundException {
//		Autor autor = new Autor("Jan", "Kowalski", 18);
//		Ksiazka ksiazka = new Ksiazka();

		Tworzenie_bazy_ksiazek();

		int ilosc_kolumn_tablicy = 8;

		while (true) {

			System.out.println("");
			System.out.println("Podaj numer akcji, ktora chcesz wykonac:");
			System.out.println("");
			System.out.println("	1) Dodaj ksiazke do listy");
			System.out.println("	2) Usuñ ksia¿ke z listy");
			System.out.println("	3) Wyœwietl autora z najwieksz¹ ilosci¹ ksi¹¿ek w bibliotece");
			System.out.println("	4) Wyœwietl wszystkie ksi¹¿ki danego autora");
			System.out.println("	5) Œrednia cena ksia¿ek danego autora");
			System.out.println("	6) Wyœwietl wszystkie ksi¹¿ki");
			System.out.println("	7) Wczytaj dane z pliku");
			System.out.println("	8) Zapisz dane z pliku");
			System.out.println("	9) Wyœwietl ksi¹¿ki o padanej liczbie autorów");
			System.out.println("	10) Wyœwietl iloœæ ksi¹¿ek napisany jako autor g³ówny i wspó³autor");
			System.out.println("	11) Wyœwietl najlepiej ocenian¹ ksi¹¿kê");
			System.out.println("	12) Wyœwietl najgorzej ocenian¹ ksi¹¿kê");
			System.out.println("	13) Ksi¹¿ki o ocenie wy¿szej niz podana waroœæ");
			System.out.println("	14) Ksi¹¿ki o ocenie ni¿szej niz podana waroœæ");
			
			System.out.println("");
			System.out.println("	0) Zakoñcz");

			switch (Wybierz_nr_operacji()) {

			case -1:
				System.out.println("Wpisz odpowiedni¹ cyfrê.");
				break;
			case 1:
				Dodaj_ksiazke_do_listy_1();
				break;
			case 2:
				System.out.println("Podaj numer akcji, ktora chcesz wykonac:");
				System.out.println("");
				System.out.println("	1) Usun ksi¹¿kê o podanym tytule");
				System.out.println("	2) Usun wszystkie ksi¹¿ki o podanym tytule");
				System.out.println("	3) Usun ksiazke podanego autora");
				System.out.println("	4) Usun wszystkie ksiazki podanego autora");

				switch (Wybierz_nr_operacji()) {
				case -1:
					System.out.println("Wpisz odpowiedni¹ cyfrê.");
				case 1:
					Usun_ksiazke_o_podanym_tytule2_1();
					break;
				case 2:
					Usun_ksiazki_o_podanym_tytule_2_2();
					break;
				case 3:
					Usun_ksiazke_podanego_autora_2_3();
					break;
				case 4:
					Usun_wszystkie_ksiazki_podanego_autora_2_4();
					break;

				default:
					break;
				}
				System.out.println("");
				break;
			case 3:
				Autor_z_najwieksza_iloscia_ksiazek_3();
				break;
			case 4:
				Wyswietl_wszystkie_ksiazki_danego_autora_4();
				break;
			case 5:
				Oblicz_srednia_cene_ksiazek_autora_5();
				break;
			case 6:
				Wyswietl_wszystkie_ksiazki_6();
				break;
			case 7: // Nie lepiej dane wczytywaæ przy odpaleniu programu?
				System.out.println("");
				break;
			case 8:
				Zapisz_dane_z_pliku_8();
				System.out.println("");
				break;
			case 9:
				Wyswietl_ksiazki_o_podanej_ilosci_autorow_9();
				System.out.println("");
				break;
			case 10:
				Wyswietl_ksia¿ki_jako_glowny_i_wspolautor_10();
				System.out.println("");
				break;
			case 11:
				Najlepiej_oceniana_ksi¹¿ka_11();
				System.out.println("");
				break;
			case 12:
				Najgorzej_oceniana_ksi¹¿ka_12();
				System.out.println("");
				break;
			case 13:
				Ksi¹zka_z_zakresu_oceny_wieksze_od_podanej_wartosci_13();
				System.out.println("");
				break;
			case 14:
				Ksi¹zka_z_zakresu_oceny_mniejsze_od_podanej_wartosci_14();
				System.out.println("");
				break;
			case 0:
				System.out.println("");
				break;

			default:
				break;
			}

		}
	}

}
