package dao;

import factory.ConnectionFactory;
import modelo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    private Connection connection;

    public UserDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(User usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone) VALUES(?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(4, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
