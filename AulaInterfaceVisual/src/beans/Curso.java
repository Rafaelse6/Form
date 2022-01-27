/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author rafa0
 */
public class Curso {
    
    private int id;
    private String nomecurso;
    private String nivel;
    private int duracao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomecurso() {
        return nomecurso;
    }

    public void setNomecurso(String nomecurso) {
        this.nomecurso = nomecurso;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public String toString(){
        return this.nomecurso;
    }
       
    public boolean equals(Object objeto){
        Curso c = (Curso) objeto;
        if(this.id == c.getId()){
            return true;
        }else{
            return false;
        }
    }
}
