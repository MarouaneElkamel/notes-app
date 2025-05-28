package com.adam.assessment.service.mapper;

import com.adam.assessment.domain.Note;
import com.adam.assessment.domain.Tag;
import com.adam.assessment.service.dto.NoteDTO;
import com.adam.assessment.service.dto.TagDTO;
import java.util.Set;
import java.util.stream.Collectors;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Note} and its DTO {@link NoteDTO}.
 */
@Mapper(componentModel = "spring")
public interface NoteMapper extends EntityMapper<NoteDTO, Note> {
    @Mapping(target = "tags", source = "tags", qualifiedByName = "tagIdSet")
    NoteDTO toDto(Note s);

    @Mapping(target = "removeTag", ignore = true)
    Note toEntity(NoteDTO noteDTO);

    @Named("tagId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TagDTO toDtoTagId(Tag tag);

    @Named("tagIdSet")
    default Set<TagDTO> toDtoTagIdSet(Set<Tag> tag) {
        return tag.stream().map(this::toDtoTagId).collect(Collectors.toSet());
    }
}
