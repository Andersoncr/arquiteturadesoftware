package br.usjt.arqsw.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author Anderson
 *
 */
public class ChamadoDAO {
	/**
	 * @param fila Pega dados do banco
	 * @return Carrega a lista de chamados
	 */
	public ArrayList<Chamado> listarChamados(Fila fila) throws IOException {
		String query = "select chamado, descricao, status, dt_abertura, dt_fechamento, id_fila from chamado where id_fila  = "+ fila.getId();
		ArrayList<Chamado> lista = new ArrayList<>();
		try(Connection conn = ConnectionFactory.getConnection();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next()) {
				DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
				Chamado chamado = new Chamado();
				chamado.setId(rs.getInt("chamado"));
				chamado.setDescricao(rs.getString("descricao"));
				chamado.setStatus(rs.getString("status"));
				chamado.setFila(rs.getInt("id_fila"));
				chamado.setDt_Abertura(formatDate.format(rs.getDate("dt_abertura")));
				if(rs.getDate("dt_fechamento") != null) {
					chamado.setDt_Fechamento(formatDate.format(rs.getDate("dt_fechamento")));
				}
				
				lista.add(chamado);
			}
			
		} catch (SQLException e) {
			throw new IOException(e);
		}
		return lista;
	}

}