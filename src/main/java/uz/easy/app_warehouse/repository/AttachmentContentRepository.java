package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.easy.app_warehouse.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {
}
