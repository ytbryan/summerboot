package com.tada.summerboot.security;

import com.tada.summerboot.component.SuccessHandler;
import com.tada.summerboot.service.CustomUserDetailsService;
import com.tada.summerboot.service.ProductServiceImpl;
import com.tada.summerboot.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< Updated upstream
=======
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
>>>>>>> Stashed changes
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private SuccessHandler successHandler;

	@Autowired
	UserServiceImpl user_service_implementation;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	public void configure(WebSecurity web) {
		//DO NOT EDIT
		//do not authenticate these APIs
		web.ignoring()
<<<<<<< Updated upstream
				.antMatchers("/js/**")
=======
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/every-users")
				.antMatchers("/buy-now")
				.antMatchers("/post/images/**")
				.antMatchers("/images/**")
				.antMatchers("/fragment-example")
				.antMatchers("/fragment1")
				.antMatchers("/pay/now")

>>>>>>> Stashed changes
				.antMatchers("/user-photos/**")
				.antMatchers("/products/**")
				.antMatchers("/posts/**")
				.antMatchers("/products/json/**") //is this necessary?
				.antMatchers("/users/**");

	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//DO NOT EDIT
		http.authorizeRequests()
				.antMatchers("/").permitAll()
<<<<<<< Updated upstream
				.antMatchers("/product").hasRole("ADMIN")
=======
				.antMatchers("/register").permitAll()
				.antMatchers("/fragment2").hasRole("ADMIN")
				.antMatchers("/register-admin").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/user/new").permitAll()
>>>>>>> Stashed changes
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.successHandler(new SuccessHandler())
				.and()
			.logout()
				.permitAll();
	}

<<<<<<< Updated upstream
=======

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}


	// This method will only be loaded once when you start the server
	// It assumes you should have users in your database
	// Read more https://www.javadevjournal.com/spring/spring-security-userdetailsservice/

>>>>>>> Stashed changes
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

<<<<<<< Updated upstream
		// Get all the users in database
		// Use the service instead of repo.
		List<com.tada.summerboot.model.User> users = user_service_implementation.getAllUsers();

		// Prepare an ArrayList for the InMemoryUserDetailsManager method at the end of this function
		ArrayList<UserDetails> list = new ArrayList<UserDetails>();

		// Iterate (go through one by one) and build a UserDetails for this app
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

		//Have at least one admin user for developer to login
=======

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//
//		// Get all the users in database
//		// Use the service instead of repo.
//		List<com.tada.summerboot.model.User> users = user_service_implementation.getAllUsers();
//
//		// Prepare an ArrayList for the InMemoryUserDetailsManager method at the end of this function
//		ArrayList<UserDetails> list = new ArrayList<UserDetails>();
//
//		for (int i = 0; i < users.size(); i++) {
//
//			// Create a UserDetails instance but set it based on the user in database
//			UserDetails user =
//					User.withDefaultPasswordEncoder()
//							.username(users.get(i).getUsername())
//							.password(users.get(i).getPassword())
//							.roles("ADMIN")
//							.build();
//			// Add that instance to the list
//			list.add(user);
//		}
//
//		list = adding_super_user(list);
//
//		return new InMemoryUserDetailsManager(list);
//	}


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
>>>>>>> Stashed changes
		UserDetails admin =
				User.withDefaultPasswordEncoder()
						.username("admin")
						.password("admin")
						.roles("ADMIN")
						.build();
		list.add(admin);

		System.out.println(list);
		return new InMemoryUserDetailsManager(list);
	}
}
