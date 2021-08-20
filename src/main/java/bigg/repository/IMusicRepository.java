package bigg.repository;

import bigg.model.Music;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IMusicRepository extends PagingAndSortingRepository<Music, Integer> {
}
