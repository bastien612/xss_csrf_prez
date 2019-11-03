package com.laboratoire.checklist.model;
//
//import com.laboratoire.checklist.model.Category;
//import com.laboratoire.checklist.model.Product;
//import org.hibernate.annotations.OnDelete;
//import org.hibernate.annotations.OnDeleteAction;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="rel_category_product")
public class RelCategoryProduct extends AuditModel{
//
//    @Id
//    @GeneratedValue(generator = "rel_product_category_generator")
//    @SequenceGenerator(
//            name="rel_product_category_generator",
//            sequenceName="rel_product_category_sequence",
//            initialValue=1
//    )
//    private Long id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    @OnDelete(action=OnDeleteAction.CASCADE)
//    private Product product;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "category_id")
//    @OnDelete(action= OnDeleteAction.CASCADE)
//    private Category category;
//
}
