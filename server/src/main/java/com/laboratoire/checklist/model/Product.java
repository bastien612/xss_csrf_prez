package com.laboratoire.checklist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="product")
public class Product extends AuditModel{

    @Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name="product_generator",
            sequenceName="product_sequence",
            initialValue=1
    )
    private Long id;

    @Column(columnDefinition = "name")
    private String name;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name="rel_category_product",
            joinColumns={@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}

    )
    private Set<Category> categories;

//    @ManyToMany(cascade={CascadeType.MERGE, CascadeType.PERSIST})
//    @JoinTable(
//            name = "rel_product_list",
//            joinColumns = {@JoinColumn(name= "product_id")},
//            inverseJoinColumns = {@JoinColumn(name = "product_list_id")}
//            )
//    private Set<ProductList> productLists = new HashSet<ProductList>();

    public Product() {}

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

//    public Set<ProductList> getProductLists() {
//        return productLists;
//    }
//
//    public void setProductLists(Set<ProductList> productLists) {
//        this.productLists = productLists;
//    }

}
