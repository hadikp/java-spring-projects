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
        User user = new User("Péter", "hadikp", "hadikp@gmail.com", "pass", "Hungary", false, LocalDate.of(2022, 12, 11));
        Squad squad1 = new Squad("squad1", "Description of squad1", LocalDate.of(2022, 12, 14));
        Squad squad2 = new Squad("squad2", "Description of squad2", LocalDate.of(2022, 12, 15));
        Project project1 = new Project("project1", "ready to work", "Description of project1", LocalDate.of(2022, 12, 11), LocalDate.of(2023, 01, 21));
        Project project2 = new Project("project2", "ready to work", "Description of project2", LocalDate.of(2022, 12, 12), LocalDate.of(2023, 01, 21));
        Project project3 = new Project("project3", "ready to work", "Description of project3", LocalDate.of(2022, 12, 13), LocalDate.of(2023, 01, 21));
        Board board1 = new Board("Booard1", 11);
        Board board2 = new Board("Booard2", 15);

        squad1.setBoard(board1);
        squad2.setBoard(board2);

        squad1.addProject(project1);
        squad1.addProject(project2);
        squad2.addProject(project3);
        user.addSquad(squad1);
        user.addSquad(squad2);
        repository.save(user);
    }

}