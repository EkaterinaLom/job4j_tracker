package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0.0;
        for (var p : pupils) {
            rsl += countAvg(p.subjects());
        }
        return rsl / pupils.size();
    }

    public static double countAvg(List<Subject> subjects) {
        var value = 0.0;
        for (var s : subjects) {
            value += s.score();
        }
        return value / subjects.size();
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        var averPup = new ArrayList<Label>(pupils.size());
        for (var p : pupils) {
            averPup.add(new Label(p.name(), countAvg(p.subjects())));
        }
        return averPup;
    }

    private static Map<String, Double> scoreSubject(List<Pupil> pupils) {
        var map = new LinkedHashMap<String, Double>();
        for (var pupil : pupils) {
            for (var subject : pupil.subjects()) {
                map.putIfAbsent(subject.name(), 0.0);
                map.put(subject.name(), map.get(subject.name()) + subject.score());
            }
        }
        return map;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        var map = scoreSubject(pupils);
        var averSub = new ArrayList<Label>();
        for (String key : map.keySet()) {
            Double value = map.get(key);
            averSub.add(new Label(key, value / pupils.size()));
        }
        return averSub;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        var bestSt = new ArrayList<Label>();
        for (var p : pupils) {
            bestSt.add(new Label(p.name(), countAvg(p.subjects()) * p.subjects().size()));
        }
        bestSt.sort(Comparator.naturalOrder());
        Label bestStu = bestSt.get(pupils.size() - 1);
        return bestStu;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        var map = scoreSubject(pupils);
        var bestSub = new ArrayList<Label>();
        for (String key : map.keySet()) {
            Double value = map.get(key);
            bestSub.add(new Label(key, value));
        }
        bestSub.sort(Comparator.naturalOrder());
        Label bestSubj = bestSub.get(pupils.size() - 1);
        return bestSubj;
    }
}