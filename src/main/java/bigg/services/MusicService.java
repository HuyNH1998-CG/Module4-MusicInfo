package bigg.services;

import bigg.model.Music;
import bigg.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MusicService implements IMusicService {
    @Autowired
    IMusicRepository musicRepository;

    @Override
    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Optional<Music> findById(Integer id) {
        return musicRepository.findById(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void delete(Integer id) {
        musicRepository.deleteById(id);
    }
}
