package com.codegym.service.song;

import com.codegym.model.Song;
import com.codegym.repository.song.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;

    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public Song findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public void save(Song model) {
        songRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        songRepository.remove(id);
    }
}