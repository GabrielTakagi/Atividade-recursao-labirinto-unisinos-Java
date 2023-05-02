

public class PrincipalLabirinto {
    public static void main(String[] args) throws Exception {
        Labirinto labirinto = new Labirinto();

        labirinto.carregaLabirinto("labirinto.txt");
        labirinto.verificarLabirinto();
        labirinto.escreverTxt();
    }

}
