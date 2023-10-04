package laundry.daeseda.controller;

import laundry.daeseda.dto.user.AddressDto;
import laundry.daeseda.dto.user.AddressListDto;
import laundry.daeseda.dto.user.UserDto;
import laundry.daeseda.service.user.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/address")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/create")
    public ResponseEntity<String> createAddress(@RequestBody @Valid AddressDto addressDto) { //register 호출
        if (addressService.createAddress(addressDto) > 0) {
            return ResponseEntity.ok().body(" Success ");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(" fail ");
        }
    }

    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public List<AddressListDto> getAddressList() {
        List<AddressListDto> addressList = addressService.getMyAddressList(); // 주소 목록을 가져오는 비즈니스 로직 호출
        return addressList;
    }

}
