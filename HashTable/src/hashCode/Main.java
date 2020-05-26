package hashCode;

import java.util.HashSet;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/3
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args){
        int a = 42;
        System.out.println(((Integer) a).hashCode());

        int b = -42;
        System.out.println(((Integer) b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());

        Student student = new Student(3, 2, "kevin");
        System.out.println("student hashCode: \t"+student.hashCode());

        Student student1 = new Student(3, 2, "Kevin");
        System.out.println("student1 hashCode: \t"+student1.hashCode());

        System.out.println(student.equals(student1));
    }
}
