package run.training;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import run.bike.Bike;
import run.run.Post;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sum_trainings")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @Column(name = "sum_km")
    private Integer km;



    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL)
    private List<Bike> bikes = new ArrayList<>();

    public Training(String type, Integer km) {
        this.type = type;
        this.km = km;
    }

    public void addPosts(Post post){
        posts.add(post);
        post.setTraining(this);
    }
    public double getTrainingAllDistance(){
        double sum = 0;
        for (int i = 0; i < posts.size(); i++){
            double distance = posts.get(i).getKm();
            sum += distance;
        }
        return sum;
    }

    public double getTrainingOneMonthDistance(){
        List<Post> actual_month_run = posts.stream().filter(post -> post.getDate() != null)
                .filter(post -> post.getDate().getMonth() == LocalDate.now().getMonth())
                .collect(Collectors.toList());
        double sum = 0;
        for (int i = 0; i < actual_month_run.size(); i++){
            double distance = actual_month_run.get(i).getKm();
            sum += distance;
        }
        return sum;
    }



}
