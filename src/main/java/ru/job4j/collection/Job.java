package ru.job4j.collection;

import ru.job4j.tracker.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Job  implements Comparable<Job> {
    private String name;
    private  int priority;

    public Job(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return priority == job.priority
                && Objects.equals(name, job.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority);
    }

    public static void main(String[] args) {

        List<Job> jobs = Arrays.asList(new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0));
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
    }
}
