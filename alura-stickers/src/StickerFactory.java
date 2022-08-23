import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class StickerFactory {

    public void create(InputStream image, File output) throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(image);

        // cria uma nóva imagem em memoria com tranparencia e tamanho novo
        int width = imagemOriginal.getWidth();
        int height = imagemOriginal.getHeight();
        int newHeight = height + 200;

        BufferedImage novaImagem = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

        // copiar a imagem original para a nova imagem
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
        graphics.setFont(font);

        // escrever uma frase na nova imagem
        graphics.setColor(Color.YELLOW);
        graphics.drawString("Topzera", 100, newHeight - 45);

        // escrever em um arquivo
        ImageIO.write(novaImagem, "png", output);
    }

    public static void main(String[] args) throws Exception {
        var gerador = new StickerFactory();

        gerador.create(new URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_1.jpg").openStream(),
                new File("saida/figurinha.png"));
    }
}
