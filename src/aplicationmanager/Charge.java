/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicationmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class Charge {

    ImportXLS ixls;
    private List<Cliente> list;

    public Charge() throws IOException {

        this.ixls = new ImportXLS();
        //ixls.LoadXLS();
        this.list = new ArrayList<>();
    }

    public void ChargeFile(String path){
        this.ixls.LoadXLS(path);
    }
    
    public void LoadClients() throws IOException {

        this.getList().addAll(this.ixls.ReadClientes());

    }

    /**
     * @return the list
     */
    public List<Cliente> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<Cliente> list) {
        this.list = list;
    }

}
