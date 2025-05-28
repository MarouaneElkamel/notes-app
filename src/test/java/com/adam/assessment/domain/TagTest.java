package com.adam.assessment.domain;

import static com.adam.assessment.domain.NoteTestSamples.*;
import static com.adam.assessment.domain.TagTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.adam.assessment.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TagTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Tag.class);
        Tag tag1 = getTagSample1();
        Tag tag2 = new Tag();
        assertThat(tag1).isNotEqualTo(tag2);

        tag2.setId(tag1.getId());
        assertThat(tag1).isEqualTo(tag2);

        tag2 = getTagSample2();
        assertThat(tag1).isNotEqualTo(tag2);
    }

    @Test
    void noteTest() {
        Tag tag = getTagRandomSampleGenerator();
        Note noteBack = getNoteRandomSampleGenerator();

        tag.addNote(noteBack);
        assertThat(tag.getNotes()).containsOnly(noteBack);
        assertThat(noteBack.getTags()).containsOnly(tag);

        tag.removeNote(noteBack);
        assertThat(tag.getNotes()).doesNotContain(noteBack);
        assertThat(noteBack.getTags()).doesNotContain(tag);

        tag.notes(new HashSet<>(Set.of(noteBack)));
        assertThat(tag.getNotes()).containsOnly(noteBack);
        assertThat(noteBack.getTags()).containsOnly(tag);

        tag.setNotes(new HashSet<>());
        assertThat(tag.getNotes()).doesNotContain(noteBack);
        assertThat(noteBack.getTags()).doesNotContain(tag);
    }
}
