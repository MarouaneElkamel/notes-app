package com.adam.assessment.service.mapper;

import com.adam.assessment.domain.Note;
import com.adam.assessment.domain.Tag;
import com.adam.assessment.service.dto.NoteDTO;
import com.adam.assessment.service.dto.TagDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Tag} and its DTO {@link TagDTO}.
 */
@Mapper(componentModel = "spring")
public interface TagMapper extends EntityMapper<TagDTO, Tag> {
    @Mapping(target = "notes", source = "notes", qualifiedByName = "noteIdSet")
    TagDTO toDto(Tag s);

    @Mapping(target = "notes", ignore = true)
    @Mapping(target = "removeNote", ignore = true)
    Tag toEntity(TagDTO tagDTO);

    @Named("noteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    NoteDTO toDtoNoteId(Note note);

    @Named("noteIdSet")
    default Set<NoteDTO> toDtoNoteIdSet(Set<Note> note) {
        return note.stream().map(this::toDtoNoteId).collect(Collectors.toSet());
    }
}
