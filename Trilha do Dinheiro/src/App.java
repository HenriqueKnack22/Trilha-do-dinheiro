public class App {
    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        try {
            //Alterar o nome de acordo com o nome do mapa
            AcmeMapa acmeMapa = new AcmeMapa("casoG50.txt");
            System.out.println("Somatório: " + acmeMapa.getSomatorio());
            long endTime = System.nanoTime();
            double totalTime = (endTime - startTime)/1000000000.0;
            System.out.println("Tempo de execução: "+ totalTime);
        } catch (Exception e) {
            System.out.println("Mapa inválido");
        }
    }
}
