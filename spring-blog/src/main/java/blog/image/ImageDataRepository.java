package blog.image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDataRepository extends JpaRepository<ImageData, Long> {
}
