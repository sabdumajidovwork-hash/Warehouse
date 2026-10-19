package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.easy.app_warehouse.dto.AttachmentDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Attachment;
import uz.easy.app_warehouse.entity.AttachmentContent;
import uz.easy.app_warehouse.repository.AttachmentContentRepository;
import uz.easy.app_warehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    public Result uploadFileService(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = new Attachment();
        attachment.setName(file.getName());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent = new AttachmentContent();
        try {
            attachmentContent.setBytes(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("Fayl saqlandi", true, savedAttachment.getId());
    }

    public Result getAttachmentsService() {
        List<Attachment> attachmentList = attachmentRepository.findAll();

        if (attachmentList.isEmpty()) return new Result("Attachment lar topilmadi", false);

        return new Result("Attachment lar ro'yxati", true, attachmentList);
    }

    public Result getAttachmentByIdService(Long id) {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);

        if (attachmentOptional.isEmpty()) return new Result("Attachment topilmadi", false);

        return new Result("Attachment  topildi", true, attachmentOptional.get());
    }

    public Result updateAttachmentService(Long id, AttachmentDto dto) {
        Optional<Attachment> attachmentOptional = attachmentRepository.findById(id);
        if (attachmentOptional.isEmpty()) return new Result("Attachment topilmadi", false);

        Attachment attachment = attachmentOptional.get();
        attachment.setName(dto.getName());
        attachment.setSize(dto.getSize());
        attachment.setContentType(dto.getContentType());

        attachmentRepository.save(attachment);

        return new Result("Attachemtn tahrirlandi", true);
    }

    public Result removeAttachmentService(Long id) {
        boolean existsById = attachmentRepository.existsById(id);
        if (!existsById) return new Result("Attachment topilmadi", false);

        List<AttachmentContent> attachmentContentList = attachmentContentRepository.findAll();
        if (attachmentContentList.isEmpty()) return new Result("Contentlar topilmadi", false);

        for (AttachmentContent attachmentContent : attachmentContentList) {
            if (attachmentContent.getAttachment().getId() == id) {
                attachmentContentRepository.deleteById(attachmentContent.getId());
            }
        }

        attachmentRepository.deleteById(id);
        return new Result("Attachment o'chirilid", true);


    }


}
