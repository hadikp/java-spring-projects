package bluesight.user;

import bluesight.board.Board;
import bluesight.project.Project;
import bluesight.squad.Squad;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserITTest {

    @Autowired
    UserRepository repository;

    @Test
    void testCreate(){
        User peter = new User("Péter", "hadikp", "hadikp@gmail.com", "pass", "Hungary", false, LocalDate.of(2022, 12, 11));
        User gergo = new User("Gergő", "tothg", "tothg@gmail.com", "pass123", "Hungary", true, LocalDate.of(2022, 12, 12));
        Squad squad1 = new Squad("squad1", "Description of squad1", LocalDate.of(2022, 12, 14));
        Squad squad2 = new Squad("squad2", "Description of squad2", LocalDate.of(2022, 12, 15));
        Squad squad3 = new Squad("squad3", "Description of squad3", LocalDate.of(2022, 12, 16));
        Project project1 = new Project("project1", "ready to work", "Description of project1", LocalDate.of(2022, 12, 11), LocalDate.of(2023, 01, 21));
        Project project2 = new Project("project2", "ready to work", "Description of project2", LocalDate.of(2022, 12, 12), LocalDate.of(2023, 01, 21));
        Project project3 = new Project("project3", "ready to work", "Description of project3", LocalDate.of(2022, 12, 13), LocalDate.of(2023, 01, 21));
        Project project4 = new Project("project4", "ready to work", "Description of project4", LocalDate.of(2022, 12, 14), LocalDate.of(2023, 01, 21));
        Board board1 = new Board("Booard1", 11);
        Board board2 = new Board("Booard2", 15);
        Board board3 = new Board("Booard3", 16);

        squad1.setBoard(board1);
        squad2.setBoard(board2);
        squad3.setBoard(board3);

        squad1.addProject(project1);
        squad1.addProject(project2);
        squad2.addProject(project3);
        squad3.addProject(project4);

        peter.addSquad(squad1);
        peter.addSquad(squad2);
        gergo.addSquad(squad3);
        repository.save(peter);
        repository.save(gergo);
    }

}