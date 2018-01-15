
package aplicationmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AplicationManager {

    public static void main(String[] args) throws IOException {


//        Atividade a1 = new Atividade();
        
//        a1.cliente.setIdCliente(1);
//        a1.cliente.setNomeCliente("CLIENTE TESTE");
        
//        System.out.println(a1.cliente.getIdCliente().toString()+" "+a1.cliente.getNomeCliente());
        
        
        ImportXLS ixls = new ImportXLS();
        
        ixls.LoadXLS("BaseActivityFile.xls");   
        
        List<Cliente> list = ixls.ReadClientes();
        
        System.out.println(list.get(1).getNomeCliente());
        System.out.println(list.get(1).getIdCliente().toString());
        
        //Cliente cliente = new Cliente();
        
        //cliente.setIdCliente(list.get(0).getIdCliente());
                
        //System.out.println(cliente.getIdCliente().toString());        
        
        //System.out.println(list.get(0).getNomeCliente());
        
        
        
        
        
    }
    
}
