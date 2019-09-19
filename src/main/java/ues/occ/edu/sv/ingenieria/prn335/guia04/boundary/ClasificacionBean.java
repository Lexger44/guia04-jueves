/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ues.occ.edu.sv.ingenieria.prn335.guia04.boundary;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import ues.occ.edu.sv.ingenieria.prn335.cinedata.entity.Clasificacion;

/**
 *
 * @author mauricio
 */
public class ClasificacionBean {
        protected EntityManager em;
    final static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("cinePU");

    public void iniciarEm() {
        this.em = EMF.createEntityManager();
    }

    public EntityTransaction getTx() {
        if (this.em != null) {
            return this.em.getTransaction();
        }
        return null;
    }

    public void crear(Clasificacion r) {
        EntityTransaction tx = this.getTx();
        tx.begin();
        this.em.persist(r);
        tx.commit();

    }

    public void modificar(Clasificacion r) {

        EntityTransaction tx = this.getTx();
        tx.begin();
        em.merge(r);
        tx.commit();

    }
    
    public void eliminar(Clasificacion r){
    EntityTransaction tx=this.getTx();
    tx.begin();
    em.remove(r);
    tx.commit();
    }
    
}
