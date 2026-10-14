package uz.easy.app_warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.easy.app_warehouse.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

}
