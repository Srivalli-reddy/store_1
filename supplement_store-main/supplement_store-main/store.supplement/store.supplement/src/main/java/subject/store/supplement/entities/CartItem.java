package subject.store.supplement.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
    @Id @GeneratedValue
    private Long id;
    private int quantity;

    @ManyToOne
    private User user;

    @ManyToOne
    private ProductVariant variant;
}
