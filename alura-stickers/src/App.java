import java.io.File;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexão http e buscar os top 250 filmes

        // String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";
        // String url = "https://api.mocki.io/v2/549a5d8b/Top250Movies";
        String url = "http://localhost:8080/languages";

        var http = new HTTPClient();
        var json = http.buscaDados(url);
        // pegar apenas dados que nos interessão (titulo, poster, classificação)

        // exibir e manipular dados
        var gerador = new StickerFactory();

        ContentExtractor extrator = new ExtractorIMDB();

        List<Content> conteudos = extrator.extractContents(json);

        for (int i = 0; i < 3; i++) {

            Content conteudo = conteudos.get(i);

            System.out.println(conteudo.getTitle());
            gerador.create(new URL(conteudo.getImageURL()).openStream(),
                    new File("saida/" + conteudo.getTitle() + ".png"));
        }

    }
}
