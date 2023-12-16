package com.mycompany.ivr.Persistencia;

import com.mycompany.ivr.Clases.Encuesta;
import com.mycompany.ivr.Clases.Llamada;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class Persistencia {
    EntityManager em;

    public Persistencia(EntityManager em){
        this.em = em;
    }

    public List<Llamada> materializarLlamadas(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Llamada> cq = cb.createQuery(Llamada.class);
        Root<Llamada> root = cq.from(Llamada.class);

        cq.select(root);

        TypedQuery<Llamada> query = em.createQuery(cq);
        return query.getResultList();
    }

    public List<Encuesta> materializarEncuestas(){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Encuesta> cq = cb.createQuery(Encuesta.class);
        Root<Encuesta> root = cq.from(Encuesta.class);

        cq.select(root); // Se levantan en memoria todas las encuestas.

        TypedQuery<Encuesta> query = em.createQuery(cq);
        return query.getResultList();
    }
}
