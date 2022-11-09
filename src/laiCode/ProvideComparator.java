package laiCode;

import laiCode.compare.Student;

import java.util.*;

// Practice Class12: ️给 PriorityQueue 提供 comparator 的方法如下：（特别重要，牢记）
public class ProvideComparator {
    public static void main (String[]  args)  {
        Queue<Student> pq = new PriorityQueue<>(new MyComparator());
        pq.offer( new Student("Jack",  12));
        pq.offer( new Student("Rose", 10));

        // 3nd way: Anonymous class
        Queue<Student> pqAnonymousClass = new PriorityQueue<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });

        // 4nd way: Lambda expression
        Queue<Student> pqLambdaExpression = new PriorityQueue<>(
                (s1, s2) -> s1.getName().compareTo(s2.getName())
        );
    }

    // 2nd way: （Static）nested class
    static class  MyComparator  implements  Comparator<Student>  {
        @Override
        public int compare(Student s1,  Student s2)  {
            return  s1.getName().compareTo (s2.getName());
        }
    }
}

// 1nd way: Top-level class
class  MyComparator  implements  Comparator<Student>  {
    @Override
    public int compare(Student s1,  Student s2)  {
        return  s1.getName().compareTo (s2.getName());
    }
}
