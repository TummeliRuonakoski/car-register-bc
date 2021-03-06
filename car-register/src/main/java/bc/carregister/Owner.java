package bc.carregister;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Owner extends AbstractPersistable<Long>{

    @Column
    private String firstname;

    @Column
    private String lastname;

    @ManyToMany(mappedBy= "owners")
    private List<Car> cars = new ArrayList<>();
    
}
