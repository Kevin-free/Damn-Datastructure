package hashCode;

/**
 * @description:
 * @author: Kevin
 * @createDate: 2020/3/3
 * @version: 1.0
 */
public class Student {
    int grade;
    int cls;
    String name;

    public Student(int grade, int cls, String name) {
        this.grade = grade;
        this.cls = cls;
        this.name = name;
    }

    // 自己重写计算 hashCode 方法
    @Override
    public int hashCode(){
        int b = 31;
        int hash = 0;
        hash = hash*b + grade;
        hash = hash*b + cls;
        // 字母不区分大小写的话加
        hash = hash*b + name.toLowerCase().hashCode();

        return hash;
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Student another = (Student) o;
        return this.grade == another.grade &&
                this.cls == another.cls &&
                this.name.toLowerCase().equals(another.name.toLowerCase()); // 字母不区分大小写的话加
    }

}
