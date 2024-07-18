package com.project.mc_dialog.web.controllers;

import com.project.mc_dialog.services.DialogService;
import com.project.mc_dialog.web.dto.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/dialogs")
@RequiredArgsConstructor
public class DialogController {

    private final DialogService dialogService;

    @PutMapping("/{dialogId}")
    public ResponseEntity<String> updateMessageStatus(@PathVariable UUID dialogId) {
        dialogService.updateMessageStatus(dialogId);
        return ResponseEntity.ok("Successful operation");
    }

    @PostMapping("/createMessage")
    public ResponseEntity<MessageDto> createMessage(@RequestBody MessageDto messageDto) {
        return ResponseEntity.ok(dialogService.createMessage(messageDto));
    }

    @PostMapping("/createDialog")
    public ResponseEntity<DialogDto> createDialog(@RequestBody DialogDto dialogDto) {
        return ResponseEntity.ok(dialogService.createDialog(dialogDto));
    }

    @GetMapping
    public ResponseEntity<PageDialogDto> getDialogs(@ModelAttribute @Valid Pageable pageable) {
        return ResponseEntity.ok(dialogService.getDialogs(pageable));
    }

    @GetMapping("/unread")
    public ResponseEntity<UnreadCountDto> getUnreadMessages() {
        return ResponseEntity.ok(dialogService.getUnreadCount());
    }

    @GetMapping("/recipientId/{id}")
    public ResponseEntity<DialogDto> getDialog(@PathVariable UUID id) {
        return ResponseEntity.ok(dialogService.getDialog(id));
    }

    @GetMapping("/messages")
    public ResponseEntity<PageMessageShortDto> getMessages(@RequestParam UUID recipientId,
                                                           @ModelAttribute @Valid Pageable pageable) {
        return ResponseEntity.ok(dialogService.getMessages(recipientId, pageable));
    }

}
