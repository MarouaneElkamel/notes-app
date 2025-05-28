package com.adam.assessment.domain;

import static com.adam.assessment.domain.NoteTestSamples.*;
import static com.adam.assessment.domain.TagTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.adam.assessment.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class NoteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Note.class);
        Note note1 = getNoteSample1();
        Note note2 = new Note();
        assertThat(note1).isNotEqualTo(note2);

        note2.setId(note1.getId());
        assertThat(note1).isEqualTo(note2);

        note2 = getNoteSample2();
        assertThat(note1).isNotEqualTo(note2);
    }

    @Test
    void tagTest() {
        Note note = getNoteRandomSampleGenerator();
        Tag tagBack = getTagRandomSampleGenerator();

        note.addTag(tagBack);
        assertThat(note.getTags()).containsOnly(tagBack);

        note.removeTag(tagBack);
        assertThat(note.getTags()).doesNotContain(tagBack);

        note.tags(new HashSet<>(Set.of(tagBack)));
        assertThat(note.getTags()).containsOnly(tagBack);

        note.setTags(new HashSet<>());
        assertThat(note.getTags()).doesNotContain(tagBack);
    }
}
