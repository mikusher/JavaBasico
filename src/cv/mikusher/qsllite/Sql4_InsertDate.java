/*
 * Copyright (C) 2016 Miky Mikusher Wayne
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * D:\sqlite-jdbc-3.8.11.2.jar
 */





package cv.mikusher.qsllite;





import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;





/**
 *
 * @author Miky Mikusher Wayne
 */
public class Sql4_InsertDate {

    /**
     * Conectar com a Base de Dados Agenda.s3db
     *
     * @param dataBaseName
     *            indica a base de dados que sera chamada para efetuar a operação
     * @return the Connection object
     */
    private Connection connect(String dataBaseName) {

        // SQLite connection string
        String url = "jdbc:sqlite:src/cv/mikusher/qsllite/BaseDados/" + dataBaseName;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }





    /**
     * Para o inserta das informações na tabela, tem de passar alguns dados!!
     * 
     * @param dataBaseName
     *            indica a base de dados que sera chamada para efetuar a operação
     * @param tableToInsert
     *            o nome da tabela a ser utilizado
     * @param nome
     *            o nome do contato
     * @param idade
     *            a idade do contato
     * @param telefone
     *            o numero de telefone do contato
     */
    public void insert(String dataBaseName, String tableToInsert, String nome, Integer idade, Integer telefone) {

        String sql = "INSERT INTO " + tableToInsert + "(nome,idade,telefone) VALUES(?,?,?)";

        try (Connection conn = this.connect(dataBaseName);

                        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setInt(2, idade);
            pstmt.setInt(3, telefone);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // se não quiser uma resposta por cada linha inserida, comenta esse print!!
        System.out.println("Linha inserida com sucesso!");
    }





    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        Sql4_InsertDate app = new Sql4_InsertDate();

        // inserir quatro linhas na tabela
        app.insert("Agenda.s3db", "utilizadores", "Luis Tavares", 28, 92555656);
        app.insert("Agenda.s3db", "utilizadores", "Miky Mikusher", 20, 924555656);
        app.insert("Agenda.s3db", "utilizadores", "Helio", 22, 92955886);
        app.insert("Agenda.s3db", "utilizadores", "Luis Amilcar", 25, 92599886);

    }

}
