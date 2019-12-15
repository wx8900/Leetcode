package leetcode.apple;

public class Employee {

    int _id;
    String _name;
    int _age;

    public Employee (int id, String name, int age) {
         _id = id;
         _name = name;
        _age = age;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "_id=" + _id +
                ", _name='" + _name + '\'' +
                ", _age=" + _age +
                '}';
    }
}
