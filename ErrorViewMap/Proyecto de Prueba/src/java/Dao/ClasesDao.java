/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import logica.HibernateUtil;
import modelo.Alumno;
import org.hibernate.Hibernate;
import org.hibernate.Session;

/**
 *
 * @author luis
 */
public class ClasesDao {

    private int idAlumno;
    private String ANombre;
    private String AContrasenha;
    private String ACorreo;

    public void indroducirAlumno(int idAlumno, String nombre, String contrasena, String corro) {

        Session session = confHibenate.getSessionFactory().getCurrentSession();
        
        Alumno n = new Alumno();
        n.setIdAlumno(idAlumno);
        n.setANombre(ANombre);
        n.setAContrasenha(AContrasenha);
        n.setACorreo(ACorreo);
        
        try {
            session.beginTransaction();
            session.save(n);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error del dao");
            session.getTransaction().rollback();
        }
    }
    public void indroducirAlumno( String nombre, String contrasena, String corro) {

        Session session = HibernateUtil.getSessionFactory().openSession(); 
        
        Alumno n = new Alumno();
        
        n.setANombre(ANombre);
        n.setAContrasenha(AContrasenha);
        n.setACorreo(ACorreo);
        
        try {
            session.beginTransaction();
            session.save(n);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("error del dao");
            session.getTransaction().rollback();
        }
    }
    

}
