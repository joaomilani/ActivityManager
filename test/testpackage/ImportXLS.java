package testpackage;


import aplicationmanager.Cliente;
import aplicationmanager.TipoAtividade;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

public class ImportXLS {

    File file;
    FileInputStream fisFile;
    HSSFWorkbook workbook;
    
    
    
    //Carrega XLS recebendo o endereço do arquivo
    public ImportXLS() {

    }

    public void build(String path) throws IOException {

        this.file = new File(path);
        try {
            this.fisFile = new FileInputStream(file);
            this.workbook = new HSSFWorkbook(this.fisFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportXLS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

    }

    public ArrayList<Cliente> getClientes() throws IOException {

        //Cliente cliente = new Cliente();
        ArrayList<Cliente> array = new ArrayList<>();

        //Busca a aba pelo nome
        HSSFSheet sheet = workbook.getSheet("Clientes");

        Row row;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Cliente cliente = new Cliente();
            array.add(cliente);
            row = sheet.getRow(i);

            for (int y = 0; y < row.getLastCellNum(); y++) {

                switch (y) {

                    case 0:
                        array.get(i - 1).setIdCliente(
                                (int) sheet.getRow(i).getCell(y).getNumericCellValue());
                    case 1:
                        array.get(i - 1).setNomeCliente(
                                sheet.getRow(i).getCell(y).toString());
                    //cliente.setNomeCliente(sheet.getRow(i).getCell(y).toString());
                }

            }

        }

        return array;

    }
    
    public ArrayList<TipoAtividade> getTipoAtividade() throws IOException {

        //Cliente cliente = new Cliente();
        ArrayList<TipoAtividade> array = new ArrayList<>();
        
//        System.out.println(this.fisFile.getChannel().toString());


        //Busca a aba pelo nome
        HSSFSheet sheet = workbook.getSheet("Tipo Atividade");

        Row row;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            TipoAtividade tipoatividade = new TipoAtividade();
            array.add(tipoatividade);
            row = sheet.getRow(i);

            for (int y = 0; y < row.getLastCellNum(); y++) {

                switch (y) {

                    case 0:
                        array.get(i - 1).setIdTipo(
                                (int) sheet.getRow(i).getCell(y).getNumericCellValue());
                    case 1:
                        array.get(i - 1).setNomeTipo(
                                sheet.getRow(i).getCell(y).toString());
                    //cliente.setNomeCliente(sheet.getRow(i).getCell(y).toString());
                }

            }

        }

        return array;

    }

}
