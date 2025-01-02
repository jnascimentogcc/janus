package com.autoloan.supply.service;

import com.autoloan.helper.exception.ItemNotFoundException;
import com.autoloan.supply.dto.CustomerDTO;
import com.autoloan.supply.model.CustomerEntity;
import com.autoloan.supply.model.CustomerRepository;

import com.autoloan.supply.dto.GroupProductDTO;
import com.autoloan.supply.model.GroupProductEntity;
import com.autoloan.supply.model.GroupProductRepository;

import com.autoloan.supply.dto.ItemOrderDTO;
import com.autoloan.supply.model.ItemOrderEntity;
import com.autoloan.supply.model.ItemOrderRepository;

import com.autoloan.supply.dto.OrderDTO;
import com.autoloan.supply.model.OrderEntity;
import com.autoloan.supply.model.OrderRepository;

import com.autoloan.supply.dto.ProductDTO;
import com.autoloan.supply.model.ProductEntity;
import com.autoloan.supply.model.ProductRepository;

import com.autoloan.supply.dto.TaxDTO;
import com.autoloan.supply.model.TaxEntity;
import com.autoloan.supply.model.TaxRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class SupplyService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SupplyService.class);

    
    private final CustomerRepository customerRepository;
    private final GroupProductRepository groupProductRepository;
    private final ItemOrderRepository itemOrderRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final TaxRepository taxRepository;

    
    public CustomerDTO getCustomer(String id) {
        try {
            CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customerEntity, customerDTO);
            return customerDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Customer with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Customer with id: %s not found.", id));
        }
    }
    
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> listCustomerDTO = new ArrayList<>();
        Iterable<CustomerEntity> itCustomerEntity = customerRepository.findAll();
        for (CustomerEntity customerEntity : itCustomerEntity) {
            CustomerDTO customerDTO = new CustomerDTO();
            BeanUtils.copyProperties(customerEntity, customerDTO);
            listCustomerDTO.add(customerDTO);
        }
        return listCustomerDTO;
    }
    
    public CustomerDTO addCustomer(CustomerDTO customerDTO) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties(customerDTO, customerEntity);
        CustomerEntity customerAdded = customerRepository.save(customerEntity);
        BeanUtils.copyProperties(customerAdded, customerDTO);
        return customerDTO;
    }
    
    public CustomerDTO updateCustomer(String id, CustomerDTO customerDTO) {
        try {
            CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(customerDTO, customerEntity);
            customerEntity.setId(id);
            customerRepository.save(customerEntity);
            customerDTO.setId(id);
            return customerDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Customer with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Customer with id: %s not found.", id));
        }
    }
    
    public void deleteCustomer(String id) {
        try {
            CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow();
            customerRepository.delete(customerEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("Customer with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Customer with id: %s not found.", id));
        }
    }
    
    public GroupProductDTO getGroupProduct(String id) {
        try {
            GroupProductEntity groupProductEntity = groupProductRepository.findById(id).orElseThrow();
            GroupProductDTO groupProductDTO = new GroupProductDTO();
            BeanUtils.copyProperties(groupProductEntity, groupProductDTO);
            return groupProductDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("GroupProduct with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("GroupProduct with id: %s not found.", id));
        }
    }
    
    public List<GroupProductDTO> getAllGroupProduct() {
        List<GroupProductDTO> listGroupProductDTO = new ArrayList<>();
        Iterable<GroupProductEntity> itGroupProductEntity = groupProductRepository.findAll();
        for (GroupProductEntity groupProductEntity : itGroupProductEntity) {
            GroupProductDTO groupProductDTO = new GroupProductDTO();
            BeanUtils.copyProperties(groupProductEntity, groupProductDTO);
            listGroupProductDTO.add(groupProductDTO);
        }
        return listGroupProductDTO;
    }
    
    public GroupProductDTO addGroupProduct(GroupProductDTO groupProductDTO) {
        GroupProductEntity groupProductEntity = new GroupProductEntity();
        BeanUtils.copyProperties(groupProductDTO, groupProductEntity);
        GroupProductEntity groupProductAdded = groupProductRepository.save(groupProductEntity);
        BeanUtils.copyProperties(groupProductAdded, groupProductDTO);
        return groupProductDTO;
    }
    
    public GroupProductDTO updateGroupProduct(String id, GroupProductDTO groupProductDTO) {
        try {
            GroupProductEntity groupProductEntity = groupProductRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(groupProductDTO, groupProductEntity);
            groupProductEntity.setId(id);
            groupProductRepository.save(groupProductEntity);
            groupProductDTO.setId(id);
            return groupProductDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("GroupProduct with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("GroupProduct with id: %s not found.", id));
        }
    }
    
    public void deleteGroupProduct(String id) {
        try {
            GroupProductEntity groupProductEntity = groupProductRepository.findById(id).orElseThrow();
            groupProductRepository.delete(groupProductEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("GroupProduct with id: {}} not found.", id);
            throw new ItemNotFoundException(String.format("GroupProduct with id: %s not found.", id));
        }
    }
    
    public ItemOrderDTO getItemOrder(String id) {
        try {
            ItemOrderEntity itemOrderEntity = itemOrderRepository.findById(id).orElseThrow();
            ItemOrderDTO itemOrderDTO = new ItemOrderDTO();
            BeanUtils.copyProperties(itemOrderEntity, itemOrderDTO);
            return itemOrderDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("ItemOrder with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("ItemOrder with id: %s not found.", id));
        }
    }
    
    public List<ItemOrderDTO> getAllItemOrder() {
        List<ItemOrderDTO> listItemOrderDTO = new ArrayList<>();
        Iterable<ItemOrderEntity> itItemOrderEntity = itemOrderRepository.findAll();
        for (ItemOrderEntity itemOrderEntity : itItemOrderEntity) {
            ItemOrderDTO itemOrderDTO = new ItemOrderDTO();
            BeanUtils.copyProperties(itemOrderEntity, itemOrderDTO);
            listItemOrderDTO.add(itemOrderDTO);
        }
        return listItemOrderDTO;
    }
    
    public ItemOrderDTO addItemOrder(ItemOrderDTO itemOrderDTO) {
        if (!orderRepository.existsById(itemOrderDTO.getIdOrder())) {
            LOGGER.info("Order with id: {} not found.", itemOrderDTO.getIdOrder());
            throw new ItemNotFoundException(String.format("Order with id: %s not found.", itemOrderDTO.getIdOrder()));
        }
        if (!productRepository.existsById(itemOrderDTO.getIdProduct())) {
            LOGGER.info("Product with id: {} not found.", itemOrderDTO.getIdProduct());
            throw new ItemNotFoundException(String.format("Product with id: %s not found.", itemOrderDTO.getIdProduct()));
        }
        ItemOrderEntity itemOrderEntity = new ItemOrderEntity();
        BeanUtils.copyProperties(itemOrderDTO, itemOrderEntity);
        itemOrderEntity.setOrderEntity(orderRepository.findById(itemOrderDTO.getIdOrder()).orElseThrow());
        itemOrderEntity.setProductEntity(productRepository.findById(itemOrderDTO.getIdProduct()).orElseThrow());
        ItemOrderEntity itemOrderAdded = itemOrderRepository.save(itemOrderEntity);
        BeanUtils.copyProperties(itemOrderAdded, itemOrderDTO);
        return itemOrderDTO;
    }
    
    public ItemOrderDTO updateItemOrder(String id, ItemOrderDTO itemOrderDTO) {
        try {
            if (!orderRepository.existsById(itemOrderDTO.getIdOrder())) {
                LOGGER.info("Order with id: {} not found.", itemOrderDTO.getIdOrder());
                throw new ItemNotFoundException(String.format("Order with id: %s not found.", itemOrderDTO.getIdOrder()));
            }
            if (!productRepository.existsById(itemOrderDTO.getIdProduct())) {
                LOGGER.info("Product with id: {} not found.", itemOrderDTO.getIdProduct());
                throw new ItemNotFoundException(String.format("Product with id: %s not found.", itemOrderDTO.getIdProduct()));
            }
            ItemOrderEntity itemOrderEntity = itemOrderRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(itemOrderDTO, itemOrderEntity);
            itemOrderEntity.setId(id);
            itemOrderEntity.setOrderEntity(orderRepository.findById(itemOrderDTO.getIdOrder()).orElseThrow());
            itemOrderEntity.setProductEntity(productRepository.findById(itemOrderDTO.getIdProduct()).orElseThrow());
            itemOrderRepository.save(itemOrderEntity);
            itemOrderDTO.setId(id);
            return itemOrderDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("ItemOrder with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("ItemOrder with id: %s not found.", id));
        }
    }
    
    public void deleteItemOrder(String id) {
        try {
            ItemOrderEntity itemOrderEntity = itemOrderRepository.findById(id).orElseThrow();
            itemOrderRepository.delete(itemOrderEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("ItemOrder with id: {}} not found.", id);
            throw new ItemNotFoundException(String.format("ItemOrder with id: %s not found.", id));
        }
    }
    
    public OrderDTO getOrder(String id) {
        try {
            OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderEntity, orderDTO);
            return orderDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Order with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Order with id: %s not found.", id));
        }
    }
    
    public List<OrderDTO> getAllOrder() {
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        Iterable<OrderEntity> itOrderEntity = orderRepository.findAll();
        for (OrderEntity orderEntity : itOrderEntity) {
            OrderDTO orderDTO = new OrderDTO();
            BeanUtils.copyProperties(orderEntity, orderDTO);
            listOrderDTO.add(orderDTO);
        }
        return listOrderDTO;
    }
    
    public OrderDTO addOrder(OrderDTO orderDTO) {
        if (!customerRepository.existsById(orderDTO.getIdCustomer())) {
            LOGGER.info("Customer with id: {} not found.", orderDTO.getIdCustomer());
            throw new ItemNotFoundException(String.format("Customer with id: %s not found.", orderDTO.getIdCustomer()));
        }
        OrderEntity orderEntity = new OrderEntity();
        BeanUtils.copyProperties(orderDTO, orderEntity);
        orderEntity.setCustomerEntity(customerRepository.findById(orderDTO.getIdCustomer()).orElseThrow());
        OrderEntity orderAdded = orderRepository.save(orderEntity);
        BeanUtils.copyProperties(orderAdded, orderDTO);
        return orderDTO;
    }
    
    public OrderDTO updateOrder(String id, OrderDTO orderDTO) {
        try {
            if (!customerRepository.existsById(orderDTO.getIdCustomer())) {
                LOGGER.info("Customer with id: {} not found.", orderDTO.getIdCustomer());
                throw new ItemNotFoundException(String.format("Customer with id: %s not found.", orderDTO.getIdCustomer()));
            }
            OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(orderDTO, orderEntity);
            orderEntity.setId(id);
            orderEntity.setCustomerEntity(customerRepository.findById(orderDTO.getIdCustomer()).orElseThrow());
            orderRepository.save(orderEntity);
            orderDTO.setId(id);
            return orderDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Order with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Order with id: %s not found.", id));
        }
    }
    
    public void deleteOrder(String id) {
        try {
            OrderEntity orderEntity = orderRepository.findById(id).orElseThrow();
            orderRepository.delete(orderEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("Order with id: {}} not found.", id);
            throw new ItemNotFoundException(String.format("Order with id: %s not found.", id));
        }
    }
    
    public ProductDTO getProduct(String id) {
        try {
            ProductEntity productEntity = productRepository.findById(id).orElseThrow();
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            return productDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Product with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Product with id: %s not found.", id));
        }
    }
    
    public List<ProductDTO> getAllProduct() {
        List<ProductDTO> listProductDTO = new ArrayList<>();
        Iterable<ProductEntity> itProductEntity = productRepository.findAll();
        for (ProductEntity productEntity : itProductEntity) {
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(productEntity, productDTO);
            listProductDTO.add(productDTO);
        }
        return listProductDTO;
    }
    
    public ProductDTO addProduct(ProductDTO productDTO) {
        if (!groupProductRepository.existsById(productDTO.getIdGroupProduct())) {
            LOGGER.info("GroupProduct with id: {} not found.", productDTO.getIdGroupProduct());
            throw new ItemNotFoundException(String.format("GroupProduct with id: %s not found.", productDTO.getIdGroupProduct()));
        }
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(productDTO, productEntity);
        productEntity.setGroupProductEntity(groupProductRepository.findById(productDTO.getIdGroupProduct()).orElseThrow());
        ProductEntity productAdded = productRepository.save(productEntity);
        BeanUtils.copyProperties(productAdded, productDTO);
        return productDTO;
    }
    
    public ProductDTO updateProduct(String id, ProductDTO productDTO) {
        try {
            if (!groupProductRepository.existsById(productDTO.getIdGroupProduct())) {
                LOGGER.info("GroupProduct with id: {} not found.", productDTO.getIdGroupProduct());
                throw new ItemNotFoundException(String.format("GroupProduct with id: %s not found.", productDTO.getIdGroupProduct()));
            }
            ProductEntity productEntity = productRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(productDTO, productEntity);
            productEntity.setId(id);
            productEntity.setGroupProductEntity(groupProductRepository.findById(productDTO.getIdGroupProduct()).orElseThrow());
            productRepository.save(productEntity);
            productDTO.setId(id);
            return productDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Product with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Product with id: %s not found.", id));
        }
    }
    
    public void deleteProduct(String id) {
        try {
            ProductEntity productEntity = productRepository.findById(id).orElseThrow();
            productRepository.delete(productEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("Product with id: {}} not found.", id);
            throw new ItemNotFoundException(String.format("Product with id: %s not found.", id));
        }
    }
    
    public TaxDTO getTax(String id) {
        try {
            TaxEntity taxEntity = taxRepository.findById(id).orElseThrow();
            TaxDTO taxDTO = new TaxDTO();
            BeanUtils.copyProperties(taxEntity, taxDTO);
            return taxDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Tax with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Tax with id: %s not found.", id));
        }
    }
    
    public List<TaxDTO> getAllTax() {
        List<TaxDTO> listTaxDTO = new ArrayList<>();
        Iterable<TaxEntity> itTaxEntity = taxRepository.findAll();
        for (TaxEntity taxEntity : itTaxEntity) {
            TaxDTO taxDTO = new TaxDTO();
            BeanUtils.copyProperties(taxEntity, taxDTO);
            listTaxDTO.add(taxDTO);
        }
        return listTaxDTO;
    }
    
    public TaxDTO addTax(TaxDTO taxDTO) {
        TaxEntity taxEntity = new TaxEntity();
        BeanUtils.copyProperties(taxDTO, taxEntity);
        TaxEntity taxAdded = taxRepository.save(taxEntity);
        BeanUtils.copyProperties(taxAdded, taxDTO);
        return taxDTO;
    }
    
    public TaxDTO updateTax(String id, TaxDTO taxDTO) {
        try {
            TaxEntity taxEntity = taxRepository.findById(id).orElseThrow();
            BeanUtils.copyProperties(taxDTO, taxEntity);
            taxEntity.setId(id);
            taxRepository.save(taxEntity);
            taxDTO.setId(id);
            return taxDTO;
        } catch (NoSuchElementException ex) {
            LOGGER.info("Tax with id: {} not found.", id);
            throw new ItemNotFoundException(String.format("Tax with id: %s not found.", id));
        }
    }
    
    public void deleteTax(String id) {
        try {
            TaxEntity taxEntity = taxRepository.findById(id).orElseThrow();
            taxRepository.delete(taxEntity);
        } catch (NoSuchElementException ex) {
            LOGGER.info("Tax with id: {}} not found.", id);
            throw new ItemNotFoundException(String.format("Tax with id: %s not found.", id));
        }
    }
    
public Double calculateOrderTotal(String orderId) {
    try {
        OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow();
        Double total = 0.0;

        for (ItemOrderEntity itemOrder : orderEntity.getListItemOrderEntity()) {
            total += itemOrder.getQtD() * itemOrder.getProductEntity().getPrice();
        }

        return total;
    } catch (NoSuchElementException ex) {
        LOGGER.info("Order with id: {} not found.", orderId);
        throw new ItemNotFoundException(String.format("Order with id: %s not found.", orderId));
    }
}

}