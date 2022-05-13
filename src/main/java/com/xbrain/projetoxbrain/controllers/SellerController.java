package com.xbrain.projetoxbrain.controllers;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonView;
import com.xbrain.projetoxbrain.controllers.util.URL;
import com.xbrain.projetoxbrain.dto.SellerDto;
import com.xbrain.projetoxbrain.dto.SellerSalesDto;
import com.xbrain.projetoxbrain.models.SellerModel;
import com.xbrain.projetoxbrain.services.SellerService;
import com.xbrain.projetoxbrain.services.exceptions.ExistsByCpfException;
import com.xbrain.projetoxbrain.services.exceptions.ExistsByFullNameException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public ResponseEntity<List<SellerModel>> findAllSellers(){
        List<SellerModel> list = sellerService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{sellerId}")
    public ResponseEntity<SellerModel> findSellerById(@PathVariable Long sellerId){
        SellerModel obj = sellerService.findById(sellerId);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{sellerId}")
    public ResponseEntity<Object> deleteSeller(@PathVariable Long sellerId){
        findSellerById(sellerId);
        sellerService.delete(sellerId);
        return ResponseEntity.ok().body("Seller deleted successfully");
    }

    @PostMapping
    public ResponseEntity<SellerModel> saveSeller(@RequestBody @Validated(SellerDto.SellerView.RegistrationPost.class) @JsonView(SellerDto.SellerView.RegistrationPost.class) SellerDto sellerDto){
        if (sellerService.existsByFullName(sellerDto.getFullName())){
            throw new ExistsByFullNameException(sellerDto.getFullName());
        }
        if (sellerService.existsByCpf(sellerDto.getCpf())){
            throw new ExistsByCpfException(sellerDto.getCpf());
        }
        SellerModel obj = sellerService.fromDto(sellerDto);
        obj = sellerService.insert(obj);
        obj = sellerService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sellerId}").buildAndExpand(obj.getSellerId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{sellerId}")
    public ResponseEntity<SellerModel> updateSeller(@PathVariable Long sellerId, @RequestBody @Validated(SellerDto.SellerView.SellerPut.class) @JsonView(SellerDto.SellerView.SellerPut.class) SellerDto sellerDto){        
        SellerModel obj = sellerService.fromDto(sellerDto);
        obj = sellerService.updateSeller(sellerId, obj);
        obj = sellerService.save(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{sellerId}/image")
    public ResponseEntity<Object> updateSellerImage(@PathVariable Long sellerId, @RequestBody @Validated(SellerDto.SellerView.ImagePut.class) @JsonView(SellerDto.SellerView.ImagePut.class) SellerDto sellerDto){
        SellerModel obj = sellerService.fromDto(sellerDto);
        obj = sellerService.updateImage(sellerId, obj);
        obj = sellerService.save(obj);
        return ResponseEntity.ok().body("Image updated sucefully");
    }

    @GetMapping(value = "/sales")
    public ResponseEntity<Set<SellerSalesDto>> sellerSales(@RequestParam(value = "minDate", required = false) String minDate, @RequestParam(value = "maxDate", required = false) String maxDate){
        Set<SellerSalesDto> sales = null;
        if(minDate != null || maxDate != null){
        LocalDateTime min = URL.converterMinDate(minDate, LocalDate.parse("2022-05-13").atTime(0, 0));
        LocalDateTime max = URL.converterMaxDate(maxDate, LocalDateTime.now(ZoneId.of("UTC")));
        sales = sellerService.sellerSalesWithDate(min, max);
        }
        else{
            sales = sellerService.sellerSales();
        }
        return ResponseEntity.ok().body(sales);
    }
    
}
