package testpackage;

import aplicationmanager.TipoAtividade;
import java.io.IOException;
import java.util.List;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joao
 */
public class Teste {
    
    public static void main(String args[]) throws IOException{
    
    ImportXLS xls = new ImportXLS();
    
    xls.build("/home/joao/Projetos/ActivityManager/BaseActivityFile.xls");
    
    List<TipoAtividade> listaTipoAtividade;
    
    listaTipoAtividade = xls.getTipoAtividade();
    
    for(TipoAtividade a : listaTipoAtividade){
        System.out.println(a.getIdTipo().toString()+" "+a.getNomeTipo());
    }
    
    
   TestFrame mf = new TestFrame();
   
   mf.setVisible(true);
    
    
    }
    
}
