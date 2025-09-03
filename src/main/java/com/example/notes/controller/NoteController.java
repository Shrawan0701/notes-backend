package com.example.notes.controller;

import com.example.notes.model.Note;
import com.example.notes.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> allNotes() {
        return service.getAll();
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return service.create(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note note) {
        return service.update(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable String id) {
        service.delete(id);
    }

    @PostMapping("/{id}/share")
    public Note shareNote(@PathVariable String id) {
        return service.makePublic(id);
    }

    @GetMapping("/public/{slug}")
    public Note getPublicNote(@PathVariable String slug) {
        return service.getBySlug(slug);
    }
}
