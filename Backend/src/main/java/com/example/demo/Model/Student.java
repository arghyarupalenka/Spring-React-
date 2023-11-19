package com.example.demo.Model;




import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "StudentDB")
public class Student implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="firstName" ,nullable = false)
	private String FirstName;
	@Column(name="lastName")
	private String LastName;
	@Column(name="email",unique=true)
	private String email;
	@Column(name="branch",nullable = false)
	private String Branch;
	@Column(name="sessionyr",nullable = false)
	private String SessionYear;
	@Column(name="pass")
	private String Password;
	@Enumerated(EnumType.STRING)
	private Role role;
	
	
	//realtions with ndcform 
	@OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
	@JoinColumn(name = "studentId")
	@JsonBackReference
	private Ndcapply_Form ndcapply_Form;
	
	
	
	public Student() {
		
	}
	
	public Student(Long id, String firstName, String lastName, String email, String branch, String sessionYear,
			String password, Role role, Ndcapply_Form ndcapply_Form) {
		super();
		this.id = id;
		FirstName = firstName;
		LastName = lastName;
		email = email;
		Branch = branch;
		SessionYear = sessionYear;
		Password = password;
		this.role = role;
		this.ndcapply_Form = ndcapply_Form;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBranch() {
		return Branch;
	}
	public void setBranch(String branch) {
		Branch = branch;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getSessionYear() {
		return SessionYear;
	}
	public void setSessionYear(String sessionYear) {
		SessionYear = sessionYear;
	}
	
	
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	public Ndcapply_Form getNdcapply_Form() {
		return ndcapply_Form;
	}
	public void setNdcapply_Form(Ndcapply_Form ndcapply_Form) {
		this.ndcapply_Form = ndcapply_Form;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", FirstName=" + FirstName + ", LastName=" + LastName + ", email=" + email
				+ ", Branch=" + Branch + ", SessionYear=" + SessionYear + ", Password=" + Password + ","
				+ ", ndcapply_Form=" + ndcapply_Form + "]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	

}
