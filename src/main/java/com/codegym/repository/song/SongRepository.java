package com.codegym.repository.song;

import com.codegym.model.Song;
import com.codegym.repository.song.ISongRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SongRepository implements ISongRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Song> findAll() {
        TypedQuery<Song> query = em.createQuery("select s from Song s", Song.class);
        return query.getResultList();
    }

    @Override
    public Song findById(Long id) {
        TypedQuery<Song> query = em.createQuery("select c from Song c where c.id=:id", Song.class);
        query.setParameter("id", id);
        try{
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }

    }

    @Override
    public void save(Song song) {
        em.merge(song);
    }

    @Override
    public void remove(Long id) {
        Song song = findById(id);
        if (song != null){
            em.remove(song);
        }
    }

}