package 算法基础.class06;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiJinLong
 * @version 1.0
 * @date 2021/12/4 15:03
 */
public class UnionFindTest {
    public static class Student{
        public List<Student> friends;

        public Student() {
           friends = new ArrayList<Student>();
        }
    }

    public static void main(String[] args) {
        /*Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        Student s5 = new Student();
        Student s6 = new Student();
        Student s7 = new Student();
        Student s11 = new Student();
        Student s12= new Student();
        Student s13= new Student();
        Student s16= new Student();
        Student s17= new Student();
        s1.friends.add(s2);
        s1.friends.add(s3);
        s3.friends.add(s6);
        s3.friends.add(s5);
        s4.friends.add(s7);
        s7.friends.add(s1);
        s11.friends.add(s12);
        s11.friends.add(s13);
        s16.friends.add(s12);
        s17.friends.add(s11);
        List<Student> list  = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s11);
        list.add(s12);
        list.add(s13);
        list.add(s16);
        list.add(s17);
        Code05_UnionFind.UnionFind<Student> unionFind = new Code05_UnionFind.UnionFind<>(list);
        for (Student s:list) {
            for (Student ss:s.friends) {
                unionFind.union(s,ss);
            }
        }
        System.out.println(unionFind.isSameSet(s1,s11));*/

    }
}
