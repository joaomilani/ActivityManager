package aplicationmanager;

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
    public ArrayList<Cliente> lsCliente;
    public ArrayList<TipoAtividade> lsTipoAtividade;
    public ArrayList<Processo> lsProcesso;

    //Carrega XLS recebendo o endereço do arquivo
    public ImportXLS() {

    }

    public void build(String path) {

        this.file = new File(path);
        try {
            
            //Trecho seta o file input stream todas as vezes pois 
            //caso não o faça recebemos o erro ChannelClose
            
            this.fisFile = new FileInputStream(file);
            this.lsCliente = this.getClientes();
            
            this.fisFile = new FileInputStream(file);
            this.lsTipoAtividade = this.getTipoAtividade();
            
            this.fisFile = new FileInputStream(file);
            this.lsProcesso = this.getProcesso();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ImportXLS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ImportXLS.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<Cliente> getClientes() throws IOException {

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
    
    public ArrayList<TipoAtividade> getTipoAtividade() throws IOException {

        //Cliente cliente = new Cliente();
        ArrayList<TipoAtividade> array = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(fisFile);

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
    
    
    public ArrayList<Processo> getProcesso() throws IOException {

        //Cliente cliente = new Cliente();
        ArrayList<Processo> array = new ArrayList<>();

        HSSFWorkbook workbook = new HSSFWorkbook(fisFile);

        //Busca a aba pelo nome
        HSSFSheet sheet = workbook.getSheet("Processos");

        Row row;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Processo processo = new Processo();
            array.add(processo);
            row = sheet.getRow(i);

            for (int y = 0; y < row.getLastCellNum(); y++) {

                switch (y) {

                    case 0:
                        array.get(i - 1).setIdProcesso(
                                (int) sheet.getRow(i).getCell(y).getNumericCellValue());
                    case 1:
                        array.get(i - 1).setNomeProcesso(
                                sheet.getRow(i).getCell(y).toString());
                    //cliente.setNomeCliente(sheet.getRow(i).getCell(y).toString());
                }

            }

        }

        return array;

    }

    /**
     * @return the lsCliente
     */
    public ArrayList<Cliente> getLsCliente() {
        return lsCliente;
    }

    /**
     * @return the lsTipoAtividade
     */
    public ArrayList<TipoAtividade> getLsTipoAtividade() {
        return lsTipoAtividade;
    }
    
    public ArrayList<Processo> getLsProcesso() {
        return lsProcesso;
    }

}
