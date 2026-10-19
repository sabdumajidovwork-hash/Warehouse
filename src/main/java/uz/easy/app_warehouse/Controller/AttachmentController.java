package uz.easy.app_warehouse.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.easy.app_warehouse.dto.AttachmentDto;
import uz.easy.app_warehouse.dto.Result;
import uz.easy.app_warehouse.service.AttachmentService;

@RestController
@RequestMapping("/attachment")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentService attachmentService;

    @PostMapping
    public Result upload(MultipartHttpServletRequest request) {
        return attachmentService.uploadFileService(request);
    }

    @GetMapping
    public Result getAttachments() {
        return attachmentService.getAttachmentsService();
    }

    @GetMapping("/{id}")
    public Result getAttachmentByIdService(@PathVariable Long id) {
        return attachmentService.getAttachmentByIdService(id);
    }

    @PatchMapping("/{id}")
    public  Result updateAttachment(@PathVariable Long id, @RequestBody AttachmentDto attachmentDto){
        return  attachmentService.updateAttachmentService(id,attachmentDto);
    }

    @DeleteMapping("/{id}")
    public  Result removeAttachment(@PathVariable Long id){
        return  attachmentService.removeAttachmentService(id);
    }


}
