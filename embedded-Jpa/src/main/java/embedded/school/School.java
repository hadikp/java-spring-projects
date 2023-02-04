package embedded.school;

import embedded.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "students", joinColumns =@JoinColumn(name = "schools_id"))
    private List<Student> students = new ArrayList<>();

    public School(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public void addStudent(Student student){
        students.add(student);
    }
}
