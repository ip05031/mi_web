/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.Donaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author IPalacios
 */
@Stateless
public class DonacionesFacade extends AbstractFacade<Donaciones> {

    @PersistenceContext(unitName = "TesisPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonacionesFacade() {
        super(Donaciones.class);
    }
    
}
