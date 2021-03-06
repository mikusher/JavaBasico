/*
 * Copyright (C) 2017 Luis Tavares
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 */





package cv.mikusher.agenda.classe.sqlClass;





import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

import cv.mikusher.agenda.classe.LoggOperation;





/**
 *
 * @author Luis Amilcar Tavares
 */
public class OperacoesSQL_Postgres extends ConnectionToSQL {

    /**
     * 
     */
    public static void createNewDatabase() {

        try (Connection conn = connect("psql")) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                LoggOperation.LOGGER.log(Level.INFO, "O Drive usado \u00e9{0}", meta.getDriverName());
                LoggOperation.LOGGER.log(Level.INFO, "Base de dados {0} criado com sucesso.", GENERAL_TABLE);
            }

        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }
    }





    /**
     * Criar uma nova Tabela com os parametros da base de dados e a tabela
     * 
     * @param_dataBaseName
     *                     indica a base de dados que sera chamada para efetuar a operação
     * @param_tableName
     */
    public static void createNewTable() {

        // SQLite conexão com a base de dados
        try (Connection conn = connect("psql"); Statement stmt = conn.createStatement()) {
            // executando a query
            stmt.execute(psqlCreateTable);
        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }
        LoggOperation.LOGGER.log(Level.INFO, "Tabela {0} criado na base de dados " + DATABASE_NAME + " com sucesso!!", GENERAL_TABLE);
    }





    /**
     * Para o inserta das informações na tabela, tem de passar alguns dados!!
     * 
     * @param uuid
     * @param id
     * @param nome
     * @param idade
     * @param endereco
     * @param_dataBaseName
     *                     indica a base de dados que sera chamada para efetuar a operação
     * @param_GENERAL_TABLE
     *                      o nome da tabela a ser utilizado
     * @param_nome
     *             o nome do contato
     * @param_idade
     *              a idade do contato
     * @param_telefone
     *                 o numero de telefone do contato
     */
    public static void insert(String uuid, Integer id, String nome, Integer idade, String endereco) {

        try (Connection conn = connect("psql");

                        PreparedStatement pstmt = conn.prepareStatement(psqlInsert)) {
            pstmt.setString(1, uuid);
            pstmt.setInt(2, id);
            pstmt.setString(3, nome);
            pstmt.setInt(4, idade);
            pstmt.setString(5, endereco);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }

        // se não quiser uma resposta por cada linha inserida, comenta esse print!!
        LoggOperation.LOGGER.info("Linha inserida com sucesso!");
        // System.out.println("Linha inserida com sucesso!");
    }





    public static void deleteSQLUser(Integer id) {

        try (Connection conn = connect("psql"); PreparedStatement pstmt = conn.prepareStatement(psqlDelete)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }
        LoggOperation.LOGGER.info("Linha apagado com sucesso.!");
    }





    public static void updateUser(int id, String nome, int idade, String endereco) {

        try (Connection conn = connect("psql"); PreparedStatement pstmt = conn.prepareStatement(psqlUpdate)) {

            // set the corresponding param
            pstmt.setString(1, nome);
            pstmt.setInt(2, idade);
            pstmt.setString(3, endereco);
            pstmt.setInt(4, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }
        LoggOperation.LOGGER.info("Linha atualizado com sucesso!");
    }





    /**
     * 
     * @param name
     * @param password
     * @param_name
     * @param_password
     */
    public static void insertUsers(String name, String password) throws Exception {

        String criptPass = CriptoLogin.encrypt(name, password);
        try (Connection conn = connect("psql");

                        PreparedStatement pstmt = conn.prepareStatement(queryNewUSERS)) {
            pstmt.setString(1, name);
            pstmt.setString(2, criptPass);
            pstmt.executeQuery();

        } catch (SQLException e) {
            LoggOperation.LOGGER.warning(e.getMessage());
        }

        // se não quiser uma resposta por cada linha inserida, comenta esse print!!
        LoggOperation.LOGGER.info("Novo utilizaror de Login criado com sucesso!");
    }





    public static void deleteUsersLogin(String username) throws SQLException {

        Connection conn = connect("psql");
        PreparedStatement pstmt = conn.prepareStatement(queryDeleteUSERS);
        pstmt.setString(1, username);
    }
}
