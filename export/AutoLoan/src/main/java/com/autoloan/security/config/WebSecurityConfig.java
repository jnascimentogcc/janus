package com.autoloan.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final CustomUserDetailService customUserDetailService;
    private final EndpointProperties endpointProperties;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        httpSecurity
                .cors(AbstractHttpConfigurer::disable)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagementCustomizer -> sessionManagementCustomizer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(AbstractHttpConfigurer::disable)
                .securityMatcher("/**")
                .authorizeHttpRequests(registry -> registry
                        .requestMatchers("/").denyAll()
                        .requestMatchers(String.format("/auth%s/login", endpointProperties.getApiV1())).permitAll()
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/customer/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_CUSTOMER.name(),
                                SecurityRoles.GET_CUSTOMER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/customer", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_CUSTOMER.name(),
                                SecurityRoles.ALL_CUSTOMER.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/customer", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_CUSTOMER.name(),
                                SecurityRoles.ADD_CUSTOMER.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/customer/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_CUSTOMER.name(),
                                SecurityRoles.UPDATE_CUSTOMER.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/customer/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_CUSTOMER.name(),
                                SecurityRoles.DELETE_CUSTOMER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/group_product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_GROUP_PRODUCT.name(),
                                SecurityRoles.GET_GROUP_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/group_product", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_GROUP_PRODUCT.name(),
                                SecurityRoles.ALL_GROUP_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/group_product", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_GROUP_PRODUCT.name(),
                                SecurityRoles.ADD_GROUP_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/group_product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_GROUP_PRODUCT.name(),
                                SecurityRoles.UPDATE_GROUP_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/group_product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_GROUP_PRODUCT.name(),
                                SecurityRoles.DELETE_GROUP_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/item_order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ITEM_ORDER.name(),
                                SecurityRoles.GET_ITEM_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/item_order", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ITEM_ORDER.name(),
                                SecurityRoles.ALL_ITEM_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/item_order", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ITEM_ORDER.name(),
                                SecurityRoles.ADD_ITEM_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/item_order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ITEM_ORDER.name(),
                                SecurityRoles.UPDATE_ITEM_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/item_order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ITEM_ORDER.name(),
                                SecurityRoles.DELETE_ITEM_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ORDER.name(),
                                SecurityRoles.GET_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/order", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ORDER.name(),
                                SecurityRoles.ALL_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/order", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ORDER.name(),
                                SecurityRoles.ADD_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ORDER.name(),
                                SecurityRoles.UPDATE_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/order/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_ORDER.name(),
                                SecurityRoles.DELETE_ORDER.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_PRODUCT.name(),
                                SecurityRoles.GET_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/product", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_PRODUCT.name(),
                                SecurityRoles.ALL_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/product", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_PRODUCT.name(),
                                SecurityRoles.ADD_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_PRODUCT.name(),
                                SecurityRoles.UPDATE_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/product/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_PRODUCT.name(),
                                SecurityRoles.DELETE_PRODUCT.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/tax/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_TAX.name(),
                                SecurityRoles.GET_TAX.name()
                        )
                        .requestMatchers(HttpMethod.GET, String.format("/supply%s/tax", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_TAX.name(),
                                SecurityRoles.ALL_TAX.name()
                        )
                        .requestMatchers(HttpMethod.POST, String.format("/supply%s/tax", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_TAX.name(),
                                SecurityRoles.ADD_TAX.name()
                        )
                        .requestMatchers(HttpMethod.PUT, String.format("/supply%s/tax/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_TAX.name(),
                                SecurityRoles.UPDATE_TAX.name()
                        )
                        .requestMatchers(HttpMethod.DELETE, String.format("/supply%s/tax/**", endpointProperties.getApiV1())).hasAnyRole(
                                SecurityRoles.ADMIN.name(),
                                SecurityRoles.MANAGER_SUPPLY.name(),
                                SecurityRoles.MANAGER_TAX.name(),
                                SecurityRoles.DELETE_TAX.name()
                        )
                        .anyRequest().authenticated()
                );
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }
}