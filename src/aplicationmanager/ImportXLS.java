package aplicationmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ImportXLS {

    File file;
    FileInputStream fisFile;

    //Carrega XLS recebendo o endereço do arquivo
    public void LoadXLS(String path) {

        this.file = new File(path);
        try {
            this.fisFile = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportXLS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Cliente> ReadClientes() throws IOException {

        //Cliente cliente = new Cliente();
        ArrayList<Cliente> array = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(fisFile);

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

}
