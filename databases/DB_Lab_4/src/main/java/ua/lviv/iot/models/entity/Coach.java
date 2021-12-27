package ua.lviv.iot.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "coach")
public class Coach {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(name = "programs_has_coach",
            joinColumns = { @JoinColumn(name = "fk_programs_id") },
            inverseJoinColumns = { @JoinColumn(name = "fk_coach_id") })
    private List<Program> programs = new ArrayList<>();

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "price")
    private double price;

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, surname: %s, phone_number: %s, price: %s", id, name, surname, phoneNumber, price);
    }
}
