import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitorMapa {
    private int linhas;
    private int colunas;

    public char[][] getMapa(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String[] dimensoes = reader.readLine().split(" ");
            this.linhas = Integer.parseInt(dimensoes[0]);
            this.colunas = Integer.parseInt(dimensoes[1]);

            char[][] mapa = new char[linhas][colunas];

            for (int x = 0; x < linhas; x++) {
                String line = reader.readLine();
                for (int y = 0; y < colunas; y++) {
                    char ch = line.charAt(y);
                    mapa[x][y] = ch;
                }
            }

            reader.close();
            return mapa;
        } catch (IOException e) {
            return null;
        }
    }

    public int getLinhas(){
        return linhas;
    }

    public int getColunas(){
        return colunas;
    }
}