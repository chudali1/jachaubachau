/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cab.jachaubachau.dao.impl;

import com.cab.jachaubachau.builder.SymptomsBuilder;
import com.cab.jachaubachau.dao.SymptomsDao;
import com.cab.jachaubachau.dbutil.DbConnection;
import com.cab.jachaubachau.entity.Symptoms;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sagar
 */
public class SymptomsDaoImpl implements SymptomsDao {

    private DbConnection db = new DbConnection();

    @Override
    public List<Symptoms> getAll() throws ClassNotFoundException, SQLException {
        List<Symptoms> symptoms = new ArrayList<>();
        db.open();
        db.init("select * from symptoms");
        ResultSet rs = db.query();
        while (rs.next()) {
            symptoms.add(mapData(rs));

        }
        db.close();
        return symptoms;
    }

    @Override
    public int insert(Symptoms s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "insert into symptoms(s_name)" + "values(?)";
        PreparedStatement stmt = db.init(sql);
        stmt.setString(1, s.getName());

        int result = db.update();
        db.close();
        return result;
    }

    @Override
    public int update(Symptoms s) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "update symptoms set s_name=? where s_sid=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setString(1, s.getName());

        stmt.setInt(2, s.getId());
        int result = db.update();
        db.close();
        return result;
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        db.open();
        String sql = "Delete from symptoms WHERE s_id=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setInt(1, id);
        int result = db.update();
        db.close();
        return result;

    }

    @Override
    public Symptoms getById(int id) throws ClassNotFoundException, SQLException {
     Symptoms symptoms = null;
        db.open();
        db.init("select * from symptoms");
        String sql = "select * from symptoms where s_id=?";
        PreparedStatement stmt = db.init(sql);
        stmt.setInt(1, id);
        ResultSet rs = db.query();
        if (rs.next()) {
            symptoms = mapData(rs);

        }
        db.close();
        return symptoms;    
    }

    private Symptoms mapData(ResultSet rs) throws SQLException {
        return SymptomsBuilder.create()
                .setId(rs.getInt("s_id"))
                .setName(rs.getString("s_name"))
                .build();

    }

}
