package teamMurange.Murange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import teamMurange.Murange.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>, CategoryRepositoryCustom{
}
