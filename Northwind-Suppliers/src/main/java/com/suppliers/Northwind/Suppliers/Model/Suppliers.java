package com.suppliers.Northwind.Suppliers.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Suppliers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer supplierid;

    @Column(name = "Company Name")
    private String companyname;

    @Column(name = "Contact Name")
    private String contactname;

    @Column(name = "Contact Title")
    private String contacttitle;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @Column(name = "Region")
    private String region;

    @Column(name = "Postal Code")
    private String postalcode;

    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Fax")
    private String fax;

    @Column(name = "Homepage")
    private String homepage;
}
