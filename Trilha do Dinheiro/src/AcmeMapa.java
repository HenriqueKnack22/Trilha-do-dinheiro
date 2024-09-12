public class AcmeMapa {
    private LeitorMapa leitor;
    private char[][] mapa;
    private int linhas;
    private int colInicial;
    private int linInicial; 

    public AcmeMapa(String nomeArquivo) {
        leitor = new LeitorMapa();
        mapa = leitor.getMapa(nomeArquivo);
        linhas = leitor.getLinhas();
        colInicial = 0;
        linInicial = buscaLinInicial();
    }

    private int buscaLinInicial(){
        for(int x = 0; x < linhas; x++){
            if(mapa[x][colInicial] == '-')
                return x;
        }
        return -1;
    }

    public long getSomatorio(){
        long somatorio = 0;
        int x = linInicial;
        int y = colInicial; 
        char charAtual = mapa[x][y];
        String numeroAtual = "";
        char direcao = 'L';


        while (charAtual != '#') {

            //Valida se char atual e um numero e o cancatena em uma string, que sera adicionada ao somatorio quando o char atual terminar de ler o numero
            if(Character.isDigit(charAtual)){
                numeroAtual += charAtual;
            }
            else if(!numeroAtual.equals("")){
                somatorio += Long.parseLong(numeroAtual);
                numeroAtual = "";
            }

            //Verifica se char atual representa uma mudança de direção
            if (charAtual == '/' || charAtual == '\\') {
                switch (direcao) {
                    case 'L':
                        if (charAtual == '/') {
                            direcao = 'N';
                        }
                        else {
                            direcao = 'S';
                        }
                        break;

                    case 'O':
                        if (charAtual == '/') {
                            direcao = 'S';
                        }
                        else {
                            direcao = 'N';
                        }
                        break;
                    
                    case 'N':
                        if (charAtual == '/') {
                            direcao = 'L';
                        }
                        else {
                            direcao = 'O';
                        }
                        break;

                    case 'S':
                        if (charAtual == '/') {
                            direcao = 'O';
                        }
                        else {
                            direcao = 'L';
                        }
                        break;
                }
            }

            //Atualiza a posição do char atual

            switch (direcao) {
                case 'N':
                    x--;
                    break;
                case 'S':
                    x++;
                    break;
                case 'L':
                    y++;
                    break;
                case 'O':
                    y--;
                    break;
            }

            charAtual = mapa[x][y];
        }

        if(!numeroAtual.equals(""))
            somatorio += Long.parseLong(numeroAtual);

        return somatorio;
    }
}
