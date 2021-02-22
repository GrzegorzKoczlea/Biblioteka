import java.util.ArrayList;
import java.util.List;

public class Ksiazka {
	int ID_ksiazki;
	List<Autor> autorzy; 
	String tytul;
	int rok_wydania;
	float cena;
	float ocena;
	
	public Ksiazka() {
		
	}
	
	public Ksiazka(int iD_ksiazki, List<Autor> autorzy, String tytul, int rok_wydania, float cena, float ocena) {
		ID_ksiazki = iD_ksiazki;
		this.autorzy = autorzy;
		this.tytul = tytul;
		this.rok_wydania = rok_wydania;
		this.cena = cena;
		this.ocena = ocena;
	}
}
