package com.autoloan.supply.controller;

import com.autoloan.supply.dto.CustomerDTO;
import com.autoloan.supply.service.SupplyService;
import com.autoloan.supply.dto.GroupProductDTO;
import com.autoloan.supply.service.SupplyService;
import com.autoloan.supply.dto.ItemOrderDTO;
import com.autoloan.supply.service.SupplyService;
import com.autoloan.supply.dto.OrderDTO;
import com.autoloan.supply.service.SupplyService;
import com.autoloan.supply.dto.ProductDTO;
import com.autoloan.supply.service.SupplyService;
import com.autoloan.supply.dto.TaxDTO;
import com.autoloan.supply.service.SupplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/supply")
public class SupplyController {

    private final SupplyService supplyService;

    @GetMapping("${endpoint.prefix.api-v1}/customer/{id}")
    public CustomerDTO getCustomer(@PathVariable(name = "id") String id) {
        return supplyService.getCustomer(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/customer")
    public List<CustomerDTO> getAllCustomer() {
        return supplyService.getAllCustomer();
    }


    @PostMapping("${endpoint.prefix.api-v1}/customer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO) {
        return supplyService.addCustomer(customerDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/customer/{id}")
    public CustomerDTO updateCustomer(@PathVariable(name = "id") String id, @RequestBody CustomerDTO customerDTO) {
        return supplyService.updateCustomer(id, customerDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/customer/{id}")
    public void deleteCustomer(@PathVariable(name = "id") String id) {
        supplyService.deleteCustomer(id);
    }

    @GetMapping("${endpoint.prefix.api-v1}/groupproduct/{id}")
    public GroupProductDTO getGroupProduct(@PathVariable(name = "id") String id) {
        return supplyService.getGroupProduct(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/groupproduct")
    public List<GroupProductDTO> getAllGroupProduct() {
        return supplyService.getAllGroupProduct();
    }


    @PostMapping("${endpoint.prefix.api-v1}/groupproduct")
    public GroupProductDTO addGroupProduct(@RequestBody GroupProductDTO groupProductDTO) {
        return supplyService.addGroupProduct(groupProductDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/groupproduct/{id}")
    public GroupProductDTO updateGroupProduct(@PathVariable(name = "id") String id, @RequestBody GroupProductDTO groupProductDTO) {
        return supplyService.updateGroupProduct(id, groupProductDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/groupproduct/{id}")
    public void deleteGroupProduct(@PathVariable(name = "id") String id) {
        supplyService.deleteGroupProduct(id);
    }

    @GetMapping("${endpoint.prefix.api-v1}/itemorder/{id}")
    public ItemOrderDTO getItemOrder(@PathVariable(name = "id") String id) {
        return supplyService.getItemOrder(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/itemorder")
    public List<ItemOrderDTO> getAllItemOrder() {
        return supplyService.getAllItemOrder();
    }


    @PostMapping("${endpoint.prefix.api-v1}/itemorder")
    public ItemOrderDTO addItemOrder(@RequestBody ItemOrderDTO itemOrderDTO) {
        return supplyService.addItemOrder(itemOrderDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/itemorder/{id}")
    public ItemOrderDTO updateItemOrder(@PathVariable(name = "id") String id, @RequestBody ItemOrderDTO itemOrderDTO) {
        return supplyService.updateItemOrder(id, itemOrderDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/itemorder/{id}")
    public void deleteItemOrder(@PathVariable(name = "id") String id) {
        supplyService.deleteItemOrder(id);
    }

    @GetMapping("${endpoint.prefix.api-v1}/order/{id}")
    public OrderDTO getOrder(@PathVariable(name = "id") String id) {
        return supplyService.getOrder(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/order")
    public List<OrderDTO> getAllOrder() {
        return supplyService.getAllOrder();
    }


    @PostMapping("${endpoint.prefix.api-v1}/order")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO) {
        return supplyService.addOrder(orderDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/order/{id}")
    public OrderDTO updateOrder(@PathVariable(name = "id") String id, @RequestBody OrderDTO orderDTO) {
        return supplyService.updateOrder(id, orderDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/order/{id}")
    public void deleteOrder(@PathVariable(name = "id") String id) {
        supplyService.deleteOrder(id);
    }

    @GetMapping("${endpoint.prefix.api-v1}/product/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id) {
        return supplyService.getProduct(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/product")
    public List<ProductDTO> getAllProduct() {
        return supplyService.getAllProduct();
    }


    @PostMapping("${endpoint.prefix.api-v1}/product")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return supplyService.addProduct(productDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/product/{id}")
    public ProductDTO updateProduct(@PathVariable(name = "id") String id, @RequestBody ProductDTO productDTO) {
        return supplyService.updateProduct(id, productDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/product/{id}")
    public void deleteProduct(@PathVariable(name = "id") String id) {
        supplyService.deleteProduct(id);
    }

    @GetMapping("${endpoint.prefix.api-v1}/tax/{id}")
    public TaxDTO getTax(@PathVariable(name = "id") String id) {
        return supplyService.getTax(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/tax")
    public List<TaxDTO> getAllTax() {
        return supplyService.getAllTax();
    }


    @PostMapping("${endpoint.prefix.api-v1}/tax")
    public TaxDTO addTax(@RequestBody TaxDTO taxDTO) {
        return supplyService.addTax(taxDTO);
    }


    @PutMapping("${endpoint.prefix.api-v1}/tax/{id}")
    public TaxDTO updateTax(@PathVariable(name = "id") String id, @RequestBody TaxDTO taxDTO) {
        return supplyService.updateTax(id, taxDTO);
    }


    @DeleteMapping("${endpoint.prefix.api-v1}/tax/{id}")
    public void deleteTax(@PathVariable(name = "id") String id) {
        supplyService.deleteTax(id);
    }


    @GetMapping("${endpoint.prefix.api-v1}/order/{id}/total")
    public Double calculateTotalOrder(@PathVariable(name = "id") String orderId) {
        return supplyService.calculateOrderTotal(orderId);
    }

}