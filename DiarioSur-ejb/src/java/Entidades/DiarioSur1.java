/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author diego
 */
public class DiarioSur1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   EntityManagerFactory emf = Persistence.createEntityManagerFactory("DiarioSur1PU"); // Poner dentro el nombre que tenga persistence 
        EntityManager em = emf.createEntityManager();

        
        em.close();
        emf.close();
    }
    
}
