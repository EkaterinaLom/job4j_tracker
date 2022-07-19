package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompareDescByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompareAscByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Fix bug", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompareAscByName() {
        List<Job> jobs = Arrays.asList(new Job("Igor", 3), new Job("Tanya", 4),
                new Job("Andrey", 1));
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(new Job("Andrey", 1), new Job("Igor", 3),
                new Job("Tanya", 4));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompareAscByPriority() {
        List<Job> jobs = Arrays.asList(new Job("Andrey", 3), new Job("Igor", 2),
                new Job("Tanya", 1));
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(new Job("Tanya", 1), new Job("Igor", 2),
                new Job("Andrey", 3));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompareDescByName() {
        List<Job> jobs = Arrays.asList(new Job("Andrey", 1), new Job("Tanya", 4),
                new Job("Igor", 3));
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(new Job("Tanya", 4), new Job("Igor", 3),
                new Job("Andrey", 1));
        assertEquals(expected, jobs);
    }

    @Test
    public void whenCompareDescByPriority() {
        List<Job> jobs = Arrays.asList(new Job("Andrey", 1), new Job("Igor", 3),
                new Job("Tanya", 2));
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(new Job("Igor", 3), new Job("Tanya", 2),
                new Job("Andrey", 1));
        assertEquals(expected, jobs);
    }
}