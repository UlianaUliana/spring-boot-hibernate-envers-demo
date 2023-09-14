package com.ns.springboothibernateenvers.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.AuditOverride;
import org.hibernate.envers.Audited;


@Entity
@Data
@Audited
@AuditOverride(forClass = BaseAuditLog.class)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends BaseAuditLog {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

//    @Column(name = "created_date", nullable = false, updatable = false)
//    @CreatedDate
//    private Timestamp createdDate;
}
