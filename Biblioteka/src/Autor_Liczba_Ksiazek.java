
public class Autor_Liczba_Ksiazek {
	Autor autor;
	public int liczba_ksiazek;
	
	public Autor_Liczba_Ksiazek(Autor autor) {
		super();
		liczba_ksiazek = 0;
		this.autor = autor;
	}
	
	public void Liczba_ksiazek_plus(){
		liczba_ksiazek++;
	}
}
