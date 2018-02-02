/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicationmanager;

/**
 *
 * @author joao
 */
public class Processo {

    private Integer idProcesso;
    private String nomeProcesso;

    /**
     * @return the idProcesso
     */
    public Integer getIdProcesso() {
        return idProcesso;
    }

    /**
     * @param idProcesso the idProcesso to set
     */
    public void setIdProcesso(Integer idProcesso) {
        this.idProcesso = idProcesso;
    }

    /**
     * @return the nomeProcesso
     */
    public String getNomeProcesso() {
        return nomeProcesso;
    }

    /**
     * @param nomeProcesso the nomeProcesso to set
     */
    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    @Override
    public String toString() {
        return this.getNomeProcesso();
    }

}
