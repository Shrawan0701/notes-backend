package com.example.notes.service;

import com.example.notes.model.Note;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    private final Map<String, Note> notes = new LinkedHashMap<>();

    public List<Note> getAll() {
        return new ArrayList<>(notes.values());
    }

    public Note create(Note note) {
        notes.put(note.getId(), note);
        return note;
    }

    public Note update(String id, Note noteData) {
        Note note = notes.get(id);
        if (note != null) {
            note.setContent(noteData.getContent());
        }
        return note;
    }

    public void delete(String id) {
        notes.remove(id);
    }

    public Note makePublic(String id) {
        Note note = notes.get(id);
        if (note != null && note.getSlug() == null) {
            note.setSlug(UUID.randomUUID().toString().substring(0, 8));
        }
        return note;
    }

    public Note getBySlug(String slug) {
        return notes.values().stream()
                .filter(n -> slug.equals(n.getSlug()))
                .findFirst()
                .orElse(null);
    }
}
