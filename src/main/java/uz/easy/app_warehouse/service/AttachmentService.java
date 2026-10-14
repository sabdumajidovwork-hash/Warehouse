package uz.easy.app_warehouse.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.entity.Attachment;
import uz.easy.app_warehouse.entity.AttachmentContent;
import uz.easy.app_warehouse.repository.AttachmentContentRepository;
import uz.easy.app_warehouse.repository.AttachmentRepository;

import java.io.IOException;
import java.util.Iterator;

@Service
@RequiredArgsConstructor
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository attachmentContentRepository;

    public Result uploadFile(MultipartHttpServletRequest request)   {
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


}
