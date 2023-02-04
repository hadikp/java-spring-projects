package embedded.school;

import embedded.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SchoolTest {

    @Autowired
    SchoolRepository repository;

    @BeforeEach
    void init(){
        Address addressB = new Address("Veszprém", "Búzavirág ut", 12);
        Address addressM = new Address("Veszprém", "Arany János ut", 22);
        School bolyai = new School("Bólyai János gimnézium", addressB);
        School madacs = new School("Madách Imre gimnézium", addressM);
        Student peter = new Student("Péter", 22, "Jeles");
        Student jani = new Student("János", 32, "jó");
        Student juli = new Student("Juli", 33, "Jeles");

        bolyai.addStudent(peter);
        bolyai.addStudent(jani);
        madacs.addStudent(juli);
        repository.save(bolyai);
        repository.save(madacs);
    }

    @Test
    void test(){
        System.out.println();
    }

}