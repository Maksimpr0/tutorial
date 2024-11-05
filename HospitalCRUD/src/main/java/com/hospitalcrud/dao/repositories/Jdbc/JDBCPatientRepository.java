package com.hospitalcrud.dao.repositories.Jdbc;

import com.hospitalcrud.dao.mappers.jdbc.JdbcMapper;
import com.hospitalcrud.dao.model.Patient;
import com.hospitalcrud.dao.repositories.Jdbc.utils.DBConnection;
import com.hospitalcrud.dao.repositories.Jdbc.utils.SQLQueries;
import com.hospitalcrud.dao.repositories.PatientRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
@Profile("enDesarrollo")
public class JDBCPatientRepository implements PatientRepository {

    private final DBConnection dbConnection;
    private final JdbcMapper jdbcMapper = new JdbcMapper();

    public JDBCPatientRepository(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }


    @Override
    public List<Patient> getAll() {

        try (Connection con = dbConnection.getConnection();
             Statement statement = con.createStatement() ){

            ResultSet rs = statement.executeQuery(SQLQueries.SELECT_patients_QUERY);



        return jdbcMapper.readRS(rs);
             } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public int add(Patient patient) {
        int rowsAffected=0;
        try (Connection con = dbConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQLQueries.INSERT_patient_WITH_AUTOINCREMENTAL_ID,
                     Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setDate(2, Date.valueOf(patient.getBirthDate()));
            preparedStatement.setString(3, patient.getPhone());


            rowsAffected= preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs.next()) {
                int auto_id = rs.getInt(1);
                System.out.println("The id of the new row is "+auto_id);
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowsAffected;

    }

    @Override
    public void delete(int patientId, boolean confirm) {

        try (Connection con = dbConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQLQueries.DELETE_patient)) {
            preparedStatement.setInt(1, patientId);
            // executeUpdate method for INSERT, UPDATE and DELETE
            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            Logger.getLogger(JDBCPatientRepository.class.getName()).log(Level.SEVERE, null, sqle);
        }

    }

    @Override
    public void update(Patient patient) {

        try (Connection con = dbConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(SQLQueries.UPDATE_patient)) {
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setDate(2, Date.valueOf(patient.getBirthDate()));
            preparedStatement.setString(3, patient.getPhone());
            preparedStatement.setInt(4,patient.getId());
            // executeUpdate method for INSERT, UPDATE and DELETE
            preparedStatement.executeUpdate();

        } catch (SQLException sqle) {
            Logger.getLogger(JDBCPatientRepository.class.getName()).log(Level.SEVERE, null, sqle);
        }
    }
}
