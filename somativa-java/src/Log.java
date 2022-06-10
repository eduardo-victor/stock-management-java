import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.DataTruncation;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Log {

    Date data = new Date();
    SimpleDateFormat formatar = new SimpleDateFormat("hh:mm dd/MM/yyyy");
    String dataFormatada = formatar.format(data);
    public void criarLog(ArrayList<String> lista) throws IOException {
        Path caminho = Paths.get("C:\\Users\\viedu\\OneDrive\\Área de Trabalho\\stock-management-java\\somativa-java\\Log.txt");
        if (Files.exists(caminho)){
            Files.write(caminho,lista, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }else {
            Files.write(caminho,lista, StandardCharsets.UTF_8);
        }
    }

}
