package aplicationmanager;

import java.util.Date;


public class Atividade {

    Cliente cliente;
    private Date iniDate;
    private Date endDate;
    
    Atividade(){
    
        this.cliente = new Cliente();
        
        
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the iniDate
     */
    public Date getIniDate() {
        return iniDate;
    }

    /**
     * @param iniDate the iniDate to set
     */
    public void setIniDate(Date iniDate) {
        this.iniDate = iniDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    

    
}
