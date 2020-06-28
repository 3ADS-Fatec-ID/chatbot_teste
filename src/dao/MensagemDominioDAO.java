package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import model.MensagemDominio;

public class MensagemDominioDAO extends DAO {
    
    private MensagemDominio mensagemDominio;
    
    public MensagemDominioDAO(MensagemDominio mensagemDominio) {
        this.mensagemDominio = mensagemDominio;
    }
    
    public MensagemDominioDAO() {
        super();
    }
    
    public MensagemDominio findMessage() {
        String sql = "select * from mensagem_dominio where id_Progresso = ? and id_Tipo_Mensagem_Dominio = ?";
        bd.getConnection();
        
        ArrayList<MensagemDominio> md = new ArrayList<>();
        
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setInt(1, mensagemDominio.idProgesso);
            bd.st.setInt(2, mensagemDominio.idTipoMensagemDominio);
            bd.rs = bd.st.executeQuery();
            
            while (bd.rs.next()) {
                md.add(new MensagemDominio(
                        bd.rs.getString("corpoMensagemDominio"),
                        bd.rs.getInt("id_Tipo_Mensagem_Dominio"),
                        bd.rs.getInt("id_Progresso")));
            }
            
            int index = ThreadLocalRandom.current().nextInt(0, md.size());
            
            return md.get(index);
        } catch (SQLException e) {
            return null;
        } finally {
            bd.close();
        }
    }
    
    public MensagemDominio findMessage(String nomeProgresso) {
        String sql = "select * from Mensagem_Dominio md, Progresso p where md.id_Progresso = p.id and p.nomeProgresso = ?";
        bd.getConnection();
        
        ArrayList<MensagemDominio> md = new ArrayList<>();
        
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, nomeProgresso);
            bd.rs = bd.st.executeQuery();
            
            while (bd.rs.next()) {
                md.add(new MensagemDominio(
                        bd.rs.getString("corpoMensagemDominio"),
                        bd.rs.getInt("id_Tipo_Mensagem_Dominio"),
                        bd.rs.getInt("id_Progresso")));
            }
            
            int index = ThreadLocalRandom.current().nextInt(0, md.size());
            
            return md.get(index);
        } catch (SQLException e) {
            return null;
        } finally {
            bd.close();
        }
    }
    
    public ArrayList<MensagemDominio> listMessage(String nomeProgresso) {
        String sql = "select * from Mensagem_Dominio md, Progresso p where md.id_Progresso = p.id and p.nomeProgresso = ?";
        bd.getConnection();
        
        ArrayList<MensagemDominio> md = new ArrayList<>();
        
        try {
            bd.st = bd.con.prepareStatement(sql);
            bd.st.setString(1, nomeProgresso);
            bd.rs = bd.st.executeQuery();
            
            while (bd.rs.next()) {
                md.add(new MensagemDominio(
                        bd.rs.getString("corpoMensagemDominio"),
                        bd.rs.getInt("id_Tipo_Mensagem_Dominio"),
                        bd.rs.getInt("id_Progresso")));
            }
            
            return md;
        } catch (SQLException e) {
            return null;
        } finally {
            bd.close();
        }
    }
}
