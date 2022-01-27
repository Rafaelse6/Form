/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Curso;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafa0
 */
public class CursoDAO {
    private Conexao conexao;
    private Connection conn;
    
    //Constructor class
    public CursoDAO(){
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public void inserir(Curso curso){
        String sql = "INSERT INTO cursos(nomecurso,nivel,duracao) VALUES " + "(?,?,?)";
        
        try {
              PreparedStatement stmt = this.conn.prepareStatement(sql);
              stmt.setString(1, curso.getNomecurso());
              stmt.setString(2, curso.getNivel());
              stmt.setInt(3, curso.getDuracao());
              stmt.execute();
              
        } catch (Exception e) {
            
            System.out.println("Erro ao inserir curso: " + e.getMessage());
        }
        
    }
    
    public void editar(Curso curso){
        String sql = "UPDATE cursos SET nomecurso=?, nivel=?, duracao=? WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, curso.getNomecurso());
            stmt.setString(2, curso.getNivel());
            stmt.setInt(3, curso.getDuracao());
            stmt.setInt(4,curso.getId());
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao editar curso: " + e.getMessage());
        }
    }
    
    public void excluir(int id){
        String sql = "DELETE FROM cursos WHERE id=?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch (Exception e) {
            System.out.println("Erro ao excluir curso" + e.getMessage());
        }
    }
    
    public Curso getCurso(int id){
        String sql = "SELECT * FROM cursos WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            Curso curso = new Curso();
            rs.first();
            curso.setId(id);
            curso.setNomecurso(rs.getString("nomecurso"));
            curso.setNivel(rs.getString("nivel"));
            curso.setDuracao(rs.getInt("duracao"));
            
            return curso;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Curso> getCursos(String nomecurso){
        String sql = "SELECT * FROM cursos WHERE nomecurso LIKE ?";
        try {
            PreparedStatement stmt = this.conn.prepareStatement(sql);
            stmt.setString(1, "%" + nomecurso + "%");
            ResultSet rs = stmt.executeQuery();
            List<Curso> listaCursos = new ArrayList<>();
            
            while(rs.next()){
                Curso curso = new Curso();
                curso.setId(rs.getInt("id"));
                curso.setNomecurso(rs.getString("nomecurso"));
                curso.setNivel(rs.getString("nivel"));
                curso.setDuracao(rs.getInt("duracao"));
                
                listaCursos.add(curso); 
                
            }
            
            return listaCursos;
        } catch (Exception e) {
            return null;
        }
    }
}
