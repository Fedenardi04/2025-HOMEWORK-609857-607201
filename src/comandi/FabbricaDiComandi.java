package comandi;


public interface FabbricaDiComandi {
	public AbstractComando costruisciComando(String istruzione) throws Exception;
}
