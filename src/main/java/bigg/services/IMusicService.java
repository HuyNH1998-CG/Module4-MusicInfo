package bigg.services;

import bigg.model.Music;

import java.util.Optional;

public interface IMusicService {
    Iterable<Music> findAll();
    Optional<Music> findById(Integer id);
    void save(Music music);
    void delete(Integer id);
}
