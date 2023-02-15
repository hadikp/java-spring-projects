package bluesight.user;

import bluesight.board.Board;
import bluesight.card.Card;
import bluesight.col.Col;
import bluesight.project.Project;
import bluesight.squad.Squad;
import bluesight.swimlane.Swimlane;
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
        User peter = new User("Péter", "hadikp", "hadikp@gmail.com", "pass", "src/images", "Hungary", false, LocalDate.of(2022, 12, 11));
        User gergo = new User("Gergő", "tothg", "tothg@gmail.com", "pass123", "src/images", "Hungary", true, LocalDate.of(2022, 12, 12));
        Squad squad1 = new Squad("squad1", "Description of squad1", LocalDate.of(2022, 12, 14));
        Squad squad2 = new Squad("squad2", "Description of squad2", LocalDate.of(2022, 12, 15));
        Squad squad3 = new Squad("squad3", "Description of squad3", LocalDate.of(2022, 12, 16));
        Project project1 = new Project("project1", "ready to work", "Description of project1", LocalDate.of(2022,12,01), LocalDate.of(2022, 12, 11), LocalDate.of(2023, 01, 21));
        Project project2 = new Project("project2", "ready to work", "Description of project2", LocalDate.of(2022,12,01), LocalDate.of(2022, 12, 12), LocalDate.of(2023, 01, 21));
        Project project3 = new Project("project3", "ready to work", "Description of project3", LocalDate.of(2022,12,01), LocalDate.of(2022, 12, 13), LocalDate.of(2023, 01, 21));
        Project project4 = new Project("project4", "ready to work", "Description of project4", LocalDate.of(2022,12,01), LocalDate.of(2022, 12, 14), LocalDate.of(2023, 01, 21));
        Swimlane swimlane1 = new Swimlane("swimlane1", 1, 110);
        Swimlane swimlane2 = new Swimlane("swimlane2", 2, 110);
        Board board1 = new Board("Booard1", 11);
        Board board2 = new Board("Booard2", 15);
        Board board3 = new Board("Booard3", 16);
        Col col1 = new Col("Column1", 1, 111, 5);
        Col col2 = new Col("Column2", 2, 111, 5);
        Col col3 = new Col("Column3", 1, 111, 5);
        Card card1 = new Card("Card1-title", "Description of card1", 2, 1, 1, LocalDate.of(2022, 12, 20),
                LocalDate.of(2022, 12, 21), LocalDate.of(2023, 01,21), LocalDate.of(2023, 01, 30));
        Card card2 = new Card("Card2-title", "Description of card2", 1, 2, 2, LocalDate.of(2022, 12, 20),
                LocalDate.of(2022, 12, 22), LocalDate.of(2023, 02,19), LocalDate.of(2023, 03, 01));

        peter.addCard(card1);
        peter.addCard(card2);
        col1.addNewCard(card1);
        col1.addNewCard(card2);
        swimlane1.addColumns(col1);
        swimlane1.addColumns(col2);
        swimlane2.addColumns(col1);
        swimlane2.addColumns(col3);

        swimlane1.addCard(card1);
        swimlane2.addCard(card2);
        board1.addSwimlane(swimlane1);
        board1.addSwimlane(swimlane2);

        squad1.setBoard(board1);
        squad2.setBoard(board2);
        squad3.setBoard(board3);

        peter.addProject(project1);
        peter.addProject(project2);
        peter.addProject(project3);
        peter.addProject(project4);


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