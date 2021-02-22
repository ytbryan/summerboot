package com.tada.summerboot.security;

import com.tada.summerboot.component.SuccessHandler;
import com.tada.summerboot.service.ProductServiceImpl;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SuccessHandler successHandler;

	@Autowired
	UserServiceImpl user_service_implementation;

	@Override
	public void configure(WebSecurity web) {
		//DO NOT EDIT
		//do not authenticate these APIs
		web.ignoring()
//				.antMatchers("/contact.html")

				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/images/**")
				.antMatchers("/every-users")

				.antMatchers("/user-photos/**")
				.antMatchers("/products/**")
				.antMatchers("/posts/**")
				.antMatchers("/products/json/**") //is this necessary?
				.antMatchers("/users/**");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//DO NOT EDIT
		http
			.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/register").permitAll()
				.antMatchers(HttpMethod.POST, "/user/new").permitAll()
				.antMatchers("/product").hasRole("ADMIN")
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(successHandler)
				.and()
			.logout()
				.logoutSuccessUrl("/") //Set the url after you logout
				.permitAll();
	}



	// This method will only be loaded once when you start the server
	// It assumes you should have users in your database
	// Read more https://www.javadevjournal.com/spring/spring-security-userdetailsservice/

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		// Get all the users in database
		// Use the service instead of repo.
		List<com.tada.summerboot.model.User> users = user_service_implementation.getAllUsers();

		// Prepare an ArrayList for the InMemoryUserDetailsManager method at the end of this function
		ArrayList<UserDetails> list = new ArrayList<UserDetails>();

		for (int i = 0; i < users.size(); i++) {

			// Create a UserDetails instance but set it based on the user in database
			UserDetails user =
					User.withDefaultPasswordEncoder()
							.username(users.get(i).getUsername())
							.password(users.get(i).getPassword())
							.roles("ADMIN")
							.build();
			// Add that instance to the list
			list.add(user);
		}

		list = adding_super_user(list);

		return new InMemoryUserDetailsManager(list);
	}


	//        UNCOMMENT SNIPPET #1
	// Remember to comment out the userDetailsService Above.

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		// Get all the users in database
//		// Use the service instead of repo.
//		List<com.tada.summerboot.model.User> users = user_service_implementation.getAllUsers();
//
//		// Prepare an ArrayList for the InMemoryUserDetailsManager method at the end of this function
//		ArrayList<UserDetails> list = new ArrayList<UserDetails>();
//
//		// Iterate (go through one by one) and build a UserDetails for this app
//		for(int i = 0; i < users.size(); i++) {
//			if(users.get(i).getUserType() != null){ // check if UserType is null
//				list = set_user_type(list, users.get(i));
//
//				// you must make sure there is only two possibilities
//			} else {
//				// Create a UserDetails instance but set it based on the user in database
//				UserDetails user = User.withDefaultPasswordEncoder()
//						.username(users.get(i).getUsername())
//						.password(users.get(i).getPassword())
//						.roles("ADMIN")
//						.build();
//
//				// Add that instance to the list
//				list.add(user);
//			}
//		}
//
//		list = adding_super_user(list);
//		//Have at least one admin user for developer to login
//		return new InMemoryUserDetailsManager(list);
//	}
////
//	private ArrayList<UserDetails>  set_user_type(ArrayList<UserDetails> list, com.tada.summerboot.model.User this_user) {
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username(this_user.getUsername())
//				.password(this_user.getPassword())
//				.roles(this_user.getUserType())
//				.build(); // This assumes that getUserType is either ADMIN or USER
//
//		list.add(user);
//		return list;
//	}

	private ArrayList<UserDetails> adding_super_user(ArrayList<UserDetails> list) {
		UserDetails admin =
				User.withDefaultPasswordEncoder()
						.username("admin")
						.password("admin")
						.roles("ADMIN")
						.build();

		list.add(admin);
		return list;
	}





}
