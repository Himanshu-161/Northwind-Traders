package com.suppliers.Northwind.Suppliers.Service;

import com.suppliers.Northwind.Suppliers.DTO.SuppliersDTO;
import com.suppliers.Northwind.Suppliers.Model.Suppliers;
import com.suppliers.Northwind.Suppliers.Repository.SuppliersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {
    @Autowired
    SuppliersRepository supplierRepo;
    public List<SuppliersDTO> getAllSuppliers(){

        List<SuppliersDTO> suppliersDTOS = new ArrayList<>();
        List<Suppliers> suppliersList = supplierRepo.findAll();

        for(int i = 0; i < suppliersList.size(); i++) {
            Suppliers suppliers = suppliersList.get(i);

            SuppliersDTO suppliersDTO = new SuppliersDTO();

            suppliersDTO.setSupplierid(suppliers.getSupplierid());
            suppliersDTO.setCompanyname(suppliers.getCompanyname());
            suppliersDTO.setContactname(suppliers.getContactname());
            suppliersDTO.setContacttitle(suppliers.getContacttitle());
            suppliersDTO.setAddress(suppliers.getAddress());
            suppliersDTO.setCity(suppliers.getCity());
            suppliersDTO.setRegion(suppliers.getRegion());
            suppliersDTO.setPostalcode(suppliers.getPostalcode());
            suppliersDTO.setCountry(suppliers.getCountry());
            suppliersDTO.setPhone(suppliers.getPhone());
            suppliersDTO.setFax(suppliers.getFax());
            suppliersDTO.setHomepage(suppliers.getHomepage());

            suppliersDTOS.add(suppliersDTO);

        }
        return suppliersDTOS;
    }




    public int saveSuppliers(SuppliersDTO suppliersDTO){

        SuppliersDTO suppliersDTOS = new SuppliersDTO();
        Suppliers suppliers = new Suppliers();

        suppliers.setSupplierid(suppliersDTO.getSupplierid());
        suppliers.setCompanyname(suppliersDTO.getCompanyname());
        suppliers.setContactname(suppliersDTO.getContactname());
        suppliers.setContacttitle(suppliersDTO.getContacttitle());
        suppliers.setAddress(suppliersDTO.getAddress());
        suppliers.setCity(suppliersDTO.getCity());
        suppliers.setRegion(suppliersDTO.getRegion());
        suppliers.setPostalcode(suppliersDTO.getPostalcode());
        suppliers.setCountry(suppliersDTO.getCountry());
        suppliers.setPhone(suppliersDTO.getPhone());
        suppliers.setFax(suppliersDTO.getFax());
        suppliers.setHomepage(suppliersDTO.getHomepage());



        Suppliers save = supplierRepo.save(suppliers);
        suppliersDTOS.setSupplierid(save.getSupplierid());

        return suppliersDTOS.getSupplierid();
    }




    public SuppliersDTO getSupplierbyId(Integer Id){
        Optional<Suppliers> suppliers =supplierRepo.findById(Id);

        SuppliersDTO suppliersDto = new SuppliersDTO();

        if (!suppliers.isPresent()){
            throw new RuntimeException("Given Id not Present");
        }
        suppliersDto.setSupplierid(suppliers.get().getSupplierid());
        suppliersDto.setFax(suppliers.get().getFax());
        suppliersDto.setCity(suppliers.get().getCity());
        suppliersDto.setPhone(suppliers.get().getPhone());
        suppliersDto.setCountry(suppliers.get().getCountry());
        suppliersDto.setRegion(suppliers.get().getRegion());
        suppliersDto.setAddress(suppliers.get().getAddress());
        suppliersDto.setHomepage(suppliers.get().getHomepage());
        suppliersDto.setContacttitle(suppliers.get().getContacttitle());
        suppliersDto.setCompanyname(suppliers.get().getCompanyname());
        suppliersDto.setPostalcode(suppliers.get().getPostalcode());
        suppliersDto.setContactname(suppliers.get().getContactname());
        return suppliersDto ;
    }


    public SuppliersDTO update(SuppliersDTO suppliersDto) {
        Optional<Suppliers> optionalSuppliers = supplierRepo.findById(suppliersDto.getSupplierid());
        SuppliersDTO dto =new SuppliersDTO();
        Suppliers suppliers = new Suppliers();
        if (optionalSuppliers.isPresent()) {
            suppliers .setSupplierid(suppliersDto.getSupplierid());
            suppliers.setPostalcode(suppliersDto.getPostalcode());
            suppliers.setCountry(suppliersDto.getCountry());
            suppliers.setAddress(suppliersDto.getAddress());
            suppliers.setRegion(suppliersDto.getRegion());
            suppliers.setCity(suppliersDto.getCity());
            suppliers.setFax(suppliersDto.getFax());
            suppliers.setHomepage(suppliersDto.getHomepage());
            suppliers.setPhone(suppliersDto.getPhone());
            suppliers.setContacttitle(suppliersDto.getContacttitle());
            suppliers.setContactname(suppliersDto.getContactname());
            suppliers.setCompanyname(suppliersDto.getCompanyname());

            Suppliers save=supplierRepo.save(suppliers);
            dto.setSupplierid(save.getSupplierid());

        } else {
            throw new RuntimeException("supplier Not Present");
        }
        return dto;
    }

    public void delete(Integer id) {
        Optional<Suppliers> suppliers = supplierRepo.findById(id);
        if (suppliers.isPresent()) {
            supplierRepo.deleteById(id);

        } else {
            throw new RuntimeException("Given ID not present");
        }


    }
}
