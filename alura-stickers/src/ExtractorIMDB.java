import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtractorIMDB implements ContentExtractor {
    public List<Content> extractContents(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);

        List<Content> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {

            String title = atributos.get("title").replaceAll("\\:", "");
            String imageURL = atributos.get("image");
            var conteudo = new Content(title, imageURL);

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
